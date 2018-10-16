package com.ring.bmi;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edHeight;
    private EditText edWeight;
    private Button help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findVeiws();
    }

    private void findVeiws() {
        edWeight = findViewById(R.id.ed_weight);
        edHeight = findViewById(R.id.ed_height);
        help = findViewById(R.id.help);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "onClick: help");
                new AlertDialog.Builder(MainActivity.this)
                        .setMessage("blabla")
                        .setPositiveButton("OK",null)
                        .show();
            }
        });
    }

    public void bmi(View view){
        Log.d("MainActivity","bmi");
        String w = edWeight.getText().toString();
        String h = edHeight.getText().toString();
        Log.d("MainActivity",w+"/"+h);
        float weight = Float.parseFloat(w);
        float height = Float.parseFloat(h);
        float bmi = weight/(height*height);
        Log.d("MainActivity",bmi+"  ");
        Toast.makeText(this, "Your Bmi is"+bmi, Toast.LENGTH_SHORT).show();
        new AlertDialog.Builder(this)
                .setMessage("Your Bmi is"+bmi)
                .setTitle("BMI")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        edHeight.setText("");//重置身高與體重
                        edWeight.setText("");
                    }
                })
        .show();//跳出確認畫面
    }
}
