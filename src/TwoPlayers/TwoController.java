
package TwoPlayers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import scene.ChangeView;

/**
 * FXML Controller class
 *
 * @author Hadeer
 */
public class TwoController implements Initializable {
    
    XOAlgo obj = new XOAlgo();
    ChangeView cv = new ChangeView();
    
    /*private int p1score;
    private int p2score;
    */
    
    @FXML Button btn1;
    @FXML Button btn2;
    @FXML Button btn3;
    @FXML Button btn4;
    @FXML Button btn5;
    @FXML Button btn6;
    @FXML Button btn7;
    @FXML Button btn8;
    @FXML Button btn9;
    
    @FXML Label score1;
    @FXML Label score2;
    
    public void changeScreenToMain(ActionEvent event) throws IOException{
        cv.changeScene("/start/start.fxml", event);
    }
 
    
    //btn1 Action handler
    public  void btn1Handler(ActionEvent event) throws IOException{
        btnChanger(btn1, event, 0, 0);
    }
    
    public  void btn2Handler(ActionEvent event) throws IOException{
        btnChanger(btn2, event, 0, 1);
    }
    public  void btn3Handler(ActionEvent event) throws IOException{
        btnChanger(btn3, event, 0, 2);
    }
    public  void btn4Handler(ActionEvent event) throws IOException{
        btnChanger(btn4, event, 1, 0);
    }
    public  void btn5Handler(ActionEvent event) throws IOException{
        btnChanger(btn5, event, 1, 1);
    }
    public  void btn6Handler(ActionEvent event) throws IOException{
        btnChanger(btn6, event, 1, 2);
    }
    public  void btn7Handler(ActionEvent event) throws IOException{
        btnChanger(btn7, event, 2, 0);
    }
    public  void btn8Handler(ActionEvent event) throws IOException{
        btnChanger(btn8, event, 2, 1);
    }
    public  void btn9Handler(ActionEvent event) throws IOException{
        btnChanger(btn9, event, 2, 2);
    }
    
    public void btnChanger(Button btn,ActionEvent event ,int a, int b) throws IOException{
        if(obj.getValue(a,b) == 0)
        {
            if (obj.getCounter()%2 != 0){
                btn.setText("O");
                obj.setArr(a, b, -1);
            }
            else{
                btn.setText("X");
                obj.setArr(a, b, 1);
            }
            obj.resultScene(event);
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
