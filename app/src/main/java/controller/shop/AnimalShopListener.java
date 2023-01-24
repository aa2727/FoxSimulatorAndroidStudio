package controller.shop;

import android.app.Activity;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;

import com.lemaitre.foxsimulator.MainActivity;

import view.shopViews.AnimalIconView;

public class AnimalShopListener implements View.OnTouchListener {
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if(view instanceof AnimalIconView){
                    AnimalIconView animalIcon = (AnimalIconView)view;
                    animalIcon.startIntent();
                }
        }
        return false;
    }
}
