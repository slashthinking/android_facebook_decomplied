package com.facebook.katana.activity.media;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Pair;
import android.view.View;
import android.widget.ProgressBar;
import com.facebook.analytics.performance.PerformanceLogger;
import com.facebook.katana.RotateBitmap;
import com.facebook.katana.ui.ImageViewTouchBase;
import com.facebook.orca.common.util.SystemClock;
import com.facebook.orca.images.ImageCache;
import com.facebook.orca.images.ImageCacheKey;
import com.facebook.widget.GalleryWithSwipingFix;

class PhotosetGalleryAdapter$LoadPhotoTask extends AsyncTask<Long, Void, Pair<Bitmap, Boolean>>
{
  private long b;
  private ImageCacheKey c;
  private boolean d = false;

  private PhotosetGalleryAdapter$LoadPhotoTask(PhotosetGalleryAdapter paramPhotosetGalleryAdapter)
  {
  }

  // ERROR //
  protected Pair<Bitmap, Boolean> a(Long[] paramArrayOfLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: iconst_0
    //   3: aaload
    //   4: invokevirtual 36	java/lang/Long:longValue	()J
    //   7: putfield 38	com/facebook/katana/activity/media/PhotosetGalleryAdapter$LoadPhotoTask:b	J
    //   10: aload_0
    //   11: getfield 17	com/facebook/katana/activity/media/PhotosetGalleryAdapter$LoadPhotoTask:a	Lcom/facebook/katana/activity/media/PhotosetGalleryAdapter;
    //   14: invokevirtual 44	com/facebook/katana/activity/media/PhotosetGalleryAdapter:getContext	()Landroid/content/Context;
    //   17: astore_2
    //   18: aload_2
    //   19: aload_0
    //   20: getfield 38	com/facebook/katana/activity/media/PhotosetGalleryAdapter$LoadPhotoTask:b	J
    //   23: invokestatic 49	com/facebook/katana/model/FacebookPhoto:a	(Landroid/content/Context;J)Lcom/facebook/katana/model/FacebookPhoto;
    //   26: astore_3
    //   27: aload_3
    //   28: ifnull +443 -> 471
    //   31: aload_0
    //   32: getfield 17	com/facebook/katana/activity/media/PhotosetGalleryAdapter$LoadPhotoTask:a	Lcom/facebook/katana/activity/media/PhotosetGalleryAdapter;
    //   35: invokestatic 52	com/facebook/katana/activity/media/PhotosetGalleryAdapter:a	(Lcom/facebook/katana/activity/media/PhotosetGalleryAdapter;)Ljava/util/Map;
    //   38: aload_0
    //   39: getfield 38	com/facebook/katana/activity/media/PhotosetGalleryAdapter$LoadPhotoTask:b	J
    //   42: invokestatic 56	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   45: invokeinterface 62 2 0
    //   50: ifne +163 -> 213
    //   53: aload_3
    //   54: invokevirtual 66	com/facebook/katana/model/FacebookPhoto:g	()Ljava/lang/String;
    //   57: ifnonnull +56 -> 113
    //   60: aload_0
    //   61: getfield 17	com/facebook/katana/activity/media/PhotosetGalleryAdapter$LoadPhotoTask:a	Lcom/facebook/katana/activity/media/PhotosetGalleryAdapter;
    //   64: invokestatic 69	com/facebook/katana/activity/media/PhotosetGalleryAdapter:b	(Lcom/facebook/katana/activity/media/PhotosetGalleryAdapter;)Lcom/facebook/common/util/FbErrorReporter;
    //   67: ldc 71
    //   69: new 73	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   76: ldc 76
    //   78: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload_0
    //   82: getfield 38	com/facebook/katana/activity/media/PhotosetGalleryAdapter$LoadPhotoTask:b	J
    //   85: invokevirtual 83	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   88: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokeinterface 91 3 0
    //   96: new 93	android/util/Pair
    //   99: dup
    //   100: aconst_null
    //   101: iconst_0
    //   102: invokestatic 98	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   105: invokespecial 101	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   108: astore 6
    //   110: goto +370 -> 480
    //   113: aload_0
    //   114: new 103	com/facebook/orca/images/ImageCacheKey
    //   117: dup
    //   118: aload_3
    //   119: invokevirtual 66	com/facebook/katana/model/FacebookPhoto:g	()Ljava/lang/String;
    //   122: invokestatic 109	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   125: getstatic 112	com/facebook/orca/images/ImageCacheKey:c	Lcom/facebook/orca/images/ImageCacheKey$Options;
    //   128: invokespecial 115	com/facebook/orca/images/ImageCacheKey:<init>	(Landroid/net/Uri;Lcom/facebook/orca/images/ImageCacheKey$Options;)V
    //   131: putfield 117	com/facebook/katana/activity/media/PhotosetGalleryAdapter$LoadPhotoTask:c	Lcom/facebook/orca/images/ImageCacheKey;
    //   134: aload_0
    //   135: getfield 17	com/facebook/katana/activity/media/PhotosetGalleryAdapter$LoadPhotoTask:a	Lcom/facebook/katana/activity/media/PhotosetGalleryAdapter;
    //   138: invokestatic 52	com/facebook/katana/activity/media/PhotosetGalleryAdapter:a	(Lcom/facebook/katana/activity/media/PhotosetGalleryAdapter;)Ljava/util/Map;
    //   141: aload_0
    //   142: getfield 38	com/facebook/katana/activity/media/PhotosetGalleryAdapter$LoadPhotoTask:b	J
    //   145: invokestatic 56	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   148: aload_0
    //   149: getfield 117	com/facebook/katana/activity/media/PhotosetGalleryAdapter$LoadPhotoTask:c	Lcom/facebook/orca/images/ImageCacheKey;
    //   152: invokeinterface 121 3 0
    //   157: pop
    //   158: aload_0
    //   159: getfield 17	com/facebook/katana/activity/media/PhotosetGalleryAdapter$LoadPhotoTask:a	Lcom/facebook/katana/activity/media/PhotosetGalleryAdapter;
    //   162: invokestatic 124	com/facebook/katana/activity/media/PhotosetGalleryAdapter:c	(Lcom/facebook/katana/activity/media/PhotosetGalleryAdapter;)Lcom/facebook/orca/images/ImageCache;
    //   165: aload_0
    //   166: getfield 117	com/facebook/katana/activity/media/PhotosetGalleryAdapter$LoadPhotoTask:c	Lcom/facebook/orca/images/ImageCacheKey;
    //   169: invokevirtual 130	com/facebook/orca/images/ImageCache:e	(Lcom/facebook/orca/media/MediaCacheKey;)Ljava/lang/Object;
    //   172: checkcast 132	android/graphics/Bitmap
    //   175: astore 11
    //   177: aload 11
    //   179: ifnull +87 -> 266
    //   182: aload_0
    //   183: iconst_1
    //   184: putfield 22	com/facebook/katana/activity/media/PhotosetGalleryAdapter$LoadPhotoTask:d	Z
    //   187: aload 11
    //   189: astore 5
    //   191: iconst_1
    //   192: istore 4
    //   194: new 93	android/util/Pair
    //   197: dup
    //   198: aload 5
    //   200: iload 4
    //   202: invokestatic 98	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   205: invokespecial 101	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   208: astore 6
    //   210: goto +270 -> 480
    //   213: aload_0
    //   214: aload_0
    //   215: getfield 17	com/facebook/katana/activity/media/PhotosetGalleryAdapter$LoadPhotoTask:a	Lcom/facebook/katana/activity/media/PhotosetGalleryAdapter;
    //   218: invokestatic 52	com/facebook/katana/activity/media/PhotosetGalleryAdapter:a	(Lcom/facebook/katana/activity/media/PhotosetGalleryAdapter;)Ljava/util/Map;
    //   221: aload_0
    //   222: getfield 38	com/facebook/katana/activity/media/PhotosetGalleryAdapter$LoadPhotoTask:b	J
    //   225: invokestatic 56	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   228: invokeinterface 136 2 0
    //   233: checkcast 103	com/facebook/orca/images/ImageCacheKey
    //   236: putfield 117	com/facebook/katana/activity/media/PhotosetGalleryAdapter$LoadPhotoTask:c	Lcom/facebook/orca/images/ImageCacheKey;
    //   239: goto -81 -> 158
    //   242: astore 9
    //   244: aconst_null
    //   245: astore 5
    //   247: aload 9
    //   249: astore 10
    //   251: iconst_0
    //   252: istore 4
    //   254: ldc 138
    //   256: ldc 140
    //   258: aload 10
    //   260: invokestatic 145	com/facebook/common/util/ErrorReporting:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   263: goto -69 -> 194
    //   266: aload_3
    //   267: invokevirtual 148	com/facebook/katana/model/FacebookPhoto:k	()Ljava/lang/String;
    //   270: ifnull +45 -> 315
    //   273: aload_3
    //   274: invokevirtual 148	com/facebook/katana/model/FacebookPhoto:k	()Ljava/lang/String;
    //   277: aconst_null
    //   278: invokestatic 153	com/facebook/katana/util/ImageUtils:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   281: astore 16
    //   283: aload 16
    //   285: astore 11
    //   287: new 155	java/io/File
    //   290: dup
    //   291: aload_3
    //   292: invokevirtual 148	com/facebook/katana/model/FacebookPhoto:k	()Ljava/lang/String;
    //   295: invokespecial 158	java/io/File:<init>	(Ljava/lang/String;)V
    //   298: invokestatic 163	java/lang/System:currentTimeMillis	()J
    //   301: invokevirtual 167	java/io/File:setLastModified	(J)Z
    //   304: pop
    //   305: aload 11
    //   307: astore 5
    //   309: iconst_1
    //   310: istore 4
    //   312: goto -118 -> 194
    //   315: aload_3
    //   316: invokevirtual 171	com/facebook/katana/model/FacebookPhoto:i	()[B
    //   319: ifnull +12 -> 331
    //   322: aload_3
    //   323: invokevirtual 171	com/facebook/katana/model/FacebookPhoto:i	()[B
    //   326: invokestatic 174	com/facebook/katana/util/ImageUtils:b	([B)Landroid/graphics/Bitmap;
    //   329: astore 11
    //   331: aload_0
    //   332: getfield 17	com/facebook/katana/activity/media/PhotosetGalleryAdapter$LoadPhotoTask:a	Lcom/facebook/katana/activity/media/PhotosetGalleryAdapter;
    //   335: aload_0
    //   336: getfield 38	com/facebook/katana/activity/media/PhotosetGalleryAdapter$LoadPhotoTask:b	J
    //   339: invokestatic 177	com/facebook/katana/activity/media/PhotosetGalleryAdapter:a	(Lcom/facebook/katana/activity/media/PhotosetGalleryAdapter;J)Z
    //   342: ifne +39 -> 381
    //   345: aload_0
    //   346: getfield 17	com/facebook/katana/activity/media/PhotosetGalleryAdapter$LoadPhotoTask:a	Lcom/facebook/katana/activity/media/PhotosetGalleryAdapter;
    //   349: invokestatic 180	com/facebook/katana/activity/media/PhotosetGalleryAdapter:d	(Lcom/facebook/katana/activity/media/PhotosetGalleryAdapter;)Lcom/facebook/katana/binding/AppSession;
    //   352: aload_2
    //   353: aload_3
    //   354: invokevirtual 185	com/facebook/katana/binding/AppSession:b	(Landroid/content/Context;Lcom/facebook/katana/model/FacebookPhoto;)Ljava/lang/String;
    //   357: astore 14
    //   359: aload_0
    //   360: getfield 17	com/facebook/katana/activity/media/PhotosetGalleryAdapter$LoadPhotoTask:a	Lcom/facebook/katana/activity/media/PhotosetGalleryAdapter;
    //   363: invokestatic 187	com/facebook/katana/activity/media/PhotosetGalleryAdapter:e	(Lcom/facebook/katana/activity/media/PhotosetGalleryAdapter;)Ljava/util/Map;
    //   366: aload_0
    //   367: getfield 38	com/facebook/katana/activity/media/PhotosetGalleryAdapter$LoadPhotoTask:b	J
    //   370: invokestatic 56	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   373: aload 14
    //   375: invokeinterface 121 3 0
    //   380: pop
    //   381: aload 11
    //   383: astore 5
    //   385: iconst_0
    //   386: istore 4
    //   388: goto -194 -> 194
    //   391: astore 7
    //   393: aconst_null
    //   394: astore 5
    //   396: aload 7
    //   398: astore 8
    //   400: iconst_0
    //   401: istore 4
    //   403: ldc 138
    //   405: ldc 189
    //   407: aload 8
    //   409: invokestatic 192	com/facebook/common/util/Log:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   412: goto -218 -> 194
    //   415: astore 8
    //   417: aload 11
    //   419: astore 5
    //   421: iconst_1
    //   422: istore 4
    //   424: goto -21 -> 403
    //   427: astore 13
    //   429: aload 11
    //   431: astore 5
    //   433: aload 13
    //   435: astore 8
    //   437: iconst_0
    //   438: istore 4
    //   440: goto -37 -> 403
    //   443: astore 10
    //   445: aload 11
    //   447: astore 5
    //   449: iconst_1
    //   450: istore 4
    //   452: goto -198 -> 254
    //   455: astore 12
    //   457: aload 11
    //   459: astore 5
    //   461: aload 12
    //   463: astore 10
    //   465: iconst_0
    //   466: istore 4
    //   468: goto -214 -> 254
    //   471: iconst_0
    //   472: istore 4
    //   474: aconst_null
    //   475: astore 5
    //   477: goto -283 -> 194
    //   480: aload 6
    //   482: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   31	177	242	com/facebook/katana/util/ImageUtils$ImageOutOfMemoryException
    //   213	239	242	com/facebook/katana/util/ImageUtils$ImageOutOfMemoryException
    //   31	177	391	com/facebook/katana/util/ImageUtils$ImageDecodeException
    //   213	239	391	com/facebook/katana/util/ImageUtils$ImageDecodeException
    //   182	187	415	com/facebook/katana/util/ImageUtils$ImageDecodeException
    //   287	305	415	com/facebook/katana/util/ImageUtils$ImageDecodeException
    //   266	283	427	com/facebook/katana/util/ImageUtils$ImageDecodeException
    //   315	381	427	com/facebook/katana/util/ImageUtils$ImageDecodeException
    //   182	187	443	com/facebook/katana/util/ImageUtils$ImageOutOfMemoryException
    //   287	305	443	com/facebook/katana/util/ImageUtils$ImageOutOfMemoryException
    //   266	283	455	com/facebook/katana/util/ImageUtils$ImageOutOfMemoryException
    //   315	381	455	com/facebook/katana/util/ImageUtils$ImageOutOfMemoryException
  }

  protected void a(Pair<Bitmap, Boolean> paramPair)
  {
    for (int i = 0; ; i++)
      try
      {
        Bitmap localBitmap = (Bitmap)paramPair.first;
        if (localBitmap == null);
        while (true)
        {
          return;
          if ((((Boolean)paramPair.second).booleanValue()) && (!this.d) && (!PhotosetGalleryAdapter.c(this.a).c(this.c)))
            PhotosetGalleryAdapter.c(this.a).a(this.c, localBitmap);
          int j = PhotosetGalleryAdapter.f(this.a).getChildCount();
          if (i < j)
          {
            View localView = PhotosetGalleryAdapter.f(this.a).getChildAt(i);
            if (localView == null)
              break;
            PhotosetGalleryAdapter.ViewHolder localViewHolder = (PhotosetGalleryAdapter.ViewHolder)localView.getTag();
            if (localViewHolder.c != this.b)
              break;
            PhotosetGalleryAdapter.g(this.a).b("NNFPhotoViewUncached", Long.toString(localViewHolder.c), SystemClock.b().a());
            localViewHolder.b.setImageRotateBitmapResetBase(new RotateBitmap(localBitmap, 0), true);
            if (((Boolean)paramPair.second).booleanValue())
            {
              localViewHolder.d.setVisibility(8);
              localViewHolder.a = true;
            }
          }
          PhotosetGalleryAdapter.b(this.a, this.b);
        }
      }
      finally
      {
        PhotosetGalleryAdapter.b(this.a, this.b);
      }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.PhotosetGalleryAdapter.LoadPhotoTask
 * JD-Core Version:    0.6.0
 */