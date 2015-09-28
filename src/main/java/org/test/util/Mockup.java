package org.test.util;

import java.util.Random;

import com.github.javafaker.Faker;

public class Mockup {

	final Faker faker = new Faker();
	
	public String randomString() {
		return randomString(radndomInteger(5, 30));
	}
	
	public String randomString(Integer length) {
		return faker.lorem().fixedString(length);
	}
	
	public Integer radndomInteger() {
		return radndomInteger(1, 100);
	}
	
	public Integer radndomInteger(Integer min, Integer max) {
	    return new Random().nextInt((max - min) + 1) + min;
	}
	
}
