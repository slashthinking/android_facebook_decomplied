package com.facebook.composer.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public enum PublishPostParams$PublishType
  implements Parcelable
{
  public static final Parcelable.Creator<PublishType> CREATOR = new PublishPostParams.PublishType.1();

  static
  {
    PHOTO = new PublishType("PHOTO", 1);
    CHECK_IN = new PublishType("CHECK_IN", 2);
    SHARE = new PublishType("SHARE", 3);
    PublishType[] arrayOfPublishType = new PublishType[4];
    arrayOfPublishType[0] = STATUS;
    arrayOfPublishType[1] = PHOTO;
    arrayOfPublishType[2] = CHECK_IN;
    arrayOfPublishType[3] = SHARE;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(name());
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.composer.protocol.PublishPostParams.PublishType
 * JD-Core Version:    0.6.2
 */