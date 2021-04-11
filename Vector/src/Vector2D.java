

public class Vector2D extends Vector{
    public Vector2D() {}

    public Vector2D(double x, double y){
        super(new Double[]{x, y});
    }
    public double getX() {
        return v[0];
    }
    public double getY() {
        return v[1];
    }
    public boolean pcollin(Vector2D v1) {
        return 0 == v[0]*v1.getY() - v[1]*v1.getX();
    }
    public Vector2D decomposition(Vector2D a, Vector2D b) throws VcollinearException {
        if (a.pcollin(b)) {
            throw new VcollinearException();
        } else {
            double aa = a.getX() * a.getX() + a.getY() * a.getY();
            double bb = b.getX() * b.getX() + b.getY() * b.getY();
            double ab =  a.getX() * b.getX() + a.getY() * b.getY();
            double pa =  this.getX() * a.getX() + this.getY() * a.getY();
            double pb =  this.getX() * b.getX() + this.getY() * b.getY();
            double x = (bb * pa - pb * ab)/(aa * bb - ab * ab);
            double y = (aa * pb - pa * ab)/(aa * bb - ab * ab);
            return new Vector2D(x, y);
        }
    }
    public Vector2D prV2(Vector2D v1) {
        Vector2D pr = v1;
        pr = Vector2DTest.makev2(pr.multiply(this.scalar(v1)/v1.len()));
        return pr;
    }
    @Override
    public boolean equals(Object o){
        if (this == o){return true;}
        if (o == null || getClass() != o.getClass()){return false;}
        Vector2D v = (Vector2D) o;
        return (v.getX() - this.getX() < 0.00000000001) && (v.getY() - this.getY() < 0.00000000001);}
}
