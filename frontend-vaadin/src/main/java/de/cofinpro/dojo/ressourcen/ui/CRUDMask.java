package de.cofinpro.dojo.ressourcen.ui;

import com.vaadin.data.Binder;
import com.vaadin.data.ValueProvider;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.server.Setter;
import com.vaadin.ui.*;
import de.cofinpro.dojo.ressourcen.model.RequestStatus;
import de.cofinpro.dojo.ressourcen.model.ResourceRequest;
import de.cofinpro.dojo.ressourcen.service.ResourceServiceClient;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;

class CRUDMask extends VerticalLayout implements PropertyChangeListener {

    private final ResourceServiceClient resourceServiceClient;
    private GlobalViewModel model;

    private Binder<ResourceRequest> binder;
    private TextField tfTitel;
    private TextField tfCustomerName;
    private TextField tfProjectName;
    private TextField tfRoleName;
    private TextField tfLocation;
    private TextField tfProjectDescription;
    private TextField tfTaskDescription;
    private DateField dtPitchDeadline;
    private DateField dtDecisionDate;
    private TextField tfPropability;
    private DateField dfRunTimeStart;
    private DateField dfRunTimeEnd;

    private ComboBox cbStatus;

    private Button btCreateNew;
    private Button btUpdateExisting;

    private DecimalFormat df = new DecimalFormat("#.00");;

    CRUDMask(ResourceServiceClient resourceServiceClient, GlobalViewModel model) {
        this.resourceServiceClient = resourceServiceClient;
        this.model = model;
        setCaption("Request bearbeiten oder erstellen");
        createWidgets();
        showWidgets();
        model.addPropertyChangeListener(this);
    }

    private void createWidgets() {
        tfTitel = new TextField("Titel");
        tfCustomerName = new TextField("Kundename");
        tfProjectName = new TextField("Projektname");
        tfRoleName = new TextField("Rollenname");
        dtDecisionDate = new DateField("Entscheidungsdatum");
        tfLocation = new TextField("Einsatzort");
        tfProjectDescription = new TextField("Projektbeschreibung");
        tfTaskDescription = new TextField("Aufgabenbeschreibung");
        dtPitchDeadline = new DateField("Pitch Deadline");
        tfPropability = new TextField("Einsatzwahrscheinlichkeit");
        dfRunTimeStart = new DateField("Startzeitpunkt");
        dfRunTimeEnd = new DateField("Endzeitpunkt");

        cbStatus = new ComboBox("Status");
        cbStatus.setDataProvider(new ListDataProvider(Arrays.asList(RequestStatus.values())));
        cbStatus.setEmptySelectionAllowed(false);
        cbStatus.setSelectedItem(RequestStatus.DRAFT);

        btCreateNew = new Button("Erstelle neuen Request");
        btCreateNew.addClickListener(clickEvent -> {onCreateNew();});

        btUpdateExisting = new Button("Aktualisiere vorhandenen Request");
        btUpdateExisting.addClickListener(clickEvent -> {onUpdateExisting();});

        bind();
    }

    private void bind() {
        binder = new Binder<>();

        binder.bind(tfTitel, ResourceRequest::getTitle, ResourceRequest::setTitle);
        binder.bind(tfCustomerName, ResourceRequest::getCustomerName, ResourceRequest::setCustomerName);
        binder.bind(tfProjectName, ResourceRequest::getProjectName, ResourceRequest::setProjectName);
        binder.bind(tfRoleName, ResourceRequest::getRoleName, ResourceRequest::setRoleName);
        binder.bind(tfLocation, ResourceRequest::getLocation, ResourceRequest::setLocation);
        binder.bind(tfProjectDescription, ResourceRequest::getProjectDescription, ResourceRequest::setProjectDescription);
        binder.bind(tfTaskDescription, ResourceRequest::getTaskDescription, ResourceRequest::setTaskDescription);

        binder.bind(cbStatus, ResourceRequest::getStatus, ResourceRequest::setStatus);

        //    return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
        //    Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())
        binder.bind(dtDecisionDate, new ValueProvider<ResourceRequest, LocalDate>() {
                    @Override
                    public LocalDate apply(ResourceRequest resourceRequest) {
                        if (resourceRequest.getDecisionDate() == null) {
                            return null;
                        }
                        return Instant.ofEpochMilli(resourceRequest.getDecisionDate().getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
                    }
                },
                new Setter<ResourceRequest, LocalDate>() {
                    @Override
                    public void accept(ResourceRequest resourceRequest, LocalDate localDate) {
                        if (localDate != null) {
                            resourceRequest.setDecisionDate(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                        }
                    }
                }
        );

        binder.bind(dtPitchDeadline, new ValueProvider<ResourceRequest, LocalDate>() {
                    @Override
                    public LocalDate apply(ResourceRequest resourceRequest) {
                        if (resourceRequest.getPitchDeadline() == null) {
                            return null;
                        }
                        return Instant.ofEpochMilli(resourceRequest.getPitchDeadline().getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
                    }
                },
                new Setter<ResourceRequest, LocalDate>() {
                    @Override
                    public void accept(ResourceRequest resourceRequest, LocalDate localDate) {
                        if (localDate != null) {
                            resourceRequest.setPitchDeadline(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                        }
                    }
                }
        );
        binder.bind(dfRunTimeStart, new ValueProvider<ResourceRequest, LocalDate>() {
                    @Override
                    public LocalDate apply(ResourceRequest resourceRequest) {
                        if (resourceRequest.getRunTimeStart() == null) {
                            return null;
                        }
                        return Instant.ofEpochMilli(resourceRequest.getRunTimeStart().getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
                    }
                },
                new Setter<ResourceRequest, LocalDate>() {
                    @Override
                    public void accept(ResourceRequest resourceRequest, LocalDate localDate) {
                        if (localDate != null) {
                            resourceRequest.setRunTimeStart(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                        }
                    }
                }
        );
        binder.bind(dfRunTimeEnd, new ValueProvider<ResourceRequest, LocalDate>() {
                    @Override
                    public LocalDate apply(ResourceRequest resourceRequest) {
                        if (resourceRequest.getRunTimeEnd() == null) {
                            return null;
                        }
                        return Instant.ofEpochMilli(resourceRequest.getRunTimeEnd().getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
                    }
                },
                new Setter<ResourceRequest, LocalDate>() {
                    @Override
                    public void accept(ResourceRequest resourceRequest, LocalDate localDate) {
                        if (localDate != null) {
                            resourceRequest.setRunTimeEnd(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
                        }
                    }
                }
        );

        binder.bind(tfPropability,
                new ValueProvider<ResourceRequest, String>() {
                    @Override
                    public String apply(ResourceRequest resourceRequest) {
                        if (resourceRequest.getProbability() != null) {
                            return df.format(resourceRequest.getProbability());
                        }
                        return null;
                    }
                },
                new Setter<ResourceRequest, String>() {
                    @Override
                    public void accept(ResourceRequest resourceRequest, String s) {
                        try {
                            if (s == null || s.isEmpty()) {
                                return;
                            }
                            resourceRequest.setProbability(df.parse(s).doubleValue());
                        } catch (ParseException e) {
                            Notification.show("Eingabe für Wahrscheinlichkeit ungültig","Bitte prüfen Sie das Format", Notification.Type.ERROR_MESSAGE);
                        }
                    }
                }
        );

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


    private void onUpdateExisting() {
        boolean saved = binder.writeBeanIfValid(model.getCurrentlySelectedResourceRequest());
        if (saved) {
            resourceServiceClient.updateExistingRequest(model.getCurrentlySelectedResourceRequest());
            Notification.show("Änderungen übernommen",
                    "Der Request mit dem Titel " + model.getCurrentlySelectedResourceRequest().getTitle() + " wurde erfolgreich gespeichert :" + model.getCurrentlySelectedResourceRequest(),
                    Notification.Type.HUMANIZED_MESSAGE);
            model.setCurrentlySelectedResourceRequest(null); //prepare for new one
        }
        else {
            Notification.show("Fehler beim Speichern",
                    "Der Request mit dem Titel " + model.getCurrentlySelectedResourceRequest().getTitle() + " konnte NICHT aktualisiert werden. Bitte prüfen Sie die Feldeingaben.",
                    Notification.Type.WARNING_MESSAGE);
        }
    }

    private void showWidgets() {
        addComponent(btCreateNew);
        addComponent(btUpdateExisting);
        addComponent(tfTitel);
        addComponent(cbStatus);
        addComponent(tfCustomerName);
        addComponent(tfProjectName);
        addComponent(tfRoleName);
        addComponent(dtDecisionDate);
        addComponent(tfLocation);
        addComponent(tfProjectDescription);
        addComponent(tfTaskDescription);
        addComponent(dtPitchDeadline);
        addComponent(tfPropability);
        addComponent(dfRunTimeStart);
        addComponent(dfRunTimeEnd);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(GlobalViewModel.SINGLE_RR_CHOSEN)) {
            binder.readBean(model.getCurrentlySelectedResourceRequest());
        }
    }
}
