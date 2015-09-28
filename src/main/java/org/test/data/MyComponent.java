package org.test.data;

import java.io.Serializable;

import com.vaadin.ui.Component;

public interface MyComponent extends Serializable {

	public Component init();
	
	public void refresh(Object... objects);
	
}
