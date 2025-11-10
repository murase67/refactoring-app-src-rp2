package jp.co.sss.crud.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.db.DBController;
import jp.co.sss.crud.util.ConstantMsg;

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
			System.out.println(ConstantMsg.MENU_TITLE);
			System.out.println(ConstantMsg.MENU_FIND_ALL);
			System.out.println(ConstantMsg.MENU_FIND_EMP_NAME);
			System.out.println(ConstantMsg.MENU_FIND_DEPT_ID);
			System.out.println(ConstantMsg.MENU_INSERT);
			System.out.println(ConstantMsg.MENU_UPDATE);
			System.out.println(ConstantMsg.MENU_DELETE);
			System.out.println(ConstantMsg.MENU_END);
			System.out.print(ConstantMsg.MENU_MESSAGE);

			// メニュー番号の入力
			String menuNoStr = br.readLine();
			menuNo = Integer.parseInt(menuNoStr);

			// 機能の呼出
			switch (menuNo) {
			case 1:
				// 全件表示機能の呼出
				DBController.findAllEmp();
				break;

			case 2:
				// 社員名検索
				System.out.print(ConstantMsg.EMP_NAME);

				// 検索機能の呼出
				DBController.findEmpName();
				break;

			case 3:
				// 検索する部署IDを入力
				System.out.print(ConstantMsg.DEPT_ID);
				String inputDeptId = br.readLine();

				// 検索機能の呼出
				DBController.findDeptId(inputDeptId);
				break;

			case 4:
				// 登録する値を入力
				System.out.print(ConstantMsg.EMP_NAME);
				String empName = br.readLine();
				System.out.print(ConstantMsg.GENDER);
				String gender = br.readLine();
				System.out.print(ConstantMsg.BIRTHDAY);
				String birthday = br.readLine();
				System.out.print(ConstantMsg.DEPT_ID);
				String deptId = br.readLine();

				// 登録機能の呼出
				DBController.insert(empName, gender, birthday, deptId);
				break;

			case 5:
				// 更新する社員IDを入力
				System.out.print(ConstantMsg.UPDATE_DEPT_ID_MSG);

				// 更新する値を入力する
				String inputEmpId = br.readLine();
				Integer.parseInt(inputEmpId);

				// 更新機能の呼出
				DBController.update(inputEmpId);
				System.out.println(ConstantMsg.UPDATE_COMPLATE_MSG);

				break;

			case 6:
				// 削除する社員IDを入力
				System.out.print(ConstantMsg.DELETE_DEPT_ID_MSG);

				// 削除機能の呼出
				DBController.delete();
				break;

			}
		} while (menuNo != 7);
		System.out.println(ConstantMsg.SYSTEM_END_MSG);
	}
}
