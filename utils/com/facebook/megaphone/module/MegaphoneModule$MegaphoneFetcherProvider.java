package com.facebook.megaphone.module;

import com.facebook.common.util.FbErrorReporter;
import com.facebook.megaphone.api.FetchMegaphoneMethod;
import com.facebook.megaphone.fetcher.MegaphoneFetcher;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.ops.OrcaServiceOperationFactory;

class MegaphoneModule$MegaphoneFetcherProvider extends AbstractProvider<MegaphoneFetcher>
{
  private MegaphoneModule$MegaphoneFetcherProvider(MegaphoneModule paramMegaphoneModule)
  {
  }

  public MegaphoneFetcher a()
  {
    return new MegaphoneFetcher((FetchMegaphoneMethod)b(FetchMegaphoneMethod.class), a(OrcaServiceOperationFactory.class), (FbErrorReporter)b(FbErrorReporter.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.megaphone.module.MegaphoneModule.MegaphoneFetcherProvider
 * JD-Core Version:    0.6.2
 */