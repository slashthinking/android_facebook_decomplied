package com.facebook.uberbar.module;

import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.base.SingleMethodRunner;
import com.facebook.uberbar.api.FetchUberbarResultMethod;
import com.facebook.uberbar.api.UberbarServiceHandler;

class UberbarModule$UberbarServiceHandlerProvider extends AbstractProvider<UberbarServiceHandler>
{
  private UberbarModule$UberbarServiceHandlerProvider(UberbarModule paramUberbarModule)
  {
  }

  public UberbarServiceHandler a()
  {
    return new UberbarServiceHandler((FetchUberbarResultMethod)b(FetchUberbarResultMethod.class), a(SingleMethodRunner.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.uberbar.module.UberbarModule.UberbarServiceHandlerProvider
 * JD-Core Version:    0.6.2
 */