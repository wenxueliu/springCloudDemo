package com.wenxueliu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	/*
	private final CityDao cityDao;

	private final HotelMapper hotelMapper;

	public DemoApplication(CityDao cityDao, HotelMapper hotelMapper) {
		this.cityDao = cityDao;
		this.hotelMapper = hotelMapper;
	}

	@Override
	@SuppressWarnings("squid:S106")
	public void run(String... args) {
		System.out.println(this.cityDao.selectCityById(1));
		System.out.println(this.hotelMapper.selectByCityId(1));
	}
	*/
}
