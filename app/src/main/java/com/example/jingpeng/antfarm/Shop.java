package com.example.jingpeng.antfarm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Shop extends MainActivity{

    protected TextView Cost;
    protected TextView Food;
    protected TextView Amount;
    protected Button plus;
    protected Button minus;
    protected Button Buy;
    protected int Buy_amount;
    protected int Price;
    protected int Type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop);

        Cost = findViewById(R.id.Cost);
        Food = findViewById(R.id.Food);
        Amount = findViewById(R.id.Amount);
        plus = findViewById(R.id.Plus);
        minus = findViewById(R.id.Minus);
        Buy = findViewById(R.id.Buy);

        plus.setOnClickListener(pClick);
        minus.setOnClickListener(mClick);
        Buy.setOnClickListener(bClick);

        //This part is to receive intent from past state
        Intent shop = getIntent();
        Bundle r = shop.getExtras();
        Type = r.getInt("TYPE");


        switch (Type) {
            case 1:
                Price = 1;
                //Normal Ants price = 1
                break;

            case 2:
                Price = 3;
                //Worker Ants price = 3
                break;

            case 3:
                Price = 5;
                //Soldier Ants price = 5
                break;
        }

        Buy_amount = Data.food / Price;
        Amount.setText("Buy: " + Buy_amount);
        Cost.setText("Cost: " + Buy_amount * Price);
        Food.setText("Food: " + Data.food);
    }




    private View.OnClickListener pClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(Buy_amount * Price + Price < Data.food){
                Buy_amount++;
            }
            Amount.setText("Buy: " + Buy_amount);
            Cost.setText("Cost: " + Buy_amount * Price);
        }
    };

    private View.OnClickListener mClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(Buy_amount > 0){
                Buy_amount--;
            }
            Amount.setText("Buy: " + Buy_amount);
            Cost.setText("Cost: " + Buy_amount * Price);
        }
    };

    private View.OnClickListener bClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (Type){
                case 1:
                    Data.normal_ant += Buy_amount;
                    Data.food -= Buy_amount * Price;
                    break;

                case 2:
                    Data.worker_ant += Buy_amount;
                    Data.food -= Buy_amount * Price;
                    break;

                case 3:
                    Data.soldier_ant += Buy_amount;
                    Data.food -= Buy_amount * Price;
                    break;
            }


            Intent buy = new Intent();
            buy.setClass(Shop.this, MainActivity.class);
            startActivity(buy);
            finish();
        }
    };
}