package jp.co.sss.crud.dto;

import jp.co.sss.crud.util.ConstantMsg;

public class Employee {

	private Integer empId;
	private String empName;
	private Integer gender;
	private String birthday;
	private Department department;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		String gender_ja = "";
		if (this.gender == 1) {
			gender_ja = ConstantMsg.GENDER_MALE;
		} else if (this.gender == 2) {
			gender_ja = ConstantMsg.GENDER_FAMALE;
		}
		return empId + "\t" + empName + "\t" + gender_ja + "\t" + birthday
				+ "\t" + department.getDeptName();
	}

}
