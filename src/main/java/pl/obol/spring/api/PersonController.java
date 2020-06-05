package pl.obol.spring.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.obol.spring.model.Person;
import pl.obol.spring.service.PersonService;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;

   @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople(){
       return personService.getAllPeople();
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable("id") UUID id){
       return personService.getPersonById(id)
               .orElse(null);
    }
    @DeleteMapping("/{id}")
    public void deletePersonById(@PathVariable("id") UUID id){
       personService.deletePerson(id);
    }
    @PutMapping("/{id}")
    public void updatePerson(@PathVariable("id") UUID id, @RequestBody Person newPerson){
       personService.updatePerson(id, newPerson);
    }
}
