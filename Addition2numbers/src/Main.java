import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a, b, c;

        System.out.println("������� ������ �����");
        a = sc.nextInt();//��������� ������ �����

        System.out.println("������� ������ �����");
        b = sc.nextInt();//��������� ������ �����

        c = a + b;

        System.out.println("c = " + c);
    }
}