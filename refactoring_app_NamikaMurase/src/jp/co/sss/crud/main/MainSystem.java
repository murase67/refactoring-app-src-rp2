package jp.co.sss.crud.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.service.DeleteService;
import jp.co.sss.crud.service.InsertService;
import jp.co.sss.crud.service.SearchForAllEmployeeService;
import jp.co.sss.crud.service.SearchForDeptIdService;
import jp.co.sss.crud.service.SearchForEmpNameService;
import jp.co.sss.crud.service.UpdateService;

/**
 * 社員情報管理システム開始クラス 社員情報管理システムはこのクラスから始まる。<br/>
 * メニュー画面を表示する。
 *
 * @author System Shared
 *
 */
public class MainSystem {
	/**
	 * 社員管理システムを起動
	 *
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException, ParseException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int menuNo = 0;

		do {
			// メニューの表示
			ConsoleWriter.showMenu();

			// メニュー番号の入力
			String menuNoStr = br.readLine();
			menuNo = Integer.parseInt(menuNoStr);

			// 機能の呼出
			switch (menuNo) {
			case 1:
				SearchForAllEmployeeService.execute();
				break;

			case 2:
				SearchForEmpNameService.execute();
				break;

			case 3:
				SearchForDeptIdService.execute();
				break;

			case 4:
				InsertService.execute();
				break;

			case 5:
				UpdateService.execute();
				break;

			case 6:
				DeleteService.execute();
				break;
			}
		} while (menuNo != 7);
		ConsoleWriter.showSystemEndMsg();
	}
}
