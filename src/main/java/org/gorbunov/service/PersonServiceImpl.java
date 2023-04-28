package org.gorbunov.service;

import org.gorbunov.model.Person;
import org.gorbunov.storage.PersonStorage;

import java.sql.SQLException;
import java.util.List;

public class PersonServiceImpl implements PersonService {
    public PersonStorage storage = new PersonStorage();

    public void showPersons() {
        try {
            storage.showAllPersons();
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void createPerson(Person person) {
        try {
            storage.addPerson(person);
        } catch (SQLException e){
//            throw new RuntimeException();
            System.out.println(e.getMessage());
        }
    }

//    public void deletePerson(int id){
//        storage.deletePerson(id);
//    }
//    public void findPersonWithId(Integer id) {
//        Person a = storage.findPersonWithId(id);
//        System.out.println(a);
//    }
//
//    public void updatePerson(int id, Person newPerson) {
//        storage.updatePerson(id, newPerson);
//    }

    private boolean validateString(String s) {
        return s.matches("\\d");
    }

}
