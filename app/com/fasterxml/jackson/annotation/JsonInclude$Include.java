package com.fasterxml.jackson.annotation;

public enum JsonInclude$Include
{
  static
  {
    NON_DEFAULT = new Include("NON_DEFAULT", 2);
    NON_EMPTY = new Include("NON_EMPTY", 3);
    Include[] arrayOfInclude = new Include[4];
    arrayOfInclude[0] = ALWAYS;
    arrayOfInclude[1] = NON_NULL;
    arrayOfInclude[2] = NON_DEFAULT;
    arrayOfInclude[3] = NON_EMPTY;
    $VALUES = arrayOfInclude;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.fasterxml.jackson.annotation.JsonInclude.Include
 * JD-Core Version:    0.6.0
 */