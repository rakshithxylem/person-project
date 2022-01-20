package com.person.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.person.entity.Person;
import com.person.exception.BusinessException;
import com.person.repository.PersonRepository;

@Service
public class personServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Override
	public Person addPersonDetails(Person person) {
		if(person.getName().isEmpty() || person.getGender().length()==0 ) {
			throw new BusinessException("100", "name and the gender should not be left blank please fill it");
		}
		
		
		
	try {
		 Person person1=personRepository.save(person);
		 return person1;

	}catch ( IllegalArgumentException e) {
		throw new BusinessException("101", "error in storing data please it..."+e.getMessage());
	}
		
		 
	}

	@Override
	public List<Person> getAllPerson() {
		try {
			 List<Person> person1=personRepository.findAll();
			 return person1;
		}catch (Exception e) {
		throw new BusinessException("102", "their is no list in data base"+e.getMessage());
		}
		
	}

	@Override
	public Person getPersonByid(int id) {
		try {
			Person person=personRepository.findById(id).get();
			return person;
		}catch (IllegalArgumentException e) {
			throw new BusinessException("103", "the id you entering is not present in data base check again");
		}catch (Exception e) {
	throw new BusinessException("104", "your id is wrong please check it....");
		}
		
	}

	@Override
	public void deleteById(int id) {
		try {
		 personRepository.deleteById(id);

		}catch (IllegalArgumentException e) {
	throw new BusinessException("104", "id you have selected is not present in data base");
			
		}
		
	}

	@Override
	public Person updatePerson(Person person, int id) {
		Person existingperson1=personRepository.findById(id).orElseThrow(
			()->	new BusinessException("303", "the person you trying to update is not presnt"));
		existingperson1.setAddress(person.getAddress());
		existingperson1.setAge(person.getAge());
		existingperson1.setName(person.getName());
		existingperson1.setGender(person.getGender());
		
		personRepository.save(existingperson1);
		return existingperson1;
	}
	
//	public List<Person> getPersonByAge(){
//		
//		List<Person> p=personRepository.getByAge();
//		return p;
//	}
//	
//
//	public List<Person> getMale(){
//		
//		List<Person> p=personRepository.getMale();
//				return p;
//	}
//	
//public List<Person> getFeMale(){
//		
//		List<Person> p=personRepository.getFeMale();
//				return p;
//	}
//	
//public List<Person> getAddress(){
//	
//	List<Person> p=personRepository.getAddressType();
//			return p;
//}
}
