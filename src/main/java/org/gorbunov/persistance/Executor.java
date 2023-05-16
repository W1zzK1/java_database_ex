package org.gorbunov.persistance;

import lombok.RequiredArgsConstructor;
import org.gorbunov.storage.ResultSetProcessor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class Executor {
    private final DataAccessObject dao;
    public <T> List<T> executeQuery(String sql, ResultSetProcessor<T> processor) throws SQLException {
        Statement st = dao.getConnection().createStatement();
        ResultSet rs = st.executeQuery(sql);
        List<T> entityList = new ArrayList<>();
        while (rs.next()) {
            T entity = processor.process(rs);
            entityList.add(entity);
        }
        return entityList;
    }

    public void executeUpdate(String sql) throws SQLException {
        Statement st = dao.getConnection().createStatement();
        st.executeUpdate(sql);
    }
}
