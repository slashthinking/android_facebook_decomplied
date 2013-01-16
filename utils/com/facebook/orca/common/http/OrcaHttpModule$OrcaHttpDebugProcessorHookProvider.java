package com.facebook.orca.common.http;

import com.facebook.common.util.NetAccessLogger;
import com.facebook.orca.inject.AbstractProvider;

class OrcaHttpModule$OrcaHttpDebugProcessorHookProvider extends AbstractProvider<OrcaHttpDebugProcessorHook>
{
  private OrcaHttpModule$OrcaHttpDebugProcessorHookProvider(OrcaHttpModule paramOrcaHttpModule)
  {
  }

  public OrcaHttpDebugProcessorHook a()
  {
    return new OrcaHttpDebugProcessorHook((NetAccessLogger)b(NetAccessLogger.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.http.OrcaHttpModule.OrcaHttpDebugProcessorHookProvider
 * JD-Core Version:    0.6.2
 */