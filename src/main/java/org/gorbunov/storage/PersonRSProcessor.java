package org.gorbunov.storage;
import org.gorbunov.model.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonRSProcessor implements ResultSetProcessor<Person> {
    @Override
    public Person process(ResultSet rs) throws SQLException{
        return new Person(
                rs.getString("first_name"),
                rs.getString("second_name"),
                rs.getString("middle_name"),
                rs.getDate("birth_date").toLocalDate()
        );
    }
}
