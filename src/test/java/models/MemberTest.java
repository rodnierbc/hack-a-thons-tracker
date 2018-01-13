package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import java.util.ArrayList;

public class MemberTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void NewMemberObjectGetsCorrectlyCreated_true() throws Exception {
        Member member = new Member("Rodnier Borrego", "rodnierbc@gmail.com", "Epicodus student");
        assertEquals(true, member instanceof Member);
        assertTrue(member.getId() == Member.getIdController()-1);
    }
    @Test
    public void findMember_Member() throws Exception {
        Member member1 = new Member("Rodnier Borrego", "rodnierbc@gmail.com", "Epicodus student");
        Member member2 = new Member("Jhon", "jhon@gmail.com", "Epicodus student");
        ArrayList<Member> members = new ArrayList<Member>();
        members.add(member1);
        members.add(member2);
        int id = 0;
        assertTrue(Member.findMember(members,id).getId() == id);
    }
    @Test
    public void updateMember() {
        Member member = new Member("Rodnier", "rodnierbc89@gmail.com", "Epicodus Student");
        member.update("Rodnier Borrego Clavero", "rodnierbc89@gmail.com", "Epicodus Student");
        assertEquals(true, member.getName().equals("Rodnier Borrego Clavero"));
    }


}