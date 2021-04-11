
import static java.lang.Math.*;

public class Vector {
    protected Double[] v;

    public Vector() {}

    public Vector(int dim) {
        v = new Double[dim];
    }

    public Vector(Double[] new_v) {
        v = new_v;
    }

    public Double[] get(){return v;}

    public int dimension() {
        return v.length;
    }

    public double getComponent(int i) {
        return v[i];
    }

    public double scalar(Vector v1) {
        double s = 0;
        for (int i = 0; i < min(this.dimension(), v1.dimension()); i++) {
            s += v[i] * v1.getComponent(i);
        }
        return s;
    }
    public double len() {
        double s = 0;
        for(double x : v) {s += x*x;}
        return sqrt(s);
    }

    public Vector(Vector new_v) {
        v = new_v.get();
    }

    public Vector multiply(double factor) {
        Vector res = new Vector(v);
        for (int i = 0; i < res.dimension(); i++)  {res.get()[i] *= factor;}
        return res;
    }

    public Vector add(Vector v1) {
        int l = min(this.dimension(), v1.dimension());
        Vector res = new Vector(l);
        for (int i = 0; i < l; i++) {
            res.get()[i] = v[i] + v1.getComponent(i);
        }
        return res;
    }

    public Vector sub(Vector v1) {
        int l = min(this.dimension(), v1.dimension());
        Vector res = new Vector(l);
        for (int i = 0; i < l; i++) {
            res.get()[i] = v[i] - v1.getComponent(i);
        }
        return res;
    }

    public double pr(Vector v1) {
        return this.scalar(v1)/v1.len();
    }
}

