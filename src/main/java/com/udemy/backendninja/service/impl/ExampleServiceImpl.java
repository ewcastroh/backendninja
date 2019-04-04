package com.udemy.backendninja.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.udemy.backendninja.model.Person;
import com.udemy.backendninja.service.ExampleService;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {

	private static final Log LOG = LogFactory.getLog(ExampleServiceImpl.class);
	
	@Override
	public List<Person> getListPeople() {
		List<Person> people = new ArrayList<>();
		people.add(new Person("Eimer", 28));
		people.add(new Person("Alejandra", 36));
		people.add(new Person("Samantha", 2));
		people.add(new Person("Mona", 3));
		people.add(new Person("Mono", 1));
		LOG.info("HELLO FROM SERVICE");
		return people;
	}

}
