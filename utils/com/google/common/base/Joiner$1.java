package com.google.common.base;

class Joiner$1 extends Joiner
{
  public Joiner skipNulls()
  {
    throw new UnsupportedOperationException("already specified useForNull");
  }

  CharSequence toString(Object paramObject)
  {
    if (paramObject == null);
    for (Object localObject = this.val$nullText; ; localObject = this.this$0.toString(paramObject))
      return localObject;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.base.Joiner.1
 * JD-Core Version:    0.6.2
 */