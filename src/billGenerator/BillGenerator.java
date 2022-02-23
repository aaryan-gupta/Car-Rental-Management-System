package billGenerator;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import connection.Connect;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class BillGenerator {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtMobile;

    @FXML
    private TextField txtDistance;

    @FXML
    private TextField txtDays;

    @FXML
    private TextField txtRate;

    @FXML
    private TextField txtAmount;

    @FXML
    void btnCalculate(ActionEvent event) {
    	int amount = Integer.parseInt(txtDistance.getText()) * Integer.parseInt(txtRate.getText());
    	System.out.println(amount);
    	txtAmount.setText(String.valueOf(amount));
    }

    @FXML
    void btnFetchBill(ActionEvent event) {
    	try {
			ps = connection.prepareStatement("select * from trip_planner where customersMobile=?");
			ps.setString(1, txtMobile.getText());
			ResultSet set = ps.executeQuery();
			if(set.next()) {
				txtMobile.setText(set.getString("customersMobile"));
				txtDays.setText(set.getString("days"));
				txtRate.setText(String.valueOf(set.getInt("rate")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void btnSave(ActionEvent event) {
    	try {
			ps = connection.prepareStatement("insert into billing (customersMobile, distance, days, rate, amount, status) values (?, ?, ?, ?, ?, 0)");
			ps.setString(1, txtMobile.getText());
			ps.setString(2, txtDistance.getText());
			ps.setString(3, txtDays.getText());
			ps.setString(4, txtRate.getText());
			ps.setInt(5, Integer.parseInt(txtAmount.getText()));
			ps.executeUpdate();
			System.out.println("SAVED");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }

    @FXML
    void btnUpdate(ActionEvent event) {

    }
    Connection connection;
    PreparedStatement ps;

    @FXML
    void initialize() {
        assert txtMobile != null : "fx:id=\"txtMobile\" was not injected: check your FXML file 'BillGenerator.fxml'.";
        assert txtDistance != null : "fx:id=\"txtDistance\" was not injected: check your FXML file 'BillGenerator.fxml'.";
        assert txtDays != null : "fx:id=\"txtDays\" was not injected: check your FXML file 'BillGenerator.fxml'.";
        assert txtRate != null : "fx:id=\"txtRate\" was not injected: check your FXML file 'BillGenerator.fxml'.";
        assert txtAmount != null : "fx:id=\"txtAmount\" was not injected: check your FXML file 'BillGenerator.fxml'.";
        connection = Connect.getConnection();
    }
}
