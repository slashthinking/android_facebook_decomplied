package com.facebook.orca.contacts.divebar;

import java.util.EnumSet;

public class DivebarLoader$LoaderParams
{
  private final EnumSet<DivebarLoader.FriendLists> a;
  private final int b;
  private final boolean c;

  public DivebarLoader$LoaderParams(EnumSet<DivebarLoader.FriendLists> paramEnumSet, int paramInt, boolean paramBoolean)
  {
    this.a = paramEnumSet;
    this.b = paramInt;
    this.c = paramBoolean;
  }

  public boolean a()
  {
    return this.a.contains(DivebarLoader.FriendLists.FAVORITE_FRIENDS);
  }

  public boolean b()
  {
    return this.a.contains(DivebarLoader.FriendLists.TOP_FRIENDS);
  }

  public boolean c()
  {
    return this.c;
  }

  public boolean d()
  {
    return this.a.contains(DivebarLoader.FriendLists.ONLINE_FRIENDS);
  }

  public boolean e()
  {
    return this.a.contains(DivebarLoader.FriendLists.MOBILE_FRIENDS);
  }

  public boolean f()
  {
    return this.a.contains(DivebarLoader.FriendLists.OTHER_CONTACTS);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.divebar.DivebarLoader.LoaderParams
 * JD-Core Version:    0.6.0
 */