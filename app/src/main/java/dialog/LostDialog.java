package dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.lemaitre.foxsimulator.MainActivity;

import activity.PlayActivity;
import model.plateau.Plateau;

public class LostDialog extends AppCompatDialogFragment {
    private PlayActivity mPlayActivity;
    private String mMessage;

    public LostDialog(PlayActivity playActivity,String message){
        mPlayActivity = playActivity;
        mMessage = message;
    }
    @Override
    public Dialog onCreateDialog(Bundle SavedInstance){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(mMessage)
                .setPositiveButton("Nouvelle Partie", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        mPlayActivity.setPlateau(new Plateau());
                    }
                })
                .setNegativeButton("Retour à l'accueil", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent gameActivityIntent = new Intent(mPlayActivity, MainActivity.class);
                        startActivity(gameActivityIntent);
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}
