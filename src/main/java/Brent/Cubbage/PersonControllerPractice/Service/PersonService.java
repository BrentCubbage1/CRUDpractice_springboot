package Brent.Cubbage.PersonControllerPractice.Service;


import Brent.Cubbage.PersonControllerPractice.Entity.Person;
import Brent.Cubbage.PersonControllerPractice.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository){
        this.repository = repository;
    }



    //CRUD is gonna have the services of Create, Read, ReadAll, Update, and Delete.

    public Person create(Person person){
        repository.save(person);
        return person;
    }


    public Person readById(Long id){
        return repository.findById(id).isPresent() ? repository.findById(id).get() :  null;
    }

    public List<Person> findAllPersons(){
        Iterable<Person> personIterator = repository.findAll();
        List<Person> personList = new ArrayList<>();

        personIterator.forEach(personList::add);
        return personList;
    }

    public Person update(Person person, Long id){
        Person personToUpdate = readById(id);

        personToUpdate.setName(person.getName());
        personToUpdate.setAge(person.getAge());
        repository.save(personToUpdate);

        return personToUpdate;
    }

    public Person delete(Long id){
        Person deletedPerson = readById(id);
        repository.delete(deletedPerson);
        return deletedPerson;
    }


}
