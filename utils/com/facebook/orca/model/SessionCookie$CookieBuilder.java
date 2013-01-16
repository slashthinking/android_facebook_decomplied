package com.facebook.orca.model;

import com.google.common.base.Joiner;
import java.util.ArrayList;
import java.util.List;

class SessionCookie$CookieBuilder
{
  private List<String> b = new ArrayList();

  public SessionCookie$CookieBuilder(SessionCookie paramSessionCookie)
  {
  }

  public CookieBuilder a(String paramString)
  {
    this.b.add(paramString);
    return this;
  }

  public CookieBuilder a(String paramString1, String paramString2)
  {
    this.b.add(paramString1 + "=" + paramString2);
    return this;
  }

  public String a()
  {
    return Joiner.on("; ").join(this.b);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.model.SessionCookie.CookieBuilder
 * JD-Core Version:    0.6.2
 */