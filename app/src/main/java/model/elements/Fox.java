package model.elements;
import java.util.*;

public class Fox extends Animal{

    private final static int DEFAULT_AGE_DEATH = 8;
    private final static int DEFAULT_AGE_STARVE = 6;
    private final static int DEFAULT_MAX_STARVE_REPRODUCT = 5;
    private final static int DEFAULT_AGE_REPRODUCT = 3;

    private int mHungerTime;


    public Fox(){
        this(0, 0);
    }

    public Fox(int x, int y){
        super(x, y);
        initDefaultValues();
        mHungerTime = 0;
        symbol = 'F';
    }

    public Fox(int x, int y, int hunger){
        this(x,y);
        mHungerTime = hunger;
    }

    public Fox(int ageDeath, int ageStarving,int ageReproduct,int maxAgeStarveReproduct){
        mAgeDeath = ageDeath;
        mAgeStarving = ageStarving;
        mAgeReproduct = ageReproduct;
        mMaxAgeStarveReproduct = maxAgeStarveReproduct;
    }

    private void initDefaultValues(){
        mAgeDeath = DEFAULT_AGE_DEATH;
        mAgeStarving = DEFAULT_AGE_STARVE;
        mAgeReproduct = DEFAULT_AGE_REPRODUCT;
        mMaxAgeStarveReproduct = DEFAULT_MAX_STARVE_REPRODUCT;
    }

    public void setHungerTime(int hungerTime) {
        if (hungerTime < 0){
            mHungerTime = 0;
        }
        mHungerTime = hungerTime;
    }

    @Override
    public void live() {
        super.makeOld();
        makeHungry();
    }

    @Override
    public boolean reproduct(HashSet<Animal> all){
        if (getAge() <= DEFAULT_AGE_REPRODUCT || getHungerTime() > DEFAULT_MAX_STARVE_REPRODUCT){
            return false;
        }
        HashSet<Animal> near = super.getNearAnimals(all);
        for (Animal animal : near) {
            if (animal instanceof Fox && !animal.getHaveReproducted() && animal.getAge() > DEFAULT_AGE_REPRODUCT){
                setHaveReproducted(true);
                return true;
            }
        }
        return false;
    }

    public boolean die(){
        return getAge() > DEFAULT_AGE_DEATH || getHungerTime()> DEFAULT_AGE_STARVE ;
    }
    public int getHungerTime(){
        return mHungerTime;
    }
    public void makeHungry(){
        mHungerTime++;
    }
    public void stopHunger(){
        mHungerTime = 0;
    }

    public Animal huntAnimal(HashSet<Animal> all) {
        HashSet<Animal> near = super.getNearAnimals(all);
        for (Animal animal : near) {
            if (animal instanceof Rabbit){
                stopHunger();
                return animal;
            }
        }
        return null;
    }
}