package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

public class UploadBulkContactsParams
  implements Parcelable
{
  public static final Parcelable.Creator<UploadBulkContactsParams> CREATOR = new UploadBulkContactsParams.1();
  private final String a;
  private final ImmutableList<UploadBulkContactChange> b;

  private UploadBulkContactsParams(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = ImmutableList.a(paramParcel.readArrayList(UploadBulkContactChange.class.getClassLoader()));
  }

  public UploadBulkContactsParams(String paramString, ImmutableList<UploadBulkContactChange> paramImmutableList)
  {
    boolean bool2;
    boolean bool3;
    if ((paramString == null) || (paramString.length() > 0))
    {
      bool2 = bool1;
      Preconditions.checkArgument(bool2);
      if (paramImmutableList == null)
        break label65;
      bool3 = bool1;
      label32: Preconditions.checkArgument(bool3);
      if (paramImmutableList.isEmpty())
        break label71;
    }
    while (true)
    {
      Preconditions.checkArgument(bool1);
      this.a = paramString;
      this.b = paramImmutableList;
      return;
      bool2 = false;
      break;
      label65: bool3 = false;
      break label32;
      label71: bool1 = false;
    }
  }

  public String a()
  {
    return this.a;
  }

  public ImmutableList<UploadBulkContactChange> b()
  {
    return this.b;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeList(this.b);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.server.UploadBulkContactsParams
 * JD-Core Version:    0.6.0
 */