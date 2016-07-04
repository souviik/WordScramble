package com.souvik.wordscramble;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

/**
 * Created by Souvik on 28/06/16.
 */
public class MusicService  extends Service{
    MediaPlayer mp;
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mp=MediaPlayer.create(this,R.raw.faded);
        mp.setLooping(true);
        mp.setVolume(100,100);
        mp.start();
        return 1;
    }
    @Override
    public void onDestroy() {
        mp.stop();
        mp.release();
        super.onDestroy();
    }
}
