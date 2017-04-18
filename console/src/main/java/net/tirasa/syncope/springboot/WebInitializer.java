package net.tirasa.syncope.springboot;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletException;
import org.apache.syncope.client.console.SyncopeConsoleApplication;
import org.apache.syncope.client.console.init.ConsoleInitializer;
import org.apache.wicket.protocol.http.WicketFilter;
import org.apache.wicket.protocol.ws.javax.JavaxWebSocketFilter;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebInitializer extends ConsoleInitializer implements ServletContextInitializer {

    @Override
    public void onStartup(final ServletContext servletContext) throws ServletException {
        FilterRegistration filter = servletContext.addFilter("SyncopeConsole", JavaxWebSocketFilter.class);
        filter.setInitParameter(WicketFilter.FILTER_MAPPING_PARAM, "/*");
        filter.setInitParameter("applicationClassName", SyncopeConsoleApplication.class.getName());
        filter.addMappingForUrlPatterns(null, false, "/*");

        super.contextInitialized(new ServletContextEvent(servletContext));
    }

}
