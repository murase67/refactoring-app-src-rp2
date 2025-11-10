package jp.co.sss.crud.dto;

public class Department {

	private Integer deptId;
	private String deptName;

	public Department(Integer deptId, String deptName) {
		this.deptId = deptId;
		this.deptName = deptName;
	}

	public Department() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}
