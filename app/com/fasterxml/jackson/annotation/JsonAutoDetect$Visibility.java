package com.fasterxml.jackson.annotation;

import java.lang.reflect.Member;
import java.lang.reflect.Modifier;

public enum JsonAutoDetect$Visibility
{
  static
  {
    NONE = new Visibility("NONE", 4);
    DEFAULT = new Visibility("DEFAULT", 5);
    Visibility[] arrayOfVisibility = new Visibility[6];
    arrayOfVisibility[0] = ANY;
    arrayOfVisibility[1] = NON_PRIVATE;
    arrayOfVisibility[2] = PROTECTED_AND_PUBLIC;
    arrayOfVisibility[3] = PUBLIC_ONLY;
    arrayOfVisibility[4] = NONE;
    arrayOfVisibility[5] = DEFAULT;
    $VALUES = arrayOfVisibility;
  }

  public boolean isVisible(Member paramMember)
  {
    boolean bool = true;
    switch (JsonAutoDetect.1.$SwitchMap$com$fasterxml$jackson$annotation$JsonAutoDetect$Visibility[ordinal()])
    {
    default:
      bool = false;
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    }
    while (true)
    {
      return bool;
      bool = false;
      continue;
      if (!Modifier.isPrivate(paramMember.getModifiers()))
        continue;
      bool = false;
      continue;
      if (Modifier.isProtected(paramMember.getModifiers()))
        continue;
      bool = Modifier.isPublic(paramMember.getModifiers());
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility
 * JD-Core Version:    0.6.0
 */