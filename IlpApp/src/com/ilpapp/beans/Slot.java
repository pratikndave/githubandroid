package com.ilpapp.beans;

import java.io.Serializable;

public class Slot implements Serializable {
	
	private String sessionName;
	private String allocatedFaculty;
	private String allocatedRoom;
	
	
	
	public Slot(String sessionName, String allocatedFaculty,
			String allocatedRoom) {

		this.sessionName = sessionName;
		this.allocatedFaculty = allocatedFaculty;
		this.allocatedRoom = allocatedRoom;
	}

	public String getSessionName() {
		return sessionName;
	}
	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}
	public String getAllocatedFaculty() {
		return allocatedFaculty;
	}
	public void setAllocatedFaculty(String allocatedFaculty) {
		this.allocatedFaculty = allocatedFaculty;
	}
	public String getAllocatedRoom() {
		return allocatedRoom;
	}
	public void setAllocatedRoom(String allocatedRoom) {
		this.allocatedRoom = allocatedRoom;
	}
	
	

}
