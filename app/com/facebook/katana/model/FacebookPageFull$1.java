package com.facebook.katana.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.ipc.katana.model.FacebookPage;

final class FacebookPageFull$1
  implements Parcelable.Creator<FacebookPage>
{
  public FacebookPage a(Parcel paramParcel)
  {
    return new FacebookPage(paramParcel);
  }

  public FacebookPage[] a(int paramInt)
  {
    return new FacebookPage[paramInt];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.model.FacebookPageFull.1
 * JD-Core Version:    0.6.0
 */