package tripPlanner;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import connection.Connect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class Trip {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> comboDriver;

    @FXML
    private TextField txtCustomer;

    @FXML
    private TextField txtCar;

    @FXML
    private TextField txtDays;

    @FXML
    private TextField txtRate;

    @FXML
    void doClear(ActionEvent event) {

    }

    @FXML
    void doDelete(ActionEvent event) {

    }

    @FXML
    void doSave(ActionEvent event) {
    	try {
			ps = connection.prepareStatement("insert into trip_planner values (?, ?, ?, ?, ?)");
			ps.setString(1, comboDriver.getSelectionModel().getSelectedItem());
			ps.setString(2, txtCustomer.getText());
			ps.setString(3, txtCar.getText());
			ps.setString(4, txtDays.getText());
			ps.setString(5, txtRate.getText());
			ps.executeUpdate();
			System.out.println("SAVED");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void doSearch(ActionEvent event) {

    }

    @FXML
    void doUpdate(ActionEvent event) {

    }
    
    Connection connection;
    PreparedStatement ps;

    @FXML
    void initialize() {
        assert comboDriver != null : "fx:id=\"comboDriver\" was not injected: check your FXML file 'Trip.fxml'.";
        assert txtCustomer != null : "fx:id=\"txtCustomer\" was not injected: check your FXML file 'Trip.fxml'.";
        assert txtCar != null : "fx:id=\"txtCar\" was not injected: check your FXML file 'Trip.fxml'.";
        assert txtDays != null : "fx:id=\"txtDays\" was not injected: check your FXML file 'Trip.fxml'.";
        assert txtRate != null : "fx:id=\"txtRate\" was not injected: check your FXML file 'Trip.fxml'.";
        connection = Connect.getConnection();
        ObservableList<String> observableList = FXCollections.observableArrayList();
        try {
			ps = connection.prepareStatement("select * from drivers");
			ResultSet set = ps.executeQuery();
			while(set.next()) observableList.add(set.getString("name"));
			comboDriver.setItems(observableList);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
}
