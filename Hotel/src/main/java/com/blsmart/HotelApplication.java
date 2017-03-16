package com.blsmart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * idea tips for mac
 *
 * 删除一行: command + delete
 * 剪切一行: command + x
 * 拷贝一行: command + d
 * 快速打印: sout + enter
 * 快速修复: alt + enter
 * 快速生成 get/set:  command + n 或者 control + enter
 * 快速查找: shift + shift
 * 测试 右键 goto
 */
@SpringBootApplication
public class HotelApplication {

	/**
	 * 启动项目方式
	 * 1. 用 idea 右键 Run
	 * 2. 进入项目的目录(这里:cd ~/IdeaProjects/Hotel),然后使用 mvn spring-boot: run
	 * 3. 进入项目的目录(这里:cd ~/IdeaProjects/Hotel),然后使用 mvn install,再进入
	 *    target 目录,使用 java -jar hotel-0.0.1-SNAPSHOT.jar
	 *    这是可以加参数的 java -jar hotel-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev
	 * mvn clean package (会自动执行测试)
	 * mvn clean package -Dmaven.test.skip=true (跳过测试)
	 * @param args
     */
	public static void main(String[] args) {
		SpringApplication.run(HotelApplication.class, args);
	}
}
