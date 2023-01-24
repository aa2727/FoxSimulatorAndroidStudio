package view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import model.player.UserInfo;

public class ViewMoneyPlay extends View {

    private UserInfo mUserInfo;
    private Paint mPaint;

    public ViewMoneyPlay(Context context,UserInfo userInfo) {
        super(context);
        mPaint = new Paint();
        mUserInfo = userInfo;
    }

    public ViewMoneyPlay(Context context, AttributeSet attrs, UserInfo userInfo){
        super(context,attrs);
        mPaint = new Paint();
        mUserInfo = userInfo;
    }

    public ViewMoneyPlay(Context context) {
        this(context,new UserInfo());
    }

    public ViewMoneyPlay(Context context, AttributeSet attrs){
        this(context,attrs,new UserInfo());
    }

    @Override
    public void onDraw(Canvas canvas){
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(3);
        canvas.drawRect(0,0,370,100,mPaint);

        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(100);
        mPaint.setTextAlign(Paint.Align.RIGHT);
        canvas.drawText(mUserInfo.getMoney()+"", 290, 90, mPaint);

        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(320,50,350,80,mPaint);

    }

    public void setUserInfo(UserInfo userInfo) {
        mUserInfo = userInfo;
    }
}
