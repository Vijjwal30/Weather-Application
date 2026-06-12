package com.weather.utilities;

import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;

public class GradientBuilder {

    double angle;
    Stop[] stops;
    public static GradientBuilder newBuilder(){
        return new GradientBuilder();
    }
    public GradientBuilder setAngle(double angle){
        this.angle = Math.toRadians(angle);
        return this;
    }
    public GradientBuilder addStops(Stop... stops){
        this.stops = stops;
        return this;
    }
    public LinearGradient build(){
        double x1 = 0.5 - 0.5*Math.cos(angle);
        double y1 = 0.5 + 0.5*Math.sin(angle);
        double x2 = 0.5 + 0.5*Math.cos(angle);
        double y2 = 0.5 - 0.5*Math.sin(angle);

        return new LinearGradient(
                x1,y1,x2,y2,
                true,
                CycleMethod.NO_CYCLE,
                stops
        );
    }
}
