package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class UploadBulkContactFieldMatch$1
  implements Parcelable.Creator<UploadBulkContactFieldMatch>
{
  public UploadBulkContactFieldMatch a(Parcel paramParcel)
  {
    return new UploadBulkContactFieldMatch(paramParcel, null);
  }

  public UploadBulkContactFieldMatch[] a(int paramInt)
  {
    return new UploadBulkContactFieldMatch[paramInt];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.server.UploadBulkContactFieldMatch.1
 * JD-Core Version:    0.6.0
 */