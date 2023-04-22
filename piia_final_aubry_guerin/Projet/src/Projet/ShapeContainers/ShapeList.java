package Projet.ShapeContainers;

public enum ShapeList {
	SELECT(false),
	LINE(false),
	TRIANGLE(false),
	SQUARE(false),
	CIRCLE(false),
	POLYGON(true),
	FREE(true);

	public final boolean MULTIPOINT;

	private ShapeList(boolean multipoint) {
		MULTIPOINT = multipoint;
	}
}
