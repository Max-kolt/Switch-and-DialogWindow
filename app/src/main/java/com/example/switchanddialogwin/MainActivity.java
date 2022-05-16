package com.example.switchanddialogwin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox[] chek = new CheckBox[4];
    EditText[] priceList = new EditText[4];
    EditText[] num = new EditText[4];
    float[] price = new float[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chek[0] = findViewById(R.id.checkApl);
        chek[1] = findViewById(R.id.checkStbr);
        chek[2] = findViewById(R.id.checkBlbr);
        chek[3] = findViewById(R.id.checkPts);

        num[0] = findViewById(R.id.num0);
        num[1] = findViewById(R.id.num1);
        num[2] = findViewById(R.id.num2);
        num[3] = findViewById(R.id.num3);

        priceList[0] = findViewById(R.id.applePrice);
        priceList[1] = findViewById(R.id.strawberryPrice);
        priceList[2] = findViewById(R.id.blueberryPrice);
        priceList[3] = findViewById(R.id.potatoesPrice);

        ///price[0] = 10.25f;
        ///price[1] = 20.10f;
        ///price[2] = 5.99f;
        ///price[3] = 17.50f;
    }

    public void onCalc(View v){
        float sum = 0.0f;
        int n = chek.length;
        AlertDialog.Builder outputdlg  = new AlertDialog.Builder(this);

        for(int i = 0; i < n; i++)
        {
            if (chek[i].isChecked())
            {
                int count;
                float price;

                try{
                    count = Integer.parseInt(num[i].getText().toString());
                    price = Float.parseFloat(priceList[i].getText().toString());
                }
                catch(Exception e){
                    Toast.makeText(getApplicationContext(),"Input Error",Toast.LENGTH_SHORT).show();
                    return;
                }

                float val = count * price;
                sum += val;

            }
        }

        ///Toast.makeText(getApplicationContext(),"Price: " + String.valueOf(sum),Toast.LENGTH_SHORT).show();

        outputdlg.setMessage("Result price: " + String.valueOf(sum));
        outputdlg.setTitle("Result");
        outputdlg.setPositiveButton("OK", null);
        outputdlg.setCancelable(true);
        outputdlg.setIcon(R.drawable.image);
        outputdlg.create().show();

    }


}

