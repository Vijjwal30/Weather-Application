package com.weather;

import com.weather.utilities.GradientBuilder;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.css.converter.PaintConverter;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Stop;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.net.http.HttpClient;
import java.util.concurrent.atomic.AtomicInteger;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        Label label = new Label("JavaFX 26 + Gluon Mobile");
        StackPane root = new StackPane(label);
        Background background = new Background(
                new BackgroundFill(
                        GradientBuilder.newBuilder()
                                .setAngle(30)
                                .addStops(
                                        new Stop(0.0,Color.rgb(233, 233, 245, 1.0)),
                                        new Stop(0.4,Color.rgb(235, 235, 240, 1.0)),
                                        new Stop(1.0,Color.rgb(142, 216, 245, 1.0))
                                )
                                .build(), null,null
                )
        );
        root.setBackground(background);
        Scene scene = new Scene(root, 370, Screen.getPrimary().getBounds().getHeight()-100);
        stage.setTitle("Weather");
        stage.setScene(scene);
        stage.show();
    }
}
