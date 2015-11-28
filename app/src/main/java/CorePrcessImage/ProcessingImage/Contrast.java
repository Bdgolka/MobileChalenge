package CorePrcessImage.ProcessingImage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
/**
 * Class which receive Bitmap and add contrast to this picture
 */
public class Contrast implements EditImage {
    //TAG for log
    private static final String TAG = "Contrast Image class";

    //Function which implement interface EditImage of InjectionMode pattern
    @Override
    public Bitmap EditImage(Bitmap  src) {
        Log.d(TAG, "EditImage(). Implement contrast to image");
        try
        {
            double value=10;
            // image size
            int width = src.getWidth();
            int height = src.getHeight();
            // create output bitmap

            // create a mutable empty bitmap
            Bitmap bmOut = Bitmap.createBitmap(width, height, src.getConfig());

            // create a canvas so that we can draw the bmOut Bitmap from source bitmap
            Canvas c = new Canvas();
            c.setBitmap(bmOut);

            // draw bitmap to bmOut from src bitmap so we can modify it
            c.drawBitmap(src, 0, 0, new Paint(Color.BLACK));


            // color information
            int A, R, G, B;
            int pixel;
            // get contrast value
            double contrast = Math.pow((100 + value) / 100, 2);

            // scan through all pixels
            for(int x = 0; x < width; ++x) {
                for(int y = 0; y < height; ++y) {
                    // get pixel color
                    pixel = src.getPixel(x, y);
                    A = Color.alpha(pixel);
                    // apply filter contrast for every channel R, G, B
                    R = Color.red(pixel);
                    R = (int)(((((R / 255.0) - 0.5) * contrast) + 0.5) * 255.0);
                    if(R < 0) { R = 0; }
                    else if(R > 255) { R = 255; }

                    G = Color.green(pixel);
                    G = (int)(((((G / 255.0) - 0.5) * contrast) + 0.5) * 255.0);
                    if(G < 0) { G = 0; }
                    else if(G > 255) { G = 255; }

                    B = Color.blue(pixel);
                    B = (int)(((((B / 255.0) - 0.5) * contrast) + 0.5) * 255.0);
                    if(B < 0) { B = 0; }
                    else if(B > 255) { B = 255; }

                    // set new pixel color to output bitmap
                    bmOut.setPixel(x, y, Color.argb(A, R, G, B));
                }
            }
        }catch(Exception e)
        {
            Log.d(TAG, "EditImage(). Error. "+e.toString());
        }

        return null;
    }
}