package com.facebook.orca.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.users.User;

public class GetMeUserResult extends BaseResult
  implements Parcelable
{
  public static final Parcelable.Creator<GetMeUserResult> CREATOR = new GetMeUserResult.1();
  private final User a;

  private GetMeUserResult(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = ((User)paramParcel.readParcelable(User.class.getClassLoader()));
  }

  public GetMeUserResult(DataFreshnessResult paramDataFreshnessResult, User paramUser, long paramLong)
  {
    super(paramDataFreshnessResult, paramLong);
    this.a = paramUser;
  }

  public User a()
  {
    return this.a;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.a, paramInt);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.GetMeUserResult
 * JD-Core Version:    0.6.0
 */