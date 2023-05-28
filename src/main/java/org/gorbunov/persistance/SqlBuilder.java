package org.gorbunov.persistance;

import org.gorbunov.persistance.annotations.Column;
import org.gorbunov.persistance.annotations.Id;
import org.gorbunov.persistance.annotations.Table;

import java.lang.reflect.Field;

public class SqlBuilder {
    private static final String SPACE = " ";

    public static String buildSelect(Object obj) {

        Class<?> oClass = obj.getClass();
        Table tableAnnotation = oClass.getDeclaredAnnotation(Table.class);
        if (tableAnnotation == null) {
            throw new RuntimeException("");
        }

        StringBuilder sb = new StringBuilder("select * from ");
        sb.append(tableAnnotation.name());
        return sb.toString();
    }

    public static String buildInsert(Object obj) throws IllegalAccessException {
        Class<?> oClass = obj.getClass();
        Table tableAnnotation = oClass.getDeclaredAnnotation(Table.class);
        if (tableAnnotation == null) {
            throw new RuntimeException("");
        }

        StringBuilder dataSb = new StringBuilder("(");
        StringBuilder sb = new StringBuilder("insert into ");
        sb.append(tableAnnotation.name());
        sb.append(" (");
        Field[] declaredFields = oClass.getDeclaredFields();
        boolean isFirstField = true;
        for (int i = 0; i < declaredFields.length; i++) {
            Field field = declaredFields[i];
            Id idAnnotation = field.getAnnotation(Id.class);
            if (idAnnotation != null) {
                continue;
            }
            Column columnAnnotation = field.getAnnotation(Column.class);
            if (columnAnnotation != null) {
                if (!isFirstField) {
                    sb.append(", ");
                    dataSb.append(", ");
                } else {
                    isFirstField = false;
                }
                sb.append(columnAnnotation.name());

                field.setAccessible(true);

                dataSb.append("'").append(field.get(obj)).append("'");
                field.setAccessible(false);
            }
        }
        dataSb.append(")");
        sb.append(") ");

        sb.append(" VALUES ");
        sb.append(dataSb);
        return sb.toString();
    }
}
