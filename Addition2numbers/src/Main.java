import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a, b, c;

        System.out.println("¬ведите первое число");
        a = sc.nextInt();//—читываем первое число

        System.out.println("¬ведите второе число");
        b = sc.nextInt();//—читываем второе число

        c = a + b;

        System.out.println("c = " + c);
    }
}