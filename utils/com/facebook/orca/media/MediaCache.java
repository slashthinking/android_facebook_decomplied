package com.facebook.orca.media;

import android.content.Context;
import com.facebook.common.util.DiskUsageUtil;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.common.util.SecureHashUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.inject.FbInjector;
import com.google.common.base.Preconditions;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Maps;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ConcurrentMap;

public abstract class MediaCache<KEY extends MediaCacheKey, VALUE>
{
  private static final Class<?> a = MediaCache.class;
  private final Context b;
  private final Clock c;
  private final ConcurrentMap<KEY, MediaCache<KEY, VALUE>.InMemoryCachedValue<KEY, VALUE>> d;
  private final ConcurrentMap<KEY, VALUE> e;
  private final ConcurrentMap<KEY, Long> f;
  private final Object g = new Object();
  private final Object h = new Object();
  private final String i;
  private final String j;
  private final boolean k;
  private final int l;
  private final int m;
  private final int n;
  private final int o;
  private volatile File p;
  private DiskUsageUtil q;
  private int r;

  protected MediaCache(Context paramContext, Clock paramClock, DiskUsageUtil paramDiskUsageUtil, MediaCacheParams paramMediaCacheParams)
  {
    this.b = paramContext;
    this.c = paramClock;
    this.q = paramDiskUsageUtil;
    this.i = paramMediaCacheParams.a();
    this.j = paramMediaCacheParams.b();
    this.l = paramMediaCacheParams.f();
    this.m = paramMediaCacheParams.e();
    this.n = paramMediaCacheParams.c();
    this.o = paramMediaCacheParams.d();
    this.k = paramMediaCacheParams.g();
    this.f = Maps.c();
    boolean bool;
    if (this.k)
      if (this.m <= this.l)
      {
        bool = true;
        Preconditions.checkArgument(bool);
        this.d = new MapMaker().a(128).c(4).n();
      }
    for (this.e = new MapMaker().a(128).c(4).h().n(); ; this.e = null)
    {
      return;
      bool = false;
      break;
      this.d = null;
    }
  }

  private File a(KEY paramKEY, String paramString)
  {
    String str = SecureHashUtil.b(paramKEY.b().getBytes("utf-8"));
    return new File(d(), str + paramString);
  }

  private File a(File paramFile, String paramString)
  {
    String str1 = paramFile.getName();
    String str2 = str1.substring(0, str1.lastIndexOf('.'));
    return new File(paramFile.getParent(), str2 + paramString);
  }

  // ERROR //
  private void b(KEY paramKEY, VALUE paramVALUE)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 88	com/facebook/orca/media/MediaCache:k	Z
    //   4: ifne +37 -> 41
    //   7: getstatic 41	com/facebook/orca/media/MediaCache:a	Ljava/lang/Class;
    //   10: new 143	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   17: ldc 176
    //   19: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_0
    //   23: getfield 62	com/facebook/orca/media/MediaCache:i	Ljava/lang/String;
    //   26: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc 178
    //   31: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 183	com/facebook/orca/debug/BLog:a	(Ljava/lang/Class;Ljava/lang/String;)V
    //   40: return
    //   41: aload_0
    //   42: getfield 49	com/facebook/orca/media/MediaCache:h	Ljava/lang/Object;
    //   45: astore_3
    //   46: aload_3
    //   47: monitorenter
    //   48: aload_0
    //   49: getfield 113	com/facebook/orca/media/MediaCache:d	Ljava/util/concurrent/ConcurrentMap;
    //   52: aload_1
    //   53: new 185	com/facebook/orca/media/MediaCache$InMemoryCachedValue
    //   56: dup
    //   57: aload_0
    //   58: aload_1
    //   59: aload_2
    //   60: aload_0
    //   61: aload_2
    //   62: invokevirtual 188	com/facebook/orca/media/MediaCache:a	(Ljava/lang/Object;)I
    //   65: invokespecial 191	com/facebook/orca/media/MediaCache$InMemoryCachedValue:<init>	(Lcom/facebook/orca/media/MediaCache;Lcom/facebook/orca/media/MediaCacheKey;Ljava/lang/Object;I)V
    //   68: invokeinterface 197 3 0
    //   73: checkcast 185	com/facebook/orca/media/MediaCache$InMemoryCachedValue
    //   76: astore 5
    //   78: aload 5
    //   80: ifnull +17 -> 97
    //   83: aload_0
    //   84: aload_0
    //   85: getfield 199	com/facebook/orca/media/MediaCache:r	I
    //   88: aload 5
    //   90: invokestatic 202	com/facebook/orca/media/MediaCache$InMemoryCachedValue:b	(Lcom/facebook/orca/media/MediaCache$InMemoryCachedValue;)I
    //   93: isub
    //   94: putfield 199	com/facebook/orca/media/MediaCache:r	I
    //   97: aload_0
    //   98: aload_0
    //   99: getfield 199	com/facebook/orca/media/MediaCache:r	I
    //   102: aload_0
    //   103: aload_2
    //   104: invokevirtual 188	com/facebook/orca/media/MediaCache:a	(Ljava/lang/Object;)I
    //   107: iadd
    //   108: putfield 199	com/facebook/orca/media/MediaCache:r	I
    //   111: aload_0
    //   112: getfield 199	com/facebook/orca/media/MediaCache:r	I
    //   115: aload_0
    //   116: getfield 71	com/facebook/orca/media/MediaCache:l	I
    //   119: if_icmpgt +19 -> 138
    //   122: aload_0
    //   123: getfield 113	com/facebook/orca/media/MediaCache:d	Ljava/util/concurrent/ConcurrentMap;
    //   126: invokeinterface 205 1 0
    //   131: aload_0
    //   132: getfield 79	com/facebook/orca/media/MediaCache:n	I
    //   135: if_icmple +298 -> 433
    //   138: getstatic 41	com/facebook/orca/media/MediaCache:a	Ljava/lang/Class;
    //   141: new 143	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   148: ldc 207
    //   150: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_0
    //   154: getfield 199	com/facebook/orca/media/MediaCache:r	I
    //   157: sipush 1024
    //   160: idiv
    //   161: invokevirtual 210	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   164: ldc 212
    //   166: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload_0
    //   170: getfield 113	com/facebook/orca/media/MediaCache:d	Ljava/util/concurrent/ConcurrentMap;
    //   173: invokeinterface 205 1 0
    //   178: invokevirtual 210	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   181: ldc 214
    //   183: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokestatic 216	com/facebook/orca/debug/BLog:c	(Ljava/lang/Class;Ljava/lang/String;)V
    //   192: aload_0
    //   193: getfield 113	com/facebook/orca/media/MediaCache:d	Ljava/util/concurrent/ConcurrentMap;
    //   196: invokeinterface 220 1 0
    //   201: invokestatic 225	com/google/common/collect/Lists:a	(Ljava/lang/Iterable;)Ljava/util/ArrayList;
    //   204: astore 6
    //   206: aload 6
    //   208: invokeinterface 231 1 0
    //   213: astore 7
    //   215: aload 7
    //   217: invokeinterface 236 1 0
    //   222: ifeq +36 -> 258
    //   225: aload 7
    //   227: invokeinterface 240 1 0
    //   232: checkcast 185	com/facebook/orca/media/MediaCache$InMemoryCachedValue
    //   235: astore 12
    //   237: aload 12
    //   239: aload 12
    //   241: invokestatic 243	com/facebook/orca/media/MediaCache$InMemoryCachedValue:c	(Lcom/facebook/orca/media/MediaCache$InMemoryCachedValue;)J
    //   244: invokestatic 246	com/facebook/orca/media/MediaCache$InMemoryCachedValue:a	(Lcom/facebook/orca/media/MediaCache$InMemoryCachedValue;J)J
    //   247: pop2
    //   248: goto -33 -> 215
    //   251: astore 4
    //   253: aload_3
    //   254: monitorexit
    //   255: aload 4
    //   257: athrow
    //   258: aload 6
    //   260: new 248	com/facebook/orca/media/MediaCache$ExpirationComparator
    //   263: dup
    //   264: aload_0
    //   265: invokespecial 251	com/facebook/orca/media/MediaCache$ExpirationComparator:<init>	(Lcom/facebook/orca/media/MediaCache;)V
    //   268: invokestatic 257	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   271: aload 6
    //   273: invokeinterface 231 1 0
    //   278: astore 8
    //   280: aload 8
    //   282: invokeinterface 236 1 0
    //   287: ifeq +91 -> 378
    //   290: aload 8
    //   292: invokeinterface 240 1 0
    //   297: checkcast 185	com/facebook/orca/media/MediaCache$InMemoryCachedValue
    //   300: astore 9
    //   302: aload_0
    //   303: getfield 118	com/facebook/orca/media/MediaCache:e	Ljava/util/concurrent/ConcurrentMap;
    //   306: aload 9
    //   308: invokestatic 260	com/facebook/orca/media/MediaCache$InMemoryCachedValue:d	(Lcom/facebook/orca/media/MediaCache$InMemoryCachedValue;)Lcom/facebook/orca/media/MediaCacheKey;
    //   311: aload 9
    //   313: invokestatic 263	com/facebook/orca/media/MediaCache$InMemoryCachedValue:a	(Lcom/facebook/orca/media/MediaCache$InMemoryCachedValue;)Ljava/lang/Object;
    //   316: invokeinterface 197 3 0
    //   321: pop
    //   322: aload_0
    //   323: getfield 113	com/facebook/orca/media/MediaCache:d	Ljava/util/concurrent/ConcurrentMap;
    //   326: aload 9
    //   328: invokestatic 260	com/facebook/orca/media/MediaCache$InMemoryCachedValue:d	(Lcom/facebook/orca/media/MediaCache$InMemoryCachedValue;)Lcom/facebook/orca/media/MediaCacheKey;
    //   331: invokeinterface 267 2 0
    //   336: pop
    //   337: aload_0
    //   338: aload_0
    //   339: getfield 199	com/facebook/orca/media/MediaCache:r	I
    //   342: aload 9
    //   344: invokestatic 202	com/facebook/orca/media/MediaCache$InMemoryCachedValue:b	(Lcom/facebook/orca/media/MediaCache$InMemoryCachedValue;)I
    //   347: isub
    //   348: putfield 199	com/facebook/orca/media/MediaCache:r	I
    //   351: aload_0
    //   352: getfield 199	com/facebook/orca/media/MediaCache:r	I
    //   355: aload_0
    //   356: getfield 75	com/facebook/orca/media/MediaCache:m	I
    //   359: if_icmpge -79 -> 280
    //   362: aload_0
    //   363: getfield 113	com/facebook/orca/media/MediaCache:d	Ljava/util/concurrent/ConcurrentMap;
    //   366: invokeinterface 205 1 0
    //   371: aload_0
    //   372: getfield 83	com/facebook/orca/media/MediaCache:o	I
    //   375: if_icmpgt -95 -> 280
    //   378: getstatic 41	com/facebook/orca/media/MediaCache:a	Ljava/lang/Class;
    //   381: new 143	java/lang/StringBuilder
    //   384: dup
    //   385: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   388: ldc_w 269
    //   391: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: aload_0
    //   395: getfield 199	com/facebook/orca/media/MediaCache:r	I
    //   398: sipush 1024
    //   401: idiv
    //   402: invokevirtual 210	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   405: ldc 212
    //   407: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: aload_0
    //   411: getfield 113	com/facebook/orca/media/MediaCache:d	Ljava/util/concurrent/ConcurrentMap;
    //   414: invokeinterface 205 1 0
    //   419: invokevirtual 210	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   422: ldc 214
    //   424: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   430: invokestatic 216	com/facebook/orca/debug/BLog:c	(Ljava/lang/Class;Ljava/lang/String;)V
    //   433: aload_3
    //   434: monitorexit
    //   435: goto -395 -> 40
    //
    // Exception table:
    //   from	to	target	type
    //   48	255	251	finally
    //   258	435	251	finally
  }

  private File d()
  {
    int i1 = 1;
    File localFile1 = this.p;
    if (localFile1 == null);
    for (int i2 = i1; ; i2 = 0)
    {
      if (i2 == 0)
      {
        boolean bool = localFile1.exists();
        int i3 = 0;
        if (!bool)
          i3 = i1;
        if (i3 != 0)
        {
          FbErrorReporter localFbErrorReporter = (FbErrorReporter)FbInjector.a(this.b).a(FbErrorReporter.class);
          if (localFbErrorReporter != null)
            localFbErrorReporter.a(a.getName(), "Cache directory initialized but later moved.");
        }
        i1 = i3;
      }
      if ((i2 != 0) || (i1 != 0))
      {
        File localFile2 = new File(this.b.getCacheDir(), this.i);
        if ((localFile2.exists()) && (!localFile2.isDirectory()))
          localFile2.delete();
        if (!localFile2.exists())
          localFile2.mkdirs();
        this.p = localFile2;
      }
      return this.p;
    }
  }

  private void i(KEY paramKEY)
  {
    try
    {
      File localFile = h(paramKEY);
      long l1 = this.c.a();
      if (localFile.exists())
      {
        if (l1 - localFile.lastModified() > 1800000L)
          localFile.setLastModified(l1);
      }
      else
        localFile.createNewFile();
    }
    catch (IOException localIOException)
    {
    }
  }

  protected abstract int a(VALUE paramVALUE);

  // ERROR //
  public android.net.Uri a(KEY paramKEY)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 47	com/facebook/orca/media/MediaCache:g	Ljava/lang/Object;
    //   4: astore 4
    //   6: aload 4
    //   8: monitorenter
    //   9: aload_0
    //   10: aload_1
    //   11: invokevirtual 333	com/facebook/orca/media/MediaCache:g	(Lcom/facebook/orca/media/MediaCacheKey;)Ljava/io/File;
    //   14: astore 6
    //   16: aload 6
    //   18: invokevirtual 274	java/io/File:exists	()Z
    //   21: ifeq +20 -> 41
    //   24: aload_0
    //   25: aload_1
    //   26: invokespecial 335	com/facebook/orca/media/MediaCache:i	(Lcom/facebook/orca/media/MediaCacheKey;)V
    //   29: aload 6
    //   31: invokestatic 341	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   34: astore_3
    //   35: aload 4
    //   37: monitorexit
    //   38: goto +22 -> 60
    //   41: aload 4
    //   43: monitorexit
    //   44: aconst_null
    //   45: astore_3
    //   46: goto +14 -> 60
    //   49: astore 5
    //   51: aload 4
    //   53: monitorexit
    //   54: aload 5
    //   56: athrow
    //   57: astore_2
    //   58: aconst_null
    //   59: astore_3
    //   60: aload_3
    //   61: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   9	54	49	finally
    //   0	9	57	java/io/UnsupportedEncodingException
    //   54	57	57	java/io/UnsupportedEncodingException
  }

  // ERROR //
  public File a(KEY paramKEY, java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: getfield 55	com/facebook/orca/media/MediaCache:q	Lcom/facebook/common/util/DiskUsageUtil;
    //   6: ldc2_w 343
    //   9: invokevirtual 348	com/facebook/common/util/DiskUsageUtil:a	(J)Z
    //   12: pop
    //   13: aload_0
    //   14: getfield 47	com/facebook/orca/media/MediaCache:g	Ljava/lang/Object;
    //   17: astore 5
    //   19: aload 5
    //   21: monitorenter
    //   22: aload_0
    //   23: aload_1
    //   24: invokevirtual 333	com/facebook/orca/media/MediaCache:g	(Lcom/facebook/orca/media/MediaCacheKey;)Ljava/io/File;
    //   27: astore_3
    //   28: aload_3
    //   29: invokevirtual 328	java/io/File:createNewFile	()Z
    //   32: pop
    //   33: new 350	com/facebook/orca/media/MediaCache$MyInputSupplier
    //   36: dup
    //   37: aload_2
    //   38: aconst_null
    //   39: invokespecial 353	com/facebook/orca/media/MediaCache$MyInputSupplier:<init>	(Ljava/io/InputStream;Lcom/facebook/orca/media/MediaCache$1;)V
    //   42: aload_3
    //   43: invokestatic 358	com/google/common/io/Files:a	(Lcom/google/common/io/InputSupplier;Ljava/io/File;)V
    //   46: aload_0
    //   47: aload_1
    //   48: invokespecial 335	com/facebook/orca/media/MediaCache:i	(Lcom/facebook/orca/media/MediaCacheKey;)V
    //   51: aload 5
    //   53: monitorexit
    //   54: aload_3
    //   55: areturn
    //   56: astore 9
    //   58: new 360	java/lang/RuntimeException
    //   61: dup
    //   62: aload 9
    //   64: invokespecial 363	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   67: athrow
    //   68: astore 6
    //   70: aload_3
    //   71: ifnull +8 -> 79
    //   74: aload_3
    //   75: invokevirtual 302	java/io/File:delete	()Z
    //   78: pop
    //   79: aload 6
    //   81: athrow
    //   82: astore 7
    //   84: aload 5
    //   86: monitorexit
    //   87: aload 7
    //   89: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   22	51	56	java/io/UnsupportedEncodingException
    //   22	51	68	finally
    //   58	68	68	finally
    //   51	54	82	finally
    //   74	87	82	finally
  }

  // ERROR //
  public File a(KEY paramKEY, VALUE paramVALUE)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: aload_1
    //   4: aload_2
    //   5: invokespecial 366	com/facebook/orca/media/MediaCache:b	(Lcom/facebook/orca/media/MediaCacheKey;Ljava/lang/Object;)V
    //   8: aload_0
    //   9: getfield 47	com/facebook/orca/media/MediaCache:g	Ljava/lang/Object;
    //   12: astore 4
    //   14: aload 4
    //   16: monitorenter
    //   17: aload_0
    //   18: aload_1
    //   19: invokevirtual 333	com/facebook/orca/media/MediaCache:g	(Lcom/facebook/orca/media/MediaCacheKey;)Ljava/io/File;
    //   22: astore 13
    //   24: aload 13
    //   26: astore 10
    //   28: aload 10
    //   30: invokevirtual 328	java/io/File:createNewFile	()Z
    //   33: pop
    //   34: aload_0
    //   35: aload_1
    //   36: aload_2
    //   37: aload 10
    //   39: invokevirtual 369	com/facebook/orca/media/MediaCache:a	(Lcom/facebook/orca/media/MediaCacheKey;Ljava/lang/Object;Ljava/io/File;)V
    //   42: aload_0
    //   43: aload_1
    //   44: invokespecial 335	com/facebook/orca/media/MediaCache:i	(Lcom/facebook/orca/media/MediaCacheKey;)V
    //   47: aload 4
    //   49: monitorexit
    //   50: aload 10
    //   52: areturn
    //   53: astore 12
    //   55: new 360	java/lang/RuntimeException
    //   58: dup
    //   59: aload 12
    //   61: invokespecial 363	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   64: athrow
    //   65: astore 7
    //   67: aload_3
    //   68: ifnull +8 -> 76
    //   71: aload_3
    //   72: invokevirtual 302	java/io/File:delete	()Z
    //   75: pop
    //   76: aload 7
    //   78: athrow
    //   79: astore 8
    //   81: aload 4
    //   83: monitorexit
    //   84: aload 8
    //   86: athrow
    //   87: astore 5
    //   89: aconst_null
    //   90: astore 6
    //   92: getstatic 41	com/facebook/orca/media/MediaCache:a	Ljava/lang/Class;
    //   95: ldc_w 371
    //   98: aload 5
    //   100: invokestatic 374	com/facebook/orca/debug/BLog:c	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   103: aload 6
    //   105: ifnull +9 -> 114
    //   108: aload 6
    //   110: invokevirtual 302	java/io/File:delete	()Z
    //   113: pop
    //   114: aload 4
    //   116: monitorexit
    //   117: aconst_null
    //   118: astore 10
    //   120: goto -70 -> 50
    //   123: astore 16
    //   125: aload 10
    //   127: astore_3
    //   128: aload 16
    //   130: astore 7
    //   132: goto -65 -> 67
    //   135: astore 7
    //   137: aload 6
    //   139: astore_3
    //   140: goto -73 -> 67
    //   143: astore 15
    //   145: aload 10
    //   147: astore 6
    //   149: aload 15
    //   151: astore 5
    //   153: goto -61 -> 92
    //   156: astore 14
    //   158: aload 10
    //   160: astore_3
    //   161: aload 14
    //   163: astore 12
    //   165: goto -110 -> 55
    //
    // Exception table:
    //   from	to	target	type
    //   17	24	53	java/io/UnsupportedEncodingException
    //   17	24	65	finally
    //   55	65	65	finally
    //   47	50	79	finally
    //   71	84	79	finally
    //   108	117	79	finally
    //   17	24	87	java/io/IOException
    //   28	47	123	finally
    //   92	103	135	finally
    //   28	47	143	java/io/IOException
    //   28	47	156	java/io/UnsupportedEncodingException
  }

  protected abstract VALUE a(KEY paramKEY, File paramFile);

  // ERROR //
  public void a()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: invokespecial 141	com/facebook/orca/media/MediaCache:d	()Ljava/io/File;
    //   6: astore_2
    //   7: aload_2
    //   8: new 377	com/facebook/orca/media/MediaCache$1
    //   11: dup
    //   12: aload_0
    //   13: invokespecial 378	com/facebook/orca/media/MediaCache$1:<init>	(Lcom/facebook/orca/media/MediaCache;)V
    //   16: invokevirtual 382	java/io/File:listFiles	(Ljava/io/FilenameFilter;)[Ljava/io/File;
    //   19: astore_3
    //   20: aload_3
    //   21: arraylength
    //   22: istore 4
    //   24: iconst_0
    //   25: istore 5
    //   27: iload 5
    //   29: iload 4
    //   31: if_icmpge +64 -> 95
    //   34: aload_3
    //   35: iload 5
    //   37: aaload
    //   38: astore 15
    //   40: aload_0
    //   41: getfield 47	com/facebook/orca/media/MediaCache:g	Ljava/lang/Object;
    //   44: astore 16
    //   46: aload 16
    //   48: monitorenter
    //   49: aload_0
    //   50: aload 15
    //   52: ldc_w 384
    //   55: invokespecial 386	com/facebook/orca/media/MediaCache:a	(Ljava/io/File;Ljava/lang/String;)Ljava/io/File;
    //   58: astore 18
    //   60: aload 18
    //   62: invokevirtual 274	java/io/File:exists	()Z
    //   65: istore 19
    //   67: iload 19
    //   69: ifne +9 -> 78
    //   72: aload 18
    //   74: invokevirtual 328	java/io/File:createNewFile	()Z
    //   77: pop
    //   78: aload 16
    //   80: monitorexit
    //   81: iinc 5 1
    //   84: goto -57 -> 27
    //   87: astore 17
    //   89: aload 16
    //   91: monitorexit
    //   92: aload 17
    //   94: athrow
    //   95: aload_2
    //   96: new 388	com/facebook/orca/media/MediaCache$2
    //   99: dup
    //   100: aload_0
    //   101: invokespecial 389	com/facebook/orca/media/MediaCache$2:<init>	(Lcom/facebook/orca/media/MediaCache;)V
    //   104: invokevirtual 382	java/io/File:listFiles	(Ljava/io/FilenameFilter;)[Ljava/io/File;
    //   107: astore 6
    //   109: aload_0
    //   110: getfield 53	com/facebook/orca/media/MediaCache:c	Lcom/facebook/orca/common/util/Clock;
    //   113: invokeinterface 316 1 0
    //   118: lstore 7
    //   120: aload 6
    //   122: arraylength
    //   123: istore 9
    //   125: iload_1
    //   126: iload 9
    //   128: if_icmpge +75 -> 203
    //   131: aload 6
    //   133: iload_1
    //   134: aaload
    //   135: astore 10
    //   137: aload_0
    //   138: getfield 47	com/facebook/orca/media/MediaCache:g	Ljava/lang/Object;
    //   141: astore 11
    //   143: aload 11
    //   145: monitorenter
    //   146: lload 7
    //   148: aload 10
    //   150: invokevirtual 319	java/io/File:lastModified	()J
    //   153: lsub
    //   154: ldc2_w 390
    //   157: lcmp
    //   158: ifle +23 -> 181
    //   161: aload_0
    //   162: aload 10
    //   164: aload_0
    //   165: getfield 66	com/facebook/orca/media/MediaCache:j	Ljava/lang/String;
    //   168: invokespecial 386	com/facebook/orca/media/MediaCache:a	(Ljava/io/File;Ljava/lang/String;)Ljava/io/File;
    //   171: invokevirtual 302	java/io/File:delete	()Z
    //   174: pop
    //   175: aload 10
    //   177: invokevirtual 302	java/io/File:delete	()Z
    //   180: pop
    //   181: aload 11
    //   183: monitorexit
    //   184: iinc 1 1
    //   187: goto -62 -> 125
    //   190: astore 12
    //   192: aload 11
    //   194: monitorexit
    //   195: aload 12
    //   197: athrow
    //   198: astore 20
    //   200: goto -122 -> 78
    //   203: return
    //
    // Exception table:
    //   from	to	target	type
    //   49	67	87	finally
    //   72	78	87	finally
    //   78	92	87	finally
    //   146	195	190	finally
    //   72	78	198	java/io/IOException
  }

  public void a(KEY paramKEY, long paramLong)
  {
    this.f.put(paramKEY, Long.valueOf(paramLong + this.c.a()));
  }

  protected abstract void a(KEY paramKEY, VALUE paramVALUE, File paramFile);

  public VALUE b(KEY paramKEY)
  {
    Object localObject;
    if (!this.k)
    {
      BLog.a(a, "The in-memory cached for " + this.i + " is disabled.");
      localObject = null;
    }
    while (true)
    {
      return localObject;
      MediaCache.InMemoryCachedValue localInMemoryCachedValue = (MediaCache.InMemoryCachedValue)this.d.get(paramKEY);
      if (localInMemoryCachedValue != null)
      {
        localInMemoryCachedValue.a();
        localObject = MediaCache.InMemoryCachedValue.a(localInMemoryCachedValue);
      }
      else
      {
        localObject = this.e.get(paramKEY);
        if (localObject != null)
          b(paramKEY, localObject);
        else
          localObject = null;
      }
    }
  }

  public void b()
  {
    if (!this.k);
    while (true)
    {
      return;
      synchronized (this.h)
      {
        this.d.clear();
        this.e.clear();
        this.r = 0;
      }
    }
  }

  public void c()
  {
    b();
    File[] arrayOfFile = d().listFiles();
    if (arrayOfFile != null)
    {
      int i1 = arrayOfFile.length;
      for (int i2 = 0; i2 < i1; i2++)
        arrayOfFile[i2].delete();
    }
  }

  public boolean c(KEY paramKEY)
  {
    try
    {
      if (!d(paramKEY))
      {
        boolean bool2 = g(paramKEY).exists();
        bool1 = false;
        if (!bool2);
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      while (true)
        boolean bool1 = false;
    }
  }

  boolean d(KEY paramKEY)
  {
    if (!this.k);
    for (boolean bool = false; ; bool = this.d.containsKey(paramKEY))
      return bool;
  }

  public VALUE e(KEY paramKEY)
  {
    Object localObject1 = b(paramKEY);
    if (localObject1 != null)
      i(paramKEY);
    while (true)
    {
      return localObject1;
      try
      {
        localFile = g(paramKEY);
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        synchronized (this.g)
        {
          File localFile;
          if (localFile.exists())
            i(paramKEY);
          if (!localFile.exists())
            break label99;
          localObject1 = a(paramKEY, localFile);
          if (localObject1 == null)
            break label99;
          b(paramKEY, localObject1);
          continue;
          localUnsupportedEncodingException = localUnsupportedEncodingException;
          localObject1 = null;
        }
      }
      catch (IOException localIOException)
      {
        localObject1 = null;
      }
      continue;
      label99: localObject1 = null;
    }
  }

  public boolean f(KEY paramKEY)
  {
    Long localLong = (Long)this.f.get(paramKEY);
    boolean bool;
    if (localLong == null)
      bool = false;
    while (true)
    {
      return bool;
      if (this.c.a() < localLong.longValue())
      {
        bool = true;
      }
      else
      {
        this.f.remove(paramKEY, localLong);
        bool = false;
      }
    }
  }

  File g(KEY paramKEY)
  {
    return a(paramKEY, this.j);
  }

  File h(KEY paramKEY)
  {
    return a(paramKEY, ".lru");
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.media.MediaCache
 * JD-Core Version:    0.6.2
 */