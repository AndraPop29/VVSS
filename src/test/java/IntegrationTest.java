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

public class IntegrationTest {
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

//    @Test
//    public void testGetEntriesForInvalidEntryTypeAddedBigBang() {
//        String name = "Andra";
//        memberController.addMember(new Member(name, 15));
//        String type = "c";
//        int value = 100;
//        int memberId = 15;
//        entryController.addEntry(new Entry(22, type, value, memberId));
//        Assert.assertEquals(new ArrayList<>(), entryController.getEntriesFor(memberId));
//    }

    @Test
    public void testAddValidEntry() {
        String type = "cost";

        int value = 100;
        int memberId = 1;

        String result = entryController.addEntry(new Entry(22, type, value, memberId));
        Assert.assertNull(result);

    }

    @Test
    public void testAddInvalidEntryType() {
        String type = "ana";
        int value = 50;
        int memberId = 1;

        String result = entryController.addEntry(new Entry(101, type, value, memberId));
        Assert.assertNotNull(result);

    }

    @Test
    public void testAddInvalidEntryId() {
        String type = "cost";
        int value = 50;
        int memberId = 1;

        String result = entryController.addEntry(new Entry(1, type, value, memberId));
        Assert.assertNotNull(result);

    }


    @Test
    public void testAddMemberValid() {
        //   assert(true == true);
        // Given
        String name = "Andra";

        // When
        String result = memberController.addMember(new Member(name, 15));

        // Then
        Assert.assertNull(result);
    }

    @Test
    public void testAddMemberInvalidId() {
        // Given
        String name = "Ana";
        int newId = 1;

        // When
        String result = memberController.addMember(new Member(name, newId));

        // Then
        Assert.assertNotNull(result);
    }

    @Test
    public void testAddMemberInvalidName() {
        // Given
        String name = "An4";

        // When
        String result = memberController.addMember(new Member(name, 102));

        // Then
        Assert.assertNotNull(result);
    }

    @Test
    public void BigBangAllValid() { // valid member, valid entry
        testAddMemberValid();
        testAddValidEntry();
        testGetEntriesForValidId();
    }

    @Test
    public void BigBangInvalidMemberId()  { // invalid member, valid entry
        testAddMemberInvalidId();
        testAddValidEntry();
        testGetEntriesForValidId();
    }

    @Test
    public void BigBangInvalidEntry()  { // valid member, invalid entry
        testAddMemberValid();
        testAddInvalidEntryType();
        testGetEntriesForValidId();
    }

    @Test
    public void BigBangInvalidMemberAndEntry()  { // invalid member, invalid entry
        testAddMemberInvalidName();
        testAddInvalidEntryType();
        testGetEntriesForValidId();
    }
}