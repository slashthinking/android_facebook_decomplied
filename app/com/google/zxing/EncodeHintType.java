package com.google.zxing;

public enum EncodeHintType
{
  static
  {
    CHARACTER_SET = new EncodeHintType("CHARACTER_SET", 1);
    MARGIN = new EncodeHintType("MARGIN", 2);
    PDF417_COMPACT = new EncodeHintType("PDF417_COMPACT", 3);
    PDF417_COMPACTION = new EncodeHintType("PDF417_COMPACTION", 4);
    PDF417_DIMENSIONS = new EncodeHintType("PDF417_DIMENSIONS", 5);
    EncodeHintType[] arrayOfEncodeHintType = new EncodeHintType[6];
    arrayOfEncodeHintType[0] = ERROR_CORRECTION;
    arrayOfEncodeHintType[1] = CHARACTER_SET;
    arrayOfEncodeHintType[2] = MARGIN;
    arrayOfEncodeHintType[3] = PDF417_COMPACT;
    arrayOfEncodeHintType[4] = PDF417_COMPACTION;
    arrayOfEncodeHintType[5] = PDF417_DIMENSIONS;
    $VALUES = arrayOfEncodeHintType;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.google.zxing.EncodeHintType
 * JD-Core Version:    0.6.0
 */