package com.bocloud.work.entity;

@SuppressWarnings("serial")
public class Project extends SuperEntity<User> {

	private String name;
	private String type;
	private String leader;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLeader() {
		return leader;
	}
	public void setLeader(String leader) {
		this.leader = leader;
	}
	@Override
	public String toString() {
		return "Project [name=" + name + ", type=" + type + ", leader=" + leader + "]";
	}
	
	

}
