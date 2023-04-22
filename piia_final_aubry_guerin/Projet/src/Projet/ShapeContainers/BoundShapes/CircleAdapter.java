package Projet.ShapeContainers.BoundShapes;

import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Shape;

public class CircleAdapter implements BoundShapeAdapter
{
	private Ellipse ellipse = new Ellipse();

	public Shape getShape() {
		return ellipse;
	}

	/* We can trust x1 < x2 and y1 < y2 */
	public void updateShape(Double x1, Double x2, Double y1, Double y2) {
		ellipse.setCenterX( (x1 + x2) / 2 );
		ellipse.setCenterY( (y1 + y2) / 2 );
		ellipse.setRadiusX( Math.abs(x2 - x1) / 2 );
		ellipse.setRadiusY( Math.abs(y2 - y1) / 2 );
	}
}
