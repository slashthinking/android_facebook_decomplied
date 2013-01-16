package com.facebook.katana.orca;

public enum ForceMessenger$Stage
{
  static
  {
    INSTALLED = new Stage("INSTALLED", 2);
    Stage[] arrayOfStage = new Stage[3];
    arrayOfStage[0] = INSTALL_LATER;
    arrayOfStage[1] = INSTALL_NOW;
    arrayOfStage[2] = INSTALLED;
    $VALUES = arrayOfStage;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.orca.ForceMessenger.Stage
 * JD-Core Version:    0.6.0
 */