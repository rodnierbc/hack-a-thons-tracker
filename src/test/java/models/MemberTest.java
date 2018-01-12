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

}