package com.bdgolka.mobilechalenge;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import CorePrcessImage.ProcessingImage.InjectionDependency;
import CorePrcessImage.ProcessingImage.RotateLeft;
import CorePrcessImage.ReadWriteImage;

public class EditPictureActivity extends AppCompatActivity {

    private ImageView imgPreview;
    private Uri myUri;

    //Buttons
    Button buttonRotateLeft;
    Button buttonRotateRight;
    Button buttonBlackAndWhite;
    Button buttonClose;
    Button buttonOK;
    Button buttonContrast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_picture);

        imgPreview = (ImageView) findViewById(R.id.imgPreview);
        myUri = Uri.parse(getIntent().getStringExtra("fileUri"));
        previewCapturedImage();

        //Set onclick listeners to buttons
        /*buttonRotateLeft = (Button) findViewById(R.id.buttonRoateLeft);
        buttonRotateLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReadWriteImage image = new ReadWriteImage(myUri.getPath());
                //InjectionDependency dependency = new RotateLeft();
            }
        });

        buttonRotateRight = (Button) findViewById(R.id.buttonRotateRight);
        buttonRotateRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReadWriteImage image = new ReadWriteImage(myUri.getPath());
                //InjectionDependency dependency = new RotateLeft();
            }
        });*/

    }

    private void previewCapturedImage() {
        try {

            imgPreview.setVisibility(View.VISIBLE);

            // bimatp factory
            BitmapFactory.Options options = new BitmapFactory.Options();

            // downsizing image as it throws OutOfMemory Exception for larger
            // images
            options.inSampleSize = 8;

            final Bitmap bitmap = BitmapFactory.decodeFile(myUri.getPath(),
                    options);

            imgPreview.setImageBitmap(bitmap);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    /**
     * Here we store the file url as it will be null after returning from camera
     * app
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // save file url in bundle as it will be null on scren orientation
        // changes
        outState.putParcelable("file_uri", myUri);
    }

    /*
     * Here we restore the fileUri again
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // get the file url
        myUri = savedInstanceState.getParcelable("file_uri");
    }


}
