package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class UploadBulkContactsResult$1
  implements Parcelable.Creator<UploadBulkContactsResult>
{
  public UploadBulkContactsResult a(Parcel paramParcel)
  {
    return new UploadBulkContactsResult(paramParcel, null);
  }

  public UploadBulkContactsResult[] a(int paramInt)
  {
    return new UploadBulkContactsResult[paramInt];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.server.UploadBulkContactsResult.1
 * JD-Core Version:    0.6.0
 */