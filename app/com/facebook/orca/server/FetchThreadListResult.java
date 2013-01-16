package com.facebook.orca.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.notify.NotificationSetting;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.threads.FolderCounts;
import com.facebook.orca.threads.FolderName;
import com.facebook.orca.threads.ThreadsCollection;
import com.facebook.orca.users.User;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

public class FetchThreadListResult extends BaseResult
  implements Parcelable
{
  public static final Parcelable.Creator<FetchThreadListResult> CREATOR = new FetchThreadListResult.1();
  private final FolderName a;
  private final ThreadsCollection b;
  private final ImmutableList<User> c;
  private final ImmutableList<String> d;
  private final ImmutableList<String> e;
  private final FolderCounts f;
  private final NotificationSetting g;
  private final boolean h;
  private final long i;
  private final boolean j;
  private final ImmutableMap<FolderName, FetchThreadListResult> k;
  private final ServiceException l;

  private FetchThreadListResult(Parcel paramParcel)
  {
    super(paramParcel);
    this.a = ((FolderName)paramParcel.readParcelable(FolderName.class.getClassLoader()));
    this.b = ((ThreadsCollection)paramParcel.readParcelable(ThreadsCollection.class.getClassLoader()));
    this.c = ImmutableList.a(paramParcel.readArrayList(User.class.getClassLoader()));
    this.f = ((FolderCounts)paramParcel.readParcelable(FolderCounts.class.getClassLoader()));
    this.g = ((NotificationSetting)paramParcel.readParcelable(NotificationSetting.class.getClassLoader()));
    this.d = ImmutableList.a(paramParcel.createStringArrayList());
    this.e = ImmutableList.a(paramParcel.createStringArrayList());
    boolean bool2;
    if (paramParcel.readInt() != 0)
    {
      bool2 = bool1;
      this.h = bool2;
      this.i = paramParcel.readLong();
      if (paramParcel.readInt() == 0)
        break label176;
    }
    while (true)
    {
      this.j = bool1;
      this.k = ((ImmutableMap)paramParcel.readSerializable());
      this.l = ((ServiceException)paramParcel.readParcelable(ServiceException.class.getClassLoader()));
      return;
      bool2 = false;
      break;
      label176: bool1 = false;
    }
  }

  FetchThreadListResult(FetchThreadListResultBuilder paramFetchThreadListResultBuilder)
  {
    super(paramFetchThreadListResultBuilder.a(), paramFetchThreadListResultBuilder.j());
    Preconditions.checkNotNull(paramFetchThreadListResultBuilder.a());
    this.a = paramFetchThreadListResultBuilder.b();
    this.b = paramFetchThreadListResultBuilder.c();
    this.c = ImmutableList.a(paramFetchThreadListResultBuilder.d());
    this.d = ImmutableList.a(paramFetchThreadListResultBuilder.e());
    this.e = ImmutableList.a(paramFetchThreadListResultBuilder.f());
    this.f = paramFetchThreadListResultBuilder.g();
    this.g = paramFetchThreadListResultBuilder.h();
    this.h = paramFetchThreadListResultBuilder.i();
    this.i = paramFetchThreadListResultBuilder.k();
    this.j = paramFetchThreadListResultBuilder.l();
    if (paramFetchThreadListResultBuilder.m() != null);
    for (ImmutableMap localImmutableMap = ImmutableMap.a(paramFetchThreadListResultBuilder.m()); ; localImmutableMap = null)
    {
      this.k = localImmutableMap;
      this.l = paramFetchThreadListResultBuilder.n();
      return;
    }
  }

  public static FetchThreadListResult a(FolderName paramFolderName)
  {
    return newBuilder().a(DataFreshnessResult.NO_DATA).a(paramFolderName).o();
  }

  public static FetchThreadListResultBuilder newBuilder()
  {
    return new FetchThreadListResultBuilder();
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

  public ImmutableList<String> d()
  {
    return this.d;
  }

  public int describeContents()
  {
    return 0;
  }

  public ImmutableList<String> g()
  {
    return this.e;
  }

  public FolderCounts h()
  {
    return this.f;
  }

  public NotificationSetting i()
  {
    return this.g;
  }

  public boolean j()
  {
    return this.h;
  }

  public long k()
  {
    return this.i;
  }

  public boolean l()
  {
    return this.j;
  }

  public ImmutableMap<FolderName, FetchThreadListResult> m()
  {
    return this.k;
  }

  public ServiceException n()
  {
    return this.l;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int m = 1;
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeParcelable(this.a, paramInt);
    paramParcel.writeParcelable(this.b, paramInt);
    paramParcel.writeList(this.c);
    paramParcel.writeParcelable(this.f, paramInt);
    paramParcel.writeParcelable(this.g, paramInt);
    paramParcel.writeStringList(this.d);
    paramParcel.writeStringList(this.e);
    int n;
    if (this.h)
    {
      n = m;
      paramParcel.writeInt(n);
      paramParcel.writeLong(this.i);
      if (!this.j)
        break label128;
    }
    while (true)
    {
      paramParcel.writeInt(m);
      paramParcel.writeSerializable(this.k);
      paramParcel.writeParcelable(this.l, paramInt);
      return;
      n = 0;
      break;
      label128: m = 0;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.FetchThreadListResult
 * JD-Core Version:    0.6.0
 */