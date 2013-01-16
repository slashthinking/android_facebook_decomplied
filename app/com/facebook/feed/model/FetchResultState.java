package com.facebook.feed.model;

public enum FetchResultState
{
  static
  {
    SERVICE_EXCEPTION = new FetchResultState("SERVICE_EXCEPTION", 1);
    CANCELLATION = new FetchResultState("CANCELLATION", 2);
    FetchResultState[] arrayOfFetchResultState = new FetchResultState[3];
    arrayOfFetchResultState[0] = SUCCESS;
    arrayOfFetchResultState[1] = SERVICE_EXCEPTION;
    arrayOfFetchResultState[2] = CANCELLATION;
    $VALUES = arrayOfFetchResultState;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.model.FetchResultState
 * JD-Core Version:    0.6.0
 */