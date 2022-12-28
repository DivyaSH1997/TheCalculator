package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn_zero, btn_one, btn_two, btn_three, btn_four, btn_five, btn_six, btn_seven, btn_eight, btn_nine;
    Button btn_addition, btn_subtraction, btn_multiplication, btn_division;
    Button btn_clear, btn_equal, btn_dot,btn_back;
    TextView answer_screen, expression_screen;
    String str = "";
    int index=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initListeners();
    }
    public void initViews()
    {
        answer_screen = findViewById(R.id.answer_screen);
        expression_screen = findViewById(R.id.expression_screen);

        btn_zero = findViewById(R.id.btn_zero);
        btn_one = findViewById(R.id.btn_one);
        btn_two = findViewById(R.id.btn_two);
        btn_three = findViewById(R.id.btn_three);
        btn_four = findViewById(R.id.btn_four);
        btn_five = findViewById(R.id.btn_five);
        btn_six = findViewById(R.id.btn_six);
        btn_seven = findViewById(R.id.btn_seven);
        btn_eight = findViewById(R.id.btn_eight);
        btn_nine = findViewById(R.id.btn_nine);
        btn_addition = findViewById(R.id.btn_addition);
        btn_subtraction = findViewById(R.id.btn_subtraction);
        btn_multiplication = findViewById(R.id.btn_multiplication);
        btn_division = findViewById(R.id.btn_division);
        btn_equal = findViewById(R.id.btn_equal);
        btn_dot = findViewById(R.id.btn_dot);
        btn_clear = findViewById(R.id.btn_clear);
        btn_back=findViewById(R.id.btn_back);
    }
    public void initListeners()
    {
        btn_zero.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                expression_screen.setText(str + "0");
                str = str + "0";

            }
        });
        btn_one.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                expression_screen.setText(str + "1");
                str = str + "1";

            }
        });
        btn_two.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                expression_screen.setText(str + "2");
                str = str + "2";

            }
        });
        btn_three.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                expression_screen.setText(str + "3");
                str = str + "3";

            }
        });
        btn_four.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                expression_screen.setText(str + "4");
                str = str + "4";

            }
        });
        btn_five.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                expression_screen.setText(str + "5");
                str = str + "5";

            }
        });
        btn_six.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                expression_screen.setText(str + "6");
                str = str + "6";

            }
        });
        btn_seven.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                expression_screen.setText(str + "7");
                str = str + "7";

            }
        });
        btn_eight.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                expression_screen.setText(str + "8");
                str = str + "8";

            }
        });
        btn_nine.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                expression_screen.setText(str + "9");
                str = str + "9";

            }
        });
        btn_dot.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                expression_screen.setText(str + ".");
                str = str + ".";

            }
        });
        btn_addition.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                expression_screen.setText(str + "+");
                str = str + "+";

            }
        });
        btn_subtraction.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                expression_screen.setText(str + "-");
                str = str + "-";

            }
        });
        btn_multiplication.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                expression_screen.setText(str + "*");
                str = str + "*";

            }
        });
        btn_division.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                expression_screen.setText(str + "/");
                str = str + "/";

            }
        });
        btn_equal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                expression_screen.setText(str + "=");
                disableEquals();


            }
        });
        btn_clear.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                btn_equal.setEnabled(true);
                expression_screen.setText("");
                answer_screen.setText("");
                str="";


            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {

            char data;
            int x=str.length();
            @Override
            public void onClick(View view) {
                str=str.substring(0,str.length()-1) ;
                expression_screen.setText(str);


            }
        });
    }

    public String calc() {
        String number = "";
        char position_data;
        int i, j = 0, k = 0;
        double result = 1; //do not mention 1.0 then garbage value
        int len = str.length();
        double numArray[] = new double[len];


        for (i = 0; i < str.length(); i++) {

            position_data = str.charAt(i);
            if (Character.isDigit(position_data) || position_data == '.') {
                number = number + position_data;


            } else if (position_data == '=' || position_data == '+' || position_data == '*' || position_data == '/' || position_data == '-') {
                Double x = Double.parseDouble(number);
                numArray[k] = x;
                k = k + 1;
                number = "";

            }

        }

        for (i = 0; i < numArray.length; i++) {
            position_data = str.charAt(i);

            if (position_data == '+') {

                if (result == 1) {
                    result = result + numArray[j] + numArray[j + 1] - 1;
                    j = j + 2;

                } else {
                    result = result + numArray[j];
                    j = j + 1;

                }

            }
            if (position_data == '*') {


                if (result == 1) {
                    result = result * numArray[j] * numArray[j + 1];
                    j = j + 2;


                } else {

                    result = result * numArray[j];
                    j = j + 1;

                }

            }
            if (position_data == '-') {

                if (result == 1) {
                    result = result + numArray[j] - numArray[j + 1] - 1;
                    j = j + 2;


                } else {

                    result = result - numArray[j];
                    j = j + 1;

                }

            }
            if (position_data == '/') {

                if (result == 1) {
                    result = result * numArray[j] / numArray[j + 1];
                    j = j + 2;


                } else {

                    result = result / numArray[j];
                    j = j + 1;

                }

            }
        }
        String a = String.valueOf(result);
        return a;
    }

    public void disableEquals() {
        str = str + "=";
        int y=str.length()-2;
        int j=0;


        for (int i = 1; i < str.length(); i++)
        {

            if(str.charAt(0)=='+'||str.charAt(0)=='/'||str.charAt(0)=='-'||str.charAt(0)=='*')
            {
                index=index+1;
                btn_equal.setEnabled(false);
                break;
            }
            if(str.charAt(0)=='=')
            {
                index=index+1;
                btn_equal.setEnabled(false);
                break;
            }
            else if(str.charAt(y)=='+'||str.charAt(y)=='/'||str.charAt(y)=='-'||str.charAt(y)=='*')
            {
                index=index+1;
                btn_equal.setEnabled(false);
                break;
            }
            else
            {
                answer_screen.setText(calc());
            }

        }

    }
}








