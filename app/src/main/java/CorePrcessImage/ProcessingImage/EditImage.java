package CorePrcessImage.ProcessingImage;

import android.graphics.Bitmap;

/**
 * Interface for patter Injection dependency
 * Has method editing image, which need inherit from this interface
 */
public interface EditImage {
    Bitmap EditImage(Bitmap  source);
}
