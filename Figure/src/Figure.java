import java.awt.Color;
import static java.lang.Math.*;

public abstract class Figure {
	protected String name; 
	protected Color color = Color.black; // цвет линии
	protected double x;
	protected double y;
	public Figure (String nm) {
		name = nm;
	}
}

class IsoscelesTrapezoid extends Figure{
	private double leg;
	private double upBase;
	private double downBase;
	//public IsoscelesTrapezoid() {super("Isosceles trapezoid");}
	public IsoscelesTrapezoid(double x, double y, double leg, double upBase, double downBase) {
		super("Isosceles trapezoid");
		this.leg = leg;
		this.upBase = upBase;
		this.downBase = downBase;
		this.x = x;
		this.y = y;
	}
	public double getX() {return x;}
	public double getY() {return y;}
	public double leg() {return leg;}
	public double upBase() {return upBase;}
	public double downBase() {return downBase;}
	public String name() {return name;}
	public double height() {
		return sqrt(leg*leg - abs(upBase - downBase)*abs(upBase - downBase)/4);
	} 
}