package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import java.util.ArrayList;


public class TeamTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        Team.clearTeams();
    }

    @Test
    public void NewTeamObjectGetsCorrectlyCreated_true() throws Exception {
        Team team = new Team("Epicodus Androide", "Epicodus team");
        Member member = new Member("Rodnier", "rodnierbc@gmail.com","epicodus student");
        team.getMembers().add(member);
        assertEquals(true, team instanceof Team);
        assertTrue(team.getId() == team.getIdController()-1);
        assertTrue(team.getMembers().size() == 1);
    }
    @Test
    public void FindTeamByID_Applicant() {
        Team team1 = new Team("Epicodus Androide 1", "Epicodus team 1");
        Team team2 = new Team("Epicodus Androide 2", "Epicodus team 2");
        assertEquals(true, Team.findById(0).getId() == Team.getTeams().get(0).getId());
    }
}