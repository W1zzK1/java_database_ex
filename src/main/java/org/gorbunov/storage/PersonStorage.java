package org.gorbunov.storage;

import org.gorbunov.model.Person;
import org.gorbunov.persistance.DAO;

import java.sql.*;

public class PersonStorage {
    private DAO dao = DAO.getInstance();
    private String INSERT_SQL = "INSERT INTO persons (first_name, second_name, middle_name, birth_date) VALUES (?, ?, ?, ?)";
    private String SELECT_ALL_SQL = "Select * from persons";

    public Person addPerson(Person person) throws SQLException {
        PreparedStatement ps = dao.getConnection().prepareStatement(INSERT_SQL);
        ps.setString(1, person.getFirstName());
        ps.setString(2, person.getSecondName());
        ps.setString(3, person.getPatternalName());
        ps.setDate(4, Date.valueOf(person.getBirthDate()));

        ps.execute();

        return person;
    }

    public void showAllPersons() throws SQLException {
        ResultSet ps = dao.getConnection().createStatement().executeQuery(SELECT_ALL_SQL);

        while (ps.next()) {
            System.out.print("ID = " + ps.getObject(1) + "; ");
            System.out.print("first_name = " + ps.getObject(2) + "; ");
            System.out.print("second_name = " + ps.getObject(3) + "; ");
            System.out.print("middle_name = " + ps.getObject(4) + "; ");
            System.out.print("birth_date = " + ps.getObject(5) + "; ");
            System.out.println(" ");
        }
        ps.close();
    }
}
