package com.facebook.orca.common.http;

import com.facebook.orca.inject.AbstractProvider;

class OrcaHttpModule$OrcaHttpRequestProcessorProvider extends AbstractProvider<OrcaHttpRequestProcessor>
{
  private OrcaHttpModule$OrcaHttpRequestProcessorProvider(OrcaHttpModule paramOrcaHttpModule)
  {
  }

  public OrcaHttpRequestProcessor a()
  {
    return new OrcaHttpRequestProcessor((OrcaHttpClient)b(OrcaHttpClient.class), (OrcaHttpDebugProcessorHook)b(OrcaHttpDebugProcessorHook.class));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.http.OrcaHttpModule.OrcaHttpRequestProcessorProvider
 * JD-Core Version:    0.6.2
 */