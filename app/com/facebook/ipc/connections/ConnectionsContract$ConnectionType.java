package com.facebook.ipc.connections;

public enum ConnectionsContract$ConnectionType
{
  static
  {
    PAGE_ADMIN = new ConnectionType("PAGE_ADMIN", 1);
    PAGE_FAN = new ConnectionType("PAGE_FAN", 2);
    SELF = new ConnectionType("SELF", 3);
    ConnectionType[] arrayOfConnectionType = new ConnectionType[4];
    arrayOfConnectionType[0] = USER;
    arrayOfConnectionType[1] = PAGE_ADMIN;
    arrayOfConnectionType[2] = PAGE_FAN;
    arrayOfConnectionType[3] = SELF;
    $VALUES = arrayOfConnectionType;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.ipc.connections.ConnectionsContract.ConnectionType
 * JD-Core Version:    0.6.0
 */