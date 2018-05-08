package org.missaoui.test.config;

import javax.servlet.Filter;

import org.missaoui.test.security.SecurityConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

   @Override
   protected Class<?>[] getRootConfigClasses() {
	   return new Class[] { AppConfig.class, SecurityConfiguration.class };
   }

   @Override
   protected Class<?>[] getServletConfigClasses() {
      return new Class[] { WebConfig.class };
   }

   @Override
   protected String[] getServletMappings() {
      return new String[] { "/" };
   }
   
   @Override
   protected Filter[] getServletFilters() {
   	Filter [] singleton = { new CORSFilter()};
   	return singleton;
   }
}