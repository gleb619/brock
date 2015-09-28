package org.test.data;

import org.test.util.Mockup;

import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.util.IndexedContainer;

public class MockupContainer {

	final Container container = new IndexedContainer();
	final Mockup mockup = new Mockup();

	public MockupContainer() {
		super();
		fill();
	}

	@SuppressWarnings("unchecked")
	private void fill() {
		container.addContainerProperty("name", String.class, "none");
		container.addContainerProperty("volume", Integer.class, 0);
		for (int index = 0; index < 50; index++) {
			Item newItem = container.getItem(container.addItem());
			newItem.getItemProperty("name").setValue(mockup.randomString());
			newItem.getItemProperty("volume").setValue(mockup.radndomInteger());
		}
	}

	public Container getContainer() {
		return container;
	}

	public Mockup getMockup() {
		return mockup;
	}

}
