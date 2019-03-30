package com.wenxueliu.utils;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by liuwenxue on 31/03/2019.
 *
 * 将类的属性及属性的值转换为 map
 *
 * from feign source code
 */
public class FieldToMapUtils {

    private final Map<Class<?>, ObjectParamMetadata> classToMetadata =
            new HashMap<Class<?>, ObjectParamMetadata>();

    public Map<String, Object> encode(Object object) {
        try {
            ObjectParamMetadata metadata = getMetadata(object.getClass());
            Map<String, Object> fieldNameToValue = new HashMap<String, Object>();
            for (Field field : metadata.objectFields) {
                Object value = field.get(object);
                if (value != null && value != object) {
                    fieldNameToValue.put(field.getName(), value);
                }
            }
            return fieldNameToValue;
        } catch (IllegalAccessException e) {
            //TODO LOG
            throw new IllegalStateException(e);
        }
    }

    private ObjectParamMetadata getMetadata(Class<?> objectType) {
        ObjectParamMetadata metadata = classToMetadata.get(objectType);
        if (metadata == null) {
            metadata = ObjectParamMetadata.parseObjectType(objectType);
            classToMetadata.put(objectType, metadata);
        }
        return metadata;
    }

    private static class ObjectParamMetadata {

        private final List<Field> objectFields;

        private ObjectParamMetadata(List<Field> objectFields) {
            this.objectFields = Collections.unmodifiableList(objectFields);
        }

        private static ObjectParamMetadata parseObjectType(Class<?> type) {
            return new ObjectParamMetadata(
                    Arrays.stream(type.getDeclaredFields())
                            .filter(field -> !field.isSynthetic())
                            .peek(field -> field.setAccessible(true))
                            .collect(Collectors.toList()));
        }
    }

    public static class FieldTest {
        int a;
        String b;

        public FieldTest(int a, String b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) {
        FieldTest test = new FieldTest(1, "b");
        FieldToMapUtils fm = new FieldToMapUtils();
        for (Map.Entry<String, Object> entry : fm.encode(test).entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
