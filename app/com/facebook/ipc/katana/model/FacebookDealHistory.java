package com.facebook.ipc.katana.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;

public class FacebookDealHistory
  implements Parcelable, JMStaticKeysDictDestination
{
  public static final Parcelable.Creator<FacebookDealHistory> CREATOR = new FacebookDealHistory.1();
  public static final long INVALID_ID = -1L;

  @JMAutogen.InferredType(jsonFieldName="claim_id")
  public final int mClaimId;

  @JMAutogen.InferredType(jsonFieldName="claim_time")
  public final long mClaimTime;

  @JMAutogen.InferredType(jsonFieldName="promotion_id")
  public final long mDealId;

  @JMAutogen.InferredType(jsonFieldName="expiration_time")
  public final long mExpirationTime;

  private FacebookDealHistory()
  {
    this.mDealId = -1L;
    this.mClaimTime = 0L;
    this.mExpirationTime = 0L;
    this.mClaimId = 0;
  }

  protected FacebookDealHistory(Parcel paramParcel)
  {
    this.mDealId = paramParcel.readLong();
    this.mClaimTime = paramParcel.readLong();
    this.mExpirationTime = paramParcel.readLong();
    this.mClaimId = paramParcel.readInt();
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.mDealId);
    paramParcel.writeLong(this.mClaimTime);
    paramParcel.writeLong(this.mExpirationTime);
    paramParcel.writeInt(this.mClaimId);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.ipc.katana.model.FacebookDealHistory
 * JD-Core Version:    0.6.0
 */