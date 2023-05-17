package generics.model;

import java.util.List;

public class Canvas {
    public void draw(Shape s) {
        s.draw(this);
   }
    public void drawAll(List<Shape> shapes) {
        for (Shape s: shapes) {
            s.draw(this);
       }
    }
}
