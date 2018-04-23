package controller;

import java.util.List;

import exceptions.MemberDoesNotExistException;
import model.Entry;
import repository.EntryRepository;
import repository.MemberRepository;

public class EntryController {

    private EntryRepository entryRepository;
    private MemberRepository memberRepository;

    public EntryController(EntryRepository entryRepository, MemberRepository memberRepository) {
        this.entryRepository = entryRepository;
        this.memberRepository = memberRepository;
    }

    public String addEntry(Entry oneEntry) {
        if (memberRepository.checkIfExists(oneEntry.getIdMember())) {
            if (oneEntry.getType().equals("cost") || oneEntry.getType().equals("income")) {
                if (!entryRepository.checkIfExists(oneEntry.getId())) {
                    this.entryRepository.addEntry(oneEntry);
                    return null;
                }
                else return "Entry with id already exists";
            }
            else return "Entry type is not valid";

        } else {
            return "Member does not exist";
        }
    }

    public List<Entry> allEntries() {
        return this.entryRepository.getAllEntries();
    }

    public List<Entry> getEntriesFor(int idMember) throws MemberDoesNotExistException {
        if (memberRepository.checkIfExists(idMember)) {
            return entryRepository.findByIdMember(idMember);
        } else {
            throw new MemberDoesNotExistException();
        }
    }

}
