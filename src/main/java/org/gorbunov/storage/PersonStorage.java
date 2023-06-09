package org.gorbunov.storage;

import org.gorbunov.model.Person;
import org.gorbunov.persistance.Executor;
import org.gorbunov.persistance.SqlBuilder;

import java.sql.*;
import java.util.List;

public class PersonStorage implements Storage{
    private DAO dao = DAO.getInstance();

    public String addPerson(Person person) throws SQLException, IllegalAccessException {
        return SqlBuilder.buildInsert(person);
    }

    @Override
    public Object getById(Integer id) throws SQLException {
        return null;
    }

    @Override
    public List showAll() throws SQLException {
        return null;
    }

//    public List<Person> showAll() throws SQLException {
//        return Executor
//    }

    @Override
    public Object add(Object entity) throws SQLException {
        return null;
    }

    @Override
    public void update(Integer id, Object entity) throws SQLException {

    }

    @Override
    public void delete(Integer id) throws SQLException {
        Storage.super.delete(id);
    }

    public Person getById(int id) throws SQLException{
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

    public void update(int id, Person person) throws SQLException {
        String sql = "Update persons Set first_name = ?, second_name = ?, middle_name = ?, birth_date = ? Where id = " + id;
        PreparedStatement ps = dao.getConnection().prepareStatement(sql);
        ps.setString(1, person.getFirstName());
        ps.setString(2, person.getSecondName());
        ps.setString(3, person.getPatternalName());
        ps.setDate(4, Date.valueOf(person.getBirthDate()));

        ps.executeUpdate();
    }
    public void delete(int id) throws SQLException{
        String sql = "Delete from persons where id = " + id;
        PreparedStatement ps = dao.getConnection().prepareStatement(sql);

        ps.executeUpdate();
    }
}
