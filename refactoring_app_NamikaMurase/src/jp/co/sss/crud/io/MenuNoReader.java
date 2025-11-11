package jp.co.sss.crud.io;

public class MenuNoReader implements IConsoleReader{

	@Override
	public boolean isValid(String inputString) {
		return inputString.matches("^[1-7１-７]$");
	}

	@Override
	public String getErrorMsg() {
		return "1以上7以下の整数を入力してください";
	}

	@Override
	public boolean isParseInt() {
		return true;
	}
}
