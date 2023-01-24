package com.lemaitre.foxsimulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import activity.PlayActivity;
import activity.shopActivity.ShopAnimalActivity;

public class MainActivity extends AppCompatActivity {
    private Button mPlayButton;
    private Button mShopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPlayButton = findViewById(R.id.playButton);
        mShopButton = findViewById(R.id.animalShopButton);

        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gameActivityIntent = new Intent(MainActivity.this, PlayActivity.class);
                startActivity(gameActivityIntent);
            }
        });

        mShopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shopActivityIntent = new Intent(MainActivity.this, ShopAnimalActivity.class);
                startActivity(shopActivityIntent);
            }
        });
    }
}