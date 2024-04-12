package org.umcspro.svgproject;

import java.util.Locale;

public class TransformationDecorator extends ShapeDecorator {
    String transform;
    public static class Builder {
        private Shape shape;
        String transform;
        public Builder(Shape shape) {

            this.transform = "";
            this.shape = shape;
        }
        public Builder translate(Vec2 translation) {
            this.transform += String.format(Locale.ENGLISH," translate(%f %f)", translation.x, translation.y);
            return this;
        }
        public Builder rotate(float angle, Vec2 middle) {
            this.transform += String.format(Locale.ENGLISH," rotate(%f %f %f)", angle, middle.x, middle.y);
            return this;
        }
        public Builder scale(Vec2 scaleVector) {
            this.transform += String.format(Locale.ENGLISH," scale(%f %f)", scaleVector.x, scaleVector.y);
            return this;
        }
        public TransformationDecorator build() {

            return new TransformationDecorator(shape, transform);
        }
    }
    public TransformationDecorator(Shape shape, String transform) {
        super(shape);
        this.transform = transform;
    }
    @Override
    public String toSvg(String param) {
        return super.toSvg(String.format("%s transform=\"%s\"", param, this.transform));
    }
}