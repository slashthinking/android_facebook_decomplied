package com.facebook.orca.contacts.divebar;

import java.util.EnumSet;
import javax.inject.Provider;

public class DivebarLoaderFactory
{
  private final Provider<DivebarLoader> a;
  private final Provider<Boolean> b;
  private final Provider<Boolean> c;

  public DivebarLoaderFactory(Provider<DivebarLoader> paramProvider, Provider<Boolean> paramProvider1, Provider<Boolean> paramProvider2)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
    this.c = paramProvider2;
  }

  private EnumSet<DivebarLoader.FriendLists> c()
  {
    int i;
    if ((((Boolean)this.b.b()).booleanValue()) || (((Boolean)this.c.b()).booleanValue()))
    {
      i = 1;
      if (i == 0)
        break label68;
    }
    label68: for (EnumSet localEnumSet = EnumSet.of(DivebarLoader.FriendLists.FAVORITE_FRIENDS, DivebarLoader.FriendLists.TOP_FRIENDS, DivebarLoader.FriendLists.ONLINE_FRIENDS, DivebarLoader.FriendLists.MOBILE_FRIENDS, DivebarLoader.FriendLists.OTHER_CONTACTS); ; localEnumSet = EnumSet.of(DivebarLoader.FriendLists.FAVORITE_FRIENDS, DivebarLoader.FriendLists.TOP_FRIENDS, DivebarLoader.FriendLists.ONLINE_FRIENDS, DivebarLoader.FriendLists.OTHER_CONTACTS))
    {
      return localEnumSet;
      i = 0;
      break;
    }
  }

  public DivebarLoader a()
  {
    DivebarLoader.LoaderParams localLoaderParams = new DivebarLoader.LoaderParams(c(), 15, true);
    DivebarLoader localDivebarLoader = (DivebarLoader)this.a.b();
    localDivebarLoader.a(localLoaderParams);
    return localDivebarLoader;
  }

  public DivebarLoader b()
  {
    EnumSet localEnumSet = EnumSet.of(DivebarLoader.FriendLists.FAVORITE_FRIENDS, DivebarLoader.FriendLists.TOP_FRIENDS);
    DivebarLoader localDivebarLoader = (DivebarLoader)this.a.b();
    localDivebarLoader.a(new DivebarLoader.LoaderParams(localEnumSet, 15, false));
    return localDivebarLoader;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.divebar.DivebarLoaderFactory
 * JD-Core Version:    0.6.0
 */