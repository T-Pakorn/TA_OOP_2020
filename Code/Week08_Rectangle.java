import java.util.Objects;

public class Week08_Rectangle extends Week08_GeometricObject{
    private double height, width;

    public Week08_Rectangle() {
        this(1,1);
    }

    public Week08_Rectangle(double height, double width) {
        this(height,width,false,"Black");
    }

    public Week08_Rectangle( double height, double width,boolean isFilled, String color) {
        super(isFilled, color);
        this.setHeight(height);
        this.setWidth(width);
    }

    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        if(height <= 0){
            System.err.println("Height must be positive. Set to default as 1");
            this.height = 1;
        }
        else{
            this.height = height;
        }

    }

    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        if(width <= 0){
            System.err.println("width  must be positive. Set to default as 1");
            this.width  = 1;
        }
        else{
            this.width  = width ;
        }
    }

    public static String max(Week08_Rectangle r1, Week08_Rectangle r2){
        if(r1.getArea() > r2.getArea()){
            return r1.toString();
        }
        if(r2.getArea() > r1.getArea()){
            return r2.toString();
        }
        return "EQUALS";
    }


    @Override
    public double getArea() {
        return width*height;
    }

    @Override
    public double getPerimeter() {
        return (width*2)+(height*2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Week08_Rectangle rectangle = (Week08_Rectangle) o;
        return Double.compare(rectangle.getArea(), this.getArea()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, width);
    }
}