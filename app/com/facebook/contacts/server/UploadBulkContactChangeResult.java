package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.ImmutableList;

public class UploadBulkContactChangeResult
  implements Parcelable
{
  public static final Parcelable.Creator<UploadBulkContactChangeResult> CREATOR = new UploadBulkContactChangeResult.1();
  private final UploadBulkContactChangeResult.Type a;
  private final String b;
  private final String c;
  private final ImmutableList<UploadBulkContactFieldMatch> d;
  private final UploadBulkContactChangeResult.Confidence e;

  private UploadBulkContactChangeResult(Parcel paramParcel)
  {
    this.a = ((UploadBulkContactChangeResult.Type)Enum.valueOf(UploadBulkContactChangeResult.Type.class, paramParcel.readString()));
    this.b = paramParcel.readString();
    this.c = paramParcel.readString();
    this.d = ImmutableList.a(paramParcel.readArrayList(UploadBulkContactFieldMatch.class.getClassLoader()));
    this.e = ((UploadBulkContactChangeResult.Confidence)Enum.valueOf(UploadBulkContactChangeResult.Confidence.class, paramParcel.readString()));
  }

  public UploadBulkContactChangeResult(UploadBulkContactChangeResult.Type paramType, String paramString1, String paramString2, ImmutableList<UploadBulkContactFieldMatch> paramImmutableList, UploadBulkContactChangeResult.Confidence paramConfidence)
  {
    this.a = paramType;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramImmutableList;
    this.e = paramConfidence;
  }

  public UploadBulkContactChangeResult.Type a()
  {
    return this.a;
  }

  public String b()
  {
    return this.b;
  }

  public String c()
  {
    return this.c;
  }

  public UploadBulkContactChangeResult.Confidence d()
  {
    return this.e;
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    return "UploadBulkContactChangeResult (" + this.a + ") confidence: " + this.e + " local id: [" + this.b + "] -> remote id: [" + this.c + "]";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a.toString());
    paramParcel.writeString(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeList(this.d);
    paramParcel.writeString(this.e.toString());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.server.UploadBulkContactChangeResult
 * JD-Core Version:    0.6.0
 */