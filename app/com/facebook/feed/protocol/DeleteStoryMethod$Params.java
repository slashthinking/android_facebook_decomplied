package com.facebook.feed.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class DeleteStoryMethod$Params
  implements Parcelable
{
  public static final Parcelable.Creator<Params> CREATOR = new DeleteStoryMethod.Params.1();
  public final String a;

  public DeleteStoryMethod$Params(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
  }

  public DeleteStoryMethod$Params(String paramString)
  {
    this.a = paramString;
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
 * Qualified Name:     com.facebook.feed.protocol.DeleteStoryMethod.Params
 * JD-Core Version:    0.6.0
 */