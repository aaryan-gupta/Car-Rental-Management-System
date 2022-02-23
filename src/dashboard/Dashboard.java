package dashboard;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Dashboard {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void doBillCollector(MouseEvent event) {
    	try {
			Parent rootParent = FXMLLoader.load(getClass().getClassLoader().getResource("billCollector/BillCollector.fxml"));
			Scene scene = new Scene(rootParent);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }

    @FXML
    void doBillGenerator(MouseEvent event) {
    	try {
			Parent rootParent = FXMLLoader.load(getClass().getClassLoader().getResource("billGenerator/BillGenerator.fxml"));
			Scene scene = new Scene(rootParent);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }

    @FXML
    void doCustomersProfile(MouseEvent event) {
    	try {
			Parent rootParent = FXMLLoader.load(getClass().getClassLoader().getResource("customersControlPanel/Customers.fxml"));
			Scene scene = new Scene(rootParent);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }

    @FXML
    void doCustomersRecord(MouseEvent event) {
    	try {
			Parent rootParent = FXMLLoader.load(getClass().getClassLoader().getResource("customersDisplayBoard/CustomersDB.fxml"));
			Scene scene = new Scene(rootParent);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }

    @FXML
    void doDriversProfile(MouseEvent event) {
    	try {
			Parent rootParent = FXMLLoader.load(getClass().getClassLoader().getResource("driversControlPanel/Drivers.fxml"));
			Scene scene = new Scene(rootParent);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }

    @FXML
    void doDriversRecord(MouseEvent event) {
    	try {
			Parent rootParent = FXMLLoader.load(getClass().getClassLoader().getResource("driversDisplayBoard/DriversDB.fxml"));
			Scene scene = new Scene(rootParent);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }

    @FXML
    void doLogout(MouseEvent event) {
    	System.exit(0);
    }

    @FXML
    void initialize() {

    }
}
