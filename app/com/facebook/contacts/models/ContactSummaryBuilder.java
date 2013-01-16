package com.facebook.contacts.models;

import com.facebook.common.util.TriState;
import com.facebook.orca.users.Name;
import com.google.common.collect.ImmutableList;

public class ContactSummaryBuilder
{
  private String a;
  private String b;
  private String c;
  private Name d;
  private String e;
  private String f;
  private String g;
  private Name h;
  private String i;
  private String j;
  private float k;
  private String l;
  private ImmutableList<ContactPhone> m = ImmutableList.d();
  private boolean n;
  private TriState o = TriState.UNSET;
  private boolean p;

  public ContactSummaryBuilder a(float paramFloat)
  {
    this.k = paramFloat;
    return this;
  }

  public ContactSummaryBuilder a(TriState paramTriState)
  {
    this.o = paramTriState;
    return this;
  }

  public ContactSummaryBuilder a(Name paramName)
  {
    this.d = paramName;
    return this;
  }

  public ContactSummaryBuilder a(ImmutableList<ContactPhone> paramImmutableList)
  {
    this.m = paramImmutableList;
    return this;
  }

  public ContactSummaryBuilder a(String paramString)
  {
    this.a = paramString;
    return this;
  }

  public ContactSummaryBuilder a(boolean paramBoolean)
  {
    this.n = paramBoolean;
    return this;
  }

  public String a()
  {
    return this.a;
  }

  public ContactSummaryBuilder b(Name paramName)
  {
    this.h = paramName;
    return this;
  }

  public ContactSummaryBuilder b(String paramString)
  {
    this.b = paramString;
    return this;
  }

  public ContactSummaryBuilder b(boolean paramBoolean)
  {
    this.p = paramBoolean;
    return this;
  }

  public String b()
  {
    return this.b;
  }

  public ContactSummaryBuilder c(String paramString)
  {
    this.c = paramString;
    return this;
  }

  public String c()
  {
    return this.c;
  }

  public ContactSummaryBuilder d(String paramString)
  {
    this.e = paramString;
    return this;
  }

  public Name d()
  {
    return this.d;
  }

  public ContactSummaryBuilder e(String paramString)
  {
    this.i = paramString;
    return this;
  }

  public Name e()
  {
    return this.h;
  }

  public ContactSummaryBuilder f(String paramString)
  {
    this.j = paramString;
    return this;
  }

  public String f()
  {
    return this.e;
  }

  public ContactSummaryBuilder g(String paramString)
  {
    this.l = paramString;
    return this;
  }

  public String g()
  {
    return this.f;
  }

  public String h()
  {
    return this.g;
  }

  public String i()
  {
    return this.i;
  }

  public String j()
  {
    return this.j;
  }

  public float k()
  {
    return this.k;
  }

  public String l()
  {
    return this.l;
  }

  public ImmutableList<ContactPhone> m()
  {
    return this.m;
  }

  public boolean n()
  {
    return this.n;
  }

  public TriState o()
  {
    return this.o;
  }

  public boolean p()
  {
    return this.p;
  }

  public ContactSummary q()
  {
    return new ContactSummary(this);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.models.ContactSummaryBuilder
 * JD-Core Version:    0.6.0
 */