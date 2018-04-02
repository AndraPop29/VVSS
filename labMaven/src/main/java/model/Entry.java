package model;

public class Entry {
	
	private int id;
	private int value;
	private String typeEntry;// cost or income
	private int idMember;

	public Entry(int id, String typeEntry, int value, int idMember) {
		this.id = id;
		this.typeEntry = typeEntry;
		this.value = value;
		this.idMember = idMember;
	}

	public void setType(String newType) {
		typeEntry = newType;
	}

	public String getType() {
		return typeEntry;
	}

	public void setValue(int newValue) {
		this.value = newValue;
	}

	public int getValue() {
		return value;
	}

	public void setMember(int newMember) {
		this.idMember = newMember;
	}

	public int getIdMember() {
		return idMember;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String toString() {
		String e = "id=" + id + " idMember=" + this.idMember + " typeOfEntry=" + this.typeEntry + " value=" + this.value;
		return e;
	}

}
