package com.person.controller;

import java.util.List;

//import org.apache.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.loger.controller.MessageController;
import com.person.PersonApplication;
import com.person.entity.Person;
import com.person.exception.BusinessException;
import com.person.exception.ControllerException;
import com.person.repository.PersonRepository;
import com.person.service.PersonService;
import com.person.service.personServiceImpl;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@Autowired
	private personServiceImpl personServiceImpl;
	
	@Autowired
	private PersonRepository personRepository;
	
	Logger logger=LoggerFactory.getLogger(PersonController.class);

	
	@PostMapping("/save")
	public ResponseEntity<?> addPersons(@RequestBody Person person){
		
		try {
			logger.info("their is some issue please check it...");
			Person persons=personService.addPersonDetails(person);
			return new ResponseEntity<Person>(persons, HttpStatus.CREATED);
		}catch (BusinessException e) {
		ControllerException ce=new ControllerException(e.getErrorcode(), e.getMessage());
		return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
			
		}
		
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllPerson(){
		
		try {
			List<Person> persons=personService.getAllPerson();
			return new ResponseEntity<List<Person>>(persons, HttpStatus.OK);
		}catch (BusinessException e) {
		ControllerException ce=new ControllerException(e.getErrorcode(), e.getMessage());
		return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getById(@PathVariable int id){
		try {
			Person persons=personService.getPersonByid(id);
			return new ResponseEntity<Person>(persons, HttpStatus.OK);
		}catch (BusinessException e) {
			ControllerException ce=new ControllerException(e.getErrorcode(), e.getMessage());
			return new ResponseEntity<ControllerException>(ce, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@DeleteMapping("/delete/{id}")
	public  ResponseEntity<?> deleteById(@PathVariable int id){
		try {
			personService.deleteById(id);
			return new ResponseEntity<Person>( HttpStatus.OK);
		}catch (BusinessException e) {
		ControllerException ce=new ControllerException(e.getErrorcode(), e.getMessage());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST );
		}
		
	}
	
	
	@PutMapping("/save/{id}")
	public ResponseEntity<?> updatePerson(@RequestBody Person person){
		try {
			Person persons=personService.addPersonDetails(person);
			return new ResponseEntity<Person>(persons, HttpStatus.CREATED);
		}catch (BusinessException e) {
		ControllerException ce=new ControllerException(e.getErrorcode(), e.getMessage());
		return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
			
		}
		
			}
	
	@GetMapping("/adult")
	public List<Person> getAge(){
			 List<Person> p=personRepository.getByAge();
			 return p;
		}
		
	@GetMapping("/male")
	public List<Person> getMale(){
		List<Person> p=personRepository.getMale();
		return p;
	}
	
	@GetMapping("/female")
	public List<Person> getFeMale(){
		List<Person> p=personRepository.getFeMale();
		return p;
	}
	
//	@GetMapping("/resi")
//	public List<Person> getAdd(){
//		List<Person> p=personRepository.getAddressType();
//		return p;
//	}
	
	}
	

