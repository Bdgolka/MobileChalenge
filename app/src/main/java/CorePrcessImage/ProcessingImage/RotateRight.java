package CorePrcessImage.ProcessingImage;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.test.InstrumentationTestCase;
import android.util.Log;

/**
 * Class which rotate by 90 degree to right
 */
public class RotateRight extends InstrumentationTestCase implements EditImage  {
    //TAG for log
    private static final String TAG = "Rotate right class";

    @Override
    public Bitmap EditImage(Bitmap source) {
        try
        {
            Log.d(TAG, "EditImage(). Implement black and white for image");
            Matrix matrix = new Matrix();

            matrix.postRotate(270);
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
