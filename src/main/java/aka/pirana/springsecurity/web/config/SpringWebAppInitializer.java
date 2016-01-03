/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aka.pirana.springsecurity.web.config;

import aka.pirana.springsecurity.config.AppConfig;
import javax.servlet.Filter;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *
 * @author aka
 */
public class SpringWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        System.out.println("aka.pirana.springsecurity.web.config.SpringWebAppInitializer.getRootConfigClasses()");
        return new Class<?>[]{AppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        System.out.println("aka.pirana.springsecurity.web.config.SpringWebAppInitializer.getServletConfigClasses()");
        return new Class<?>[]{WebMvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        System.out.println("aka.pirana.springsecurity.web.config.SpringWebAppInitializer.getServletMappings()");
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        System.out.println("aka.pirana.springsecurity.web.config.SpringWebAppInitializer.getServletFilters()");
       return new Filter[]{ 
    		   new DelegatingFilterProxy("springSecurityFilterChain"),
    		   new OpenEntityManagerInViewFilter()};
    }

}
