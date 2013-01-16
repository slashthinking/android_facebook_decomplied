package com.google.inject.name;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.lang.annotation.Annotation;

class NamedImpl
  implements Named, Serializable
{
  private static final long serialVersionUID;
  private final String value;

  public NamedImpl(String paramString)
  {
    this.value = ((String)Preconditions.checkNotNull(paramString, "name"));
  }

  public Class<? extends Annotation> annotationType()
  {
    return Serializable.class;
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Serializable));
    Named localNamed;
    for (boolean bool = false; ; bool = this.value.equals(localNamed.value()))
    {
      return bool;
      localNamed = (Serializable)paramObject;
    }
  }

  public int hashCode()
  {
    return 127 * "value".hashCode() ^ this.value.hashCode();
  }

  public String toString()
  {
    return "@" + Serializable.class.getName() + "(value=" + this.value + ")";
  }

  public String value()
  {
    return this.value;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.google.inject.name.NamedImpl
 * JD-Core Version:    0.6.0
 */