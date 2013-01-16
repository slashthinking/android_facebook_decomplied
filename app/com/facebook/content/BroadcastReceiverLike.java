package com.facebook.content;

import android.os.Bundle;

public abstract interface BroadcastReceiverLike
{
  public abstract void abortBroadcast();

  public abstract int getResultCode();

  public abstract String getResultData();

  public abstract Bundle getResultExtras(boolean paramBoolean);

  public abstract void setResult(int paramInt, String paramString, Bundle paramBundle);

  public abstract void setResultCode(int paramInt);

  public abstract void setResultData(String paramString);

  public abstract void setResultExtras(Bundle paramBundle);
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.content.BroadcastReceiverLike
 * JD-Core Version:    0.6.0
 */