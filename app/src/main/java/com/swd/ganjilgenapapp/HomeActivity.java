package com.swd.ganjilgenapapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    Button btn;
    Button btn1;
    Button reset;
    TextView tv;
    TextView tv1;
    int j = 1;
    int h = 2;
    int max=2000;

    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btn=(Button) findViewById(R.id.btnGenap);
        btn1=(Button) findViewById(R.id.btnGanjil);
        tv=(TextView) findViewById(R.id.txtGenap);
        tv1=(TextView) findViewById(R.id.txtGanjil);
        reset =(Button) findViewById(R.id.btnReset);

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                for (int i = j;i<=max;i++){
                    if (nomorGanjil(i)){
                        tv1.setText(i+"");
                        j= i+1;
                        break;
                    }
                }
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = h;i<=max;i++){
                    if (nomorGenap(i)){
                        tv.setText(i+"");
                        h= i+1;
                        break;
                    }
                }
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                j=0;
                h=0;
                tv.setText(String.valueOf(j));
                tv1.setText(String.valueOf(h));
            }
        });
    }
    @Override
    public void onBackPressed(){

        if (backPressedTime + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        }else{
        backToast=Toast.makeText(getBaseContext(),"Tekan kembali lagi untuk keluar!",Toast.LENGTH_SHORT);
        backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }

    public boolean nomorGanjil(int ganjil){
        for (int i = 1; i<= ganjil;i++){
            if (ganjil % 2 == 0){
                return false;
            }
        }
        return true;
    }
    public boolean nomorGenap(int genap ){
        return (genap % 2==0);
    }

}
