package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class UploadBulkContactChange$1
  implements Parcelable.Creator<UploadBulkContactChange>
{
  public UploadBulkContactChange a(Parcel paramParcel)
  {
    return new UploadBulkContactChange(paramParcel);
  }

  public UploadBulkContactChange[] a(int paramInt)
  {
    return new UploadBulkContactChange[paramInt];
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.server.UploadBulkContactChange.1
 * JD-Core Version:    0.6.0
 */