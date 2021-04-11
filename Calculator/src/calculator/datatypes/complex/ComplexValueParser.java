package calculator.datatypes.complex;

import java.util.Scanner;
import calculator.AbstractValue;
import calculator.AbstractValueParser;
import calculator.ParseValueException;

public class ComplexValueParser implements AbstractValueParser {
	
	public AbstractValue parse(String value) throws ParseValueException {
		try {
			double a,b;
			if (value.contains("+")) {
				String[] v = value.split("\\+"), v1;
				if(v.length != 2) throw new NumberFormatException();
				a = Double.parseDouble(v[0]);
				v1 = v[1].split("i");
				b = Double.parseDouble(v1[0]);
				return new ComplexValue(a, b);
			} else {
				String[] v = value.split("\\-"), v1;
				if(v.length != 2) throw new NumberFormatException();
				a = Double.parseDouble(v[0]);
				v1 = v[1].split("i");
				b = Double.parseDouble(v1[0]);
				return new ComplexValue(a, -b);
			}
		} catch  (NumberFormatException exception) {
			throw new ParseValueException();
		}
	}
	
	public String getDatatypeName() {
		return "комплексные числа";
	}

}
