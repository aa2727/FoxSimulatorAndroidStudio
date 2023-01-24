package activity.shopActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.lemaitre.foxsimulator.R;

public class CapacityShopActivity extends AppCompatActivity {

    private TextView mAnimalName;
    private int mAnimalIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capacity_shop);

        mAnimalName = findViewById(R.id.animalName);
        loadAnimal();
        initAnimalName();
    }

    private void loadAnimal(){
        Bundle b = getIntent().getExtras();
        mAnimalIndex = -1; // or other values
        if(b != null)
            mAnimalIndex = b.getInt("species");
    }

    private void initAnimalName(){
        switch (mAnimalIndex){
            case 1:
                mAnimalName.setText("Rabbit");
                break;
            case 0:
                mAnimalName.setText("Fox");
                break;
        }
    }
}