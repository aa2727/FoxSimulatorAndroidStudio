package model.elements;

import java.util.HashSet;

public class Rabbit extends Animal{
    private final static int DEFAULT_AGE_DEATH = 3;
    private final static int DEFAULT_AGE_REPRODUCT = 1;

    public Rabbit(){
        this(0, 0);
    }

    public Rabbit(int x, int y){
        super(x, y);
        symbol = 'R';
        initDefaultValues();
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Rabbit)) {
            return false;
        }
        Rabbit rabbit = (Rabbit) o;
        return super.getPositionX() == rabbit.getPositionX() && super.getPositionY() == rabbit.getPositionY();
    }

    private void initDefaultValues(){
        mAgeDeath = DEFAULT_AGE_DEATH;
        mAgeReproduct = DEFAULT_AGE_REPRODUCT;
    }


    @Override
    public void live(){
        super.makeOld();
    }

    @Override
    public boolean reproduct(HashSet<Animal> all){
        if (getAge()<=1){
            return false;
        }
        HashSet<Animal> near = super.getNearAnimals(all);
        for (Animal animal : near) {
            if (animal instanceof Rabbit && !animal.getHaveReproducted() && animal.getAge()>1){
                setHaveReproducted(true);
                return true;
            }
        }
        return false;
    } 
}
