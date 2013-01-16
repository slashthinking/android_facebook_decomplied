package com.google.common.collect;

public abstract class ForwardingObject
{
  protected abstract Object c();

  public String toString()
  {
    return c().toString();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ForwardingObject
 * JD-Core Version:    0.6.2
 */