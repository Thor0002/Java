
import java.awt.*;
import javax.swing.JFrame;
public class GraphicsCoord extends JFrame {
	private IsoscelesTrapezoid t;
	public GraphicsCoord(IsoscelesTrapezoid t) {
		super("simpleApp");
		this.t = t;
		setSize(700, 600);
		setVisible(true);
	}
	@Override
	public void paint(Graphics g) {
		Graphics2D gr2d = (Graphics2D) g;
		// Рисуем простые линии
		gr2d.setPaint(Color.BLUE);
		gr2d.drawLine(0, 300, 700, 300);
		gr2d.drawLine(350, 0, 350, 600);
		gr2d.setFont(new Font("TimesRoman", Font.PLAIN, 10));
		for (int i = 1; i < 17; i++) {
			gr2d.drawLine(350+i*20, 295, 350+i*20, 305);
			gr2d.drawString(i+"", 351+i*20, 310);
			gr2d.drawLine(350-i*20, 295, 350-i*20, 305);
			gr2d.drawLine(345, 300+i*20, 355, 300+i*20);
			gr2d.drawLine(345, 300-i*20, 355, 300-i*20);
			gr2d.drawString(i+"", 352, 300-i*20);
		}
		
		gr2d.setPaint(t.color);
		int x = 350 + (int) t.getX() * 20;
		int y = 300 + (int) t.getY() * 20;
		int h = (int) t.height() * 20;
		int u = (int) t.upBase() * 20;
		int d = (int) t.downBase() * 20;
		
		gr2d.drawLine(x, y, x + d, y);
		gr2d.drawLine(x, y, x + (d - u) /2, y - h);
		gr2d.drawLine(x + (d - u) /2, y - h, x + (d - u) /2 + u, y - h);
		gr2d.drawLine(x + (d - u) /2 + u, y - h, x + d, y);
		gr2d.setPaint(Color.GREEN);
		gr2d.drawLine(x + d /2, y, x + d/2, y - h);
	}
	public static void main(String args[]) {
		IsoscelesTrapezoid tr = new IsoscelesTrapezoid(0.0, 0.0, 5.0, 5.0, 11.0);
		tr.color = Color.RED;
		GraphicsCoord app = new GraphicsCoord(tr);
	}
}
