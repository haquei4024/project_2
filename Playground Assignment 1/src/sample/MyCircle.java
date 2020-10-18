package sample;

import javafx.scene.canvas.GraphicsContext;


public class MyCircle extends MyOval {

    private double radius;

    MyCircle(){ super(); }
    MyCircle(double x, double y, double radius, MyColor color){
        super(x, y, radius, radius, color);
        this.radius = radius;
    }


    public double getRadius(){
        return radius;
    }

    public double getArea(){
        double area = Math.PI*Math.pow(radius,2);
        return area;
    }

    public double getPerimeter(){
        double perimeter = 2*Math.PI*radius;
        return perimeter;
    }

    @Override
    public String toString(){
        return "Center = ("+getX()+","+ getY()+") radius = "+getRadius()+" perimeter = "+getPerimeter()+" area = "+getArea();
    }

    @Override
    public void draw(GraphicsContext GC){
        GC.setFill(super.getColor().getColor());
        GC.strokeOval(super.getX()-radius/2, super.getY()-radius/2, radius, radius);
        GC.fillOval(super.getX()-radius/2, super.getY()-radius/2, radius, radius);
    }

    @Override
    public MyRectangle getMyBoundingRectangle() {
        MyRectangle rec = new MyRectangle(super.getX(), super.getY(), radius, radius, MyColor.BLACK);
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
