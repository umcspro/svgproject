package org.svgproject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
public class SvgScene {
    private static SvgScene instance = null;
    private static int index = 0;
    private List<Shape> shapes;
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
            for(Shape shape : shapes)
                fileWriter.write("\t" + shape.toSvg("") + "\n");
            fileWriter.write("</svg>");
            fileWriter.write("</body>");
            fileWriter.write("</HTML>");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}