package com.kooknluke.skidice2;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.Toast;

public class Settings extends AppCompatActivity {

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = preferences.edit();

        final SeekBar difficultyBar = (SeekBar) findViewById(R.id.difficultyBar);

        difficultyBar.setProgress(preferences.getInt("diffSetting", 0));

        assert difficultyBar != null;
        difficultyBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progressValue, boolean fromUser) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                editor.putInt("diffSetting", difficultyBar.getProgress());
                editor.apply();
            }
        });
    }
}
