
public interface IShape {
	public double area();
	public double perimeter();
	public String name();
}

class TrapezoidIShape implements IShape {
	private IsoscelesTrapezoid tr;
	public TrapezoidIShape(IsoscelesTrapezoid t) {
		tr = t;
	}
	public double area() {
		return (tr.height() * (tr.upBase() + tr.downBase()) /2);
	}
	public double perimeter() {return 2*tr.leg() + tr.upBase() + tr.downBase();}
	public String name() {return tr.name();}
	
}