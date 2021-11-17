package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Float valueOne;
    private Float valueTwo;
    private Float memory;

    private boolean isAddition, isMultiplication, isSubstraction, isDivision;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn0 = (Button) findViewById(R.id.btn0);
        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);
        Button btn4 = (Button) findViewById(R.id.btn4);
        Button btn5 = (Button) findViewById(R.id.btn5);
        Button btn6 = (Button) findViewById(R.id.btn6);
        Button btn7 = (Button) findViewById(R.id.btn7);
        Button btn8 = (Button) findViewById(R.id.btn8);
        Button btn9 = (Button) findViewById(R.id.btn9);

        Button btnPtn = (Button) findViewById(R.id.btnPtn);

        Button btnMult = (Button) findViewById(R.id.btnMult);
        Button btnDiv = (Button) findViewById(R.id.btnDiv);
        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        Button btnSubstr = (Button) findViewById(R.id.btnSubstr);

        Button btnMs = (Button) findViewById(R.id.btnMs);
        Button btnMr = (Button) findViewById(R.id.btnMr);
        Button btnMc = (Button) findViewById(R.id.btnMc);

        Button btnClear = (Button) findViewById(R.id.btnClear);
        Button btnEq = (Button) findViewById(R.id.btnEq);

        TextView text = (TextView) findViewById(R.id.text);

        // ensure there is never null to handle
        if(text.getText() == null) {
            text.setText("");
        }

        // not allow type '0' when no other digit is entered
        btn0.setOnClickListener(v -> {
                if (!"".contentEquals(text.getText())) {
                    text.setText(text.getText() + "0");
                }
        });

        btn1.setOnClickListener(v -> text.setText(text.getText()+"1"));
        btn2.setOnClickListener(v -> text.setText(text.getText()+"2"));
        btn3.setOnClickListener(v -> text.setText(text.getText()+"3"));
        btn4.setOnClickListener(v -> text.setText(text.getText()+"4"));
        btn5.setOnClickListener(v -> text.setText(text.getText()+"5"));
        btn6.setOnClickListener(v -> text.setText(text.getText()+"6"));
        btn7.setOnClickListener(v -> text.setText(text.getText()+"7"));
        btn8.setOnClickListener(v -> text.setText(text.getText()+"8"));
        btn9.setOnClickListener(v -> text.setText(text.getText()+"9"));

        btnPtn.setOnClickListener(v -> text.setText(text.getText()+"."));

        btnClear.setOnClickListener(v -> text.setText(""));

        btnAdd.setOnClickListener(v -> {
            try {
                valueOne = Float.parseFloat((String) text.getText());
            } catch (NumberFormatException ignored) {return;}
            isAddition = true;
            text.setText("");
        });

        btnMult.setOnClickListener(v -> {
            try {
                valueOne = Float.parseFloat((String) text.getText());
            } catch (NumberFormatException ignored) {return;}
            isMultiplication = true;
            text.setText("");
        });

        btnSubstr.setOnClickListener(v -> {
            try {
                valueOne = Float.parseFloat((String) text.getText());
            } catch (NumberFormatException ignored) {return;}
            isSubstraction = true;
            text.setText("");
        });

        btnDiv.setOnClickListener(v -> {
            try {
                valueOne = Float.parseFloat((String) text.getText());
            } catch (NumberFormatException ignored) {return;}
            isDivision = true;
            text.setText("");
        });

        btnEq.setOnClickListener(v -> {
            try {
                valueTwo = Float.parseFloat((String) text.getText());
            } catch (NumberFormatException ignored) {return;}

            if (isAddition) {
                text.setText(valueOne + valueTwo + "");
                isAddition = false;
            } else if (isMultiplication) {
                text.setText(valueOne * valueTwo + "");
                isMultiplication = false;
            } else if (isDivision) {
                if (valueTwo == 0) {
                    text.setText("");
                } else {
                    text.setText(valueOne / valueTwo + "");
                }
                isDivision = false;
            } else if (isSubstraction) {
                text.setText(valueOne - valueTwo + "");
                isSubstraction = false;
            }

            // immediately save result into valueOne, since we want to use that as input for
            //     following operation
            valueOne = Float.parseFloat((String) text.getText());
        });

        btnMs.setOnClickListener(v -> {
                try {
                    memory = Float.parseFloat((String) text.getText());
                } catch (NumberFormatException ignored) {}
        });

        btnMc.setOnClickListener(v -> memory = null);

        btnMr.setOnClickListener(v -> text.setText(memory + ""));
    }
}