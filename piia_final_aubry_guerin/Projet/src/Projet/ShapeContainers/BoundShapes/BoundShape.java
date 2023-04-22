package Projet.ShapeContainers.BoundShapes;

import Projet.MainControl;
import Projet.ShapeContainers.ShapeList;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

public class BoundShape
{
	private Double x1, x2, y1, y2;
	private Double prevX, prevY;
	protected BoundShapeAdapter shapeAdapter;
	private MainControl control;

	public BoundShape(double x, double y, BoundShapeAdapter shapeAdapter, MainControl control) {
		this.shapeAdapter = shapeAdapter;
		this.control = control;

		update(x, x, y, y);

		shape().setOnMousePressed(e -> onPressed(e));
		shape().setOnMouseDragged(e -> onDragged(e));
		shape().setOnMouseClicked(e -> onClicked(e));

		Pane canvas = control.getCanvas();
		canvas.setOnMouseDragged(e -> update(x1, e.getX(), y1, e.getY()) );
		canvas.setOnMouseReleased(e -> { canvas.setOnMouseDragged(null); control.selectNone(); });
	}

	private void update(Double x1, Double x2, Double y1, Double y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;

		shapeAdapter.updateShape(x1, x2, y1, y2);
	}

	public Shape shape() {
		return shapeAdapter.getShape();
	}

	/** Controllers */

	private void onPressed(MouseEvent e) {
		if(control.getSelectedAction() == ShapeList.SELECT) {
			prevX = e.getX();
			prevY = e.getY();

			control.select(this);
			e.consume();
		}
	}

	private void onDragged(MouseEvent e) {
		if(control.getSelectedAction() == ShapeList.SELECT) {
			Double nextX = e.getX();
			Double nextY = e.getY();

			update(x1 + nextX - prevX, x2 + nextX - prevX, y1 + nextY - prevY, y2 + nextY - prevY);

			prevX = nextX;
			prevY = nextY;

			e.consume();
		}
	}

	private void onClicked(MouseEvent e) {
		if(control.getSelectedAction() == ShapeList.SELECT) {
			control.select(this);
			e.consume();
		}
	}
}
