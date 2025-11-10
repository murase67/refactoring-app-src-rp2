package jp.co.sss.crud.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.util.ConstantMsg;

public class SearchForEmpNameService {
	
	public static void execute() throws ClassNotFoundException, SQLException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		 List<Employee> searchedEmployees = new ArrayList<Employee>();

		System.out.print(ConstantMsg.EMP_NAME);
		searchedEmployees = EmployeeDAO.findByEmpName();

		ConsoleWriter.showEmployees(searchedEmployees);
	}

}
