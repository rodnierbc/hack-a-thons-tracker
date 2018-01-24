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
    public static Member findMember(ArrayList<Member> members, int idMember){
        Member member = null;
        for(Member memberAux: members){
            if(memberAux.getId() == idMember){
                member = memberAux;
            }
        }
        return member;
    }
    public void update(String name, String email, String education){
       this.education = education;
       this.name = name;
        this.email = email;
    }

}
