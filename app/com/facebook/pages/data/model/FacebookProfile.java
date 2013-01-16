package com.facebook.pages.data.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class FacebookProfile extends com.facebook.ipc.model.FacebookProfile
{
  public static final Parcelable.Creator<FacebookProfile> CREATOR = new FacebookProfile.1();
  public String mByline;

  public FacebookProfile()
  {
    this.mByline = null;
  }

  protected FacebookProfile(Parcel paramParcel)
  {
    super(paramParcel);
    this.mByline = paramParcel.readString();
  }

  public boolean equals(Object paramObject)
  {
    if (((paramObject instanceof FacebookProfile)) && (this.mId == ((FacebookProfile)paramObject).mId));
    for (int i = 1; ; i = 0)
      return i;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.mByline);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.pages.data.model.FacebookProfile
 * JD-Core Version:    0.6.0
 */