package com.facebook.orca.threadview;

 enum ThreadViewMessagesAdapterUpdater$ReplaceAction
{
  static
  {
    HIDE = new ReplaceAction("HIDE", 1);
    REVEAL = new ReplaceAction("REVEAL", 2);
    ReplaceAction[] arrayOfReplaceAction = new ReplaceAction[3];
    arrayOfReplaceAction[0] = NONE;
    arrayOfReplaceAction[1] = HIDE;
    arrayOfReplaceAction[2] = REVEAL;
    $VALUES = arrayOfReplaceAction;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.ThreadViewMessagesAdapterUpdater.ReplaceAction
 * JD-Core Version:    0.6.0
 */