package jp.co.sss.crud.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.util.ConstantMsg;

public class DeleteService {

	public static void execute() throws ClassNotFoundException, SQLException, IOException, ParseException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 削除する社員IDを入力
		System.out.print(ConstantMsg.DELETE_DEPT_ID_MSG);
		Integer InputEmpId = Integer.parseInt(br.readLine());

		// 削除機能の呼出
		EmployeeDAO.delete(InputEmpId);
		
		// 削除完了メッセージを出力
		ConsoleWriter.showDeleteComplate();
	}

}
