package com.facebook.katana.model;

import com.facebook.common.json.jsonmirror.JMAutogen.IgnoreUnexpectedJsonFields;
import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMAutogen.ListType;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination.Encoder.SerializableJsonObject;
import com.facebook.common.json.jsonmirror.types.JMLong;
import com.facebook.ipc.katana.model.FacebookPlace;
import java.util.Collections;
import java.util.List;

@JMAutogen.IgnoreUnexpectedJsonFields
public class FacebookCheckinDetails
  implements JMStaticKeysDictDestination
{

  @JMAutogen.InferredType(jsonFieldName="app_id")
  public final long mAppId;

  @JMStaticKeysDictDestination.Encoder.SerializableJsonObject(jsonFieldName="app_info", type=FacebookApp.class)
  protected FacebookApp mAppInfo;

  @JMAutogen.InferredType(jsonFieldName="author_uid")
  public final long mAuthorId;

  @JMAutogen.InferredType(jsonFieldName="checkin_id")
  public final long mCheckinId;

  @JMAutogen.InferredType(jsonFieldName="page_id")
  public final long mPageId;

  @JMStaticKeysDictDestination.Encoder.SerializableJsonObject(jsonFieldName="place_info", type=FacebookPlace.class)
  protected FacebookPlace mPlaceInfo;

  @JMAutogen.ListType(b={JMLong.class}, jsonFieldName="tagged_uids")
  public List<Long> mTaggedUids;

  @JMAutogen.InferredType(jsonFieldName="timestamp")
  public final long mTimestamp;

  @JMAutogen.InferredType(jsonFieldName="type")
  public final String mType;

  private FacebookCheckinDetails()
  {
    this.mCheckinId = -1L;
    this.mAuthorId = -1L;
    this.mPageId = -1L;
    this.mTimestamp = 0L;
    this.mTaggedUids = Collections.EMPTY_LIST;
    this.mType = "";
    this.mAppId = 0L;
  }

  public FacebookCheckinDetails(long paramLong1, long paramLong2, long paramLong3, long paramLong4, List<Long> paramList, String paramString, long paramLong5)
  {
    this.mCheckinId = paramLong1;
    this.mAuthorId = paramLong2;
    this.mPageId = paramLong3;
    this.mTimestamp = paramLong4;
    this.mTaggedUids = paramList;
    this.mType = paramString;
    this.mAppId = paramLong5;
  }

  public FacebookPlace a()
  {
    return this.mPlaceInfo;
  }

  public void a(FacebookPlace paramFacebookPlace)
  {
    this.mPlaceInfo = paramFacebookPlace;
  }

  public void a(FacebookApp paramFacebookApp)
  {
    this.mAppInfo = paramFacebookApp;
  }

  public FacebookApp b()
  {
    return this.mAppInfo;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.model.FacebookCheckinDetails
 * JD-Core Version:    0.6.0
 */