package jp.co.sss.crud.exception;

public class IllegalInputException extends RuntimeException{

	public IllegalInputException(String errorMsg) {
		super(errorMsg);
	}

}
