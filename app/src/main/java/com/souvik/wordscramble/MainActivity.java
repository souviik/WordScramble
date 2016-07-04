package com.souvik.wordscramble;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Souvik on 28/06/16.
 */
public class MainActivity extends Activity {
    EditText et;
    String string;
    Intent intent,intent2;
    Button quit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quit = (Button) findViewById(R.id.quit);
        et=(EditText) findViewById(R.id.editText1);
        intent2=new Intent(this,MusicService.class);
        startService(intent2);

        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(this.getResources().getColor(R.color.my_status_bar_yellow));
    }




    public void moveToNextActivity(View v){
        intent=new Intent("com.souvik.wordscramble.levelselect");
        string=et.getText().toString().trim();

        if(string.equals(""))
        {
            Toast.makeText(MainActivity.this,"Please enter your Name", Toast.LENGTH_LONG).show();
            et.setText("");
        }
        else{
            intent.putExtra("name",et.getText().toString());
            startActivity(intent);
        }
    }



    @Override
    protected void onRestart() {
        super.onRestart();
        stopService(intent2);
        finish();
    }

    protected void onDestroy() {
        stopService(intent2);
        super.onDestroy();
    }

    public void quit(View view)
    {

            this.onBackPressed();
    }

}




