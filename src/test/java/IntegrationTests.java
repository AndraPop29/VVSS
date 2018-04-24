import controller.EntryController;
import controller.MemberController;
import model.Entry;
import model.Member;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import repository.EntryRepository;
import repository.MemberRepository;

import java.util.ArrayList;
import java.util.List;

public class IntegrationTests {
    private EntryRepository entryRepo;
    private MemberRepository memberRepo;
    private EntryController entryController;
    private MemberController memberController;

    @Before
    public void init() {
        memberRepo = new MemberRepository("membersF.txt");
        entryRepo = new EntryRepository("budgetF.txt");
        memberController = new MemberController(memberRepo);
        entryController = new EntryController(entryRepo, memberRepo);
    }

    @Test
    public void testGetEntriesForValidId() {
        int memberId = 1;
        List<Entry> entries = entryController.getEntriesFor(memberId);
        Assert.assertNotNull(entries);
    }

    @Test
    public void testGetEntriesForValidIdBigBang() {
        String name = "Andra";
        memberController.addMember(new Member(name, 15));
        String type = "cost";
        int value = 100;
        int memberId = 15;
        entryController.addEntry(new Entry(22, type, value, memberId));
        Assert.assertNotNull(entryController.getEntriesFor(memberId));
    }

    @Test
    public void testGetEntriesForInvalidIdBigBang() {
        String name = "Andra";
        memberController.addMember(new Member(name, 15));
        String type = "cost";
        int value = 100;
        int memberId = 100;
        entryController.addEntry(new Entry(22, type, value, memberId));
        Assert.assertNull(entryController.getEntriesFor(memberId));

    }

    @Test
    public void testGetEntriesForInvalidEntryTypeAddedBigBang() {
        String name = "Andra";
        memberController.addMember(new Member(name, 15));
        String type = "c";
        int value = 100;
        int memberId = 15;
        entryController.addEntry(new Entry(22, type, value, memberId));
        Assert.assertEquals(new ArrayList<>(), entryController.getEntriesFor(memberId));
    }
}