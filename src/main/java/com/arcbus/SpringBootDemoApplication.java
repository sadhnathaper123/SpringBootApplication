package com.arcbus;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootDemoApplication {

	private static final Logger LOGGER = LogManager.getLogger(SpringBootDemoApplication.class);
	
	@Bean
	protected ServletContextListener listener() {
		return new ServletContextListener() {

			@Override
			public void contextInitialized(ServletContextEvent sce) {
				LOGGER.info("ServletContext initialized");
			}

			@Override
			public void contextDestroyed(ServletContextEvent sce) {
				LOGGER.info("ServletContext destroyed");
			}

		};
}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
		LOGGER.info("Info level log message *********");
        LOGGER.debug("Debug level log message *********");
        LOGGER.error("Error level log message *********");
	}

}
