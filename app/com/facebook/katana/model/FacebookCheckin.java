package com.facebook.katana.model;

import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination.Encoder.SerializableJsonObject;
import com.facebook.ipc.katana.model.FacebookUser;
import java.util.Comparator;

public class FacebookCheckin
  implements JMStaticKeysDictDestination
{
  public static final long INVALID_ID = -1L;
  public static final String LOCATION_POST_TYPE_CHECKIN = "checkin";
  public static final String LOCATION_POST_TYPE_PHOTO = "photo";
  public static final String LOCATION_POST_TYPE_STATUS = "status";
  public static final Comparator<FacebookCheckin> checkinsByTimeComparator = new FacebookCheckin.1();

  @JMStaticKeysDictDestination.Encoder.SerializableJsonObject(jsonFieldName="actor", type=FacebookUser.class)
  protected FacebookUser mActor;

  @JMAutogen.InferredType(jsonFieldName="actor_uid")
  public final long mActorId;

  @JMStaticKeysDictDestination.Encoder.SerializableJsonObject(jsonFieldName="checkin_details", type=FacebookCheckinDetails.class)
  protected FacebookCheckinDetails mCheckinDetails;

  @JMAutogen.InferredType(jsonFieldName="checkin_id")
  public final long mCheckinId;

  private FacebookCheckin()
  {
    this.mActorId = -1L;
    this.mCheckinId = -1L;
  }

  public FacebookCheckin(long paramLong1, long paramLong2)
  {
    this.mActorId = paramLong1;
    this.mCheckinId = paramLong2;
  }

  public FacebookCheckinDetails a()
  {
    return this.mCheckinDetails;
  }

  public void a(FacebookUser paramFacebookUser)
  {
    this.mActor = paramFacebookUser;
  }

  public void a(FacebookCheckinDetails paramFacebookCheckinDetails)
  {
    this.mCheckinDetails = paramFacebookCheckinDetails;
  }

  public FacebookUser b()
  {
    return this.mActor;
  }

  public String c()
  {
    return this.mCheckinDetails.mAuthorId + "_" + this.mCheckinId;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.model.FacebookCheckin
 * JD-Core Version:    0.6.0
 */