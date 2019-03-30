package com.wenxueliu.utils;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * Created by liuwenxue on 31/03/2019.
 *
 * 根据对象的 getter 方法，获取参数与值的 map
 */
public class BeanToMapUtils {
    private final Map<Class<?>, ObjectParamMetadata> classToMetadata =
            new HashMap<Class<?>, ObjectParamMetadata>();

    public Map<String, Object> encode(Object object) {
        try {
            ObjectParamMetadata metadata = getMetadata(object.getClass());
            Map<String, Object> propertyNameToValue = new HashMap<String, Object>();
            for (PropertyDescriptor pd : metadata.objectProperties) {
                Object value = pd.getReadMethod().invoke(object);
                if (value != null && value != object) {
                    propertyNameToValue.put(pd.getName(), value);
                }
            }
            return propertyNameToValue;
        } catch (IllegalAccessException | IntrospectionException | InvocationTargetException e) {
            //TODO LOG
            throw new IllegalStateException("Failure encoding object into query map", e);
        }
    }

    private ObjectParamMetadata getMetadata(Class<?> objectType) throws IntrospectionException {
        ObjectParamMetadata metadata = classToMetadata.get(objectType);
        if (metadata == null) {
            metadata = ObjectParamMetadata.parseObjectType(objectType);
            classToMetadata.put(objectType, metadata);
        }
        return metadata;
    }

    private static class ObjectParamMetadata {

        private final List<PropertyDescriptor> objectProperties;

        private ObjectParamMetadata(List<PropertyDescriptor> objectProperties) {
            this.objectProperties = Collections.unmodifiableList(objectProperties);
        }

        private static ObjectParamMetadata parseObjectType(Class<?> type)
                throws IntrospectionException {
            List<PropertyDescriptor> properties = new ArrayList<PropertyDescriptor>();

            for (PropertyDescriptor pd : Introspector.getBeanInfo(type).getPropertyDescriptors()) {
                boolean isGetterMethod = pd.getReadMethod() != null && !"class".equals(pd.getName());
                if (isGetterMethod) {
                    properties.add(pd);
                }
            }

            return new ObjectParamMetadata(properties);
        }
    }


    public static void main(String[] args) {
        class FieldTest {
            int a;
            String b;

            public FieldTest(int a, String b) {
                this.a = a;
                this.b = b;
            }

            //public 必须指定
            public int getA() {
                return a;
            }

            //public 必须指定
            public String getB() {
                return b;
            }
        }
        FieldTest test = new FieldTest(1, "b");
        BeanToMapUtils fm = new BeanToMapUtils();
        for (Map.Entry<String, Object> entry : fm.encode(test).entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
