package model.elements;

import java.util.HashSet;

import model.plateau.Distance;

public abstract class Animal {
    private int positionX;
    private int positionY;
    private int age;
    private boolean haveReproducted;
    protected char symbol;

    protected int mAgeDeath;
    protected int mAgeStarving;
    protected int mMaxAgeStarveReproduct;
    protected int mAgeReproduct;

    public Animal() {
        this(0,0);
    }

    public Animal(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.age = 0;
        this.haveReproducted = false;
        symbol = 'A';
    }

    public boolean getHaveReproducted() {
        return this.haveReproducted;
    }

    public void setHaveReproducted(boolean haveReproducted) {
        this.haveReproducted = haveReproducted;
    }

    public char getSymbol() {
        return this.symbol;
    }
    public int getPositionX() {
        return this.positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return this.positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getAge(){
        return this.age;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Animal)) {
            return false;
        }
        Animal animal = (Animal) o;
        return animal.getClass() == getClass() && positionX == animal.positionX && positionY == animal.positionY;
    }

    @Override
    public String toString() {
        return "{" +
            " class = " + this.getClass()+
            " positionX='" + getPositionX() + "'" +
            ", positionY='" + getPositionY() + "'" +
            "}";
    }

    public abstract void live();

    public abstract boolean reproduct(HashSet<Animal> all);

    public boolean die(){
        return this.age > mAgeDeath;
    }
    public Animal huntAnimal(HashSet<Animal> all){
        return null;
    }

    public void makeOld() {
        this.age++;
    }

    public HashSet<Animal> getNearAnimals(HashSet<Animal> all){
        HashSet<Animal> near = new HashSet<Animal>();
        for (Animal animal : all) {
            if (Distance.dist(this,animal) <= 5){
                near.add(animal);
            }
        }
        near.remove(this);
        return near;
    }


}
