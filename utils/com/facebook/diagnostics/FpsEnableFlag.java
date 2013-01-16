package com.facebook.diagnostics;

public enum FpsEnableFlag
{
  static
  {
    ENABLE_OUTPUT_TO_LOGCAT = new FpsEnableFlag("ENABLE_OUTPUT_TO_LOGCAT", 2);
    ENABLE_FRAME_COUNTER = new FpsEnableFlag("ENABLE_FRAME_COUNTER", 3);
    ENABLE_FLUSH_DATA_ON_PAUSE = new FpsEnableFlag("ENABLE_FLUSH_DATA_ON_PAUSE", 4);
    FpsEnableFlag[] arrayOfFpsEnableFlag = new FpsEnableFlag[5];
    arrayOfFpsEnableFlag[0] = ENABLE;
    arrayOfFpsEnableFlag[1] = ENABLE_RECORD_DATA;
    arrayOfFpsEnableFlag[2] = ENABLE_OUTPUT_TO_LOGCAT;
    arrayOfFpsEnableFlag[3] = ENABLE_FRAME_COUNTER;
    arrayOfFpsEnableFlag[4] = ENABLE_FLUSH_DATA_ON_PAUSE;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.diagnostics.FpsEnableFlag
 * JD-Core Version:    0.6.2
 */