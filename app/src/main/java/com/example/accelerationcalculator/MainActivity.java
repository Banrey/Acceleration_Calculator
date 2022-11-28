package com.example.accelerationcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etV1, etV2, etT;
    String strV1, strV2, strT, resultMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCompute = (Button) findViewById(R.id.btnCompute);

        btnCompute.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Computing....", Toast.LENGTH_SHORT).show();
        ComputeResult();
    }

    public void ComputeResult(){
        etV1 = (EditText) findViewById(R.id.etNumberV1);
        etV2 = (EditText) findViewById(R.id.etNumberV2);
        etT = (EditText) findViewById(R.id.etNumberT);
        if(etV1.getText().toString().isEmpty() || etV2.getText().toString().isEmpty() || etT.getText().toString().isEmpty()){
            strV1 = "0";
            strV2 = "0";
            strT = "0";
        }else{
            strV1 = etV1.getText().toString();
            strV2 = etV2.getText().toString();
            strT = etT.getText().toString();
        }
        double rawV1 = Double.parseDouble(strV1);
        double rawV2 = Double.parseDouble(strV2);
        double rawT = Double.parseDouble(strT);

        double result = (rawV2 - rawV1)/ rawT ;
        // Casted result to int type, remove to show decimal value
        resultMessage = (double) result + "m/s" + '\u00B2' + " is " + "the average acceleration  of the car";

        // Create Bundle instance, this will allow transfer of data from Activity to DialogFragment
        Bundle args = new Bundle();
        args.putString("result", resultMessage);

        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        intent.putExtras(args);
        startActivity(intent);
        /*
        // Create a dialog instance
        DialogFragmentCustom dialogFragmentImp = new DialogFragmentCustom();
        // Pass on dialog argument(args), the result
        dialogFragmentImp.setArguments(args);
        // Display the Dialog
        dialogFragmentImp.show(getSupportFragmentManager(),"Display Result");
        // Reset EditTexts

        */
        clearEditText();
    }
    public void clearEditText(){
        etV1.getText().clear();
        etV2.getText().clear();
        etT.getText().clear();
        etV1.requestFocus();
    }

}

