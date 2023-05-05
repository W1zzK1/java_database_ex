package org.gorbunov.controller;

import org.gorbunov.exception.IlligalDataException;
import org.gorbunov.model.Person;
import org.gorbunov.service.PersonServiceImpl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Controller {
    PersonServiceImpl service = new PersonServiceImpl();

    public void addPersonView() {
        boolean correctFlag = false;
        while (!correctFlag) {
            try {
                Scanner sc = new Scanner(System.in);
                service.createPerson(readData(sc));
                correctFlag = true;
            } catch (IlligalDataException e) {
                System.out.println("Произошла ошибка при вводе данных, попробуйте заново");
            }
        }
    }

    private Person readData(Scanner sc) {

        Person person = new Person();
        System.out.print("Введите имя : ");
        String firstName = sc.nextLine();
        if (validateString(firstName)) {
            person.setFirstName(firstName);
        } else {
            System.out.println("Не корректное имя, начните заново");
            throw new IlligalDataException("Не корректное имя");
        }

        System.out.print("Введите фамилию : ");
        String secondName = sc.nextLine();
        if (validateString(secondName)) {
            person.setSecondName(secondName);
        } else {
            System.out.println("Не корректная фамилия, начните заново");
            throw new IlligalDataException("Не корректная фамилия");
        }

        System.out.print("Введите отчество : ");
        String patternalName = sc.nextLine();
        if (validateString(patternalName)) {
            person.setPatternalName(patternalName);
        } else {
            System.out.println("Не корректное отчество, начните заново");
            throw new IlligalDataException("Не корректное отчество");
        }

        System.out.print("Введите дату рождения в формате 1900-01-01 : ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthDate = LocalDate.parse(sc.nextLine(), formatter);
        LocalDate minimalDate = LocalDate.parse("1900-01-01");
        if (!birthDate.isBefore(minimalDate)) {
            person.setBirthDate(birthDate);
        } else {
            System.out.println("Не корректная дата рождения, попробуйте еще раз");
            throw new IlligalDataException("Не корректная дата рождения");
        }
//        person.setBirthDate(LocalDate.parse("1900-01-02"));
        return person;

    }

    public void showPersons() {
        service.showPersons();
    }
    public void showPersonById(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите Id для поиска : ");
        Integer id = Integer.valueOf(sc.nextLine());
        System.out.println(service.showPersonById(id));
    }

    public void updatePerson(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите Id persona для обновления данных : ");
        Integer id = Integer.valueOf(sc.nextLine());
        service.updatePerson(id, readData(sc));
    }
    public void deletePerson(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите Id для поиска : ");
        Integer id = Integer.valueOf(sc.nextLine());
        service.deletePerson(id);
    }
//
//    public void findPersonWithId() {
//        boolean correctFlag = false;
////        int idPersonToFind = 0;
//        while (!correctFlag) {
////            try (Scanner sc = new Scanner(System.in)) {
////                System.out.print("Введите Id для поиска : ");
////                idPersonToFind = sc.nextInt();
////                service.findPersonWithId(idPersonToFind);
////                correctFlag = true;
////            } catch (RuntimeException e){
////                correctFlag = false;
////            }
//            try {
//                try {
//                    int idPersonToFind = 0;
//                    Scanner sc = new Scanner(System.in);
//                    System.out.print("Введите Id для поиска : ");
//                    idPersonToFind = Integer.valueOf(sc.nextLine());
//                    service.findPersonWithId(idPersonToFind);
//                    correctFlag = true;
//                    sc.close();
//                } catch (NumberFormatException e) {
//                    System.out.println("Id может быть только числом, попробуйте еще раз");
//                    throw new IlligalDataException("Id может быть только числом");
//                } catch (IndexOutOfBoundsException e) {
//                    System.out.println("Такого Id не существует, попробуйте еще раз");
//                    throw new IlligalDataException("Такого Id не существует");
//                }
//            } catch (RuntimeException e) {
//                correctFlag = false;
//            }
//        }
//    }
//
//    public void deletePerson() {
//        boolean correctId = false;
//        while (!correctId) {
//            try {
//                try {
//                    Scanner sc = new Scanner(System.in);
//                    System.out.print("Введите Id для удаления : ");
//                    int id = Integer.valueOf(sc.nextLine());
//                    service.deletePerson(id);
//                    service.showPersons();
//                    correctId = true;
//                    sc.close();
//                } catch (NumberFormatException e) {
//                    System.out.println("Id может быть только числом, попробуйте еще раз");
//                    throw new IlligalDataException("Id может быть только числом");
//                } catch (IndexOutOfBoundsException e) {
//                    System.out.println("Такого Id не существует, попробуйте еще раз");
//                    throw new IlligalDataException("Такого Id не существует");
//                }
//            } catch (RuntimeException e) {
//                correctId = false;
//            }
//        }
//    }
//
//    public void updatePerson() {
//        boolean correctId = false;
//        while (!correctId) {
//            try {
//                Scanner sc = new Scanner(System.in);
//                System.out.print("Введите id пользователя для обновления данных : ");
//                int id = Integer.valueOf(sc.nextLine());
//                service.updatePerson(id, readData(sc));
//                service.findPersonWithId(id);
//                correctId = true;
//            } catch (NumberFormatException e) {
//                System.out.println("Id может быть только числом, попробуйте еще раз");
//                throw new IlligalDataException("Id может быть только числом");
//            } catch (IndexOutOfBoundsException e) {
//                System.out.println("Такого Id не существует, попробуйте еще раз");
//                throw new IlligalDataException("Такого Id не существует");
//            } catch (RuntimeException e) {}
//        }
//    }

    private boolean validateString(String s) {
        if (!s.matches("\\d")) {
            return true;
        } else throw new IlligalDataException("Не корректные данные");
    }
}
