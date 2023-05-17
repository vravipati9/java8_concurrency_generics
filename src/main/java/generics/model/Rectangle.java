package generics.model;

import generics.model.Canvas;
import generics.model.Shape;

public class Rectangle extends Shape {
    private int x, y, width, height;
    public void draw(Canvas c) {
    	System.out.println("Drawing Rectangle......");
    }
}
