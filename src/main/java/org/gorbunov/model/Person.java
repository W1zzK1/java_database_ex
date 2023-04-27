package org.gorbunov.model;

import java.time.LocalDate;

public class Person {
    public String firstName;
    public String secondName;
    public String patternalName;
    public LocalDate birthDate;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
//        if (firstName.matches("[а-яА-Я,a-zA-Z]+")){
//        }
//        else System.out.println("Не верно введено имя");
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
//        if (secondName.matches("[а-яА-Я,a-zA-Z]+")){
//        }
//        else System.out.println("Не верно введено отчество");
    }

    public String getPatternalName() {
        return patternalName;
    }

    public void setPatternalName(String patternalName) {
        this.patternalName = patternalName;
//        if (patternalName.matches("[а-яА-Я,a-zA-Z]+")){
//        }
//        else System.out.println("Не верно введено фамилия");
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        LocalDate minimalDate = LocalDate.parse("1900-01-01"); /// Минимальная граница года, который можео ввести
        if (birthDate.isBefore(minimalDate)){
            System.out.println("Не верная дата");
            return;
        }
        this.birthDate = birthDate;
    }

    public Person(String firstName, String secondName, String patternalName, LocalDate birthDate) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.patternalName = patternalName;
        this.birthDate = birthDate;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", patternalName='" + patternalName + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
