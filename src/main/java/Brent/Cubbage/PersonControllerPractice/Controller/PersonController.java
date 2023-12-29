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

        return ResponseEntity.status(HttpStatus.CREATED).body(createdPerson);
    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<Person> findById(@PathVariable Long id){
        Person foundPerson = service.readById(id);

        return ResponseEntity.status(HttpStatus.OK).body(foundPerson);
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<Person>> findAll(){
        List<Person> foundPersons = service.findAllPersons();

        return ResponseEntity.status(HttpStatus.OK).body(foundPersons);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Person> update(@PathVariable Long id, @RequestBody Person person){
        Person updatedPerson = service.update(person, id);

        return ResponseEntity.status(HttpStatus.OK).body(updatedPerson);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Person> delete(@PathVariable Long id){
        Person person = service.delete(id);

        return ResponseEntity.status(HttpStatus.OK).body(person);
    }

}
