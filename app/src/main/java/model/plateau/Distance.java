package model.plateau;

import model.elements.Animal;

public class Distance {
    

    public static int dist(int x1, int y1,int x2, int y2) {
        return (int)Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
    }

    public static int dist(Animal a, Animal b) {
        return (int)Math.sqrt((b.getPositionX()-a.getPositionX())*(b.getPositionX()-a.getPositionX())+(b.getPositionY()-a.getPositionY())*(b.getPositionY()-a.getPositionY()));
    }
}
