package com.facebook.katana.service.method;

import android.content.ContentResolver;
import android.database.Cursor;
import com.facebook.katana.util.Factory;
import java.util.Collection;

final class SyncAlbums$1
  implements Factory<Cursor>
{
  public Cursor a()
  {
    if (SyncAlbums.a(this.a));
    for (Cursor localCursor = AlbumSyncModel.a(this.b, this.c); ; localCursor = AlbumSyncModel.a(this.b, this.a))
      return localCursor;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.SyncAlbums.1
 * JD-Core Version:    0.6.0
 */