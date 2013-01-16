package com.facebook.orca.server;

public enum DataFreshnessResult
{
  static
  {
    FROM_CACHE_UP_TO_DATE = new DataFreshnessResult("FROM_CACHE_UP_TO_DATE", 1);
    FROM_CACHE_STALE = new DataFreshnessResult("FROM_CACHE_STALE", 2);
    NO_DATA = new DataFreshnessResult("NO_DATA", 3);
    FROM_CACHE_INCOMPLETE = new DataFreshnessResult("FROM_CACHE_INCOMPLETE", 4);
    FROM_CACHE_HAD_SERVER_ERROR = new DataFreshnessResult("FROM_CACHE_HAD_SERVER_ERROR", 5);
    DataFreshnessResult[] arrayOfDataFreshnessResult = new DataFreshnessResult[6];
    arrayOfDataFreshnessResult[0] = FROM_SERVER;
    arrayOfDataFreshnessResult[1] = FROM_CACHE_UP_TO_DATE;
    arrayOfDataFreshnessResult[2] = FROM_CACHE_STALE;
    arrayOfDataFreshnessResult[3] = NO_DATA;
    arrayOfDataFreshnessResult[4] = FROM_CACHE_INCOMPLETE;
    arrayOfDataFreshnessResult[5] = FROM_CACHE_HAD_SERVER_ERROR;
    $VALUES = arrayOfDataFreshnessResult;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.DataFreshnessResult
 * JD-Core Version:    0.6.0
 */