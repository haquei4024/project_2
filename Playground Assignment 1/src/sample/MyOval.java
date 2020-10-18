package sample;

import javafx.scene.canvas.GraphicsContext;

public class MyOval extends MyShape{
    private double small_radius;
    private double big_radius;

    MyOval(){super();}
    MyOval(double x, double y, double width, double height, MyColor color){
        super(x, y, color);
        this.small_radius = height;
        this.big_radius = width;
    }

    public double major_axis = big_radius/2;
    public double minor_axis = small_radius/2;

    public double getPerimeter(){
        double perimeter = 2*Math.PI*Math.sqrt((major_axis+minor_axis)/2);
        return perimeter;
    }

    public double getArea(){
        return Math.PI*major_axis*minor_axis;
    }

    public String toString(){
        return "major axis = "+major_axis+" minor axis = "+minor_axis+" perimeter = "+getPerimeter()+" area = "+getArea();
    }

    public void draw(GraphicsContext GC){
        GC.setFill(super.getColor().getColor());
        GC.strokeOval(super.getX()-(big_radius/2), super.getY()-(small_radius/2), big_radius, small_radius);
        GC.fillOval(super.getX()-(big_radius/2), super.getY()-(small_radius/2), big_radius, small_radius);
    }

    @Override
    public MyRectangle getMyBoundingRectangle() {
        MyRectangle rec = new MyRectangle(super.getX(), super.getY(), big_radius, small_radius,MyColor.BLACK);
        return rec;
    }

    @Override
    public boolean overlapMyShapes(MyShape shape) {
        MyRectangle newShape = shape.getMyBoundingRectangle();   // the shape that is being compared to
        MyRectangle oldShape = this.getMyBoundingRectangle();   //  the shape I am trying to compare

        // When they do overlap
        if (oldShape.topLeftX() >= newShape.topLeftX() && oldShape.topLeftX() <= newShape.topRightX()&&
                oldShape.topLeftY() >= newShape.topLeftY() && oldShape.topLeftY() <= newShape.bottomLeftY()) return true;

        if (oldShape.topLeftX() >= newShape.topLeftX() && oldShape.topLeftX() <= newShape.topRightX() &&
                oldShape.topLeftY() >= newShape.topLeftY() && oldShape.topLeftY() <=  newShape.bottomLeftY()) return true;

        if (newShape.topLeftX() >= oldShape.topLeftX() && newShape.topLeftX() <= oldShape.topRightX()&&
                newShape.topLeftY() >= oldShape.topLeftY() && newShape.topLeftY() <= oldShape.bottomLeftY()) return true;

        if (newShape.topLeftX() >= oldShape.topLeftX() && newShape.topLeftX() <= oldShape.topRightX() &&
                newShape.topLeftY() >= oldShape.topLeftY() && newShape.topLeftY() <=  oldShape.bottomLeftY()) return true;

        return false;
    }
}
