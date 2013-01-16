package com.facebook.orca.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;

public class SessionCookie
  implements Parcelable, JMStaticKeysDictDestination
{
  public static final Parcelable.Creator<SessionCookie> CREATOR = new SessionCookie.1();
  private static final String DOMAIN = "Domain";
  private static final String EXPIRES = "Expires";
  private static final String PATH = "Path";
  private static final String SECURE = "secure";

  @JMAutogen.InferredType(jsonFieldName="domain")
  private final String mDomain;

  @JMAutogen.InferredType(jsonFieldName="expires")
  private final String mExpires;

  @JMAutogen.InferredType(jsonFieldName="name")
  private final String mName;

  @JMAutogen.InferredType(jsonFieldName="path")
  private String mPath;

  @JMAutogen.InferredType(jsonFieldName="secure")
  private boolean mSecure;

  @JMAutogen.InferredType(jsonFieldName="value")
  private final String mValue;

  private SessionCookie()
  {
    this.mName = null;
    this.mValue = "";
    this.mExpires = null;
    this.mDomain = "";
    this.mSecure = false;
    this.mPath = "";
  }

  public SessionCookie(Parcel paramParcel)
  {
    this.mName = paramParcel.readString();
    this.mValue = paramParcel.readString();
    this.mExpires = paramParcel.readString();
    this.mDomain = paramParcel.readString();
    if (paramParcel.readByte() != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.mSecure = bool;
      this.mPath = paramParcel.readString();
      return;
    }
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    if (this.mName == null);
    SessionCookie.CookieBuilder localCookieBuilder;
    for (String str = null; ; str = localCookieBuilder.a())
    {
      return str;
      localCookieBuilder = new SessionCookie.CookieBuilder(this).a(this.mName, this.mValue);
      if (this.mExpires != null)
        localCookieBuilder.a("Expires", this.mExpires);
      localCookieBuilder.a("Domain", this.mDomain).a("Path", this.mPath);
      if (this.mSecure)
        localCookieBuilder.a("secure");
    }
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.mName);
    paramParcel.writeString(this.mValue);
    paramParcel.writeString(this.mExpires);
    paramParcel.writeString(this.mDomain);
    if (this.mSecure);
    for (int i = 1; ; i = 0)
    {
      paramParcel.writeByte((byte)i);
      paramParcel.writeString(this.mPath);
      return;
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.model.SessionCookie
 * JD-Core Version:    0.6.2
 */