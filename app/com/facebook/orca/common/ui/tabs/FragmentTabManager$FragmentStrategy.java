package com.facebook.orca.common.ui.tabs;

public enum FragmentTabManager$FragmentStrategy
{
  static
  {
    ATTACH_DETACH = new FragmentStrategy("ATTACH_DETACH", 1);
    FragmentStrategy[] arrayOfFragmentStrategy = new FragmentStrategy[2];
    arrayOfFragmentStrategy[0] = SHOW_HIDE;
    arrayOfFragmentStrategy[1] = ATTACH_DETACH;
    $VALUES = arrayOfFragmentStrategy;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.common.ui.tabs.FragmentTabManager.FragmentStrategy
 * JD-Core Version:    0.6.0
 */