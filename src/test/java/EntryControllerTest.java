import controller.EntryController;
import model.Entry;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import repository.EntryRepository;
import repository.MemberRepository;

import java.util.Random;

public class EntryControllerTest {
    private EntryRepository entryRepo;
    private MemberRepository memberRepo;
    private EntryController controller;
    private int id;

    @Before
    public void init() {
        memberRepo = new MemberRepository("membersF.txt");
        entryRepo = new EntryRepository("budgetF.txt");
        controller = new EntryController(entryRepo, memberRepo);
        Random rnd = new Random();
        id = rnd.nextInt(100) + 1;
    }

    @Test
    public void testAddValidEntry() {
        String type = "cost";
        int value = 100;
        int memberId = 1;

        String result = controller.addEntry(new Entry(id, type, value, memberId));
        Assert.assertNull(result);

    }


    @Test
    public void testAddInvalidMemberIdEntry() {
        String type = "income";
        int value = 50;
        int memberId = 100; // does not exist

        String result = controller.addEntry(new Entry(id, type, value, memberId));
        Assert.assertNotNull(result);

    }
}
