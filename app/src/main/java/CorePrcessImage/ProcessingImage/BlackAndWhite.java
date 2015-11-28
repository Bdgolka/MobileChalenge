package CorePrcessImage.ProcessingImage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.util.Log;

/**
 * Class which receive Bitmap and convert it to black and white
 */
public class BlackAndWhite implements EditImage {
    //TAG for log
    private static final String TAG = "Black and White class";

    //Function which implement interface EditImage of InjectionMode pattern
    @Override
    public Bitmap EditImage(Bitmap  source) {
        Log.d(TAG, "EditImage(). Implement black and white for image");
        try {
            //initialize variable
            int width, height;
            height = source.getHeight();
            width = source.getWidth();

            //Create bitmap from origianl image
            Bitmap bmpGrayscale = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Canvas c = new Canvas(bmpGrayscale);
            Paint paint = new Paint();

            //Initialize color matrix, and set which operation we need
            ColorMatrix cm = new ColorMatrix();
            cm.setSaturation(0);

            //Initialize filter
            ColorMatrixColorFilter f = new ColorMatrixColorFilter(cm);
            paint.setColorFilter(f);
            c.drawBitmap(source, 0, 0, paint);
            //return grey color
            return bmpGrayscale;
        }catch(Exception e)
        {
            Log.d(TAG, "EditImage(). Error. "+e.toString());
        }

        return null;
    }
}