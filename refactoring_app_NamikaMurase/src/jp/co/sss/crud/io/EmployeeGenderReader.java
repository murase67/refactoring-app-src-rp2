package jp.co.sss.crud.io;

public class EmployeeGenderReader implements IConsoleReader{

	@Override
	public boolean isValid(String inputString) {
		return inputString.matches("[0129０１２９]{1}$");
	}

	@Override
	public String getErrorMsg() {
		return "不正な入力値です。再度入力してください";
	}

	@Override
	public boolean isParseInt() {
		return true;
	}
}
