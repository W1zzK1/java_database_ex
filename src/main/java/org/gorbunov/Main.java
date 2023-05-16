package org.gorbunov;

import org.gorbunov.controller.Controller;
import org.gorbunov.model.Pet;
import org.gorbunov.storage.PetStorage;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        Controller controller = new Controller();

//        controller.addPersonView();
//        controller.showPersons();
//        controller.showPersonById();
//        controller.findPersonWithId();
//
//        controller.deletePerson();
//
//        controller.updatePerson();

//        controller.showPersons();
        PetStorage storage = new PetStorage();
        List<Pet> all = storage.showAll();
        all.forEach(pet -> System.out.println(pet));
    }
}