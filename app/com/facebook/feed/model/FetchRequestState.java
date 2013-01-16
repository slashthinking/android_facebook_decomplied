package com.facebook.feed.model;

public enum FetchRequestState
{
  static
  {
    ALREADY_SCHEDULED = new FetchRequestState("ALREADY_SCHEDULED", 1);
    END_OF_FEED = new FetchRequestState("END_OF_FEED", 2);
    FetchRequestState[] arrayOfFetchRequestState = new FetchRequestState[3];
    arrayOfFetchRequestState[0] = SUCCESS;
    arrayOfFetchRequestState[1] = ALREADY_SCHEDULED;
    arrayOfFetchRequestState[2] = END_OF_FEED;
    $VALUES = arrayOfFetchRequestState;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.model.FetchRequestState
 * JD-Core Version:    0.6.0
 */