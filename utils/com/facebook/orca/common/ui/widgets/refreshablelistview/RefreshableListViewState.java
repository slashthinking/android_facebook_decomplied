package com.facebook.orca.common.ui.widgets.refreshablelistview;

public enum RefreshableListViewState
{
  static
  {
    LOADING = new RefreshableListViewState("LOADING", 4);
    BUFFERING = new RefreshableListViewState("BUFFERING", 5);
    RefreshableListViewState[] arrayOfRefreshableListViewState = new RefreshableListViewState[6];
    arrayOfRefreshableListViewState[0] = NORMAL;
    arrayOfRefreshableListViewState[1] = PULL_TO_REFRESH;
    arrayOfRefreshableListViewState[2] = PUSH_TO_REFRESH;
    arrayOfRefreshableListViewState[3] = RELEASE_TO_REFRESH;
    arrayOfRefreshableListViewState[4] = LOADING;
    arrayOfRefreshableListViewState[5] = BUFFERING;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.widgets.refreshablelistview.RefreshableListViewState
 * JD-Core Version:    0.6.2
 */