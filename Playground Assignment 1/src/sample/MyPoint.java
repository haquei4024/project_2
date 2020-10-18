package sample;

public class MyPoint {
    private double x, y;

    MyPoint(){
        x=0; y=0;
    }
    MyPoint(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void setX(double x){this.x = x;}
    public void setY(double y){this.y = y;}

    public double getX(){return x;}
    public double getY(){return y;}

}
