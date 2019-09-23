package com.example.jingpeng.antfarm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private Button Normal_ant;
    private Button Worker_ant;
    private Button Soldier_ant;
    private TextView Ant_count;
    private TextView Normal_ant_count;
    private TextView Worker_ant_count;
    private TextView Soldier_ant_count;
    private TextView Food;
    private int type; //Type of ant to buy: 1 = normal, 2 = worker, 3 = soldier

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Normal_ant = findViewById(R.id.Normal_ant);
        Worker_ant = findViewById(R.id.Worker_ant);
        Soldier_ant = findViewById(R.id.Soldier_ant);

        Ant_count = findViewById(R.id.Ant_count);
        Normal_ant_count = findViewById(R.id.Normal_ant_count);
        Worker_ant_count = findViewById(R.id.Worker_ant_count);
        Soldier_ant_count = findViewById(R.id.Soldier_ant_count);
        Food = findViewById(R.id.Food_main);

        Normal_ant.setOnClickListener(nClick);
        Worker_ant.setOnClickListener(wClick);
        Soldier_ant.setOnClickListener(sClick);

        Data.ant = Data.normal_ant + Data.worker_ant + Data.soldier_ant;

        Ant_count.setText("Ant Count: " + Data.ant);
        Normal_ant_count.setText("Normal Ants: " + Data.normal_ant);
        Worker_ant_count.setText("Worker Ants: " + Data.worker_ant);
        Soldier_ant_count.setText("Soldier Ants: " + Data.soldier_ant);
        Food.setText("Food: " + Data.food);
    }


    private View.OnClickListener nClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            //Buy normal ants
            type = 1;
            Bundle t = new Bundle();
            t.putInt("TYPE", type);

            if(Data.food < 1){
                Intent w = new Intent();
                w.setClass(MainActivity.this, Warning.class);
                startActivity(w);
                finish();
                return;
            }

            Intent shop = new Intent();
            shop.setClass(MainActivity.this, Shop.class);
            shop.putExtras(t);
            startActivity(shop);
            finish();
        }
    };

    private View.OnClickListener wClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            //Buy worker ants
            type = 2;
            Bundle t = new Bundle();
            t.putInt("TYPE", type);

            if(Data.food < 3){
                Intent w = new Intent();
                w.setClass(MainActivity.this, Warning.class);
                startActivity(w);
                finish();
                return;
            }

            Intent shop = new Intent();
            shop.setClass(MainActivity.this, Shop.class);
            shop.putExtras(t);
            startActivity(shop);
            finish();
        }
    };

    private View.OnClickListener sClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            //Buy soldier ants
            type = 3;
            Bundle t = new Bundle();
            t.putInt("TYPE", type);

            if(Data.food < 5){
                Intent w = new Intent();
                w.setClass(MainActivity.this, Warning.class);
                startActivity(w);
                finish();
                return;
            }

            Intent shop = new Intent();
            shop.setClass(MainActivity.this, Shop.class);
            shop.putExtras(t);
            startActivity(shop);
            finish();
        }
    };

}
