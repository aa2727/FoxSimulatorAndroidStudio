package model.shop.animal.capacitySheet;

import model.shop.capacity.Capacity;

public class FoxCapacitySheet extends AnimalCapacitySheet{

    public FoxCapacitySheet(){
        super();
        super.mAnimalName = "Fox";
    }

    @Override
    public void setDefaultCapacity(){
        Capacity hungerCap = new Capacity("Hunger resistance",3,0,50);
        Capacity mercyCap = new Capacity("Mercy",3,0,50);
        Capacity lifeEsperance = new Capacity("Life esperance",3,0,50);
        super.addCapacity(hungerCap);
        super.addCapacity(mercyCap);
        super.addCapacity(lifeEsperance);
    }
}
