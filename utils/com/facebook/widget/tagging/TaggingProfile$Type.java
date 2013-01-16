package com.facebook.widget.tagging;

public enum TaggingProfile$Type
{
  static
  {
    TEXT = new Type("TEXT", 1);
    SELF = new Type("SELF", 2);
    USER = new Type("USER", 3);
    PAGE = new Type("PAGE", 4);
    Type[] arrayOfType = new Type[5];
    arrayOfType[0] = UNKNOWN;
    arrayOfType[1] = TEXT;
    arrayOfType[2] = SELF;
    arrayOfType[3] = USER;
    arrayOfType[4] = PAGE;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.widget.tagging.TaggingProfile.Type
 * JD-Core Version:    0.6.2
 */