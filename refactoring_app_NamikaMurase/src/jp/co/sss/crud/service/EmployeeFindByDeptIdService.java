package jp.co.sss.crud.service;

import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;

public class EmployeeFindByDeptIdService {

	/**
	 * 部署IDで社員情報を検索
	 * 
	 * @param inputDeptId 検索する部署ID
	 * @throws SystemErrorException
	 */
	public static void execute(Integer inputDeptId) throws SystemErrorException{
		
		 List<Employee> searchedEmployees = EmployeeDAO.findByDeptId(inputDeptId);
		ConsoleWriter.showEmployees(searchedEmployees);
	}

}
