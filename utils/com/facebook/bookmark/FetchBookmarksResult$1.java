package com.facebook.bookmark;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class FetchBookmarksResult$1
  implements Parcelable.Creator<FetchBookmarksResult>
{
  public FetchBookmarksResult a(Parcel paramParcel)
  {
    return new FetchBookmarksResult(paramParcel, null);
  }

  public FetchBookmarksResult[] a(int paramInt)
  {
    return new FetchBookmarksResult[paramInt];
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.FetchBookmarksResult.1
 * JD-Core Version:    0.6.2
 */