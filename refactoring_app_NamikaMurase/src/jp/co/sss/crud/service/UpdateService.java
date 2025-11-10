package jp.co.sss.crud.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.util.ConstantMsg;

public class UpdateService {

	public static void execute() throws ClassNotFoundException, SQLException, IOException, ParseException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 更新する社員IDを入力
		System.out.print(ConstantMsg.UPDATE_DEPT_ID_MSG);
		String inputEmpId = br.readLine();
		Integer.parseInt(inputEmpId);

		// 更新機能の呼出
		EmployeeDAO.update(inputEmpId);
		
		ConsoleWriter.showUpdateComplate();
	}

}
