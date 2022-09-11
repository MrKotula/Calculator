package com.example.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainController {

    @FXML
    private Label screen;

    @FXML
    private Button clear_btn;

    @FXML
    private Button comma_btn;

    @FXML
    private Button divide_btn;

    @FXML
    private Button minus_btn;

    @FXML
    private Button mult_btn;

    @FXML
    private Button percent_btn;

    @FXML
    private Button plus_btn;

    @FXML
    private Button plus_minus_btn;

    @FXML
    private Button res_btn;

    String textNum = "";
    float firstNum = 0f;
    char operation = ' ';

    @FXML
    void addNumber(ActionEvent event) {
    textNum += ((Button) event.getSource()).getText();
    screen.setText(textNum);
    }

    @FXML
    void initialize() {
        plus_btn.setOnAction(event -> {
            mathAction('+');
        });
        minus_btn.setOnAction(event -> {
            mathAction('-');
        });
        divide_btn.setOnAction(event -> {
            mathAction('/');
        });
        mult_btn.setOnAction(event -> {
            mathAction('*');
        });
        res_btn.setOnAction(event -> {
            if(operation == '+' || operation == '-' || operation == '*' || operation == '/')
                equalsRes();
        });
        percent_btn.setOnAction(event -> {
            if(!textNum.equals("")) {
                float num = Float.parseFloat(textNum) * 0.1f;
                textNum = String.valueOf(num);
                screen.setText(textNum);
            }
        });
        comma_btn.setOnAction(event -> {
            if(!textNum.contains(".")) {
                textNum += ".";
                screen.setText(textNum);
            }
        });
        plus_minus_btn.setOnAction(event -> {
            if(!textNum.equals("")) {
                float num = Float.parseFloat(textNum) * -1f;
                textNum = String.valueOf(num);
                screen.setText(textNum);
            }
        });
        clear_btn.setOnAction(event ->{
            screen.setText("0");
            textNum = "";
            operation = ' ';
            firstNum =  0f;
        });

    }

    private void equalsRes() {
        float result = 0f;
        switch (operation) {
            case '+':
                result = firstNum + Float.parseFloat(textNum);
                break;
            case '-':
                result = firstNum - Float.parseFloat(textNum);
                break;
            case '*':
                result = firstNum * Float.parseFloat(textNum);
                break;
            case '/':
                float secondNum = Float.parseFloat(textNum);
                if (secondNum == 0)
                    result = 0;
                else
                    result = firstNum / secondNum;
                break;
        }
                screen.setText(Float.toString(result));
                firstNum = 0f;
                textNum = "";
                operation = ' ';
        }

    private void mathAction(char action) {
        if(operation != '+' && operation != '-' && operation != '*' && operation != '/'){
    firstNum = Float.parseFloat(textNum);
    screen.setText(String.valueOf(action));
    textNum = "";
    operation = action;
    }
    }


}

