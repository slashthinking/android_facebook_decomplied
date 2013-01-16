package com.ooqqxx.stat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public abstract interface IStat
{
  public abstract boolean drawWindow(Activity paramActivity);

  public abstract boolean filter(Context paramContext, Intent paramIntent);

  public abstract void packageChanged(Context paramContext, Intent paramIntent);

  public abstract void stat(Context paramContext, Intent paramIntent);
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.ooqqxx.stat.IStat
 * JD-Core Version:    0.6.0
 */