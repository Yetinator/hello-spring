package org.launchcode.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity  //import form java persistence
@Table(name = "hellolog")
public class HelloLog {
	
	private String name;
	private Date timestamp;
	private int uid;
	
	public HelloLog(String name){
		this.name = name;
		timestamp = new Date();
	}
	
	//no arg constructor
	public HelloLog(){}
	
	
	@Id  // primary key
	@GeneratedValue
	@NotNull
	@Column(name = "uid", unique = true)
	public int getUid() {
		return uid;
	}

	
	public void setUid(int uid) {
		this.uid = uid;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}
	
	@NotNull
	@Column(name = "timestamp")
	public Date getTimestamp() {
		return timestamp;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
}
