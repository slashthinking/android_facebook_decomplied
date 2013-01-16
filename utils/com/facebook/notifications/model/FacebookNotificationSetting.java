package com.facebook.notifications.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMParser;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;

public class FacebookNotificationSetting
  implements Parcelable, JMStaticKeysDictDestination
{
  public static final Parcelable.Creator<FacebookNotificationSetting> CREATOR = new FacebookNotificationSetting.1();

  @JMAutogen.InferredType(jsonFieldName="setting_id")
  public final String settingId;

  @JMAutogen.InferredType(jsonFieldName="setting_value")
  public final String settingValue;

  private FacebookNotificationSetting()
  {
    this.settingId = null;
    this.settingValue = null;
  }

  public FacebookNotificationSetting(Parcel paramParcel)
  {
    this.settingId = paramParcel.readString();
    this.settingValue = paramParcel.readString();
  }

  public static FacebookNotificationSetting a(JsonParser paramJsonParser)
  {
    return (FacebookNotificationSetting)JMParser.a(paramJsonParser, FacebookNotificationSetting.class);
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof FacebookNotificationSetting;
    boolean bool2 = false;
    if (bool1)
    {
      FacebookNotificationSetting localFacebookNotificationSetting = (FacebookNotificationSetting)paramObject;
      boolean bool3 = Objects.equal(localFacebookNotificationSetting.settingId, this.settingId);
      bool2 = false;
      if (bool3)
      {
        boolean bool4 = Objects.equal(localFacebookNotificationSetting.settingValue, this.settingValue);
        bool2 = false;
        if (bool4)
          bool2 = true;
      }
    }
    return bool2;
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.settingId;
    arrayOfObject[1] = this.settingValue;
    return Objects.hashCode(arrayOfObject);
  }

  public String toString()
  {
    return Objects.toStringHelper(this).add("setting ID", this.settingId).add("setting value", this.settingValue).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.settingId);
    paramParcel.writeString(this.settingValue);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.notifications.model.FacebookNotificationSetting
 * JD-Core Version:    0.6.2
 */