package com.example.chanchal_pc.masg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Bundle extras = getIntent().getExtras();
        String msg = extras.getString("keyMessage");
        EditText editText=(EditText)findViewById(R.id.editText5);
        editText.setText(msg);
        editText.setKeyListener(null);
    }
}
