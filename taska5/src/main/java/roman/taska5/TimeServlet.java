package roman.taska5;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

public class TimeServlet extends HttpServlet {
    private static String defaultHtmlFile = "e:\\time.html";
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        List<String> htmlLines = Files.readAllLines( Paths.get( defaultHtmlFile ) );
        for(String line:htmlLines) {
            out.println( line.replaceAll( "%MESSAGE%", getTime() ) );
        }			
    }

    public String getTime() {
        return new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(System.currentTimeMillis());
    }
 
}
