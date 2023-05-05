package org.gorbunov.storage;

import org.gorbunov.model.Person;
import org.gorbunov.persistance.DAO;

import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.LinkedList;
import java.util.List;

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

    public Person getPersonById(int id) throws SQLException{
        String sql = "Select * from persons where id = " + id;
        ResultSet ps = dao.getConnection().createStatement().executeQuery(sql);

        ps.next();
        return new Person(
                ps.getString("first_name"),
                ps.getString("second_name"),
                ps.getString("middle_name"),
                ps.getDate("birth_date").toLocalDate()
        );
    }

    public void updatePersonById(int id, Person person) throws SQLException {
        String sql = "Update persons Set first_name = ?, second_name = ?, middle_name = ?, birth_date = ? Where id = " + id;
        PreparedStatement ps = dao.getConnection().prepareStatement(sql);
        ps.setString(1, person.getFirstName());
        ps.setString(2, person.getSecondName());
        ps.setString(3, person.getPatternalName());
        ps.setDate(4, Date.valueOf(person.getBirthDate()));

        ps.executeUpdate();
    }
    public void deletePerson(int id) throws SQLException{
        String sql = "Delete from persons where id = " + id;
        PreparedStatement ps = dao.getConnection().prepareStatement(sql);

        ps.executeUpdate();
    }
}
