package com.facebook.katana.features.uberbar;

import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.uberbar.resolvers.LocalUberbarResultResolver;

class UberbarResultFetcherFactory
{
  private final LocalUberbarResultResolver a;
  private final LocalUberbarResultResolver b;
  private final AndroidThreadUtil c;
  private final OrcaServiceOperationFactory d;

  public UberbarResultFetcherFactory(LocalUberbarResultResolver paramLocalUberbarResultResolver1, LocalUberbarResultResolver paramLocalUberbarResultResolver2, AndroidThreadUtil paramAndroidThreadUtil, OrcaServiceOperationFactory paramOrcaServiceOperationFactory)
  {
    this.a = paramLocalUberbarResultResolver1;
    this.b = paramLocalUberbarResultResolver2;
    this.c = paramAndroidThreadUtil;
    this.d = paramOrcaServiceOperationFactory;
  }

  public UberbarResultFetcher a(int paramInt, String paramString)
  {
    return new UberbarResultFetcher(this.a, this.b, this.c, this.d, paramInt, paramString);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.uberbar.UberbarResultFetcherFactory
 * JD-Core Version:    0.6.0
 */