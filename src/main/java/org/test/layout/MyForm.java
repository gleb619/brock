package org.test.layout;

import org.test.data.MyComponent;

import com.vaadin.data.Item;
import com.vaadin.data.fieldgroup.DefaultFieldGroupFieldFactory;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroupFieldFactory;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.DefaultFieldFactory;
import com.vaadin.ui.Field;
import com.vaadin.ui.Form;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;

public class MyForm implements MyComponent {

	private static final long serialVersionUID = -5879121930252656568L;

	final Form form = new Form();
	final Button save = new Button("Save");
	final HorizontalLayout footer = new HorizontalLayout();
	
	@Override
	public Component init() {
		form.setFormFieldFactory(new MyFieldFactory());
		footer.addComponent(save);
		form.setFooter(footer);
		
		return form;
	}
	
	private void onClick() {
		save.addClickListener((e) -> {
			try {
				form.commit();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
	}
	
	@SuppressWarnings("unchecked")
	class MyFieldFactory extends DefaultFieldFactory {

		private static final long serialVersionUID = -5423890726505103576L;

		@Override
		public Field<?> createField(Item item, Object propertyId,
				Component uiContext) {
			return super.createField(item, propertyId, uiContext);
		}

	}

	@Override
	public void refresh(Object... objects) {
		// TODO Auto-generated method stub
		
	}

}
