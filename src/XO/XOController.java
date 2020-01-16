/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XO;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import scene.ChangeView;

/**
 *
 * @author user
 */
public class XOController extends SingleMode {
    
    ChangeView cv = new ChangeView();

    @FXML private Button btn1;
    @FXML private Button btn2;
    @FXML private Button btn3;
    @FXML private Button btn4;
    @FXML private Button btn5;
    @FXML private Button btn6;
    @FXML private Button btn7;
    @FXML private Button btn8;
    @FXML private Button btn9;

    private int winner;

    public void changeScreenToMain(ActionEvent event) throws IOException {
        cv.changeScene("/start/start.fxml", event);
    }


    public void btnMethod(Button btn, int x) {
        if (arr[x] == 0) {
            btn.setText("x");
            arr[x] = 1;
            drawCounter++;
            if (drawCounter != 9) {
                computerPlay();
            }
            winner = checkForWinner();

        }
    }
    
    public void changeScene2(ActionEvent event) throws IOException{
        
        if (winner != 0) {
                if (winner == 2) {
                    cv.changeScene("/drawScene/drawView.fxml", event);
                }
                else if(winner == 1){
                    cv.changeScene("/winnerScene/winnerView.fxml", event);
                }
                else if(winner == -1){
                    cv.changeScene("/loserScene/loserView.fxml", event);
                }
            }
        
    }

    public void btn1Handler(ActionEvent event) throws IOException {
        btnMethod(btn1, 0);
        changeScene2(event);
    }

    public void btn2Handler(ActionEvent event) throws IOException {
        btnMethod(btn2, 1);
        changeScene2(event);
    }

    public void btn3Handler(ActionEvent event) throws IOException {
        btnMethod(btn3, 2);
        changeScene2(event);
    }

    public void btn4Handler(ActionEvent event) throws IOException {
        btnMethod(btn4, 3);
        changeScene2(event);
    }

    public void btn5Handler(ActionEvent event) throws IOException {
        btnMethod(btn5, 4);
        changeScene2(event);
    }

    public void btn6Handler(ActionEvent event) throws IOException {
        btnMethod(btn6, 5);
        changeScene2(event);
    }

    public void btn7Handler(ActionEvent event) throws IOException {
        btnMethod(btn7, 6);
        changeScene2(event);
    }

    public void btn8Handler(ActionEvent event) throws IOException {
        btnMethod(btn8, 7);
        changeScene2(event);
    }

    public void btn9Handler(ActionEvent event) throws IOException {
        btnMethod(btn9, 8);
        changeScene2(event);
    }
}

/*
    //setter
     public void setVal(int _val)
    {
        value = _val;
        System.out.println(value);
        if (value ==2)
        {
            player1.setText("player1");
            player2.setText("player2");
        }
    } */
