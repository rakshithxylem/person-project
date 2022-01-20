package com.person.service;

import java.util.List;

import com.person.entity.Person;

public interface PersonService {

	public Person addPersonDetails(Person person);
	
	public List<Person> getAllPerson();
	
	public Person getPersonByid(int id);
	
	public void deleteById(int id);
	
	public Person updatePerson(Person person, int id);
	//public List<Person> getPersonByAge();
}
