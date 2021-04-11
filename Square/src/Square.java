import static java.lang.Math.sqrt;

class Square {
    public double x; // абсцисса центра
    public double y; // ордината центра
    public double dl_s; // сторона

    public void printSquare() {
        System.out.println(" вадрат с центром ("+x+";"+y+") и стороной "+dl_s);
    }
    public void moveSquare(double a, double b) {
        x = x + a;
        y = y + b;
    }
    public void zoomSquare(double dl_s) {
        this.dl_s = this.dl_s * dl_s;
    }
    public Square() {
        x = 0.0;
        y = 0.0;
        dl_s = 1.0;
    }
    public Square(double a, double b, double s) {
        x = a;
        y = b;
        dl_s = s;
    }
    // метод вычисл€ющий площадь квадрата
    public double squareSquare() {
        double s = dl_s * dl_s;
        return s;
    }
    // метод провер€ющий равны ли квадраты по площад€м
    public boolean equalsSquare(Square squ) {
        if(this.squareSquare() == squ.squareSquare()) {
            return true;
        } else {
            return false;
        }
    }
    public double perimeter() {
        return 4 * dl_s;
    }
    public void randomCentre(){
        x = (Math.random() - 0.5) * 2 * 99;
        y = (Math.random() - 0.5) * 2 * 99;
    }
    public double distance(Square sq){
        return 1;//sqrt((x - sq.x)*(x - sq.x) + (y - sq.y)*(y - sq.y));
    }
}

class Main {
    public static void main(String[] args) {
        Square s1 = new Square();
        s1.printSquare(); //  вадрат с центром (0.0;0.0) и стороной 1.0
        Square s2 = new Square(1,-1,14);
        s2.printSquare(); //  вадрат с центром (1.0;-1.0) и стороной 14.0
        System.out.println("ѕлощадь квадрата s2: "+s2.squareSquare());
        s1.zoomSquare(14);
        if(s1.equalsSquare(s2)) {
            System.out.println(" вадраты s2 и s1 имеют равную площадь");
        } else {
            System.out.println(" вадраты s2 и s1 имеют различную площадь");
        }
        System.out.print("ѕериметр s2 равен ");
        System.out.println(s2.perimeter());
        System.out.print("–ассто€ние от s1 до s2 ");
        System.out.println(s1.distance(s2));
        System.out.print("s1:");
        s1.randomCentre();
        s1.printSquare();
        System.out.print(sqrt(1));
    }
}


