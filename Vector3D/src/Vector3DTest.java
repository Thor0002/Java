
import static org.junit.Assert.*;

import org.junit.Test;

public class Vector3DTest {

    @org.junit.Test
    public void getX() {
        double res = new Vector3D(1, 2, 3 ).getX();
        assertEquals(1, res, 0.00000000001);
    }

    @org.junit.Test
    public void getY() {
    	double res = new Vector3D(1, 2, 3 ).getY();
        assertEquals(2, res, 0.00000000001);
    }

    @org.junit.Test
    public void getZ() {
    	double res = new Vector3D(1, 2, 3 ).getZ();
        assertEquals(3, res, 0.00000000001);
    }

    @org.junit.Test
    public void scalar() {
    	Vector3D v1 = new Vector3D(1, 2, 3);
    	Vector3D v2 = new Vector3D(8, 7, 2);
    	double res = v1.scalar(v2);
        assertEquals(28, res, 0.00000000001);
    }

    @org.junit.Test
    public void len() {
    	Vector3D v1 = new Vector3D(3, 4, 12);
    	double res = v1.len();
        assertEquals(13, res, 0.00000000001);
    }

    @org.junit.Test
    public void multiply() {
    	double x = (1.0 / 3) * 7;
    	double y = (1.0 * 7) / 3;
    	Vector3D v1 = new Vector3D(3, 4, 12);
    	Vector3D v2 = v1.multiply(x);
        assertEquals(new Vector3D(3 * y, 4 * y , 12 * y), v2); // ?
    }

    @org.junit.Test
    public void add() {
    	Vector3D v1 = new Vector3D(1, 2, 3);
    	Vector3D v2 = new Vector3D(8, 7, 2);
        assertEquals(new Vector3D(9, 9 , 5), v1.add(v2));
    }

    @org.junit.Test
    public void sub() {
    	Vector3D v1 = new Vector3D(1, 2, 3);
    	Vector3D v2 = new Vector3D(8, 7, 2);
        assertEquals(new Vector3D(-7, -5 , 1), v1.sub(v2));
    }

    @org.junit.Test
    public void vecX() {
    	Vector3D v1 = new Vector3D(1, 0, 0);
    	Vector3D v2 = new Vector3D(0, 1, 0);
        assertEquals( new Vector3D(0, 0, 1), v1.vecX(v2));
    }

    @org.junit.Test
    public void pcollin() {
    	Vector3D v1 = new Vector3D(1, 0, 0);
    	Vector3D v2 = new Vector3D(0, 1, 0);
    	boolean t = v1.pcollin(v2);
    	assertEquals(t, false);
    	v1 = new Vector3D(1, 0, 0);
    	v2 = new Vector3D(2, 0, 0);
    	t = v1.pcollin(v2);
    	assertEquals(t, true);
    }

    @org.junit.Test
    public void testEquals() {//?
    }
}
