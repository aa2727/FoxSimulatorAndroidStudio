package activity.shopActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.lemaitre.foxsimulator.R;

import controller.shop.AnimalShopListener;
import view.shopViews.AnimalIconView;

public class ShopAnimalActivity extends AppCompatActivity {
    private AnimalIconView mFoxIcon;
    private AnimalIconView mRabbitIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_animal);

        mFoxIcon = findViewById(R.id.foxIcon);
        mRabbitIcon = findViewById(R.id.rabbitIcon);

        initFoxIcon();
        initRabbitIcon();

    }

    private void initFoxIcon(){
        mFoxIcon.setIntentFox();
        mFoxIcon.setOnTouchListener(new AnimalShopListener());
    }
    private void initRabbitIcon(){
        mRabbitIcon.setIntentRabbit();
        mRabbitIcon.setRabbitColor();
        mRabbitIcon.setOnTouchListener(new AnimalShopListener());

    }
}