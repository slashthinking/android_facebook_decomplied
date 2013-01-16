package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.server.DataFreshnessParam;
import com.facebook.orca.users.UserKey;
import com.google.common.base.Preconditions;

public class FetchContactParams
  implements Parcelable
{
  public static final Parcelable.Creator<FetchContactParams> CREATOR = new FetchContactParams.1();
  private final UserKey a;
  private final DataFreshnessParam b;

  private FetchContactParams(Parcel paramParcel)
  {
    this.a = UserKey.a(paramParcel.readString());
    this.b = DataFreshnessParam.valueOf(paramParcel.readString());
  }

  public FetchContactParams(DataFreshnessParam paramDataFreshnessParam, UserKey paramUserKey)
  {
    Preconditions.checkNotNull(paramUserKey);
    this.a = paramUserKey;
    this.b = paramDataFreshnessParam;
  }

  public UserKey a()
  {
    return this.a;
  }

  public DataFreshnessParam b()
  {
    return this.b;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a.c());
    paramParcel.writeString(this.b.toString());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.server.FetchContactParams
 * JD-Core Version:    0.6.0
 */