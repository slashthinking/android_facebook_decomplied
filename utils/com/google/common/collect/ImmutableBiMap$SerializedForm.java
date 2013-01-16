package com.google.common.collect;

class ImmutableBiMap$SerializedForm extends ImmutableMap.SerializedForm
{
  private static final long serialVersionUID;

  ImmutableBiMap$SerializedForm(ImmutableBiMap<?, ?> paramImmutableBiMap)
  {
    super(paramImmutableBiMap);
  }

  Object readResolve()
  {
    return a(new ImmutableBiMap.Builder());
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.collect.ImmutableBiMap.SerializedForm
 * JD-Core Version:    0.6.2
 */