package com.facebook.katana.activity.media.crop;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.FloatMath;
import com.facebook.katana.RotateBitmap;

public class CropStaticHelper
{
  public static float a(float paramFloat1, float paramFloat2)
  {
    return (paramFloat1 + paramFloat2) / 2.0F;
  }

  public static float a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    float f1 = (float)Math.atan2(paramFloat2 - paramFloat4, paramFloat1 - paramFloat3);
    float f2 = (float)Math.atan2(paramFloat6 - paramFloat8, paramFloat5 - paramFloat7);
    return b((float)Math.toDegrees(f1), (float)Math.toDegrees(f2));
  }

  public static float a(Bitmap paramBitmap, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float[] arrayOfFloat = new float[2];
    int i = 0;
    if (i < 2)
    {
      float f1;
      float f2;
      label25: float f3;
      float f4;
      float f5;
      float f6;
      float f7;
      if (i == 0)
      {
        f1 = paramFloat2;
        f2 = paramFloat1;
        f3 = f1 - paramFloat3;
        f4 = paramBitmap.getWidth();
        f5 = paramBitmap.getHeight();
        if (paramInt % 180 != 0)
          break label111;
        f6 = Math.min(f2 * paramFloat4 / f4, 10.0F);
        f7 = Math.min(f3 * paramFloat4 / f5, 10.0F);
      }
      while (true)
      {
        arrayOfFloat[i] = Math.min(f6, f7);
        i++;
        break;
        f1 = paramFloat1;
        f2 = paramFloat2;
        break label25;
        label111: f6 = Math.min(f2 * paramFloat4 / f5, 10.0F);
        f7 = Math.min(f3 * paramFloat4 / f4, 10.0F);
      }
    }
    return Math.max(arrayOfFloat[0], arrayOfFloat[1]);
  }

  private static Matrix a(Matrix paramMatrix)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.set(paramMatrix);
    return localMatrix;
  }

  private static void a(float[] paramArrayOfFloat)
  {
    for (int i = 0; i < paramArrayOfFloat.length; i++)
      paramArrayOfFloat[i] = Math.round(paramArrayOfFloat[i]);
  }

  public static boolean a(float paramFloat1, float paramFloat2, float paramFloat3, CropState paramCropState)
  {
    Matrix localMatrix = a(paramCropState.g());
    localMatrix.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
    if (!a(paramCropState.a(paramCropState, localMatrix)));
    for (int i = 1; ; i = 0)
      return i;
  }

  public static boolean a(float paramFloat1, float paramFloat2, CropState paramCropState)
  {
    Matrix localMatrix = a(paramCropState.g());
    localMatrix.postTranslate(paramFloat1, paramFloat2);
    if (!a(paramCropState.a(paramCropState, localMatrix)));
    for (int i = 1; ; i = 0)
      return i;
  }

  private static boolean a(RectF paramRectF, float paramFloat1, float paramFloat2)
  {
    if ((paramRectF.left <= paramRectF.right) && (paramRectF.top <= paramRectF.bottom) && (paramFloat1 >= paramRectF.left) && (paramFloat1 <= paramRectF.right) && (paramFloat2 >= paramRectF.top) && (paramFloat2 <= paramRectF.bottom));
    for (int i = 1; ; i = 0)
      return i;
  }

  public static boolean a(CropState paramCropState)
  {
    RectF localRectF1 = new RectF(0.0F, 0.0F, paramCropState.e().b().getWidth(), paramCropState.e().b().getHeight());
    Matrix localMatrix1 = paramCropState.m();
    Matrix localMatrix2 = new Matrix();
    if (localMatrix1.invert(localMatrix2))
    {
      RectF localRectF2 = paramCropState.i();
      float[] arrayOfFloat = new float[8];
      arrayOfFloat[0] = localRectF2.left;
      arrayOfFloat[1] = localRectF2.bottom;
      arrayOfFloat[2] = localRectF2.left;
      arrayOfFloat[3] = localRectF2.top;
      arrayOfFloat[4] = localRectF2.right;
      arrayOfFloat[5] = localRectF2.bottom;
      arrayOfFloat[6] = localRectF2.right;
      arrayOfFloat[7] = localRectF2.top;
      localMatrix2.mapPoints(arrayOfFloat);
      a(arrayOfFloat);
      if ((a(localRectF1, arrayOfFloat[0], arrayOfFloat[1])) && (a(localRectF1, arrayOfFloat[2], arrayOfFloat[3])) && (a(localRectF1, arrayOfFloat[4], arrayOfFloat[5])))
      {
        boolean bool = a(localRectF1, arrayOfFloat[6], arrayOfFloat[7]);
        i = 0;
        if (bool)
          break label222;
      }
    }
    for (int i = 1; ; i = 1)
      label222: return i;
  }

  private static float b(float paramFloat1, float paramFloat2)
  {
    float f1 = (paramFloat2 + 360.0F) % 360.0F;
    float f2 = (paramFloat1 + 360.0F) % 360.0F - f1;
    if (f2 < -180.0F)
      f2 += 360.0F;
    while (true)
    {
      return f2;
      if (f2 <= 180.0F)
        continue;
      f2 -= 360.0F;
    }
  }

  public static float b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8)
  {
    float f = FloatMath.sqrt((paramFloat3 - paramFloat1) * (paramFloat3 - paramFloat1) + (paramFloat4 - paramFloat2) * (paramFloat4 - paramFloat2));
    return FloatMath.sqrt((paramFloat7 - paramFloat5) * (paramFloat7 - paramFloat5) + (paramFloat8 - paramFloat6) * (paramFloat8 - paramFloat6)) / f;
  }

  public static boolean b(float paramFloat1, float paramFloat2, float paramFloat3, CropState paramCropState)
  {
    Matrix localMatrix = a(paramCropState.g());
    localMatrix.postTranslate(-paramFloat2, -paramFloat3);
    localMatrix.postRotate(paramFloat1);
    localMatrix.postTranslate(paramFloat2, paramFloat3);
    if (!a(paramCropState.a(paramCropState, localMatrix)));
    for (int i = 1; ; i = 0)
      return i;
  }

  public static boolean b(CropState paramCropState)
  {
    if ((paramCropState.i().bottom - paramCropState.i().top < 240.0F) || (paramCropState.i().right - paramCropState.i().left < 240.0F));
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.crop.CropStaticHelper
 * JD-Core Version:    0.6.0
 */