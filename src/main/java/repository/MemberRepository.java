package repository;

import java.io.BufferedReader;

import model.*;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import exceptions.MemberAlreadyExistsException;

public class MemberRepository {
	private List<Member> members = new ArrayList<Member>();

	private String filename;

	public MemberRepository(String fileName) {
		this.filename = fileName;
		readFromFile();
	}

	private String validateName(String name){
		if  (name.length() >= 256) {
			return "Name can not be longer than 256";
		}

		if(!name.equals("") && !name.equals(" ")){
			for(int i=0;i<name.length();i++){
				if((!Character.isUpperCase(name.charAt(i))) && (!Character.isLowerCase(name.charAt(i))) && (!Character.isSpaceChar(name.charAt(i)))){
					return "Invalid character: " + name.charAt(i);
				}
			}
			return null;
		}else{
			return "Name or address cannot be empty!";
		}
	}

	public void addMember(Member m) throws Exception {
		if(validateName(m.getName()) != null) {
			throw new Exception("Invalid name");
		}
		if (checkIfExists(m.getId())) {
			throw new MemberAlreadyExistsException();
		} else {
			members.add(m);
		}
	}

	public boolean checkIfExists(int idOfMember) {
		Optional<Member> tempMember = members.stream().filter(m -> m.getId() == idOfMember).findFirst();
		return tempMember.isPresent();
	}

	@SuppressWarnings("resource")
	private void readFromFile() {
		try {
			FileReader fileReader = null;
			BufferedReader bufferedReader = null;
			String currentLine = null;

			fileReader = new FileReader(this.filename);
			bufferedReader = new BufferedReader(fileReader);

			while ((currentLine = bufferedReader.readLine()) != null) {
				String line[] = currentLine.split(";");
				Member m = new Member(line[0], Integer.parseInt(line[1]));
				this.members.add(m);
			}
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}

}
