package com.facebook.megaphone.module;

import com.facebook.megaphone.api.MegaphoneServiceHandler;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.server.OrcaServiceHandler;

class MegaphoneModule$OrcaServiceHandlerForMegaphoneQueueProvider extends AbstractProvider<OrcaServiceHandler>
{
  private MegaphoneModule$OrcaServiceHandlerForMegaphoneQueueProvider(MegaphoneModule paramMegaphoneModule)
  {
  }

  public OrcaServiceHandler a()
  {
    return (OrcaServiceHandler)b(MegaphoneServiceHandler.class);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.megaphone.module.MegaphoneModule.OrcaServiceHandlerForMegaphoneQueueProvider
 * JD-Core Version:    0.6.2
 */