package sample;

import javafx.scene.canvas.GraphicsContext;

public class MyRectangle extends MyShape {
    private double width;
    private double height;

    MyRectangle(){super();}
    MyRectangle(double x, double y, double width, double height, MyColor color){
        super(x, y, color);
        this.width = width;
        this.height = height;
    }

    public void setHeight(double height){
        this.height = height;
    }
    public void setWidth(double width){
        this.width = width;
    }

    public double getHeight(){ return height;}
    public double getWidth(){return width;}
    public double getPerimeter(){return 2*(height+width);}
    public double getArea(){return height*width;}

    public double topLeftX(){return super.getX();}
    public double topLeftY(){return super.getY();}
    public double topRightX(){return super.getX()+getWidth();}
    public double topRightY(){return super.getY()+getWidth();}
    public double bottomLeftX(){return super.getX()+getHeight();}
    public double bottomLeftY(){return super.getY()+getHeight();}
    public double bottomRightX(){return super.getX()+getWidth()+getHeight();}
    public double bottomRightY(){return super.getY()+getWidth()+getHeight();}

    public String toString(){
        return "width = "+getWidth()+" height = "+getHeight()+" perimeter = "+getPerimeter()+" area = "+getArea();
    }

    public void draw(GraphicsContext GC){
        GC.setFill(super.getColor().getColor());
        GC.strokeRect(super.getX()-(getWidth()/2),super.getY()-(getHeight()/2), getWidth(), getHeight());
        GC.fillRect(super.getX()-(getWidth()/2),super.getY()-(getHeight()/2), getWidth(), getHeight());
    }

    @Override
    public MyRectangle getMyBoundingRectangle() {
        return this;
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
