package PersonApp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import PersonApp.model.Person;
import PersonApp.repository.PersonRepository;
import sumapp.exceptions.ResourceNotFoundException;

@Service
public class PersonServices {
	private final AtomicLong counter = new AtomicLong();
    private Logger logger= Logger.getLogger(PersonServices.class.getName());
   @Autowired
   PersonRepository personRepository;
    
    public List<Person> findAll() {
    	List<Person> persons = new ArrayList<>();
    	for (int i =0; i < 8; i++) {
    		Person person = mockPerson(i);
    		persons.add(person);
    	}
		return persons;
    	
    }
    public Person create(Person person) {
    	logger.info("Creating one person!");
    	return personRepository.save(person);
    	
    }
    public Person update(Person person) {
    	logger.info("Updating one person!");
    	Person entity = personRepository.findById(person.getId())
     			.orElseThrow(()->new ResourceNotFoundException("Not records for ths id"));
    	entity.setFirstName(person.getFirstName());
    	entity.setLasttName(person.getLasttName());
    	entity.setAddress(person.getAddress());
    	entity.setEmail(person.getEmail());
    	entity.setPhoneNumber(person.getPhoneNumber());
    	entity.setGender(person.getGender());
    	return personRepository.save(entity);
    	
    }
  	private Person mockPerson(int i) {
  		logger.info("Finding all people!");
  		Person person = new Person();
  		person.setId(counter.incrementAndGet());
    	person.setFirstName("Person "+i);
    	person.setLasttName("Chagas");
    	person.setAddress("Address "+i);
    	person.setEmail("email "+i);
    	person.setPhoneNumber("819991791043");
    	person.setGender("gender"+i);
		return person;
	}
	public Person findByid(Long id) {
    	logger.info("Finding one person!");
     	return personRepository.findById(id)
     			.orElseThrow(()->new ResourceNotFoundException("Not records for ths id"));
    }
	public void delete(Long id) {
		logger.info("Deleting one person!");
		Person entity = personRepository.findById(id)
     			.orElseThrow(()->new ResourceNotFoundException("Not records for ths id"));
		 personRepository.delete(entity);
	}
}
