package com.facebook.orca.threadlist;

 enum ThreadListAdapter$LoadMoreState
{
  static
  {
    LOAD_MORE_PLACEHOLDER = new LoadMoreState("LOAD_MORE_PLACEHOLDER", 1);
    LOAD_MORE = new LoadMoreState("LOAD_MORE", 2);
    LOADING = new LoadMoreState("LOADING", 3);
    LoadMoreState[] arrayOfLoadMoreState = new LoadMoreState[4];
    arrayOfLoadMoreState[0] = NONE;
    arrayOfLoadMoreState[1] = LOAD_MORE_PLACEHOLDER;
    arrayOfLoadMoreState[2] = LOAD_MORE;
    arrayOfLoadMoreState[3] = LOADING;
    $VALUES = arrayOfLoadMoreState;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadlist.ThreadListAdapter.LoadMoreState
 * JD-Core Version:    0.6.0
 */