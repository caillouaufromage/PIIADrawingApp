package Projet.ShapeContainers.BoundShapes;

import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class SquareAdapter implements BoundShapeAdapter
{
	private Rectangle rectangle = new Rectangle();

	public Shape getShape() {
		return rectangle;
	}

	/* We can trust x1 < x2 and y1 < y2 */
	public void updateShape(Double x1, Double x2, Double y1, Double y2) {
		rectangle.setX( Math.min(x1, x2) );
		rectangle.setY( Math.min(y1, y2) );
		rectangle.setWidth( Math.abs(x2 - x1) );
		rectangle.setHeight( Math.abs(y2 - y1) );
	}
}
