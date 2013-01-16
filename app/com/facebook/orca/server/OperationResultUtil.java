package com.facebook.orca.server;

import android.os.Bundle;
import android.os.Parcelable;
import java.io.Serializable;

public class OperationResultUtil
{
  public static OperationResult a(OperationResult paramOperationResult, String paramString, Serializable paramSerializable)
  {
    if (paramOperationResult.c())
    {
      if (paramOperationResult.g() == null)
        paramOperationResult = OperationResult.a((Parcelable)null);
      paramOperationResult.g().putSerializable(paramString, paramSerializable);
    }
    while (true)
    {
      return paramOperationResult;
      Bundle localBundle = paramOperationResult.g();
      if (paramOperationResult.g() == null)
        localBundle = new Bundle();
      localBundle.putSerializable(paramString, paramSerializable);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.OperationResultUtil
 * JD-Core Version:    0.6.0
 */