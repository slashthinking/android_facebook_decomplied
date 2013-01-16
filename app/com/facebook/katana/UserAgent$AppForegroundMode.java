package com.facebook.katana;

public enum UserAgent$AppForegroundMode
{
  private final String uaFlagValue;

  static
  {
    Background = new AppForegroundMode("Background", 1, "1");
    None = new AppForegroundMode("None", 2, "-1");
    AppForegroundMode[] arrayOfAppForegroundMode = new AppForegroundMode[3];
    arrayOfAppForegroundMode[0] = Foreground;
    arrayOfAppForegroundMode[1] = Background;
    arrayOfAppForegroundMode[2] = None;
    $VALUES = arrayOfAppForegroundMode;
  }

  private UserAgent$AppForegroundMode(String paramString)
  {
    this.uaFlagValue = paramString;
  }

  public String toString()
  {
    return this.uaFlagValue;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.UserAgent.AppForegroundMode
 * JD-Core Version:    0.6.0
 */