package com.facebook.orca.threadview;

public class ThreadViewMapActivityTabShim
{
  public static boolean a()
  {
    try
    {
      Class localClass = Class.forName("com.google.android.maps.MapActivity");
      i = 0;
      if (localClass != null)
        i = 1;
      return i;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      while (true)
        int i = 0;
    }
  }

  public static Class b()
  {
    try
    {
      Class localClass2 = Class.forName("com.facebook.orca.threadview.ThreadViewMapActivityTabImpl");
      localClass1 = localClass2;
      return localClass1;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      while (true)
        Class localClass1 = null;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threadview.ThreadViewMapActivityTabShim
 * JD-Core Version:    0.6.0
 */