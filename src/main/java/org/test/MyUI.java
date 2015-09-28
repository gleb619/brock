package org.test;

import javax.servlet.annotation.WebServlet;

import org.test.data.MockupContainer;
import org.test.data.MyComponent;
import org.test.layout.ViewLayout;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 *
 */
@Theme("mytheme")
@Widgetset("org.test.MyAppWidgetset")
public class MyUI extends UI {

	private static final long serialVersionUID = 7943106665719793304L;
	
	final VerticalLayout root = new VerticalLayout();
	final TabSheet tabsheet = new TabSheet();
	final MockupContainer container = new MockupContainer();
	final ViewLayout table = new ViewLayout(tabsheet, container.getContainer()); 
	
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        root.setMargin(true);
        root.setSizeFull();
        setContent(root);

        Button button = new Button("Click Me");
        button.addClickListener((e) -> {
            root.addComponent(new Label("Thank you for clicking"));
        });
        
        tabsheet.setSizeFull();
        root.addComponent(tabsheet);

        // Create the first tab
        VerticalLayout tab1 = new VerticalLayout();
        tab1.setSizeFull();
        tab1.addComponent(table.init());
        tabsheet.addTab(tab1, "Data list");

        // This tab gets its caption from the component caption
        VerticalLayout tab2 = new VerticalLayout();
//        tab2.addComponent();
        tabsheet.addTab(tab2, "Edit");
        
        
        root.addComponent(tabsheet);

    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
