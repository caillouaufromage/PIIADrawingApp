package Projet;

import Projet.ShapeContainers.*;
import Projet.ShapeContainers.BoundShapes.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeLineJoin;

public class MainControl
{
	@FXML private Pane canvas;
	@FXML private ColorPicker cFill;
	@FXML private ColorPicker cStroke;
	@FXML private ToggleButton pfill;
	@FXML private ToggleButton prounded;
	private ShapeList selectedShapeType = ShapeList.SELECT;
	private double lineWidth = 10;
	private BoundShape selectedShapeContainer;

	/** Fonctions publiques */

	public Pane getCanvas() {
		return canvas;
	}

	public ShapeList getSelectedAction() {
		return selectedShapeType;
	}

	public void select(BoundShape shape) {
		if(selectedShapeContainer != null)
			selectedShapeContainer.shape().setOpacity(1);

		selectedShapeContainer = shape;
		selectedShapeContainer.shape().setOpacity(0.8);
	}

	public void selectNone() {
		if(selectedShapeContainer != null)
			selectedShapeContainer.shape().setOpacity(1);

		selectedShapeContainer = null;
	}

	/** Fonctions privées */

	private void decorate(Shape s) {
		s.setStroke( cStroke.getValue() );
		s.setStrokeWidth(lineWidth);

		if( pfill.isSelected() ) {
			s.setFill( cFill.getValue() );
		} else {
			s.setFill( null );
		}

		if( prounded.isSelected() ) {
			s.setStrokeLineJoin( StrokeLineJoin.ROUND );
		} else {
			s.setStrokeLineJoin( StrokeLineJoin.MITER );
		}
	}

	/** Contrôleurs canvas */

	@FXML
	protected void canvasPressed(MouseEvent e) {
		System.out.println("Adding a " + selectedShapeType);

		BoundShapeAdapter bsa = null;

		switch(selectedShapeType) {
			case SELECT:
				return;

			case CIRCLE:
				bsa = new CircleAdapter();
				break;

			case SQUARE:
				bsa = new SquareAdapter();
				break;

			case TRIANGLE:
				bsa = new TriangleAdapter();
				break;

			case LINE:
				bsa = new LineAdapter();
				break;
		}

		if(!selectedShapeType.MULTIPOINT) {
			BoundShape bs = new BoundShape(e.getX(), e.getY(), bsa, this);
			Shape shape = bsa.getShape();
			canvas.getChildren().add(shape);
			decorate(shape);
			select(bs);
		} else {
			System.out.println("Not Yet Implemented");
		}
	}

	@FXML
	protected void canvasDragged(MouseEvent e) {
	}

	@FXML
	protected void canvasReleased(MouseEvent e) {}

	@FXML
	protected void canvasClicked(MouseEvent e) {
		if(selectedShapeType == ShapeList.SELECT)
			selectNone();
	}

	/** Contrôleurs boutons */

	@FXML
	protected void historyBack(ActionEvent e) {}

	@FXML
	protected void historyForward(ActionEvent e) {}

	@FXML
	protected void shapePointer(ActionEvent e) {
		selectedShapeType = ShapeList.SELECT;
	}

	@FXML
	protected void shapeLine(ActionEvent e)
	{
		selectedShapeType = ShapeList.LINE;
	}

	@FXML
	protected void shapeTriangle(ActionEvent e)
	{
		selectedShapeType = ShapeList.TRIANGLE;
	}

	@FXML
	protected void shapeRectangle(ActionEvent e)
	{
		selectedShapeType = ShapeList.SQUARE;
	}

	@FXML
	protected void shapeCircle(ActionEvent e)
	{
		selectedShapeType = ShapeList.CIRCLE;
	}

	@FXML
	protected void shapePolygon(ActionEvent e)
	{
		selectedShapeType = ShapeList.POLYGON;
	}

	@FXML
	protected void shapeFree(ActionEvent e)
	{
		selectedShapeType = ShapeList.FREE;
	}

	@FXML
	protected void propertyFill(ActionEvent e) {
		decorate( selectedShapeContainer.shape() );
	}

	@FXML
	protected void propertyRounded(ActionEvent e) {
		decorate( selectedShapeContainer.shape() );
	}

	@FXML
	protected void actionBackward(ActionEvent e) {}

	@FXML
	protected void actionForward(ActionEvent e) {
		selectedShapeContainer.shape().toFront();
	}

	@FXML
	protected void actionPolygon(ActionEvent e) {
		selectedShapeContainer.shape().toBack();
	}

	@FXML
	protected void actionDelete(ActionEvent e) {
		canvas.getChildren().remove( selectedShapeContainer.shape() );
		selectedShapeContainer = null;
	}

	@FXML
	protected void colorFill(ActionEvent e) {
		pfill.setSelected(true);
		decorate( selectedShapeContainer.shape() );
	}

	@FXML
	protected void colorStroke(ActionEvent e) {
		decorate( selectedShapeContainer.shape() );
	}

	@FXML
	protected void propertyFin(ActionEvent e) {
		lineWidth = 5;
		decorate( selectedShapeContainer.shape() );
	}

	@FXML
	protected void propertyMoyen(ActionEvent e) {
		lineWidth = 10;
		decorate( selectedShapeContainer.shape() );
	}

	@FXML
	protected void propertyEpais(ActionEvent e) {
		lineWidth = 15;
		decorate( selectedShapeContainer.shape() );
	}
}