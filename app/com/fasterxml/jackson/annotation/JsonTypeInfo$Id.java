package com.fasterxml.jackson.annotation;

public enum JsonTypeInfo$Id
{
  private final String _defaultPropertyName;

  static
  {
    CLASS = new Id("CLASS", 1, "@class");
    MINIMAL_CLASS = new Id("MINIMAL_CLASS", 2, "@c");
    NAME = new Id("NAME", 3, "@type");
    CUSTOM = new Id("CUSTOM", 4, null);
    Id[] arrayOfId = new Id[5];
    arrayOfId[0] = NONE;
    arrayOfId[1] = CLASS;
    arrayOfId[2] = MINIMAL_CLASS;
    arrayOfId[3] = NAME;
    arrayOfId[4] = CUSTOM;
    $VALUES = arrayOfId;
  }

  private JsonTypeInfo$Id(String paramString)
  {
    this._defaultPropertyName = paramString;
  }

  public String getDefaultPropertyName()
  {
    return this._defaultPropertyName;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.fasterxml.jackson.annotation.JsonTypeInfo.Id
 * JD-Core Version:    0.6.0
 */