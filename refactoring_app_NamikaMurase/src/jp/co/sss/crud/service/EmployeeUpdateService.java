package jp.co.sss.crud.service;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;

public class EmployeeUpdateService {

	/**
	 * 社員情報を更新
	 * 
	 * @param employee 更新する社員情報
	 * @throws SystemErrorException
	 */
	public static void execute(Employee employee) throws SystemErrorException{

		EmployeeDAO.update(employee);
		ConsoleWriter.showUpdateComplate();
	}

}
