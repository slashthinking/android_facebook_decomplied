package com.facebook.orca.users;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class LastActive
  implements Parcelable
{
  public static final Parcelable.Creator<LastActive> CREATOR = new LastActive.1();
  private final long a;
  private final boolean b;

  public LastActive(long paramLong, boolean paramBoolean)
  {
    this.a = paramLong;
    this.b = paramBoolean;
  }

  public LastActive(Parcel paramParcel)
  {
    this.a = paramParcel.readLong();
    if (paramParcel.readInt() == i);
    while (true)
    {
      this.b = i;
      return;
      i = 0;
    }
  }

  public long a()
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

  public boolean equals(Object paramObject)
  {
    int i = 1;
    if (this == paramObject);
    while (true)
    {
      return i;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
      {
        i = 0;
        continue;
      }
      LastActive localLastActive = (LastActive)paramObject;
      if (this.b != localLastActive.b)
      {
        i = 0;
        continue;
      }
      if (this.a == localLastActive.a)
        continue;
      i = 0;
    }
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.a);
    if (this.b);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeInt(i);
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.users.LastActive
 * JD-Core Version:    0.6.0
 */