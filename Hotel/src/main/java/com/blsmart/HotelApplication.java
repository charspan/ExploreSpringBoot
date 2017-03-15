package com.blsmart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HotelApplication {

	/**
	 * 启动项目方式
	 * 1. 用 idea 右键 Run
	 * 2. 进入项目的目录(这里:cd ~/IdeaProjects/Hotel),然后使用 mvn spring-boot: run
	 * 3. 进入项目的目录(这里:cd ~/IdeaProjects/Hotel),然后使用 mvn install,再进入
	 *    target 目录,使用 java -jar hotel-0.0.1-SNAPSHOT.jar
	 *    这是可以加参数的 java -jar hotel-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev
	 * @param args
     */
	public static void main(String[] args) {
		SpringApplication.run(HotelApplication.class, args);
	}
}
