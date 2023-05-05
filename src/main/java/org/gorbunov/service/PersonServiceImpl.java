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

    public Person showPersonById(Integer id) {
        try {
            return storage.getPersonById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

        public void deletePerson(int id){
            try {
                storage.deletePerson(id);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    public void updatePerson(int id, Person newPerson) {
        try {
            storage.updatePersonById(id, newPerson);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
