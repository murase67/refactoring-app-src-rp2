package jp.co.sss.crud.io;

import java.util.List;

import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.util.ConstantMsg;

public class ConsoleWriter {
	
	public static void showMenu() {
		System.out.println("");
		System.out.println(ConstantMsg.MENU_TITLE);
		System.out.println(ConstantMsg.MENU_FIND_ALL);
		System.out.println(ConstantMsg.MENU_FIND_EMP_NAME);
		System.out.println(ConstantMsg.MENU_FIND_DEPT_ID);
		System.out.println(ConstantMsg.MENU_INSERT);
		System.out.println(ConstantMsg.MENU_UPDATE);
		System.out.println(ConstantMsg.MENU_DELETE);
		System.out.println(ConstantMsg.MENU_END);
		System.out.print(ConstantMsg.MENU_MESSAGE);
	}

	public static void showEmployees(List<Employee> employees) {

		if (employees.isEmpty()) {
			showNonExistTarget();
		} else {
			showHeader();
			for (Employee employee : employees) {
				System.out.println(employee);
			}
		}
	}

	public static void showNonExistTarget() {
		System.out.println(ConstantMsg.NOT_EMPLOYEE_MSG);
	}

	public static void showHeader() {
		System.out.println(ConstantMsg.TABLE_COLUMN_NAME);
	}

	public static void showInsertComplate() {
		System.out.println(ConstantMsg.INSERT_CONPLATE_MSG);
	}
	
	public static void showUpdateComplate() {
		System.out.println(ConstantMsg.UPDATE_COMPLATE_MSG);
	}
	
	public static void showDeleteComplate() {
		System.out.println(ConstantMsg.DELETE_CONPLATE_MSG);
	}
	
	public static void showSystemEndMsg() {
		System.out.println(ConstantMsg.SYSTEM_END_MSG);
	}
}
