package org.test.layout;

import org.test.data.MockupContainer;
import org.test.data.MyComponent;

import com.vaadin.data.Container;
import com.vaadin.ui.Component;
import com.vaadin.ui.Table;

public class MyTable implements MyComponent {

	private static final long serialVersionUID = -2989018669507214813L;
	
	final Table table = new Table();
	final Container container;
	
	public MyTable(Container container) {
		super();
		this.container = container;
	}

	@Override
	public Component init() {
		settings();
		return table;
	}
	
	private void settings() {
		table.setSizeFull();
		table.setSelectable(true);
		
		table.setContainerDataSource(container);
		table.setColumnHeaders(new String[] { "Text", "Number" });
	}

}
