package org.umcspro.svgproject;

public class Main2 {
    public static void main(String[] args) {
        Shape polygon = new Polygon(new Vec2[]{
                new Vec2(200,100),
                new Vec2(200,200),
                new Vec2(300,100),
        });
        polygon = new SolidFillShapeDecorator(polygon,"green");
        polygon = new StrokeShapeDecorator(polygon,"blue",3);

        Shape ellipse = new Ellipse(new Vec2(100, 400), 50, 100);
        TransformationDecorator.Builder builder = new TransformationDecorator.Builder(
                new SolidFillShapeDecorator(ellipse,"red"));
        Shape s =
                builder
                .rotate(-25, new Vec2(0, 0))
                .translate(new Vec2(20, 20))
                .scale(new Vec2(1.5, 1.5))
                .build();

        SvgScene scene = SvgScene.getInstance();
        scene.addShape(polygon);
        scene.addShape(ellipse);
        scene.addShape(s);

        scene.save("./out.html");
    }
}