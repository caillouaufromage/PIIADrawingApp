package Projet;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application
{
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		primaryStage.setTitle("EverDraw");
		AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("draw_appli.fxml"));

		Scene scene = new Scene(pane);

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args)
	{
		launch(args);
	}
}
