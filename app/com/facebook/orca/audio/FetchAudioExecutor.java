package com.facebook.orca.audio;

import android.net.Uri;
import com.facebook.orca.common.async.KeyedExecutor;
import com.facebook.orca.debug.BLog;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;

public class FetchAudioExecutor
{
  private static final Class<?> a = FetchAudioExecutor.class;
  private final AudioCache b;
  private final AudioUriCache c;
  private final AudioMediaDownloader d;
  private final KeyedExecutor e;

  public FetchAudioExecutor(AudioCache paramAudioCache, AudioUriCache paramAudioUriCache, KeyedExecutor paramKeyedExecutor, AudioMediaDownloader paramAudioMediaDownloader)
  {
    this.b = paramAudioCache;
    this.c = paramAudioUriCache;
    this.d = paramAudioMediaDownloader;
    this.e = paramKeyedExecutor;
  }

  private Uri b(FetchAudioParams paramFetchAudioParams)
  {
    AudioCacheKey localAudioCacheKey = paramFetchAudioParams.b();
    Uri localUri = this.b.a(localAudioCacheKey);
    if (localUri != null)
      this.c.a(paramFetchAudioParams.a(), localUri);
    while (true)
    {
      return localUri;
      BLog.a(a, "Miss to hit the audio cache. Start downloading " + localAudioCacheKey.a());
      File localFile = c(paramFetchAudioParams);
      if (localFile != null)
      {
        localUri = Uri.fromFile(localFile);
        this.c.a(paramFetchAudioParams.a(), localUri);
        continue;
      }
      localUri = null;
    }
  }

  // ERROR //
  private File c(FetchAudioParams paramFetchAudioParams)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 40	com/facebook/orca/audio/FetchAudioParams:b	()Lcom/facebook/orca/audio/AudioCacheKey;
    //   4: astore_2
    //   5: aload_0
    //   6: getfield 25	com/facebook/orca/audio/FetchAudioExecutor:b	Lcom/facebook/orca/audio/AudioCache;
    //   9: aload_2
    //   10: invokevirtual 92	com/facebook/orca/audio/AudioCache:f	(Lcom/facebook/orca/media/MediaCacheKey;)Z
    //   13: istore_3
    //   14: aconst_null
    //   15: astore 4
    //   17: iload_3
    //   18: ifeq +6 -> 24
    //   21: aload 4
    //   23: areturn
    //   24: ldc 94
    //   26: invokestatic 99	com/facebook/orca/debug/Tracer:a	(Ljava/lang/String;)Lcom/facebook/orca/debug/Tracer;
    //   29: astore 8
    //   31: aload_1
    //   32: invokevirtual 48	com/facebook/orca/audio/FetchAudioParams:a	()Landroid/net/Uri;
    //   35: astore 13
    //   37: aload_0
    //   38: getfield 29	com/facebook/orca/audio/FetchAudioExecutor:d	Lcom/facebook/orca/audio/AudioMediaDownloader;
    //   41: aload_1
    //   42: invokevirtual 48	com/facebook/orca/audio/FetchAudioParams:a	()Landroid/net/Uri;
    //   45: invokevirtual 104	com/facebook/orca/audio/AudioMediaDownloader:a	(Landroid/net/Uri;)Lcom/facebook/orca/media/MediaDownloader$DownloadResult;
    //   48: astore 14
    //   50: aload 14
    //   52: astore 7
    //   54: aload 7
    //   56: invokevirtual 109	com/facebook/orca/media/MediaDownloader$DownloadResult:a	()Lcom/facebook/orca/media/MediaDownloader$DownloadResultCode;
    //   59: getstatic 115	com/facebook/orca/media/MediaDownloader$DownloadResultCode:UNSUPPORTED_URI	Lcom/facebook/orca/media/MediaDownloader$DownloadResultCode;
    //   62: if_acmpne +45 -> 107
    //   65: getstatic 19	com/facebook/orca/audio/FetchAudioExecutor:a	Ljava/lang/Class;
    //   68: ldc 117
    //   70: iconst_1
    //   71: anewarray 4	java/lang/Object
    //   74: dup
    //   75: iconst_0
    //   76: aload 13
    //   78: aastore
    //   79: invokestatic 120	com/facebook/orca/debug/BLog:e	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)V
    //   82: aload 8
    //   84: invokevirtual 123	com/facebook/orca/debug/Tracer:a	()J
    //   87: pop2
    //   88: aconst_null
    //   89: astore 4
    //   91: aload 7
    //   93: ifnull -72 -> 21
    //   96: aload 7
    //   98: invokevirtual 125	com/facebook/orca/media/MediaDownloader$DownloadResult:c	()V
    //   101: aconst_null
    //   102: astore 4
    //   104: goto -83 -> 21
    //   107: aload 8
    //   109: invokevirtual 123	com/facebook/orca/debug/Tracer:a	()J
    //   112: pop2
    //   113: ldc 127
    //   115: invokestatic 99	com/facebook/orca/debug/Tracer:a	(Ljava/lang/String;)Lcom/facebook/orca/debug/Tracer;
    //   118: astore 17
    //   120: getstatic 132	com/facebook/orca/audio/FetchAudioExecutor$2:a	[I
    //   123: aload 7
    //   125: invokevirtual 109	com/facebook/orca/media/MediaDownloader$DownloadResult:a	()Lcom/facebook/orca/media/MediaDownloader$DownloadResultCode;
    //   128: invokevirtual 136	com/facebook/orca/media/MediaDownloader$DownloadResultCode:ordinal	()I
    //   131: iaload
    //   132: tableswitch	default:+28 -> 160, 1:+97->229, 2:+172->304, 3:+208->340
    //   161: getfield 25	com/facebook/orca/audio/FetchAudioExecutor:b	Lcom/facebook/orca/audio/AudioCache;
    //   164: aload_2
    //   165: ldc2_w 137
    //   168: invokevirtual 141	com/facebook/orca/audio/AudioCache:a	(Lcom/facebook/orca/media/MediaCacheKey;J)V
    //   171: aload 17
    //   173: invokevirtual 123	com/facebook/orca/debug/Tracer:a	()J
    //   176: pop2
    //   177: aconst_null
    //   178: astore 4
    //   180: aload 7
    //   182: ifnull -161 -> 21
    //   185: aload 7
    //   187: invokevirtual 125	com/facebook/orca/media/MediaDownloader$DownloadResult:c	()V
    //   190: aconst_null
    //   191: astore 4
    //   193: goto -172 -> 21
    //   196: astore 9
    //   198: aconst_null
    //   199: astore 7
    //   201: aload 9
    //   203: astore 10
    //   205: aload 8
    //   207: invokevirtual 123	com/facebook/orca/debug/Tracer:a	()J
    //   210: pop2
    //   211: aload 10
    //   213: athrow
    //   214: astore 6
    //   216: aload 7
    //   218: ifnull +8 -> 226
    //   221: aload 7
    //   223: invokevirtual 125	com/facebook/orca/media/MediaDownloader$DownloadResult:c	()V
    //   226: aload 6
    //   228: athrow
    //   229: aload_0
    //   230: getfield 25	com/facebook/orca/audio/FetchAudioExecutor:b	Lcom/facebook/orca/audio/AudioCache;
    //   233: aload_2
    //   234: aload 7
    //   236: invokevirtual 144	com/facebook/orca/media/MediaDownloader$DownloadResult:b	()Ljava/io/InputStream;
    //   239: invokevirtual 147	com/facebook/orca/audio/AudioCache:a	(Lcom/facebook/orca/media/MediaCacheKey;Ljava/io/InputStream;)Ljava/io/File;
    //   242: astore 28
    //   244: aload 28
    //   246: astore 4
    //   248: aload 17
    //   250: invokevirtual 123	com/facebook/orca/debug/Tracer:a	()J
    //   253: pop2
    //   254: aload 7
    //   256: ifnull -235 -> 21
    //   259: aload 7
    //   261: invokevirtual 125	com/facebook/orca/media/MediaDownloader$DownloadResult:c	()V
    //   264: goto -243 -> 21
    //   267: astore 25
    //   269: getstatic 19	com/facebook/orca/audio/FetchAudioExecutor:a	Ljava/lang/Class;
    //   272: ldc 149
    //   274: aload 25
    //   276: invokestatic 152	com/facebook/orca/debug/BLog:d	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   279: aload 17
    //   281: invokevirtual 123	com/facebook/orca/debug/Tracer:a	()J
    //   284: pop2
    //   285: aconst_null
    //   286: astore 4
    //   288: aload 7
    //   290: ifnull -269 -> 21
    //   293: aload 7
    //   295: invokevirtual 125	com/facebook/orca/media/MediaDownloader$DownloadResult:c	()V
    //   298: aconst_null
    //   299: astore 4
    //   301: goto -280 -> 21
    //   304: aload_0
    //   305: getfield 25	com/facebook/orca/audio/FetchAudioExecutor:b	Lcom/facebook/orca/audio/AudioCache;
    //   308: aload_2
    //   309: ldc2_w 153
    //   312: invokevirtual 141	com/facebook/orca/audio/AudioCache:a	(Lcom/facebook/orca/media/MediaCacheKey;J)V
    //   315: aload 17
    //   317: invokevirtual 123	com/facebook/orca/debug/Tracer:a	()J
    //   320: pop2
    //   321: aconst_null
    //   322: astore 4
    //   324: aload 7
    //   326: ifnull -305 -> 21
    //   329: aload 7
    //   331: invokevirtual 125	com/facebook/orca/media/MediaDownloader$DownloadResult:c	()V
    //   334: aconst_null
    //   335: astore 4
    //   337: goto -316 -> 21
    //   340: aload_0
    //   341: getfield 25	com/facebook/orca/audio/FetchAudioExecutor:b	Lcom/facebook/orca/audio/AudioCache;
    //   344: aload_2
    //   345: ldc2_w 155
    //   348: invokevirtual 141	com/facebook/orca/audio/AudioCache:a	(Lcom/facebook/orca/media/MediaCacheKey;J)V
    //   351: aload 17
    //   353: invokevirtual 123	com/facebook/orca/debug/Tracer:a	()J
    //   356: pop2
    //   357: aconst_null
    //   358: astore 4
    //   360: aload 7
    //   362: ifnull -341 -> 21
    //   365: aload 7
    //   367: invokevirtual 125	com/facebook/orca/media/MediaDownloader$DownloadResult:c	()V
    //   370: aconst_null
    //   371: astore 4
    //   373: goto -352 -> 21
    //   376: astore 18
    //   378: aload 17
    //   380: invokevirtual 123	com/facebook/orca/debug/Tracer:a	()J
    //   383: pop2
    //   384: aload 18
    //   386: athrow
    //   387: astore 5
    //   389: aload 5
    //   391: astore 6
    //   393: aconst_null
    //   394: astore 7
    //   396: goto -180 -> 216
    //   399: astore 10
    //   401: goto -196 -> 205
    //
    // Exception table:
    //   from	to	target	type
    //   31	50	196	finally
    //   82	88	214	finally
    //   107	120	214	finally
    //   171	177	214	finally
    //   205	214	214	finally
    //   248	254	214	finally
    //   279	285	214	finally
    //   315	321	214	finally
    //   351	357	214	finally
    //   378	387	214	finally
    //   229	244	267	java/io/IOException
    //   120	171	376	finally
    //   229	244	376	finally
    //   269	279	376	finally
    //   304	315	376	finally
    //   340	351	376	finally
    //   24	31	387	finally
    //   54	82	399	finally
  }

  public ListenableFuture<Uri> a(FetchAudioParams paramFetchAudioParams)
  {
    AudioCacheKey localAudioCacheKey = paramFetchAudioParams.b();
    ListenableFuture localListenableFuture = this.e.a(localAudioCacheKey);
    if ((localListenableFuture == null) || (localListenableFuture.isCancelled()))
    {
      FetchAudioExecutor.1 local1 = new FetchAudioExecutor.1(this, paramFetchAudioParams);
      String str1 = "audio-message-" + Math.abs(localAudioCacheKey.a().hashCode() % 3);
      BLog.b(a, "Create async task for downloading " + str1);
      String str2 = paramFetchAudioParams.a().toString();
      localListenableFuture = this.e.a(str1, localAudioCacheKey, local1, str2);
    }
    return localListenableFuture;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.audio.FetchAudioExecutor
 * JD-Core Version:    0.6.0
 */