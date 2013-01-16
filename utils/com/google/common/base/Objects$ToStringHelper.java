package com.google.common.base;

public final class Objects$ToStringHelper
{
  private final StringBuilder builder;
  private boolean needsSeparator = false;

  private Objects$ToStringHelper(String paramString)
  {
    Preconditions.checkNotNull(paramString);
    this.builder = new StringBuilder(32).append(paramString).append('{');
  }

  private StringBuilder maybeAppendSeparator()
  {
    if (this.needsSeparator);
    for (StringBuilder localStringBuilder = this.builder.append(", "); ; localStringBuilder = this.builder)
    {
      return localStringBuilder;
      this.needsSeparator = true;
    }
  }

  public ToStringHelper add(String paramString, Object paramObject)
  {
    Preconditions.checkNotNull(paramString);
    maybeAppendSeparator().append(paramString).append('=').append(paramObject);
    return this;
  }

  public ToStringHelper addValue(Object paramObject)
  {
    maybeAppendSeparator().append(paramObject);
    return this;
  }

  public String toString()
  {
    try
    {
      String str = '}';
      return str;
    }
    finally
    {
      this.builder.setLength(-1 + this.builder.length());
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.google.common.base.Objects.ToStringHelper
 * JD-Core Version:    0.6.2
 */