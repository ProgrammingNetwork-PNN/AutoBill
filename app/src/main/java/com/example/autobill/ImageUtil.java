package com.example.autobill;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.media.Image;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

public class ImageUtil {
    byte[] bitmapToByteArray(Bitmap bitmap) {
        byte[] byteArray = new byte[4 * bitmap.getWidth() * bitmap.getHeight() * 3];
        int byteArrayIndex = 0;
        for (int y = 0; y < bitmap.getHeight(); y++) {
            for (int x = 0; x < bitmap.getWidth(); x++) {
                int pixel = bitmap.getPixel(x, y);
                int r = (pixel >> 16) & 0xFF;
                int g = (pixel >> 8) & 0xFF;
                int b = pixel & 0xFF;
                byteArray[byteArrayIndex++] = (byte) r;
                byteArray[byteArrayIndex++] = (byte) g;
                byteArray[byteArrayIndex++] = (byte) b;
            }
        }

        return byteArray;
    }
    public static Bitmap mediaImageToBitmap(Image mediaImage) {
        byte[] byteArray = mediaImageToByteArray(mediaImage);
        Bitmap bitmap = null;
        if (mediaImage.getFormat() == ImageFormat.JPEG) {
            bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        } else if (mediaImage.getFormat() == ImageFormat.YUV_420_888) {
            YuvImage yuvImage = new YuvImage(byteArray, ImageFormat.NV21, mediaImage.getWidth(), mediaImage.getHeight(), null);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            yuvImage.compressToJpeg(new Rect(0, 0, yuvImage.getWidth(), yuvImage.getHeight()), 100, out);
            byte[] imageBytes = out.toByteArray();
            bitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
        } else {
            Image.Plane[] planes = mediaImage.getPlanes();
            ByteBuffer imageBuffer = (ByteBuffer) planes[0].getBuffer().rewind();
            int pixelStride = planes[0].getPixelStride();
            int rowStride = planes[0].getRowStride();
            int rowPadding = rowStride - pixelStride * mediaImage.getWidth();
            bitmap = Bitmap.createBitmap(mediaImage.getWidth() + rowPadding / pixelStride, mediaImage.getHeight(), Bitmap.Config.ARGB_8888);
            bitmap.copyPixelsFromBuffer(imageBuffer);
        }
        return bitmap;
    }


    public static byte[] mediaImageToByteArray(Image mediaImage) {
        byte[] byteArray = null;
        if (mediaImage.getFormat() == ImageFormat.JPEG) {
            ByteBuffer buffer0 = mediaImage.getPlanes()[0].getBuffer();
            buffer0.rewind();
            int buffer0Size = buffer0.remaining();
            byteArray = new byte[buffer0Size];
            buffer0.get(byteArray, 0, buffer0Size);
        } else if (mediaImage.getFormat() == ImageFormat.YUV_420_888) {
            ByteBuffer buffer0 = mediaImage.getPlanes()[0].getBuffer();
            ByteBuffer buffer2 = mediaImage.getPlanes()[2].getBuffer();
            int buffer0Size = buffer0.remaining();
            int buffer2Size = buffer2.remaining();
            byteArray = new byte[buffer0Size + buffer2Size];
            buffer0.get(byteArray, 0, buffer0Size);
            buffer2.get(byteArray, buffer0Size, buffer2Size);
        }
        return byteArray;
    }
}