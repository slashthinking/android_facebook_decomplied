package com.facebook.orca.server;

public enum DataFreshnessParam
{
  static
  {
    CHECK_SERVER_FOR_NEW_DATA = new DataFreshnessParam("CHECK_SERVER_FOR_NEW_DATA", 1);
    DO_NOT_CHECK_SERVER = new DataFreshnessParam("DO_NOT_CHECK_SERVER", 2);
    STALE_DATA_OKAY = new DataFreshnessParam("STALE_DATA_OKAY", 3);
    DataFreshnessParam[] arrayOfDataFreshnessParam = new DataFreshnessParam[4];
    arrayOfDataFreshnessParam[0] = PREFER_CACHE_IF_UP_TO_DATE;
    arrayOfDataFreshnessParam[1] = CHECK_SERVER_FOR_NEW_DATA;
    arrayOfDataFreshnessParam[2] = DO_NOT_CHECK_SERVER;
    arrayOfDataFreshnessParam[3] = STALE_DATA_OKAY;
    $VALUES = arrayOfDataFreshnessParam;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.DataFreshnessParam
 * JD-Core Version:    0.6.0
 */