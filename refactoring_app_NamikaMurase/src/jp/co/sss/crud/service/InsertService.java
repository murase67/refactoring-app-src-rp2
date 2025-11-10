package jp.co.sss.crud.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.util.ConstantMsg;

public class InsertService {

	public static void execute() throws ClassNotFoundException, SQLException, IOException, ParseException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print(ConstantMsg.EMP_NAME);
		String empName = br.readLine();
		System.out.print(ConstantMsg.GENDER);
		String gender = br.readLine();
		System.out.print(ConstantMsg.BIRTHDAY);
		String birthday = br.readLine();
		System.out.print(ConstantMsg.DEPT_ID);
		String deptId = br.readLine();

		// 登録機能の呼出
		EmployeeDAO.insert(empName, gender, birthday, deptId);
		
		ConsoleWriter.showInsertComplate();
	}

}
