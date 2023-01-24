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

import controller.game.AnimalAdderListener;
import model.elements.*;
import model.plateau.*;

public class ViewMap extends View {

    private final Paint mPaint = new Paint();
    private Plateau plateau;
    private ViewScore mViewScore;
    private Drawable mRabbitImage;
    private Drawable mFoxImage;
    private int size;
    private int widthCase;
    private int heightCase;

    public ViewMap(Context context){
        this(context, new Plateau());
    }
    public ViewMap(Context context,Plateau plateau){
        super(context);
        this.plateau = plateau;
        this.size = 1000;
        this.widthCase = this.size/plateau.getWidth()+1;
        this.heightCase = this.size/plateau.getHeight()+1;
    }
    public ViewMap(Context context, AttributeSet attrs){ this(context,attrs,new Plateau()); }

    public ViewMap(Context context, AttributeSet attrs, Plateau plateau){
        super(context,attrs);
        mRabbitImage = context.getResources().getDrawable(R.drawable.rabbit_withoutbg);
        mFoxImage = context.getResources().getDrawable(R.drawable.hungry_fox_withoutbg);
        this.plateau = plateau;
        this.size = 1000;
        this.widthCase = this.size/(plateau.getWidth()+1);
        this.heightCase = this.size/(plateau.getHeight()+1);

    }
    public int getWidthCase() {
        return this.widthCase;
    }
    public int getHeightCase() {
        return this.heightCase;
    }

    public void setViewScore(ViewScore viewScore) {
        mViewScore = viewScore;
    }

    public Plateau getPlateau(){
        return this.plateau;
    }

    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
        this.widthCase = this.size/(plateau.getWidth()+1);
        this.heightCase = this.size/(plateau.getHeight()+1);
    }
    public void setSizeMap(int size) {
        this.size = size;
        this.widthCase = this.size/(plateau.getWidth()+1);
        this.heightCase = this.size/(plateau.getHeight()+1);
        // Changer size de la map
    }

    public void initMapController(ViewToPlace viewToPlace){
        this.setOnTouchListener(new AnimalAdderListener(viewToPlace,this));
    }

    public int getSizeMap(){
        return this.size;
    }

    public void playUpdate(){
        plateau.play();
        invalidate();
        mViewScore.invalidate();
    }

    @Override
    public void onDraw(Canvas canvas){

        mPaint.setColor(Color.GREEN);
        mPaint.setStrokeWidth(3);
        canvas.drawRect(0,0,size,size,mPaint);

        Drawable animalImage = null;

        for (Animal animal : plateau.getElements()){
            if (animal instanceof Rabbit){
                mPaint.setColor(Color.GRAY);
                animalImage = mRabbitImage;
            }
            if (animal instanceof Fox){
                mPaint.setColor(Color.rgb(235,152,52));
                animalImage = mFoxImage;
            }
            int right = (int)((animal.getPositionX()+1.5)*widthCase);
            int top = (int) ((animal.getPositionY()+1.5)*heightCase);
            Rect imageBounds = new Rect(animal.getPositionX()*widthCase,animal.getPositionY()*heightCase,right,top);  // Adjust this for where you want it
            animalImage.setBounds(imageBounds);
            animalImage.draw(canvas);

        }
    }
}
