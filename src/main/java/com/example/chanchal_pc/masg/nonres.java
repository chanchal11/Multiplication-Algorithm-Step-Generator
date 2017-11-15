package com.example.chanchal_pc.masg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class nonres extends AppCompatActivity implements View.OnClickListener{
    EditText ip1,ip2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nonres);
        Button go=(Button)findViewById(R.id.button5);
        go.setOnClickListener(this);
        ip1=(EditText)findViewById(R.id.editText8);
        ip2=(EditText)findViewById(R.id.editText9);
    }

    @Override
    public void onClick(View v) {
        try {
            int arg1 = Integer.valueOf(ip1.getText().toString());
            int arg2 = Integer.valueOf(ip2.getText().toString());
            if(true) { //condition(arg1,arg2)
                NRDA nrda = new NRDA();
                String msg = "message";
                Intent i = new Intent(nonres.this, result.class);
                i.putExtra("keyMessage", nrda.getData(arg1, arg2));
                startActivity(i);
            }
        }catch(Exception e){}
    }
    private boolean condition(int a,int b)
    {
        if( a==1 || b==1 )
            return false;
        else
            return true;
    }
}
