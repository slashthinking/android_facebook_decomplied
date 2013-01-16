package com.facebook.orca.server;

import android.os.Bundle;

class OrcaService$OrcaServiceStub extends IOrcaService.Stub
{
  OrcaService$OrcaServiceStub(OrcaService paramOrcaService)
  {
  }

  public String a(String paramString, Bundle paramBundle)
  {
    return OrcaService.a(this.a, paramString, paramBundle);
  }

  public boolean a(String paramString, ICompletionHandler paramICompletionHandler)
  {
    return OrcaService.a(this.a, paramString, paramICompletionHandler);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.OrcaService.OrcaServiceStub
 * JD-Core Version:    0.6.0
 */