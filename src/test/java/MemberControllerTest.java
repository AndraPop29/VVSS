import controller.MemberController;
import model.Member;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import repository.MemberRepository;

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
        int id = rnd.nextInt(100) + 1;
    }

    @Test
    public void testAddMemberValid() {
     //   assert(true == true);
        // Given
        String name = "Andrei";

        // When
        String result = controller.addMember(new Member(name, id));

        // Then
        Assert.assertNull(result);
    }

}
