package initializer;
 import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import config.MvcConfig;
    
 public class MvcWebApplicationInitializer 
 extends AbstractAnnotationConfigDispatcherServletInitializer {

        @Override
        protected Class<?>[] getRootConfigClasses() {
            return new Class[] {};
        }

        @Override
        protected Class<?>[] getServletConfigClasses() {
            return new Class[] {MvcConfig.class};
        }

        @Override
        protected String[] getServletMappings() {
            return new String[] {"/"};
        }

    }