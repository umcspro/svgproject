package org.svgproject;
import java.util.Locale;
public class Ellipse implements Shape {
    private Style style;
    private Vec2 center;
    private double rx;
    private double ry;
    public Ellipse(Vec2 center, double rx, double ry) {
        this.style = new Style("none","black",1.0);
        this.center = center;
        this.rx = rx;
        this.ry = ry;
    }
    @Override
    public String toSvg(String parameters) {
        return String.format(Locale.ENGLISH,"<ellipse cx='%f' cy='%f' rx='%f' ry='%f' %s />",
                center.getX(), center.getY(), rx, ry,parameters);
    }
}