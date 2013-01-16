package com.facebook.orca.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class DeleteThreadParams
  implements Parcelable
{
  public static final Parcelable.Creator<DeleteThreadParams> CREATOR = new DeleteThreadParams.1();
  private final String a;

  private DeleteThreadParams(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
  }

  public DeleteThreadParams(String paramString)
  {
    this.a = paramString;
  }

  public String a()
  {
    return this.a;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.DeleteThreadParams
 * JD-Core Version:    0.6.0
 */