package com.facebook.orca.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.orca.users.User;
import com.google.common.collect.ImmutableList;

public class ModifyThreadResult extends BaseResult
  implements Parcelable
{
  public static final Parcelable.Creator<ModifyThreadResult> CREATOR = new ModifyThreadResult.1();
  private final ThreadSummary a;
  private final ImmutableList<User> b;

  private ModifyThreadResult(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = ((ThreadSummary)paramParcel.readParcelable(ThreadSummary.class.getClassLoader()));
    this.b = ImmutableList.a(paramParcel.readArrayList(User.class.getClassLoader()));
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.a, paramInt);
    paramParcel.writeList(this.b);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.ModifyThreadResult
 * JD-Core Version:    0.6.0
 */