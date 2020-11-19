package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView result;
    TextView ac;
    TextView change;
    TextView percent;
    TextView multiply;
    TextView plus;
    TextView minus;
    TextView divide;
    TextView equal;
    TextView point;
    TextView zero;
    TextView one;
    TextView two;
    TextView three;
    TextView four;
    TextView five;
    TextView six;
    TextView seven;
    TextView eight;
    TextView nine;
    boolean clickEqual = false;
    double firstNum;
    double nextNum;
    double end;
    String sign = "";
    DecimalFormat decimalFormat;
    String percentStr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (TextView) findViewById(R.id.result);
        ac = (TextView) findViewById(R.id.ac);
        change = (TextView) findViewById(R.id.signchange);
        percent = (TextView) findViewById(R.id.percentsign);
        multiply = (TextView) findViewById(R.id.multiplicationsign);
        plus = (TextView) findViewById(R.id.plussign);
        minus = (TextView) findViewById(R.id.minussign);
        divide = (TextView) findViewById(R.id.divisionsign);
        equal = (TextView) findViewById(R.id.equalsign);
        point = (TextView) findViewById(R.id.pointsign);
        zero = (TextView) findViewById(R.id.sign_0);
        one = (TextView) findViewById(R.id.sign_1);
        two = (TextView) findViewById(R.id.sign_2);
        three = (TextView) findViewById(R.id.sign_3);
        four = (TextView) findViewById(R.id.sign_4);
        five = (TextView) findViewById(R.id.sign_5);
        six = (TextView) findViewById(R.id.sign_6);
        seven = (TextView) findViewById(R.id.sign_7);
        eight = (TextView) findViewById(R.id.sign_8);
        nine = (TextView) findViewById(R.id.sign_9);
        ac.setOnClickListener(this);
        change.setOnClickListener(this);
        percent.setOnClickListener(this);
        multiply.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        divide.setOnClickListener(this);
        equal.setOnClickListener(this);
        point.setOnClickListener(this);
        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        result.setText("0");
    }

    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.ac:
                sign="";
                result.setText("0");
                break;
            case R.id.signchange:
                String changeStr = result.getText().toString();
                Double changeNum = Double.parseDouble(changeStr);
                changeNum = 0 - changeNum;
                changeStr = String.valueOf(changeNum);
                if(changeNum%1 == 0) {
                    changeStr = changeStr.replace(".0","");
                }
                result.setText(changeStr);
                break;
            case R.id.percentsign:
                percentStr = result.getText().toString();
                double percentDouble = Double.parseDouble(percentStr);
                if (percentStr == "0") {
                    percentDouble = 0;
                }
                percentDouble = percentDouble / 100;
                percentStr = String.valueOf(percentDouble);
                result.setText(percentStr);
                break;
            case R.id.pointsign:
                String pointStr = result.getText().toString();
                char[] pointChar = pointStr.toCharArray();
                int pointCount = 0;
                for (int i = 0; i < pointChar.length; i++) {
                    if (pointChar[i] == '.') {
                        pointCount++;
                        if (pointCount != 0) {
                            return;
                        }
                    }
                }
                pointStr += ".";
                result.setText(pointStr);
                break;
            //4つの算術記号
            case R.id.multiplicationsign:
                if(sign==""){
                String multiplyStr = result.getText().toString();
                if (multiplyStr.equals("")) {
                    return;
                }
                firstNum = Double.valueOf(multiplyStr);
                result.setText(multiplyStr);
                    sign = "*";
                    clickEqual = false;
                }

                else {
                    equal(equal);
                    sign = "*";
                    firstNum = end;
                }
                break;
            case R.id.plussign:
                if(sign==""){
                String plusStr = result.getText().toString();
                if (plusStr.equals("")) {
                    return;
                }
                firstNum = Double.valueOf(plusStr);
                result.setText(plusStr);
                clickEqual = false;
                }
                else {
                    equal(equal);
                    firstNum = end;
                }
                sign = "+";
                break;
            case R.id.minussign:
                if(sign==""){
                String minusStr = result.getText().toString();
                if (minusStr.equals("")) {
                    return;
                }
                firstNum = Double.valueOf(minusStr);
                result.setText(minusStr);
                sign = "-";
                clickEqual = false;
                }
                else {
                    equal(equal);
                    sign = "-";
                    firstNum = end;
                }
                break;
            case R.id.divisionsign:
                if(sign=="") {
                    String divisionStr = result.getText().toString();
                    if (divisionStr.equals("")) {
                        return;
                    }
                    firstNum = Double.valueOf(divisionStr);
                    result.setText(divisionStr);
                    sign = "/";
                    clickEqual = false;
                }
                else {
                    equal(equal);
                    sign = "/";
                    firstNum = end;
                }
                break;

            case R.id.equalsign:
                equal(equal);
                break;

            //0——9
            case R.id.sign_0:
                String zeroStr = result.getText().toString();
                if (zeroStr == "0"||sign!="") {
                    zeroStr = "0";

                } else {
                    zeroStr += "0";
                }
                result.setText(zeroStr);
                break;
            case R.id.sign_1:
                String oneStr = result.getText().toString();
                if (oneStr == "0"||sign!="") {
                    oneStr = "1";
                } else {
                    oneStr += "1";
                }
                result.setText(oneStr);
                break;
            case R.id.sign_2:
                String twoStr = result.getText().toString();
                if (twoStr == "0"||sign!="") {
                    twoStr = "2";
                } else {
                    twoStr += "2";
                }
                result.setText(twoStr);
                break;
            case R.id.sign_3:
                String threeStr = result.getText().toString();
                if (threeStr == "0"||sign!="") {
                    threeStr = "3";
                } else {
                    threeStr += "3";
                }
                result.setText(threeStr);
                break;
            case R.id.sign_4:
                String fourStr = result.getText().toString();
                if (fourStr == "0"||sign!="") {
                    fourStr = "4";
                } else {
                    fourStr += "4";
                }
                result.setText(fourStr);
                break;
            case R.id.sign_5:
                String fiveStr = result.getText().toString();
                if (fiveStr == "0"||sign!="") {
                    fiveStr = "5";
                } else {
                    fiveStr += "5";
                }
                result.setText(fiveStr);
                break;
            case R.id.sign_6:
                String sixStr = result.getText().toString();
                if (sixStr == "0"||sign!="") {
                    sixStr = "6";
                } else {
                    sixStr += "6";
                }
                result.setText(sixStr);
                break;
            case R.id.sign_7:
                String sevenStr = result.getText().toString();
                if (sevenStr == "0"||sign!="") {
                    sevenStr = "7";
                } else {
                    sevenStr += "7";
                }
                result.setText(sevenStr);
                break;
            case R.id.sign_8:
                String eightStr = result.getText().toString();
                if (eightStr == "0"||sign!="") {
                    eightStr = "8";
                } else {
                    eightStr += "8";
                }
                result.setText(eightStr);
                break;
            case R.id.sign_9:
                String nineStr = result.getText().toString();
                if (nineStr == "0"||sign!="") {
                    nineStr = "9";
                } else {
                    nineStr += "9";
                }
                result.setText(nineStr);
                break;
            default:
        }
    }
    public void equal(View view){
        String equalStr = result.getText().toString();
        if (equalStr.equals("")) {
            return;
        }
        nextNum = Double.valueOf(equalStr);
        result.setText("");
        switch (sign) {
            case "*":
                end = firstNum * nextNum;
                break;
            case "/":
                end = firstNum / nextNum;
                break;
            case "+":
                end = firstNum + nextNum;
                break;
            case "-":
                end = firstNum - nextNum;
                break;
        }
        equalStr = String.valueOf(end);
        if (end % 1 == 0) {
            equalStr = equalStr.replace(".0", "");
        } else {
            DecimalFormat df = new DecimalFormat( "0.00000000");
            Double equalDouble=Double.parseDouble(equalStr);
            equalStr=df.format(equalDouble);
            String getLastNum = equalStr.substring(equalStr.indexOf('.') + 1);
            String getIntegerNum = equalStr.substring(0, equalStr.indexOf('.') + 1);
            boolean getNumBool = getLastNum.contains("0000");
            if(getNumBool==true){
                getLastNum = getLastNum.substring(0, getLastNum.indexOf("0000"));
                equalStr = getIntegerNum + getLastNum;
            }
        }
    result.setText(equalStr);
        clickEqual = true;
    }
}