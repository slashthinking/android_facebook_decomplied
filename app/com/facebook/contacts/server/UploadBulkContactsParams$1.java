package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class UploadBulkContactsParams$1
  implements Parcelable.Creator<UploadBulkContactsParams>
{
  public UploadBulkContactsParams a(Parcel paramParcel)
  {
    return new UploadBulkContactsParams(paramParcel, null);
  }

  public UploadBulkContactsParams[] a(int paramInt)
  {
    return new UploadBulkContactsParams[paramInt];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.server.UploadBulkContactsParams.1
 * JD-Core Version:    0.6.0
 */