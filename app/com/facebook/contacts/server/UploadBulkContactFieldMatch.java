package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class UploadBulkContactFieldMatch
  implements Parcelable
{
  public static final Parcelable.Creator<UploadBulkContactFieldMatch> CREATOR = new UploadBulkContactFieldMatch.1();
  private final UploadBulkContactFieldMatch.MatchType a;
  private final UploadBulkContactFieldMatch.ValueType b;

  private UploadBulkContactFieldMatch(Parcel paramParcel)
  {
    this.a = ((UploadBulkContactFieldMatch.MatchType)Enum.valueOf(UploadBulkContactFieldMatch.MatchType.class, paramParcel.readString()));
    this.b = ((UploadBulkContactFieldMatch.ValueType)Enum.valueOf(UploadBulkContactFieldMatch.ValueType.class, paramParcel.readString()));
  }

  public UploadBulkContactFieldMatch(UploadBulkContactFieldMatch.MatchType paramMatchType, UploadBulkContactFieldMatch.ValueType paramValueType)
  {
    this.a = paramMatchType;
    this.b = paramValueType;
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    return super.toString() + " match type: " + this.a + " value type: " + this.b;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a.toString());
    paramParcel.writeString(this.b.toString());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.server.UploadBulkContactFieldMatch
 * JD-Core Version:    0.6.0
 */