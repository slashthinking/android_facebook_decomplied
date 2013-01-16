package com.facebook.orca.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;

public class UserTokenCredentials
  implements Parcelable
{
  public static final Parcelable.Creator<UserTokenCredentials> CREATOR = new UserTokenCredentials.1();
  private final String a;
  private final String b;

  public UserTokenCredentials(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }

  public String a()
  {
    return this.a;
  }

  public String b()
  {
    return this.b;
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    int i = 1;
    if (this == paramObject);
    while (true)
    {
      return i;
      if (!(paramObject instanceof UserTokenCredentials))
      {
        i = 0;
        continue;
      }
      UserTokenCredentials localUserTokenCredentials = (UserTokenCredentials)paramObject;
      if (!Objects.equal(this.a, localUserTokenCredentials.a))
      {
        i = 0;
        continue;
      }
      if (Objects.equal(this.b, localUserTokenCredentials.b))
        continue;
      i = 0;
    }
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.a;
    arrayOfObject[1] = this.b;
    return Objects.hashCode(arrayOfObject);
  }

  public String toString()
  {
    return "UserTokenCredentials{userId='" + this.a + "'}";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeString(this.b);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.auth.UserTokenCredentials
 * JD-Core Version:    0.6.0
 */