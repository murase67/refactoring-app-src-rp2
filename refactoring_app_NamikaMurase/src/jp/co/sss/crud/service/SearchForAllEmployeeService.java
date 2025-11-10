package jp.co.sss.crud.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.io.ConsoleWriter;

public class SearchForAllEmployeeService {

	public static void execute() throws ClassNotFoundException, SQLException, IOException {
		
		 List<Employee> searchedEmployees = new ArrayList<Employee>();

		searchedEmployees = EmployeeDAO.findAll();

		ConsoleWriter.showEmployees(searchedEmployees);
	}

}
