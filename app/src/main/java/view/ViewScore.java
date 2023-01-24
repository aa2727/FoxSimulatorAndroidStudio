package view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

import com.lemaitre.foxsimulator.R;

import model.plateau.Plateau;

public class ViewScore extends View {
    private Plateau mPlateau;
    private Paint mPaint;
    private Drawable mBackgroundImage;

    public ViewScore(Context context,Plateau plateau) {
        super(context);
        this.mPlateau = plateau;
        this.mPaint = new Paint();
        this.mBackgroundImage = context.getResources().getDrawable(R.drawable.bois);
    }
    public ViewScore (Context context){
        this(context,new Plateau());
    }


    @SuppressLint("UseCompatLoadingForDrawables")
    public ViewScore(Context context, AttributeSet attrs, Plateau plateau){

        super(context,attrs);
        this.mPlateau = plateau;
        this.mPaint = new Paint();
        this.mPaint = new Paint();
        this.mBackgroundImage = context.getResources().getDrawable(R.drawable.bois);
    }

    public ViewScore(Context context, AttributeSet attrs){
        this(context,attrs,new Plateau());
    }

    public void setPlateau(Plateau plateau) {
        mPlateau = plateau;
    }

    @Override
    public void onDraw(Canvas canvas){
        Rect imageBounds = new Rect(0,0,600,150);  // Adjust this for where you want it
        mBackgroundImage.setBounds(imageBounds);
        mBackgroundImage.draw(canvas);

        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(60);
        mPaint.setTextAlign(Paint.Align.RIGHT);
        canvas.drawText("Score :",550,60,mPaint);
        canvas.drawText(mPlateau.getScore()+"", 550, 120, mPaint);

    }
}
