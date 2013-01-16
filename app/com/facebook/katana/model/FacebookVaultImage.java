package com.facebook.katana.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;

public class FacebookVaultImage
  implements Parcelable, JMStaticKeysDictDestination
{
  public static final Parcelable.Creator<FacebookVaultImage> CREATOR = new FacebookVaultImage.1();

  @JMAutogen.InferredType(jsonFieldName="date_taken")
  public final long mDateTaken;
  public boolean mDeleted;

  @JMAutogen.InferredType(jsonFieldName="device_oid")
  public final long mDeviceId;

  @JMAutogen.InferredType(jsonFieldName="object_id")
  public final long mFbid;

  @JMAutogen.InferredType(jsonFieldName="owner_id")
  public final long mOwnerId;

  @JMAutogen.InferredType(jsonFieldName="remote_id")
  public final long mRemoteId;

  private FacebookVaultImage()
  {
    this.mFbid = 0L;
    this.mOwnerId = 0L;
    this.mRemoteId = 0L;
    this.mDateTaken = 0L;
    this.mDeviceId = 0L;
    this.mDeleted = false;
  }

  protected FacebookVaultImage(Parcel paramParcel)
  {
    this.mFbid = paramParcel.readLong();
    this.mOwnerId = paramParcel.readLong();
    this.mRemoteId = paramParcel.readLong();
    this.mDateTaken = paramParcel.readLong();
    this.mDeviceId = paramParcel.readLong();
    this.mDeleted = false;
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    return this.mFbid + "," + this.mOwnerId + "," + this.mRemoteId + "," + this.mDateTaken + "," + this.mDeviceId + "," + this.mDeleted;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.mFbid);
    paramParcel.writeLong(this.mOwnerId);
    paramParcel.writeLong(this.mRemoteId);
    paramParcel.writeLong(this.mDateTaken);
    paramParcel.writeLong(this.mDeviceId);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.model.FacebookVaultImage
 * JD-Core Version:    0.6.0
 */