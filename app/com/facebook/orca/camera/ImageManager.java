package com.facebook.orca.camera;

import android.content.ContentResolver;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Images.Thumbnails;
import com.facebook.orca.camera.gallery.BaseImageList;
import com.facebook.orca.camera.gallery.IImageList;
import com.facebook.orca.camera.gallery.ImageList;
import com.facebook.orca.camera.gallery.ImageListUber;
import com.facebook.orca.camera.gallery.SingleImageList;
import com.facebook.orca.debug.BLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ImageManager
{
  public static final String a;
  public static final String b;
  private static final Class<?> c = ImageManager.class;
  private static final Uri d = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
  private static final Uri e = MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI;
  private static final Uri f = Uri.parse("content://media/external/video/media");

  static
  {
    a = Environment.getExternalStorageDirectory().toString() + "/DCIM/Camera";
    b = a(a);
  }

  // ERROR //
  public static Uri a(ContentResolver paramContentResolver, String paramString1, long paramLong, android.location.Location paramLocation, String paramString2, String paramString3, android.graphics.Bitmap paramBitmap, byte[] paramArrayOfByte, int[] paramArrayOfInt)
  {
    // Byte code:
    //   0: new 42	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   7: aload 5
    //   9: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12: ldc 79
    //   14: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload 6
    //   19: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: astore 10
    //   27: new 53	java/io/File
    //   30: dup
    //   31: aload 5
    //   33: invokespecial 82	java/io/File:<init>	(Ljava/lang/String;)V
    //   36: astore 11
    //   38: aload 11
    //   40: invokevirtual 86	java/io/File:exists	()Z
    //   43: ifne +9 -> 52
    //   46: aload 11
    //   48: invokevirtual 89	java/io/File:mkdirs	()Z
    //   51: pop
    //   52: new 91	java/io/FileOutputStream
    //   55: dup
    //   56: new 53	java/io/File
    //   59: dup
    //   60: aload 5
    //   62: aload 6
    //   64: invokespecial 94	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: invokespecial 97	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   70: astore 13
    //   72: aload 7
    //   74: ifnull +146 -> 220
    //   77: aload 7
    //   79: getstatic 103	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   82: bipush 75
    //   84: aload 13
    //   86: invokevirtual 109	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   89: pop
    //   90: aload 9
    //   92: iconst_0
    //   93: iconst_0
    //   94: iastore
    //   95: aload 13
    //   97: invokestatic 114	com/facebook/orca/camera/Util:a	(Ljava/io/Closeable;)V
    //   100: new 116	android/content/ContentValues
    //   103: dup
    //   104: bipush 7
    //   106: invokespecial 119	android/content/ContentValues:<init>	(I)V
    //   109: astore 18
    //   111: aload 18
    //   113: ldc 121
    //   115: aload_1
    //   116: invokevirtual 124	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: aload 18
    //   121: ldc 126
    //   123: aload 6
    //   125: invokevirtual 124	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   128: aload 18
    //   130: ldc 128
    //   132: lload_2
    //   133: invokestatic 134	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   136: invokevirtual 137	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   139: aload 18
    //   141: ldc 139
    //   143: ldc 141
    //   145: invokevirtual 124	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: aload 18
    //   150: ldc 143
    //   152: aload 9
    //   154: iconst_0
    //   155: iaload
    //   156: invokestatic 148	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   159: invokevirtual 151	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   162: aload 18
    //   164: ldc 153
    //   166: aload 10
    //   168: invokevirtual 124	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   171: aload 4
    //   173: ifnull +33 -> 206
    //   176: aload 18
    //   178: ldc 155
    //   180: aload 4
    //   182: invokevirtual 161	android/location/Location:getLatitude	()D
    //   185: invokestatic 166	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   188: invokevirtual 169	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Double;)V
    //   191: aload 18
    //   193: ldc 171
    //   195: aload 4
    //   197: invokevirtual 174	android/location/Location:getLongitude	()D
    //   200: invokestatic 166	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   203: invokevirtual 169	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Double;)V
    //   206: aload_0
    //   207: getstatic 25	com/facebook/orca/camera/ImageManager:d	Landroid/net/Uri;
    //   210: aload 18
    //   212: invokevirtual 180	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   215: astore 15
    //   217: aload 15
    //   219: areturn
    //   220: aload 13
    //   222: aload 8
    //   224: invokevirtual 186	java/io/OutputStream:write	([B)V
    //   227: aload 9
    //   229: iconst_0
    //   230: aload 10
    //   232: invokestatic 189	com/facebook/orca/camera/ImageManager:b	(Ljava/lang/String;)I
    //   235: iastore
    //   236: goto -141 -> 95
    //   239: astore 12
    //   241: getstatic 18	com/facebook/orca/camera/ImageManager:c	Ljava/lang/Class;
    //   244: aload 12
    //   246: invokestatic 194	com/facebook/orca/debug/BLog:a	(Ljava/lang/Class;Ljava/lang/Throwable;)V
    //   249: aload 13
    //   251: invokestatic 114	com/facebook/orca/camera/Util:a	(Ljava/io/Closeable;)V
    //   254: aconst_null
    //   255: astore 15
    //   257: goto -40 -> 217
    //   260: astore 17
    //   262: aconst_null
    //   263: astore 13
    //   265: getstatic 18	com/facebook/orca/camera/ImageManager:c	Ljava/lang/Class;
    //   268: aload 17
    //   270: invokestatic 194	com/facebook/orca/debug/BLog:a	(Ljava/lang/Class;Ljava/lang/Throwable;)V
    //   273: aload 13
    //   275: invokestatic 114	com/facebook/orca/camera/Util:a	(Ljava/io/Closeable;)V
    //   278: aconst_null
    //   279: astore 15
    //   281: goto -64 -> 217
    //   284: astore 16
    //   286: aconst_null
    //   287: astore 13
    //   289: aload 16
    //   291: astore 14
    //   293: aload 13
    //   295: invokestatic 114	com/facebook/orca/camera/Util:a	(Ljava/io/Closeable;)V
    //   298: aload 14
    //   300: athrow
    //   301: astore 14
    //   303: goto -10 -> 293
    //   306: astore 17
    //   308: goto -43 -> 265
    //   311: astore 12
    //   313: aconst_null
    //   314: astore 13
    //   316: goto -75 -> 241
    //
    // Exception table:
    //   from	to	target	type
    //   77	95	239	java/io/FileNotFoundException
    //   220	236	239	java/io/FileNotFoundException
    //   27	72	260	java/io/IOException
    //   27	72	284	finally
    //   77	95	301	finally
    //   220	236	301	finally
    //   241	249	301	finally
    //   265	273	301	finally
    //   77	95	306	java/io/IOException
    //   220	236	306	java/io/IOException
    //   27	72	311	java/io/FileNotFoundException
  }

  public static ImageManager.ImageListParam a(Uri paramUri)
  {
    ImageManager.ImageListParam localImageListParam = new ImageManager.ImageListParam();
    localImageListParam.e = paramUri;
    return localImageListParam;
  }

  public static ImageManager.ImageListParam a(ImageManager.DataLocation paramDataLocation, int paramInt1, int paramInt2, String paramString)
  {
    ImageManager.ImageListParam localImageListParam = new ImageManager.ImageListParam();
    localImageListParam.a = paramDataLocation;
    localImageListParam.b = paramInt1;
    localImageListParam.c = paramInt2;
    localImageListParam.d = paramString;
    return localImageListParam;
  }

  public static IImageList a(ContentResolver paramContentResolver, Uri paramUri)
  {
    return a(paramContentResolver, a(paramUri));
  }

  public static IImageList a(ContentResolver paramContentResolver, Uri paramUri, int paramInt)
  {
    String str1;
    IImageList localIImageList;
    if (paramUri != null)
    {
      str1 = paramUri.toString();
      if (!str1.startsWith("content://drm"))
        break label39;
      localIImageList = a(paramContentResolver, ImageManager.DataLocation.ALL, 2, paramInt, null);
    }
    while (true)
    {
      return localIImageList;
      str1 = "";
      break;
      label39: if (str1.startsWith("content://media/external/video"))
      {
        localIImageList = a(paramContentResolver, ImageManager.DataLocation.EXTERNAL, 4, paramInt, null);
        continue;
      }
      if (c(str1))
      {
        localIImageList = a(paramContentResolver, paramUri);
        continue;
      }
      String str2 = paramUri.getQueryParameter("bucketId");
      localIImageList = a(paramContentResolver, ImageManager.DataLocation.ALL, 1, paramInt, str2);
    }
  }

  public static IImageList a(ContentResolver paramContentResolver, ImageManager.DataLocation paramDataLocation, int paramInt1, int paramInt2, String paramString)
  {
    return a(paramContentResolver, a(paramDataLocation, paramInt1, paramInt2, paramString));
  }

  public static IImageList a(ContentResolver paramContentResolver, ImageManager.ImageListParam paramImageListParam)
  {
    ImageManager.DataLocation localDataLocation = paramImageListParam.a;
    int i = paramImageListParam.b;
    int j = paramImageListParam.c;
    String str = paramImageListParam.d;
    Uri localUri = paramImageListParam.e;
    Object localObject;
    if ((paramImageListParam.f) || (paramContentResolver == null))
      localObject = new ImageManager.EmptyImageList(null);
    while (true)
    {
      return localObject;
      if (localUri != null)
      {
        localObject = new SingleImageList(paramContentResolver, localUri);
        continue;
      }
      boolean bool = a(false);
      ArrayList localArrayList = new ArrayList();
      if ((bool) && (localDataLocation != ImageManager.DataLocation.INTERNAL) && ((i & 0x1) != 0))
        localArrayList.add(new ImageList(paramContentResolver, d, e, j, str));
      if (((localDataLocation == ImageManager.DataLocation.INTERNAL) || (localDataLocation == ImageManager.DataLocation.ALL)) && ((i & 0x1) != 0))
        localArrayList.add(new ImageList(paramContentResolver, MediaStore.Images.Media.INTERNAL_CONTENT_URI, MediaStore.Images.Thumbnails.INTERNAL_CONTENT_URI, j, str));
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        BaseImageList localBaseImageList = (BaseImageList)localIterator.next();
        if (!localBaseImageList.c())
          continue;
        localBaseImageList.a();
        localIterator.remove();
      }
      if (localArrayList.size() == 1)
      {
        localObject = (BaseImageList)localArrayList.get(0);
        continue;
      }
      localObject = new ImageListUber((IImageList[])localArrayList.toArray(new IImageList[localArrayList.size()]), j);
    }
  }

  public static String a(String paramString)
  {
    return String.valueOf(paramString.toLowerCase().hashCode());
  }

  public static boolean a()
  {
    return a(true);
  }

  public static boolean a(boolean paramBoolean)
  {
    boolean bool = true;
    String str = Environment.getExternalStorageState();
    if ("mounted".equals(str))
      if (!paramBoolean);
    for (bool = b(); ; bool = false)
      do
        return bool;
      while ((!paramBoolean) && ("mounted_ro".equals(str)));
  }

  public static int b(String paramString)
  {
    try
    {
      localExifInterface = new ExifInterface(paramString);
      i = 0;
      int j;
      if (localExifInterface != null)
      {
        j = localExifInterface.getAttributeInt("Orientation", -1);
        i = 0;
        if (j != -1)
          i = 0;
      }
      switch (j)
      {
      case 4:
      case 5:
      case 7:
      default:
        return i;
      case 6:
      case 3:
      case 8:
      }
    }
    catch (IOException localIOException)
    {
      while (true)
      {
        BLog.e(c, "cannot read exif", localIOException);
        ExifInterface localExifInterface = null;
        continue;
        int i = 90;
        continue;
        i = 180;
        continue;
        i = 270;
      }
    }
  }

  private static boolean b()
  {
    String str = Environment.getExternalStorageDirectory().toString() + "/DCIM";
    File localFile1 = new File(str);
    int i;
    if (!localFile1.isDirectory())
    {
      boolean bool2 = localFile1.mkdirs();
      i = 0;
      if (bool2);
    }
    while (true)
    {
      return i;
      File localFile2 = new File(str, ".probe");
      try
      {
        if (localFile2.exists())
          localFile2.delete();
        boolean bool1 = localFile2.createNewFile();
        i = 0;
        if (!bool1)
          continue;
        localFile2.delete();
        i = 1;
      }
      catch (IOException localIOException)
      {
        i = 0;
      }
    }
  }

  static boolean c(String paramString)
  {
    if ((!paramString.startsWith(MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString())) && (!paramString.startsWith(MediaStore.Images.Media.INTERNAL_CONTENT_URI.toString())));
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.camera.ImageManager
 * JD-Core Version:    0.6.0
 */