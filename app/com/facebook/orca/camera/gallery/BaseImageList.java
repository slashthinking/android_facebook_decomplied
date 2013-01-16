package com.facebook.orca.camera.gallery;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import com.facebook.orca.camera.Util;
import com.facebook.orca.debug.BLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class BaseImageList
  implements IImageList
{
  private static final Class<?> h = BaseImageList.class;
  private static final Pattern j = Pattern.compile("(.*)/\\d+");
  protected ContentResolver a;
  protected int b;
  protected Uri c;
  protected Cursor d;
  protected String e;
  protected Uri f;
  protected boolean g = false;
  private final LruCache<Integer, BaseImage> i = new LruCache(512);

  public BaseImageList(ContentResolver paramContentResolver, Uri paramUri, int paramInt, String paramString)
  {
    this.b = paramInt;
    this.c = paramUri;
    this.e = paramString;
    this.a = paramContentResolver;
    this.d = d();
    if (this.d == null)
      BLog.d(h, "createCursor returns null.");
    this.i.a();
  }

  private static String b(Uri paramUri)
  {
    String str = paramUri.getPath();
    Matcher localMatcher = j.matcher(str);
    if (localMatcher.matches())
      str = localMatcher.group(1);
    return str;
  }

  private boolean c(Uri paramUri)
  {
    Uri localUri = this.c;
    if ((Util.a(localUri.getScheme(), paramUri.getScheme())) && (Util.a(localUri.getHost(), paramUri.getHost())) && (Util.a(localUri.getAuthority(), paramUri.getAuthority())) && (Util.a(localUri.getPath(), b(paramUri))));
    for (int k = 1; ; k = 0)
      return k;
  }

  private Cursor g()
  {
    monitorenter;
    Cursor localCursor;
    try
    {
      if (this.d == null)
      {
        monitorexit;
        localCursor = null;
      }
      else
      {
        if (this.g)
        {
          this.d.requery();
          this.g = false;
        }
        localCursor = this.d;
        monitorexit;
      }
    }
    finally
    {
      localObject = finally;
      monitorexit;
      throw localObject;
    }
    return localCursor;
  }

  public Uri a(long paramLong)
  {
    try
    {
      if (ContentUris.parseId(this.c) != paramLong)
        BLog.e(h, "id mismatch");
      localUri = this.c;
      return localUri;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (true)
        Uri localUri = ContentUris.withAppendedId(this.c, paramLong);
    }
  }

  protected abstract BaseImage a(Cursor paramCursor);

  public IImage a(int paramInt)
  {
    BaseImage localBaseImage = (BaseImage)this.i.a(Integer.valueOf(paramInt));
    Cursor localCursor;
    if (localBaseImage == null)
    {
      localCursor = g();
      if (localCursor == null)
        localBaseImage = null;
    }
    else
    {
      return localBaseImage;
    }
    monitorenter;
    while (true)
    {
      try
      {
        if (localCursor.moveToPosition(paramInt))
        {
          localBaseImage = a(localCursor);
          this.i.a(Integer.valueOf(paramInt), localBaseImage);
          monitorexit;
          break;
        }
      }
      finally
      {
        localObject = finally;
        monitorexit;
        throw localObject;
      }
      localBaseImage = null;
    }
  }

  // ERROR //
  public IImage a(Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 163	com/facebook/orca/camera/gallery/BaseImageList:c	(Landroid/net/Uri;)Z
    //   5: istore_2
    //   6: aconst_null
    //   7: astore_3
    //   8: iload_2
    //   9: ifne +5 -> 14
    //   12: aload_3
    //   13: areturn
    //   14: aload_1
    //   15: invokestatic 128	android/content/ContentUris:parseId	(Landroid/net/Uri;)J
    //   18: lstore 5
    //   20: aload_0
    //   21: invokespecial 151	com/facebook/orca/camera/gallery/BaseImageList:g	()Landroid/database/Cursor;
    //   24: astore 7
    //   26: aconst_null
    //   27: astore_3
    //   28: aload 7
    //   30: ifnull -18 -> 12
    //   33: aload_0
    //   34: monitorenter
    //   35: aload 7
    //   37: iconst_m1
    //   38: invokeinterface 155 2 0
    //   43: pop
    //   44: iconst_0
    //   45: istore 10
    //   47: aload 7
    //   49: invokeinterface 166 1 0
    //   54: ifeq +108 -> 162
    //   57: aload_0
    //   58: aload 7
    //   60: invokevirtual 169	com/facebook/orca/camera/gallery/BaseImageList:b	(Landroid/database/Cursor;)J
    //   63: lload 5
    //   65: lcmp
    //   66: ifne +90 -> 156
    //   69: aload_0
    //   70: getfield 52	com/facebook/orca/camera/gallery/BaseImageList:i	Lcom/facebook/orca/camera/gallery/LruCache;
    //   73: iload 10
    //   75: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   78: invokevirtual 147	com/facebook/orca/camera/gallery/LruCache:a	(Ljava/lang/Object;)Ljava/lang/Object;
    //   81: checkcast 149	com/facebook/orca/camera/gallery/BaseImage
    //   84: astore_3
    //   85: aload_3
    //   86: ifnonnull +24 -> 110
    //   89: aload_0
    //   90: aload 7
    //   92: invokevirtual 157	com/facebook/orca/camera/gallery/BaseImageList:a	(Landroid/database/Cursor;)Lcom/facebook/orca/camera/gallery/BaseImage;
    //   95: astore_3
    //   96: aload_0
    //   97: getfield 52	com/facebook/orca/camera/gallery/BaseImageList:i	Lcom/facebook/orca/camera/gallery/LruCache;
    //   100: iload 10
    //   102: invokestatic 144	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   105: aload_3
    //   106: invokevirtual 160	com/facebook/orca/camera/gallery/LruCache:a	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   109: pop
    //   110: aload_0
    //   111: monitorexit
    //   112: goto -100 -> 12
    //   115: astore 8
    //   117: aload_0
    //   118: monitorexit
    //   119: aload 8
    //   121: athrow
    //   122: astore 4
    //   124: getstatic 31	com/facebook/orca/camera/gallery/BaseImageList:h	Ljava/lang/Class;
    //   127: new 171	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 172	java/lang/StringBuilder:<init>	()V
    //   134: ldc 174
    //   136: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload_1
    //   140: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: aload 4
    //   148: invokestatic 187	com/facebook/orca/debug/BLog:c	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   151: aconst_null
    //   152: astore_3
    //   153: goto -141 -> 12
    //   156: iinc 10 1
    //   159: goto -112 -> 47
    //   162: aload_0
    //   163: monitorexit
    //   164: aconst_null
    //   165: astore_3
    //   166: goto -154 -> 12
    //
    // Exception table:
    //   from	to	target	type
    //   35	119	115	finally
    //   162	164	115	finally
    //   14	20	122	java/lang/NumberFormatException
  }

  public void a()
  {
    try
    {
      e();
      this.a = null;
      if (this.d != null)
      {
        this.d.close();
        this.d = null;
      }
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      while (true)
        BLog.e(h, "Caught exception while deactivating cursor.", localIllegalStateException);
    }
  }

  public int b()
  {
    Cursor localCursor = g();
    int k;
    if (localCursor == null)
      k = 0;
    while (true)
    {
      return k;
      monitorenter;
      try
      {
        k = localCursor.getCount();
        monitorexit;
        continue;
      }
      finally
      {
        localObject = finally;
        monitorexit;
      }
    }
    throw localObject;
  }

  protected abstract long b(Cursor paramCursor);

  public boolean c()
  {
    if (b() == 0);
    for (int k = 1; ; k = 0)
      return k;
  }

  protected abstract Cursor d();

  protected void e()
  {
    if (this.d == null);
    while (true)
    {
      return;
      this.d.deactivate();
      this.g = true;
    }
  }

  protected String f()
  {
    if (this.b == 1);
    for (String str = " ASC"; ; str = " DESC")
      return "case ifnull(datetaken,0) when 0 then date_modified*1000 else datetaken end" + str + ", _id" + str;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.camera.gallery.BaseImageList
 * JD-Core Version:    0.6.0
 */