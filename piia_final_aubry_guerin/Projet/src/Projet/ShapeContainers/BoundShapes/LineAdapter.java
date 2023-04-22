package Projet.ShapeContainers.BoundShapes;

import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class LineAdapter implements BoundShapeAdapter
{
	private Line line = new Line();

	public Shape getShape() {
		return line;
	}

	/* We can trust x1 < x2 and y1 < y2 */
	public void updateShape(Double x1, Double x2, Double y1, Double y2) {
		line.setStartX(x1);
		line.setEndX(x2);
		line.setStartY(y1);
		line.setEndY(y2);
	}
}
