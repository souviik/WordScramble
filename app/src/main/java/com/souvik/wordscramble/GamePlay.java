package com.souvik.wordscramble;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by Souvik on 28/06/16.
 */
public class GamePlay extends Activity {
    AlertDialog.Builder adb;
    SQLiteDatabase db;
    TextView name,levelText,jumbleWord,points,attemptsLeft;
    EditText answerText;
    Button b;
    Intent i;
    String n,lv,s="";
    ArrayList<String> quesWord=new ArrayList<String>();
    int score=0,chances=3,j;
    Cursor c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        jumbleWord=(TextView) findViewById(R.id.jumbled);
        attemptsLeft=(TextView) findViewById(R.id.attemp);
        answerText=(EditText) findViewById(R.id.ans);
        levelText=(TextView) findViewById(R.id.lvdisp);
        points=(TextView) findViewById(R.id.score);
        name=(TextView) findViewById(R.id.name);
        b=(Button) findViewById(R.id.match);
        i=getIntent();
        n=i.getStringExtra("name");

        name.setText("Player: "+n);

        lv=i.getStringExtra("level");
        levelText.setText("Level: "+lv);
        createTable();
        insertIntoBeginner();
        insertIntoIntermediate();
        insertIntoExpert();
        fetchWords();
        adb= new AlertDialog.Builder(this);



        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(this.getResources().getColor(R.color.my_status_bar_pink));
    }

    public void createTable(){
        db=openOrCreateDatabase("com.souvik.wordscramble",MODE_PRIVATE ,null);
        try
        {
            db.execSQL("create table if not exists wordscramble(word varchar(7) primary key not null,level varchar(15))");
        }
        catch(Exception e){

        }
    }
    public void insertIntoBeginner()
    {
        try
        {
            db.execSQL("insert into wordscramble values('above','Beginner')");
            db.execSQL("insert into wordscramble values('alert','Beginner')");
            db.execSQL("insert into wordscramble values('bench','Beginner')");
            db.execSQL("insert into wordscramble values('blood','Beginner')");
            db.execSQL("insert into wordscramble values('chart','Beginner')");
            db.execSQL("insert into wordscramble values('class','Beginner')");
            db.execSQL("insert into wordscramble values('daily','Beginner')");
            db.execSQL("insert into wordscramble values('death','Beginner')");
            db.execSQL("insert into wordscramble values('entry','Beginner')");
            db.execSQL("insert into wordscramble values('extra','Beginner')");
            db.execSQL("insert into wordscramble values('flood','Beginner')");
            db.execSQL("insert into wordscramble values('force','Beginner')");
            db.execSQL("insert into wordscramble values('globe','Beginner')");
            db.execSQL("insert into wordscramble values('guard','Beginner')");
            db.execSQL("insert into wordscramble values('house','Beginner')");
            db.execSQL("insert into wordscramble values('heavy','Beginner')");
            db.execSQL("insert into wordscramble values('index','Beginner')");
            db.execSQL("insert into wordscramble values('image','Beginner')");
            db.execSQL("insert into wordscramble values('joint','Beginner')");
            db.execSQL("insert into wordscramble values('laser','Beginner')");
            db.execSQL("insert into wordscramble values('learn','Beginner')");
            db.execSQL("insert into wordscramble values('local','Beginner')");
            db.execSQL("insert into wordscramble values('month','Beginner')");
            db.execSQL("insert into wordscramble values('minor','Beginner')");
            db.execSQL("insert into wordscramble values('mouse','Beginner')");
            db.execSQL("insert into wordscramble values('never','Beginner')");
            db.execSQL("insert into wordscramble values('noise','Beginner')");
            db.execSQL("insert into wordscramble values('north','Beginner')");
            db.execSQL("insert into wordscramble values('offer','Beginner')");
            db.execSQL("insert into wordscramble values('order','Beginner')");
            db.execSQL("insert into wordscramble values('paint','Beginner')");
            db.execSQL("insert into wordscramble values('paper','Beginner')");
            db.execSQL("insert into wordscramble values('raise','Beginner')");
            db.execSQL("insert into wordscramble values('right','Beginner')");
            db.execSQL("insert into wordscramble values('sense','Beginner')");
            db.execSQL("insert into wordscramble values('sharp','Beginner')");
            db.execSQL("insert into wordscramble values('sleep','Beginner')");
            db.execSQL("insert into wordscramble values('solve','Beginner')");
            db.execSQL("insert into wordscramble values('table','Beginner')");
            db.execSQL("insert into wordscramble values('tight','Beginner')");
            db.execSQL("insert into wordscramble values('throw','Beginner')");
            db.execSQL("insert into wordscramble values('today','Beginner')");
            db.execSQL("insert into wordscramble values('upper','Beginner')");
            db.execSQL("insert into wordscramble values('upset','Beginner')");
            db.execSQL("insert into wordscramble values('value','Beginner')");
            db.execSQL("insert into wordscramble values('valid','Beginner')");
            db.execSQL("insert into wordscramble values('waste','Beginner')");
            db.execSQL("insert into wordscramble values('while','Beginner')");
            db.execSQL("insert into wordscramble values('youth','Beginner')");
            db.execSQL("insert into wordscramble values('young','Beginner')");
        }
        catch(Exception e){

        }
    }
    public void insertIntoIntermediate()
    {
        try
        {
            db.execSQL("insert into wordscramble values('abroad','Intermediate')");
            db.execSQL("insert into wordscramble values('across','Intermediate')");
            db.execSQL("insert into wordscramble values('belong','Intermediate')");
            db.execSQL("insert into wordscramble values('bright','Intermediate')");
            db.execSQL("insert into wordscramble values('carbon','Intermediate')");
            db.execSQL("insert into wordscramble values('career','Intermediate')");
            db.execSQL("insert into wordscramble values('degree','Intermediate')");
            db.execSQL("insert into wordscramble values('design','Intermediate')");
            db.execSQL("insert into wordscramble values('effort','Intermediate')");
            db.execSQL("insert into wordscramble values('engine','Intermediate')");
            db.execSQL("insert into wordscramble values('factor','Intermediate')");
            db.execSQL("insert into wordscramble values('famous','Intermediate')");
            db.execSQL("insert into wordscramble values('future','Intermediate')");
            db.execSQL("insert into wordscramble values('garden','Intermediate')");
            db.execSQL("insert into wordscramble values('gender','Intermediate')");
            db.execSQL("insert into wordscramble values('global','Intermediate')");
            db.execSQL("insert into wordscramble values('hardly','Intermediate')");
            db.execSQL("insert into wordscramble values('height','Intermediate')");
            db.execSQL("insert into wordscramble values('holder','Intermediate')");
            db.execSQL("insert into wordscramble values('hidden','Intermediate')");
            db.execSQL("insert into wordscramble values('hockey','Intermediate')");
            db.execSQL("insert into wordscramble values('injury','Intermediate')");
            db.execSQL("insert into wordscramble values('island','Intermediate')");
            db.execSQL("insert into wordscramble values('junior','Intermediate')");
            db.execSQL("insert into wordscramble values('jungle','Intermediate')");
            db.execSQL("insert into wordscramble values('killer','Intermediate')");
            db.execSQL("insert into wordscramble values('kidney','Intermediate')");
            db.execSQL("insert into wordscramble values('letter','Intermediate')");
            db.execSQL("insert into wordscramble values('launch','Intermediate')");
            db.execSQL("insert into wordscramble values('lesson','Intermediate')");
            db.execSQL("insert into wordscramble values('liquid','Intermediate')");
            db.execSQL("insert into wordscramble values('little','Intermediate')");
            db.execSQL("insert into wordscramble values('living','Intermediate')");
            db.execSQL("insert into wordscramble values('manage','Intermediate')");
            db.execSQL("insert into wordscramble values('manner','Intermediate')");
            db.execSQL("insert into wordscramble values('method','Intermediate')");
            db.execSQL("insert into wordscramble values('native','Intermediate')");
            db.execSQL("insert into wordscramble values('notice','Intermediate')");
            db.execSQL("insert into wordscramble values('office','Intermediate')");
            db.execSQL("insert into wordscramble values('patent','Intermediate')");
            db.execSQL("insert into wordscramble values('random','Intermediate')");
            db.execSQL("insert into wordscramble values('rating','Intermediate')");
            db.execSQL("insert into wordscramble values('remove','Intermediate')");
            db.execSQL("insert into wordscramble values('screen','Intermediate')");
            db.execSQL("insert into wordscramble values('secure','Intermediate')");
            db.execSQL("insert into wordscramble values('theory','Intermediate')");
            db.execSQL("insert into wordscramble values('unique','Intermediate')");
            db.execSQL("insert into wordscramble values('vision','Intermediate')");
            db.execSQL("insert into wordscramble values('winter','Intermediate')");
            db.execSQL("insert into wordscramble values('yellow','Intermediate')");
        }
        catch(Exception e){

        }
    }
    public void insertIntoExpert(){
        try{
            db.execSQL("insert into wordscramble values('account','Expert')");
            db.execSQL("insert into wordscramble values('acquire','Expert')");
            db.execSQL("insert into wordscramble values('bedroom','Expert')");
            db.execSQL("insert into wordscramble values('benefit','Expert')");
            db.execSQL("insert into wordscramble values('century','Expert')");
            db.execSQL("insert into wordscramble values('captain','Expert')");
            db.execSQL("insert into wordscramble values('decline','Expert')");
            db.execSQL("insert into wordscramble values('develop','Expert')");
            db.execSQL("insert into wordscramble values('economy','Expert')");
            db.execSQL("insert into wordscramble values('example','Expert')");
            db.execSQL("insert into wordscramble values('faculty','Expert')");
            db.execSQL("insert into wordscramble values('fiction','Expert')");
            db.execSQL("insert into wordscramble values('gallery','Expert')");
            db.execSQL("insert into wordscramble values('genuine','Expert')");
            db.execSQL("insert into wordscramble values('healthy','Expert')");
            db.execSQL("insert into wordscramble values('hundred','Expert')");
            db.execSQL("insert into wordscramble values('imagine','Expert')");
            db.execSQL("insert into wordscramble values('improve','Expert')");
            db.execSQL("insert into wordscramble values('journal','Expert')");
            db.execSQL("insert into wordscramble values('justice','Expert')");
            db.execSQL("insert into wordscramble values('kitchen','Expert')");
            db.execSQL("insert into wordscramble values('kingdom','Expert')");
            db.execSQL("insert into wordscramble values('leisure','Expert')");
            db.execSQL("insert into wordscramble values('logical','Expert')");
            db.execSQL("insert into wordscramble values('machine','Expert')");
            db.execSQL("insert into wordscramble values('mineral','Expert')");
            db.execSQL("insert into wordscramble values('nuclear','Expert')");
            db.execSQL("insert into wordscramble values('nervous','Expert')");
            db.execSQL("insert into wordscramble values('officer','Expert')");
            db.execSQL("insert into wordscramble values('outside','Expert')");
            db.execSQL("insert into wordscramble values('partial','Expert')");
            db.execSQL("insert into wordscramble values('passive','Expert')");
            db.execSQL("insert into wordscramble values('quality','Expert')");
            db.execSQL("insert into wordscramble values('quarter','Expert')");
            db.execSQL("insert into wordscramble values('receive','Expert')");
            db.execSQL("insert into wordscramble values('replace','Expert')");
            db.execSQL("insert into wordscramble values('science','Expert')");
            db.execSQL("insert into wordscramble values('session','Expert')");
            db.execSQL("insert into wordscramble values('teacher','Expert')");
            db.execSQL("insert into wordscramble values('trouble','Expert')");
            db.execSQL("insert into wordscramble values('upgrade','Expert')");
            db.execSQL("insert into wordscramble values('utility','Expert')");
            db.execSQL("insert into wordscramble values('vehicle','Expert')");
            db.execSQL("insert into wordscramble values('veteran','Expert')");
            db.execSQL("insert into wordscramble values('welcome','Expert')");
            db.execSQL("insert into wordscramble values('western','Expert')");
            db.execSQL("insert into wordscramble values('undress','Expert')");
            db.execSQL("insert into wordscramble values('venture','Expert')");
            db.execSQL("insert into wordscramble values('visible','Expert')");
            db.execSQL("insert into wordscramble values('yoghurt','Expert')");
        }

        catch(Exception e){

        }
    }


    public static String wordJumble(String word )
    {
        Random random = new Random();
        char wordArray[] = word.toCharArray();
        for(int i=0 ; i< wordArray.length-1 ; i++ )
        {
            int j = random.nextInt(wordArray.length-1);
            char temp = wordArray[i];
            wordArray[i] = wordArray[j];
            wordArray[j] = temp;
        }
        if(wordArray.toString().equals(word)){
            wordJumble(word);
        }
        return new String(wordArray);
    }


    public void fetchWords(){
        try{
            c=db.rawQuery("select * from wordscramble where level='"+lv+"'",null);
            while(c.moveToNext()){
                s=c.getString(0);
                quesWord.add(s);
            }
            Collections.shuffle(quesWord);
        }
        catch(Exception e){

        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        final String [] str=quesWord.toArray(new String[quesWord.size()]);
        points.setText("Score: "+score);
        attemptsLeft.setText("Attempts left: "+chances);
        jumbleWord.setText(wordJumble(str[0]));
        b.setOnClickListener(new OnClickListener() {
            int j=0;
            int len=str.length;
            @Override
            public void onClick(View v) {
                try{
                    if(answerText.getText().toString().trim().equalsIgnoreCase(str[j])){
                        score++;
                        if(score==len){
                            adb.setTitle("You Won!");
                            adb.setMessage("Score: "+score);
                            adb.setPositiveButton("Okay", new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            });
                            adb.show();
                        }
                        j++;
                        points.setText("Score: "+score);
                        jumbleWord.setText((wordJumble(str[j])));
                        answerText.setText("");
                    }
                    else{
                        chances--;
                        Toast.makeText(getApplicationContext(), "Wrong Answer", Toast.LENGTH_SHORT).show();
                        if(chances==0){
                            adb.setTitle("You Lose!");
                            adb.setMessage("Score: "+score);
                            adb.setPositiveButton("Okay", new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            });
                            adb.show();
                        }
                        attemptsLeft.setText("Attempts left: "+chances);
                        answerText.setText("");

                    }
                }catch(Exception e){

                }
            }
        });
    }

    public void back(View v)
    {
        adb.setTitle("Go Back?");
        adb.setMessage("Are you sure you want to go back?");
        adb.setNegativeButton("Yes", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        adb.setPositiveButton("No", null);
        adb.show();
    }



}