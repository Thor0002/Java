package calculator;

@SuppressWarnings("serial")
public class OperationNotSupportedException extends Exception {

	public OperationNotSupportedException(String operation) {
		super("�������� " + operation + " �� ��������������");
	}

}
