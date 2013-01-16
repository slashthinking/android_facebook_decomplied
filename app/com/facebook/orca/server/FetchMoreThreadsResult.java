package com.facebook.orca.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.threads.FolderName;
import com.facebook.orca.threads.ThreadsCollection;
import com.facebook.orca.users.User;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

public class FetchMoreThreadsResult extends BaseResult
  implements Parcelable
{
  public static final Parcelable.Creator<FetchMoreThreadsResult> CREATOR = new FetchMoreThreadsResult.1();
  private final FolderName a;
  private final ThreadsCollection b;
  private final ImmutableList<User> c;
  private final ImmutableMap<FolderName, FetchMoreThreadsResult> d;

  private FetchMoreThreadsResult(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = ((FolderName)paramParcel.readParcelable(FolderName.class.getClassLoader()));
    this.b = ((ThreadsCollection)paramParcel.readParcelable(ThreadsCollection.class.getClassLoader()));
    this.c = ImmutableList.a(paramParcel.readArrayList(User.class.getClassLoader()));
    this.d = ((ImmutableMap)paramParcel.readSerializable());
  }

  public FetchMoreThreadsResult(DataFreshnessResult paramDataFreshnessResult, FolderName paramFolderName, ThreadsCollection paramThreadsCollection, ImmutableList<User> paramImmutableList, long paramLong)
  {
    super(paramDataFreshnessResult, paramLong);
    this.a = paramFolderName;
    this.b = paramThreadsCollection;
    this.c = paramImmutableList;
    this.d = null;
  }

  public FetchMoreThreadsResult(DataFreshnessResult paramDataFreshnessResult, FolderName paramFolderName, ThreadsCollection paramThreadsCollection, ImmutableList<User> paramImmutableList, long paramLong, ImmutableMap<FolderName, FetchMoreThreadsResult> paramImmutableMap)
  {
    super(paramDataFreshnessResult, paramLong);
    this.a = paramFolderName;
    this.b = paramThreadsCollection;
    this.c = paramImmutableList;
    this.d = paramImmutableMap;
  }

  public FolderName a()
  {
    return this.a;
  }

  public ThreadsCollection b()
  {
    return this.b;
  }

  public ImmutableList<User> c()
  {
    return this.c;
  }

  public ImmutableMap<FolderName, FetchMoreThreadsResult> d()
  {
    return this.d;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.a, paramInt);
    paramParcel.writeParcelable(this.b, paramInt);
    paramParcel.writeList(this.c);
    paramParcel.writeSerializable(this.d);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.FetchMoreThreadsResult
 * JD-Core Version:    0.6.0
 */