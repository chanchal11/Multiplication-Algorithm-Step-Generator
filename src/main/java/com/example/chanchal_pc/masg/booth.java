package com.example.chanchal_pc.masg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class booth extends AppCompatActivity implements View.OnClickListener{
    int arg1,arg2; //editText2 and editText4 for booth
    EditText ip1,ip2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booth);
        Button go=(Button)findViewById(R.id.button4);
        go.setOnClickListener(this);
        ip1=(EditText)findViewById(R.id.editText2);
        ip2=(EditText)findViewById(R.id.editText4);
    }

    @Override
    public void onClick(View v) {
        try {
            int arg1 = Integer.valueOf(ip1.getText().toString());
            int arg2 = Integer.valueOf(ip2.getText().toString());
            BMA bma = new BMA();
            String msg = "message";
            Intent i = new Intent(booth.this, result.class);
            i.putExtra("keyMessage", bma.getData(arg1, arg2));
            startActivity(i);
        }catch(Exception e1){}
    }
}
