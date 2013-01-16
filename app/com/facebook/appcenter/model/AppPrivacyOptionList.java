package com.facebook.appcenter.model;

import java.util.ArrayList;

public class AppPrivacyOptionList extends ArrayList<AppPrivacyOption>
{
  public static int a = 1;

  public AppPrivacyOptionList()
  {
    add(new AppPrivacyOption("EVERYONE", 2131362066, 2131362063, 2130837515, 0));
    add(new AppPrivacyOption("ALL_FRIENDS", 2131362065, 2131362062, 2130837513, 40));
    add(new AppPrivacyOption("SELF", 2131362067, 2131362064, 2130837514, 80));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.model.AppPrivacyOptionList
 * JD-Core Version:    0.6.0
 */