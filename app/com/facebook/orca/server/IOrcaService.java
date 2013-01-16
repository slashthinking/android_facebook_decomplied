package com.facebook.orca.server;

import android.os.Bundle;
import android.os.IInterface;

public abstract interface IOrcaService extends IInterface
{
  public abstract String a(String paramString, Bundle paramBundle);

  public abstract boolean a(String paramString, ICompletionHandler paramICompletionHandler);
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.IOrcaService
 * JD-Core Version:    0.6.0
 */