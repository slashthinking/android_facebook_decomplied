package com.facebook.katana.features.uberbar;

 enum UberSearchResultsAdapter$FetchStatus
{
  static
  {
    COMPLETED = new FetchStatus("COMPLETED", 1);
    ONGOING = new FetchStatus("ONGOING", 2);
    FetchStatus[] arrayOfFetchStatus = new FetchStatus[3];
    arrayOfFetchStatus[0] = NO_QUERY;
    arrayOfFetchStatus[1] = COMPLETED;
    arrayOfFetchStatus[2] = ONGOING;
    $VALUES = arrayOfFetchStatus;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.uberbar.UberSearchResultsAdapter.FetchStatus
 * JD-Core Version:    0.6.0
 */