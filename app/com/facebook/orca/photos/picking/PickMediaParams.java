package com.facebook.orca.photos.picking;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.EnumSet;
import java.util.Iterator;

public class PickMediaParams
  implements Parcelable
{
  public static final Parcelable.Creator<PickMediaParams> CREATOR;
  private static final EnumSet<MediaChoiceDialog.ButtonOption> a = EnumSet.of(MediaChoiceDialog.ButtonOption.CAMERA, MediaChoiceDialog.ButtonOption.GALLERY, MediaChoiceDialog.ButtonOption.IMAGE_SEARCH);
  private String b;
  private boolean c;
  private int d;
  private int e;
  private int f;
  private int g;
  private EnumSet<MediaChoiceDialog.ButtonOption> h;

  static
  {
    CREATOR = new PickMediaParams.1();
  }

  private PickMediaParams(Parcel paramParcel)
  {
    this.b = paramParcel.readString();
    if (paramParcel.readInt() != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.c = bool;
      this.d = paramParcel.readInt();
      this.e = paramParcel.readInt();
      this.f = paramParcel.readInt();
      this.g = paramParcel.readInt();
      this.h = EnumSet.noneOf(MediaChoiceDialog.ButtonOption.class);
      int j = paramParcel.readInt();
      while (i < j)
      {
        this.h.add(MediaChoiceDialog.ButtonOption.valueOf(paramParcel.readString()));
        i++;
      }
    }
  }

  public PickMediaParams(boolean paramBoolean)
  {
    this.b = "";
    if (paramBoolean);
    for (EnumSet localEnumSet = EnumSet.copyOf(a); ; localEnumSet = EnumSet.noneOf(MediaChoiceDialog.ButtonOption.class))
    {
      this.h = localEnumSet;
      return;
    }
  }

  public PickMediaParams a(int paramInt)
  {
    this.d = paramInt;
    return this;
  }

  public PickMediaParams a(MediaChoiceDialog.ButtonOption paramButtonOption)
  {
    this.h.add(paramButtonOption);
    return this;
  }

  public PickMediaParams a(String paramString)
  {
    this.b = paramString;
    return this;
  }

  public PickMediaParams a(boolean paramBoolean)
  {
    this.c = paramBoolean;
    return this;
  }

  public String a()
  {
    return this.b;
  }

  public PickMediaParams b(int paramInt)
  {
    this.e = paramInt;
    return this;
  }

  public boolean b()
  {
    return this.c;
  }

  public int c()
  {
    return this.d;
  }

  public PickMediaParams c(int paramInt)
  {
    this.f = paramInt;
    return this;
  }

  public int d()
  {
    return this.e;
  }

  public PickMediaParams d(int paramInt)
  {
    this.g = paramInt;
    return this;
  }

  public int describeContents()
  {
    return 0;
  }

  public int e()
  {
    return this.f;
  }

  public int f()
  {
    return this.g;
  }

  public EnumSet<MediaChoiceDialog.ButtonOption> g()
  {
    return this.h;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.b);
    if (this.c);
    for (int i = 0; ; i = 1)
    {
      paramParcel.writeInt(i);
      paramParcel.writeInt(this.d);
      paramParcel.writeInt(this.e);
      paramParcel.writeInt(this.f);
      paramParcel.writeInt(this.g);
      paramParcel.writeInt(this.h.size());
      Iterator localIterator = this.h.iterator();
      while (localIterator.hasNext())
        paramParcel.writeString(((MediaChoiceDialog.ButtonOption)localIterator.next()).name());
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.photos.picking.PickMediaParams
 * JD-Core Version:    0.6.0
 */