package org.test.layout;

import org.test.data.MyComponent;

import com.vaadin.data.Container;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

public class EditLayout implements MyComponent {

	private static final long serialVersionUID = 7515031420128556207L;

	final VerticalLayout layout = new VerticalLayout();
	final Component form = new MyForm().init();
	final Container container;
	
	
//	final Item 
	
	public EditLayout(Container container) {
		super();
		this.container = container;
	}

	@Override
	public Component init() {
//		form.init().setI
		layout.setSizeFull();
		
		
		
		layout.addComponent(form);
		
		return layout;
	}

	@Override
	public void refresh(Object... objects) {
		if(objects.length > 0){
			((Form)form).setItemDataSource(container.getItem(objects[0]));
		}
//		((Form)form).
	}
		
}
