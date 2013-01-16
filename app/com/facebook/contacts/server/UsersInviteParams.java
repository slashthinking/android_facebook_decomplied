package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.users.User;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

public class UsersInviteParams
  implements Parcelable
{
  public static final Parcelable.Creator<UsersInviteParams> CREATOR = new UsersInviteParams.1();
  private final ImmutableList<User> a;
  private final String b;

  UsersInviteParams(Parcel paramParcel)
  {
    this.a = ImmutableList.a(paramParcel.readArrayList(User.class.getClassLoader()));
    this.b = paramParcel.readString();
  }

  public UsersInviteParams(ImmutableList<User> paramImmutableList, String paramString)
  {
    boolean bool2;
    boolean bool3;
    label28: boolean bool4;
    if (paramImmutableList != null)
    {
      bool2 = bool1;
      Preconditions.checkArgument(bool2);
      if (paramImmutableList.isEmpty())
        break label73;
      bool3 = bool1;
      Preconditions.checkArgument(bool3);
      if (paramString == null)
        break label79;
      bool4 = bool1;
      label40: Preconditions.checkArgument(bool4);
      if (paramString.length() <= 0)
        break label85;
    }
    while (true)
    {
      Preconditions.checkArgument(bool1);
      this.a = paramImmutableList;
      this.b = paramString;
      return;
      bool2 = false;
      break;
      label73: bool3 = false;
      break label28;
      label79: bool4 = false;
      break label40;
      label85: bool1 = false;
    }
  }

  public ImmutableList<User> a()
  {
    return this.a;
  }

  public String b()
  {
    return this.b;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeList(this.a);
    paramParcel.writeString(this.b);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.server.UsersInviteParams
 * JD-Core Version:    0.6.0
 */