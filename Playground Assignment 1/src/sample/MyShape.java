package sample;


import javafx.scene.canvas.GraphicsContext;


abstract class MyShape extends MyPoint implements MyShapeInterface{
    private MyColor color;

    MyShape(){
        super();
        color = MyColor.BLACK;

    MyShape(double x, double y, MyColor color){
        super(x,y);
        this.color = color;
    }

    public void setColor(MyColor color){this.color = color;}

    public MyColor getColor(){return color;}


    public String toString(){
        return "x = " + getX() + "and y = " + getY();
    }

    public void draw(GraphicsContext GC){}
}
