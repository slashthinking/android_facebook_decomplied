package com.facebook.megaphone.module;

import com.facebook.megaphone.api.FetchMegaphoneMethod;
import com.facebook.megaphone.api.LogMegaphoneMethod;
import com.facebook.megaphone.api.MegaphoneServiceHandler;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.protocol.base.SingleMethodRunner;

class MegaphoneModule$MegaphoneServiceHandlerProvider extends AbstractProvider<MegaphoneServiceHandler>
{
  private MegaphoneModule$MegaphoneServiceHandlerProvider(MegaphoneModule paramMegaphoneModule)
  {
  }

  public MegaphoneServiceHandler a()
  {
    return new MegaphoneServiceHandler(a(SingleMethodRunner.class), (FetchMegaphoneMethod)b(FetchMegaphoneMethod.class), (LogMegaphoneMethod)b(LogMegaphoneMethod.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.megaphone.module.MegaphoneModule.MegaphoneServiceHandlerProvider
 * JD-Core Version:    0.6.2
 */