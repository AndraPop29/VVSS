package repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import model.Entry;
import model.Member;

public class EntryRepository {

	private List<Entry> entries = new ArrayList<Entry>();
	private String fileName;

	public void addEntry(Entry e) {
		entries.add(e);
	}

	public List<Entry> getAllEntries() {
		return entries;
	}

	public EntryRepository(String fileName) {
		this.fileName = fileName;
		readFromFile();
	}
	public boolean checkIfExists(int idOfEntry) {
		Optional<Entry> tempMember = entries.stream().filter(m -> m.getId() == idOfEntry).findFirst();
		return tempMember.isPresent();
	}

	public List<Entry> findByIdMember(int idMember) {
		return entries.stream().filter(m -> m.getIdMember() == idMember).collect(Collectors.toList());
	}
	@SuppressWarnings("resource")
	private void readFromFile() {
		try {
			FileReader fileReaderEntry = new FileReader(fileName);
			BufferedReader bufferedReaderEntry = new BufferedReader(fileReaderEntry);
			String currentLineEntry = null;

			while ((currentLineEntry = bufferedReaderEntry.readLine()) != null) {
				String line[] = currentLineEntry.split(";");
				String typeOfEntry = line[0];
				int valueEntry = Integer.parseInt(line[1]);
				int idEntryMember = Integer.parseInt(line[2]);
				Entry e = new Entry(entries.size() + 1, typeOfEntry, valueEntry, idEntryMember);
				this.entries.add(e);
			}
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}

}
