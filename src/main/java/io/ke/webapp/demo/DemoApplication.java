/*
 * @Author: ke 
 * @Date: 2022-10-06 10:40:03 
 * @Last Modified by: ke
 * @Last Modified time: 2022-10-06 12:17:49
 */
package io.ke.webapp.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//import springfox.documentation.swagger2.annotations.EnableSwagger2;



@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
