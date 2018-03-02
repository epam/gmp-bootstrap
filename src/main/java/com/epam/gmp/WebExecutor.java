package com.epam.gmp;

/*import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.annotations.ClassInheritanceHandler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.ConcurrentHashSet;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.webapp.WebXmlConfiguration;*/


public class WebExecutor {
/*
    public static void main(String... args) throws Exception {
        //Properties properties = new Properties();
        //InputStream stream = WebExecutor.class.getResourceAsStream("WEB-INF/web-application.properties");
        //properties.load(stream);
        //stream.close();
        //PropertyConfigurator.configure(properties);

        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setResourceBase("/");
        webAppContext.setContextPath("webapp");

        webAppContext.setConfigurations(new Configuration[]{
                new WebXmlConfiguration(),
                new AnnotationConfiguration() {
                    @Override
                    public void preConfigure(WebAppContext context) {
                        ClassInheritanceMap map = new ClassInheritanceMap();
                        map.put(WebApplicationInitializer.class.getName(), new ConcurrentHashSet<String>() {{

                            // add(SecurityWebInitializer.class.getName());
                            add(WebApplicationInitializer.class.getName());
                        }});
                        context.setAttribute(CLASS_INHERITANCE_MAP, map);
                        _classInheritanceHandler = new ClassInheritanceHandler(map);
                    }
                }
        });

        Server server = new Server(8080);
        server.setHandler(webAppContext);
        server.start();
        server.join();
    }*/
}
