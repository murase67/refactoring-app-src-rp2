package jp.co.sss.crud.main;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.dto.Department;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.IllegalInputException;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeBirthdayReader;
import jp.co.sss.crud.io.EmployeeDeptIdReader;
import jp.co.sss.crud.io.EmployeeEmpIdReader;
import jp.co.sss.crud.io.EmployeeGenderReader;
import jp.co.sss.crud.io.EmployeeNameReader;
import jp.co.sss.crud.io.IConsoleReader;
import jp.co.sss.crud.io.MenuNoReader;
import jp.co.sss.crud.service.EmployeeAllFindService;
import jp.co.sss.crud.service.EmployeeDeleteService;
import jp.co.sss.crud.service.EmployeeFindByDeptIdService;
import jp.co.sss.crud.service.EmployeeFindByEmpNameService;
import jp.co.sss.crud.service.EmployeeRegisterService;
import jp.co.sss.crud.service.EmployeeUpdateService;
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
		
		MenuNoReader menuNoReader = new MenuNoReader();
		IConsoleReader nameReader = new EmployeeNameReader();
		IConsoleReader genderReader = new EmployeeGenderReader();
		IConsoleReader birthdayReader = new EmployeeBirthdayReader();
		IConsoleReader deptReader = new EmployeeDeptIdReader();
		IConsoleReader deptIdReader = new EmployeeDeptIdReader();
		IConsoleReader empIdReader = new EmployeeEmpIdReader();

		int menuNo = 0;

		do {
			try {
			// メニューの表示
			ConsoleWriter.showMenu();
			menuNo = (int) menuNoReader.input();

			// 機能の呼出
			switch (menuNo) {
			
			case 1:
				// 社員情報を全件表示
				EmployeeAllFindService.execute();
				break;

			case 2:
				// 社員名検索
				System.out.println(ConstantMsg.EMP_NAME);
				String searchWord = (String) nameReader.input();
				
				EmployeeFindByEmpNameService.execute(searchWord);
				break;

			case 3:
				// 部署ID検索
				System.out.println(ConstantMsg.DEPT_ID);
				Integer inputDeptId = (Integer) deptIdReader.input();
				
				EmployeeFindByDeptIdService.execute(inputDeptId);
				break;

			case 4:
				// 登録
				System.out.print(ConstantMsg.EMP_NAME);
				String empName = (String) nameReader.input();
				System.out.print(ConstantMsg.GENDER);
				Integer gender = (Integer) genderReader.input();
				System.out.print(ConstantMsg.BIRTHDAY);
				String birthday = (String) birthdayReader.input();
				System.out.print(ConstantMsg.DEPT_ID);
				Integer deptId = (Integer) deptReader.input();
				
				EmployeeRegisterService.execute(empName, gender, birthday, deptId);
				break;

			case 5:
				// 更新
				Employee employee = new Employee();
				System.out.print(ConstantMsg.UPDATE_EMP_ID_MSG);
				employee.setEmpId((Integer) empIdReader.input());
				System.out.print(ConstantMsg.EMP_NAME);
				employee.setEmpName((String) nameReader.input());
				System.out.print(ConstantMsg.GENDER);
				employee.setGender((Integer) genderReader.input());
				System.out.print(ConstantMsg.BIRTHDAY);
				employee.setBirthday((String) birthdayReader.input());
				System.out.print(ConstantMsg.DEPT_ID);
				Integer DeptId = (Integer) deptReader.input();
				employee.setDepartment(new Department(DeptId,null));

				EmployeeUpdateService.execute(employee);
				break;

			case 6:
				// 削除する社員IDを入力
				System.out.print(ConstantMsg.DELETE_EMP_ID_MSG);
				Integer deleteInputEmpId = (Integer) empIdReader.input();
				
				EmployeeDeleteService.execute(deleteInputEmpId);
				break;
			}
		}catch(IllegalInputException e){
			System.out.println(e.getMessage());
			System.out.println();	
			continue;
		}catch(SystemErrorException e){
			System.out.println(e.getMessage());
			e.printStackTrace();
			break;
		}
		} while (menuNo != 7);
		ConsoleWriter.showSystemEndMsg();
	}
}
