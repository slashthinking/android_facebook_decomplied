package com.facebook.katana.view.findfriends;

import com.facebook.katana.model.FacebookPhonebookContactUser;

public class FriendCandidate
{
  public final FacebookPhonebookContactUser a;
  public final String b;
  private boolean c = false;
  private String d = null;

  public FriendCandidate(FacebookPhonebookContactUser paramFacebookPhonebookContactUser)
  {
    this.a = paramFacebookPhonebookContactUser;
    this.b = this.a.name;
  }

  public void a()
  {
    this.c = true;
  }

  public void a(String paramString)
  {
    this.d = paramString;
  }

  public void b()
  {
    this.c = false;
  }

  public boolean c()
  {
    if (this.c)
      b();
    for (int i = 0; ; i = 1)
    {
      return i;
      a();
    }
  }

  public boolean d()
  {
    return this.c;
  }

  public String e()
  {
    return this.d;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.view.findfriends.FriendCandidate
 * JD-Core Version:    0.6.0
 */