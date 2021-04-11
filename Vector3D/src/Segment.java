import static java.lang.Math.min;

public class Segment {
	private Vector3D p1;
	private Vector3D p2;
	public Segment(Vector3D new_p1, Vector3D new_p2) {
		p1 = new_p1; p2 = new_p2;
	}
	public double len() {return (p1.sub(p2)).len();}
	public double distanceTo(Vector3D p) {
		if ( ((p2.sub(p1)).scalar(p.sub(p1)) < 0) || ((p1.sub(p2)).scalar(p.sub(p2)) < 0) ) {
			return min((p.sub(p2)).len(), (p.sub(p1)).len());
		} else {
			double l = (p2.sub(p1)).len();
			return (p.sub(p1).vecX((p2.sub(p1))).len())/l;
		}
	}	
}
