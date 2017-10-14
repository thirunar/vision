package com.smarthome.light;

import com.amazon.speech.Sdk;
import com.amazon.speech.speechlet.servlet.SpeechletServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

import java.io.IOException;

@SpringBootApplication(scanBasePackages = {"com.alexaframework.springalexa", "com.smarthome.light"})
@ImportResource
public class LightApplication {

    @Autowired
    private VisionSpeechlet speechlet;

	public static void main(String[] args) {
	    setAmazonProperties();
		SpringApplication.run(LightApplication.class, args);
	}

    @Bean
    public ServletRegistrationBean alexaServlet() throws IOException {
        SpeechletServlet speechletServlet;
        speechletServlet = new SpeechletServlet();
        speechletServlet.setSpeechlet(speechlet);

        ServletRegistrationBean servlet = new ServletRegistrationBean(speechletServlet, "/alexa");
        servlet.setName("alexa");
        return servlet;
    }

    private static void setAmazonProperties() {
        System.setProperty(Sdk.DISABLE_REQUEST_SIGNATURE_CHECK_SYSTEM_PROPERTY, "true");
        System.setProperty(Sdk.SUPPORTED_APPLICATION_IDS_SYSTEM_PROPERTY, "");
        System.setProperty(Sdk.TIMESTAMP_TOLERANCE_SYSTEM_PROPERTY, "");
    }

}
