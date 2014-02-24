package com.ilpapp.beans;

import java.io.Serializable;
import java.util.Date;

public class DailySchedule implements Serializable{
	
	private Date date;
	private Slot slotA;
	private Slot slotB;
	private Slot slotC;
	private Slot slotD;
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Slot getSlotA() {
		return slotA;
	}
	public void setSlotA(Slot slotA) {
		this.slotA = slotA;
	}
	public Slot getSlotB() {
		return slotB;
	}
	public void setSlotB(Slot slotB) {
		this.slotB = slotB;
	}
	public Slot getSlotC() {
		return slotC;
	}
	public void setSlotC(Slot slotC) {
		this.slotC = slotC;
	}
	public Slot getSlotD() {
		return slotD;
	}
	public void setSlotD(Slot slotD) {
		this.slotD = slotD;
	}
	
	

}
