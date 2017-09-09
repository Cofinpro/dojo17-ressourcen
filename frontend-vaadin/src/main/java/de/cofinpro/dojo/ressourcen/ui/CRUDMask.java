package de.cofinpro.dojo.ressourcen.ui;

import com.vaadin.data.Binder;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import de.cofinpro.dojo.ressourcen.model.ResourceRequest;
import de.cofinpro.dojo.ressourcen.service.ResourceServiceClient;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

class CRUDMask extends VerticalLayout implements PropertyChangeListener {

    private final ResourceServiceClient resourceServiceClient;
    private GlobalViewModel model;

    private Binder<ResourceRequest> binder;
    private TextField tfTitel;

    CRUDMask(ResourceServiceClient resourceServiceClient, GlobalViewModel model) {
        this.resourceServiceClient = resourceServiceClient;
        this.model = model;
        setCaption("Neuen Request erstellen");
        createWidgets();
        showWidgets();
        model.addPropertyChangeListener(this);
    }

    private void createWidgets() {
        tfTitel = new TextField("Titel");

        binder = new Binder<>();

        binder.bind(tfTitel, ResourceRequest::getTitle, ResourceRequest::setTitle);
    }


    private void showWidgets() {
        addComponent(tfTitel);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(GlobalViewModel.SINGLE_RR_CHOSEN)
        && model.getCurrentlySelectedResourceRequest() != null) {
            binder.readBean(model.getCurrentlySelectedResourceRequest());
        }
    }
}
