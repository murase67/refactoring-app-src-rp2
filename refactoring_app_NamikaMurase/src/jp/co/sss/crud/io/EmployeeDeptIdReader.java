package jp.co.sss.crud.io;

public class EmployeeDeptIdReader implements IConsoleReader {

	@Override
	public boolean isValid(String inputString) {
		return inputString.matches("^[1-3１-３]{1}$");
	}

	@Override
	public String getErrorMsg() {
		return "1以上3以下の整数を入力してください";
	}

	@Override
	public boolean isParseInt() {
		return true;
	}
}
