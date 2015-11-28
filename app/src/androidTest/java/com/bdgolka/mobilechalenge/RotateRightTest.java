package com.bdgolka.mobilechalenge;

import android.graphics.Bitmap;

import junit.framework.Assert;
import junit.framework.TestCase;

import CorePrcessImage.ProcessingImage.EditImage;
import CorePrcessImage.ProcessingImage.RotateRight;

/**
 * Created by Lena on 28.11.2015.
 */
public class RotateRightTest extends TestCase {

    public void testEditImage() throws Exception {
        EditImage testRotateRight=new RotateRight();
        int w = 100, h = 50;

        Bitmap.Config conf = Bitmap.Config.ARGB_8888; // see other conf types
        Bitmap bmp = Bitmap.createBitmap(w, h, conf); // this creates a MUTABLE bitmap
        testRotateRight.EditImage(bmp);

        Assert.assertEquals(50, bmp.getWidth());
        Assert.assertEquals(100, bmp.getHeight());
    }
}