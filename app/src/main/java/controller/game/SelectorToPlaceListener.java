package controller.game;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import view.ViewToPlace;

public class SelectorToPlaceListener implements View.OnTouchListener{
    private ViewToPlace mViewToPlace;

    public SelectorToPlaceListener(ViewToPlace viewToPlace){
        mViewToPlace = viewToPlace;
    }
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i("TAG", "touched down");
                int index = 0;
                int nbAnimal = 2;
                for (int i = 0; i < nbAnimal; i++) {
                    if (x > 85 * i && x < 85 * (i+1)){
                        index = i+1;
                        break;
                    }
                }
                mViewToPlace.setSelector(index);
                Log.i("TAG",index+"");
                break;
        }

        return true;
    }
}
