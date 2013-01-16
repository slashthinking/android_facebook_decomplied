package com.facebook.orca.ui.touch;

 enum DragMotionDetector$ListenState
{
  static
  {
    INTERCEPTING = new ListenState("INTERCEPTING", 1);
    DEFERRING = new ListenState("DEFERRING", 2);
    ListenState[] arrayOfListenState = new ListenState[3];
    arrayOfListenState[0] = MONITORING;
    arrayOfListenState[1] = INTERCEPTING;
    arrayOfListenState[2] = DEFERRING;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.ui.touch.DragMotionDetector.ListenState
 * JD-Core Version:    0.6.2
 */