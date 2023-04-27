package org.gorbunov.storage;

import org.gorbunov.model.Person;
import org.gorbunov.persistance.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class PersonStorage {
    private DAO dao = DAO.getInstance();
    private String INSERT_SQL = "INSERT INTO persons (first_name, second_name, middle_name, birth_date) VALUES (?, ?, ?, ?)";

    public Person addPerson(Person person) throws SQLException {
        PreparedStatement ps = dao.getConnection().prepareStatement(INSERT_SQL);
        ps.setString(1, person.getFirstName());
        ps.setString(2, person.getSecondName());
        ps.setString(3, person.getPatternalName());
        ps.setDate(4, Date.valueOf(person.getBirthDate()));

        ps.execute();

        return person;
    }


//    public void addPerson(Person person) {
//        allPersons.add(person);
//        index++;
//    }
//
//    public void deletePerson(int id) {
//        allPersons.remove(id);
//    }
//
//    public List<Person> getAllPersons() {
//        return new ArrayList<>(allPersons);
//    }
//
//    public Person updatePerson(int id, Person person) {
//        return allPersons.set(id, person);
//    }
//
//    public Person findPersonWithId(int id) {
//        return allPersons.get(id);
//    }
}
