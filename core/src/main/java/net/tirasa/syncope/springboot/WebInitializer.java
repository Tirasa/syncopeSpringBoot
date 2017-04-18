package net.tirasa.syncope.springboot;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.apache.syncope.core.rest.cxf.WADLServlet;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * This class is the replacement of the web.xml.
 */
@Configuration
public class WebInitializer extends WebMvcConfigurerAdapter implements ServletContextInitializer {

    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/index.html");

        registry.addViewController("/swagger").setViewName("redirect:/rest/api-docs?url=/syncope/rest/swagger.json");
        registry.addViewController("/swagger/").setViewName("redirect:/rest/api-docs?url=/syncope/rest/swagger.json");
    }

    @Override
    public void onStartup(final ServletContext sc) throws ServletException {
        ServletRegistration.Dynamic wadlServlet = sc.addServlet("WADLServlet", WADLServlet.class);
        wadlServlet.addMapping("/index.html", "/schema_1_syncope2.html", "/syncope.wadl");
    }

}
