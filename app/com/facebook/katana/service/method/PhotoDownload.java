package com.facebook.katana.service.method;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.net.Uri;
import com.facebook.common.util.Log;
import com.facebook.katana.binding.StreamPhoto;
import com.facebook.katana.net.HttpOperation;
import com.facebook.katana.net.HttpOperation.HttpOperationListener;
import com.facebook.katana.net.HttpOperation.Method;
import com.facebook.katana.net.HttpOperation.ResponseInputStream;
import com.facebook.katana.provider.PhotosProvider;
import com.facebook.katana.util.FileUtils;
import com.facebook.katana.util.ImageUtils;
import java.io.File;
import java.io.IOException;

public class PhotoDownload extends ApiMethod
  implements HttpOperation.HttpOperationListener
{
  private final long a;
  private final String b;
  private final String f;
  private final int g;
  private final String h;
  private StreamPhoto i;
  private Bitmap j;
  private byte[] r;

  public PhotoDownload(Context paramContext, Intent paramIntent, long paramLong1, String paramString1, String paramString2, long paramLong2, String paramString3, int paramInt, ServiceOperationListener paramServiceOperationListener)
  {
    super(paramContext, paramIntent, "GET", null, paramString3, paramServiceOperationListener);
    this.a = paramLong1;
    this.b = paramString1;
    this.f = paramString2;
    this.g = paramInt;
    this.h = FileUtils.a(paramContext);
  }

  public static StreamPhoto a(Context paramContext, String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      Bitmap localBitmap2 = ImageUtils.a(paramArrayOfByte, 150, 150);
      localBitmap1 = localBitmap2;
    }
    finally
    {
      try
      {
        String str = FileUtils.a(paramContext);
        if (localBitmap1.getConfig() == Bitmap.Config.RGB_565);
        for (Bitmap.CompressFormat localCompressFormat = Bitmap.CompressFormat.JPEG; ; localCompressFormat = Bitmap.CompressFormat.PNG)
        {
          ImageUtils.a(localBitmap1, localCompressFormat, 80, new File(str));
          ContentValues localContentValues = new ContentValues();
          localContentValues.put("url", paramString);
          localContentValues.put("filename", str);
          StreamPhoto localStreamPhoto = new StreamPhoto(paramContext.getContentResolver().insert(PhotosProvider.i, localContentValues), paramString, str, new File(str).length(), localBitmap1);
          if (0 != 0)
            null.recycle();
          return localStreamPhoto;
        }
        localObject1 = finally;
        Bitmap localBitmap1 = null;
        label143: if (localBitmap1 != null)
          localBitmap1.recycle();
        throw localObject1;
      }
      finally
      {
        break label143;
      }
    }
  }

  // ERROR //
  private static void a(Context paramContext, long paramLong, String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload 4
    //   5: invokestatic 127	com/facebook/katana/util/ImageUtils:b	([B)Landroid/graphics/Bitmap;
    //   8: astore 8
    //   10: aload 8
    //   12: bipush 56
    //   14: bipush 56
    //   16: invokestatic 130	com/facebook/katana/util/ImageUtils:a	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   19: astore 9
    //   21: aload 8
    //   23: invokevirtual 116	android/graphics/Bitmap:recycle	()V
    //   26: aload 9
    //   28: getstatic 66	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   31: bipush 100
    //   33: invokestatic 133	com/facebook/katana/util/ImageUtils:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap$CompressFormat;I)[B
    //   36: astore 10
    //   38: aload 9
    //   40: invokevirtual 116	android/graphics/Bitmap:recycle	()V
    //   43: new 76	android/content/ContentValues
    //   46: dup
    //   47: invokespecial 79	android/content/ContentValues:<init>	()V
    //   50: astore 11
    //   52: aload 11
    //   54: ldc 135
    //   56: aload 10
    //   58: invokevirtual 138	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   61: getstatic 140	com/facebook/katana/provider/PhotosProvider:g	Landroid/net/Uri;
    //   64: new 142	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   71: ldc 145
    //   73: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: lload_1
    //   77: invokevirtual 152	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   80: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 162	android/net/Uri:withAppendedPath	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   86: astore 12
    //   88: aload_0
    //   89: invokevirtual 95	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   92: aload 12
    //   94: aload 11
    //   96: ldc 164
    //   98: iconst_1
    //   99: anewarray 166	java/lang/String
    //   102: dup
    //   103: iconst_0
    //   104: aload_3
    //   105: aastore
    //   106: invokevirtual 170	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   109: pop
    //   110: iconst_0
    //   111: ifeq +7 -> 118
    //   114: aconst_null
    //   115: invokevirtual 116	android/graphics/Bitmap:recycle	()V
    //   118: iconst_0
    //   119: ifeq +7 -> 126
    //   122: aconst_null
    //   123: invokevirtual 116	android/graphics/Bitmap:recycle	()V
    //   126: return
    //   127: astore 6
    //   129: aconst_null
    //   130: astore 7
    //   132: aload 7
    //   134: ifnull +8 -> 142
    //   137: aload 7
    //   139: invokevirtual 116	android/graphics/Bitmap:recycle	()V
    //   142: aload 5
    //   144: ifnull +8 -> 152
    //   147: aload 5
    //   149: invokevirtual 116	android/graphics/Bitmap:recycle	()V
    //   152: aload 6
    //   154: athrow
    //   155: astore 6
    //   157: aload 8
    //   159: astore 7
    //   161: aconst_null
    //   162: astore 5
    //   164: goto -32 -> 132
    //   167: astore 6
    //   169: aload 9
    //   171: astore 5
    //   173: aload 8
    //   175: astore 7
    //   177: goto -45 -> 132
    //   180: astore 6
    //   182: aload 9
    //   184: astore 5
    //   186: aconst_null
    //   187: astore 7
    //   189: goto -57 -> 132
    //
    // Exception table:
    //   from	to	target	type
    //   3	10	127	finally
    //   43	110	127	finally
    //   10	21	155	finally
    //   21	26	167	finally
    //   26	43	180	finally
  }

  // ERROR //
  public static StreamPhoto b(Context paramContext, String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_2
    //   3: invokestatic 127	com/facebook/katana/util/ImageUtils:b	([B)Landroid/graphics/Bitmap;
    //   6: astore 6
    //   8: aload 6
    //   10: ldc 174
    //   12: aload_0
    //   13: invokevirtual 178	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   16: invokevirtual 184	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   19: getfield 190	android/util/DisplayMetrics:density	F
    //   22: fmul
    //   23: f2i
    //   24: invokestatic 193	com/facebook/katana/util/ImageUtils:b	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   27: astore 7
    //   29: aload 7
    //   31: astore 5
    //   33: aload 6
    //   35: invokevirtual 116	android/graphics/Bitmap:recycle	()V
    //   38: aload_0
    //   39: invokestatic 40	com/facebook/katana/util/FileUtils:a	(Landroid/content/Context;)Ljava/lang/String;
    //   42: astore 8
    //   44: aload 5
    //   46: getstatic 119	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   49: bipush 100
    //   51: new 68	java/io/File
    //   54: dup
    //   55: aload 8
    //   57: invokespecial 71	java/io/File:<init>	(Ljava/lang/String;)V
    //   60: invokestatic 74	com/facebook/katana/util/ImageUtils:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap$CompressFormat;ILjava/io/File;)V
    //   63: new 76	android/content/ContentValues
    //   66: dup
    //   67: invokespecial 79	android/content/ContentValues:<init>	()V
    //   70: astore 9
    //   72: aload 9
    //   74: ldc 81
    //   76: aload_1
    //   77: invokevirtual 85	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   80: aload 9
    //   82: ldc 87
    //   84: aload 8
    //   86: invokevirtual 85	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: new 89	com/facebook/katana/binding/StreamPhoto
    //   92: dup
    //   93: aload_0
    //   94: invokevirtual 95	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   97: getstatic 100	com/facebook/katana/provider/PhotosProvider:i	Landroid/net/Uri;
    //   100: aload 9
    //   102: invokevirtual 106	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   105: aload_1
    //   106: aload 8
    //   108: new 68	java/io/File
    //   111: dup
    //   112: aload 8
    //   114: invokespecial 71	java/io/File:<init>	(Ljava/lang/String;)V
    //   117: invokevirtual 110	java/io/File:length	()J
    //   120: aload 5
    //   122: invokespecial 113	com/facebook/katana/binding/StreamPhoto:<init>	(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;JLandroid/graphics/Bitmap;)V
    //   125: astore 10
    //   127: iconst_0
    //   128: ifeq +7 -> 135
    //   131: aconst_null
    //   132: invokevirtual 116	android/graphics/Bitmap:recycle	()V
    //   135: iconst_0
    //   136: ifeq +7 -> 143
    //   139: aconst_null
    //   140: invokevirtual 116	android/graphics/Bitmap:recycle	()V
    //   143: aload 10
    //   145: areturn
    //   146: astore 4
    //   148: aconst_null
    //   149: astore 5
    //   151: aload_3
    //   152: ifnull +7 -> 159
    //   155: aload_3
    //   156: invokevirtual 116	android/graphics/Bitmap:recycle	()V
    //   159: aload 5
    //   161: ifnull +8 -> 169
    //   164: aload 5
    //   166: invokevirtual 116	android/graphics/Bitmap:recycle	()V
    //   169: aload 4
    //   171: athrow
    //   172: astore 4
    //   174: aload 6
    //   176: astore_3
    //   177: aconst_null
    //   178: astore 5
    //   180: goto -29 -> 151
    //   183: astore 4
    //   185: aload 6
    //   187: astore_3
    //   188: goto -37 -> 151
    //   191: astore 4
    //   193: aconst_null
    //   194: astore_3
    //   195: goto -44 -> 151
    //
    // Exception table:
    //   from	to	target	type
    //   2	8	146	finally
    //   8	29	172	finally
    //   33	38	183	finally
    //   38	127	191	finally
  }

  private static void b(Context paramContext, String paramString1, String paramString2)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("filename", paramString2);
    Uri localUri = Uri.withAppendedPath(PhotosProvider.b, paramString1);
    paramContext.getContentResolver().update(localUri, localContentValues, null, null);
  }

  private static void c(Context paramContext, String paramString, byte[] paramArrayOfByte)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("thumbnail", paramArrayOfByte);
    Uri localUri = Uri.withAppendedPath(PhotosProvider.b, paramString);
    paramContext.getContentResolver().update(localUri, localContentValues, null, null);
  }

  private Boolean j()
  {
    try
    {
      ImageUtils.a(this.r, this.h);
      Boolean localBoolean2 = Boolean.valueOf(true);
      localBoolean1 = localBoolean2;
      return localBoolean1;
    }
    catch (IOException localIOException)
    {
      while (true)
      {
        Log.a("Failed to output to file.", localIOException);
        Boolean localBoolean1 = Boolean.valueOf(false);
      }
    }
  }

  public void a(HttpOperation paramHttpOperation, int paramInt, String paramString, HttpOperation.ResponseInputStream paramResponseInputStream, Exception paramException)
  {
    File localFile1;
    if (paramInt == 200)
      localFile1 = new File(this.h);
    while (true)
    {
      try
      {
        this.r = ImageUtils.a(paramResponseInputStream);
        this.r.length;
        int k = this.g;
        switch (k)
        {
        default:
          localFile2 = localFile1;
          if ((localFile2 == null) || (!localFile2.exists()))
            continue;
          localFile2.delete();
          super.a(paramInt, paramString, paramException);
          return;
        case 73:
          this.i = a(this.o, this.d, this.r);
          localFile2 = localFile1;
          break;
        case 72:
          this.i = b(this.o, this.d, this.r);
          localFile2 = localFile1;
          break;
        case 74:
          a(this.o, this.a, this.b, this.r);
          localFile2 = localFile1;
          break;
        case 75:
          c(this.o, this.f, this.r);
          localFile2 = localFile1;
          break;
        case 77:
          this.j = ImageUtils.b(this.r);
          localFile2 = null;
          continue;
        case 76:
        }
      }
      catch (IOException paramException)
      {
        File localFile2;
        if ((localFile1 != null) && (localFile1.exists()))
        {
          localFile1.delete();
          paramString = null;
          paramInt = 0;
          continue;
          new PhotoDownload.WriteDataToFileTask(this, null).execute(new Void[0]);
          localFile2 = null;
          continue;
        }
      }
      catch (com.facebook.katana.util.ImageUtils.ImageException paramException)
      {
        if ((localFile1 != null) && (localFile1.exists()))
        {
          localFile1.delete();
          paramString = null;
          paramInt = 0;
          continue;
        }
      }
      finally
      {
        if ((localFile1 == null) || (!localFile1.exists()))
          continue;
        localFile1.delete();
      }
      paramString = null;
      paramInt = 0;
    }
  }

  public void a(HttpOperation paramHttpOperation, long paramLong1, long paramLong2)
  {
  }

  public void b()
  {
    try
    {
      this.l = new HttpOperation(this.o, HttpOperation.Method.GET, this.d, this, false);
      this.l.b();
      return;
    }
    catch (Exception localException)
    {
      while (true)
      {
        localException.printStackTrace();
        this.q.a_(this, 0, null, localException);
      }
    }
  }

  public StreamPhoto g()
  {
    return this.i;
  }

  public Bitmap h()
  {
    return this.j;
  }

  public byte[] i()
  {
    return this.r;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.PhotoDownload
 * JD-Core Version:    0.6.0
 */