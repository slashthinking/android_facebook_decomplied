package com.facebook.katana.features.uberbar;

import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.uberbar.annotations.FriendsResolver;
import com.facebook.uberbar.annotations.PagesResolver;
import com.facebook.uberbar.resolvers.LocalUberbarResultResolver;

class UberbarFB4AModule$UberbarResultFetcherFactoryProvider extends AbstractProvider<UberbarResultFetcherFactory>
{
  private UberbarFB4AModule$UberbarResultFetcherFactoryProvider(UberbarFB4AModule paramUberbarFB4AModule)
  {
  }

  public UberbarResultFetcherFactory a()
  {
    return new UberbarResultFetcherFactory((LocalUberbarResultResolver)b(LocalUberbarResultResolver.class, FriendsResolver.class), (LocalUberbarResultResolver)b(LocalUberbarResultResolver.class, PagesResolver.class), (AndroidThreadUtil)b(AndroidThreadUtil.class), (OrcaServiceOperationFactory)b(OrcaServiceOperationFactory.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.uberbar.UberbarFB4AModule.UberbarResultFetcherFactoryProvider
 * JD-Core Version:    0.6.0
 */