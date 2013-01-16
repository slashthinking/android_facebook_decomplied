package com.facebook.orca.users;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class UserWithIdentifier
  implements Parcelable
{
  public static final Parcelable.Creator<UserWithIdentifier> CREATOR = new UserWithIdentifier.1();
  private final User a;
  private final UserIdentifier b;

  private UserWithIdentifier(Parcel paramParcel)
  {
    this.a = ((User)paramParcel.readParcelable(User.class.getClassLoader()));
    this.b = ((UserIdentifier)paramParcel.readParcelable(UserIdentifier.class.getClassLoader()));
  }

  public UserWithIdentifier(User paramUser, UserIdentifier paramUserIdentifier)
  {
    this.a = paramUser;
    this.b = paramUserIdentifier;
  }

  public User a()
  {
    return this.a;
  }

  public UserIdentifier b()
  {
    return this.b;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.a, paramInt);
    paramParcel.writeParcelable(this.b, paramInt);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.users.UserWithIdentifier
 * JD-Core Version:    0.6.0
 */