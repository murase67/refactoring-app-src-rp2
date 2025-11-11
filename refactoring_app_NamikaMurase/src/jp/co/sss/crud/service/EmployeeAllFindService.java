package jp.co.sss.crud.service;

import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;

public class EmployeeAllFindService {

	/**
	 * すべての社員情報を検索
	 * 
	 * @throws SystemErrorException
	 */
	public static void execute() throws SystemErrorException{
		
		 List<Employee> searchedEmployees = EmployeeDAO.findAll();
		ConsoleWriter.showEmployees(searchedEmployees);
	}

}
