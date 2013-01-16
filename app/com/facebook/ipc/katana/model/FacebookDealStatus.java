package com.facebook.ipc.katana.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;

public class FacebookDealStatus
  implements Parcelable, JMStaticKeysDictDestination
{
  public static final Parcelable.Creator<FacebookDealStatus> CREATOR = new FacebookDealStatus.1();
  public static final long INVALID_ID = -1L;

  @JMAutogen.InferredType(jsonFieldName="promotion_id")
  public final long mDealId;

  @JMAutogen.InferredType(jsonFieldName="status_code")
  public final int mStatusCode;

  @JMAutogen.InferredType(jsonFieldName="status_data")
  public final int mStatusData;

  private FacebookDealStatus()
  {
    this.mDealId = -1L;
    this.mStatusCode = 0;
    this.mStatusData = 0;
  }

  protected FacebookDealStatus(Parcel paramParcel)
  {
    this.mDealId = paramParcel.readLong();
    this.mStatusCode = paramParcel.readInt();
    this.mStatusData = paramParcel.readInt();
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.mDealId);
    paramParcel.writeInt(this.mStatusCode);
    paramParcel.writeInt(this.mStatusData);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.ipc.katana.model.FacebookDealStatus
 * JD-Core Version:    0.6.0
 */