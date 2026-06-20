package com.weather;

import com.weather.utilities.GradientBuilder;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Stop;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicInteger;


public class App extends Application {
    double width,height;
    boolean isAndroid = false;


    @Override
    public void start(Stage stage) {
        Label label = new Label("JavaFX 26 + Gluon Mobile");

        label.setFont(new Font(20));
        label.setTextFill(Color.ALICEBLUE);

        var root = new VBox(label);
        root.setSpacing(20);
        root.setAlignment(Pos.CENTER);
        Background background = new Background(
                new BackgroundFill(
                        GradientBuilder.newBuilder()
                                .setAngle(-90)
                                .addStops(
                                        new Stop(0.5,Color.BLACK),
                                        new Stop(1,Color.valueOf("#434343"))
                                )
                                .build(), null,null
                )
        );

        Canvas canvas = new Canvas(300,300);
        var gc = canvas.getGraphicsContext2D();

        Button button = new Button("Click!");
        root.getChildren().addAll(button,canvas);

        button.setOnAction(event-> {
            var angle = new AtomicInteger(0);
            Platform.runLater(
                    () -> new AnimationTimer() {
                        @Override
                        public void handle(long now) {
                            if (angle.get() > 360) this.stop();
                            gc.setFill(Color.ALICEBLUE);
                            gc.fillArc(canvas.getWidth()/4, canvas.getHeight()/4, 150, 150, 0, angle.getAndIncrement(), ArcType.ROUND);
                        }
                    }.start()
            );
        });
        root.setBackground(background);
        if(isAndroid){
            width = Screen.getPrimary().getVisualBounds().getWidth();
            height = Screen.getPrimary().getVisualBounds().getHeight();
        }
        else{
            width = 370;
            height = Screen.getPrimary().getVisualBounds().getHeight()-100;
        }
        Scene scene = new Scene(root, width, height);
        stage.setTitle("Weather");
        stage.setScene(scene);
        stage.show();
    }
}
