package Projet.ShapeContainers.BoundShapes;

import javafx.scene.shape.Shape;

public interface BoundShapeAdapter {
	Shape getShape();
	void updateShape(Double x1, Double x2, Double y1, Double y2);
}
