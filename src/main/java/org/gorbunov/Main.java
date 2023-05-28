package org.gorbunov;

import org.gorbunov.controller.Controller;
import org.gorbunov.model.Person;
import org.gorbunov.model.Pet;
import org.gorbunov.persistance.DataAccessObject;
import org.gorbunov.persistance.Executor;
import org.gorbunov.persistance.SqlBuilder;
import org.gorbunov.storage.DAO;
import org.gorbunov.storage.PersonRSProcessor;
import org.gorbunov.storage.PetStorage;
import org.gorbunov.storage.ResultSetProcessor;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, IllegalAccessException {
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

        Pet a = new Pet();
        a.setAge(12);
        a.setName("qwerty");
        a.setId(1);

//        PetStorage storage = new PetStorage();
//        List<Pet> all = storage.showAll();
//        all.forEach(pet -> System.out.println(pet));
//        String sql = SqlBuilder.buildInsert(new Person("Иван", "Иванов", "Иванович"));
//        Executor executor = new Executor(DAO.getInstance());
//        try{
//            executor.executeUpdate(sql);
//        } catch (Exception e){
//            System.out.println(e);
//        }
    }
}