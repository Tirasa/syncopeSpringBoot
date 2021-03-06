package net.tirasa.syncope.springboot;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletException;
import org.apache.syncope.client.enduser.SyncopeEnduserApplication;
import org.apache.syncope.client.enduser.init.EnduserInitializer;
import org.apache.wicket.protocol.http.WicketFilter;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebInitializer extends EnduserInitializer implements ServletContextInitializer {

    @Override
    public void onStartup(final ServletContext servletContext) throws ServletException {
        FilterRegistration filter = servletContext.addFilter("SyncopeEnduser", WicketFilter.class);
        filter.setInitParameter(WicketFilter.FILTER_MAPPING_PARAM, "/*");
        filter.setInitParameter("applicationClassName", SyncopeEnduserApplication.class.getName());
        filter.addMappingForUrlPatterns(null, false, "/*");

        super.contextInitialized(new ServletContextEvent(servletContext));
    }

}
