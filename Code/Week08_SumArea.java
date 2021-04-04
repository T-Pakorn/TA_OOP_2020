public class Week08_SumArea {
    public static double sumArea(Week08_GeometricObject[] geometricObjects){
        double sum = 0;
        for(Week08_GeometricObject geometricObject : geometricObjects){
            if(geometricObject != null){
                if(geometricObject instanceof Week08_Triangle){
                    Week08_Triangle t = (Week08_Triangle)geometricObject;
                    System.out.println("Triangle: "+ t.getA()+" "+t.getB()+" "+t.getC());

                    sum += t.getArea();
                }
                else if(geometricObject instanceof Week08_Rectangle){
                    Week08_Rectangle r = (Week08_Rectangle)geometricObject;
                    System.out.println("Rectangle: "+ r.getWidth()+" "+r.getHeight());
                    sum += r.getArea();
                }
                else if(geometricObject instanceof Week08_Circle){
                    Week08_Circle c = (Week08_Circle)geometricObject;
                    System.out.println("Circle: "+ c.getRadius());
                    sum += c.getArea();
                }
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Week08_GeometricObject[] list = new Week08_GeometricObject[5];
        list[0] = new Week08_Rectangle(5,5);
        list[1] = new Week08_Rectangle(7,10);
        list[2] = new Week08_Circle(2);
        list[3] = new Week08_Circle(3);
        list[4] = new Week08_Triangle(5,4,3);
        System.out.println("Sum of all area: "+sumArea(list));
    }
}