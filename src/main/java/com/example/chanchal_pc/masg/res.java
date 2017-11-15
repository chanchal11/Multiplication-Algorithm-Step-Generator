package com.example.chanchal_pc.masg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class res extends AppCompatActivity implements View.OnClickListener{
    EditText ip1,ip2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res);
        Button go=(Button)findViewById(R.id.button2);
        go.setOnClickListener(this);
        ip1=(EditText)findViewById(R.id.editText6);
        ip2=(EditText)findViewById(R.id.editText7);
    }

    @Override
    public void onClick(View v) {

            try {
                int arg1 = Integer.valueOf(ip1.getText().toString());
                int arg2 = Integer.valueOf(ip2.getText().toString());
                if(true) { //condition(arg1,arg2)
                    RDA rda = new RDA();
                    String msg = "message";
                    Intent i = new Intent(res.this, result.class);
                    i.putExtra("keyMessage", rda.getData(arg1, arg2));
                    startActivity(i);
                }
            } catch (Exception e) {
            }

    }
    private boolean condition(int a,int b)
    {
        if( a==1 || b==1 )
            return false;
        else
            return true;
    }
}
