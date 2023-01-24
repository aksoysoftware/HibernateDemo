package com.hibernatedemo;

import javax.persistence.*;

@Entity 
@Table(name="actor")

public class actor {
	@Id
	@Column(name="actor_id")
	private int actor_id;
	
	
	@Column(name="first_name")
	private String first_name;
	
	
	@Column(name="last_name")
	private String last_name;
	
	public int getId() {
		return actor_id;
	}
	public void setId(int id) {
		this.actor_id = id;
	}
	public String getFirst_Name() {
		return first_name;
	}
	public void setFirst_Name( String first_name) {
		this.first_name = first_name;
	}
	public String getLast_Name() {
		return last_name;
	}
	public void setLast_Name( String last_name) {
		this.last_name = last_name;
	}
	

}
