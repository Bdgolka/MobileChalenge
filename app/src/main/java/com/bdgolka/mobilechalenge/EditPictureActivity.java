package com.bdgolka.mobilechalenge;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import CorePrcessImage.ProcessingImage.EditImage;
import CorePrcessImage.ProcessingImage.RotateRight;
import CorePrcessImage.ReadWriteImage;


public class EditPictureActivity extends AppCompatActivity {

    private ImageView imgPreview;
    private Uri myUri;

    //Buttons
    ImageButton buttonRotateLeft;
    ImageButton buttonRotateRight;
    ImageButton buttonBlackAndWhite;
    ImageButton buttonClose;
    ImageButton buttonOK;
    ImageButton buttonContrast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_picture);

        imgPreview = (ImageView) findViewById(R.id.imgPreview);
        myUri = Uri.parse(getIntent().getStringExtra("fileUri"));
        previewCapturedImage();

        //Set onclick listeners to buttons
      buttonRotateLeft = (ImageButton) findViewById(R.id.buttonRoateLeft);
        buttonRotateLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EditPictureActivity.this, "Rotated Left", Toast.LENGTH_SHORT).show();

            }
        });

       buttonRotateRight = (ImageButton) findViewById(R.id.buttonRotateRight);
        buttonRotateRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*ReadWriteImage image = new ReadWriteImage(myUri.getPath());
                EditImage operation = new RotateRight();
                imgPreview.setImageBitmap(operation.EditImage());*/
                Toast.makeText(EditPictureActivity.this, "Rotated Right", Toast.LENGTH_SHORT).show();
            }
        });

        buttonBlackAndWhite = (ImageButton) findViewById(R.id.buttonBlackAndWhite);
        buttonBlackAndWhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EditPictureActivity.this, "Applied Black & White", Toast.LENGTH_SHORT).show();

            }
        });

        buttonClose = (ImageButton) findViewById(R.id.buttonClose);
        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EditPictureActivity.this, "Return to Main Activity", Toast.LENGTH_SHORT).show();

            }
        });

        buttonOK = (ImageButton) findViewById(R.id.buttonOK);
        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EditPictureActivity.this, "Picture was saved", Toast.LENGTH_SHORT).show();
            }
        });

        buttonContrast = (ImageButton) findViewById(R.id.buttonContrast);
        buttonContrast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EditPictureActivity.this, "Contrast was changed", Toast.LENGTH_SHORT).show();

            }
        });
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
