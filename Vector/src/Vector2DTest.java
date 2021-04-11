
import static java.lang.Math.*;

import java.util.Scanner;

public class Vector2DTest {
    public static Vector2D symmetry(Vector2D p, Vector2D n, Vector2D s){
        Vector2D sp = makev2(p.sub(s));
        sp = makev2(sp.multiply(2));
        Vector2D pr = sp.prV2(n);
        Vector vs1 = s.add(pr);
        Vector2D s1 = new Vector2D(vs1.getComponent(0) , vs1.getComponent(1));
        return s1;
    }

    public static Vector2D makev2(Vector v){
        if (v.dimension() == 2){
            return new Vector2D(v.getComponent(0), v.getComponent(1));
        }
        return new Vector2D();
    }
    
    public static Vector2D dif(Vector2D a, Vector2D b){
        Vector vab = b.sub(a);
        Vector2D ab = new Vector2D(vab.getComponent(0), vab.getComponent(1));
        return ab;
    }

    public static void main(String[] args) throws VcollinearException {
    
    	Scanner sc = new Scanner(System.in);
    	double x1, x2;
    	Vector2D p, n;
    	System.out.println("Симметричная точка");
    	System.out.println("Введите точку P прямой:");
    	x1 = sc.nextDouble(); x2 = sc.nextDouble();
        p = new Vector2D(x1, x2);
    	System.out.println("Введите нормалый вектор n прямой:");
    	x1 = sc.nextDouble(); x2 = sc.nextDouble();
        n = new Vector2D(x1, x2);
    	System.out.println("Введите точку S:");
    	x1 = sc.nextDouble(); x2 = sc.nextDouble();
        Vector2D s = new Vector2D(x1, x2);
        Vector2D s1 = symmetry(p, n, s);
    	System.out.println("Точка симметричная для точки S:");
        System.out.println(s1.getX() + " " + s1.getY()  + "\n");
    	
    	System.out.println("Точка на биссектрисе");
        System.out.println("Введите точку P прямой:");
    	x1 = sc.nextDouble(); x2 = sc.nextDouble();
        p = new Vector2D(x1, x2);
    	System.out.println("Введите нормалый вектор n прямой:");
    	x1 = sc.nextDouble(); x2 = sc.nextDouble();
        n = new Vector2D(x1, x2);
        System.out.println("Введите точку A:");
    	x1 = sc.nextDouble(); x2 = sc.nextDouble();
        Vector2D a = new Vector2D(x1, x2);
        System.out.println("Введите точку B:");
    	x1 = sc.nextDouble(); x2 = sc.nextDouble();
        Vector2D b = new Vector2D(x1, x2);
        Vector2D a1 = symmetry(p, n, a);
        Vector2D a1b = dif(a1, b);
        Vector2D pa = dif(p, a);;
        Vector2D pa1 = dif(p, a1);
        if (n.scalar(pa)*n.scalar(pa1) < 0 && a1b.scalar(n) != 0){
            Vector2D a1a = dif(a1, a);
            double sina = abs(n.scalar(a1b))/(n.len() * a1b.len());
            double lx = a1a.len()/(2 * sina);
            if (a1a.scalar(a1b) < 0){a1b = makev2(a1b.multiply(-1));}
            Vector2D x = makev2(a1.add(makev2(a1b.multiply(lx/a1b.len()))));
        	System.out.println("Точка X:");
            System.out.println(x.getX() + " " + x.getY());
        } else {
        	if (a1.equals(b)) {System.out.println("Подходит любая точка прямой");}
        	else {System.out.println("На прямой такой точки нет:");}
        }
        System.out.println("");
        
        try {
        System.out.println("Разложение на компоненты");
        System.out.println("Какой вектор раскладываем:");
    	x1 = sc.nextDouble(); x2 = sc.nextDouble();
        p = new Vector2D(x1, x2);
        System.out.println("По каким:");
    	x1 = sc.nextDouble(); x2 = sc.nextDouble();
        Vector2D v1 = new Vector2D(x1, x2);
    	x1 = sc.nextDouble(); x2 = sc.nextDouble();
        Vector2D v2 = new Vector2D(x1, x2);
        Vector2D xy = p.decomposition(v1, v2);
        System.out.println("v = " + xy.getX() + "*v1 +"+ " " + xy.getY() + "*v2");
        } catch(VcollinearException e) {
        	e.printStackTrace(System.out);
        }
    }

}

