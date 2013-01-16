package com.facebook.orca.threads;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.users.User.Type;
import com.facebook.orca.users.UserKey;
import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;
import com.google.common.base.Preconditions;

public class ParticipantInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ParticipantInfo> CREATOR = new ParticipantInfo.1();
  private final UserKey a;
  private final String b;
  private final String c;

  private ParticipantInfo(Parcel paramParcel)
  {
    this.c = paramParcel.readString();
    this.b = paramParcel.readString();
    this.a = UserKey.a(paramParcel.readString());
  }

  public ParticipantInfo(UserKey paramUserKey, String paramString)
  {
    this(paramUserKey, paramString, null);
  }

  public ParticipantInfo(UserKey paramUserKey, String paramString1, String paramString2)
  {
    Preconditions.checkNotNull(paramUserKey);
    this.a = paramUserKey;
    this.b = paramString1;
    this.c = paramString2;
  }

  public String a()
  {
    return this.c;
  }

  public boolean b()
  {
    if (this.a.a() == User.Type.FACEBOOK);
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean c()
  {
    if (this.a.a() == User.Type.PHONE_NUMBER);
    for (int i = 1; ; i = 0)
      return i;
  }

  public String d()
  {
    return this.b;
  }

  public int describeContents()
  {
    return 0;
  }

  public UserKey e()
  {
    return this.a;
  }

  public String toString()
  {
    return Objects.toStringHelper(ParticipantInfo.class).add("userKey", this.a.c()).add("name", this.b).add("emailAddress", this.c).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.a.c());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threads.ParticipantInfo
 * JD-Core Version:    0.6.0
 */