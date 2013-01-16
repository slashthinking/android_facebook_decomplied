package com.facebook.ipc.katana.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination.Encoder.SerializableJsonObject;

public class FacebookPlace
  implements Parcelable, JMStaticKeysDictDestination
{
  public static final Parcelable.Creator<FacebookPlace> CREATOR = new FacebookPlace.1();
  public static final double INVALID_COORDINATE = -200.0D;

  @JMAutogen.InferredType(jsonFieldName="checkin_count")
  public final int mCheckinCount;

  @JMStaticKeysDictDestination.Encoder.SerializableJsonObject(jsonFieldName="deal", type=FacebookDeal.class)
  protected FacebookDeal mDeal;

  @JMAutogen.InferredType(jsonFieldName="display_subtext")
  public final String mDisplaySubtext;

  @JMStaticKeysDictDestination.Encoder.SerializableJsonObject(jsonFieldName="event", type=FacebookEvent.class)
  protected FacebookEvent mEvent;

  @JMAutogen.InferredType(jsonFieldName="latitude")
  public final double mLatitude;

  @JMAutogen.InferredType(jsonFieldName="longitude")
  public final double mLongitude;

  @JMAutogen.InferredType(jsonFieldName="name")
  public final String mName;

  @JMAutogen.InferredType(jsonFieldName="page_id")
  public final long mPageId;

  @JMStaticKeysDictDestination.Encoder.SerializableJsonObject(jsonFieldName="page_info", type=FacebookPage.class)
  protected FacebookPage mPageInfo;

  @JMAutogen.InferredType(jsonFieldName="pic_square")
  public final String mPicUrl;

  private FacebookPlace()
  {
    this.mPageId = -1L;
    this.mName = null;
    this.mDisplaySubtext = null;
    this.mLatitude = -200.0D;
    this.mLongitude = -200.0D;
    this.mCheckinCount = 0;
    this.mPicUrl = null;
    this.mPageInfo = null;
    this.mDeal = null;
    this.mEvent = null;
  }

  public FacebookPlace(long paramLong, String paramString1, String paramString2, double paramDouble1, double paramDouble2, int paramInt, String paramString3)
  {
    this.mPageId = paramLong;
    this.mName = paramString1;
    this.mDisplaySubtext = paramString2;
    this.mLatitude = paramDouble1;
    this.mLongitude = paramDouble2;
    this.mCheckinCount = paramInt;
    this.mPicUrl = paramString3;
    this.mPageInfo = null;
    this.mDeal = null;
    this.mEvent = null;
  }

  protected FacebookPlace(Parcel paramParcel)
  {
    this.mPageId = paramParcel.readLong();
    this.mName = paramParcel.readString();
    this.mLatitude = paramParcel.readDouble();
    this.mLongitude = paramParcel.readDouble();
    this.mCheckinCount = paramParcel.readInt();
    this.mDisplaySubtext = paramParcel.readString();
    this.mPicUrl = paramParcel.readString();
    this.mPageInfo = ((FacebookPage)paramParcel.readParcelable(FacebookPage.class.getClassLoader()));
    this.mDeal = ((FacebookDeal)paramParcel.readParcelable(FacebookDeal.class.getClassLoader()));
    this.mEvent = ((FacebookEvent)paramParcel.readParcelable(FacebookEvent.class.getClassLoader()));
  }

  public FacebookPlace(FacebookEvent paramFacebookEvent)
  {
    this.mPageId = paramFacebookEvent.a();
    this.mName = paramFacebookEvent.b();
    this.mDisplaySubtext = null;
    this.mLatitude = -200.0D;
    this.mLongitude = -200.0D;
    this.mCheckinCount = 0;
    this.mPicUrl = paramFacebookEvent.c();
    this.mPageInfo = null;
    this.mDeal = null;
    this.mEvent = paramFacebookEvent;
  }

  public FacebookPage a()
  {
    return this.mPageInfo;
  }

  public void a(FacebookDeal paramFacebookDeal)
  {
    this.mDeal = paramFacebookDeal;
  }

  public void a(FacebookPage paramFacebookPage)
  {
    this.mPageInfo = paramFacebookPage;
  }

  public FacebookDeal b()
  {
    return this.mDeal;
  }

  public FacebookEvent c()
  {
    return this.mEvent;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.mPageId);
    paramParcel.writeString(this.mName);
    paramParcel.writeDouble(this.mLatitude);
    paramParcel.writeDouble(this.mLongitude);
    paramParcel.writeInt(this.mCheckinCount);
    paramParcel.writeString(this.mDisplaySubtext);
    paramParcel.writeString(this.mPicUrl);
    paramParcel.writeParcelable(this.mPageInfo, 0);
    paramParcel.writeParcelable(this.mDeal, 0);
    paramParcel.writeParcelable(this.mEvent, 0);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.ipc.katana.model.FacebookPlace
 * JD-Core Version:    0.6.0
 */