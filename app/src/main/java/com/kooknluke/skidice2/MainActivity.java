package com.kooknluke.skidice2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Context context = this;
        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        Button settingsButton = (Button) findViewById(R.id.btnSettings);
        Button testButton = (Button) findViewById(R.id.btnTest);

        assert settingsButton != null;
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent settingsIntent =  new Intent(context, Settings.class);
                startActivity(settingsIntent);
            }
        });

        assert testButton != null;
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), Integer.toString(preferences.getInt("diffSetting", 0)), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
