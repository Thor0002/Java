package calculator;

@SuppressWarnings("serial")
public class ParseValueException extends Exception {
	public ParseValueException() {
		super("�������� ������ ������");
	}
	public ParseValueException(String details) {
		super("�������� ������ ������. " + details);
	}
}
