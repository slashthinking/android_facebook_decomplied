package com.facebook.ipc.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMDictDestination.PostProcessable;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;
import com.facebook.common.json.jsonmirror.types.JMDict;
import com.fasterxml.jackson.core.JsonParser;

public class FacebookProfile
  implements Parcelable, JMDictDestination.PostProcessable, JMStaticKeysDictDestination
{
  public static final Parcelable.Creator<FacebookProfile> CREATOR = new FacebookProfile.1();
  public static final long INVALID_ID = -1L;
  public static final int TYPE_EVENT = 4;
  public static final int TYPE_GROUP = 3;
  public static final int TYPE_PAGE = 1;
  public static final int TYPE_PLACE_PAGE = 2;
  public static final int TYPE_USER;

  @JMAutogen.InferredType(jsonFieldName="can_post")
  public final boolean mCanPost;
  public final boolean mCanPostKnown;

  @JMAutogen.InferredType(jsonFieldName="name")
  public final String mDisplayName;

  @JMAutogen.InferredType(jsonFieldName="id")
  public final long mId;

  @JMAutogen.InferredType(jsonFieldName="pic_square")
  public final String mImageUrl;
  public final int mType;

  @JMAutogen.InferredType(jsonFieldName="type")
  private String mTypeString;

  public FacebookProfile()
  {
    this.mId = -1L;
    this.mDisplayName = null;
    this.mImageUrl = null;
    this.mType = 0;
    this.mCanPost = false;
    this.mCanPostKnown = false;
  }

  public FacebookProfile(long paramLong, String paramString1, String paramString2, int paramInt)
  {
    this(paramLong, paramString1, paramString2, paramInt, false);
  }

  public FacebookProfile(long paramLong, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    this.mId = paramLong;
    this.mDisplayName = paramString1;
    this.mImageUrl = paramString2;
    this.mType = paramInt;
    this.mCanPost = paramBoolean;
    this.mCanPostKnown = true;
  }

  public FacebookProfile(long paramLong, String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mId = paramLong;
    this.mDisplayName = paramString1;
    this.mImageUrl = paramString2;
    this.mType = paramInt;
    this.mCanPost = paramBoolean1;
    this.mCanPostKnown = paramBoolean2;
  }

  protected FacebookProfile(Parcel paramParcel)
  {
    this.mId = paramParcel.readLong();
    this.mDisplayName = paramParcel.readString();
    this.mImageUrl = paramParcel.readString();
    this.mType = paramParcel.readInt();
    boolean[] arrayOfBoolean = new boolean[2];
    paramParcel.readBooleanArray(arrayOfBoolean);
    this.mCanPost = arrayOfBoolean[0];
    this.mCanPostKnown = arrayOfBoolean[1];
  }

  public static FacebookProfile a(JsonParser paramJsonParser)
  {
    return (FacebookProfile)JMParser.a(paramJsonParser, FacebookProfile.class);
  }

  public void a(JMDict paramJMDict)
  {
    if (this.mTypeString != null)
    {
      if (!this.mTypeString.equals("page"))
        break label33;
      paramJMDict.a(this, "mType", 1L);
    }
    while (true)
    {
      this.mTypeString = null;
      return;
      label33: if (this.mTypeString.equals("group"))
      {
        paramJMDict.a(this, "mType", 3L);
        continue;
      }
      if (!this.mTypeString.equals("event"))
        continue;
      paramJMDict.a(this, "mType", 4L);
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (((paramObject instanceof FacebookProfile)) && (this.mId == ((FacebookProfile)paramObject).mId));
    for (int i = 1; ; i = 0)
      return i;
  }

  public int hashCode()
  {
    return (int)this.mId;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FacebookProfile(").append(this.mDisplayName).append(" (id=").append(this.mId).append("))");
    return localStringBuilder.toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.mId);
    paramParcel.writeString(this.mDisplayName);
    paramParcel.writeString(this.mImageUrl);
    paramParcel.writeInt(this.mType);
    boolean[] arrayOfBoolean = new boolean[2];
    arrayOfBoolean[0] = this.mCanPost;
    arrayOfBoolean[1] = this.mCanPostKnown;
    paramParcel.writeBooleanArray(arrayOfBoolean);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.ipc.model.FacebookProfile
 * JD-Core Version:    0.6.0
 */