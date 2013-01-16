package com.google.common.collect;

class EmptyImmutableListMultimap extends ImmutableListMultimap<Object, Object>
{
  static final EmptyImmutableListMultimap a = new EmptyImmutableListMultimap();
  private static final long serialVersionUID;

  private EmptyImmutableListMultimap()
  {
    super(ImmutableMap.j(), 0);
  }

  private Object readResolve()
  {
    return a;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.EmptyImmutableListMultimap
 * JD-Core Version:    0.6.2
 */