package com.facebook.orca.server;

import android.os.Bundle;
import com.google.common.base.Objects;

public class OperationParams
{
  private final String a;
  private final Bundle b;
  private final OrcaServiceProgressCallback c;

  public OperationParams(String paramString, Bundle paramBundle)
  {
    this(paramString, paramBundle, null);
  }

  public OperationParams(String paramString, Bundle paramBundle, OrcaServiceProgressCallback paramOrcaServiceProgressCallback)
  {
    this.a = paramString;
    this.b = paramBundle;
    this.c = paramOrcaServiceProgressCallback;
  }

  public String a()
  {
    return this.a;
  }

  public Bundle b()
  {
    return this.b;
  }

  public OrcaServiceProgressCallback c()
  {
    return this.c;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof OperationParams;
    int i = 0;
    if (bool1)
    {
      OperationParams localOperationParams = (OperationParams)paramObject;
      boolean bool2 = localOperationParams.a().equals(a());
      i = 0;
      if (bool2)
      {
        boolean bool3 = localOperationParams.b().equals(b());
        i = 0;
        if (bool3)
          i = 1;
      }
    }
    return i;
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.a;
    arrayOfObject[1] = this.b;
    return Objects.hashCode(arrayOfObject);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.OperationParams
 * JD-Core Version:    0.6.0
 */