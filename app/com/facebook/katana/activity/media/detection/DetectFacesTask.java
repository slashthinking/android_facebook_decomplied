package com.facebook.katana.activity.media.detection;

import android.os.AsyncTask;
import com.facebook.katana.activity.media.Facebox;
import com.facebook.katana.activity.media.MediaTagController;
import com.facebook.katana.model.PhotoItem;
import java.util.List;

public class DetectFacesTask extends AsyncTask<PhotoItem, Void, List<Facebox>>
{
  final String[] a = { "facebox_id", "x_pos", "y_pos", "width", "height", "image_hash" };
  final String[] b = { "image_hash" };
  private MediaTagController c;
  private DetectFacesTaskManager.FaceDetectionListener d;
  private long e = 0L;

  public DetectFacesTask(MediaTagController paramMediaTagController, DetectFacesTaskManager.FaceDetectionListener paramFaceDetectionListener)
  {
    this.c = paramMediaTagController;
    this.d = paramFaceDetectionListener;
  }

  // ERROR //
  protected List<Facebox> a(PhotoItem[] paramArrayOfPhotoItem)
  {
    // Byte code:
    //   0: aload_1
    //   1: arraylength
    //   2: istore 10
    //   4: aconst_null
    //   5: astore 5
    //   7: iload 10
    //   9: ifeq +937 -> 946
    //   12: aload_1
    //   13: iconst_0
    //   14: aaload
    //   15: ifnonnull +9 -> 24
    //   18: aconst_null
    //   19: astore 5
    //   21: goto +925 -> 946
    //   24: aload_1
    //   25: iconst_0
    //   26: aaload
    //   27: astore 11
    //   29: aload_0
    //   30: aload 11
    //   32: invokevirtual 55	com/facebook/katana/model/PhotoItem:a	()J
    //   35: putfield 39	com/facebook/katana/activity/media/detection/DetectFacesTask:e	J
    //   38: aload 11
    //   40: invokevirtual 59	com/facebook/katana/model/PhotoItem:h	()I
    //   43: istore 12
    //   45: aload_0
    //   46: getfield 41	com/facebook/katana/activity/media/detection/DetectFacesTask:c	Lcom/facebook/katana/activity/media/MediaTagController;
    //   49: pop
    //   50: aload 11
    //   52: invokestatic 64	com/facebook/katana/activity/media/MediaTagController:a	(Lcom/facebook/katana/model/MediaItem;)Ljava/lang/String;
    //   55: astore 14
    //   57: invokestatic 67	com/facebook/katana/activity/media/MediaTagController:a	()Ljava/util/Map;
    //   60: astore 15
    //   62: aconst_null
    //   63: astore 16
    //   65: aload 15
    //   67: ifnull +18 -> 85
    //   70: invokestatic 67	com/facebook/katana/activity/media/MediaTagController:a	()Ljava/util/Map;
    //   73: aload 14
    //   75: invokeinterface 73 2 0
    //   80: checkcast 75	com/facebook/katana/activity/media/detection/PhotoDetectionData
    //   83: astore 16
    //   85: aload 16
    //   87: ifnonnull +852 -> 939
    //   90: ldc 77
    //   92: iconst_1
    //   93: anewarray 79	java/lang/Object
    //   96: dup
    //   97: iconst_0
    //   98: ldc 33
    //   100: aastore
    //   101: invokestatic 84	com/facebook/orca/common/util/StringLocaleUtil:a	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   104: astore 34
    //   106: iconst_1
    //   107: anewarray 21	java/lang/String
    //   110: dup
    //   111: iconst_0
    //   112: aload 14
    //   114: aastore
    //   115: astore 35
    //   117: aload_0
    //   118: getfield 41	com/facebook/katana/activity/media/detection/DetectFacesTask:c	Lcom/facebook/katana/activity/media/MediaTagController;
    //   121: invokevirtual 87	com/facebook/katana/activity/media/MediaTagController:c	()Landroid/content/Context;
    //   124: invokevirtual 93	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   127: getstatic 98	com/facebook/katana/provider/LocalFaceboxProvider:a	Landroid/net/Uri;
    //   130: aload_0
    //   131: getfield 35	com/facebook/katana/activity/media/detection/DetectFacesTask:a	[Ljava/lang/String;
    //   134: aload 34
    //   136: aload 35
    //   138: aconst_null
    //   139: invokevirtual 104	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   142: astore 36
    //   144: aload 36
    //   146: ifnull +786 -> 932
    //   149: iconst_0
    //   150: istore 41
    //   152: aload 36
    //   154: invokeinterface 110 1 0
    //   159: ifeq +107 -> 266
    //   162: invokestatic 67	com/facebook/katana/activity/media/MediaTagController:a	()Ljava/util/Map;
    //   165: aload 14
    //   167: invokeinterface 114 2 0
    //   172: ifne +21 -> 193
    //   175: invokestatic 67	com/facebook/katana/activity/media/MediaTagController:a	()Ljava/util/Map;
    //   178: aload 14
    //   180: new 75	com/facebook/katana/activity/media/detection/PhotoDetectionData
    //   183: dup
    //   184: invokespecial 115	com/facebook/katana/activity/media/detection/PhotoDetectionData:<init>	()V
    //   187: invokeinterface 119 3 0
    //   192: pop
    //   193: new 121	com/facebook/katana/activity/media/Facebox
    //   196: dup
    //   197: aload 36
    //   199: iconst_0
    //   200: invokeinterface 125 2 0
    //   205: aload 36
    //   207: iconst_1
    //   208: invokeinterface 129 2 0
    //   213: aload 36
    //   215: iconst_2
    //   216: invokeinterface 129 2 0
    //   221: aload 36
    //   223: iconst_3
    //   224: invokeinterface 129 2 0
    //   229: aload 36
    //   231: iconst_4
    //   232: invokeinterface 129 2 0
    //   237: invokespecial 132	com/facebook/katana/activity/media/Facebox:<init>	(Ljava/lang/String;FFFF)V
    //   240: astore 42
    //   242: invokestatic 67	com/facebook/katana/activity/media/MediaTagController:a	()Ljava/util/Map;
    //   245: aload 14
    //   247: invokeinterface 73 2 0
    //   252: checkcast 75	com/facebook/katana/activity/media/detection/PhotoDetectionData
    //   255: aload 42
    //   257: invokevirtual 135	com/facebook/katana/activity/media/detection/PhotoDetectionData:b	(Lcom/facebook/katana/activity/media/Facebox;)V
    //   260: iconst_1
    //   261: istore 41
    //   263: goto -111 -> 152
    //   266: aload 36
    //   268: invokeinterface 138 1 0
    //   273: iload 41
    //   275: ifeq +657 -> 932
    //   278: invokestatic 67	com/facebook/katana/activity/media/MediaTagController:a	()Ljava/util/Map;
    //   281: aload 14
    //   283: invokeinterface 73 2 0
    //   288: checkcast 75	com/facebook/katana/activity/media/detection/PhotoDetectionData
    //   291: astore 37
    //   293: ldc 77
    //   295: iconst_1
    //   296: anewarray 79	java/lang/Object
    //   299: dup
    //   300: iconst_0
    //   301: ldc 33
    //   303: aastore
    //   304: invokestatic 84	com/facebook/orca/common/util/StringLocaleUtil:a	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   307: astore 38
    //   309: aload_0
    //   310: getfield 41	com/facebook/katana/activity/media/detection/DetectFacesTask:c	Lcom/facebook/katana/activity/media/MediaTagController;
    //   313: invokevirtual 87	com/facebook/katana/activity/media/MediaTagController:c	()Landroid/content/Context;
    //   316: invokevirtual 93	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   319: getstatic 141	com/facebook/katana/provider/DetectedPhotoProvider:a	Landroid/net/Uri;
    //   322: aload_0
    //   323: getfield 37	com/facebook/katana/activity/media/detection/DetectFacesTask:b	[Ljava/lang/String;
    //   326: aload 38
    //   328: aload 35
    //   330: aconst_null
    //   331: invokevirtual 104	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   334: astore 39
    //   336: aload 39
    //   338: ifnull +587 -> 925
    //   341: aload 37
    //   343: astore 17
    //   345: aload 39
    //   347: invokeinterface 110 1 0
    //   352: ifeq +52 -> 404
    //   355: invokestatic 67	com/facebook/katana/activity/media/MediaTagController:a	()Ljava/util/Map;
    //   358: aload 14
    //   360: invokeinterface 114 2 0
    //   365: ifne +21 -> 386
    //   368: invokestatic 67	com/facebook/katana/activity/media/MediaTagController:a	()Ljava/util/Map;
    //   371: aload 14
    //   373: new 75	com/facebook/katana/activity/media/detection/PhotoDetectionData
    //   376: dup
    //   377: invokespecial 115	com/facebook/katana/activity/media/detection/PhotoDetectionData:<init>	()V
    //   380: invokeinterface 119 3 0
    //   385: pop
    //   386: invokestatic 67	com/facebook/katana/activity/media/MediaTagController:a	()Ljava/util/Map;
    //   389: aload 14
    //   391: invokeinterface 73 2 0
    //   396: checkcast 75	com/facebook/katana/activity/media/detection/PhotoDetectionData
    //   399: astore 17
    //   401: goto -56 -> 345
    //   404: aload 39
    //   406: invokeinterface 138 1 0
    //   411: aload_0
    //   412: getfield 41	com/facebook/katana/activity/media/detection/DetectFacesTask:c	Lcom/facebook/katana/activity/media/MediaTagController;
    //   415: invokevirtual 143	com/facebook/katana/activity/media/MediaTagController:d	()I
    //   418: ifeq +8 -> 426
    //   421: aload 17
    //   423: ifnull +496 -> 919
    //   426: aload 17
    //   428: ifnonnull +361 -> 789
    //   431: new 145	java/lang/StringBuilder
    //   434: dup
    //   435: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   438: ldc 148
    //   440: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: aload 11
    //   445: invokevirtual 55	com/facebook/katana/model/PhotoItem:a	()J
    //   448: invokevirtual 155	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   451: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   454: invokestatic 164	com/facebook/common/util/Log:c	(Ljava/lang/String;)V
    //   457: aload 11
    //   459: invokevirtual 166	com/facebook/katana/model/PhotoItem:b	()Ljava/lang/String;
    //   462: sipush 600
    //   465: invokestatic 171	com/facebook/katana/util/ImageUtils:a	(Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   468: astore 19
    //   470: aload_0
    //   471: getfield 41	com/facebook/katana/activity/media/detection/DetectFacesTask:c	Lcom/facebook/katana/activity/media/MediaTagController;
    //   474: invokevirtual 174	com/facebook/katana/activity/media/MediaTagController:b	()Lcom/facebook/facedetection/Tracker;
    //   477: aload 19
    //   479: iload 12
    //   481: iconst_0
    //   482: invokevirtual 179	com/facebook/facedetection/Tracker:a	(Landroid/graphics/Bitmap;IZ)Ljava/util/List;
    //   485: astore 20
    //   487: new 181	java/util/ArrayList
    //   490: dup
    //   491: invokespecial 182	java/util/ArrayList:<init>	()V
    //   494: astore 21
    //   496: aload 20
    //   498: ifnull +100 -> 598
    //   501: aload 20
    //   503: invokeinterface 188 1 0
    //   508: astore 31
    //   510: aload 31
    //   512: invokeinterface 193 1 0
    //   517: ifeq +81 -> 598
    //   520: aload 31
    //   522: invokeinterface 197 1 0
    //   527: checkcast 199	com/facebook/facedetection/Tracker$DetectionData
    //   530: astore 32
    //   532: aload 32
    //   534: ifnull -24 -> 510
    //   537: aload 21
    //   539: new 121	com/facebook/katana/activity/media/Facebox
    //   542: dup
    //   543: aload 32
    //   545: invokespecial 202	com/facebook/katana/activity/media/Facebox:<init>	(Lcom/facebook/facedetection/Tracker$DetectionData;)V
    //   548: invokeinterface 205 2 0
    //   553: pop
    //   554: goto -44 -> 510
    //   557: astore 24
    //   559: aload 21
    //   561: astore 4
    //   563: aload 24
    //   565: astore_3
    //   566: new 145	java/lang/StringBuilder
    //   569: dup
    //   570: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   573: ldc 207
    //   575: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: aload_3
    //   579: invokevirtual 210	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   582: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   588: invokestatic 212	com/facebook/common/util/Log:a	(Ljava/lang/String;)V
    //   591: aload 4
    //   593: astore 5
    //   595: goto +351 -> 946
    //   598: aload 19
    //   600: invokevirtual 217	android/graphics/Bitmap:recycle	()V
    //   603: invokestatic 67	com/facebook/katana/activity/media/MediaTagController:a	()Ljava/util/Map;
    //   606: aload 14
    //   608: invokeinterface 73 2 0
    //   613: checkcast 75	com/facebook/katana/activity/media/detection/PhotoDetectionData
    //   616: ifnonnull +140 -> 756
    //   619: invokestatic 67	com/facebook/katana/activity/media/MediaTagController:a	()Ljava/util/Map;
    //   622: aload 14
    //   624: new 75	com/facebook/katana/activity/media/detection/PhotoDetectionData
    //   627: dup
    //   628: aload 21
    //   630: invokespecial 220	com/facebook/katana/activity/media/detection/PhotoDetectionData:<init>	(Ljava/util/List;)V
    //   633: invokeinterface 119 3 0
    //   638: pop
    //   639: aload 21
    //   641: invokeinterface 223 1 0
    //   646: anewarray 225	android/content/ContentValues
    //   649: astore 26
    //   651: iconst_0
    //   652: istore 27
    //   654: iload 27
    //   656: aload 21
    //   658: invokeinterface 223 1 0
    //   663: if_icmpge +31 -> 694
    //   666: aload 26
    //   668: iload 27
    //   670: aload 21
    //   672: iload 27
    //   674: invokeinterface 228 2 0
    //   679: checkcast 121	com/facebook/katana/activity/media/Facebox
    //   682: aload 14
    //   684: invokevirtual 231	com/facebook/katana/activity/media/Facebox:a	(Ljava/lang/String;)Landroid/content/ContentValues;
    //   687: aastore
    //   688: iinc 27 1
    //   691: goto -37 -> 654
    //   694: aload 26
    //   696: arraylength
    //   697: ifle +22 -> 719
    //   700: aload_0
    //   701: getfield 41	com/facebook/katana/activity/media/detection/DetectFacesTask:c	Lcom/facebook/katana/activity/media/MediaTagController;
    //   704: invokevirtual 87	com/facebook/katana/activity/media/MediaTagController:c	()Landroid/content/Context;
    //   707: invokevirtual 93	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   710: getstatic 98	com/facebook/katana/provider/LocalFaceboxProvider:a	Landroid/net/Uri;
    //   713: aload 26
    //   715: invokevirtual 235	android/content/ContentResolver:bulkInsert	(Landroid/net/Uri;[Landroid/content/ContentValues;)I
    //   718: pop
    //   719: new 225	android/content/ContentValues
    //   722: dup
    //   723: invokespecial 236	android/content/ContentValues:<init>	()V
    //   726: astore 28
    //   728: aload 28
    //   730: ldc 33
    //   732: aload 14
    //   734: invokevirtual 239	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   737: aload_0
    //   738: getfield 41	com/facebook/katana/activity/media/detection/DetectFacesTask:c	Lcom/facebook/katana/activity/media/MediaTagController;
    //   741: invokevirtual 87	com/facebook/katana/activity/media/MediaTagController:c	()Landroid/content/Context;
    //   744: invokevirtual 93	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   747: getstatic 141	com/facebook/katana/provider/DetectedPhotoProvider:a	Landroid/net/Uri;
    //   750: aload 28
    //   752: invokevirtual 243	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   755: pop
    //   756: new 145	java/lang/StringBuilder
    //   759: dup
    //   760: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   763: ldc 245
    //   765: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   768: aload 11
    //   770: invokevirtual 55	com/facebook/katana/model/PhotoItem:a	()J
    //   773: invokevirtual 155	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   776: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   779: invokestatic 164	com/facebook/common/util/Log:c	(Ljava/lang/String;)V
    //   782: aload 21
    //   784: astore 4
    //   786: goto -195 -> 591
    //   789: aload 17
    //   791: ifnull +128 -> 919
    //   794: aload 17
    //   796: invokevirtual 248	com/facebook/katana/activity/media/detection/PhotoDetectionData:a	()Ljava/util/List;
    //   799: astore 18
    //   801: aload 18
    //   803: astore 4
    //   805: goto -214 -> 591
    //   808: astore 8
    //   810: aload 8
    //   812: astore 9
    //   814: aconst_null
    //   815: astore 4
    //   817: new 145	java/lang/StringBuilder
    //   820: dup
    //   821: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   824: ldc 250
    //   826: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   829: aload 9
    //   831: invokevirtual 251	com/facebook/katana/util/ImageUtils$ImageOutOfMemoryException:getMessage	()Ljava/lang/String;
    //   834: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   837: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   840: invokestatic 212	com/facebook/common/util/Log:a	(Ljava/lang/String;)V
    //   843: goto -252 -> 591
    //   846: astore 6
    //   848: aload 6
    //   850: astore 7
    //   852: aconst_null
    //   853: astore 4
    //   855: new 145	java/lang/StringBuilder
    //   858: dup
    //   859: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   862: ldc 253
    //   864: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   867: aload 7
    //   869: invokevirtual 254	com/facebook/katana/util/ImageUtils$ImageDecodeException:getMessage	()Ljava/lang/String;
    //   872: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   875: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   878: invokestatic 212	com/facebook/common/util/Log:a	(Ljava/lang/String;)V
    //   881: goto -290 -> 591
    //   884: astore 23
    //   886: aload 21
    //   888: astore 4
    //   890: aload 23
    //   892: astore 7
    //   894: goto -39 -> 855
    //   897: astore 22
    //   899: aload 21
    //   901: astore 4
    //   903: aload 22
    //   905: astore 9
    //   907: goto -90 -> 817
    //   910: astore_2
    //   911: aload_2
    //   912: astore_3
    //   913: aconst_null
    //   914: astore 4
    //   916: goto -350 -> 566
    //   919: aconst_null
    //   920: astore 4
    //   922: goto -331 -> 591
    //   925: aload 37
    //   927: astore 17
    //   929: goto -518 -> 411
    //   932: aload 16
    //   934: astore 37
    //   936: goto -643 -> 293
    //   939: aload 16
    //   941: astore 17
    //   943: goto -532 -> 411
    //   946: aload 5
    //   948: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   501	554	557	java/lang/OutOfMemoryError
    //   598	782	557	java/lang/OutOfMemoryError
    //   0	496	808	com/facebook/katana/util/ImageUtils$ImageOutOfMemoryException
    //   794	801	808	com/facebook/katana/util/ImageUtils$ImageOutOfMemoryException
    //   0	496	846	com/facebook/katana/util/ImageUtils$ImageDecodeException
    //   794	801	846	com/facebook/katana/util/ImageUtils$ImageDecodeException
    //   501	554	884	com/facebook/katana/util/ImageUtils$ImageDecodeException
    //   598	782	884	com/facebook/katana/util/ImageUtils$ImageDecodeException
    //   501	554	897	com/facebook/katana/util/ImageUtils$ImageOutOfMemoryException
    //   598	782	897	com/facebook/katana/util/ImageUtils$ImageOutOfMemoryException
    //   0	496	910	java/lang/OutOfMemoryError
    //   794	801	910	java/lang/OutOfMemoryError
  }

  protected void a(List<Facebox> paramList)
  {
    DetectFacesTaskManager.FaceDetectionListener localFaceDetectionListener = this.d;
    long l = this.e;
    if ((paramList != null) && (paramList.size() > 0));
    for (boolean bool = true; ; bool = false)
    {
      localFaceDetectionListener.a(l, bool);
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.detection.DetectFacesTask
 * JD-Core Version:    0.6.0
 */