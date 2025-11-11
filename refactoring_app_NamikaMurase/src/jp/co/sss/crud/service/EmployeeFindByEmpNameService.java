package jp.co.sss.crud.service;

import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;

public class EmployeeFindByEmpNameService {
	
	/**
	 * 社員名で検索
	 * 
	 * @param searchWord 社員名の検索キーワード
	 * @throws SystemErrorException
	 */
	public static void execute(String searchWord) throws SystemErrorException{
		
		 List<Employee> searchedEmployees = EmployeeDAO.findByEmpName(searchWord);
		ConsoleWriter.showEmployees(searchedEmployees);
	}


}
