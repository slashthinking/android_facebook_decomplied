package com.facebook.common.util;

public enum ReflectionUtils$IncludeFlags
{
  static
  {
    INCLUDE_CONSTRUCTORS = new IncludeFlags("INCLUDE_CONSTRUCTORS", 1);
    INCLUDE_METHODS = new IncludeFlags("INCLUDE_METHODS", 2);
    INCLUDE_FIELDS = new IncludeFlags("INCLUDE_FIELDS", 3);
    IncludeFlags[] arrayOfIncludeFlags = new IncludeFlags[4];
    arrayOfIncludeFlags[0] = INCLUDE_SUPERCLASSES;
    arrayOfIncludeFlags[1] = INCLUDE_CONSTRUCTORS;
    arrayOfIncludeFlags[2] = INCLUDE_METHODS;
    arrayOfIncludeFlags[3] = INCLUDE_FIELDS;
    $VALUES = arrayOfIncludeFlags;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.common.util.ReflectionUtils.IncludeFlags
 * JD-Core Version:    0.6.0
 */