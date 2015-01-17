package roman.taska5;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;

public class Main {
    public static void main(String[] args) throws Exception{
        Server server = new Server();
        ServerConnector connector = new ServerConnector( server );
        connector.setHost("127.0.0.1");
        connector.setPort(65001);
        connector.setName("main");
        server.addConnector( connector );  

        ServletHandler myservlet = new ServletHandler();
        myservlet.addServletWithMapping(TimeServlet.class, "/time");

        server.setHandler(myservlet);

        server.start();
        server.join();
    }
}
