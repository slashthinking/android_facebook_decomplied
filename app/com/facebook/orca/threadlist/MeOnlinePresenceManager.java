package com.facebook.orca.threadlist;

import com.facebook.orca.cache.DataCache;
import com.facebook.orca.ops.OrcaServiceOperation;
import javax.inject.Provider;

public class MeOnlinePresenceManager
{
  private final OrcaServiceOperation a;
  private final OrcaServiceOperation b;
  private final DataCache c;
  private boolean d = false;

  public MeOnlinePresenceManager(Provider<OrcaServiceOperation> paramProvider, DataCache paramDataCache)
  {
    this.a = ((OrcaServiceOperation)paramProvider.b());
    this.a.a(true);
    this.b = ((OrcaServiceOperation)paramProvider.b());
    this.b.a(true);
    this.c = paramDataCache;
    MeOnlinePresenceManager.1 local1 = new MeOnlinePresenceManager.1(this);
    this.b.a(local1);
    this.a.a(local1);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadlist.MeOnlinePresenceManager
 * JD-Core Version:    0.6.0
 */