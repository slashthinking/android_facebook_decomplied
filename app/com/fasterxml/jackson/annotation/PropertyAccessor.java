package com.fasterxml.jackson.annotation;

public enum PropertyAccessor
{
  static
  {
    CREATOR = new PropertyAccessor("CREATOR", 2);
    FIELD = new PropertyAccessor("FIELD", 3);
    IS_GETTER = new PropertyAccessor("IS_GETTER", 4);
    NONE = new PropertyAccessor("NONE", 5);
    ALL = new PropertyAccessor("ALL", 6);
    PropertyAccessor[] arrayOfPropertyAccessor = new PropertyAccessor[7];
    arrayOfPropertyAccessor[0] = GETTER;
    arrayOfPropertyAccessor[1] = SETTER;
    arrayOfPropertyAccessor[2] = CREATOR;
    arrayOfPropertyAccessor[3] = FIELD;
    arrayOfPropertyAccessor[4] = IS_GETTER;
    arrayOfPropertyAccessor[5] = NONE;
    arrayOfPropertyAccessor[6] = ALL;
    $VALUES = arrayOfPropertyAccessor;
  }

  public boolean creatorEnabled()
  {
    if ((this == CREATOR) || (this == ALL));
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean fieldEnabled()
  {
    if ((this == FIELD) || (this == ALL));
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean getterEnabled()
  {
    if ((this == GETTER) || (this == ALL));
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean isGetterEnabled()
  {
    if ((this == IS_GETTER) || (this == ALL));
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean setterEnabled()
  {
    if ((this == SETTER) || (this == ALL));
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.fasterxml.jackson.annotation.PropertyAccessor
 * JD-Core Version:    0.6.0
 */