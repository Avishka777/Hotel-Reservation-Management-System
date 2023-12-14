package com.EventPack;

/*
This is a model class represents a Wedding entity
*/
public class Wedding {
	protected int id;
	protected String fullName;
	protected String phone;
	protected String email;
	protected int attendees;
	protected String additional;
	protected int uid;
	
	public Wedding() {}

	public Wedding(int id, String fullName, String phone, String email, int attendees, String additional) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.phone = phone;
		this.email = email;
		this.attendees = attendees;
		this.additional = additional;
		
	}

	public Wedding(String fullName, String phone, String email, int attendees, String additional,int uid) {
		super();
		this.fullName = fullName;
		this.phone = phone;
		this.email = email;
		this.attendees = attendees;
		this.additional = additional;
		this.uid = uid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAttendees() {
		return attendees;
	}

	public void setAttendees(int attendees) {
		this.attendees = attendees;
	}

	public String getAdditional() {
		return additional;
	}

	public void setAdditional(String additional) {
		this.additional = additional;
	}
}
