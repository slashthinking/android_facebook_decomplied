package com.facebook.orca.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MarkThreadParams
  implements Parcelable
{
  public static final Parcelable.Creator<MarkThreadParams> CREATOR = new MarkThreadParams.1();
  private final String a;
  private final MarkThreadParams.Mark b;
  private final boolean c;
  private final long d;

  private MarkThreadParams(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = MarkThreadParams.Mark.valueOf(paramParcel.readString());
    if (paramParcel.readInt() != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.c = bool;
      this.d = paramParcel.readLong();
      return;
    }
  }

  public MarkThreadParams(String paramString, MarkThreadParams.Mark paramMark, boolean paramBoolean, long paramLong)
  {
    this.a = paramString;
    this.b = paramMark;
    this.c = paramBoolean;
    this.d = paramLong;
  }

  public String a()
  {
    return this.a;
  }

  public MarkThreadParams.Mark b()
  {
    return this.b;
  }

  public boolean c()
  {
    return this.c;
  }

  public long d()
  {
    return this.d;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b.name());
    if (this.c);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeInt(i);
      paramParcel.writeLong(this.d);
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.MarkThreadParams
 * JD-Core Version:    0.6.0
 */