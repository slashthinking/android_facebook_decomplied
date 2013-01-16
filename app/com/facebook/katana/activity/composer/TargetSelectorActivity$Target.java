package com.facebook.katana.activity.composer;

import android.content.Context;

public enum TargetSelectorActivity$Target
{
  private final int mTargetLabelRes;

  static
  {
    FRIEND_TIMELINE = new Target("FRIEND_TIMELINE", 1, 2131363226);
    GROUP = new Target("GROUP", 2, 2131363228);
    OWN_PAGE = new Target("OWN_PAGE", 3, 2131363230);
    Target[] arrayOfTarget = new Target[4];
    arrayOfTarget[0] = OWN_TIMELINE;
    arrayOfTarget[1] = FRIEND_TIMELINE;
    arrayOfTarget[2] = GROUP;
    arrayOfTarget[3] = OWN_PAGE;
    $VALUES = arrayOfTarget;
  }

  private TargetSelectorActivity$Target(int paramInt)
  {
    this.mTargetLabelRes = paramInt;
  }

  public String getLabel(Context paramContext)
  {
    return paramContext.getString(this.mTargetLabelRes);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.composer.TargetSelectorActivity.Target
 * JD-Core Version:    0.6.0
 */