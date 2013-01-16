package com.facebook.feed.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class DeleteCommentParams
  implements Parcelable
{
  public static final Parcelable.Creator<DeleteCommentParams> CREATOR = new DeleteCommentParams.1();
  public final String a;
  public String b;

  public DeleteCommentParams(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    if (paramParcel.dataAvail() > 0)
      this.b = paramParcel.readString();
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    if (this.b != null)
      paramParcel.writeString(this.b);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.protocol.DeleteCommentParams
 * JD-Core Version:    0.6.0
 */