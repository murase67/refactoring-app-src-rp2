package jp.co.sss.crud.service;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;

public class EmployeeDeleteService {

	/**
	 * 社員情報を1件削除する
	 * 
	 * @param inputEmpId 削除する社員の社員ID
	 * @throws SystemErrorException
	 */
	public static void execute(Integer inputEmpId) throws SystemErrorException{
		
		EmployeeDAO.delete(inputEmpId);
		ConsoleWriter.showDeleteComplate();
	}

}
