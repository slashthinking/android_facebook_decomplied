package com.facebook.katana.activity.media;

public enum ImageLoaderThread$WorkerThreadState
{
  static
  {
    STATE_NO_PRELOAD = new WorkerThreadState("STATE_NO_PRELOAD", 1);
    STATE_STOP = new WorkerThreadState("STATE_STOP", 2);
    WorkerThreadState[] arrayOfWorkerThreadState = new WorkerThreadState[3];
    arrayOfWorkerThreadState[0] = STATE_RUN;
    arrayOfWorkerThreadState[1] = STATE_NO_PRELOAD;
    arrayOfWorkerThreadState[2] = STATE_STOP;
    $VALUES = arrayOfWorkerThreadState;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.ImageLoaderThread.WorkerThreadState
 * JD-Core Version:    0.6.0
 */