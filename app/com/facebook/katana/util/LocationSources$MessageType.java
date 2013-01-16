package com.facebook.katana.util;

public enum LocationSources$MessageType
{
  public final String dontAskPrefKey;
  public final int messageResId;
  public final int titleResId;

  static
  {
    GPS = new MessageType("GPS", 1, 2131363371, 2131363372, "location_services_turn_gps_on_dont_ask");
    BOTH = new MessageType("BOTH", 2, 2131363367, 2131363368, "location_services_enable_sources_dont_ask");
    MessageType[] arrayOfMessageType = new MessageType[3];
    arrayOfMessageType[0] = NETWORK;
    arrayOfMessageType[1] = GPS;
    arrayOfMessageType[2] = BOTH;
    $VALUES = arrayOfMessageType;
  }

  private LocationSources$MessageType(int paramInt1, int paramInt2, String paramString)
  {
    this.titleResId = paramInt1;
    this.messageResId = paramInt2;
    this.dontAskPrefKey = paramString;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.util.LocationSources.MessageType
 * JD-Core Version:    0.6.0
 */