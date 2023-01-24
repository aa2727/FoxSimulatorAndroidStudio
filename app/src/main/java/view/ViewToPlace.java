package view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import controller.game.SelectorToPlaceListener;
import model.plateau.Plateau;

public class ViewToPlace extends View {
    private Plateau mPlateau;
    private Paint mPaint;
    private int mSelector;

    public ViewToPlace(Context context, Plateau plateau) {
        super(context);
        this.mSelector = 0;
        this.mPlateau = plateau;
        this.mPaint = new Paint();
        this.setOnTouchListener(new SelectorToPlaceListener(this));
    }

    public ViewToPlace(Context context, AttributeSet attrs, Plateau plateau) {
        super(context,attrs);
        this.mSelector = 0;
        this.mPlateau = plateau;
        this.mPaint = new Paint();
        this.setOnTouchListener(new SelectorToPlaceListener(this));
    }

    public ViewToPlace(Context context){
        this(context,new Plateau());
    }

    public ViewToPlace(Context context,AttributeSet attrs){
        this(context,attrs,new Plateau());
    }

    public int getSelector() {
        return mSelector;
    }

    public void setSelector(int selector) {
        mSelector = selector;
    }

    public void setPlateau(Plateau plateau) {
        mPlateau = plateau;
    }

    @Override
    public void onDraw(Canvas canvas){
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(3);
        canvas.drawRect(0,0,400,100,mPaint);

        mPaint.setColor(Color.GRAY);
        mPaint.setStrokeWidth(3);
        canvas.drawRect(5,5,90,90,mPaint);

        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(50);
        canvas.drawText(""+mPlateau.getnbRabbitToPlace(), 55, 85, mPaint);

        mPaint.setColor(Color.rgb(235,152,52));
        mPaint.setStrokeWidth(3);
        canvas.drawRect(100,5,185,90,mPaint);

        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(50);
        canvas.drawText(""+mPlateau.getnbFoxToPlace(), 150, 85, mPaint);
    }

}
