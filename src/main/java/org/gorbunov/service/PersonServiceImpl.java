package org.gorbunov.service;

import org.gorbunov.model.Person;
import org.gorbunov.storage.PersonStorage;

import java.sql.SQLException;

public class PersonServiceImpl implements PersonService {
    public PersonStorage storage = new PersonStorage();

    public void showPersons() {
        try {
            System.out.println(storage.showAll());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createPerson(Person person) {
        try {
            storage.addPerson(person);
        } catch (SQLException e) {
//            throw new RuntimeException();
            System.out.println(e.getMessage());
        }
    }

    public Object showPersonById(Integer id) {
        try {
            return storage.getById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//        public void deletePerson(int id){
//            try {
//                storage.deletePerson(id);
//            } catch (SQLException e) {
//                System.out.println(e.getMessage());
//            }
//        }

    public void updatePerson(int id, Person newPerson) {
        try {
            storage.update(id, newPerson);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
