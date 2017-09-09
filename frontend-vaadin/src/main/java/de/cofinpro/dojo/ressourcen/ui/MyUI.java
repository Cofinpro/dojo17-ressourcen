package de.cofinpro.dojo.ressourcen.ui;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;
import de.cofinpro.dojo.ressourcen.service.ResourceServiceClient;
import sun.misc.Version;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    private ResourceServiceClient resourceServiceClient = new ResourceServiceClient();

    private TabSheet rootLayout;

    private Overview overview;

    private CRUDMask singleCrud;

    private GlobalViewModel model;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        model = new GlobalViewModel();
        initComponents();
        setContent(rootLayout);
    }

    private void initComponents() {
        rootLayout = new TabSheet();
        singleCrud = new CRUDMask(resourceServiceClient,model);
        overview = new Overview(resourceServiceClient, model);
        rootLayout.addTab(singleCrud);
        rootLayout.addTab(overview);
        setContent(rootLayout);
    }

    private String getRequestsPresentation() {
        return resourceServiceClient.getAllResourceRequests().toString();
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }

}