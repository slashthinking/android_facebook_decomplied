package com.facebook.uberbar.module;

import android.content.Context;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.uberbar.resolvers.LocalUberbarResultResolver;
import com.facebook.uberbar.resolvers.PagesLocalUberbarResultResolverFactory;

class UberbarModule$PagesLocalUberbarResultResolverProvider extends AbstractProvider<LocalUberbarResultResolver>
{
  private UberbarModule$PagesLocalUberbarResultResolverProvider(UberbarModule paramUberbarModule)
  {
  }

  public LocalUberbarResultResolver a()
  {
    return PagesLocalUberbarResultResolverFactory.a(UberbarModule.a(this.a).getContentResolver(), (AndroidThreadUtil)b(AndroidThreadUtil.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.uberbar.module.UberbarModule.PagesLocalUberbarResultResolverProvider
 * JD-Core Version:    0.6.2
 */