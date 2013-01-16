package com.facebook.katana.service.method;

public enum GraphFeedPublish$ImplicitLocation
{
  private int mCode;

  static
  {
    ENABLED = new ImplicitLocation("ENABLED", 1, 1);
    DISABLED = new ImplicitLocation("DISABLED", 2, 2);
    ImplicitLocation[] arrayOfImplicitLocation = new ImplicitLocation[3];
    arrayOfImplicitLocation[0] = UNKNOWN;
    arrayOfImplicitLocation[1] = ENABLED;
    arrayOfImplicitLocation[2] = DISABLED;
    $VALUES = arrayOfImplicitLocation;
  }

  private GraphFeedPublish$ImplicitLocation(int paramInt)
  {
    this.mCode = paramInt;
  }

  public int getCode()
  {
    return this.mCode;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.GraphFeedPublish.ImplicitLocation
 * JD-Core Version:    0.6.0
 */