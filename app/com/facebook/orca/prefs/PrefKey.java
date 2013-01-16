package com.facebook.orca.prefs;

import com.facebook.orca.common.util.TypedKey;

public class PrefKey extends TypedKey<PrefKey>
{
  PrefKey(String paramString)
  {
    super(paramString);
  }

  protected PrefKey a(String paramString)
  {
    return new PrefKey(paramString);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.PrefKey
 * JD-Core Version:    0.6.0
 */