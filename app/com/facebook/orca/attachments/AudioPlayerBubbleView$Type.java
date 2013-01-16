package com.facebook.orca.attachments;

public enum AudioPlayerBubbleView$Type
{
  static
  {
    SELF_HIGHLIGHTED = new Type("SELF_HIGHLIGHTED", 1);
    OTHER_NORMAL = new Type("OTHER_NORMAL", 2);
    OTHER_HIGHLIGHTED = new Type("OTHER_HIGHLIGHTED", 3);
    Type[] arrayOfType = new Type[4];
    arrayOfType[0] = SELF_NORMAL;
    arrayOfType[1] = SELF_HIGHLIGHTED;
    arrayOfType[2] = OTHER_NORMAL;
    arrayOfType[3] = OTHER_HIGHLIGHTED;
    $VALUES = arrayOfType;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.attachments.AudioPlayerBubbleView.Type
 * JD-Core Version:    0.6.0
 */