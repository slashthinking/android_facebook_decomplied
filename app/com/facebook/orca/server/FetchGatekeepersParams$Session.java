package com.facebook.orca.server;

public enum FetchGatekeepersParams$Session
{
  static
  {
    IS_NOT_SESSIONLESS = new Session("IS_NOT_SESSIONLESS", 1);
    Session[] arrayOfSession = new Session[2];
    arrayOfSession[0] = IS_SESSIONLESS;
    arrayOfSession[1] = IS_NOT_SESSIONLESS;
    $VALUES = arrayOfSession;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.FetchGatekeepersParams.Session
 * JD-Core Version:    0.6.0
 */