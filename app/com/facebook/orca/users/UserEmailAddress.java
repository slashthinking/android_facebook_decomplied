package com.facebook.orca.users;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class UserEmailAddress extends UserIdentifier
  implements Parcelable
{
  public static final Parcelable.Creator<UserEmailAddress> CREATOR = new UserEmailAddress.1();
  private final UserIdentifierKey a;
  private final String b;
  private final int c;

  private UserEmailAddress(Parcel paramParcel)
  {
    this.a = new UserIdentifierKey(UserIdentifier.IdentifierType.EMAIL, paramParcel.readString());
    this.b = paramParcel.readString();
    this.c = paramParcel.readInt();
  }

  public UserEmailAddress(String paramString, int paramInt)
  {
    this.a = new UserIdentifierKey(UserIdentifier.IdentifierType.EMAIL, paramString.toLowerCase());
    this.b = paramString;
    this.c = paramInt;
  }

  public String a()
  {
    return d();
  }

  public String a(Resources paramResources)
  {
    return this.b;
  }

  public int b()
  {
    return this.c;
  }

  public UserIdentifierKey c()
  {
    return this.a;
  }

  public String d()
  {
    return this.a.b;
  }

  public int describeContents()
  {
    return 0;
  }

  public UserIdentifier.IdentifierType e()
  {
    return UserIdentifier.IdentifierType.EMAIL;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(d());
    paramParcel.writeString(this.b);
    paramParcel.writeInt(this.c);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.users.UserEmailAddress
 * JD-Core Version:    0.6.0
 */