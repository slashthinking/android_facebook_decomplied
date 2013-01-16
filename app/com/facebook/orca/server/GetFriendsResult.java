package com.facebook.orca.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.users.User;
import com.google.common.collect.ImmutableList;

public class GetFriendsResult extends BaseResult
  implements Parcelable
{
  public static final Parcelable.Creator<GetFriendsResult> CREATOR = new GetFriendsResult.1();
  private final ImmutableList<User> a;
  private final boolean b;
  private final ImmutableList<String> c;
  private final String d;

  private GetFriendsResult(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = ImmutableList.a(paramParcel.readArrayList(User.class.getClassLoader()));
    if (paramParcel.readInt() != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.b = bool;
      this.c = ImmutableList.a(paramParcel.createStringArrayList());
      this.d = paramParcel.readString();
      return;
    }
  }

  public GetFriendsResult(DataFreshnessResult paramDataFreshnessResult, ImmutableList<User> paramImmutableList, boolean paramBoolean, ImmutableList<String> paramImmutableList1, String paramString, long paramLong)
  {
    super(paramDataFreshnessResult, paramLong);
    this.a = paramImmutableList;
    this.b = paramBoolean;
    this.c = paramImmutableList1;
    this.d = paramString;
  }

  public ImmutableList<User> a()
  {
    return this.a;
  }

  public boolean b()
  {
    return this.b;
  }

  public ImmutableList<String> c()
  {
    return this.c;
  }

  public String d()
  {
    return this.d;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeList(this.a);
    if (this.b);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeInt(i);
      paramParcel.writeList(this.c);
      paramParcel.writeString(this.d);
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.GetFriendsResult
 * JD-Core Version:    0.6.0
 */