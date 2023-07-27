package in.ineuron.dto;

import java.io.Serializable;

public class Student implements Serializable {
    private Integer sid ;
    private String name ;


    private String email;
    private String city ;
    private String country ;
    public Student(){
//        System.out.println("Student Object created successfully.");
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getSid() {
        return sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }


}
