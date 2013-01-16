package com.facebook.bookmark.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class Bookmark$1
  implements Parcelable.Creator<Bookmark>
{
  public Bookmark a(Parcel paramParcel)
  {
    return new Bookmark(paramParcel, null);
  }

  public Bookmark[] a(int paramInt)
  {
    return new Bookmark[paramInt];
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.model.Bookmark.1
 * JD-Core Version:    0.6.2
 */