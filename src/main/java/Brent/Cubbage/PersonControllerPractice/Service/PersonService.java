package Brent.Cubbage.PersonControllerPractice.Service;


import Brent.Cubbage.PersonControllerPractice.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository){
        this.repository = repository;
    }
}
