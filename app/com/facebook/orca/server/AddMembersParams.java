package com.facebook.orca.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.users.UserWithIdentifier;
import com.google.common.collect.ImmutableList;
import java.util.List;

public class AddMembersParams
  implements Parcelable
{
  public static final Parcelable.Creator<AddMembersParams> CREATOR = new AddMembersParams.1();
  private final String a;
  private final ImmutableList<UserWithIdentifier> b;

  private AddMembersParams(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = ImmutableList.a(paramParcel.readArrayList(UserWithIdentifier.class.getClassLoader()));
  }

  public AddMembersParams(String paramString, List<UserWithIdentifier> paramList)
  {
    this.a = paramString;
    this.b = ImmutableList.a(paramList);
  }

  public String a()
  {
    return this.a;
  }

  public ImmutableList<UserWithIdentifier> b()
  {
    return this.b;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeList(this.b);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.AddMembersParams
 * JD-Core Version:    0.6.0
 */