package com.facebook.katana.util;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.MediaStore.Images.Media;
import com.facebook.camera.utils.Storage;
import com.facebook.common.util.ErrorReporting;
import com.facebook.katana.model.PhotoItem;
import com.facebook.orca.inject.FbInjector;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ImageUtils
{
  public static float a;
  public static float b;
  private static final Paint c = new Paint(2);
  private static final Map<Integer, String[]> d = new HashMap();
  private static final Paint e;
  private static final Paint f;
  private static final Paint g;

  static
  {
    d.put(Integer.valueOf(11), new String[] { "FNumber", "ExposureTime", "ISOSpeedRatings" });
    d.put(Integer.valueOf(9), new String[] { "GPSAltitude", "GPSAltitudeRef" });
    d.put(Integer.valueOf(8), new String[] { "FocalLength", "GPSDateStamp", "GPSTimeStamp", "GPSProcessingMethod" });
    d.put(Integer.valueOf(5), new String[] { "DateTime", "Flash", "Orientation", "GPSLatitude", "GPSLatitudeRef", "GPSLongitude", "GPSLongitudeRef", "Make", "Model", "WhiteBalance" });
    e = new Paint();
    e.setStrokeWidth(1.0F);
    e.setStyle(Paint.Style.STROKE);
    e.setColor(-2039584);
    f = new Paint();
    f.setStrokeWidth(1.0F);
    f.setStyle(Paint.Style.STROKE);
    f.setColor(-986896);
    g = new Paint();
    g.setStrokeWidth(3.0F);
    g.setStyle(Paint.Style.STROKE);
    g.setColor(-986896);
    a = 7.0F;
    b = 50.0F;
  }

  private static float a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    float f1;
    if ((paramBoolean) && ((paramInt3 == 90) || (paramInt3 == 270)))
    {
      if ((paramInt2 <= paramInt4) && (paramInt1 <= paramInt5))
        break label59;
      f1 = Math.max(paramInt2 / paramInt4, paramInt1 / paramInt5);
    }
    while (true)
    {
      return f1;
      int i = paramInt2;
      paramInt2 = paramInt1;
      paramInt1 = i;
      break;
      label59: f1 = 1.0F;
    }
  }

  public static int a(Context paramContext, Uri paramUri)
  {
    Cursor localCursor;
    int i;
    if ((paramUri.getScheme().equals("content")) && (paramUri.getHost().equals("media")) && (paramUri.getPath().startsWith(MediaStore.Images.Media.EXTERNAL_CONTENT_URI.getPath())))
    {
      localCursor = paramContext.getContentResolver().query(paramUri, new String[] { "orientation" }, null, null, null);
      if (localCursor.getCount() != 1)
        i = -1;
    }
    while (true)
    {
      return i;
      localCursor.moveToFirst();
      i = localCursor.getInt(0);
      continue;
      if (paramUri.getScheme().equals("file"))
      {
        i = c(paramUri.getPath());
        continue;
      }
      i = -1;
    }
  }

  public static Bitmap a(Context paramContext, Uri paramUri, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    ImageUtils.ImageSource localImageSource = new ImageUtils.ImageSource(paramUri);
    try
    {
      Bitmap localBitmap = a(paramContext, localImageSource, a(paramContext, paramUri), paramInt1, paramInt2, paramBoolean);
      return localBitmap;
    }
    catch (IOException localIOException)
    {
    }
    throw new ImageUtils.ImageIOException(paramUri.toString(), localIOException);
  }

  public static Bitmap a(Context paramContext, Uri paramUri, ContentResolver paramContentResolver, int paramInt)
  {
    return ThumbnailUtils.createVideoThumbnail(((Storage)FbInjector.a(paramContext).a(Storage.class)).b(paramUri, paramContentResolver), paramInt);
  }

  public static Bitmap a(Context paramContext, Uri paramUri, boolean paramBoolean)
  {
    return a(paramContext, paramUri, 960, 960, paramBoolean);
  }

  private static Bitmap a(Context paramContext, ImageUtils.ImageSource paramImageSource, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    while (true)
    {
      try
      {
        BitmapFactory.Options localOptions1 = paramImageSource.a(paramContext);
        float f1 = a(localOptions1.outWidth, localOptions1.outHeight, paramInt1, paramInt2, paramInt3, paramBoolean);
        float f2 = 1.0F;
        int i = 0;
        OutOfMemoryError localOutOfMemoryError2 = null;
        if (f2 < 2.0F)
          if ((int)f1 == i)
          {
            i = (int)f1;
            f1 *= 1.19F;
            f2 *= 1.19F;
            continue;
          }
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        throw new ImageUtils.ImageOutOfMemoryException(localOutOfMemoryError1);
      }
      try
      {
        BitmapFactory.Options localOptions2 = new BitmapFactory.Options();
        localOptions2.inSampleSize = (int)f1;
        Bitmap localBitmap = a(paramImageSource.a(paramContext, localOptions2), paramInt1, paramBoolean);
        return localBitmap;
        ErrorReporting.a(ImageUtils.class.getSimpleName(), "unable to resize image, even after additional subsampling");
        throw new ImageUtils.ImageOutOfMemoryException(localOutOfMemoryError2);
      }
      catch (OutOfMemoryError localOutOfMemoryError3)
      {
      }
    }
  }

  public static Bitmap a(Context paramContext, File paramFile, int paramInt)
  {
    Bitmap localBitmap1 = a(paramContext, Uri.fromFile(paramFile), paramInt, paramInt, false);
    if (localBitmap1 == null);
    for (Bitmap localBitmap2 = null; ; localBitmap2 = localBitmap1)
    {
      return localBitmap2;
      if ((localBitmap1.getWidth() > paramInt) || (localBitmap1.getHeight() > paramInt))
        break;
    }
    double d1 = localBitmap1.getWidth() / localBitmap1.getHeight();
    int i;
    if (d1 > 1.0D)
    {
      int j = (int)(paramInt / d1);
      i = paramInt;
      paramInt = j;
    }
    while (true)
    {
      localBitmap2 = Bitmap.createScaledBitmap(localBitmap1, i, paramInt, true);
      break;
      i = (int)(d1 * paramInt);
    }
  }

  public static Bitmap a(Resources paramResources, int paramInt)
  {
    Bitmap localBitmap = BitmapFactory.decodeResource(paramResources, paramInt);
    if (localBitmap != null);
    while (true)
    {
      return localBitmap;
      try
      {
        XmlResourceParser localXmlResourceParser = paramResources.getXml(paramInt);
        int j;
        for (int i = localXmlResourceParser.getEventType(); i != 1; i = j)
        {
          if ((i == 2) && ((localXmlResourceParser.getName().equals("nine-patch")) || (localXmlResourceParser.getName().equals("bitmap"))))
          {
            localBitmap = BitmapFactory.decodeResource(paramResources, localXmlResourceParser.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "src", 0));
            break;
          }
          j = localXmlResourceParser.next();
        }
      }
      catch (Exception localException)
      {
      }
    }
  }

  public static Bitmap a(Bitmap paramBitmap, int paramInt)
  {
    Bitmap localBitmap = null;
    try
    {
      localBitmap = Bitmap.createBitmap(paramInt, paramInt, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      if (paramBitmap.getWidth() > paramBitmap.getHeight());
      int i;
      for (int j = paramBitmap.getHeight(); ; j = i)
      {
        localCanvas.drawBitmap(paramBitmap, new Rect((paramBitmap.getWidth() - j) / 2, (paramBitmap.getHeight() - j) / 2, (j + paramBitmap.getWidth()) / 2, (j + paramBitmap.getHeight()) / 2), new Rect(0, 0, paramInt, paramInt), c);
        return localBitmap;
        i = paramBitmap.getWidth();
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (localBitmap != null)
        localBitmap.recycle();
    }
    throw new ImageUtils.ImageOutOfMemoryException(localOutOfMemoryError);
  }

  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    Bitmap localBitmap = null;
    try
    {
      localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      new Canvas(localBitmap).drawBitmap(paramBitmap, new Rect((paramBitmap.getWidth() - paramInt1) / 2, (paramBitmap.getHeight() - paramInt2) / 2, (paramInt1 + paramBitmap.getWidth()) / 2, (paramInt2 + paramBitmap.getHeight()) / 2), new Rect(0, 0, paramInt1, paramInt2), null);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (localBitmap != null)
        localBitmap.recycle();
    }
    throw new ImageUtils.ImageOutOfMemoryException(localOutOfMemoryError);
  }

  public static Bitmap a(Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    if ((!paramBoolean) || (paramInt <= 0));
    while (true)
    {
      return paramBitmap;
      try
      {
        Matrix localMatrix = new Matrix();
        localMatrix.postRotate(paramInt);
        int i = paramBitmap.getWidth();
        int j = paramBitmap.getHeight();
        Bitmap localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
        paramBitmap.recycle();
        paramBitmap = localBitmap;
      }
      finally
      {
        paramBitmap.recycle();
      }
    }
  }

  public static Bitmap a(Uri paramUri, Rect paramRect, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    BitmapRegionDecoder localBitmapRegionDecoder = BitmapRegionDecoder.newInstance(paramUri.toString(), true);
    float f1 = a(paramRect.width(), paramRect.height(), paramInt1, paramInt2, paramInt3, paramBoolean);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inSampleSize = (int)f1;
    return a(localBitmapRegionDecoder.decodeRegion(paramRect, localOptions), paramInt1, paramBoolean);
  }

  public static Bitmap a(String paramString, int paramInt)
  {
    ImageUtils.Dimension localDimension = a(paramString);
    float f1 = 1.0F;
    if (Math.max(localDimension.b, localDimension.a) > paramInt)
      f1 = Math.max(localDimension.b, localDimension.a) / paramInt;
    int i = (int)(localDimension.b / f1);
    int j = (int)(localDimension.a / f1);
    try
    {
      Bitmap localBitmap = a(paramString, i, j);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
    }
    throw new ImageUtils.ImageOutOfMemoryException(localOutOfMemoryError);
  }

  public static Bitmap a(String paramString, int paramInt1, int paramInt2)
  {
    ImageUtils.Dimension localDimension = a(paramString);
    Bitmap localBitmap;
    if ((localDimension.b <= paramInt1) && (localDimension.a <= paramInt2))
      localBitmap = b(paramString);
    while (true)
    {
      return localBitmap;
      float f1 = localDimension.b / paramInt1;
      float f2 = localDimension.a / paramInt2;
      float f3;
      if (f1 > f2)
        f3 = paramInt1;
      while (true)
      {
        if (localDimension.b <= f3)
          break label119;
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inSampleSize = (localDimension.b / (int)f3);
        localBitmap = a(paramString, localOptions);
        break;
        f3 = localDimension.b / f2;
      }
      label119: localBitmap = b(paramString);
    }
  }

  // ERROR //
  public static Bitmap a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: iload_1
    //   1: iconst_3
    //   2: isub
    //   3: istore 4
    //   5: iload_2
    //   6: iconst_3
    //   7: isub
    //   8: istore 5
    //   10: aload_0
    //   11: invokestatic 389	com/facebook/katana/util/ImageUtils:a	(Ljava/lang/String;)Lcom/facebook/katana/util/ImageUtils$Dimension;
    //   14: astore 11
    //   16: aload 11
    //   18: getfield 393	com/facebook/katana/util/ImageUtils$Dimension:b	I
    //   21: iload 4
    //   23: if_icmpgt +13 -> 36
    //   26: aload 11
    //   28: getfield 395	com/facebook/katana/util/ImageUtils$Dimension:a	I
    //   31: iload 5
    //   33: if_icmple +266 -> 299
    //   36: aload 11
    //   38: getfield 393	com/facebook/katana/util/ImageUtils$Dimension:b	I
    //   41: i2f
    //   42: iload 4
    //   44: i2f
    //   45: fdiv
    //   46: fstore 12
    //   48: aload 11
    //   50: getfield 395	com/facebook/katana/util/ImageUtils$Dimension:a	I
    //   53: i2f
    //   54: iload 5
    //   56: i2f
    //   57: fdiv
    //   58: fstore 13
    //   60: fload 12
    //   62: fload 13
    //   64: fcmpl
    //   65: ifle +206 -> 271
    //   68: iload 4
    //   70: i2f
    //   71: fstore 14
    //   73: aload 11
    //   75: getfield 395	com/facebook/katana/util/ImageUtils$Dimension:a	I
    //   78: i2f
    //   79: fload 12
    //   81: fdiv
    //   82: fstore 15
    //   84: aload 11
    //   86: getfield 393	com/facebook/katana/util/ImageUtils$Dimension:b	I
    //   89: i2f
    //   90: fload 14
    //   92: fdiv
    //   93: fconst_1
    //   94: fcmpl
    //   95: ifle +195 -> 290
    //   98: new 239	android/graphics/BitmapFactory$Options
    //   101: dup
    //   102: invokespecial 255	android/graphics/BitmapFactory$Options:<init>	()V
    //   105: astore 16
    //   107: aload 16
    //   109: aload 11
    //   111: getfield 393	com/facebook/katana/util/ImageUtils$Dimension:b	I
    //   114: fload 14
    //   116: f2i
    //   117: idiv
    //   118: putfield 258	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   121: aload_0
    //   122: aload 16
    //   124: invokestatic 407	com/facebook/katana/util/ImageUtils:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   127: astore 17
    //   129: aload 17
    //   131: astore 18
    //   133: fload 15
    //   135: fstore 19
    //   137: fload 14
    //   139: fstore 20
    //   141: aload 18
    //   143: astore 10
    //   145: iconst_3
    //   146: fload 20
    //   148: f2i
    //   149: iadd
    //   150: istore 21
    //   152: iconst_3
    //   153: fload 19
    //   155: f2i
    //   156: iadd
    //   157: istore 22
    //   159: iload 21
    //   161: iload 22
    //   163: getstatic 337	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   166: invokestatic 341	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   169: astore 23
    //   171: new 343	android/graphics/Canvas
    //   174: dup
    //   175: aload 23
    //   177: invokespecial 346	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   180: astore 24
    //   182: aload 24
    //   184: iconst_m1
    //   185: invokevirtual 411	android/graphics/Canvas:drawColor	(I)V
    //   188: iload_3
    //   189: tableswitch	default:+23 -> 212, 0:+147->336, 1:+287->476
    //   213: dload 25
    //   215: lconst_1
    //   216: new 348	android/graphics/Rect
    //   219: dup
    //   220: iconst_0
    //   221: iconst_0
    //   222: aload 10
    //   224: invokevirtual 286	android/graphics/Bitmap:getWidth	()I
    //   227: aload 10
    //   229: invokevirtual 289	android/graphics/Bitmap:getHeight	()I
    //   232: invokespecial 351	android/graphics/Rect:<init>	(IIII)V
    //   235: new 348	android/graphics/Rect
    //   238: dup
    //   239: iconst_3
    //   240: iconst_3
    //   241: iconst_1
    //   242: fload 20
    //   244: f2i
    //   245: iadd
    //   246: fload 19
    //   248: f2i
    //   249: invokespecial 351	android/graphics/Rect:<init>	(IIII)V
    //   252: getstatic 25	com/facebook/katana/util/ImageUtils:c	Landroid/graphics/Paint;
    //   255: invokevirtual 355	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   258: aload 10
    //   260: ifnull +8 -> 268
    //   263: aload 10
    //   265: invokevirtual 358	android/graphics/Bitmap:recycle	()V
    //   268: aload 23
    //   270: areturn
    //   271: aload 11
    //   273: getfield 393	com/facebook/katana/util/ImageUtils$Dimension:b	I
    //   276: i2f
    //   277: fload 13
    //   279: fdiv
    //   280: fstore 14
    //   282: iload 5
    //   284: i2f
    //   285: fstore 15
    //   287: goto -203 -> 84
    //   290: aload_0
    //   291: invokestatic 404	com/facebook/katana/util/ImageUtils:b	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   294: astore 18
    //   296: goto -163 -> 133
    //   299: aload 11
    //   301: getfield 393	com/facebook/katana/util/ImageUtils$Dimension:b	I
    //   304: i2f
    //   305: fstore 26
    //   307: aload 11
    //   309: getfield 395	com/facebook/katana/util/ImageUtils$Dimension:a	I
    //   312: i2f
    //   313: fstore 27
    //   315: aload_0
    //   316: invokestatic 404	com/facebook/katana/util/ImageUtils:b	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   319: astore 28
    //   321: aload 28
    //   323: astore 10
    //   325: fload 27
    //   327: fstore 19
    //   329: fload 26
    //   331: fstore 20
    //   333: goto -188 -> 145
    //   336: aload 24
    //   338: aload 10
    //   340: new 348	android/graphics/Rect
    //   343: dup
    //   344: iconst_0
    //   345: iconst_0
    //   346: aload 10
    //   348: invokevirtual 286	android/graphics/Bitmap:getWidth	()I
    //   351: aload 10
    //   353: invokevirtual 289	android/graphics/Bitmap:getHeight	()I
    //   356: invokespecial 351	android/graphics/Rect:<init>	(IIII)V
    //   359: new 348	android/graphics/Rect
    //   362: dup
    //   363: iconst_3
    //   364: iconst_3
    //   365: iconst_1
    //   366: fload 20
    //   368: f2i
    //   369: iadd
    //   370: fload 19
    //   372: f2i
    //   373: invokespecial 351	android/graphics/Rect:<init>	(IIII)V
    //   376: getstatic 25	com/facebook/katana/util/ImageUtils:c	Landroid/graphics/Paint;
    //   379: invokevirtual 355	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   382: aload 24
    //   384: fconst_0
    //   385: fconst_0
    //   386: ldc 110
    //   388: fload 20
    //   390: fadd
    //   391: fconst_1
    //   392: fsub
    //   393: ldc 110
    //   395: fload 19
    //   397: fadd
    //   398: fconst_1
    //   399: fsub
    //   400: getstatic 86	com/facebook/katana/util/ImageUtils:e	Landroid/graphics/Paint;
    //   403: invokevirtual 415	android/graphics/Canvas:drawRect	(FFFFLandroid/graphics/Paint;)V
    //   406: getstatic 106	com/facebook/katana/util/ImageUtils:f	Landroid/graphics/Paint;
    //   409: astore 25
    //   411: aload 24
    //   413: fconst_2
    //   414: fconst_2
    //   415: fload 20
    //   417: fload 19
    //   419: aload 25
    //   421: invokevirtual 415	android/graphics/Canvas:drawRect	(FFFFLandroid/graphics/Paint;)V
    //   424: goto -166 -> 258
    //   427: astore 6
    //   429: aload 23
    //   431: astore 7
    //   433: aload 10
    //   435: astore 8
    //   437: aload 7
    //   439: ifnull +8 -> 447
    //   442: aload 7
    //   444: invokevirtual 358	android/graphics/Bitmap:recycle	()V
    //   447: new 251	com/facebook/katana/util/ImageUtils$ImageOutOfMemoryException
    //   450: dup
    //   451: aload 6
    //   453: invokespecial 254	com/facebook/katana/util/ImageUtils$ImageOutOfMemoryException:<init>	(Ljava/lang/OutOfMemoryError;)V
    //   456: athrow
    //   457: astore 9
    //   459: aload 8
    //   461: astore 10
    //   463: aload 10
    //   465: ifnull +8 -> 473
    //   468: aload 10
    //   470: invokevirtual 358	android/graphics/Bitmap:recycle	()V
    //   473: aload 9
    //   475: athrow
    //   476: aload 24
    //   478: aload 10
    //   480: new 348	android/graphics/Rect
    //   483: dup
    //   484: iconst_0
    //   485: iconst_0
    //   486: aload 10
    //   488: invokevirtual 286	android/graphics/Bitmap:getWidth	()I
    //   491: aload 10
    //   493: invokevirtual 289	android/graphics/Bitmap:getHeight	()I
    //   496: invokespecial 351	android/graphics/Rect:<init>	(IIII)V
    //   499: new 348	android/graphics/Rect
    //   502: dup
    //   503: iconst_3
    //   504: iconst_3
    //   505: iconst_1
    //   506: fload 20
    //   508: f2i
    //   509: iadd
    //   510: fload 19
    //   512: f2i
    //   513: invokespecial 351	android/graphics/Rect:<init>	(IIII)V
    //   516: getstatic 25	com/facebook/katana/util/ImageUtils:c	Landroid/graphics/Paint;
    //   519: invokevirtual 355	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   522: aload 24
    //   524: fconst_1
    //   525: fconst_0
    //   526: ldc 110
    //   528: fload 20
    //   530: fadd
    //   531: fconst_1
    //   532: fsub
    //   533: ldc 110
    //   535: fload 19
    //   537: fadd
    //   538: fconst_1
    //   539: fsub
    //   540: getstatic 109	com/facebook/katana/util/ImageUtils:g	Landroid/graphics/Paint;
    //   543: invokevirtual 415	android/graphics/Canvas:drawRect	(FFFFLandroid/graphics/Paint;)V
    //   546: goto -288 -> 258
    //   549: astore 9
    //   551: goto -88 -> 463
    //   554: astore 9
    //   556: aconst_null
    //   557: astore 10
    //   559: goto -96 -> 463
    //   562: astore 6
    //   564: aconst_null
    //   565: astore 7
    //   567: aconst_null
    //   568: astore 8
    //   570: goto -133 -> 437
    //   573: astore 6
    //   575: aload 10
    //   577: astore 8
    //   579: aconst_null
    //   580: astore 7
    //   582: goto -145 -> 437
    //
    // Exception table:
    //   from	to	target	type
    //   171	258	427	java/lang/OutOfMemoryError
    //   336	424	427	java/lang/OutOfMemoryError
    //   476	546	427	java/lang/OutOfMemoryError
    //   442	457	457	finally
    //   159	171	549	finally
    //   171	258	549	finally
    //   336	424	549	finally
    //   476	546	549	finally
    //   10	129	554	finally
    //   271	321	554	finally
    //   10	129	562	java/lang/OutOfMemoryError
    //   271	321	562	java/lang/OutOfMemoryError
    //   159	171	573	java/lang/OutOfMemoryError
  }

  public static Bitmap a(String paramString, BitmapFactory.Options paramOptions)
  {
    Bitmap localBitmap;
    try
    {
      localBitmap = BitmapFactory.decodeFile(paramString, paramOptions);
      if (localBitmap == null)
        throw new ImageUtils.ImageDecodeException();
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      throw new ImageUtils.ImageOutOfMemoryException(localOutOfMemoryError);
    }
    return localBitmap;
  }

  public static Bitmap a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    ImageUtils.Dimension localDimension = a(paramArrayOfByte);
    Bitmap localBitmap;
    if ((localDimension.b <= paramInt1) && (localDimension.a <= paramInt2))
      localBitmap = b(paramArrayOfByte);
    while (true)
    {
      return localBitmap;
      float f1 = localDimension.b / paramInt1;
      float f2 = localDimension.a / paramInt2;
      float f3;
      if (f1 > f2)
        f3 = paramInt1;
      while (true)
      {
        if (localDimension.b <= f3)
          break label119;
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inSampleSize = (localDimension.b / (int)f3);
        localBitmap = a(paramArrayOfByte, localOptions);
        break;
        f3 = localDimension.b / f2;
      }
      label119: localBitmap = b(paramArrayOfByte);
    }
  }

  public static Bitmap a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    ImageUtils.ImageSource localImageSource = new ImageUtils.ImageSource(paramArrayOfByte);
    try
    {
      Bitmap localBitmap = a(null, localImageSource, paramInt1, paramInt2, paramInt3, paramBoolean);
      return localBitmap;
    }
    catch (IOException localIOException)
    {
    }
    throw new IllegalStateException("should never happen with byte arrays");
  }

  public static Bitmap a(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    return a(paramArrayOfByte, paramInt, 960, 960, paramBoolean);
  }

  public static Bitmap a(byte[] paramArrayOfByte, BitmapFactory.Options paramOptions)
  {
    Bitmap localBitmap;
    try
    {
      localBitmap = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, paramOptions);
      if (localBitmap == null)
        throw new ImageUtils.ImageDecodeException();
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      throw new ImageUtils.ImageOutOfMemoryException(localOutOfMemoryError);
    }
    return localBitmap;
  }

  public static ImageUtils.Dimension a(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    return new ImageUtils.Dimension(localOptions.outWidth, localOptions.outHeight);
  }

  public static ImageUtils.Dimension a(byte[] paramArrayOfByte)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length, localOptions);
    return new ImageUtils.Dimension(localOptions.outWidth, localOptions.outHeight);
  }

  // ERROR //
  public static void a(Bitmap paramBitmap, Bitmap.CompressFormat paramCompressFormat, int paramInt, File paramFile)
  {
    // Byte code:
    //   0: new 459	java/io/FileOutputStream
    //   3: dup
    //   4: aload_3
    //   5: invokespecial 462	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   8: astore 4
    //   10: aload_0
    //   11: aload_1
    //   12: iload_2
    //   13: aload 4
    //   15: invokevirtual 466	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   18: ifne +81 -> 99
    //   21: new 191	java/io/IOException
    //   24: dup
    //   25: new 468	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 469	java/lang/StringBuilder:<init>	()V
    //   32: ldc_w 471
    //   35: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_3
    //   39: invokevirtual 478	java/io/File:getPath	()Ljava/lang/String;
    //   42: invokevirtual 475	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 479	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokespecial 480	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   51: athrow
    //   52: astore 8
    //   54: new 203	com/facebook/katana/util/ImageUtils$ImageIOException
    //   57: dup
    //   58: aload_3
    //   59: invokevirtual 478	java/io/File:getPath	()Ljava/lang/String;
    //   62: aload 8
    //   64: invokespecial 209	com/facebook/katana/util/ImageUtils$ImageIOException:<init>	(Ljava/lang/String;Ljava/io/IOException;)V
    //   67: athrow
    //   68: astore 5
    //   70: aload 4
    //   72: ifnull +8 -> 80
    //   75: aload 4
    //   77: invokevirtual 483	java/io/FileOutputStream:close	()V
    //   80: aload_3
    //   81: ifnull +15 -> 96
    //   84: aload_3
    //   85: invokevirtual 486	java/io/File:exists	()Z
    //   88: ifeq +8 -> 96
    //   91: aload_3
    //   92: invokevirtual 489	java/io/File:delete	()Z
    //   95: pop
    //   96: aload 5
    //   98: athrow
    //   99: aload 4
    //   101: invokevirtual 483	java/io/FileOutputStream:close	()V
    //   104: iconst_0
    //   105: ifeq +7 -> 112
    //   108: aconst_null
    //   109: invokevirtual 483	java/io/FileOutputStream:close	()V
    //   112: iconst_0
    //   113: ifeq +15 -> 128
    //   116: aconst_null
    //   117: invokevirtual 486	java/io/File:exists	()Z
    //   120: ifeq +8 -> 128
    //   123: aconst_null
    //   124: invokevirtual 489	java/io/File:delete	()Z
    //   127: pop
    //   128: return
    //   129: astore 10
    //   131: goto -19 -> 112
    //   134: astore 7
    //   136: goto -56 -> 80
    //   139: astore 5
    //   141: aconst_null
    //   142: astore 4
    //   144: goto -74 -> 70
    //   147: astore 8
    //   149: aconst_null
    //   150: astore 4
    //   152: goto -98 -> 54
    //
    // Exception table:
    //   from	to	target	type
    //   10	52	52	java/io/IOException
    //   10	52	68	finally
    //   54	68	68	finally
    //   108	112	129	java/io/IOException
    //   75	80	134	java/io/IOException
    //   0	10	139	finally
    //   99	104	139	finally
    //   0	10	147	java/io/IOException
    //   99	104	147	java/io/IOException
  }

  public static void a(File paramFile1, File paramFile2, int paramInt1, int paramInt2)
  {
    while (true)
    {
      int k;
      try
      {
        ExifInterface localExifInterface1 = new ExifInterface(paramFile1.getAbsolutePath());
        ExifInterface localExifInterface2 = new ExifInterface(paramFile2.getAbsolutePath());
        int i = Build.VERSION.SDK_INT;
        Iterator localIterator = d.keySet().iterator();
        if (!localIterator.hasNext())
          continue;
        Integer localInteger = (Integer)localIterator.next();
        if (i < localInteger.intValue())
          continue;
        String[] arrayOfString = (String[])d.get(localInteger);
        int j = arrayOfString.length;
        k = 0;
        if (k >= j)
          continue;
        String str1 = arrayOfString[k];
        String str2 = localExifInterface1.getAttribute(str1);
        if (str2 != null)
        {
          localExifInterface2.setAttribute(str1, str2);
          break label219;
          localExifInterface2.setAttribute("Width", Integer.toString(paramInt1));
          localExifInterface2.setAttribute("Length", Integer.toString(paramInt2));
          localExifInterface2.saveAttributes();
          return;
        }
      }
      catch (IOException localIOException)
      {
        throw new ImageUtils.ImageIOException("copyExif from " + paramFile1.getPath() + " to " + paramFile2.getPath(), localIOException);
      }
      label219: k++;
    }
  }

  public static void a(byte[] paramArrayOfByte, String paramString)
  {
    FileOutputStream localFileOutputStream = new FileOutputStream(paramString);
    localFileOutputStream.write(paramArrayOfByte);
    localFileOutputStream.close();
  }

  public static boolean a(Context paramContext, File paramFile1, File paramFile2, int paramInt1, int paramInt2)
  {
    return a(paramContext, paramFile1, paramFile2, paramInt1, paramInt1, paramInt2, true, null);
  }

  public static boolean a(Context paramContext, File paramFile1, File paramFile2, int paramInt1, int paramInt2, int paramInt3)
  {
    return a(paramContext, paramFile1, paramFile2, paramInt1, paramInt2, paramInt3, false, null);
  }

  // ERROR //
  private static boolean a(Context paramContext, File paramFile1, File paramFile2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, PhotoItem paramPhotoItem)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aload 7
    //   5: ifnull +91 -> 96
    //   8: aload 7
    //   10: invokevirtual 564	com/facebook/katana/model/PhotoItem:i	()Z
    //   13: ifeq +83 -> 96
    //   16: aload 7
    //   18: iload_3
    //   19: iload 4
    //   21: invokestatic 569	com/facebook/katana/activity/media/crop/CroppedImageGenerator:a	(Lcom/facebook/katana/model/PhotoItem;II)Landroid/graphics/Bitmap;
    //   24: astore 15
    //   26: aload 15
    //   28: astore 12
    //   30: aload 12
    //   32: ifnull +147 -> 179
    //   35: aload 12
    //   37: getstatic 575	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   40: iload 5
    //   42: aload_2
    //   43: invokestatic 577	com/facebook/katana/util/ImageUtils:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap$CompressFormat;ILjava/io/File;)V
    //   46: aload_1
    //   47: aload_2
    //   48: aload 12
    //   50: invokevirtual 286	android/graphics/Bitmap:getWidth	()I
    //   53: aload 12
    //   55: invokevirtual 289	android/graphics/Bitmap:getHeight	()I
    //   58: invokestatic 579	com/facebook/katana/util/ImageUtils:a	(Ljava/io/File;Ljava/io/File;II)V
    //   61: iconst_1
    //   62: istore 13
    //   64: aload 12
    //   66: ifnull +8 -> 74
    //   69: aload 12
    //   71: invokevirtual 358	android/graphics/Bitmap:recycle	()V
    //   74: aload 8
    //   76: ifnull +17 -> 93
    //   79: aload 8
    //   81: invokevirtual 486	java/io/File:exists	()Z
    //   84: ifeq +9 -> 93
    //   87: aload 8
    //   89: invokevirtual 489	java/io/File:delete	()Z
    //   92: pop
    //   93: iload 13
    //   95: ireturn
    //   96: iload 6
    //   98: ifne +90 -> 188
    //   101: aload_0
    //   102: aload_1
    //   103: invokestatic 281	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   106: iload_3
    //   107: iload 4
    //   109: iconst_0
    //   110: invokestatic 232	com/facebook/katana/util/ImageUtils:a	(Landroid/content/Context;Landroid/net/Uri;IIZ)Landroid/graphics/Bitmap;
    //   113: astore 12
    //   115: goto -85 -> 30
    //   118: aload_0
    //   119: aload_1
    //   120: iload_3
    //   121: invokestatic 581	com/facebook/katana/util/ImageUtils:a	(Landroid/content/Context;Ljava/io/File;I)Landroid/graphics/Bitmap;
    //   124: astore 11
    //   126: aload 11
    //   128: astore 12
    //   130: goto -100 -> 30
    //   133: iload 4
    //   135: istore_3
    //   136: goto -18 -> 118
    //   139: astore 9
    //   141: aload 8
    //   143: ifnull +8 -> 151
    //   146: aload 8
    //   148: invokevirtual 358	android/graphics/Bitmap:recycle	()V
    //   151: aload_2
    //   152: ifnull +15 -> 167
    //   155: aload_2
    //   156: invokevirtual 486	java/io/File:exists	()Z
    //   159: ifeq +8 -> 167
    //   162: aload_2
    //   163: invokevirtual 489	java/io/File:delete	()Z
    //   166: pop
    //   167: aload 9
    //   169: athrow
    //   170: astore 9
    //   172: aload 12
    //   174: astore 8
    //   176: goto -35 -> 141
    //   179: aload_2
    //   180: astore 8
    //   182: iconst_0
    //   183: istore 13
    //   185: goto -121 -> 64
    //   188: iload_3
    //   189: iload 4
    //   191: if_icmple -58 -> 133
    //   194: goto -76 -> 118
    //
    // Exception table:
    //   from	to	target	type
    //   8	26	139	finally
    //   101	126	139	finally
    //   35	61	170	finally
  }

  public static boolean a(Context paramContext, File paramFile1, File paramFile2, PhotoItem paramPhotoItem, int paramInt1, int paramInt2, int paramInt3)
  {
    return a(paramContext, paramFile1, paramFile2, paramInt1, paramInt2, paramInt3, false, paramPhotoItem);
  }

  public static byte[] a(Bitmap paramBitmap, Bitmap.CompressFormat paramCompressFormat, int paramInt)
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(4 * (paramBitmap.getWidth() * paramBitmap.getHeight()));
      paramBitmap.compress(paramCompressFormat, 100, localByteArrayOutputStream);
      byte[] arrayOfByte = localByteArrayOutputStream.toByteArray();
      return arrayOfByte;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
    }
    throw new ImageUtils.ImageOutOfMemoryException(localOutOfMemoryError);
  }

  public static byte[] a(InputStream paramInputStream)
  {
    try
    {
      byte[] arrayOfByte1 = new byte[4096];
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      for (int i = paramInputStream.read(arrayOfByte1); i != -1; i = paramInputStream.read(arrayOfByte1))
        localByteArrayOutputStream.write(arrayOfByte1, 0, i);
      byte[] arrayOfByte2 = localByteArrayOutputStream.toByteArray();
      return arrayOfByte2;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
    }
    throw new ImageUtils.ImageOutOfMemoryException(localOutOfMemoryError);
  }

  public static Bitmap b(Resources paramResources, int paramInt)
  {
    try
    {
      Bitmap localBitmap = a(paramResources, paramInt);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
    }
    throw new ImageUtils.ImageOutOfMemoryException(localOutOfMemoryError);
  }

  public static Bitmap b(Bitmap paramBitmap, int paramInt)
  {
    Bitmap localBitmap = null;
    try
    {
      localBitmap = Bitmap.createBitmap(paramInt, paramInt, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      int k;
      int j;
      if (paramBitmap.getWidth() > paramBitmap.getHeight())
      {
        k = paramInt * paramBitmap.getHeight() / paramBitmap.getWidth();
        j = paramInt;
      }
      while (true)
      {
        localCanvas.drawBitmap(paramBitmap, new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight()), new Rect((paramInt - j) / 2, (paramInt - k) / 2, (j + paramInt) / 2, (k + paramInt) / 2), c);
        return localBitmap;
        int i = paramInt * paramBitmap.getWidth() / paramBitmap.getHeight();
        j = i;
        k = paramInt;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (localBitmap != null)
        localBitmap.recycle();
    }
    throw new ImageUtils.ImageOutOfMemoryException(localOutOfMemoryError);
  }

  public static Bitmap b(String paramString)
  {
    return a(paramString, null);
  }

  public static Bitmap b(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, null);
  }

  private static int c(String paramString)
  {
    int i = -1;
    try
    {
      ExifInterface localExifInterface = new ExifInterface(paramString);
      switch (localExifInterface.getAttributeInt("Orientation", 1))
      {
      case 2:
      case 4:
      case 5:
      case 7:
      default:
      case 1:
      case 6:
      case 3:
      case 8:
      }
      while (true)
      {
        label64: return i;
        i = 0;
        continue;
        i = 90;
        continue;
        i = 180;
        continue;
        i = 270;
      }
    }
    catch (IOException localIOException)
    {
      break label64;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.ImageUtils
 * JD-Core Version:    0.6.0
 */