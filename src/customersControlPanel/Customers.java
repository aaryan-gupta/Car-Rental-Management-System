package customersControlPanel;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import connection.Connect;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Customers {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtMobile;

    @FXML
    private TextField txtTime;

    @FXML
    private TextField txtDestination;

    @FXML
    private TextField txtDays;

    @FXML
    private TextArea txtAddress;

    @FXML
    private DatePicker txtDate;

    @FXML
    private ComboBox<String> comboCar;

    @FXML
    void doDelete(ActionEvent event) {
    	try {
			ps = connection.prepareStatement("delete from customers where mobile=?");
			ps.setString(1, txtMobile.getText());
			ps.executeUpdate();
			System.out.println("DELETED");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void doSave(ActionEvent event) {
    	try {
			ps = connection.prepareStatement("insert into customers (name, mobile, address, date, time, destination, days, requirement) values (?, ?, ?, curdate(), ?, ?, ?, ?)");
			ps.setString(1, txtName.getText());
			ps.setString(2, txtMobile.getText());
			ps.setString(3, txtAddress.getText());
//			ps.setDate(4, txtDate.getValue());
			ps.setString(4, txtTime.getText());
			ps.setString(5, txtDestination.getText());
			ps.setString(6, txtDays.getText());
			ps.setString(7, comboCar.getSelectionModel().getSelectedItem());
			ps.executeUpdate();
			System.out.println("SAVED");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void doSearch(ActionEvent event) {
    	try {
			ps = connection.prepareStatement("select * from customers where mobile=?");
			ps.setString(1, txtMobile.getText());
	    	ResultSet set = ps.executeQuery();
	    	if(set.next()) {
	    		txtName.setText(set.getString("name"));
	    		txtMobile.setText(set.getString("mobile"));
	    		txtAddress.setText(set.getString("address"));
//	    		txtDate.set(set.getString("date"));
	    		txtTime.setText(set.getString("time"));
	    		txtDestination.setText(set.getString("destination"));
	    		txtDays.setText(set.getString("days"));
	    		comboCar.getSelectionModel().select(set.getString("requirement"));
	    	}
	    	else System.out.println("INVALID");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void doUpdate(ActionEvent event) {
    	try {
			ps = connection.prepareStatement("update customers set name=?, address=?, time=?, destination=?, days=?, requirement=? where mobile=?");
			ps.setString(1, txtName.getText());
			ps.setString(7, txtMobile.getText());
			ps.setString(2, txtAddress.getText());
//			ps.setDate(4, txtDate.getValue());
			ps.setString(3, txtTime.getText());
			ps.setString(4, txtDestination.getText());
			ps.setString(5, txtDays.getText());
			ps.setString(6, comboCar.getSelectionModel().getSelectedItem());
			ps.executeUpdate();
			System.out.println("UPDATED");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
    void doClear(ActionEvent event) {
    	txtName.clear();
    	txtMobile.clear();
    	txtAddress.clear();
    	txtTime.clear();
    	txtDestination.clear();
    	txtDays.clear();
    	comboCar.getSelectionModel().clearSelection();
//    	comboCar.getItems().addAll("Bugatti", "Audi");
    }
    
    Connection connection;
    PreparedStatement ps;

    @FXML
    void initialize() {
        assert txtName != null : "fx:id=\"txtName\" was not injected: check your FXML file 'Customers.fxml'.";
        assert txtMobile != null : "fx:id=\"txtMobile\" was not injected: check your FXML file 'Customers.fxml'.";
        assert txtTime != null : "fx:id=\"txtTime\" was not injected: check your FXML file 'Customers.fxml'.";
        assert txtDestination != null : "fx:id=\"txtDestination\" was not injected: check your FXML file 'Customers.fxml'.";
        assert txtDays != null : "fx:id=\"txtDays\" was not injected: check your FXML file 'Customers.fxml'.";
        assert txtAddress != null : "fx:id=\"txtAddress\" was not injected: check your FXML file 'Customers.fxml'.";
        assert txtDate != null : "fx:id=\"txtDate\" was not injected: check your FXML file 'Customers.fxml'.";
        assert comboCar != null : "fx:id=\"comboCar\" was not injected: check your FXML file 'Customers.fxml'.";
        connection = Connect.getConnection();
        comboCar.getItems().addAll("Bugatti", "Audi");
    }
}
