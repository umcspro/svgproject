package org.example.ooplab3;

public class Main2 {
    public static void main(String[] args) {
        Shape ellipse = new Ellipse(new Vec2(100, 200), 50.5, 75.7);
        ellipse = new SolidFillShapeDecorator(ellipse,"black");

        ellipse = new TransformationDecorator.Builder(ellipse)
                .rotate(1, new Vec2(0, 0))
                .build();

        ellipse = new DropShadowDecorator(ellipse);

        polygon = new GradientFillShapeDecorator.Builder()
                .setShape(polygon)
                .addStop(0.3, "red")
                .addStop(0.6, "blue")
                .addStop(1, "green")
                .build();

        TransformationDecorator.Builder builder = new TransformationDecorator.Builder(
                new SolidFillShapeDecorator(
                        new Ellipse(new Vec2(0, 0), 20, 60),"red"));
        Shape s =
                builder
                .rotate(-25, new Vec2(0, 0))
                .translate(new Vec2(100, 150))
                .scale(new Vec2(1.5, 1.5))
                .build();
        System.out.println(s);

        SvgScene scene = SvgScene.getInstance();
//        scene.addShape(polygon);
//        scene.addShape(ellipse);
        scene.addShape(s);

        scene.save("./out.html");
    }
}