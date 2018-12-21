package com.wajahat.reservationsdashboard;

import com.wajahat.reservationsdashboard.config.ReservationsDashboardConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(ReservationsDashboardConfig.class)
public class ReservationsDashboardApplication {
	public static void main(String[] args) {
		SpringApplication.run(ReservationsDashboardApplication.class, args);
	}
}

