package calculator.datatypes.complex;

import calculator.AbstractValue;
import calculator.DivisionByZeroException;
import calculator.datatypes.real.RealValue;

public class ComplexValue extends AbstractValue {
	private final double realValue;
	private final double imaginaryValue;
	public ComplexValue(double realValue, double imaginaryValue) {
		super();
		this.realValue = realValue;
		this.imaginaryValue = imaginaryValue;
	}
	public String toString() {
		return (Double.toString(realValue) + ((imaginaryValue >= 0 ) ? "+" : "-") + Double.toString((imaginaryValue >= 0 ) ? imaginaryValue : (-imaginaryValue)) + "i");
	}
	public AbstractValue add(AbstractValue operand) {
		return new ComplexValue(realValue + ((ComplexValue) operand).realValue, imaginaryValue + ((ComplexValue) operand).imaginaryValue);
	}
	
	public AbstractValue sub(AbstractValue operand) {
		return new ComplexValue(realValue - ((ComplexValue) operand).realValue, imaginaryValue - ((ComplexValue) operand).imaginaryValue);
	}
	public AbstractValue mul(AbstractValue operand) {
		return new ComplexValue(realValue * ((ComplexValue) operand).realValue - (imaginaryValue * ((ComplexValue) operand).imaginaryValue),
				imaginaryValue * ((ComplexValue) operand).realValue + realValue * ((ComplexValue) operand).imaginaryValue);
	}
	public AbstractValue div(AbstractValue operand) throws DivisionByZeroException {
		double a = ((ComplexValue) operand).realValue, b = ((ComplexValue) operand).imaginaryValue;
		double l = a*a + b*b;
		if (l == 0) throw new DivisionByZeroException();
		ComplexValue inv = new ComplexValue(a/l, - b/l);
		return this.mul(inv);
	}
	
}
