package com.facebook.orca.users;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Birthday
  implements Parcelable
{
  public static final Parcelable.Creator<Birthday> CREATOR = new Birthday.1();
  private final int a;
  private final int b;
  private final int c;

  public Birthday(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
  }

  public Birthday(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readInt();
  }

  public int a()
  {
    return this.a;
  }

  public int b()
  {
    return this.b;
  }

  public int c()
  {
    return this.c;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeInt(this.c);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.users.Birthday
 * JD-Core Version:    0.6.0
 */