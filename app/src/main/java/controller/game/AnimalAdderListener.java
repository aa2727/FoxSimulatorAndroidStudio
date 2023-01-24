package controller.game;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import model.elements.Fox;
import model.elements.Rabbit;
import view.ViewMap;
import view.ViewToPlace;

public class AnimalAdderListener implements View.OnTouchListener {

    private ViewToPlace mViewToPlace;
    private ViewMap mViewMap;
    public AnimalAdderListener (ViewToPlace viewToPlace, ViewMap viewMap){
        mViewToPlace = viewToPlace;
        mViewMap = viewMap;
    }
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int posX,posY;
        posX = (int) motionEvent.getX()/mViewMap.getWidthCase();
        posY = (int) motionEvent.getY()/mViewMap.getHeightCase();

        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
            switch (mViewToPlace.getSelector()) {
                case 1:
                    mViewMap.getPlateau().placeAnimal(new Rabbit(posX, posY));

                    break;
                case 2:
                    mViewMap.getPlateau().placeAnimal(new Fox(posX, posY));

                    break;
                default:
                    System.err.println("Veuillez selectionner une race");
                    break;
            }
            Log.i("TAG","Animal ajouté");
            mViewToPlace.invalidate();
            mViewMap.invalidate();
        }

        return false;
    }
}
