import java.util.Scanner;

public class SegmentTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("��������� ������ �������");
		double x = sc.nextDouble(), y = sc.nextDouble(), z = sc.nextDouble();
		Vector3D p1 = new Vector3D(x, y, z);
		System.out.println("��������� ����� �������");
		x = sc.nextDouble(); y = sc.nextDouble(); z = sc.nextDouble();
		Vector3D p2 = new Vector3D(x, y, z);
		Segment s = new Segment(p1, p2);
		System.out.println("��������� �����");
		x = sc.nextDouble(); y = sc.nextDouble(); z = sc.nextDouble();
		Vector3D p = new Vector3D(x, y, z);
		System.out.println("����� �������:");
		System.out.println(s.len());
		System.out.println("����������:");
		System.out.println(s.distanceTo(p));
	}
}
