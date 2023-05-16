package org.gorbunov.storage;

import org.gorbunov.model.Pet;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PetRSProcessor implements ResultSetProcessor<Pet> {
    @Override
    public Pet process(ResultSet rs) throws SQLException {
        return new Pet(rs.getInt("id"),
                rs.getString("name"),
                rs.getInt("age"));
    }
}
