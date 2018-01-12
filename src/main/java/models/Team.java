package models;

import java.util.ArrayList;

public class Team {
    private String name;
    private String description;
    private ArrayList<Member> members;
    private int id;
    private static ArrayList<Team> teams = new ArrayList<Team>();
    private static int idController = 0;
    

}
