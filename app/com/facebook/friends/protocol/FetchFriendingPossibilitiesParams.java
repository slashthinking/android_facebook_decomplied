package com.facebook.friends.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class FetchFriendingPossibilitiesParams
  implements Parcelable
{
  public static final Parcelable.Creator<FetchFriendingPossibilitiesParams> CREATOR;
  private static final int[] d = { 34, 40, 43, 50, 57, 60, 64, 68, 74, 80, 86, 100, 111, 114, 120, 130, 148, 160, 320 };
  public final int a;
  public final int b;
  public final String c;

  static
  {
    CREATOR = new FetchFriendingPossibilitiesParams.1();
  }

  public FetchFriendingPossibilitiesParams(int paramInt1, int paramInt2, String paramString)
  {
    this.a = a(paramInt1);
    this.b = paramInt2;
    this.c = paramString;
  }

  public FetchFriendingPossibilitiesParams(Parcel paramParcel)
  {
    this.a = paramParcel.readInt();
    this.b = paramParcel.readInt();
    this.c = paramParcel.readString();
  }

  private int a(int paramInt)
  {
    int[] arrayOfInt = d;
    int i = arrayOfInt.length;
    int j = 0;
    int k;
    if (j < i)
    {
      k = arrayOfInt[j];
      if (k <= paramInt);
    }
    while (true)
    {
      return k;
      j++;
      break;
      k = d[(-1 + d.length)];
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeString(this.c);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.friends.protocol.FetchFriendingPossibilitiesParams
 * JD-Core Version:    0.6.0
 */