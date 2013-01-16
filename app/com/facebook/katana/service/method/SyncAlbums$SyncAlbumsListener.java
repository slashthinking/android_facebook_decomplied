package com.facebook.katana.service.method;

import android.content.Context;
import com.facebook.katana.model.FacebookAlbum;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SyncAlbums$SyncAlbumsListener
  implements ServiceOperationListener
{
  private boolean b;

  protected SyncAlbums$SyncAlbumsListener(SyncAlbums paramSyncAlbums)
  {
  }

  public void a(ServiceOperation paramServiceOperation, long paramLong1, long paramLong2)
  {
    this.a.q.a(paramServiceOperation, paramLong1, paramLong2);
  }

  public void a_(ServiceOperation paramServiceOperation, int paramInt, String paramString, Exception paramException)
  {
    if (this.b)
      this.a.q.a_(paramServiceOperation, paramInt, paramString, paramException);
  }

  public void b(ServiceOperation paramServiceOperation, int paramInt, String paramString, Exception paramException)
  {
    SyncAlbums localSyncAlbums = this.a;
    boolean bool;
    List localList;
    if ((SyncAlbums.a(this.a)) && (paramInt == 200))
    {
      bool = true;
      SyncAlbums.a(localSyncAlbums, bool);
      localList = ((FqlGetAlbums)paramServiceOperation).a;
      if ((localList != null) && (localList.size() != 0) && (SyncAlbums.b(this.a).size() + localList.size() < 70L) && (SyncAlbums.a(this.a)))
        break label168;
      this.b = true;
      if (SyncAlbums.a(this.a))
        SyncAlbums.a(this.a.o.getContentResolver(), SyncAlbums.c(this.a), SyncAlbums.b(this.a).values(), true);
      this.a.q.b(paramServiceOperation, paramInt, paramString, paramException);
    }
    while (true)
    {
      return;
      bool = false;
      break;
      label168: SyncAlbums.a(this.a.o.getContentResolver(), SyncAlbums.c(this.a), localList, false);
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        FacebookAlbum localFacebookAlbum = (FacebookAlbum)localIterator.next();
        SyncAlbums.b(this.a).put(localFacebookAlbum.a(), localFacebookAlbum);
      }
      long l1 = SyncAlbums.b(this.a).size();
      if ((SyncAlbums.b(this.a).containsKey(FqlGetTaggedUserAlbum.a(SyncAlbums.c(this.a)))) && (SyncAlbums.b(this.a).size() > 1))
        l1 -= 1L;
      long l2 = -1L;
      if (l1 < 70L)
        l2 = 20L;
      new FqlGetAlbums(this.a.o, SyncAlbums.d(this.a), SyncAlbums.e(this.a), SyncAlbums.c(this.a), SyncAlbums.f(this.a), this, l1, l2).b();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.SyncAlbums.SyncAlbumsListener
 * JD-Core Version:    0.6.0
 */