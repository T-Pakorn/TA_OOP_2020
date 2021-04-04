import java.util.Objects;

public class Week08_Circle extends Week08_GeometricObject implements Cloneable{
    private double radius;

    public Week08_Circle() {
        this(1);
    }
    public Week08_Circle(double radius) {
        this(radius,false,"Black");
    }
    public Week08_Circle(double radius,boolean isFilled, String color) {
        super(isFilled, color);
        this.setRadius(radius);
    }

    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        if(radius <= 0){
            System.err.println("Radius must be positive. Set to default as 1");
            this.radius = 1;
        }
        else {
            this.radius = radius;
        }
    }
    public double getDiameter(){
        return this.radius*2;
    }

    public static String max(Week08_Circle c1, Week08_Circle c2){
        if(c1.radius > c2.radius){
            return c1.toString();
        }
        if(c2.radius > c1.radius){
            return c2.toString();
        }
        return "EQUALS";
    }

    @Override
    public double getArea() {
        return Math.PI*this.radius*this.radius;
    }

    @Override
    public double getPerimeter() {
        return Math.PI*2*this.radius;
    }

    @Override
    public String toString() {
        return super.toString() +" Circle{" +
                "radius=" + radius +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Week08_Circle circle = (Week08_Circle) o;
        return Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}