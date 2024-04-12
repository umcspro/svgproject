package org.umcspro.svgproject;
public class SolidFillShapeDecorator extends ShapeDecorator{
    private String color;
    public SolidFillShapeDecorator(Shape decoratedShape, String color) {
        super(decoratedShape);
        this.color = color;
    }
    @Override
    public String toSvg(String parameter) {
        String f=String.format("fill=\"%s\" %s ",color, parameter);
        return decoratedShape.toSvg(f);
    }
}