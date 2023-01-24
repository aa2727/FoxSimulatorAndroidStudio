package model.shop.capacity;

import java.util.ArrayList;


public class Capacity {
    private String mName;
    private ArrayList<Integer> mPrices;
    private int mLevel;
    private int mUpgradesNumber;

    public Capacity(){
        mName = "Capacity";
        mUpgradesNumber = 3;
        initPrices(0);
        mLevel = 1;
    }
    public Capacity(String name,int upgradesNumber,int level,int firstPrice){
        mName = name;
        mUpgradesNumber = upgradesNumber;
        initPrices(firstPrice);
        mLevel = level;
    }
    public void initPrices(int firstPrice){
        mPrices = new ArrayList<>();
        for (int i = 0; i<mUpgradesNumber;i++){
            mPrices.add(firstPrice*i);
        }
    }
}
