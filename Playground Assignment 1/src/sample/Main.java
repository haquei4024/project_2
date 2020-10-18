package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Canvas canvas = new Canvas(600,600);
        GraphicsContext p = canvas.getGraphicsContext2D();
        StackPane layout = new StackPane(canvas);

        // scenes
        Scene scene = new Scene(layout);
        primaryStage.setTitle("Different Shapes Using JavaFx");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Polygons and Circles
        MyPolygon p1 = new MyPolygon(6,105,300,275, MyColor.RED);
        p1.draw(p);
        MyCircle c1 = new MyCircle(300, 275, 180, MyColor.BLUE);
        c1.draw(p);
        MyPolygon p2 = new MyPolygon(6,90,300,275, MyColor.ORANGE);
        p2.draw(p);
        MyCircle c2 = new MyCircle(300, 275, 160, MyColor.CYAN);
        c2.draw(p);
        MyPolygon p3 = new MyPolygon(6,70,300,275, MyColor.YELLOW);
        p3.draw(p);

        //Lines and Boxes
        MyLine l1 = new MyLine(100,150,500,150,MyColor.BLACK);
        l1.draw(p);
        MyLine l2 = new MyLine(100,400,500,400,MyColor.BLACK);
        l2.draw(p);
        MyLine l3 = new MyLine(100,400,100,150,MyColor.BLACK);
        l3.draw(p);
        MyLine l4 = new MyLine(500,400,500,150,MyColor.BLACK);
        l4.draw(p);
        MyLine d1 = new MyLine(100,150,500,400,MyColor.BLACK);
        d1.draw(p);
        MyLine d2 = new MyLine(100,400,500,150,MyColor.BLACK);
        d2.draw(p);

    }


    public static void main(String[] args) {
        launch(args);
    }
}

