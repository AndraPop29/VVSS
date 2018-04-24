import controller.EntryController;
import model.Entry;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import repository.EntryRepository;
import repository.MemberRepository;

import java.util.List;
import java.util.Random;

public class IntegrationTests {
    private EntryRepository entryRepo;
    private MemberRepository memberRepo;
    private EntryController controller;

    @Before
    public void init() {
        memberRepo = new MemberRepository("membersF.txt");
        entryRepo = new EntryRepository("budgetF.txt");
        controller = new EntryController(entryRepo, memberRepo);

    }

    @Test
    public void testGetEntriesForValidId() {
        int memberId = 1;

        List<Entry>  entries = controller.getEntriesFor(memberId);
        Assert.assertNotNull(entries);
    }
}
