package net.tirasa.syncope.springboot;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DB {

    @Autowired
    private ServletContext context;

    @RequestMapping("/db")
    public void db(final HttpServletResponse response) throws IOException {
        Server h2Datastore = (Server) context.getAttribute("H2_DATASTORE");
        if (h2Datastore == null || !h2Datastore.isRunning(true)) {
            try {
                h2Datastore = Server.createWebServer("-webPort", "8082");
                h2Datastore.start();

                context.setAttribute("H2_DATASTORE", h2Datastore);
            } catch (SQLException e) {
                context.log("Could not start H2 web console (datastore)", e);
            }
        }
        response.sendRedirect("http://localhost:8082");
    }
}
