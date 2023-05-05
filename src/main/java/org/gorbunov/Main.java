package org.gorbunov;

import org.gorbunov.controller.Controller;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();

        controller.addPersonView();
//        controller.showPersons();
//        controller.showPersonById();
//        controller.findPersonWithId();
//
        controller.deletePerson();
//
//        controller.updatePerson();

        controller.showPersons();
    }
}