package org.gorbunov.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    private Integer id;
    private String name;
    private Integer age;

//    public Pet(Integer id, String name, Integer age) {
//        this.id = id;
//        this.name = name;
//        this.age = age;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    @Override
//    public String toString() {
//        return "Pet{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", age=" + age +
//                '}';
//    }
}

