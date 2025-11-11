package jp.co.sss.crud.service;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;

public class EmployeeRegisterService {

	/**
	 * 社員情報を登録
	 * 
	 * @param empName 社員名
	 * @param gender 性別
	 * @param birthday 生年月日
	 * @param deptId 部署ID
	 * 
	 * @throws SystemErrorException
	 */
	public static void execute(String empName, Integer gender, String birthday, Integer deptId)  throws SystemErrorException{

		EmployeeDAO.insert(empName, gender, birthday, deptId);
		ConsoleWriter.showInsertComplate();
	}

}
