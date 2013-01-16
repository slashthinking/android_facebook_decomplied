package com.facebook.megaphone.module;

import com.facebook.common.util.FbErrorReporter;
import com.facebook.megaphone.data.MegaphoneStore;
import com.facebook.megaphone.fetcher.MegaphoneFetcher;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.inject.AbstractProvider;

class MegaphoneModule$MegaphoneStoreProvider extends AbstractProvider<MegaphoneStore>
{
  private MegaphoneModule$MegaphoneStoreProvider(MegaphoneModule paramMegaphoneModule)
  {
  }

  public MegaphoneStore a()
  {
    return new MegaphoneStore((Clock)b(Clock.class), (MegaphoneFetcher)b(MegaphoneFetcher.class), (FbErrorReporter)b(FbErrorReporter.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.megaphone.module.MegaphoneModule.MegaphoneStoreProvider
 * JD-Core Version:    0.6.2
 */