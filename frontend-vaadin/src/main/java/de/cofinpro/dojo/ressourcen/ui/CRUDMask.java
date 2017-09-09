package de.cofinpro.dojo.ressourcen.ui;

import com.vaadin.data.Binder;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.ui.*;
import de.cofinpro.dojo.ressourcen.model.ResourceRequest;
import de.cofinpro.dojo.ressourcen.service.ResourceServiceClient;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

class CRUDMask extends VerticalLayout implements PropertyChangeListener {

    private final ResourceServiceClient resourceServiceClient;
    private GlobalViewModel model;

    private Binder<ResourceRequest> binder;
    private TextField tfTitel;

    private Button btCreateNew;

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
        btCreateNew = new Button("Erstelle neuen Request");
        btCreateNew.addClickListener(clickEvent -> {onCreateNew();});

        binder = new Binder<>();

        binder.bind(tfTitel, ResourceRequest::getTitle, ResourceRequest::setTitle);
    }

    private void onCreateNew() {
        ResourceRequest rr = new ResourceRequest();
        boolean saved = binder.writeBeanIfValid(rr);
        if (saved) {
            ResourceRequest newRequest = resourceServiceClient.createNewRequest(rr);
            Notification.show("Gesichert",
                    "Der Request mit dem Titel " + rr.getTitle() + " wurde erfolgreich gespeichert :" + newRequest,
                    Notification.Type.HUMANIZED_MESSAGE);
            model.setCurrentlySelectedResourceRequest(null); //prepare for new one
        } else {
            Notification.show("Fehler beim Speichern",
                    "Der Request mit dem Titel " + rr.getTitle() + " konnte NICHT gesichert werden. Bitte prüfen Sie die Feldeingaben.",
                    Notification.Type.WARNING_MESSAGE);
        }
    }


    private void showWidgets() {
        addComponent(btCreateNew);
        addComponent(tfTitel);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(GlobalViewModel.SINGLE_RR_CHOSEN)) {
            binder.readBean(model.getCurrentlySelectedResourceRequest());
        }
    }
}
