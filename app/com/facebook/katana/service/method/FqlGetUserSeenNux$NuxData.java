package com.facebook.katana.service.method;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;

class FqlGetUserSeenNux$NuxData
  implements Parcelable, JMStaticKeysDictDestination
{
  public static final Parcelable.Creator<NuxData> CREATOR = new FqlGetUserSeenNux.NuxData.1();
  private static final long INVALID_ID = -1L;

  @JMAutogen.InferredType(jsonFieldName="app_id")
  public final long projectID;

  public FqlGetUserSeenNux$NuxData()
  {
    this.projectID = -1L;
  }

  public FqlGetUserSeenNux$NuxData(Parcel paramParcel)
  {
    this.projectID = paramParcel.readLong();
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.projectID);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.service.method.FqlGetUserSeenNux.NuxData
 * JD-Core Version:    0.6.0
 */