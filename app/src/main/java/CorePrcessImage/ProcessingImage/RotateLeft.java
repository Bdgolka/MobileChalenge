package CorePrcessImage.ProcessingImage;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.Log;

/**
 * Class which rotate by 90 degree to left
 */
public class RotateLeft implements EditImage {
    //TAG for log
    private static final String TAG = "Rotate left class.";

    //Function which implement interface EditImage of InjectionMode pattern
    @Override
    public Bitmap EditImage(Bitmap source) {
        try
        {
            Log.d(TAG, "EditImage(). Implement black and white for image");
            Matrix matrix = new Matrix();

            matrix.postRotate(90);
            // image size
            int width = source.getWidth();
            int height = source.getHeight();
            Bitmap scaledBitmap = Bitmap.createScaledBitmap(source,width,height,true);

            Bitmap rotatedBitmap = Bitmap.createBitmap(scaledBitmap , 0, 0, scaledBitmap .getWidth(), scaledBitmap .getHeight(), matrix, true);
        }catch(Exception e)
        {
            Log.d(TAG, "EditImage(). Error. " + e.toString());
        }
        return null;
    }
}
