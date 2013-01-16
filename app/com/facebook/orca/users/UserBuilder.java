package com.facebook.orca.users;

import com.facebook.common.util.TriState;
import java.util.List;

public class UserBuilder
{
  private User.Type a;
  private String b;
  private List<UserEmailAddress> c = null;
  private List<UserPhoneNumber> d = null;
  private Name e;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private PicCropInfo k;
  private PicCropInfo l;
  private String m;
  private float n;
  private TriState o = TriState.UNSET;
  private boolean p;
  private Birthday q;
  private String r;
  private String s;
  private LastActive t;
  private MobileAppData u;
  private String v;

  public User.Type a()
  {
    return this.a;
  }

  public UserBuilder a(float paramFloat)
  {
    this.n = paramFloat;
    return this;
  }

  public UserBuilder a(TriState paramTriState)
  {
    this.o = paramTriState;
    return this;
  }

  public UserBuilder a(Birthday paramBirthday)
  {
    this.q = paramBirthday;
    return this;
  }

  public UserBuilder a(LastActive paramLastActive)
  {
    this.t = paramLastActive;
    return this;
  }

  public UserBuilder a(MobileAppData paramMobileAppData)
  {
    this.u = paramMobileAppData;
    return this;
  }

  public UserBuilder a(Name paramName)
  {
    this.e = paramName;
    return this;
  }

  public UserBuilder a(PicCropInfo paramPicCropInfo)
  {
    this.k = paramPicCropInfo;
    return this;
  }

  public UserBuilder a(User.Type paramType, String paramString)
  {
    this.a = paramType;
    this.b = paramString;
    return this;
  }

  public UserBuilder a(User paramUser)
  {
    this.a = paramUser.a();
    this.b = paramUser.b();
    this.c = paramUser.i();
    this.d = paramUser.j();
    this.e = paramUser.d();
    this.j = paramUser.o();
    this.i = paramUser.p();
    this.k = paramUser.r();
    this.l = paramUser.s();
    this.m = paramUser.t();
    this.n = paramUser.v();
    this.o = paramUser.w();
    this.p = paramUser.x();
    this.q = paramUser.y();
    this.r = paramUser.z();
    this.s = paramUser.A();
    this.t = paramUser.B();
    this.u = paramUser.C();
    this.v = paramUser.D();
    return this;
  }

  public UserBuilder a(String paramString)
  {
    this.f = paramString;
    return this;
  }

  public UserBuilder a(List<UserEmailAddress> paramList)
  {
    this.c = paramList;
    return this;
  }

  public void a(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }

  public UserBuilder b(PicCropInfo paramPicCropInfo)
  {
    this.l = paramPicCropInfo;
    return this;
  }

  public UserBuilder b(String paramString)
  {
    this.g = paramString;
    return this;
  }

  public UserBuilder b(List<UserPhoneNumber> paramList)
  {
    this.d = paramList;
    return this;
  }

  public String b()
  {
    return this.b;
  }

  public UserBuilder c(String paramString)
  {
    this.h = paramString;
    return this;
  }

  public List<UserEmailAddress> c()
  {
    return this.c;
  }

  public UserBuilder d(String paramString)
  {
    this.i = paramString;
    return this;
  }

  public List<UserPhoneNumber> d()
  {
    return this.d;
  }

  public UserBuilder e(String paramString)
  {
    this.j = paramString;
    return this;
  }

  public String e()
  {
    return this.f;
  }

  public UserBuilder f(String paramString)
  {
    this.r = paramString;
    return this;
  }

  public String f()
  {
    return this.g;
  }

  public UserBuilder g(String paramString)
  {
    this.s = paramString;
    return this;
  }

  public String g()
  {
    return this.h;
  }

  public Name h()
  {
    return this.e;
  }

  public UserBuilder h(String paramString)
  {
    this.v = paramString;
    return this;
  }

  public String i()
  {
    return this.i;
  }

  public String j()
  {
    return this.j;
  }

  public PicCropInfo k()
  {
    return this.k;
  }

  public PicCropInfo l()
  {
    return this.l;
  }

  public String m()
  {
    return this.m;
  }

  public float n()
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

  public Birthday q()
  {
    return this.q;
  }

  public String r()
  {
    return this.r;
  }

  public String s()
  {
    return this.s;
  }

  public LastActive t()
  {
    return this.t;
  }

  public MobileAppData u()
  {
    return this.u;
  }

  public String v()
  {
    return this.v;
  }

  public User w()
  {
    return new User(this);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.users.UserBuilder
 * JD-Core Version:    0.6.0
 */