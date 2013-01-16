package com.facebook.ipc.katana.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class FacebookPage
  implements Parcelable, JMStaticKeysDictDestination
{
  public static final Parcelable.Creator<FacebookPage> CREATOR = new FacebookPage.1();
  public static final int INVALID_FAN_COUNT = -1;
  public static final long INVALID_ID = -1L;

  @JMAutogen.InferredType(jsonFieldName="can_post")
  public final boolean mCanPost;

  @JMAutogen.InferredType(jsonFieldName="is_community_page")
  public final boolean mCommunityPage;

  @JMAutogen.InferredType(jsonFieldName="name")
  public final String mDisplayName;

  @JMAutogen.InferredType(jsonFieldName="fan_count")
  public final int mFanCount;

  @JMAutogen.InferredType(jsonFieldName="location")
  public final Map<String, Serializable> mLocation;

  @JMAutogen.InferredType(jsonFieldName="page_id")
  public final long mPageId;

  @JMAutogen.InferredType(jsonFieldName="pic_big")
  public final String mPicBig;

  @JMAutogen.InferredType(jsonFieldName="pic")
  public final String mPicMedium;

  @JMAutogen.InferredType(jsonFieldName="pic_small")
  public final String mPicSmall;

  @JMAutogen.InferredType(jsonFieldName="page_url")
  public final String mUrl;

  protected FacebookPage()
  {
    this.mPageId = -1L;
    this.mDisplayName = null;
    this.mCanPost = false;
    this.mCommunityPage = false;
    this.mPicSmall = null;
    this.mPicMedium = null;
    this.mPicBig = null;
    this.mUrl = null;
    this.mLocation = new HashMap();
    this.mFanCount = -1;
  }

  public FacebookPage(Parcel paramParcel)
  {
    this.mPageId = paramParcel.readLong();
    this.mDisplayName = paramParcel.readString();
    boolean bool2;
    if (paramParcel.readByte() != 0)
    {
      bool2 = bool1;
      this.mCanPost = bool2;
      if (paramParcel.readByte() == 0)
        break label118;
    }
    while (true)
    {
      this.mCommunityPage = bool1;
      this.mPicSmall = paramParcel.readString();
      this.mPicMedium = paramParcel.readString();
      this.mPicBig = paramParcel.readString();
      this.mUrl = paramParcel.readString();
      this.mLocation = new HashMap();
      paramParcel.readMap(this.mLocation, Map.class.getClassLoader());
      this.mFanCount = paramParcel.readInt();
      return;
      bool2 = false;
      break;
      label118: bool1 = false;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    paramParcel.writeLong(this.mPageId);
    paramParcel.writeString(this.mDisplayName);
    int j;
    if (this.mCanPost)
    {
      j = i;
      paramParcel.writeByte((byte)j);
      if (!this.mCommunityPage)
        break label103;
    }
    while (true)
    {
      paramParcel.writeByte((byte)i);
      paramParcel.writeString(this.mPicSmall);
      paramParcel.writeString(this.mPicMedium);
      paramParcel.writeString(this.mPicBig);
      paramParcel.writeString(this.mUrl);
      paramParcel.writeMap(this.mLocation);
      paramParcel.writeInt(this.mFanCount);
      return;
      j = 0;
      break;
      label103: i = 0;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.ipc.katana.model.FacebookPage
 * JD-Core Version:    0.6.0
 */