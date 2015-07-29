/*
Landon Speer
*/
package lab10;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class Lab10 extends Application {
    private CirclePane circlePane = new CirclePane();
    private double width = 400;
    private double height = 350;
    
    @Override
    public void start(Stage primaryStage) {
        
        HBox hBox = new HBox();
        hBox.setSpacing(5);
        hBox.setAlignment(Pos.CENTER);
        Button left = new Button("Left");
        Button right = new Button("Right");
        Button up = new Button("Up");
        Button down = new Button("Down");
        hBox.getChildren().addAll(left,right,up,down);
        
        left.setOnAction(e -> circlePane.left());
        right.setOnAction(e -> circlePane.right());
        up.setOnAction(e -> circlePane.up());
        down.setOnAction(e -> circlePane.down());
                
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(circlePane);
        borderPane.setBottom(hBox);
        borderPane.setAlignment(hBox,Pos.CENTER);
        
        Scene scene = new Scene(borderPane, width, height);
        primaryStage.setTitle("Lab10");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }//start
    
    class CirclePane extends Pane {
        private Circle circle = new Circle(400/2,350/2,50);
        
        public CirclePane(){
            getChildren().add(circle);
            circle.setStroke(Color.BLACK);
            circle.setFill(Color.BLUE);
        }//constructor
        
        public void left(){
            if(circle.getCenterX() > 50){
                circle.setCenterX(circle.getCenterX() - 25);
            }//if
        }//left
        
        public void right(){
            if(circle.getCenterX() < (circle.getScene().getWidth()) - 50){
                circle.setCenterX(circle.getCenterX() + 25);
            }//if
        }//right
        
        public void up(){
            if(circle.getCenterY() > 50){
                circle.setCenterY(circle.getCenterY() - 25);
            }//if
        }//up
        
        public void down(){
            if(circle.getCenterY() < (circle.getScene().getHeight()) - 50){
                circle.setCenterY(circle.getCenterY() + 25);
            }//if
        }//down
    }//class
    
    public static void main(String[] args) {
        launch(args);
    }//main
    
}//class