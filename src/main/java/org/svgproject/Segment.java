package org.svgproject;
public class Segment {
    private Vec2 startVec2;
    private Vec2 endVec2;
    public Segment(Vec2 startVec2, Vec2 endVec2) {
        this.startVec2 = startVec2;
        this.endVec2 = endVec2;
    }
    // Akcesory pozostają bez zmian
    public Vec2 getStartPoint() {
        return startVec2;
    }
    public Vec2 getEndPoint() {
        return endVec2;
    }
    // Metoda length() pozostaje bez zmian
    public double length() {
        return Math.sqrt(Math.pow(endVec2.x - startVec2.x, 2) + Math.pow(endVec2.y - startVec2.y, 2));

    }
    public String toSvg() {
        //trzebaby dodać: Locale.ENGLISH
//        return String.format("<line x1='%f' y1='%f' x2='%f' y2='%f' stroke='black'/>",
//                startPoint.x, startPoint.y, endPoint.x, endPoint.y);
        return "<line x1='" + this.startVec2.x + "' y1='" + this.startVec2.y +
                "' x2='" + this.endVec2.x + "' y2='" + this.endVec2.y +"' stroke='black' />";
    }
    @Override
    public String toString() {
        return this.toSvg();
    }
    public static Segment[] perpendicularSegments(Segment segment, Vec2 point) {
        double dx = segment.getEndPoint().x - segment.getStartPoint().x;
        double dy = segment.getEndPoint().y - segment.getStartPoint().y;
        //w skrocie:
        return new Segment[] {
                new Segment(point, new Vec2(
                        point.x - dy, point.y + dx
                )),
                new Segment(point, new Vec2(
                        point.x + dy, point.y - dx
                )),
        };
//
//        // Wektory prostopadłe do oryginalnego segmentu: (-dy, dx) i (dy, -dx)
//        //rozowy na obrazku:
//        double perpDx1 = -dy;
//        double perpDy1 = dx;
//        //zielony na obrazku:
//        double perpDx2 = dy;
//        double perpDy2 = -dx;
//
//        // Obliczanie końcowych punktów dla obu możliwych odcinków prostopadłych
//        double endX1 = point.x + perpDx1;
//        double endY1 = point.y + perpDy1;
//
//        double endX2 = point.x + perpDx2;
//        double endY2 = point.y + perpDy2;
//
//        // Tworzenie dwóch odcinków
//        Segment segment1 = new Segment(new Point(point.x, point.y), new Point(endX1, endY1));
//        Segment segment2 = new Segment(new Point(point.x, point.y), new Point(endX2, endY2));
//
//
//        return new Segment[] { segment1, segment2 };


    }


    public static Segment[] perpendicularSegments(Segment segment, Vec2 center, double length) {

        // wektor oryginalnego segmentu:
        //double dx = segment.getEndPoint().x - segment.getStartPoint().x;
        //double dy = segment.getEndPoint().y - segment.getStartPoint().y;

        //w skrocie:
        double dx = ((segment.getEndPoint().getX() - segment.getStartPoint().getX())/segment.length())*length ;
        double dy = ((segment.getEndPoint().getY() - segment.getStartPoint().getY())/segment.length())*length  ;
        return new Segment[] {
                new Segment(center, new Vec2(
                        center.x - dy, center.y + dx
                )),
                new Segment(center, new Vec2(
                        center.x + dy, center.y - dx
                )),
        };
//        // wektor jednostkowy:
//        double udx = dx / segment.length(); // dlugosc oryginalnego odcinka
//        double udy = dy / segment.length(); // dlugosc oryginalnego odcinka
//        // wektory prostopadle:
//        double perpDx1 = -udy;
//        double perpDy1 = udx;
//        double perpDx2 = udy;
//        double perpDy2 = -udx;
//        // przeskalowanie do nowej dlugosci (pomnozone przez nowa dlugosc):
//        perpDx1 = perpDx1 * length;
//        perpDy1 = perpDy1 * length;
//        perpDx2 = perpDx2 * length;
//        perpDy2 = perpDy2 * length;
//
//        // nowe segmenty:
//        Segment segment1 = new Segment(center, new Point(center.getX() + perpDx1, center.getY() + perpDy1));
//        Segment segment2 = new Segment(center, new Point(center.getX() + perpDx2, center.getY() + perpDy2));
//
//        return new Segment[]{segment1, segment2};
    }
}