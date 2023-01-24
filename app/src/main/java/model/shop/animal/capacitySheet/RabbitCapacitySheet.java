package model.shop.animal.capacitySheet;

import model.shop.capacity.Capacity;

public class RabbitCapacitySheet extends AnimalCapacitySheet{

    public RabbitCapacitySheet(){
        super();
        super.mAnimalName = "Rabbit";
    }

    @Override
    public void setDefaultCapacity(){
        Capacity ReproCap = new Capacity("Reproduction speed",3,0,50);
        Capacity QuantityCap = new Capacity("Reproduction quantity",3,0,50);
        Capacity lifeEsperance = new Capacity("Life esperance",3,0,50);
        super.addCapacity(ReproCap);
        super.addCapacity(QuantityCap);
        super.addCapacity(lifeEsperance);
    }
}
