package org.test.entity;

import java.io.Serializable;

public class Employee implements Serializable {

	private static final long serialVersionUID = 4301528352866098886L;
	
	private Integer id;
	private String text;
	private Integer number;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(Integer id, String text, Integer number) {
		super();
		this.id = id;
		this.text = text;
		this.number = number;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

}
