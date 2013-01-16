package com.facebook.analytics;

public enum InteractionLogger$ContentFlags
{
  private final int mFlags;

  static
  {
    NO_DATA = new ContentFlags("NO_DATA", 1, 1);
    LOCAL_DATA = new ContentFlags("LOCAL_DATA", 2, 2);
    NETWORK_DATA = new ContentFlags("NETWORK_DATA", 3, 3);
    ContentFlags[] arrayOfContentFlags = new ContentFlags[4];
    arrayOfContentFlags[0] = UNDEFINED;
    arrayOfContentFlags[1] = NO_DATA;
    arrayOfContentFlags[2] = LOCAL_DATA;
    arrayOfContentFlags[3] = NETWORK_DATA;
  }

  private InteractionLogger$ContentFlags(int paramInt)
  {
    this.mFlags = paramInt;
  }

  public int getValue()
  {
    return this.mFlags;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.analytics.InteractionLogger.ContentFlags
 * JD-Core Version:    0.6.2
 */