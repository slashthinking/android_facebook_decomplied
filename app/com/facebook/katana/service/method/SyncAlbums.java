package com.facebook.katana.service.method;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.facebook.katana.Constants.URL;
import com.facebook.katana.model.FacebookAlbum;
import com.facebook.katana.util.Factory;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SyncAlbums extends ApiMethod
{
  private final Map<String, FacebookAlbum> a = new HashMap();
  private boolean b;
  private final Intent f;
  private final String g;
  private final long h;
  private final String[] i;

  public SyncAlbums(Context paramContext, Intent paramIntent, String paramString, long paramLong, String[] paramArrayOfString, ServiceOperationListener paramServiceOperationListener)
  {
    super(paramContext, paramIntent, "GET", null, Constants.URL.b(paramContext), null);
    this.f = paramIntent;
    this.g = paramString;
    this.h = paramLong;
    this.i = paramArrayOfString;
    this.q = paramServiceOperationListener;
    this.b = true;
  }

  protected static Factory<Cursor> a(ContentResolver paramContentResolver, long paramLong, Collection<FacebookAlbum> paramCollection)
  {
    return new SyncAlbums.1(paramLong, paramContentResolver, paramCollection);
  }

  protected static void a(ContentResolver paramContentResolver, long paramLong, Collection<FacebookAlbum> paramCollection, boolean paramBoolean)
  {
    AlbumSyncModel.a(paramContentResolver, paramCollection, a(paramContentResolver, paramLong, paramCollection), true, true, paramBoolean, false, paramLong);
  }

  protected static boolean a(long paramLong, String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0));
    for (int j = 1; ; j = 0)
      return j;
  }

  private static boolean b(long paramLong)
  {
    if (-1L == paramLong);
    for (int j = 1; ; j = 0)
      return j;
  }

  public void b()
  {
    long l = -1L;
    if (a(this.h, this.i))
      l = 10L;
    new FqlGetAlbums(this.o, this.p, this.g, this.h, this.i, new SyncAlbums.SyncAlbumsListener(this), 0L, l).b();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.SyncAlbums
 * JD-Core Version:    0.6.0
 */