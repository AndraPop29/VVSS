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
				this.entryRepository.addEntry(oneEntry);
				return null;
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
