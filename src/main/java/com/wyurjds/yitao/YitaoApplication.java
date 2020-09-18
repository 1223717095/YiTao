package com.wyurjds.yitao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
//@EntityScan("com.wyurjds.yitao.Entity")
public class YitaoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(YitaoApplication.class, args);
	}

//打包要加上这个

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(YitaoApplication.class);
	}
}
