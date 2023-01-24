package model.player;

import java.io.Serializable;
import java.util.HashMap;

public class UserInfo implements Serializable {
    private int mBestScore;
    private int mMoney;
    private HashMap<String,Boolean> mAnimalPossession;

    public UserInfo(){
        mBestScore = 0;
        mMoney = 0;
        mAnimalPossession = new HashMap<String,Boolean>();
        initAnimalPossession();
    }
    private void initAnimalPossession(){
        mAnimalPossession.put("Fox",true);
        mAnimalPossession.put("Rabbit",true);
    }
    public int getBestScore() {
        return mBestScore;
    }

    public void setBestScore(int bestScore) {
        mBestScore = bestScore;
    }

    public int getMoney() {
        return mMoney;
    }

    public void earnMoney(int moneyEarned){
        mMoney += moneyEarned;
    }

    public void spendMoney(int moneySpent){
        mMoney -= moneySpent;
    }

    public boolean canAfford(int moneySpent){
        return mMoney-moneySpent>=0;
    }
}
