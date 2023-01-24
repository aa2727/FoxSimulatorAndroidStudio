package activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.Button;

import com.lemaitre.foxsimulator.R;

import controller.button.RunButtonListener;
import dialog.LostDialog;
import model.plateau.Plateau;
import model.player.UserInfo;
import model.savers.UserInfoSaver;
import view.ViewBestScore;
import view.ViewMap;
import view.ViewMoneyPlay;
import view.ViewScore;
import view.ViewToPlace;

public class PlayActivity extends AppCompatActivity {

    private UserInfo mUserInfo;
    private UserInfoSaver mUserInfoSaver;
    private Plateau mPlateau;

    private ViewMap mViewMap;
    private ViewScore mViewScore;
    private ViewToPlace mViewToPlace;

    private ViewBestScore mViewBestScore;
    private ViewMoneyPlay mViewMoneyPlay;

    private Button mRunButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        mUserInfoSaver = new UserInfoSaver();

        mViewMap = findViewById(R.id.viewMap);
        mViewScore = findViewById(R.id.viewScore);
        mViewToPlace = findViewById(R.id.viewPlace);
        mViewBestScore = findViewById(R.id.viewBestScore);
        mViewMoneyPlay = findViewById(R.id.viewMoney);


        initUserInfo();


        mPlateau = new Plateau();
        mViewMap.setPlateau(mPlateau);
        mViewMap.setViewScore(mViewScore);
        mViewMap.initMapController(mViewToPlace);
        mViewScore.setPlateau(mPlateau);
        mViewToPlace.setPlateau(mPlateau);


        mRunButton = findViewById(R.id.runButton);
        mRunButton.setOnClickListener(new RunButtonListener(this,mViewMap));



    }

    private void initUserInfo(){
        UserInfo userInfo = mUserInfoSaver.readUserInfoFromFile(this);
        if (userInfo == null){
            setUserInfo(new UserInfo());
        }
        else
        {
            setUserInfo(userInfo);
        }
    }

    private void openDialogContinue(String message){
        LostDialog dialog = new LostDialog(this,message);
        dialog.show(getSupportFragmentManager(),"game");
    }

    private boolean updateBestScore(){
        if (mPlateau.getScore()>mUserInfo.getBestScore()){
            mUserInfo.setBestScore(mPlateau.getScore());
            return true;
        }
        return false;
    }

    public void onLost(){
        if ( updateBestScore()){
            openDialogContinue("Nouveau Record ! \n Score : "+mPlateau.getScore());
        }
        else{
            openDialogContinue("Il manque encore : "+(mUserInfo.getBestScore()-mPlateau.getScore())+" points pour battre le record !");
        }
        mUserInfo.earnMoney((int)mPlateau.getScore()/100);
        mUserInfoSaver.writeUserInfoToFile(this,mUserInfo);
        updateUserInfoViews();
    }

    public ViewMap getViewMap() {
        return mViewMap;
    }

    public void setPlateau(Plateau plateau) {
        mPlateau = plateau;
        mViewMap.setPlateau(mPlateau);
        mViewMap.invalidate();
        mViewScore.setPlateau(mPlateau);
        mViewScore.invalidate();
        mViewToPlace.setPlateau(mPlateau);
        mViewToPlace.invalidate();
    }

    public void setUserInfo(UserInfo userInfo){
        mUserInfo = userInfo;
        mViewBestScore.setUserInfo(mUserInfo);
        mViewMoneyPlay.setUserInfo(mUserInfo);
    }

    private void updateUserInfoViews(){
        mViewMoneyPlay.invalidate();
        mViewBestScore.invalidate();
    }
}