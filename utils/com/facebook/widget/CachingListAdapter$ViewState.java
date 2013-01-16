package com.facebook.widget;

public enum CachingListAdapter$ViewState
{
  static
  {
    Created = new ViewState("Created", 1);
    Measured = new ViewState("Measured", 2);
    LaidOut = new ViewState("LaidOut", 3);
    Ready = new ViewState("Ready", 4);
    OnScreen = new ViewState("OnScreen", 5);
    ViewState[] arrayOfViewState = new ViewState[6];
    arrayOfViewState[0] = NotLoaded;
    arrayOfViewState[1] = Created;
    arrayOfViewState[2] = Measured;
    arrayOfViewState[3] = LaidOut;
    arrayOfViewState[4] = Ready;
    arrayOfViewState[5] = OnScreen;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.CachingListAdapter.ViewState
 * JD-Core Version:    0.6.2
 */