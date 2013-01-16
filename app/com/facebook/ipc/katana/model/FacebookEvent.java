package com.facebook.ipc.katana.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.jsonmirror.JMAutogen;
import com.facebook.common.json.jsonmirror.JMAutogen.ExplicitType;
import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;
import com.facebook.ipc.util.StringUtil.JMStrippedString;
import com.facebook.ipc.util.TimeUtil;
import com.fasterxml.jackson.core.JsonParser;

public class FacebookEvent
  implements Parcelable, JMStaticKeysDictDestination
{
  public static final Parcelable.Creator<FacebookEvent> CREATOR;
  public static final long INVALID_ID = -1L;
  private static final Class<?> TAG = FacebookEvent.class;

  @JMAutogen.InferredType(jsonFieldName="end_time")
  protected long mEndTime;

  @JMAutogen.InferredType(jsonFieldName="eid")
  protected long mEventId;

  @JMAutogen.ExplicitType(jsonFieldName="name", type=StringUtil.JMStrippedString.class)
  protected String mName;

  @JMAutogen.InferredType(jsonFieldName="pic_square")
  protected String mPicSquare;

  @JMAutogen.InferredType(jsonFieldName="start_time")
  protected long mStartTime;

  static
  {
    CREATOR = new FacebookEvent.1();
  }

  protected FacebookEvent()
  {
    this.mEventId = -1L;
    this.mName = null;
    this.mPicSquare = null;
  }

  protected FacebookEvent(Parcel paramParcel)
  {
    this.mEventId = paramParcel.readLong();
    this.mName = paramParcel.readString();
    this.mPicSquare = paramParcel.readString();
    this.mStartTime = paramParcel.readLong();
    this.mEndTime = paramParcel.readLong();
  }

  public static FacebookEvent a(JsonParser paramJsonParser)
  {
    Object localObject = JMParser.a(paramJsonParser, JMAutogen.a(FacebookEvent.class));
    if ((localObject instanceof FacebookEvent));
    for (FacebookEvent localFacebookEvent = (FacebookEvent)localObject; ; localFacebookEvent = null)
      return localFacebookEvent;
  }

  public long a()
  {
    return this.mEventId;
  }

  public String b()
  {
    return this.mName;
  }

  public String c()
  {
    return this.mPicSquare;
  }

  public long d()
  {
    return TimeUtil.a(this.mStartTime);
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof FacebookEvent;
    int i = 0;
    if (!bool1);
    while (true)
    {
      return i;
      boolean bool2 = ((FacebookEvent)paramObject).mEventId < this.mEventId;
      i = 0;
      if (bool2)
        continue;
      i = 1;
    }
  }

  public int hashCode()
  {
    return (int)this.mEventId;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.mEventId);
    paramParcel.writeString(this.mName);
    paramParcel.writeString(this.mPicSquare);
    paramParcel.writeLong(this.mStartTime);
    paramParcel.writeLong(this.mEndTime);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.ipc.katana.model.FacebookEvent
 * JD-Core Version:    0.6.0
 */