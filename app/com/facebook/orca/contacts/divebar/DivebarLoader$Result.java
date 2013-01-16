package com.facebook.orca.contacts.divebar;

import com.facebook.orca.users.User;
import com.google.common.collect.ImmutableList;

public class DivebarLoader$Result
{
  private final ImmutableList<User> a;
  private final ImmutableList<User> b;
  private final ImmutableList<User> c;
  private final ImmutableList<User> d;
  private final ImmutableList<User> e;
  private final boolean f;

  public DivebarLoader$Result(ImmutableList<User> paramImmutableList1, ImmutableList<User> paramImmutableList2, ImmutableList<User> paramImmutableList3, ImmutableList<User> paramImmutableList4, ImmutableList<User> paramImmutableList5)
  {
    this(paramImmutableList1, paramImmutableList2, paramImmutableList3, paramImmutableList4, paramImmutableList5, false);
  }

  public DivebarLoader$Result(ImmutableList<User> paramImmutableList1, ImmutableList<User> paramImmutableList2, ImmutableList<User> paramImmutableList3, ImmutableList<User> paramImmutableList4, ImmutableList<User> paramImmutableList5, boolean paramBoolean)
  {
    this.a = paramImmutableList1;
    this.b = paramImmutableList2;
    this.c = paramImmutableList3;
    this.e = paramImmutableList5;
    this.d = paramImmutableList4;
    this.f = paramBoolean;
  }

  public ImmutableList<User> a()
  {
    return this.a;
  }

  public ImmutableList<User> b()
  {
    return this.b;
  }

  public ImmutableList<User> c()
  {
    return this.c;
  }

  public ImmutableList<User> d()
  {
    return this.d;
  }

  public ImmutableList<User> e()
  {
    return this.e;
  }

  public boolean f()
  {
    return this.f;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.a != null)
      localStringBuilder.append(" favoriteFriends:" + this.a.size());
    if (this.b != null)
      localStringBuilder.append(" topFriends:" + this.b.size());
    if (this.c != null)
      localStringBuilder.append(" onlineFriends:" + this.c.size());
    if (this.e != null)
      localStringBuilder.append(" mobileFriends:" + this.e.size());
    if (this.d != null)
      localStringBuilder.append(" otherContacts:" + this.d.size());
    localStringBuilder.append(" hasPendingUpdates:" + Boolean.toString(this.f));
    return localStringBuilder.toString();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.contacts.divebar.DivebarLoader.Result
 * JD-Core Version:    0.6.0
 */