package com.google.common.collect;

final class MapMaker$RemovalNotification<K, V> extends ImmutableEntry<K, V>
{
  private static final long serialVersionUID;
  private final MapMaker.RemovalCause cause;

  MapMaker$RemovalNotification(K paramK, V paramV, MapMaker.RemovalCause paramRemovalCause)
  {
    super(paramK, paramV);
    this.cause = paramRemovalCause;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.MapMaker.RemovalNotification
 * JD-Core Version:    0.6.2
 */