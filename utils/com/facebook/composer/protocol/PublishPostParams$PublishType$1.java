package com.facebook.composer.protocol;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class PublishPostParams$PublishType$1
  implements Parcelable.Creator<PublishPostParams.PublishType>
{
  public PublishPostParams.PublishType a(Parcel paramParcel)
  {
    return PublishPostParams.PublishType.valueOf(paramParcel.readString());
  }

  public PublishPostParams.PublishType[] a(int paramInt)
  {
    return new PublishPostParams.PublishType[paramInt];
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.composer.protocol.PublishPostParams.PublishType.1
 * JD-Core Version:    0.6.2
 */