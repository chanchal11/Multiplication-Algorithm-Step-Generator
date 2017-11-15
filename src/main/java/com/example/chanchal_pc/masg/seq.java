package com.example.chanchal_pc.masg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class seq extends AppCompatActivity implements View.OnClickListener{
    EditText ip1,ip2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seq);
        Button go=(Button)findViewById(R.id.button3);
        go.setOnClickListener(this);
        ip1=(EditText)findViewById(R.id.editText);
        ip2=(EditText)findViewById(R.id.editText3);
    }

    @Override
    public void onClick(View v) {
        try {
            int arg1 = Integer.valueOf(ip1.getText().toString());
            int arg2 = Integer.valueOf(ip2.getText().toString());
            SMA sma = new SMA();
            String msg = "message";
            Intent i = new Intent(seq.this, result.class);
            i.putExtra("keyMessage", sma.getData(arg1, arg2));
            startActivity(i);
        }catch(Exception e){}
    }
}
