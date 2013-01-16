package com.facebook.orca.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.users.User;
import com.google.common.collect.ImmutableList;
import java.util.List;

public class UpdateFavoriteContactsParams
  implements Parcelable
{
  public static final Parcelable.Creator<UpdateFavoriteContactsParams> CREATOR = new UpdateFavoriteContactsParams.1();
  private final ImmutableList<User> a;

  UpdateFavoriteContactsParams(Parcel paramParcel)
  {
    this.a = ImmutableList.a(paramParcel.readArrayList(User.class.getClassLoader()));
  }

  public UpdateFavoriteContactsParams(List<User> paramList)
  {
    this.a = ImmutableList.a(paramList);
  }

  public ImmutableList<User> a()
  {
    return this.a;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeList(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.UpdateFavoriteContactsParams
 * JD-Core Version:    0.6.0
 */