package com.jpa.eager.test.jpatest;

import com.jpa.eager.test.jpatest.data.entity.AccessoryModel;
import com.jpa.eager.test.jpatest.data.entity.DeviceModel;
import com.jpa.eager.test.jpatest.data.entity.OrderDetailsModel;
import com.jpa.eager.test.jpatest.data.repo.OrderModelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class JpaTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaTestApplication.class, args);
	}
}
