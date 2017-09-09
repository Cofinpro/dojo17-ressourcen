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
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

class Overview extends VerticalLayout {

    private Grid<ResourceRequest> grid;
    private ResourceServiceClient resourceServiceClient;
    private GlobalViewModel model;
    private ListDataProvider<ResourceRequest> listDataProvider;
    private Button btReload;


    Overview(ResourceServiceClient resourceServiceClient, GlobalViewModel model) {
        this.resourceServiceClient = resourceServiceClient;
        this.model = model;
        setCaption("Übersicht");
        createWidgets();
        showWidgets();
    }

    private void createWidgets() {
        listDataProvider =
                new ListDataProvider<>(resourceServiceClient.getAllResourceRequests());
        btReload = new Button("Neuladen");
        btReload.addClickListener(clickEvent -> { listDataProvider.refreshAll(); });
        grid = new Grid<>();
        grid.setSizeFull();
        grid.setDataProvider(listDataProvider);
        //grid.setSelectionMode(Grid.SelectionMode.SINGLE);
        HeaderRow topHeader = grid.prependHeaderRow();
        grid.addColumn(ResourceRequest::getTitle)
                .setId("TitleColumn")
                .setCaption("Titel");
        grid.addSelectionListener(selectionEvent -> {
            Iterator<ResourceRequest> it = grid.getSelectedItems().iterator();
            if (it.hasNext()) {
                model.setCurrentlySelectedResourceRequest(it.next());
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