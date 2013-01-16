package com.google.common.collect;

abstract interface MapMaker$RemovalListener<K, V>
{
  public abstract void onRemoval(MapMaker.RemovalNotification<K, V> paramRemovalNotification);
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.MapMaker.RemovalListener
 * JD-Core Version:    0.6.2
 */