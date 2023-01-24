package view.shopViews;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.lemaitre.foxsimulator.MainActivity;

import java.util.HashMap;

import activity.PlayActivity;
import activity.shopActivity.CapacityShopActivity;
import model.elements.Species;

public class AnimalIconView extends View {

    private final Paint mPaint = new Paint();
    private Intent mAnimalShopIntent;
    private int mColor;
    private int mSizeWidth;
    private int mSizeHeight;

    public AnimalIconView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,Color.rgb(235,152,52));
    }

    public AnimalIconView(Context context, @Nullable AttributeSet attrs,int color) {
        super(context, attrs);
        setColor(color);
        initSize();
    }
    public AnimalIconView (Context context){
        this(context,Color.rgb(235,152,52));
    }

    public AnimalIconView(Context context, int color){
        super(context);
        setColor(color);
        initSize();
    }

    private void initSize(){
        mSizeHeight = 80;
        mSizeWidth = 80;
    }

    private void setColor(int color){
        mColor = color;
    }

    public void setRabbitColor(){
        setColor(Color.GRAY);
    }
    private void setIntent(int indexSpecies){
        mAnimalShopIntent = new Intent(getContext(), CapacityShopActivity.class);
        Bundle b = new Bundle();
        b.putInt("species", indexSpecies);
        mAnimalShopIntent.putExtras(b);
    }

    public void startIntent(){
        getContext().startActivity(mAnimalShopIntent);
    }

    public void setIntentFox(){
        setIntent(0);
    }
    public void setIntentRabbit(){
        setIntent(1);
    }
    @Override
    public void onDraw(Canvas canvas) {

        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(3);
        canvas.drawRect(0,0,100,100,mPaint);

        mPaint.setColor(mColor);
        mPaint.setStrokeWidth(3);
        canvas.drawRect(10,10,90,90,mPaint);
    }

}


