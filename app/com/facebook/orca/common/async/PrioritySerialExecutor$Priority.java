package com.facebook.orca.common.async;

public enum PrioritySerialExecutor$Priority
{
  static
  {
    LOW = new Priority("LOW", 2);
    Priority[] arrayOfPriority = new Priority[3];
    arrayOfPriority[0] = HIGH;
    arrayOfPriority[1] = NORMAL;
    arrayOfPriority[2] = LOW;
    $VALUES = arrayOfPriority;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.async.PrioritySerialExecutor.Priority
 * JD-Core Version:    0.6.0
 */