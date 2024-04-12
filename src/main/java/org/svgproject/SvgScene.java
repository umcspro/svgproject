package org.example.ooplab3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
public class SvgScene {
    private static SvgScene instance = null;
    private static int index = 0;
    private List<Shape> shapes;
    private List<String> defs = new ArrayList<>();
    static public SvgScene getInstance(){
        if(instance == null){
            instance = new SvgScene();
        }
        return instance;
    }
    public SvgScene() {
        this.shapes = new ArrayList<>();
    }
    public void addShape(Shape shape) {
        this.shapes.add(shape);
    }
    public int addFilter(String filter){
        defs.add(
                String.format(filter, ++index)
        );
        return index;
    }
    public void save(String path)
    {
        try {
            FileWriter fileWriter = new FileWriter(path);
            fileWriter.write("<HTML>");
            fileWriter.write("<body>");
            fileWriter.write(
                    String.format(Locale.ENGLISH,
                            "<svg width=\"%f\" height=\"%f\" xmlns=\"http://www.w3.org/2000/svg\">\n",
                            1000.0,
                            1000.0
                    )
            );
            fileWriter.write("<defs>");
            /* \t<filter id=\"f%d\" x=\"-100%%\" y=\"-100%%\" width=\"300%%\" height=\"300%%\">\n" +
            "\t\t<feOffset result=\"offOut\" in=\"SourceAlpha\" dx=\"5\" dy=\"5\" />\n" +
            "\t\t<feGaussianBlur result=\"blurOut\" in=\"offOut\" stdDeviation=\"5\" />\n" +
            "\t\t<feBlend in=\"SourceGraphic\" in2=\"blurOut\" mode=\"normal\" />\n" +
            "\t</filter>", index
            */
            for(String def : defs){
                fileWriter.write(def + "\n");
            }
            fileWriter.write("</defs>");
            for(Shape polygon : shapes)
                fileWriter.write("\t" + polygon.toSvg("") + "\n");
            fileWriter.write("</svg>");
            fileWriter.write("</body>");
            fileWriter.write("</HTML>");
            fileWriter.close();
        } catch (IOException e) {
            System.err.println("can't write to "+ path);
        }
    }
}