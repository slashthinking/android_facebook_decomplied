package com.facebook.orca.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ConfirmPhoneAndRegisterPartialAccountResult extends BaseResult
  implements Parcelable
{
  public static final Parcelable.Creator<ConfirmPhoneAndRegisterPartialAccountResult> CREATOR = new ConfirmPhoneAndRegisterPartialAccountResult.1();
  private final String a;
  private final int b;
  private final String c;
  private final String d;
  private final boolean e;

  private ConfirmPhoneAndRegisterPartialAccountResult(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = paramParcel.readString();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    if (paramParcel.readInt() == i);
    while (true)
    {
      this.e = i;
      return;
      i = 0;
    }
  }

  public ConfirmPhoneAndRegisterPartialAccountResult(DataFreshnessResult paramDataFreshnessResult, String paramString1, int paramInt, String paramString2, String paramString3, boolean paramBoolean, long paramLong)
  {
    super(paramDataFreshnessResult, paramLong);
    this.a = paramString1;
    this.b = paramInt;
    this.c = paramString2;
    this.d = paramString3;
    this.e = paramBoolean;
  }

  public int a()
  {
    return this.b;
  }

  public String b()
  {
    return this.c;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    if (this.e);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeInt(i);
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.ConfirmPhoneAndRegisterPartialAccountResult
 * JD-Core Version:    0.6.0
 */