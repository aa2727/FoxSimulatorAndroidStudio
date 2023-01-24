package view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import com.lemaitre.foxsimulator.R;

import model.player.UserInfo;

public class ViewBestScore extends View {
    private UserInfo mUserInfo;
    private Paint mPaint;
    private Drawable mBackgroundImage;

    public ViewBestScore(Context context, UserInfo userInfo) {
        super(context);
        this.mUserInfo = userInfo;
        this.mPaint = new Paint();
        this.mBackgroundImage = context.getResources().getDrawable(R.drawable.bois);
    }
    public ViewBestScore (Context context){
        this(context,new UserInfo());
    }


    public ViewBestScore(Context context, AttributeSet attrs, UserInfo userInfo){

        super(context,attrs);
        this.mUserInfo = userInfo;
        this.mPaint = new Paint();
        this.mBackgroundImage = context.getResources().getDrawable(R.drawable.bois);
    }

    public ViewBestScore(Context context, AttributeSet attrs){
        this(context,attrs,new UserInfo());
    }

    public void setUserInfo(UserInfo userInfo) {
        mUserInfo = userInfo;
    }

    @Override
    public void onDraw(Canvas canvas){
        Rect imageBounds = new Rect(0,0,600,150);  // Adjust this for where you want it
        mBackgroundImage.setBounds(imageBounds);
        mBackgroundImage.draw(canvas);

        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(60);
        mPaint.setTextAlign(Paint.Align.RIGHT);
        canvas.drawText("Record :",550,60,mPaint);
        canvas.drawText(mUserInfo.getBestScore()+"", 550, 120, mPaint);

    }
}
