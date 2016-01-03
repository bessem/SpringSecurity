/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aka.pirana.springsecurity.web.config;

import java.util.Properties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 *
 * @author aka
 */
@Configuration
@ComponentScan(basePackages =  "aka.pirana.springsecurity.web")
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter{

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        System.out.println("aka.pirana.springsecurity.web.config.WebMvcConfig.addViewControllers()");
        super.addViewControllers(registry); 
        registry.addViewController("login/form").setViewName("login");
        registry.addViewController("welcome").setViewName("welcome");
        registry.addViewController("admin").setViewName("admin");
    }
    
    @Bean
    public ViewResolver viewResolver(){
        System.out.println("aka.pirana.springsecurity.web.config.WebMvcConfig.viewResolver()");
        InternalResourceViewResolver url = new InternalResourceViewResolver();
        url.setPrefix("/WEB-INF/jsp/");
        url.setSuffix(".jsp");
        return url;
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println("aka.pirana.springsecurity.web.config.WebMvcConfig.addResourceHandlers()");
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        System.out.println("aka.pirana.springsecurity.web.config.WebMvcConfig.configureDefaultServletHandling()");
        configurer.enable();
    }
    
    @Bean(name = "messageSource")
    public MessageSource configureMessageSource(){
        System.out.println("aka.pirana.springsecurity.web.config.WebMvcConfig.configureMessageSource()");
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setCacheSeconds(5);
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
    
    @Bean
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver(){
        System.out.println("aka.pirana.springsecurity.web.config.WebMvcConfig.simpleMappingExceptionResolver()");
            SimpleMappingExceptionResolver b = new SimpleMappingExceptionResolver();
            Properties mappings = new Properties();
            mappings.put("org.springframework.dao.DataAccessException", "error");
            b.setExceptionMappings(mappings);
            return b;
    }
}
