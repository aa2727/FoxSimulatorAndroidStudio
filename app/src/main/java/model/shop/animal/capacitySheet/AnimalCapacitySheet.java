package model.shop.animal.capacitySheet;

import java.util.ArrayList;
import model.shop.capacity.Capacity;

public class AnimalCapacitySheet {
    protected String mAnimalName;
    protected int mNbCapacities;
    private ArrayList<Capacity> mCapacities;

    public AnimalCapacitySheet(){
        mAnimalName = "Animal";
        mNbCapacities = 0;
        mCapacities = new ArrayList<Capacity>();
        setDefaultCapacity();
    }

    private void initEmptyCapacities(){
        mCapacities = new ArrayList<Capacity>();
        for (int i = 0; i < 3; i++) {
            this.addCapacity(new Capacity());
        }
    }

    protected void addCapacity(Capacity c){
        mCapacities.add(c);
        mNbCapacities++;
    }

    public void setDefaultCapacity(){
        initEmptyCapacities();
    }

    public ArrayList<Capacity> getCapacities() {
        return mCapacities;
    }

    @Override
    public String toString() {
        return "AnimalCapacitySheet{" +
                "mAnimalName='" + mAnimalName + '\'' +
                ", mNbCapacities=" + mNbCapacities +
                ", mCapacities=" + mCapacities +
                '}';
    }
}
