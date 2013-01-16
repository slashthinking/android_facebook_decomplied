package com.google.common.collect;

 enum GenericMapMaker$NullListener
  implements MapMaker.RemovalListener<Object, Object>
{
  static
  {
    NullListener[] arrayOfNullListener = new NullListener[1];
    arrayOfNullListener[0] = INSTANCE;
  }

  public void onRemoval(MapMaker.RemovalNotification<Object, Object> paramRemovalNotification)
  {
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.GenericMapMaker.NullListener
 * JD-Core Version:    0.6.2
 */