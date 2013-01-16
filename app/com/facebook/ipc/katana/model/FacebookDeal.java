package com.facebook.ipc.katana.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination.Encoder.SerializableJsonObject;
import java.util.HashMap;
import java.util.Map;

public class FacebookDeal
  implements Parcelable, JMStaticKeysDictDestination
{
  public static final Parcelable.Creator<FacebookDeal> CREATOR = new FacebookDeal.1();
  public static final long INVALID_ID = -1L;

  @JMStaticKeysDictDestination.Encoder.SerializableJsonObject(jsonFieldName="deal_history", type=FacebookDealHistory.class)
  public FacebookDealHistory mDealHistory;

  @JMAutogen.InferredType(jsonFieldName="promotion_id")
  public final long mDealId;

  @JMStaticKeysDictDestination.Encoder.SerializableJsonObject(jsonFieldName="deal_status", type=FacebookDealStatus.class)
  public FacebookDealStatus mDealStatus;

  @JMAutogen.InferredType(jsonFieldName="display_data")
  public final Map<String, String> mDisplayData;

  @JMAutogen.InferredType(jsonFieldName="end_time")
  public final long mEndTime;

  @JMAutogen.InferredType(jsonFieldName="min_checkin")
  public final int mMinCheckin;

  @JMAutogen.InferredType(jsonFieldName="min_tagging")
  public final int mMinTagging;

  @JMAutogen.InferredType(jsonFieldName="num_claimed")
  public final int mNumClaimed;

  @JMAutogen.InferredType(jsonFieldName="num_offered")
  public final int mNumOffered;

  @JMAutogen.InferredType(jsonFieldName="creator_id")
  public final long mPageId;

  private FacebookDeal()
  {
    this.mDealId = -1L;
    this.mPageId = -1L;
    this.mDisplayData = null;
    this.mEndTime = 0L;
    this.mNumClaimed = 0;
    this.mNumOffered = 0;
    this.mMinCheckin = 0;
    this.mMinTagging = 0;
    this.mDealStatus = null;
    this.mDealHistory = null;
  }

  protected FacebookDeal(Parcel paramParcel)
  {
    this.mDealId = paramParcel.readLong();
    this.mPageId = paramParcel.readLong();
    this.mDisplayData = new HashMap();
    paramParcel.readMap(this.mDisplayData, Map.class.getClassLoader());
    this.mEndTime = paramParcel.readLong();
    this.mNumClaimed = paramParcel.readInt();
    this.mNumOffered = paramParcel.readInt();
    this.mMinCheckin = paramParcel.readInt();
    this.mMinTagging = paramParcel.readInt();
    this.mDealStatus = ((FacebookDealStatus)paramParcel.readParcelable(FacebookStatus.class.getClassLoader()));
    this.mDealHistory = ((FacebookDealHistory)paramParcel.readParcelable(FacebookDealHistory.class.getClassLoader()));
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.mDealId);
    paramParcel.writeLong(this.mPageId);
    paramParcel.writeMap(this.mDisplayData);
    paramParcel.writeLong(this.mEndTime);
    paramParcel.writeInt(this.mNumClaimed);
    paramParcel.writeInt(this.mNumOffered);
    paramParcel.writeInt(this.mMinCheckin);
    paramParcel.writeInt(this.mMinTagging);
    paramParcel.writeParcelable(this.mDealStatus, 0);
    paramParcel.writeParcelable(this.mDealHistory, 0);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.ipc.katana.model.FacebookDeal
 * JD-Core Version:    0.6.0
 */