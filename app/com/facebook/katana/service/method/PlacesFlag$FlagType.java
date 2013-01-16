package com.facebook.katana.service.method;

public enum PlacesFlag$FlagType
{
  public static final String ARG_NAME = "flag";
  public final String mArgVal;

  static
  {
    CLOSED = new FlagType("CLOSED", 2, "closed");
    DUPLICATE = new FlagType("DUPLICATE", 3, "duplicate");
    NOT_PUBLIC = new FlagType("NOT_PUBLIC", 4, "not_public");
    FlagType[] arrayOfFlagType = new FlagType[5];
    arrayOfFlagType[0] = INFO_INCORRECT;
    arrayOfFlagType[1] = OFFENSIVE;
    arrayOfFlagType[2] = CLOSED;
    arrayOfFlagType[3] = DUPLICATE;
    arrayOfFlagType[4] = NOT_PUBLIC;
    $VALUES = arrayOfFlagType;
  }

  private PlacesFlag$FlagType(String paramString)
  {
    this.mArgVal = paramString;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.PlacesFlag.FlagType
 * JD-Core Version:    0.6.0
 */