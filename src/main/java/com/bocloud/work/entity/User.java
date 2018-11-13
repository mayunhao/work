package com.bocloud.work.entity;

/*
 * 用户实体类
 * 
 */

@SuppressWarnings("serial")
public class User extends SuperEntity<User> {
	

	private String name;
	private Long pwd;
	private Long department_id;
	private Boolean status; // 状态 1在职 0离职
	private Long job_id;
	private Long email;
	private Long salarya;
	private Long salaryb;
	private Long salaryc;
	private Long salaryd;
	private Long salarye;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getPwd() {
		return pwd;
	}
	public void setPwd(Long pwd) {
		this.pwd = pwd;
	}
	public Long getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(Long department_id) {
		this.department_id = department_id;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Long getJob_id() {
		return job_id;
	}
	public void setJob_id(Long job_id) {
		this.job_id = job_id;
	}
	public Long getEmail() {
		return email;
	}
	public void setEmail(Long email) {
		this.email = email;
	}
	public Long getSalarya() {
		return salarya;
	}
	public void setSalarya(Long salarya) {
		this.salarya = salarya;
	}
	public Long getSalaryb() {
		return salaryb;
	}
	public void setSalaryb(Long salaryb) {
		this.salaryb = salaryb;
	}
	public Long getSalaryc() {
		return salaryc;
	}
	public void setSalaryc(Long salaryc) {
		this.salaryc = salaryc;
	}
	public Long getSalaryd() {
		return salaryd;
	}
	public void setSalaryd(Long salaryd) {
		this.salaryd = salaryd;
	}
	public Long getSalarye() {
		return salarye;
	}
	public void setSalarye(Long salarye) {
		this.salarye = salarye;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", pwd=" + pwd + ", department_id=" + department_id + ", status=" + status
				+ ", job_id=" + job_id + ", email=" + email + ", salarya=" + salarya + ", salaryb=" + salaryb
				+ ", salaryc=" + salaryc + ", salaryd=" + salaryd + ", salarye=" + salarye + "]";
	}


}
