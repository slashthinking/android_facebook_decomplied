package com.facebook.orca.images;

import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.debug.Tracer;
import com.facebook.orca.media.MediaDownloader.DownloadResult;
import com.facebook.orca.media.MediaDownloader.DownloadResultCode;
import javax.inject.Provider;

class FetchImageHelper
{
  private static Class<?> a = FetchImageHelper.class;
  private final ImageCache b;
  private final ImageMediaDownloader c;
  private final AnalyticsLogger d;
  private final Provider<String> e;

  public FetchImageHelper(ImageCache paramImageCache, ImageMediaDownloader paramImageMediaDownloader, AnalyticsLogger paramAnalyticsLogger, Provider<String> paramProvider)
  {
    this.b = paramImageCache;
    this.c = paramImageMediaDownloader;
    this.d = paramAnalyticsLogger;
    this.e = paramProvider;
  }

  private Bitmap a(FetchImageParams paramFetchImageParams, boolean paramBoolean)
  {
    Tracer localTracer1 = Tracer.a("fetchImage");
    try
    {
      ImageCacheKey localImageCacheKey1 = paramFetchImageParams.d();
      Bitmap localBitmap = (Bitmap)this.b.e(localImageCacheKey1);
      if (localBitmap != null);
      while (true)
      {
        return localBitmap;
        ImageCacheKey localImageCacheKey2 = paramFetchImageParams.e();
        localBitmap = (Bitmap)this.b.e(localImageCacheKey2);
        if (localBitmap == null)
        {
          if (paramBoolean)
          {
            localTracer1.a();
            localBitmap = null;
          }
          else
          {
            localBitmap = c(paramFetchImageParams);
          }
        }
        else
        {
          if (localBitmap != null)
          {
            UrlImageProcessor localUrlImageProcessor = paramFetchImageParams.b();
            if (localUrlImageProcessor != null)
            {
              Tracer localTracer2 = Tracer.a("Running processor");
              BLog.a(a, "Processing image");
              localBitmap = localUrlImageProcessor.a(localBitmap);
              localTracer2.a();
              String str = localUrlImageProcessor.a();
              if ((str != null) && (str != UrlImageProcessor.a))
              {
                Tracer localTracer3 = Tracer.a("Inserting processed image into cache");
                this.b.a(localImageCacheKey1, localBitmap);
                localTracer3.a();
              }
            }
          }
          localTracer1.a();
        }
      }
    }
    finally
    {
      localTracer1.a();
    }
  }

  private void a(FetchImageParams paramFetchImageParams, MediaDownloader.DownloadResult paramDownloadResult)
  {
    if ((this.e.b() == null) || (!paramFetchImageParams.a().toString().startsWith("http://maps.google.com/maps/api/staticmap")));
    while (true)
    {
      return;
      HoneyClientEvent localHoneyClientEvent = new HoneyClientEvent("counters").e("google_static_maps").f((String)this.e.b()).b("result", paramDownloadResult.a().toString());
      this.d.a(localHoneyClientEvent);
    }
  }

  // ERROR //
  private Bitmap c(FetchImageParams paramFetchImageParams)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_1
    //   3: invokevirtual 57	com/facebook/orca/images/FetchImageParams:e	()Lcom/facebook/orca/images/ImageCacheKey;
    //   6: astore_3
    //   7: aload_0
    //   8: getfield 26	com/facebook/orca/images/FetchImageHelper:b	Lcom/facebook/orca/images/ImageCache;
    //   11: aload_3
    //   12: invokevirtual 148	com/facebook/orca/images/ImageCache:f	(Lcom/facebook/orca/media/MediaCacheKey;)Z
    //   15: ifeq +9 -> 24
    //   18: aconst_null
    //   19: astore 20
    //   21: aload 20
    //   23: areturn
    //   24: ldc 150
    //   26: invokestatic 40	com/facebook/orca/debug/Tracer:a	(Ljava/lang/String;)Lcom/facebook/orca/debug/Tracer;
    //   29: astore 6
    //   31: aload_1
    //   32: invokevirtual 97	com/facebook/orca/images/FetchImageParams:a	()Landroid/net/Uri;
    //   35: astore 10
    //   37: aload_0
    //   38: getfield 28	com/facebook/orca/images/FetchImageHelper:c	Lcom/facebook/orca/images/ImageMediaDownloader;
    //   41: aload 10
    //   43: invokevirtual 155	com/facebook/orca/images/ImageMediaDownloader:a	(Landroid/net/Uri;)Lcom/facebook/orca/media/MediaDownloader$DownloadResult;
    //   46: astore 11
    //   48: aload 11
    //   50: astore 5
    //   52: aload 5
    //   54: invokevirtual 132	com/facebook/orca/media/MediaDownloader$DownloadResult:a	()Lcom/facebook/orca/media/MediaDownloader$DownloadResultCode;
    //   57: getstatic 159	com/facebook/orca/media/MediaDownloader$DownloadResultCode:UNSUPPORTED_URI	Lcom/facebook/orca/media/MediaDownloader$DownloadResultCode;
    //   60: if_acmpne +42 -> 102
    //   63: getstatic 20	com/facebook/orca/images/FetchImageHelper:a	Ljava/lang/Class;
    //   66: ldc 161
    //   68: iconst_1
    //   69: anewarray 4	java/lang/Object
    //   72: dup
    //   73: iconst_0
    //   74: aload 10
    //   76: aastore
    //   77: invokestatic 164	com/facebook/orca/debug/BLog:e	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)V
    //   80: aload 6
    //   82: invokevirtual 55	com/facebook/orca/debug/Tracer:a	()J
    //   85: pop2
    //   86: aload 5
    //   88: ifnull +8 -> 96
    //   91: aload 5
    //   93: invokevirtual 166	com/facebook/orca/media/MediaDownloader$DownloadResult:c	()V
    //   96: aconst_null
    //   97: astore 20
    //   99: goto -78 -> 21
    //   102: aload 6
    //   104: invokevirtual 55	com/facebook/orca/debug/Tracer:a	()J
    //   107: pop2
    //   108: aload_0
    //   109: aload_1
    //   110: aload 5
    //   112: invokespecial 168	com/facebook/orca/images/FetchImageHelper:a	(Lcom/facebook/orca/images/FetchImageParams;Lcom/facebook/orca/media/MediaDownloader$DownloadResult;)V
    //   115: ldc 170
    //   117: invokestatic 40	com/facebook/orca/debug/Tracer:a	(Ljava/lang/String;)Lcom/facebook/orca/debug/Tracer;
    //   120: astore 14
    //   122: getstatic 175	com/facebook/orca/images/FetchImageHelper$1:a	[I
    //   125: aload 5
    //   127: invokevirtual 132	com/facebook/orca/media/MediaDownloader$DownloadResult:a	()Lcom/facebook/orca/media/MediaDownloader$DownloadResultCode;
    //   130: invokevirtual 179	com/facebook/orca/media/MediaDownloader$DownloadResultCode:ordinal	()I
    //   133: iaload
    //   134: tableswitch	default:+26 -> 160, 1:+88->222, 2:+168->302, 3:+201->335
    //   161: getfield 26	com/facebook/orca/images/FetchImageHelper:b	Lcom/facebook/orca/images/ImageCache;
    //   164: aload_3
    //   165: ldc2_w 180
    //   168: invokevirtual 184	com/facebook/orca/images/ImageCache:a	(Lcom/facebook/orca/media/MediaCacheKey;J)V
    //   171: aload 14
    //   173: invokevirtual 55	com/facebook/orca/debug/Tracer:a	()J
    //   176: pop2
    //   177: aload 5
    //   179: ifnull +8 -> 187
    //   182: aload 5
    //   184: invokevirtual 166	com/facebook/orca/media/MediaDownloader$DownloadResult:c	()V
    //   187: aconst_null
    //   188: astore 20
    //   190: goto -169 -> 21
    //   193: astore 7
    //   195: aload 6
    //   197: invokevirtual 55	com/facebook/orca/debug/Tracer:a	()J
    //   200: pop2
    //   201: aload 7
    //   203: athrow
    //   204: astore 4
    //   206: aload_2
    //   207: astore 5
    //   209: aload 5
    //   211: ifnull +8 -> 219
    //   214: aload 5
    //   216: invokevirtual 166	com/facebook/orca/media/MediaDownloader$DownloadResult:c	()V
    //   219: aload 4
    //   221: athrow
    //   222: aload_0
    //   223: getfield 26	com/facebook/orca/images/FetchImageHelper:b	Lcom/facebook/orca/images/ImageCache;
    //   226: aload_3
    //   227: aload 5
    //   229: invokevirtual 187	com/facebook/orca/media/MediaDownloader$DownloadResult:b	()Ljava/io/InputStream;
    //   232: invokevirtual 190	com/facebook/orca/images/ImageCache:a	(Lcom/facebook/orca/media/MediaCacheKey;Ljava/io/InputStream;)Ljava/io/File;
    //   235: pop
    //   236: aload_0
    //   237: getfield 26	com/facebook/orca/images/FetchImageHelper:b	Lcom/facebook/orca/images/ImageCache;
    //   240: aload_3
    //   241: invokevirtual 50	com/facebook/orca/images/ImageCache:e	(Lcom/facebook/orca/media/MediaCacheKey;)Ljava/lang/Object;
    //   244: checkcast 52	android/graphics/Bitmap
    //   247: astore 20
    //   249: aload 14
    //   251: invokevirtual 55	com/facebook/orca/debug/Tracer:a	()J
    //   254: pop2
    //   255: aload 5
    //   257: ifnull -236 -> 21
    //   260: aload 5
    //   262: invokevirtual 166	com/facebook/orca/media/MediaDownloader$DownloadResult:c	()V
    //   265: goto -244 -> 21
    //   268: astore 23
    //   270: getstatic 20	com/facebook/orca/images/FetchImageHelper:a	Ljava/lang/Class;
    //   273: ldc 192
    //   275: aload 23
    //   277: invokestatic 195	com/facebook/orca/debug/BLog:d	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   280: aload 14
    //   282: invokevirtual 55	com/facebook/orca/debug/Tracer:a	()J
    //   285: pop2
    //   286: aload 5
    //   288: ifnull +8 -> 296
    //   291: aload 5
    //   293: invokevirtual 166	com/facebook/orca/media/MediaDownloader$DownloadResult:c	()V
    //   296: aconst_null
    //   297: astore 20
    //   299: goto -278 -> 21
    //   302: aload_0
    //   303: getfield 26	com/facebook/orca/images/FetchImageHelper:b	Lcom/facebook/orca/images/ImageCache;
    //   306: aload_3
    //   307: ldc2_w 196
    //   310: invokevirtual 184	com/facebook/orca/images/ImageCache:a	(Lcom/facebook/orca/media/MediaCacheKey;J)V
    //   313: aload 14
    //   315: invokevirtual 55	com/facebook/orca/debug/Tracer:a	()J
    //   318: pop2
    //   319: aload 5
    //   321: ifnull +8 -> 329
    //   324: aload 5
    //   326: invokevirtual 166	com/facebook/orca/media/MediaDownloader$DownloadResult:c	()V
    //   329: aconst_null
    //   330: astore 20
    //   332: goto -311 -> 21
    //   335: aload_0
    //   336: getfield 26	com/facebook/orca/images/FetchImageHelper:b	Lcom/facebook/orca/images/ImageCache;
    //   339: aload_3
    //   340: ldc2_w 198
    //   343: invokevirtual 184	com/facebook/orca/images/ImageCache:a	(Lcom/facebook/orca/media/MediaCacheKey;J)V
    //   346: aload 14
    //   348: invokevirtual 55	com/facebook/orca/debug/Tracer:a	()J
    //   351: pop2
    //   352: aload 5
    //   354: ifnull +8 -> 362
    //   357: aload 5
    //   359: invokevirtual 166	com/facebook/orca/media/MediaDownloader$DownloadResult:c	()V
    //   362: aconst_null
    //   363: astore 20
    //   365: goto -344 -> 21
    //   368: astore 15
    //   370: aload 14
    //   372: invokevirtual 55	com/facebook/orca/debug/Tracer:a	()J
    //   375: pop2
    //   376: aload 15
    //   378: athrow
    //   379: astore 4
    //   381: goto -172 -> 209
    //   384: astore 4
    //   386: aconst_null
    //   387: astore 5
    //   389: goto -180 -> 209
    //   392: astore 7
    //   394: aload 5
    //   396: astore_2
    //   397: goto -202 -> 195
    //
    // Exception table:
    //   from	to	target	type
    //   31	48	193	finally
    //   195	204	204	finally
    //   222	249	268	java/io/IOException
    //   122	171	368	finally
    //   222	249	368	finally
    //   270	280	368	finally
    //   302	313	368	finally
    //   335	346	368	finally
    //   80	86	379	finally
    //   102	122	379	finally
    //   171	177	379	finally
    //   249	255	379	finally
    //   280	286	379	finally
    //   313	319	379	finally
    //   346	352	379	finally
    //   370	379	379	finally
    //   24	31	384	finally
    //   52	80	392	finally
  }

  Bitmap a(FetchImageParams paramFetchImageParams)
  {
    return a(paramFetchImageParams, true);
  }

  Bitmap b(FetchImageParams paramFetchImageParams)
  {
    return a(paramFetchImageParams, false);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.images.FetchImageHelper
 * JD-Core Version:    0.6.2
 */