package com.facebook.appcenter.workflow;

public enum AppWorkflowManager$DisplayState
{
  boolean enabled;
  int textId;

  static
  {
    BUY = new DisplayState("BUY", 1, 2131362047, true);
    INSTALL = new DisplayState("INSTALL", 2, 2131362048, true);
    LAUNCH = new DisplayState("LAUNCH", 3, 2131362049, true);
    AUTHORIZING = new DisplayState("AUTHORIZING", 4, 2131362050, true);
    BUYING = new DisplayState("BUYING", 5, 2131362051, false);
    DOWNLOADING = new DisplayState("DOWNLOADING", 6, 2131362052, false);
    INSTALLING = new DisplayState("INSTALLING", 7, 2131362053, false);
    DisplayState[] arrayOfDisplayState = new DisplayState[8];
    arrayOfDisplayState[0] = FREE;
    arrayOfDisplayState[1] = BUY;
    arrayOfDisplayState[2] = INSTALL;
    arrayOfDisplayState[3] = LAUNCH;
    arrayOfDisplayState[4] = AUTHORIZING;
    arrayOfDisplayState[5] = BUYING;
    arrayOfDisplayState[6] = DOWNLOADING;
    arrayOfDisplayState[7] = INSTALLING;
    $VALUES = arrayOfDisplayState;
  }

  private AppWorkflowManager$DisplayState(int paramInt, boolean paramBoolean)
  {
    this.textId = paramInt;
    this.enabled = paramBoolean;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.workflow.AppWorkflowManager.DisplayState
 * JD-Core Version:    0.6.0
 */