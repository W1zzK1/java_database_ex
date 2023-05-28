package org.gorbunov.storage;

import org.gorbunov.model.Pet;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PetStorage {
    private DAO dao = DAO.getInstance();
    public void add(Pet pet) throws SQLException {
//        ps.setInt(1, pet.getId());
//        ps.setString(2, pet.getName());
//        ps.setInt(3, pet.getAge());
//
//        ps.execute();
    }

//    public List<Pet> showAll() throws SQLException {
//        return dao.executeQuery("Select * from pets", new PetRSProcessor());
//    }

    public Pet getById(int id) throws SQLException{
        String sql = "Select * from pets where id = " + id;
        ResultSet ps = dao.getConnection().createStatement().executeQuery(sql);

        ps.next();
        return new Pet(
                ps.getInt("id"),
                ps.getString("name"),
                ps.getInt("age")
        );
    }

    public void update(int id, Pet pet) throws SQLException {
        String sql = "Update pets Set name = ?, age = ? Where id = " + id;
        PreparedStatement ps = dao.getConnection().prepareStatement(sql);
        ps.setString(2, pet.getName());
        ps.setInt(3, pet.getAge());

        ps.executeUpdate();
    }
    public void deletePerson(int id) throws SQLException{
        String sql = "Delete from pets where id = " + id;
        PreparedStatement ps = dao.getConnection().prepareStatement(sql);

        ps.executeUpdate();
    }

}
