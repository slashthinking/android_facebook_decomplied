package com.facebook.orca.debug;

 enum TraceEvent$Type
{
  static
  {
    COMMENT = new Type("COMMENT", 2);
    Type[] arrayOfType = new Type[3];
    arrayOfType[0] = START;
    arrayOfType[1] = STOP;
    arrayOfType[2] = COMMENT;
    $VALUES = arrayOfType;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.debug.TraceEvent.Type
 * JD-Core Version:    0.6.0
 */