package generics;

import generics.model.Canvas;
import generics.model.Circle;
import generics.model.Rectangle;
import generics.model.Shape;

import java.util.ArrayList;
import java.util.List;

public class Drawing {

	public static void main(String[] args) {
		List<Shape> drawingList = new ArrayList<>();
		drawingList.add(new Circle());
		drawingList.add(new Rectangle());
		Canvas c = new Canvas();
		c.drawAll(drawingList);
	}
}
