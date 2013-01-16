package com.google.common.collect;

 enum AbstractIterator$State
{
  static
  {
    NOT_READY = new State("NOT_READY", 1);
    DONE = new State("DONE", 2);
    FAILED = new State("FAILED", 3);
    State[] arrayOfState = new State[4];
    arrayOfState[0] = READY;
    arrayOfState[1] = NOT_READY;
    arrayOfState[2] = DONE;
    arrayOfState[3] = FAILED;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.AbstractIterator.State
 * JD-Core Version:    0.6.2
 */