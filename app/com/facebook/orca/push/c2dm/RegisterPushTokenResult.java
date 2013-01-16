package com.facebook.orca.push.c2dm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.server.BaseResult;
import com.facebook.orca.server.DataFreshnessResult;

public class RegisterPushTokenResult extends BaseResult
  implements Parcelable
{
  public static final Parcelable.Creator<RegisterPushTokenResult> CREATOR = new RegisterPushTokenResult.1();
  private boolean a;
  private boolean b;

  private RegisterPushTokenResult(Parcel paramParcel)
  {
    super(paramParcel);
    boolean bool2;
    if (paramParcel.readInt() != 0)
    {
      bool2 = bool1;
      this.a = bool2;
      if (paramParcel.readInt() == 0)
        break label39;
    }
    while (true)
    {
      this.b = bool1;
      return;
      bool2 = false;
      break;
      label39: bool1 = false;
    }
  }

  public RegisterPushTokenResult(boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    super(DataFreshnessResult.FROM_SERVER, paramLong);
    this.a = paramBoolean1;
    this.b = paramBoolean2;
  }

  public boolean a()
  {
    return this.a;
  }

  public boolean b()
  {
    return this.b;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    super.writeToParcel(paramParcel, paramInt);
    int j;
    if (this.a)
    {
      j = i;
      paramParcel.writeInt(j);
      if (!this.b)
        break label43;
    }
    while (true)
    {
      paramParcel.writeInt(i);
      return;
      j = 0;
      break;
      label43: i = 0;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.push.c2dm.RegisterPushTokenResult
 * JD-Core Version:    0.6.0
 */