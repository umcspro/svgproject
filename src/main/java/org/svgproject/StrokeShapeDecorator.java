package org.svgproject;

import java.util.Locale;

public class StrokeShapeDecorator extends ShapeDecorator {
    private String color;
    private double width;
    public StrokeShapeDecorator(Shape decoratedShape, String color, double width) {
        super(decoratedShape);
        this.color = color;
        this.width = width;
    }
    @Override
    public String toSvg(String parameters) {
        String strokeStyle = String.format(Locale.ENGLISH,"stroke='%s' stroke-width='%f'", color, width);
        if (!parameters.isEmpty()) {
            parameters += " ";
        }
        parameters += strokeStyle;
        return decoratedShape.toSvg(parameters);
    }
}