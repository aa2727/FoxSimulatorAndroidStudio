package model.savers;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.player.UserInfo;

public class UserInfoSaver {
    private final static String USERINFO_FILENAME = "userInfo.txt";

    public boolean writeUserInfoToFile(Activity act,UserInfo userInfo){
        FileOutputStream fos;
        ObjectOutputStream oos = null;
        try{
            fos = act.getApplicationContext().openFileOutput(USERINFO_FILENAME, Context.MODE_PRIVATE);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(userInfo);
            oos.close();
            return true;
        }catch(Exception e){
            Log.e(String.valueOf(getClass()), "Cant save records "+e.getStackTrace());
            return false;
        }
        finally{
            if(oos!=null)
                try{
                    oos.close();
                }catch(Exception e){
                    Log.e(String.valueOf(getClass()), "Error while closing stream "+e.getMessage());
                }
        }
    }

    public UserInfo readUserInfoFromFile(Activity act){
        FileInputStream fin;
        ObjectInputStream ois=null;
        try{
            fin = act.getApplicationContext().openFileInput(USERINFO_FILENAME);
            ois = new ObjectInputStream(fin);
            UserInfo userInfo = (UserInfo) ois.readObject();
            ois.close();
            Log.e(String.valueOf(getClass()), "Userinfo read successfully");
            return userInfo;
        }catch(Exception e){
            Log.e(String.valueOf(getClass()), "Cant read saved Userinfo"+e.getMessage());
            return null;
        }
        finally{
            if(ois!=null)
                try{
                    ois.close();
                }catch(Exception e){
                    Log.e(String.valueOf(getClass()), "Error in closing stream while reading records"+e.getMessage());
                }
        }
    }
}
