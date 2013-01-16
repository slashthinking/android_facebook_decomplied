package com.facebook.orca.media;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;
import java.io.File;

public class MediaResource
  implements Parcelable
{
  public static final Parcelable.Creator<MediaResource> CREATOR = new MediaResource.1();
  private final MediaResource.Type a;
  private final Uri b;
  private final String c;
  private final String d;
  private final long e;

  private MediaResource(Parcel paramParcel)
  {
    this.b = ((Uri)paramParcel.readParcelable(null));
    this.a = MediaResource.Type.valueOf(paramParcel.readString());
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    this.e = paramParcel.readLong();
  }

  private MediaResource(MediaResource.Builder paramBuilder)
  {
    this.a = paramBuilder.a();
    this.b = paramBuilder.b();
    this.c = paramBuilder.c();
    this.d = paramBuilder.d();
    this.e = paramBuilder.e();
  }

  public static MediaResource.Builder a()
  {
    return new MediaResource.Builder();
  }

  public static MediaResource a(Uri paramUri)
  {
    return a().a(MediaResource.Type.PHOTO).a(paramUri).f();
  }

  public static MediaResource a(Uri paramUri, long paramLong)
  {
    return a().a(MediaResource.Type.AUDIO).a(paramUri).a(paramLong).f();
  }

  public static MediaResource a(File paramFile)
  {
    return a(Uri.fromFile(paramFile));
  }

  public static MediaResource b(Uri paramUri)
  {
    return a().a(MediaResource.Type.VIDEO).a(paramUri).f();
  }

  public static MediaResource b(File paramFile)
  {
    return b(Uri.fromFile(paramFile));
  }

  public MediaResource.Type b()
  {
    return this.a;
  }

  public Uri c()
  {
    return this.b;
  }

  public String d()
  {
    return this.c;
  }

  public int describeContents()
  {
    return 0;
  }

  public String e()
  {
    return this.d;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject);
    while (true)
    {
      return bool;
      if (!(paramObject instanceof MediaResource))
      {
        bool = false;
      }
      else
      {
        MediaResource localMediaResource = (MediaResource)paramObject;
        if ((!Objects.equal(c(), localMediaResource.c())) || (!Objects.equal(b(), localMediaResource.b())) || (!Objects.equal(Long.valueOf(f()), Long.valueOf(localMediaResource.f()))))
          bool = false;
      }
    }
  }

  public long f()
  {
    return this.e;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.b, paramInt);
    paramParcel.writeString(this.a.name());
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeLong(this.e);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.media.MediaResource
 * JD-Core Version:    0.6.2
 */