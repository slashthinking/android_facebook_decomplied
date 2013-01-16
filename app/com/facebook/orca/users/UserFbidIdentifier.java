package com.facebook.orca.users;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class UserFbidIdentifier extends UserIdentifier
  implements Parcelable
{
  public static final Parcelable.Creator<UserFbidIdentifier> CREATOR = new UserFbidIdentifier.1();
  private final UserIdentifierKey a;

  private UserFbidIdentifier(Parcel paramParcel)
  {
    this.a = new UserIdentifierKey(UserIdentifier.IdentifierType.FBID, paramParcel.readString());
  }

  public UserFbidIdentifier(String paramString)
  {
    this.a = new UserIdentifierKey(UserIdentifier.IdentifierType.EMAIL, paramString);
  }

  public String a()
  {
    return this.a.b;
  }

  public String a(Resources paramResources)
  {
    return this.a.b;
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
    return UserIdentifier.IdentifierType.FBID;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(d());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.users.UserFbidIdentifier
 * JD-Core Version:    0.6.0
 */