package com.person.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
//import org.yaml.snakeyaml.external.com.google.gdata.util.common.base.PercentEscaper;

import com.person.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{
	
	@Query(value = "SELECT  * FROM PERSON  WHERE AGE>=18",nativeQuery = true)
	public List<Person> getByAge();
	
	@Query(value = "SELECT * FROM PERSON WHERE GENDER='M'",nativeQuery = true)
	public List<Person> getMale();

	@Query(value = "SELECT * FROM PERSON WHERE GENDER='F'",nativeQuery = true)
	public List<Person> getFeMale();
	
	@Query(value="SELECT * FROM PERSON WHERE TYPE='residential'",nativeQuery = true)
	public List<Person> getAddressType();

}
