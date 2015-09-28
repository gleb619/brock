package org.test.layout;

import org.test.data.MyComponent;

import com.vaadin.data.Container;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

public class ViewLayout implements MyComponent {

	private static final long serialVersionUID = 7515031420128556207L;
	
	final TabSheet parent;
	final Container container;
	
	final VerticalLayout layout = new VerticalLayout();
	final HorizontalLayout toolbar = new HorizontalLayout();
	final Button editButton = new Button("Edit");
	final Button deleteButton = new Button("Delete");
	final Table table;
	
	public ViewLayout(TabSheet parent, Container container) {
		super();
		this.parent = parent;
		this.container = container;
		this.table = (Table) new MyTable(container).init();
	}

	@Override
	public Component init() {
		onClick();
		toolbar.addComponent(editButton);
		toolbar.addComponent(deleteButton);
		layout.addComponent(toolbar);
		layout.addComponent(table);
		
		return layout;
	}
	
	public void onClick() {
		table.addItemClickListener((e) -> {
			deleteButton.setEnabled(true);
			editButton.setEnabled(true);
		});
		
		editButton.addClickListener((e) -> {
			parent.setSelectedTab(1);
		});
		
		deleteButton.addClickListener((e) -> {
			container.removeItem(table.getValue());

			deleteButton.setEnabled(false);
			editButton.setEnabled(false);
		});
	}
	
/*
	@Override
	public void layoutClick(LayoutClickEvent event) {
		if (event.getButton() == editButton) {
			Notification.show("Message", "Button is working",
					Notification.Type.TRAY_NOTIFICATION);
			parent.setSelectedTab(2);
			System.out.println("ViewLayout.buttonClick()#editClicked");
		}
		else if (event.getButton() == deleteButton) {
			container.removeItem(table.getValue());

			deleteButton.setEnabled(false);
			editButton.setEnabled(false);
			System.out.println("ViewLayout.buttonClick()#deleteClicked");
		}
	}
*/
/*
	@Override
	public void layoutClick(LayoutClickEvent event) {
		if (event.getButton() == editButton) {
			Notification.show("Message", "Button is working",
					Notification.Type.TRAY_NOTIFICATION);
			parent.setSelectedTab(2);
			System.out.println("ViewLayout.buttonClick()#editClicked");
		}
		else if (event.getButton() == deleteButton) {
			container.removeItem(table.getValue());

			deleteButton.setEnabled(false);
			editButton.setEnabled(false);
			System.out.println("ViewLayout.buttonClick()#deleteClicked");
		}
	}
	*/
	
}
