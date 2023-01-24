package model.plateau;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

import model.elements.*;

public class Plateau {

    private int width;
    private int height;
    private int score;
    private int nbTurn;
    private HashMap<String,Integer> toPlace;
    private HashSet<Animal> elements;
    private HashSet<Rabbit> lapins;
    private HashSet<Fox> renards;

    public Plateau() {
        this(25,25,new HashSet<Animal>(),new HashMap<String,Integer>());
    }

    public Plateau(int width,int height) {
        this(width,height,new HashSet<Animal>(),new HashMap<String,Integer>());
    }

    public Plateau(int width,int height,HashMap<String,Integer> toPlace) {
        this(width,height,new HashSet<Animal>(),toPlace);
    }

    public Plateau(int width, int height, HashSet<Animal> elements,HashMap<String,Integer> toPlace) {
        this.width = width;
        this.height = height;
        this.elements = elements;
        this.toPlace = toPlace;
        initToPlace();
        lapins = new HashSet<>();
        renards = new HashSet<>();
        score = 0;
        nbTurn = 0;
    }

    private void initToPlace() {
        toPlace.put("Fox", 4);
        toPlace.put("Rabbit", 4);
        

    }

    public int getWidth() {
        return this.width;
    }

    public int getScore(){
        return this.score;
    }

    public int getHeight() {
        return this.height;
    }

    public int getNbTurn() {
        return this.nbTurn;
    }

    public HashSet<Animal> getElements() {
        return this.elements;
    }

    public HashSet<Rabbit> getLapins() {
        return this.lapins;
    }

    public HashSet<Fox> getRenards() {
        return this.renards;
    }

    public HashMap<String,Integer> getToPlace() {
        return this.toPlace;
    }

    public int getnbFoxToPlace() {
        return toPlace.get("Fox");
    }

    public int getnbRabbitToPlace() {
        return toPlace.get("Rabbit");
    }

    public int getnbAnimalToPlace() {
        int nb = 0;
        for (String animal : toPlace.keySet()) {
            nb += toPlace.get(animal);
        }
        return nb;
    }

    @Override
    public String toString() {
        return "{" +
            " width='" + getWidth() + "'" +
            ", height='" + getHeight() + "'" +
            ", elements='" + getElements() + "'" +
            "}";
    }
    // Fonction inutile par la suite qui permet d'afficher le plateau en console (à améliorer)
    public void printPlateau() {
        boolean occuped = false;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                occuped = false;
                for (Animal animal : elements) {
                    if (i == animal.getPositionX() && j == animal.getPositionY()){
                        System.out.print(animal.getSymbol() + " ");
                        occuped = true;
                        break;
                    }
                }

                if(!occuped){
                    System.out.print(". ");
                }
                
            }
            System.out.println();
        }
    }

    public boolean isOccuped(int x, int y){
        for (Animal animal : elements) {
            if (animal.getPositionX()==x && animal.getPositionY()==y){
                return true;
            }
        }
        return false;
    }

    public void updateScore(){
        score += renards.size()*5 + lapins.size()*10;
    }

    public void addAnimal(Animal a) {
        if (!isOccuped(a.getPositionX(), a.getPositionY())){
            this.elements.add(a);
            if (a instanceof Fox){
                renards.add((Fox)a);
            }
            if (a instanceof Rabbit){
                lapins.add((Rabbit)a);
            }
        }
    }

    public boolean placeAnimal(Animal a){
        if (a.getPositionX() <= height && a.getPositionY() <= width && a.getPositionX()>= 0 && a.getPositionY()>= 0 && !isOccuped(a.getPositionX(),a.getPositionY())){
            if (a instanceof Rabbit && toPlace.get("Rabbit") > 0){
                addAnimal(a);
                toPlace.put("Rabbit", toPlace.get("Rabbit")-1);
                return true;
            }
            else if (a instanceof Fox && toPlace.get("Fox") > 0){
                addAnimal(a);
                toPlace.put("Fox", toPlace.get("Fox")-1);
                return true;
            }
        }
        return false;
    }

    public void addAllAnimal(HashSet<Animal> all){
        for (Animal animal : all) {
            addAnimal(animal);
        }
    }

    public Rabbit bornRabbit(Animal parent){
        int minHeigth = Math.max(-parent.getPositionX(), -3);
        int minWidth = Math.max(-parent.getPositionY(), -3);
        int maxHeigth = Math.min(height-parent.getPositionX(), 3);
        int maxWidth = Math.min(width-parent.getPositionY(), 3);
        int posX = parent.getPositionX()+(int)(Math.random() * ((maxHeigth-minHeigth)+1))+minHeigth;
        int posY = parent.getPositionY()+(int)(Math.random() * ((maxWidth-minWidth)+1))+minWidth;
        return new Rabbit(posX,posY);
    }

    public Fox bornFox(Animal parent){
        int minHeigth = Math.max(-parent.getPositionX(), -3);
        int minWidth = Math.max(-parent.getPositionY(), -3);
        int maxHeigth = Math.min(height-parent.getPositionX(), 3);
        int maxWidth = Math.min(width-parent.getPositionY(), 3);
        int posX = parent.getPositionX()+(int)(Math.random() * ((maxHeigth-minHeigth)+1))+minHeigth;
        int posY = parent.getPositionY()+(int)(Math.random() * ((maxWidth-minWidth)+1))+minWidth;
        return new Fox(posX,posY);
    }

    public Fox bornFoxHungry(Fox parent){
        Fox baby = bornFox(parent);
        baby.setHungerTime(parent.getHungerTime()-1);
        return baby;
    }
    /**
     * Fonction qui permet d'initier le plateau lorsque le jeu est joué en console
     */
    public void beginPlay(){;
        Scanner saisieScanner = new Scanner(System.in);
        int posX,posY;
        Animal a = null;
        for (String animal : toPlace.keySet()) {

            for (int i = 0; i < toPlace.get(animal); i++) {
            System.out.println("Position en X du " + animal);
            posX = saisieScanner.nextInt();
            System.out.println("Position en Y du " + animal);
            posY = saisieScanner.nextInt();
            if (animal == "Fox"){
                a = new Fox(posX, posY);
            }
            if (animal == "Rabbit"){
                a = new Rabbit(posX,posY);
            }
            addAnimal(a);
            }
        }
        try {
            saisieScanner.close();
        } catch (Exception e) {
            System.out.println("Scanner fermé");
        }
    }
    /**
     * Fonction appelée à chaque tour de jeu play fait vivre la biodiversité pour un tour
     */
    public void play() {
        nbTurn++;
        HashSet<Animal> newBorn = new HashSet<>();
        HashSet<Animal> mustDie = new HashSet<>();
        for (Animal animal : elements) {
            animal.live();
            if (animal.die()){
                mustDie.add(animal);
            }
            else{
                if (animal.reproduct(elements)){
                    if (animal instanceof Rabbit){
                        newBorn.add(bornRabbit(animal));
                    }
                    else{
                        newBorn.add(bornFoxHungry((Fox) animal));
                    }
                    
                }
                mustDie.add(animal.huntAnimal(elements));
            }
        }
        endTurn(newBorn,mustDie);
    }

    public void endTurn(HashSet<Animal> newBorn,HashSet<Animal> mustDie) {
        elements.removeAll(mustDie);
        lapins.removeAll(mustDie);
        renards.removeAll(mustDie);
        for (Animal animal : elements) {
            animal.setHaveReproducted(false);
        }
        addAllAnimal(newBorn);
        updateScore();
    }

    public boolean isOver() {
        if (this.getElements().isEmpty()){
            System.out.println("Perdu tous les animaux sont morts");
            return true;
        }
        if (this.getLapins().isEmpty()){
            System.out.println("Perdu tous les lapins sont morts");
            return true;
        }
        if (this.getRenards().isEmpty()){
            System.out.println("Perdu tous les Renards sont morts");
            return true;
        }
        return false;
    }
    
}
