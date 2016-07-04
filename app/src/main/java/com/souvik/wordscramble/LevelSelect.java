package com.souvik.wordscramble;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Souvik on 28/06/16.
 */

public class LevelSelect extends Activity {

    AlertDialog.Builder adb;
    RadioButton radio1,radio2,radio3;
    Intent intent,lvl1,lvl2,lvl3;
    String name;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);

        tv=(TextView) findViewById(R.id.greetings);
        radio1=(RadioButton) findViewById(R.id.radio0);
        radio2=(RadioButton) findViewById(R.id.radio1);
        radio3=(RadioButton) findViewById(R.id.radio2);
        adb = new AlertDialog.Builder(this);

        intent=getIntent();
        name=intent.getStringExtra("name");
        tv.setText("Welcome "+name);


        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(this.getResources().getColor(R.color.my_status_bar_red));

        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
        }
    }



    public void beginner(View v)
    {
        Toast.makeText(LevelSelect.this,radio1.getText().toString()+" level", Toast.LENGTH_SHORT).show();
        lvl1=new Intent("com.souvik.wordscramble.beginner");
        lvl1.putExtra("name",name);
        lvl1.putExtra("level","Beginner");
        startActivity(lvl1);
    }


    public void intermediate(View v)
    {
        Toast.makeText(LevelSelect.this,radio2.getText().toString()+" level", Toast.LENGTH_SHORT).show();
        lvl2=new Intent("com.souvik.wordscramble.intermediate");
        lvl2.putExtra("name",name);
        lvl2.putExtra("level","Intermediate");
        startActivity(lvl2);
    }


    public void expert(View v)
    {
        Toast.makeText(LevelSelect.this,radio3.getText().toString()+" level", Toast.LENGTH_SHORT).show();
        lvl3=new Intent("com.souvik.wordscramble.expert");
        lvl3.putExtra("name",name);
        lvl3.putExtra("level","Expert");
        startActivity(lvl3);
    }
/*
    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
    */
/*
    public void exit(View v)
    {
        adb.setTitle("Quit?");
        adb.setMessage("Do you really want to quit?");
        adb.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                //finish();
                LevelSelect.this.onBackPressed();
            }
        });
        adb.setNegativeButton("No", null);
        adb.show();

    }
*/
}