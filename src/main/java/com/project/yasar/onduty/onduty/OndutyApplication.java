package com.project.yasar.onduty.onduty;

import com.project.yasar.onduty.onduty.service.DummyDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class OndutyApplication {
	@Autowired
	DummyDataService dummyDataService;
	public static void main(String[] args) {
		SpringApplication.run(OndutyApplication.class, args);

	}

	@PostConstruct
	public void createDummyData(){
		dummyDataService.createDummyData();
	}
}
