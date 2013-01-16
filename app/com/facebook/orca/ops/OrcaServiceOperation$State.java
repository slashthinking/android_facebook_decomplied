package com.facebook.orca.ops;

public enum OrcaServiceOperation$State
{
  static
  {
    OPERATION_QUEUED = new State("OPERATION_QUEUED", 2);
    COMPLETED = new State("COMPLETED", 3);
    State[] arrayOfState = new State[4];
    arrayOfState[0] = INIT;
    arrayOfState[1] = READY_TO_QUEUE;
    arrayOfState[2] = OPERATION_QUEUED;
    arrayOfState[3] = COMPLETED;
    $VALUES = arrayOfState;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.ops.OrcaServiceOperation.State
 * JD-Core Version:    0.6.0
 */