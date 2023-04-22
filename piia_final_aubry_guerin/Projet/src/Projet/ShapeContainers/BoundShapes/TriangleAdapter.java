package Projet.ShapeContainers.BoundShapes;

import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class TriangleAdapter implements BoundShapeAdapter
{
	private Polygon polygon = new Polygon();

	public Shape getShape() {
		return polygon;
	}

	/* We can trust x1 < x2 and y1 < y2 */
	public void updateShape(Double x1, Double x2, Double y1, Double y2) {
		polygon.getPoints().setAll( new Double[] { x1, y2, x2, y2, (x1 + x2) / 2.0, y1 } );
	}
}
