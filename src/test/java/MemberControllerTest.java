import controller.MemberController;
import model.Member;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import repository.MemberRepository;

import java.util.Collections;
import java.util.Random;

public class MemberControllerTest {
    private MemberRepository repo;
    private MemberController controller;
    private int id;

    @Before
    public void init() {
        repo = new MemberRepository("membersF.txt");
        controller = new MemberController(repo);
        Random rnd = new Random();
        id = rnd.nextInt(100) + 1;
    }

    @Test
    public void testAddMemberValid() {
     //   assert(true == true);
        // Given
        String name = "Andra";

        // When
        String result = controller.addMember(new Member(name, id));

        // Then
        Assert.assertNull(result);
    }

    @Test
    public void testAddClientInvalidId() {
        // Given
        String name = "Ana";
        int newId = 1;

        // When
        String result = controller.addMember(new Member(name, newId));

        // Then
        Assert.assertNotNull(result);
    }

    @Test
    public void testAddMemberInvalidName() {
        // Given
        String name = "An4";

        // When
        String result = controller.addMember(new Member(name, id));

        // Then
        Assert.assertNotNull(result);
    }

    @Test
    public void testAddMemberInvalidNameLength() {
        String name = String.join("", Collections.nCopies(256, "a"));

        String result = controller.addMember(new Member(name, id));

        Assert.assertNotNull(result);
    }

    @Test
    public void testAddMemberEmptyName() {
        String name = "";

        Assert.assertNotNull(controller.addMember(new Member(name, id)));
    }

    @Test
    public void testAddMemberIdTooLarge() {
        // Given
        String name = "Ana";
        int newId = 512;

        // When
        String result = controller.addMember(new Member(name, newId));

        // Then
        Assert.assertNotNull(result);
    }

    @Test
    public void testAddMemberIdBelowZero() {
        // Given
        String name = "Ana";
        int newId = -1;

        // When
        String result = controller.addMember(new Member(name, newId));

        // Then
        Assert.assertNotNull(result);
    }


}
