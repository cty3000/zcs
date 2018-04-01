//
// This file generated by rdl 1.4.15. Do not modify!
//
package com.yahoo.athenz.zcs;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

public class ZCSServer {
    ZCSHandler handler;

    public ZCSServer(ZCSHandler handler) {
        this.handler = handler;
    }

    public void run(int port) {
        try {
            Server server = new Server(port);
            ServletContextHandler handler = new ServletContextHandler();
            handler.setContextPath("");
            ResourceConfig config = new ResourceConfig(ZCSResources.class).register(new Binder());
            handler.addServlet(new ServletHolder(new ServletContainer(config)), "/*");
            server.setHandler(handler);
            server.start();
            server.join();
        } catch (Exception e) {
            System.err.println("*** " + e);
        }
    }

    class Binder extends AbstractBinder {
        @Override
        protected void configure() {
            bind(handler).to(ZCSHandler.class);
        }
    }
}
