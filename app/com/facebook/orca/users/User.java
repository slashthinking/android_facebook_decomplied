package com.facebook.orca.users;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.util.TriState;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

public class User
  implements Parcelable
{
  public static final Parcelable.Creator<User> CREATOR = new User.1();
  private final String a;
  private final User.Type b;
  private final ImmutableList<UserEmailAddress> c;
  private final ImmutableList<UserPhoneNumber> d;
  private final Name e;
  private final String f;
  private final String g;
  private final PicCropInfo h;
  private final PicCropInfo i;
  private final String j;
  private final float k;
  private final TriState l;
  private final boolean m;
  private final Birthday n;
  private final String o;
  private final String p;
  private final LastActive q;
  private final MobileAppData r;
  private final String s;
  private final UserKey t;
  private final ImmutableList<UserIdentifier> u;
  private final UserFbidIdentifier v;

  private User(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = User.Type.valueOf(paramParcel.readString());
    this.t = new UserKey(this.b, this.a);
    this.c = ImmutableList.a(paramParcel.readArrayList(UserEmailAddress.class.getClassLoader()));
    this.d = ImmutableList.a(paramParcel.readArrayList(UserPhoneNumber.class.getClassLoader()));
    this.e = ((Name)paramParcel.readParcelable(Name.class.getClassLoader()));
    this.f = paramParcel.readString();
    this.g = paramParcel.readString();
    this.h = ((PicCropInfo)paramParcel.readParcelable(PicCropInfo.class.getClassLoader()));
    this.i = ((PicCropInfo)paramParcel.readParcelable(PicCropInfo.class.getClassLoader()));
    this.j = paramParcel.readString();
    this.k = paramParcel.readFloat();
    this.l = TriState.valueOf(paramParcel.readString());
    if (paramParcel.readInt() != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.m = bool;
      this.n = ((Birthday)paramParcel.readParcelable(Birthday.class.getClassLoader()));
      this.o = paramParcel.readString();
      this.p = paramParcel.readString();
      this.q = ((LastActive)paramParcel.readParcelable(LastActive.class.getClassLoader()));
      this.r = ((MobileAppData)paramParcel.readParcelable(MobileAppData.class.getClassLoader()));
      this.s = paramParcel.readString();
      this.v = E();
      this.u = F();
      return;
    }
  }

  User(UserBuilder paramUserBuilder)
  {
    this.a = ((String)Preconditions.checkNotNull(paramUserBuilder.b(), "id must not be null"));
    this.b = ((User.Type)Preconditions.checkNotNull(paramUserBuilder.a(), "type must not be null"));
    this.t = new UserKey(this.b, this.a);
    if (paramUserBuilder.c() == null)
    {
      this.c = ImmutableList.d();
      if (paramUserBuilder.d() != null)
        break label234;
    }
    label234: for (this.d = ImmutableList.d(); ; this.d = ImmutableList.a(paramUserBuilder.d()))
    {
      this.e = a(paramUserBuilder);
      this.f = paramUserBuilder.i();
      this.g = paramUserBuilder.j();
      this.h = paramUserBuilder.k();
      this.i = paramUserBuilder.l();
      this.j = paramUserBuilder.m();
      this.k = paramUserBuilder.n();
      this.l = paramUserBuilder.o();
      this.m = paramUserBuilder.p();
      this.n = paramUserBuilder.q();
      this.o = paramUserBuilder.r();
      this.p = paramUserBuilder.s();
      this.q = paramUserBuilder.t();
      this.r = paramUserBuilder.u();
      this.s = paramUserBuilder.v();
      this.v = E();
      this.u = F();
      return;
      this.c = ImmutableList.a(paramUserBuilder.c());
      break;
    }
  }

  private UserFbidIdentifier E()
  {
    if (this.b == User.Type.FACEBOOK);
    for (UserFbidIdentifier localUserFbidIdentifier = new UserFbidIdentifier(this.a); ; localUserFbidIdentifier = null)
      return localUserFbidIdentifier;
  }

  private ImmutableList<UserIdentifier> F()
  {
    ImmutableList.Builder localBuilder = ImmutableList.e();
    if (this.v != null)
      localBuilder.b(this.v);
    localBuilder.b(this.c);
    localBuilder.b(this.d);
    return localBuilder.b();
  }

  private static Name a(UserBuilder paramUserBuilder)
  {
    if (paramUserBuilder.h() != null);
    for (Name localName = paramUserBuilder.h(); ; localName = new Name(paramUserBuilder.f(), paramUserBuilder.g(), paramUserBuilder.e()))
      return localName;
  }

  public String A()
  {
    return this.p;
  }

  public LastActive B()
  {
    return this.q;
  }

  public MobileAppData C()
  {
    return this.r;
  }

  public String D()
  {
    return this.s;
  }

  public User.Type a()
  {
    return this.b;
  }

  public String b()
  {
    return this.a;
  }

  public UserKey c()
  {
    return this.t;
  }

  public Name d()
  {
    return this.e;
  }

  public int describeContents()
  {
    return 0;
  }

  public String e()
  {
    return this.e.getFirstName();
  }

  public String f()
  {
    return this.e.getDisplayName();
  }

  public String g()
  {
    return this.e.f();
  }

  public UserFbidIdentifier h()
  {
    return this.v;
  }

  public ImmutableList<UserEmailAddress> i()
  {
    return this.c;
  }

  public ImmutableList<UserPhoneNumber> j()
  {
    return this.d;
  }

  public boolean k()
  {
    if (!this.c.isEmpty());
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public String l()
  {
    if (this.c.isEmpty());
    for (String str = null; ; str = ((UserEmailAddress)this.c.get(0)).a())
      return str;
  }

  public boolean m()
  {
    if (!this.d.isEmpty());
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public UserPhoneNumber n()
  {
    if (this.d.isEmpty());
    for (UserPhoneNumber localUserPhoneNumber = null; ; localUserPhoneNumber = (UserPhoneNumber)this.d.get(0))
      return localUserPhoneNumber;
  }

  public String o()
  {
    return this.g;
  }

  public String p()
  {
    return this.f;
  }

  public Uri q()
  {
    if (this.g != null);
    for (Uri localUri = Uri.parse(this.g); ; localUri = null)
      return localUri;
  }

  public PicCropInfo r()
  {
    return this.h;
  }

  public PicCropInfo s()
  {
    return this.i;
  }

  public String t()
  {
    return this.j;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.e).append(" ");
    localStringBuilder.append(this.a).append(" [").append(this.b).append("] ");
    if (!this.c.isEmpty())
      localStringBuilder.append(this.c.get(0)).append(" ");
    if (!this.d.isEmpty())
      localStringBuilder.append(this.d.get(0)).append(" ");
    return localStringBuilder.toString();
  }

  public ImmutableList<UserIdentifier> u()
  {
    return this.u;
  }

  public float v()
  {
    return this.k;
  }

  public TriState w()
  {
    return this.l;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b.name());
    paramParcel.writeList(this.c);
    paramParcel.writeList(this.d);
    paramParcel.writeParcelable(this.e, paramInt);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.g);
    paramParcel.writeParcelable(this.h, paramInt);
    paramParcel.writeParcelable(this.i, paramInt);
    paramParcel.writeString(this.j);
    paramParcel.writeFloat(this.k);
    paramParcel.writeString(this.l.name());
    if (this.m);
    for (int i1 = 1; ; i1 = 0)
    {
      paramParcel.writeInt(i1);
      paramParcel.writeParcelable(this.n, paramInt);
      paramParcel.writeString(this.o);
      paramParcel.writeString(this.p);
      paramParcel.writeParcelable(this.q, paramInt);
      paramParcel.writeParcelable(this.r, paramInt);
      paramParcel.writeString(this.s);
      return;
    }
  }

  public boolean x()
  {
    return this.m;
  }

  public Birthday y()
  {
    return this.n;
  }

  public String z()
  {
    return this.o;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.users.User
 * JD-Core Version:    0.6.0
 */