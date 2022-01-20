package com.person.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String type;
	private String city;
	private String state;
@ManyToOne
@JoinTable(name="stu_address" ,joinColumns = {@JoinColumn(name="person_table")},
inverseJoinColumns = {@JoinColumn(name="address_table")}
		)
@JsonBackReference
	private Person person;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public Person getPerson() {
	return person;
}
public void setPerson(Person person) {
	this.person = person;
}
public Address(int id, String type, String city, String state, Person person) {
	super();
	this.id = id;
	this.type = type;
	this.city = city;
	this.state = state;
	this.person = person;
}
public Address() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Address [id=" + id + ", type=" + type + ", city=" + city + ", state=" + state + ", person=" + person + "]";
}





}
