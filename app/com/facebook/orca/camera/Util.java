package com.facebook.orca.camera;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import com.facebook.orca.debug.BLog;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.IOException;

public class Util
{
  private static final Class<?> a = Util.class;

  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int i = b(paramOptions, paramInt1, paramInt2);
    if (i <= 8)
    {
      j = 1;
      while (j < i)
        j <<= 1;
    }
    int j = 8 * ((i + 7) / 8);
    return j;
  }

  public static Bitmap a(int paramInt1, int paramInt2, Uri paramUri, ContentResolver paramContentResolver, ParcelFileDescriptor paramParcelFileDescriptor, BitmapFactory.Options paramOptions)
  {
    Object localObject1 = null;
    if (paramParcelFileDescriptor == null);
    try
    {
      ParcelFileDescriptor localParcelFileDescriptor = a(paramUri, paramContentResolver);
      paramParcelFileDescriptor = localParcelFileDescriptor;
      if (paramParcelFileDescriptor == null);
      while (true)
      {
        return localObject1;
        if (paramOptions == null)
          paramOptions = new BitmapFactory.Options();
        FileDescriptor localFileDescriptor = paramParcelFileDescriptor.getFileDescriptor();
        paramOptions.inJustDecodeBounds = true;
        BitmapManager.a().a(localFileDescriptor, paramOptions);
        if ((!paramOptions.mCancel) && (paramOptions.outWidth != -1))
        {
          int i = paramOptions.outHeight;
          if (i != -1);
        }
        else
        {
          a(paramParcelFileDescriptor);
          localObject1 = null;
          continue;
        }
        paramOptions.inSampleSize = a(paramOptions, paramInt1, paramInt2);
        paramOptions.inJustDecodeBounds = false;
        paramOptions.inDither = false;
        paramOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
        Bitmap localBitmap = BitmapManager.a().a(localFileDescriptor, paramOptions);
        localObject1 = localBitmap;
        a(paramParcelFileDescriptor);
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (true)
      {
        BLog.e(a, "Got oom exception ", localOutOfMemoryError);
        a(paramParcelFileDescriptor);
        localObject1 = null;
      }
    }
    finally
    {
      a(paramParcelFileDescriptor);
    }
    throw localObject2;
  }

  // ERROR //
  public static Bitmap a(int paramInt1, int paramInt2, Uri paramUri, ContentResolver paramContentResolver, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_3
    //   1: aload_2
    //   2: ldc 88
    //   4: invokevirtual 94	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
    //   7: astore 9
    //   9: aload 9
    //   11: astore 6
    //   13: iload 4
    //   15: ifeq +72 -> 87
    //   18: invokestatic 97	com/facebook/orca/camera/Util:a	()Landroid/graphics/BitmapFactory$Options;
    //   21: astore 10
    //   23: iload_0
    //   24: iload_1
    //   25: aload_2
    //   26: aload_3
    //   27: aload 6
    //   29: aload 10
    //   31: invokestatic 99	com/facebook/orca/camera/Util:a	(IILandroid/net/Uri;Landroid/content/ContentResolver;Landroid/os/ParcelFileDescriptor;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   34: astore 12
    //   36: aload 12
    //   38: astore 8
    //   40: aload 6
    //   42: invokestatic 27	com/facebook/orca/camera/Util:a	(Landroid/os/ParcelFileDescriptor;)V
    //   45: aload 8
    //   47: areturn
    //   48: astore 7
    //   50: aconst_null
    //   51: astore 6
    //   53: aload 6
    //   55: invokestatic 27	com/facebook/orca/camera/Util:a	(Landroid/os/ParcelFileDescriptor;)V
    //   58: aconst_null
    //   59: astore 8
    //   61: goto -16 -> 45
    //   64: astore 5
    //   66: aconst_null
    //   67: astore 6
    //   69: aload 6
    //   71: invokestatic 27	com/facebook/orca/camera/Util:a	(Landroid/os/ParcelFileDescriptor;)V
    //   74: aload 5
    //   76: athrow
    //   77: astore 5
    //   79: goto -10 -> 69
    //   82: astore 11
    //   84: goto -31 -> 53
    //   87: aconst_null
    //   88: astore 10
    //   90: goto -67 -> 23
    //
    // Exception table:
    //   from	to	target	type
    //   0	9	48	java/io/IOException
    //   0	9	64	finally
    //   18	36	77	finally
    //   18	36	82	java/io/IOException
  }

  public static Bitmap a(int paramInt1, int paramInt2, ParcelFileDescriptor paramParcelFileDescriptor, boolean paramBoolean)
  {
    if (paramBoolean);
    for (BitmapFactory.Options localOptions = a(); ; localOptions = null)
      return a(paramInt1, paramInt2, null, null, paramParcelFileDescriptor, localOptions);
  }

  public static Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    Matrix localMatrix;
    if ((paramInt != 0) && (paramBitmap != null))
    {
      localMatrix = new Matrix();
      localMatrix.setRotate(paramInt, paramBitmap.getWidth() / 2.0F, paramBitmap.getHeight() / 2.0F);
    }
    try
    {
      int i = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
      if (paramBitmap != localBitmap)
      {
        paramBitmap.recycle();
        paramBitmap = localBitmap;
      }
      label75: return paramBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      break label75;
    }
  }

  public static Bitmap a(Matrix paramMatrix, Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = paramBitmap.getWidth() - paramInt1;
    int j = paramBitmap.getHeight() - paramInt2;
    Bitmap localBitmap2;
    if ((!paramBoolean1) && ((i < 0) || (j < 0)))
    {
      Bitmap localBitmap3 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap3);
      int n = Math.max(0, i / 2);
      int i1 = Math.max(0, j / 2);
      Rect localRect = new Rect(n, i1, n + Math.min(paramInt1, paramBitmap.getWidth()), i1 + Math.min(paramInt2, paramBitmap.getHeight()));
      int i2 = (paramInt1 - localRect.width()) / 2;
      int i3 = (paramInt2 - localRect.height()) / 2;
      localCanvas.drawBitmap(paramBitmap, localRect, new Rect(i2, i3, paramInt1 - i2, paramInt2 - i3), null);
      if (paramBoolean2)
        paramBitmap.recycle();
      localBitmap2 = localBitmap3;
      return localBitmap2;
    }
    float f1 = paramBitmap.getWidth();
    float f2 = paramBitmap.getHeight();
    label231: Matrix localMatrix;
    if (f1 / f2 > paramInt1 / paramInt2)
    {
      float f4 = paramInt2 / f2;
      if ((f4 < 0.9F) || (f4 > 1.0F))
      {
        paramMatrix.setScale(f4, f4);
        localMatrix = paramMatrix;
        label234: if (localMatrix == null)
          break label389;
      }
    }
    label389: for (Bitmap localBitmap1 = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true); ; localBitmap1 = paramBitmap)
    {
      if ((paramBoolean2) && (localBitmap1 != paramBitmap))
        paramBitmap.recycle();
      int k = Math.max(0, localBitmap1.getWidth() - paramInt1);
      int m = Math.max(0, localBitmap1.getHeight() - paramInt2);
      localBitmap2 = Bitmap.createBitmap(localBitmap1, k / 2, m / 2, paramInt1, paramInt2);
      if ((localBitmap2 == localBitmap1) || ((!paramBoolean2) && (localBitmap1 == paramBitmap)))
        break;
      localBitmap1.recycle();
      break;
      paramMatrix = null;
      break label231;
      float f3 = paramInt1 / f1;
      if ((f3 < 0.9F) || (f3 > 1.0F))
      {
        paramMatrix.setScale(f3, f3);
        localMatrix = paramMatrix;
        break label234;
      }
      localMatrix = null;
      break label234;
    }
  }

  public static BitmapFactory.Options a()
  {
    return new BitmapFactory.Options();
  }

  private static ParcelFileDescriptor a(Uri paramUri, ContentResolver paramContentResolver)
  {
    try
    {
      ParcelFileDescriptor localParcelFileDescriptor2 = paramContentResolver.openFileDescriptor(paramUri, "r");
      localParcelFileDescriptor1 = localParcelFileDescriptor2;
      return localParcelFileDescriptor1;
    }
    catch (IOException localIOException)
    {
      while (true)
        ParcelFileDescriptor localParcelFileDescriptor1 = null;
    }
  }

  public static void a(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    if (paramParcelFileDescriptor == null);
    while (true)
    {
      return;
      try
      {
        paramParcelFileDescriptor.close();
      }
      catch (Throwable localThrowable)
      {
      }
    }
  }

  public static void a(MonitoredActivity paramMonitoredActivity, String paramString1, String paramString2, Runnable paramRunnable, Handler paramHandler)
  {
    new Thread(new Util.BackgroundJob(paramMonitoredActivity, paramRunnable, ProgressDialog.show(paramMonitoredActivity, paramString1, paramString2, true, false), paramHandler)).start();
  }

  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable == null);
    while (true)
    {
      return;
      try
      {
        paramCloseable.close();
      }
      catch (Throwable localThrowable)
      {
      }
    }
  }

  public static boolean a(String paramString1, String paramString2)
  {
    if ((paramString1 == paramString2) || (paramString1.equals(paramString2)));
    for (int i = 1; ; i = 0)
      return i;
  }

  private static int b(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    double d1 = paramOptions.outWidth;
    double d2 = paramOptions.outHeight;
    int i;
    int j;
    if (paramInt2 == -1)
    {
      i = 1;
      if (paramInt1 != -1)
        break label60;
      j = 128;
      label31: if (j >= i)
        break label84;
    }
    while (true)
    {
      return i;
      i = (int)Math.ceil(Math.sqrt(d1 * d2 / paramInt2));
      break;
      label60: j = (int)Math.min(Math.floor(d1 / paramInt1), Math.floor(d2 / paramInt1));
      break label31;
      label84: if ((paramInt2 == -1) && (paramInt1 == -1))
      {
        i = 1;
        continue;
      }
      if (paramInt1 == -1)
        continue;
      i = j;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.camera.Util
 * JD-Core Version:    0.6.0
 */