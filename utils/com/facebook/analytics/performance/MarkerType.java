package com.facebook.analytics.performance;

public enum MarkerType
{
  private final String mMarkerName;

  static
  {
    MARK = new MarkerType("MARK", 2, "mark");
    CLIENT_TTI = new MarkerType("CLIENT_TTI", 3, "client_tti");
    VALUE = new MarkerType("VALUE", 4, "value");
    DATA_REQUESTED = new MarkerType("DATA_REQUESTED", 5, "data_requested");
    DATA_RECEIVED = new MarkerType("DATA_RECEIVED", 6, "data_received");
    ACTIVITY_CREATED = new MarkerType("ACTIVITY_CREATED", 7, "activity_created");
    ACTIVITY_RESUMED = new MarkerType("ACTIVITY_RESUMED", 8, "activity_resumed");
    MarkerType[] arrayOfMarkerType = new MarkerType[9];
    arrayOfMarkerType[0] = START;
    arrayOfMarkerType[1] = STOP;
    arrayOfMarkerType[2] = MARK;
    arrayOfMarkerType[3] = CLIENT_TTI;
    arrayOfMarkerType[4] = VALUE;
    arrayOfMarkerType[5] = DATA_REQUESTED;
    arrayOfMarkerType[6] = DATA_RECEIVED;
    arrayOfMarkerType[7] = ACTIVITY_CREATED;
    arrayOfMarkerType[8] = ACTIVITY_RESUMED;
  }

  private MarkerType(String paramString)
  {
    this.mMarkerName = paramString;
  }

  public String toString()
  {
    return this.mMarkerName;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.performance.MarkerType
 * JD-Core Version:    0.6.2
 */