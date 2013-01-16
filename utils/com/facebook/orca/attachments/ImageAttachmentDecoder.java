package com.facebook.orca.attachments;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.util.DisplayMetrics;
import com.facebook.orca.images.ImageCacheKey.Options;
import com.facebook.orca.images.ImageCacheKey.Options.DownscalingMethod;
import com.facebook.orca.media.MediaResource;
import com.google.common.base.Objects;
import com.google.common.io.ByteStreams;
import java.io.File;

public class ImageAttachmentDecoder
{
  private final Context a;

  public ImageAttachmentDecoder(Context paramContext)
  {
    this.a = paramContext;
  }

  private int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, ImageCacheKey.Options.DownscalingMethod paramDownscalingMethod)
  {
    label40: int i;
    if (paramInt2 == -2)
    {
      paramInt2 = this.a.getResources().getDisplayMetrics().heightPixels;
      if (paramInt1 != -2)
        break label94;
      paramInt1 = this.a.getResources().getDisplayMetrics().widthPixels;
      i = 1;
      switch (ImageAttachmentDecoder.2.a[paramDownscalingMethod.ordinal()])
      {
      default:
      case 1:
      case 2:
      case 3:
      }
    }
    while (true)
    {
      return i;
      if (paramInt2 != -1)
        break;
      paramInt2 = paramInt4;
      break;
      label94: if (paramInt1 != -1)
        break label40;
      paramInt1 = paramInt3;
      break label40;
      int j = 4 * (paramInt4 * paramInt3);
      int k = 4 * (paramInt1 * (paramInt2 * 17)) / 10;
      while (j > k)
      {
        int m = i * 2;
        j /= 4;
        i = m;
      }
      i = (int)Math.max(Math.floor(paramInt3 / paramInt1), Math.floor(paramInt4 / paramInt2));
      continue;
      i = (int)Math.min(Math.floor(paramInt3 / paramInt1), Math.floor(paramInt4 / paramInt2));
    }
  }

  private int a(MediaAttachment paramMediaAttachment)
  {
    Uri localUri = paramMediaAttachment.a().c();
    File localFile;
    if (!Objects.equal("file", localUri.getScheme()))
    {
      String str = "temp-rotate_" + System.currentTimeMillis();
      localFile = this.a.getFileStreamPath(str);
    }
    while (true)
    {
      try
      {
        ByteStreams.a(paramMediaAttachment.c(), new ImageAttachmentDecoder.1(this, localFile));
        int j = new ExifInterface(localFile.getAbsolutePath()).getAttributeInt("Orientation", 1);
        i = j;
        return i;
      }
      finally
      {
        localFile.delete();
      }
      int i = new ExifInterface(localUri.getPath()).getAttributeInt("Orientation", 1);
    }
  }

  private Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    if ((paramInt == 0) || (paramInt == 1))
      return paramBitmap;
    Matrix localMatrix = new Matrix();
    if (paramInt == 2)
    {
      localMatrix.postScale(1.0F, -1.0F);
      paramInt = 1;
      label34: if (paramInt != 3)
        break label131;
      localMatrix.postRotate(180.0F);
    }
    while (true)
    {
      int i = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
      break;
      if (paramInt == 4)
      {
        localMatrix.postScale(1.0F, -1.0F);
        paramInt = 3;
        break label34;
      }
      if (paramInt == 7)
      {
        localMatrix.postScale(1.0F, -1.0F);
        paramInt = 6;
        break label34;
      }
      if (paramInt != 5)
        break label34;
      localMatrix.postScale(1.0F, -1.0F);
      paramInt = 8;
      break label34;
      label131: if (paramInt == 6)
        localMatrix.postRotate(90.0F);
      else if (paramInt == 8)
        localMatrix.postRotate(270.0F);
    }
  }

  public Bitmap a(MediaAttachment paramMediaAttachment, int paramInt)
  {
    return a(paramMediaAttachment, paramInt, paramInt);
  }

  public Bitmap a(MediaAttachment paramMediaAttachment, int paramInt1, int paramInt2)
  {
    return a(paramMediaAttachment, paramInt1, paramInt2, false, ImageCacheKey.Options.a);
  }

  // ERROR //
  public Bitmap a(MediaAttachment paramMediaAttachment, int paramInt1, int paramInt2, boolean paramBoolean, ImageCacheKey.Options.DownscalingMethod paramDownscalingMethod)
  {
    // Byte code:
    //   0: new 191	android/graphics/BitmapFactory$Options
    //   3: dup
    //   4: invokespecial 192	android/graphics/BitmapFactory$Options:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: iconst_1
    //   12: putfield 196	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   15: aload_1
    //   16: invokevirtual 200	com/facebook/orca/attachments/MediaAttachment:b	()Ljava/io/InputStream;
    //   19: astore 9
    //   21: aload 9
    //   23: instanceof 202
    //   26: ifeq +123 -> 149
    //   29: aload 9
    //   31: checkcast 202	java/io/FileInputStream
    //   34: invokevirtual 206	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   37: aconst_null
    //   38: aload 6
    //   40: invokestatic 212	android/graphics/BitmapFactory:decodeFileDescriptor	(Ljava/io/FileDescriptor;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   43: pop
    //   44: aload 9
    //   46: invokestatic 217	com/google/common/io/Closeables:a	(Ljava/io/Closeable;)V
    //   49: iload_2
    //   50: iconst_m1
    //   51: if_icmpne +120 -> 171
    //   54: iload_3
    //   55: iconst_m1
    //   56: if_icmpne +115 -> 171
    //   59: iconst_1
    //   60: istore 13
    //   62: new 191	android/graphics/BitmapFactory$Options
    //   65: dup
    //   66: invokespecial 192	android/graphics/BitmapFactory$Options:<init>	()V
    //   69: astore 14
    //   71: aload 14
    //   73: iload 13
    //   75: putfield 220	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   78: aload_1
    //   79: invokevirtual 200	com/facebook/orca/attachments/MediaAttachment:b	()Ljava/io/InputStream;
    //   82: astore 15
    //   84: iload 4
    //   86: ifeq +112 -> 198
    //   89: aload 15
    //   91: instanceof 202
    //   94: ifeq +104 -> 198
    //   97: aload 15
    //   99: checkcast 202	java/io/FileInputStream
    //   102: invokevirtual 206	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   105: astore 20
    //   107: aload 14
    //   109: iconst_1
    //   110: putfield 223	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   113: aload 14
    //   115: iconst_1
    //   116: putfield 226	android/graphics/BitmapFactory$Options:inInputShareable	Z
    //   119: aload 20
    //   121: aconst_null
    //   122: aload 14
    //   124: invokestatic 212	android/graphics/BitmapFactory:decodeFileDescriptor	(Ljava/io/FileDescriptor;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   127: astore 21
    //   129: aload 21
    //   131: astore 8
    //   133: aload 15
    //   135: invokestatic 217	com/google/common/io/Closeables:a	(Ljava/io/Closeable;)V
    //   138: aload 8
    //   140: ifnonnull +85 -> 225
    //   143: aconst_null
    //   144: astore 8
    //   146: aload 8
    //   148: areturn
    //   149: aload 9
    //   151: aconst_null
    //   152: aload 6
    //   154: invokestatic 230	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   157: pop
    //   158: goto -114 -> 44
    //   161: astore 10
    //   163: aload 9
    //   165: invokestatic 217	com/google/common/io/Closeables:a	(Ljava/io/Closeable;)V
    //   168: aload 10
    //   170: athrow
    //   171: aload_0
    //   172: iload_2
    //   173: iload_3
    //   174: aload 6
    //   176: getfield 233	android/graphics/BitmapFactory$Options:outWidth	I
    //   179: aload 6
    //   181: getfield 236	android/graphics/BitmapFactory$Options:outHeight	I
    //   184: aload 5
    //   186: invokespecial 238	com/facebook/orca/attachments/ImageAttachmentDecoder:a	(IIIILcom/facebook/orca/images/ImageCacheKey$Options$DownscalingMethod;)I
    //   189: istore 12
    //   191: iload 12
    //   193: istore 13
    //   195: goto -133 -> 62
    //   198: aload 15
    //   200: aconst_null
    //   201: aload 14
    //   203: invokestatic 230	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   206: astore 17
    //   208: aload 17
    //   210: astore 8
    //   212: goto -79 -> 133
    //   215: astore 16
    //   217: aload 15
    //   219: invokestatic 217	com/google/common/io/Closeables:a	(Ljava/io/Closeable;)V
    //   222: aload 16
    //   224: athrow
    //   225: aload_0
    //   226: aload 8
    //   228: aload_0
    //   229: aload_1
    //   230: invokespecial 240	com/facebook/orca/attachments/ImageAttachmentDecoder:a	(Lcom/facebook/orca/attachments/MediaAttachment;)I
    //   233: invokespecial 242	com/facebook/orca/attachments/ImageAttachmentDecoder:a	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   236: astore 19
    //   238: aload 19
    //   240: astore 8
    //   242: goto -96 -> 146
    //   245: astore 18
    //   247: goto -101 -> 146
    //   250: astore 7
    //   252: aconst_null
    //   253: astore 8
    //   255: goto -109 -> 146
    //
    // Exception table:
    //   from	to	target	type
    //   21	44	161	finally
    //   149	158	161	finally
    //   89	129	215	finally
    //   198	208	215	finally
    //   225	238	245	java/io/IOException
    //   0	21	250	java/io/IOException
    //   44	84	250	java/io/IOException
    //   133	138	250	java/io/IOException
    //   163	191	250	java/io/IOException
    //   217	225	250	java/io/IOException
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.attachments.ImageAttachmentDecoder
 * JD-Core Version:    0.6.2
 */