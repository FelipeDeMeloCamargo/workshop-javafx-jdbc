package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class MaingViewControler implements Initializable{
	
	@FXML
	private MenuItem menuItemSeller;
	
	@FXML
	private MenuItem menuItemDepartment;
	
	@FXML
	private MenuItem menuItemAbout;
	
	//métodos para tratar cada item de menu
	
	@FXML
	public void onMenuItemSellerAction() {
		System.out.println("onMenuItemSellerAction"); 
	}
	
	@FXML
	public void onMenuItemDepartmentAction() {
		loadView("/gui/DepartmentList.fxml");//carregar a view  
	}
	@FXML
	public void onMenuItemAboutAction() {
		loadView("/gui/About.fxml");//carregar a view
	}
	



	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		// TODO Auto-generated method stub
		
	}
	
	private void loadView(String absoluteName) {  //funcao para exibir uma tela expecifica de alerta
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));//para carregar a tela
			VBox newVbox = loader.load();
		
			Scene mainScene = Main.getMainScene(); 
			VBox mainVBox = (VBox) ((ScrollPane)mainScene.getRoot()).getContent();//pega o primeiro elemento da view
			
			Node mainMenu = mainVBox.getChildren().get(0);//é o primeiro filho do vbox da janela principal, o main menu
			mainVBox.getChildren().clear();
			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().addAll(newVbox.getChildren());
		}
		catch(IOException e) {
			Alerts.showAlert("Io Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
	}

}
