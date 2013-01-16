package com.facebook.orca.prefs;

public enum PayForPlayPresence
{
  private final boolean mShowPresence;

  static
  {
    DISABLED = new PayForPlayPresence("DISABLED", 1, false);
    OFF = new PayForPlayPresence("OFF", 2, true);
    PayForPlayPresence[] arrayOfPayForPlayPresence = new PayForPlayPresence[3];
    arrayOfPayForPlayPresence[0] = ENABLED;
    arrayOfPayForPlayPresence[1] = DISABLED;
    arrayOfPayForPlayPresence[2] = OFF;
    $VALUES = arrayOfPayForPlayPresence;
  }

  private PayForPlayPresence(boolean paramBoolean)
  {
    this.mShowPresence = paramBoolean;
  }

  public boolean shouldShowPresence()
  {
    return this.mShowPresence;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.PayForPlayPresence
 * JD-Core Version:    0.6.0
 */