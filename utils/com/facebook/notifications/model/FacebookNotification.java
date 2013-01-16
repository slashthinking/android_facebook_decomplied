package com.facebook.notifications.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;
import com.facebook.common.util.Log;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;
import org.json.JSONException;
import org.json.JSONObject;

public class FacebookNotification
  implements Parcelable, JMStaticKeysDictDestination
{
  private static final Class<?> CLSTAG = FacebookNotification.class;
  public static final Parcelable.Creator<FacebookNotification> CREATOR = new FacebookNotification.1();
  private static final String TAG = CLSTAG.getSimpleName();

  @JMAutogen.InferredType(jsonFieldName="mobile_href")
  public final String href;

  @JMAutogen.InferredType(jsonFieldName="icon_url")
  public final String iconUrl;

  @JMAutogen.InferredType(jsonFieldName="is_unread")
  public final boolean isUnread;

  @JMAutogen.InferredType(jsonFieldName="join_data")
  public final String joinDataString;

  @JMAutogen.InferredType(jsonFieldName="notification_id")
  public final long notificationId;

  @JMAutogen.InferredType(jsonFieldName="object_id")
  public final String objectId;

  @JMAutogen.InferredType(jsonFieldName="object_type")
  public final String objectType;

  @JMAutogen.InferredType(jsonFieldName="sender_id")
  public final long senderId;

  @JMAutogen.InferredType(jsonFieldName="title_text")
  public final String title;

  @JMAutogen.InferredType(jsonFieldName="updated_time")
  public final long updatedTime;

  private FacebookNotification()
  {
    this.title = null;
    this.senderId = -1L;
    this.notificationId = 0L;
    this.updatedTime = 0L;
    this.href = null;
    this.isUnread = false;
    this.objectId = null;
    this.objectType = null;
    this.joinDataString = null;
    this.iconUrl = null;
  }

  public FacebookNotification(Parcel paramParcel)
  {
    this.title = paramParcel.readString();
    this.senderId = paramParcel.readLong();
    this.notificationId = paramParcel.readLong();
    this.updatedTime = paramParcel.readLong();
    this.href = paramParcel.readString();
    if (paramParcel.readByte() == i);
    while (true)
    {
      this.isUnread = i;
      this.objectId = paramParcel.readString();
      this.objectType = paramParcel.readString();
      this.joinDataString = paramParcel.readString();
      this.iconUrl = paramParcel.readString();
      return;
      i = 0;
    }
  }

  FacebookNotification(FacebookNotificationBuilder paramFacebookNotificationBuilder)
  {
    this.title = paramFacebookNotificationBuilder.d();
    this.senderId = paramFacebookNotificationBuilder.b();
    this.notificationId = paramFacebookNotificationBuilder.a();
    this.updatedTime = paramFacebookNotificationBuilder.c();
    this.href = paramFacebookNotificationBuilder.e();
    this.isUnread = paramFacebookNotificationBuilder.f();
    this.objectId = paramFacebookNotificationBuilder.g();
    this.objectType = paramFacebookNotificationBuilder.h();
    this.joinDataString = paramFacebookNotificationBuilder.j();
    this.iconUrl = paramFacebookNotificationBuilder.i();
  }

  public static FacebookNotification a(JsonParser paramJsonParser)
  {
    return (FacebookNotification)JMParser.a(paramJsonParser, FacebookNotification.class);
  }

  public JSONObject a()
  {
    if (this.joinDataString != null);
    while (true)
    {
      try
      {
        localJSONObject = new JSONObject(this.joinDataString);
        return localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        Log.c(TAG, "unable to parse join data ", localJSONException);
      }
      JSONObject localJSONObject = null;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof FacebookNotification;
    boolean bool2 = false;
    if (bool1)
    {
      FacebookNotification localFacebookNotification = (FacebookNotification)paramObject;
      boolean bool3 = Objects.equal(localFacebookNotification.title, this.title);
      bool2 = false;
      if (bool3)
      {
        boolean bool4 = Objects.equal(Long.valueOf(localFacebookNotification.senderId), Long.valueOf(this.senderId));
        bool2 = false;
        if (bool4)
        {
          boolean bool5 = Objects.equal(Long.valueOf(localFacebookNotification.notificationId), Long.valueOf(this.notificationId));
          bool2 = false;
          if (bool5)
          {
            boolean bool6 = Objects.equal(Long.valueOf(localFacebookNotification.updatedTime), Long.valueOf(this.updatedTime));
            bool2 = false;
            if (bool6)
            {
              boolean bool7 = Objects.equal(localFacebookNotification.href, this.href);
              bool2 = false;
              if (bool7)
              {
                boolean bool8 = Objects.equal(Boolean.valueOf(localFacebookNotification.isUnread), Boolean.valueOf(this.isUnread));
                bool2 = false;
                if (bool8)
                {
                  boolean bool9 = Objects.equal(localFacebookNotification.objectId, this.objectId);
                  bool2 = false;
                  if (bool9)
                  {
                    boolean bool10 = Objects.equal(localFacebookNotification.objectType, this.objectType);
                    bool2 = false;
                    if (bool10)
                    {
                      boolean bool11 = Objects.equal(localFacebookNotification.joinDataString, this.joinDataString);
                      bool2 = false;
                      if (bool11)
                      {
                        boolean bool12 = Objects.equal(localFacebookNotification.iconUrl, this.iconUrl);
                        bool2 = false;
                        if (bool12)
                          bool2 = true;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool2;
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[10];
    arrayOfObject[0] = this.title;
    arrayOfObject[1] = Long.valueOf(this.senderId);
    arrayOfObject[2] = Long.valueOf(this.notificationId);
    arrayOfObject[3] = Long.valueOf(this.updatedTime);
    arrayOfObject[4] = this.href;
    arrayOfObject[5] = Boolean.valueOf(this.isUnread);
    arrayOfObject[6] = this.objectId;
    arrayOfObject[7] = this.objectType;
    arrayOfObject[8] = this.joinDataString;
    arrayOfObject[9] = this.iconUrl;
    return Objects.hashCode(arrayOfObject);
  }

  public String toString()
  {
    return Objects.toStringHelper(this).add("title", this.title).add("sender ID", Long.valueOf(this.senderId)).add("notification ID", Long.valueOf(this.notificationId)).add("updated time", Long.valueOf(this.updatedTime)).add("href", this.href).add("is unread", Boolean.valueOf(this.isUnread)).add("object ID", this.objectId).add("object type", this.objectType).add("join data", this.joinDataString).add("icon URL", this.iconUrl).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.title);
    paramParcel.writeLong(this.senderId);
    paramParcel.writeLong(this.notificationId);
    paramParcel.writeLong(this.updatedTime);
    paramParcel.writeString(this.href);
    if (this.isUnread);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeByte((byte)i);
      paramParcel.writeString(this.objectId);
      paramParcel.writeString(this.objectType);
      paramParcel.writeString(this.joinDataString);
      paramParcel.writeString(this.iconUrl);
      return;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.model.FacebookNotification
 * JD-Core Version:    0.6.2
 */