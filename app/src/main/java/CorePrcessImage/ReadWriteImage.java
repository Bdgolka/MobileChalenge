package CorePrcessImage;

import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Class for copy original Image to temp,
 * and save processed image to original path
 */
public class ReadWriteImage {
    //File with original Image
    private File pathToOriginal;
    //File with copy image, which will eedit
    private File pathToCopy;
    //path to temp, where save BitMap
    private String pathTemp="@drawable/temp";
    //TAG for log
    private static final String TAG = "RadWriteClass";

    //Public constructor which take in path to image
    //clone image
    //save in temp folder
    public ReadWriteImage(String path)
    {
        //check path
        File fileOriginal = new File(path);
        if(fileOriginal.exists() && !fileOriginal.isDirectory()) {
            //If pas exist, clone original image to temp
            Log.d(TAG, "ReadWriteImage() Original image exist. start lone it.");
            pathToOriginal=new File(path);
            pathToCopy=new File(pathTemp);
            DeleteFile(pathToCopy);
            try {
                copy(pathToOriginal, pathToCopy);
            } catch (IOException e) {
                Log.d(TAG, "ReadWriteImage() Error to clone image");
            }
        }else
        {
            Log.d(TAG, "ReadWriteImage() Original path doesn't exist!");
        }
    }

    //function "copy" which clone file using converter byte to output Stream
    public void copy(File src, File dst) throws IOException {
        InputStream in = new FileInputStream(src);
        OutputStream out = new FileOutputStream(dst);

        // Transfer bytes from in to out
        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        in.close();
        out.close();
    }

    //function, which delete original image and write new from temp
    public void SaveToOriginalImage()
    {
        //Delete original file
        DeleteFile(pathToOriginal);
        try {
            copy(pathToCopy, pathToOriginal);
        } catch (IOException e) {
            Log.d(TAG, "SaveToOriginalImage() Error to clone image");
        }

    }

    private void DeleteFile(File deleteFile)
    {
        //delete image
        if(pathToOriginal.delete()){
            Log.d(TAG, pathToOriginal.getName() + " is deleted!");
        }else{
            Log.d(TAG, "Delete operation is failed.");
        }
    }
}