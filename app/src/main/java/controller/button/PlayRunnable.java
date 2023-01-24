package controller.button;

import android.app.DialogFragment;
import android.os.Handler;

import activity.PlayActivity;
import view.ViewMap;

public class PlayRunnable implements Runnable{
    private PlayActivity mPlayActivity;
    private ViewMap mViewMap;
    private Handler mHandler;

    public PlayRunnable(PlayActivity playActivity,ViewMap viewMap, Handler handler){
        mViewMap = viewMap;
        mPlayActivity = playActivity;
        mHandler = handler;
    }
    @Override
    public void run() {
        if (!mViewMap.getPlateau().isOver()){
            mViewMap.playUpdate();
            mHandler.postDelayed(this,500);
        }
        else{
            mPlayActivity.onLost();
            mHandler.removeCallbacks(this);
        }

    }
}
