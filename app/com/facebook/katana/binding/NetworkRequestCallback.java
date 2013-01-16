package com.facebook.katana.binding;

import android.content.Context;
import com.facebook.katana.util.TraceLogger;

public abstract interface NetworkRequestCallback<K, V>
{
  public abstract void a(Context paramContext, boolean paramBoolean, K paramK, String paramString, V paramV);

  public abstract TraceLogger b();
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.binding.NetworkRequestCallback
 * JD-Core Version:    0.6.0
 */