package com.facebook.orca.users;

import android.graphics.RectF;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.jsonmirror.JMAutogen.InferredType;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination;
import com.google.common.base.Objects;

public class PicCropInfo
  implements Parcelable, JMStaticKeysDictDestination
{
  public static final Parcelable.Creator<PicCropInfo> CREATOR = new PicCropInfo.1();
  private static final int DEFAULT_SIZE_PX = 100;

  @JMAutogen.InferredType(jsonFieldName="bottom")
  private final float bottom;

  @JMAutogen.InferredType(jsonFieldName="height")
  private final int height;

  @JMAutogen.InferredType(jsonFieldName="left")
  private final float left;

  @JMAutogen.InferredType(jsonFieldName="right")
  private final float right;

  @JMAutogen.InferredType(jsonFieldName="top")
  private final float top;

  @JMAutogen.InferredType(jsonFieldName="uri")
  private final String url;

  @JMAutogen.InferredType(jsonFieldName="width")
  private final int width;

  private PicCropInfo()
  {
    this.url = null;
    this.width = 0;
    this.height = 0;
    this.left = 0.0F;
    this.right = 0.0F;
    this.top = 0.0F;
    this.bottom = 0.0F;
  }

  private PicCropInfo(Parcel paramParcel)
  {
    this.url = paramParcel.readString();
    this.width = paramParcel.readInt();
    this.height = paramParcel.readInt();
    this.left = paramParcel.readFloat();
    this.top = paramParcel.readFloat();
    this.right = paramParcel.readFloat();
    this.bottom = paramParcel.readFloat();
  }

  public PicCropInfo(String paramString, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.url = paramString;
    this.width = paramInt1;
    this.height = paramInt2;
    this.left = paramFloat1;
    this.top = paramFloat2;
    this.right = paramFloat3;
    this.bottom = paramFloat4;
  }

  public static PicCropInfo a(String paramString)
  {
    return a(paramString, 100);
  }

  public static PicCropInfo a(String paramString, int paramInt)
  {
    return new PicCropInfo(paramString, paramInt, paramInt, 0.0F, 0.0F, 1.0F, 1.0F);
  }

  public String a()
  {
    return this.url;
  }

  public Uri b()
  {
    return Uri.parse(this.url);
  }

  public int c()
  {
    return this.width;
  }

  public int d()
  {
    return this.height;
  }

  public int describeContents()
  {
    return 0;
  }

  public float e()
  {
    return this.left;
  }

  public boolean equals(Object paramObject)
  {
    int i = 1;
    if (this == paramObject);
    while (true)
    {
      return i;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
      {
        i = 0;
        continue;
      }
      PicCropInfo localPicCropInfo = (PicCropInfo)paramObject;
      if (!a().equals(localPicCropInfo.a()))
      {
        i = 0;
        continue;
      }
      if (c() != localPicCropInfo.c())
      {
        i = 0;
        continue;
      }
      if (d() != localPicCropInfo.d())
      {
        i = 0;
        continue;
      }
      if (e() != localPicCropInfo.e())
      {
        i = 0;
        continue;
      }
      if (f() != localPicCropInfo.f())
      {
        i = 0;
        continue;
      }
      if (g() != localPicCropInfo.g())
      {
        i = 0;
        continue;
      }
      if (h() == localPicCropInfo.h())
        continue;
      i = 0;
    }
  }

  public float f()
  {
    return this.top;
  }

  public float g()
  {
    return this.right;
  }

  public float h()
  {
    return this.bottom;
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[7];
    arrayOfObject[0] = a();
    arrayOfObject[1] = Integer.valueOf(c());
    arrayOfObject[2] = Integer.valueOf(d());
    arrayOfObject[3] = Float.valueOf(e());
    arrayOfObject[4] = Float.valueOf(f());
    arrayOfObject[5] = Float.valueOf(g());
    arrayOfObject[6] = Float.valueOf(h());
    return Objects.hashCode(arrayOfObject);
  }

  public boolean i()
  {
    if ((this.left >= 0.0F) && (this.right <= 1.0F) && (this.left < this.right) && (this.right != 0.0F) && (this.top >= 0.0F) && (this.bottom <= 1.0F) && (this.top < this.bottom) && (this.bottom != 0.0F));
    for (int i = 1; ; i = 0)
      return i;
  }

  public RectF j()
  {
    return new RectF(this.left, this.top, this.right, this.bottom);
  }

  public String toString()
  {
    return "PicCropInfo <" + a() + "> (" + c() + "x" + d() + ") (" + e() + ", " + f() + ", " + g() + ", " + h() + ")";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.url);
    paramParcel.writeInt(this.width);
    paramParcel.writeInt(this.height);
    paramParcel.writeFloat(this.left);
    paramParcel.writeFloat(this.top);
    paramParcel.writeFloat(this.right);
    paramParcel.writeFloat(this.bottom);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.users.PicCropInfo
 * JD-Core Version:    0.6.0
 */