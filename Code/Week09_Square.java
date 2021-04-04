public class Week09_Square extends Week08_GeometricObject implements Week09_Colorable{
    public double side;

    public Week09_Square(){
        this(1);
    }

    public Week09_Square(double side) {
        this(side, false, "Black");
    }

    public Week09_Square(double side, boolean isFilled, String color) {
        super(isFilled, color);
        this.setSide(side);
    }

    public double getSide() {
        return side;
    }
    public void setSide(double side) {
        if(side <= 0){
            System.out.println("Side length must be positive. Set to default as 1");
            this.side = 1;
        }
        else {
            this.side = side;
        }
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides");
    }

    @Override
    public double getArea() {
        return side*side;
    }

    @Override
    public double getPerimeter() {
        return side*4;
    }

}