package dtc.epam.com.dtc.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;

/**
 * Created by User on 22.12.2014.
 */
public class CircleMaskedBitmap {

    public static boolean CIRCLE = true;

    public static synchronized Bitmap scaleTo(Bitmap source, int size) {

        int destWidth = source.getWidth();
        int destHeight = source.getHeight();
        destHeight = destHeight * size / destWidth;
        destWidth = size;
        if (destHeight < size) {
            destWidth = destWidth * size / destHeight;
            destHeight = size;
        }
        Bitmap destBitmap = Bitmap.createBitmap(destWidth, destHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(destBitmap);
        canvas.drawBitmap(source, new Rect(0, 0, source.getWidth(), source.getHeight()), new Rect(0, 0, destWidth, destHeight), new Paint(Paint.ANTI_ALIAS_FLAG));
        return destBitmap;
    }

    public static synchronized Bitmap getCircleMaskedBitmapUsingShader(Bitmap source, int radius) {
        if (source == null) {
            return null;
        }
        if (CIRCLE) {
            int diam = radius << 1;
            Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
            Bitmap scaledBitmap = scaleTo(source, diam);
            final Shader shader = new BitmapShader(scaledBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            paint.setShader(shader);
            Bitmap targetBitmap = Bitmap.createBitmap(diam, diam, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(targetBitmap);
            canvas.drawCircle(radius, radius, radius, paint);
            return targetBitmap;
        } else {
            return source;
        }
    }

}
