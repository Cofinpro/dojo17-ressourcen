package de.cofinpro.dojo.ressourcen.ui;

import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.components.grid.HeaderRow;
import com.vaadin.ui.themes.ValoTheme;
import de.cofinpro.dojo.ressourcen.model.ResourceRequest;
import de.cofinpro.dojo.ressourcen.service.ResourceServiceClient;

import java.beans.PropertyChangeSupport;
import java.util.*;

class Overview extends VerticalLayout {

    private Grid<ResourceRequest> grid;
    private ResourceServiceClient resourceServiceClient;
    private GlobalViewModel model;
    private ListDataProvider<ResourceRequest> listDataProvider;
    private Button btReload;
    private List<ResourceRequest> allResourceRequests;

    Overview(ResourceServiceClient resourceServiceClient, GlobalViewModel model) {
        this.resourceServiceClient = resourceServiceClient;
        this.model = model;
        allResourceRequests = new ArrayList<>();
        allResourceRequests.addAll(resourceServiceClient.getAllResourceRequests());
        setCaption("Übersicht");
        createWidgets();
        showWidgets();
    }

    private void createWidgets() {
        listDataProvider =
                new ListDataProvider<>(allResourceRequests);
        btReload = new Button("Neuladen");
        btReload.addClickListener(clickEvent -> {
            allResourceRequests.clear();
            allResourceRequests.addAll(resourceServiceClient.getAllResourceRequests());
            listDataProvider.refreshAll(); }
        );
        grid = new Grid<>();
        grid.setSizeFull();
        grid.setDataProvider(listDataProvider);
        //grid.setSelectionMode(Grid.SelectionMode.SINGLE);
        HeaderRow topHeader = grid.prependHeaderRow();
        grid.addColumn(ResourceRequest::getTitle)
                .setId("TitleColumn")
                .setCaption("Titel");
        grid.addColumn(ResourceRequest::getProjectName)
                .setId("ProjectColumn")
                .setCaption("Project");
        grid.addColumn(ResourceRequest::getDecisionDate)
                .setId("DecisionDateColumn")
                .setCaption("Entscheidungsdatum");

        grid.addSelectionListener(selectionEvent -> {
            Iterator<ResourceRequest> it = grid.getSelectedItems().iterator();
            if (it.hasNext()) {
                model.setCurrentlySelectedResourceRequest(it.next());
            }
            else {
                model.setCurrentlySelectedResourceRequest(null);
            }
        });
    }

    private void showWidgets() {
        addComponent(btReload);
        addComponent(grid);
    }

    private TextField getColumnFilterField() {
        TextField filter = new TextField();
        filter.setWidth("100%");
        filter.addStyleName(ValoTheme.TEXTFIELD_TINY);
        filter.setPlaceholder("Filter");
        return filter;
    }
}
