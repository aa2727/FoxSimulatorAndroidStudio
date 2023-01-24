package controller.button;

import android.os.Handler;
import android.view.View;

import activity.PlayActivity;
import model.plateau.Plateau;
import view.ViewMap;

public class RunButtonListener implements View.OnClickListener {
    private PlayActivity mPlayActivity;
    private ViewMap mViewMap;
    private Handler mHandler;
    public RunButtonListener(PlayActivity playActivity,ViewMap viewMap){
        mPlayActivity = playActivity;
        mViewMap = viewMap;
        mHandler = new Handler();
    }
    @Override
    public void onClick(View view) {
        if (mViewMap.getPlateau().getnbAnimalToPlace()==0){
             Runnable run = new PlayRunnable(mPlayActivity,mViewMap,mHandler);
            mHandler.postDelayed(run,500);
        }
    }
}
