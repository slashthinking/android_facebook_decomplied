package com.facebook.bookmark;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.bookmark.model.BookmarksGroup;
import com.facebook.orca.server.BaseResult;
import com.facebook.orca.server.DataFreshnessResult;
import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.ArrayList;

public class FetchBookmarksResult extends BaseResult
  implements Parcelable
{
  public static final Parcelable.Creator<FetchBookmarksResult> CREATOR = new FetchBookmarksResult.1();
  private final ImmutableList<BookmarksGroup> a;

  private FetchBookmarksResult(Parcel paramParcel)
  {
    super(paramParcel);
    ArrayList localArrayList = Lists.a();
    paramParcel.readTypedList(localArrayList, BookmarksGroup.CREATOR);
    this.a = ImmutableList.a(localArrayList);
  }

  public FetchBookmarksResult(DataFreshnessResult paramDataFreshnessResult, long paramLong, ImmutableList<BookmarksGroup> paramImmutableList)
  {
    super(paramDataFreshnessResult, paramLong);
    this.a = paramImmutableList;
  }

  public ImmutableList<BookmarksGroup> a()
  {
    return this.a;
  }

  public int describeContents()
  {
    return 0;
  }

  public String toString()
  {
    return Objects.toStringHelper(this).add("mBookmarksGroups", this.a).add("status", e()).add("syncTime", Long.valueOf(f())).toString();
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeTypedList(this.a);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.bookmark.FetchBookmarksResult
 * JD-Core Version:    0.6.2
 */