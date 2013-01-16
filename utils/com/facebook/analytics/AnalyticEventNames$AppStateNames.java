package com.facebook.analytics;

public enum AnalyticEventNames$AppStateNames
{
  private String stateName;

  static
  {
    ACTIVE = new AppStateNames("ACTIVE", 2, "active");
    RESIGN = new AppStateNames("RESIGN", 3, "resign");
    FOREGROUNDED = new AppStateNames("FOREGROUNDED", 4, "foreground");
    BACKGROUNDED = new AppStateNames("BACKGROUNDED", 5, "background");
    AppStateNames[] arrayOfAppStateNames = new AppStateNames[6];
    arrayOfAppStateNames[0] = INIT;
    arrayOfAppStateNames[1] = LAUNCH;
    arrayOfAppStateNames[2] = ACTIVE;
    arrayOfAppStateNames[3] = RESIGN;
    arrayOfAppStateNames[4] = FOREGROUNDED;
    arrayOfAppStateNames[5] = BACKGROUNDED;
  }

  private AnalyticEventNames$AppStateNames(String paramString)
  {
    this.stateName = paramString;
  }

  public String toString()
  {
    return this.stateName;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.AnalyticEventNames.AppStateNames
 * JD-Core Version:    0.6.2
 */