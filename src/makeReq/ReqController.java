/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makeReq;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import scene.ChangeView;
/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class ReqController implements Initializable {

    ChangeView cv = new ChangeView();
    
    
    @FXML
    private RadioButton rBtnX;
    @FXML
    private RadioButton rBtnO;
    @FXML
    private Button btnSendReq;
    @FXML
    private Button btnCancelReq;
    @FXML
    private CheckBox ckBxRecordReq;
    @FXML
    private ToggleGroup xo;
    private char play = 'x';

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backToOnlinePlayers(ActionEvent event) throws IOException {
        cv.changeScene("/onlinePlayers/onlineXML.fxml", event);
    }
    
    @FXML
    private void sendReq(ActionEvent event) throws IOException {
        cv.changeScene("/receiveReq/ReceiveReq.fxml", event);
    }

    @FXML
    private void setX(ActionEvent event) {
        play='x';
        System.out.println(""+play);
    }

    @FXML
    private void setO(ActionEvent event) {
        play='o';
        System.out.println(""+play);
    }

    @FXML
    private void recordGame(ActionEvent event){
            System.out.println("Recorded");
    }
   
}
