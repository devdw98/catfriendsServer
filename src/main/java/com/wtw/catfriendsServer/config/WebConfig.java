//package com.wtw.catfriendsServer.config;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import java.util.List;
//
//@Configuration
//public class WebConfig extends WebMvcConfigurationSupport{
//    final Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
//    final MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//    final ObjectMapper objectMapper = new ObjectMapper();
//
//    @Override
//    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        super.configureMessageConverters(converters);
//        super.addDefaultHttpMessageConverters(converters);
//    }
//}
