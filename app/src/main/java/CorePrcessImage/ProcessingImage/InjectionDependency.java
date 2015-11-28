package CorePrcessImage.ProcessingImage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.File;

/**
 * Class which work with patter Injection Dependency
 * It has variable EditImage, which has implements of Interface "EditImage"
 * When user choose operation, to this variable set instance of class, which
 * operation need done.
 */
public class InjectionDependency {
    //Variable with instance of class, which operation need done.
    public EditImage needOperation;

    //TAG for log
    private static final String TAG = "Injection Dependency.";

    //This function call UI activity.
    //Another developer doesn't need think about operation.
    //Just choose operation, set variable and push "EditImage" function
    public Bitmap EditImage(File src)
    {
        Bitmap edited=null;
        //Check if file exist and this is not directory
        if(src.exists() && !src.isDirectory()) {
            Log.d(TAG,"Image exist. Start editing image");
            BitmapFactory.Options bmOptions = new BitmapFactory.Options();
            Bitmap bitmap = BitmapFactory.decodeFile(src.getAbsolutePath(),bmOptions);
            edited=needOperation.EditImage(bitmap);
        }else
        {
            Log.d(TAG,"Image doesn't found.");
        }

        return edited;
    }
}
