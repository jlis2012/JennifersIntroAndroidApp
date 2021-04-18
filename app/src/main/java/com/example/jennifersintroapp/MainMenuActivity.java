package com.example.jennifersintroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        //add a listener to onCreate to take you to the temp
        Button btnWeather = (Button) findViewById(R.id.btnWeather);
        btnWeather.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                goWeather();
            }
        });

        //listener for draw
        Button btnDraw = (Button) findViewById(R.id.btnDraw);
        btnDraw.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                goDrawing();
            }
        });

        //listener for TicTacToe
        Button btnTicTacToe = (Button) findViewById(R.id.btnTicTacToe);
        btnTicTacToe.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                goGame();
            }
        });

        //listener for your info
        Button btnInfo = (Button) findViewById(R.id.btnInfo);
        btnInfo.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                goInfo();
            }
        });

        //listener for songs
        Button btnFavSong = (Button) findViewById(R.id.btnSong);
        btnFavSong.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                goSong();
            }
        });

        //listener for Take Picture
        Button btnTakePic = (Button) findViewById(R.id.btnTakePic);
        btnTakePic.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                goTakePic();
            }
        });
    }
    private void goWeather(){
        Intent intent = new Intent(MainMenuActivity.this, WeatherActivity.class);
        this.startActivity(intent);
    }
    private void goDrawing() {
        Intent intent = new Intent(MainMenuActivity.this, MyDrawing.class);
        this.startActivity(intent);
    }
    private void goGame() {
        Intent intent = new Intent(MainMenuActivity.this, TicTacToeActivity.class);
        this.startActivity(intent);
    }

    private void goInfo() {
        Intent intent = new Intent(MainMenuActivity.this, InformationPageActivity.class);
        this.startActivity(intent);
    }

    private void goSong() {
        Intent intent = new Intent(MainMenuActivity.this, SongActivity.class);
        this.startActivity(intent);
    }

    private void goTakePic() {
        Intent intent = new Intent(MainMenuActivity.this, TakePictureActivity.class);
        this.startActivity(intent);
    }
}