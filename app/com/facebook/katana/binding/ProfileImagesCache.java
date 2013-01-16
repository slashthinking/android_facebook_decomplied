package com.facebook.katana.binding;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import com.facebook.common.util.ErrorReporting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProfileImagesCache
{
  private final Map<Long, ProfileImage> a = new HashMap();
  private final ProfileImagesCache.ProfileImagesContainerListener b;
  private final List<ProfileImage> c = new ArrayList();
  private final Map<Long, String> d = new HashMap();
  private final Map<Long, ProfileImage> e = new HashMap();
  private WorkerThread f;

  protected ProfileImagesCache(ProfileImagesCache.ProfileImagesContainerListener paramProfileImagesContainerListener)
  {
    this.b = paramProfileImagesContainerListener;
  }

  private void a(Context paramContext, ProfileImage paramProfileImage, ProfileImagesCache.ProfileImagesContainerListener paramProfileImagesContainerListener)
  {
    long l = paramProfileImage.a;
    if (this.e.containsKey(Long.valueOf(l)));
    while (true)
    {
      return;
      if (this.f == null)
      {
        ErrorReporting.a("ProfileImagesCache", "mLoaderThread not loaded");
        continue;
      }
      if (l <= 0L)
      {
        ErrorReporting.a("ProfileImagesCache", "invalid profileid: " + l);
        continue;
      }
      this.e.put(Long.valueOf(l), paramProfileImage);
      this.f.a().post(new ProfileImagesCache.4(this, paramContext, l, paramProfileImage, paramProfileImagesContainerListener));
    }
  }

  // ERROR //
  private static Bitmap b(Context paramContext, long paramLong)
  {
    // Byte code:
    //   0: getstatic 114	com/facebook/ipc/connections/ConnectionsContract:c	Landroid/net/Uri;
    //   3: lload_1
    //   4: invokestatic 119	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   7: invokestatic 125	android/net/Uri:withAppendedPath	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   10: astore 7
    //   12: aload_0
    //   13: invokevirtual 131	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   16: aload 7
    //   18: getstatic 136	com/facebook/katana/binding/ProfileImagesCache$ImagesQuery:a	[Ljava/lang/String;
    //   21: aconst_null
    //   22: aconst_null
    //   23: aconst_null
    //   24: invokevirtual 142	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   27: astore 8
    //   29: aload 8
    //   31: astore 4
    //   33: aload 4
    //   35: ifnull +17 -> 52
    //   38: aload 4
    //   40: invokeinterface 148 1 0
    //   45: istore 9
    //   47: iload 9
    //   49: ifne +21 -> 70
    //   52: aload 4
    //   54: ifnull +10 -> 64
    //   57: aload 4
    //   59: invokeinterface 151 1 0
    //   64: aconst_null
    //   65: astore 6
    //   67: aload 6
    //   69: areturn
    //   70: aload 4
    //   72: aload 4
    //   74: ldc 153
    //   76: invokeinterface 157 2 0
    //   81: invokeinterface 161 2 0
    //   86: astore 10
    //   88: aload 10
    //   90: ifnonnull +21 -> 111
    //   93: aload 4
    //   95: ifnull +10 -> 105
    //   98: aload 4
    //   100: invokeinterface 151 1 0
    //   105: aconst_null
    //   106: astore 6
    //   108: goto -41 -> 67
    //   111: aload 10
    //   113: invokestatic 166	com/facebook/katana/util/ImageUtils:b	([B)Landroid/graphics/Bitmap;
    //   116: astore 11
    //   118: aload 11
    //   120: astore 6
    //   122: aload 4
    //   124: ifnull -57 -> 67
    //   127: aload 4
    //   129: invokeinterface 151 1 0
    //   134: goto -67 -> 67
    //   137: astore 5
    //   139: aconst_null
    //   140: astore 4
    //   142: ldc 168
    //   144: ldc 170
    //   146: aload 5
    //   148: invokestatic 175	com/facebook/common/util/Log:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   151: aload 4
    //   153: ifnull +10 -> 163
    //   156: aload 4
    //   158: invokeinterface 151 1 0
    //   163: aconst_null
    //   164: astore 6
    //   166: goto -99 -> 67
    //   169: astore_3
    //   170: aconst_null
    //   171: astore 4
    //   173: aload 4
    //   175: ifnull +10 -> 185
    //   178: aload 4
    //   180: invokeinterface 151 1 0
    //   185: aload_3
    //   186: athrow
    //   187: astore_3
    //   188: goto -15 -> 173
    //   191: astore 5
    //   193: goto -51 -> 142
    //
    // Exception table:
    //   from	to	target	type
    //   0	29	137	com/facebook/katana/util/ImageUtils$ImageException
    //   0	29	169	finally
    //   38	47	187	finally
    //   70	88	187	finally
    //   111	118	187	finally
    //   142	151	187	finally
    //   38	47	191	com/facebook/katana/util/ImageUtils$ImageException
    //   70	88	191	com/facebook/katana/util/ImageUtils$ImageException
    //   111	118	191	com/facebook/katana/util/ImageUtils$ImageException
  }

  private void b()
  {
    this.c.addAll(this.a.values());
    Collections.sort(this.c, new ProfileImagesCache.2(this));
    int i = Math.min(this.c.size(), 5);
    for (int j = 0; j < i; j++)
    {
      ProfileImage localProfileImage = (ProfileImage)this.c.get(j);
      this.a.remove(Long.valueOf(localProfileImage.a));
    }
    this.c.clear();
  }

  public Bitmap a(Context paramContext, long paramLong, String paramString)
  {
    ProfileImage localProfileImage = (ProfileImage)this.a.get(Long.valueOf(paramLong));
    Bitmap localBitmap2;
    Bitmap localBitmap1;
    if ((paramString != null) && (paramString.length() > 0))
      if (localProfileImage != null)
        if (localProfileImage.b.equals(paramString))
        {
          localBitmap2 = localProfileImage.c();
          if (localBitmap2 == null)
          {
            a(paramContext, localProfileImage, this.b);
            localBitmap1 = localBitmap2;
          }
        }
    while (true)
    {
      return localBitmap1;
      localProfileImage.b();
      localBitmap1 = localBitmap2;
      continue;
      if (!this.d.containsKey(Long.valueOf(paramLong)))
      {
        this.b.a(paramContext, paramLong, paramString);
        this.d.put(Long.valueOf(paramLong), paramString);
        localBitmap1 = null;
        continue;
        a(paramContext, new ProfileImage(paramLong, paramString, null), this.b);
        localBitmap1 = null;
        continue;
        if (localProfileImage != null)
          this.a.remove(Long.valueOf(paramLong));
      }
      localBitmap1 = null;
    }
  }

  protected ProfileImage a(Context paramContext, int paramInt, long paramLong, ProfileImage paramProfileImage)
  {
    if (paramInt == 200)
    {
      if (this.a.size() >= 75L)
        b();
      this.a.put(Long.valueOf(paramLong), paramProfileImage);
    }
    this.d.remove(Long.valueOf(paramLong));
    return paramProfileImage;
  }

  protected void a()
  {
    this.a.clear();
    this.d.clear();
    this.e.clear();
    this.f = null;
  }

  protected void a(Context paramContext, WorkerThread paramWorkerThread)
  {
    this.f = paramWorkerThread;
  }

  public void a(Context paramContext, Map<Long, String> paramMap)
  {
    this.d.putAll(paramMap);
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      this.b.a(paramContext, localLong.longValue(), (String)paramMap.get(localLong));
    }
  }

  public void a(AppSession paramAppSession, Context paramContext, Map<Long, String> paramMap)
  {
    if (!paramAppSession.c(new ProfileImagesCache.1(this, paramContext, paramMap)))
      a(paramContext, paramMap);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.binding.ProfileImagesCache
 * JD-Core Version:    0.6.0
 */