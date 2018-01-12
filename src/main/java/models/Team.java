package models;

import java.util.ArrayList;

public class Team {
    private String name;
    private String description;
    private ArrayList<Member> members;
    private int id;
    private static ArrayList<Team> teams = new ArrayList<Team>();
    private static int idController = 0;

    public Team(String name, String description){
        this.name = name;
        this.description = description;
        this.members = new ArrayList<Member>();
        this.id = idController;
        teams.add(this);
        idController++;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public static ArrayList<Team> getTeams() {
        return teams;
    }

    public static int getIdController() {
        return idController;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public static void clearTeams(){
        teams.clear();
    }
    public static Team findById(int id){
        Team team= null;
        for(int i = 0; i<teams.size();i++){
            if(teams.get(i).getId() == id){
                team = teams.get(i);
                i = teams.size();
            }
        }
        return team;
    }
}
