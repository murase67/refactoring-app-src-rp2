package jp.co.sss.crud.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import jp.co.sss.crud.dto.Department;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;
import jp.co.sss.crud.util.ConstantSQL;

public class EmployeeDAO {

	/**
	 * 全ての社員情報を検索
	 *
	 * @throws SystemErrorException 独自例外クラス
	 */
	public static List<Employee> findAll() throws SystemErrorException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Employee> employees = new ArrayList<>();

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// ステートメントを作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_ALL_SELECT);

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			// 検索結果をDTOへ格納
			while (resultSet.next()) {
				Employee employee = new Employee();

				// DTOへの格納
				employee.setEmpId(resultSet.getInt("emp_id"));
				employee.setEmpName(resultSet.getString("emp_name"));
				employee.setGender(resultSet.getInt("gender"));
				employee.setBirthday(resultSet.getString("birthday"));
				employee.setDepartment(new Department(null, resultSet.getString("dept_name")));

				// リストへの追加
				employees.add(employee);

			}

			System.out.println("");

		} catch (ClassNotFoundException | SQLException e) {
			throw new SystemErrorException(ConstantMsg.MSG_SYSTEM_ERROR, e);
		} finally {
			// ResultSetをクローズ
			DBManager.close(resultSet);
			// Statementをクローズ
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}

		// DTOを戻す
		return employees;
	}

	/**
	 * 社員名に該当する社員情報を検索
	 * 
	 * @param searchWord 検索キーワード
	 *
	 * @throws SystemErrorException 独自例外クラス
	 */
	public static List<Employee> findByEmpName(String searchWord) throws SystemErrorException {

		List<Employee> employees = new ArrayList<>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {

			// DBに接続
			connection = DBManager.getConnection();

			// SQL文を準備
			StringBuffer sql = new StringBuffer(ConstantSQL.SQL_SELECT_BASIC);
			sql.append(ConstantSQL.SQL_SELECT_BY_EMP_NAME);

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(sql.toString());

			// 検索条件となる値をバインド
			preparedStatement.setString(1, "%" + searchWord + "%");

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				// DTO Employeeのオブジェクト生成
				Employee employee = new Employee();

				// DTOへの格納
				employee.setEmpId(resultSet.getInt("emp_id"));
				employee.setEmpName(resultSet.getString("emp_name"));
				employee.setGender(resultSet.getInt("gender"));
				employee.setBirthday(resultSet.getString("birthday"));
				employee.setDepartment(new Department(null, resultSet.getString("dept_name")));

				// リストへの追加
				employees.add(employee);

			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new SystemErrorException(ConstantMsg.MSG_SYSTEM_ERROR, e);
		} finally {
			// クローズ処理
			DBManager.close(resultSet);
			// Statementをクローズ
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}

		return employees;
	}

	/**
	 * 部署IDに該当する社員情報を検索
	 * 
	 * @param 検索する部署ID
	 *
	 * @throws SystemErrorException 独自例外クラス
	 */
	public static List<Employee> findByDeptId(Integer inputDeptId) throws SystemErrorException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		List<Employee> employees = new ArrayList<>();

		try {
			// DBに接続
			connection = DBManager.getConnection();

			// SQL文を準備
			StringBuffer sql = new StringBuffer(ConstantSQL.SQL_SELECT_BASIC);
			sql.append(ConstantSQL.SQL_SELECT_BY_DEPT_ID);

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(sql.toString());

			// 検索条件となる値をバインド
			preparedStatement.setInt(1, inputDeptId);

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();

			// 結果をDTOへ格納
			while (resultSet.next()) {
				// DTO Employeeのオブジェクト生成
				Employee employee = new Employee();

				// DTOへの格納
				employee.setEmpId(resultSet.getInt("emp_id"));
				employee.setEmpName(resultSet.getString("emp_name"));
				employee.setGender(resultSet.getInt("gender"));
				employee.setBirthday(resultSet.getString("birthday"));
				employee.setDepartment(new Department(null, resultSet.getString("dept_name")));

				// リストへの追加
				employees.add(employee);

			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new SystemErrorException(ConstantMsg.MSG_SYSTEM_ERROR, e);

		} finally {
			// クローズ処理
			DBManager.close(resultSet);
			// Statementをクローズ
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}

		return employees;
	}

	/**
	 * 社員情報を1件登録
	 * 
	 * @param empName 社員名
	 * @param gender 性別
	 * @param birthday 生年月日
	 * @param deptId 部署ID
	 * 
	 * @throws SystemErrorException 独自例外クラス
	 */
	public static void insert(String empName, Integer gender, String birthday, Integer deptId)
			throws SystemErrorException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			// DBに接続
			connection = DBManager.getConnection();

			// ステートメントを作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_INSERT);

			// 入力値をバインド
			preparedStatement.setString(1, empName);
			preparedStatement.setInt(2, gender);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			preparedStatement.setObject(3, sdf.parse(birthday), Types.DATE);
			preparedStatement.setInt(4, deptId);

			// SQL文を実行
			preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException | ParseException e) {
			throw new SystemErrorException(ConstantMsg.MSG_SYSTEM_ERROR, e);

		} finally {
			// クローズ処理
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
	}

	/**
	 * 社員情報を1件更新
	 * 
	 * @param employee 社員の更新情報
	 * 
	 * @throws SystemErrorException 独自例外クラス 
	 */
	public static void update(Employee employee) throws SystemErrorException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			// データベースに接続
			connection = DBManager.getConnection();

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_UPDATE);

			// 入力値をバインド
			preparedStatement.setString(1, employee.getEmpName());
			preparedStatement.setInt(2, employee.getGender());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			preparedStatement.setObject(3, sdf.parse(employee.getBirthday()), Types.DATE);
			preparedStatement.setInt(4, employee.getDepartment().getDeptId());
			preparedStatement.setInt(5, employee.getEmpId());

			// SQL文の実行(失敗時は戻り値0)
			preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException | ParseException e) {
			throw new SystemErrorException(ConstantMsg.MSG_SYSTEM_ERROR, e);

		} finally {
			// クローズ処理
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
	}

	/**
	 * 社員情報を1件削除
	 * 
	 * @param empId 削除する社員の社員ID
	 *
	 * @throws SystemErrorException 独自例外クラス
	 */
	public static void delete(Integer empId) throws SystemErrorException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			// データベースに接続
			connection = DBManager.getConnection();

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_DELETE);

			// 社員IDをバインド
			preparedStatement.setInt(1, empId);

			// SQL文の実行(失敗時は戻り値0)
			preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			throw new SystemErrorException(ConstantMsg.MSG_SYSTEM_ERROR, e);
		}finally {
			// クローズ処理
			DBManager.close(preparedStatement);
			// DBとの接続を切断
			DBManager.close(connection);
		}
	}
}
