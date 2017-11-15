package com.example.chanchal_pc.masg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    int flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioButton seqb=(RadioButton)findViewById(R.id.radioButton);
        RadioButton boothb=(RadioButton)findViewById(R.id.radioButton2);
        RadioButton nonres=(RadioButton)findViewById(R.id.radioButton3);
        RadioButton res=(RadioButton)findViewById(R.id.radioButton4);
        Button next=(Button)findViewById(R.id.button);
        seqb.setOnClickListener(this);
        boothb.setOnClickListener(this);
        next.setOnClickListener(this);
        res.setOnClickListener(this);
        nonres.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.button:
                if(flag==1)
                {startActivity(new Intent(MainActivity.this,seq.class));}
                else if(flag==2)
                {startActivity(new Intent(MainActivity.this,booth.class));}
                else if(flag==3)
                {startActivity(new Intent(MainActivity.this,nonres.class));}
                else if(flag==4)
                {startActivity(new Intent(MainActivity.this,res.class));}
                break;

            case R.id.radioButton: //sequen
               flag=1;
                break;
            case R.id.radioButton2: //booth
                flag=2;
                break;
            case R.id.radioButton3: //nonres
                flag=3;
                break;
            case R.id.radioButton4: //res
                flag=4;
                break;
        }
    }
}
