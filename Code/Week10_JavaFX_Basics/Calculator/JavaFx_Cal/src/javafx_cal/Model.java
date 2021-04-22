/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_cal;

/**
 *
 * @author 179
 */
class Model {
    public float calculate(long number1, long number2, String operator){
        switch(operator){
            case "+":
                return number1+number2;
            case "-":
                return number1-number2;
            case "*":
                return number1*number2;
            case "/":
                if(number2 == 0)
                    return 0;
                return Math.floorDiv(number1, number2);//normal div create problem at parseLong
            default:
                return 0;
        }
    }
}
