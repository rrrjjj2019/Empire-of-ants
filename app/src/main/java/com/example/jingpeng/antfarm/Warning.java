package com.example.jingpeng.antfarm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Warning extends MainActivity {

    protected Button Back;
    protected TextView Message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.warning);

        Back = findViewById(R.id.Back);
        Message = findViewById(R.id.Message);

        Back.setOnClickListener(bClick);
        Message.setText("You don't have enough money!");
    }

    private View.OnClickListener bClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent r = new Intent();
            r.setClass(Warning.this, MainActivity.class);
            startActivity(r);
            finish();
        }
    };

}
