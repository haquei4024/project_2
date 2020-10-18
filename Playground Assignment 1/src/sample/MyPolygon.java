package sample;

import javafx.scene.canvas.GraphicsContext;

public class MyPolygon extends MyShape{

    //Private attributes
    private int sides;
    private double radius;

    //Public methods
    public double getArea (){return (double)(1/2) * radius * getPerimter();}
    public double getPerimter() { return (double) sides * getSide();}
    public double getAngle (){ return 360/sides; }
    public double getSide (){ return (double) 2 * radius * Math.tan(180/sides); }

    //Overloaded constructor
    public MyPolygon(int sides, int radius, int center_x, int center_y, MyColor color) {
        super(center_x,center_y,color);
        this.sides = sides;
        this.radius = radius;
    }

    @Override
    public String toString(){
        return "Radius: " + radius + " Perimeter: " + getPerimter() + " Area: " + getArea();
    }

    @Override
    public void draw (GraphicsContext GC){
        double [] x_coordinates = new double[this.sides];
        double [] y_coordinates = new double [this.sides];
        double exterior_angle  = (this.sides-1) * getAngle();
        double increase_angle = (2 * Math.PI) / this.sides;
        for (int i = 0; i < sides; i++){
            x_coordinates[i] = (float) super.getX() + (radius * Math.cos(exterior_angle));
            y_coordinates[i] = (float) super.getY()+ (radius * Math.sin(exterior_angle));
            exterior_angle += increase_angle;
        }
        GC.setFill(super.getColor().getColor());
        GC.strokePolygon(x_coordinates, y_coordinates, sides);
        GC.fillPolygon(x_coordinates,y_coordinates,sides);
    }

    @Override
    public MyRectangle getMyBoundingRectangle() {
        MyRectangle rec = new MyRectangle(super.getX(),super.getY(), 2*radius,2*radius, MyColor.BLACK);
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