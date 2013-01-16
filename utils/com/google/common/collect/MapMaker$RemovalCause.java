package com.google.common.collect;

 enum MapMaker$RemovalCause
{
  static
  {
    COLLECTED = new MapMaker.RemovalCause.3("COLLECTED", 2);
    EXPIRED = new MapMaker.RemovalCause.4("EXPIRED", 3);
    SIZE = new MapMaker.RemovalCause.5("SIZE", 4);
    RemovalCause[] arrayOfRemovalCause = new RemovalCause[5];
    arrayOfRemovalCause[0] = EXPLICIT;
    arrayOfRemovalCause[1] = REPLACED;
    arrayOfRemovalCause[2] = COLLECTED;
    arrayOfRemovalCause[3] = EXPIRED;
    arrayOfRemovalCause[4] = SIZE;
  }

  abstract boolean wasEvicted();
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.MapMaker.RemovalCause
 * JD-Core Version:    0.6.2
 */