import static java.lang.Math.sqrt;

public class Vector3D{
    private double x;
    private double y;
    private double z;
    public Vector3D(double new_x, double new_y, double new_z){
        x = new_x;
        y = new_y;
        z = new_z;
    }
    public double getX(){return x;}
    public double getY(){return y;}
    public double getZ(){return z;}
    public double scalar(Vector3D v){ return x*v.x + y*v.y + z*v.z;}
    public double len(){ return sqrt(x*x + y*y + z*z);}
    public Vector3D multiply(double factor){ return new Vector3D(factor*x, factor*y, factor*z); }
    public Vector3D add(Vector3D v){ return new Vector3D(x+v.x, y+v.y, z+v.z); }
    public Vector3D sub(Vector3D v){ return new Vector3D(x-v.x, y-v.y, z-v.z); }
    public Vector3D vecX(Vector3D v){ return new Vector3D(y*v.z-z*v.y, z*v.x-x*v.z, x*v.y-y*v.x); }
    public boolean pcollin(Vector3D v){ return  vecX(v).equals(new Vector3D(0, 0, 0) ); }
    @Override
    public boolean equals(Object o){
        if (this == o){return true;}
        if (o == null || getClass() != o.getClass()){return false;}
        Vector3D v = (Vector3D) o;
        return (x - v.x < 0.00000000001) && (y - v.y < 0.00000000001) && (z - v.z < 0.00000000001);}


}

