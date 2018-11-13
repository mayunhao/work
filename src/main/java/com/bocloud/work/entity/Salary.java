package com.bocloud.work.entity;

/*
 * 薪资实体类
 * 
 */

@SuppressWarnings("serial")
public class Salary extends SuperEntity<Salary> {


	private Long salarya;
	private Long salaryb;
	private Long salaryc;
	private Long salaryd;
	private Long salarye;
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
		return "Salary [salarya=" + salarya + ", salaryb=" + salaryb + ", salaryc=" + salaryc + ", salaryd=" + salaryd
				+ ", salarye=" + salarye + "]";
	}


}
