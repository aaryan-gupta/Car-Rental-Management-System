package billCollector;

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

public class BillCollector {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtMobile;

    @FXML
    private TextField txtAmount;

    @FXML
    void btnFetchBill(ActionEvent event) {
    	try {
			ps = connection.prepareStatement("select * from billing where status=0 and customersMobile=?");
			ps.setString(1, txtMobile.getText());
			ResultSet set = ps.executeQuery();
			if (set.next()) {
				txtAmount.setText(String.valueOf(set.getInt("amount")));
			}
			else System.out.println("BILL ALREADY PAID");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }

    @FXML
    void txtBillPaid(ActionEvent event) {
    	try {
			ps = connection.prepareStatement("update billing set status=1 where customersMobile=? and status=0");
			ps.setString(1, txtMobile.getText());
			ps.executeUpdate();
			System.out.println("BILL PAID");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
    
    Connection connection;
    PreparedStatement ps;

    @FXML
    void initialize() {
        assert txtMobile != null : "fx:id=\"txtMobile\" was not injected: check your FXML file 'BillCollector.fxml'.";
        assert txtAmount != null : "fx:id=\"txtAmount\" was not injected: check your FXML file 'BillCollector.fxml'.";
        connection = Connect.getConnection();
    }
}
