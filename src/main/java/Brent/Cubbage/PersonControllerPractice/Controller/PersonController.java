package Brent.Cubbage.PersonControllerPractice.Controller;


import Brent.Cubbage.PersonControllerPractice.Entity.Person;
import Brent.Cubbage.PersonControllerPractice.Service.PersonService;
import org.apache.coyote.Response;
import org.aspectj.weaver.patterns.PerObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/person")
public class PersonController {


    private PersonService service;

    @Autowired
    public PersonController(PersonService service){
        this.service = service;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Person> createPerson(@RequestBody Person person){
        Person createdPerson = service.create(person);

        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<Person> findById(@PathVariable Long id){
        Person foundPerson = service.readById(id);

        return new ResponseEntity<>(foundPerson, HttpStatus.OK);
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<Person>> findAll(){
        List<Person> foundPersons = service.findAllPersons();

        return new ResponseEntity<>(foundPersons, HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Person> update(@PathVariable Long id, @RequestBody Person person){
        Person updatedPerson = service.update(person, id);

        return new ResponseEntity<>(updatedPerson, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Person> delete(@PathVariable Long id){
        Person deletedPerson = service.delete(id);

        return new ResponseEntity<>(deletedPerson, HttpStatus.OK);
    }

}
