package jp.co.sss.crud.io;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EmployeeBirthdayReader implements IConsoleReader {

	@Override
	public boolean isValid(String inputString) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		sdf.setLenient(false);

		try {
			sdf.parse(inputString);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

	@Override
	public String getErrorMsg() {
		return "正しい形式(西暦年/月/日)で日付を入力してください";
	}

	@Override
	public boolean isParseInt() {
		return false;
	}
}
