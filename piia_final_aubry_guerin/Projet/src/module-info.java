module test {
	requires javafx.controls;
	requires javafx.fxml;


	opens Projet to javafx.fxml;
	exports Projet;
	opens Projet.ShapeContainers to javafx.fxml;
	exports Projet.ShapeContainers;
	exports Projet.ShapeContainers.BoundShapes;
	opens Projet.ShapeContainers.BoundShapes to javafx.fxml;
}