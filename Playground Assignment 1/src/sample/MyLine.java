package sample;


import javafx.scene.canvas.GraphicsContext;

public class MyLine extends MyShape {
    private double x2, y2;


    MyLine() {
        super();
    }
    MyLine(double x1, double y1, double x2, double y2, MyColor color){
        super(x1, y1, color);
        this.x2 = x2;
        this.y2 = y2;
    }

    public double getLength(){
        double length = Math.sqrt(Math.pow(x2-super.getX(), 2) + Math.pow(y2-super.getY(),2));
        return length;
    }

    public double get_xAngle(){
        double angle = Math.toDegrees(Math.atan((y2-super.getY())/(x2-super.getX())));
        return angle;
    }

    @Override
    public String toString(){
        return "x = " + getX() + " y = " + getY() + " angle = " + get_xAngle() + " length = " + getLength();
    }

    @Override
    public void draw(GraphicsContext GC){
        GC.setStroke(super.getColor().getColor());
        GC.strokeLine(super.getX(), super.getY(), x2, y2);
    }


    @Override
    public MyRectangle getMyBoundingRectangle() {
        MyRectangle rec = new MyRectangle(super.getX() + (getLength()/2), super.getY(),getLength(),6, MyColor.BLACK);
        return rec;
    }

    @Override
    public boolean overlapMyShapes(MyShape line){

    }


}
