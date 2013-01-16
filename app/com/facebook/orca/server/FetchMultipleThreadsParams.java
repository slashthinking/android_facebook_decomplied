package com.facebook.orca.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.orca.threads.FolderName;
import com.facebook.orca.threads.MessagingIdUtil;
import com.facebook.orca.users.User.Type;
import com.facebook.orca.users.UserKey;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.Iterator;

public class FetchMultipleThreadsParams
  implements Parcelable
{
  public static final Parcelable.Creator<FetchMultipleThreadsParams> CREATOR = new FetchMultipleThreadsParams.1();
  private final FolderName a;
  private final ImmutableList<FetchThreadParams> b;

  private FetchMultipleThreadsParams(Parcel paramParcel)
  {
    this.a = ((FolderName)paramParcel.readParcelable(FolderName.class.getClassLoader()));
    this.b = ImmutableList.a(paramParcel.readArrayList(FetchThreadParams.class.getClassLoader()));
  }

  public FetchMultipleThreadsParams(FolderName paramFolderName, ImmutableList<FetchThreadParams> paramImmutableList)
  {
    boolean bool2;
    if ((paramFolderName == FolderName.b) || (paramFolderName == FolderName.d) || (paramFolderName == FolderName.e))
    {
      bool2 = bool1;
      Preconditions.checkArgument(bool2);
      if (paramImmutableList == null)
        break label72;
      label39: Preconditions.checkArgument(bool1);
      if (paramFolderName != FolderName.b)
        break label77;
      a(paramImmutableList);
    }
    while (true)
    {
      this.a = paramFolderName;
      this.b = paramImmutableList;
      return;
      bool2 = false;
      break;
      label72: bool1 = false;
      break label39;
      label77: if (paramFolderName == FolderName.d)
      {
        b(paramImmutableList);
        continue;
      }
      c(paramImmutableList);
    }
  }

  private void a(ImmutableList<FetchThreadParams> paramImmutableList)
  {
    Iterator localIterator = paramImmutableList.iterator();
    if (localIterator.hasNext())
    {
      ThreadCriteria localThreadCriteria = ((FetchThreadParams)localIterator.next()).a();
      if (localThreadCriteria.b() != null)
      {
        if (localThreadCriteria.b().a() == User.Type.FACEBOOK);
        for (boolean bool2 = true; ; bool2 = false)
        {
          Preconditions.checkArgument(bool2);
          break;
        }
      }
      if (!MessagingIdUtil.g(localThreadCriteria.a()));
      for (boolean bool1 = true; ; bool1 = false)
      {
        Preconditions.checkArgument(bool1);
        break;
      }
    }
  }

  private void b(ImmutableList<FetchThreadParams> paramImmutableList)
  {
    Iterator localIterator = paramImmutableList.iterator();
    while (localIterator.hasNext())
    {
      ThreadCriteria localThreadCriteria = ((FetchThreadParams)localIterator.next()).a();
      if (localThreadCriteria.b() != null)
      {
        if (localThreadCriteria.b().a() == User.Type.PHONE_NUMBER);
        for (boolean bool = true; ; bool = false)
        {
          Preconditions.checkArgument(bool);
          break;
        }
      }
      Preconditions.checkArgument(MessagingIdUtil.g(localThreadCriteria.a()));
    }
  }

  private void c(ImmutableList<FetchThreadParams> paramImmutableList)
  {
    Iterator localIterator = paramImmutableList.iterator();
    while (localIterator.hasNext())
    {
      ThreadCriteria localThreadCriteria = ((FetchThreadParams)localIterator.next()).a();
      if (localThreadCriteria.b() == null)
        continue;
      User.Type localType = localThreadCriteria.b().a();
      if ((localType == User.Type.PHONE_NUMBER) || (localType == User.Type.FACEBOOK));
      for (boolean bool = true; ; bool = false)
      {
        Preconditions.checkArgument(bool);
        break;
      }
    }
  }

  public FolderName a()
  {
    return this.a;
  }

  public ImmutableList<FetchThreadParams> b()
  {
    return this.b;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeParcelable(this.a, paramInt);
    paramParcel.writeList(this.b);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.FetchMultipleThreadsParams
 * JD-Core Version:    0.6.0
 */