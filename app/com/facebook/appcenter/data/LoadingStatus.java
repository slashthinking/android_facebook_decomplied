package com.facebook.appcenter.data;

public enum LoadingStatus
{
  static
  {
    FAIL = new LoadingStatus("FAIL", 2);
    LoadingStatus[] arrayOfLoadingStatus = new LoadingStatus[3];
    arrayOfLoadingStatus[0] = LOADING;
    arrayOfLoadingStatus[1] = SUCCESS;
    arrayOfLoadingStatus[2] = FAIL;
    $VALUES = arrayOfLoadingStatus;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.data.LoadingStatus
 * JD-Core Version:    0.6.0
 */