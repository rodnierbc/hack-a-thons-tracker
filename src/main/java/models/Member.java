package models;

import java.util.ArrayList;

public class Member {
    private String name;
    private String email;
    private String education;
    private int id;
    private static int idController = 0;

    public Member(String name, String email, String education){
        this.name = name;
        this.email = email;
        this.education = education;
        this.id = idController;
        idController ++;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getEducation() {
        return education;
    }

    public int getId() {
        return id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEducation(String education) {
        this.education = education;
    }
    public static int getIdController(){
        return idController;
    }
}
