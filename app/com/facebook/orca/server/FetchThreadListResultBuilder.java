package com.facebook.orca.server;

import com.facebook.orca.notify.NotificationSetting;
import com.facebook.orca.ops.ServiceException;
import com.facebook.orca.threads.FolderCounts;
import com.facebook.orca.threads.FolderName;
import com.facebook.orca.threads.ThreadsCollection;
import com.facebook.orca.users.User;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.List;
import java.util.Map;

public class FetchThreadListResultBuilder
{
  private DataFreshnessResult a;
  private FolderName b;
  private ThreadsCollection c;
  private List<User> d = ImmutableList.d();
  private List<String> e = ImmutableList.d();
  private List<String> f = ImmutableList.d();
  private FolderCounts g;
  private NotificationSetting h;
  private boolean i;
  private long j = -1L;
  private long k = -1L;
  private boolean l;
  private Map<FolderName, FetchThreadListResult> m = ImmutableMap.j();
  private ServiceException n;

  public DataFreshnessResult a()
  {
    return this.a;
  }

  public FetchThreadListResultBuilder a(long paramLong)
  {
    this.j = paramLong;
    return this;
  }

  public FetchThreadListResultBuilder a(NotificationSetting paramNotificationSetting)
  {
    this.h = paramNotificationSetting;
    return this;
  }

  public FetchThreadListResultBuilder a(ServiceException paramServiceException)
  {
    this.n = paramServiceException;
    return this;
  }

  public FetchThreadListResultBuilder a(DataFreshnessResult paramDataFreshnessResult)
  {
    this.a = paramDataFreshnessResult;
    return this;
  }

  public FetchThreadListResultBuilder a(FetchThreadListResult paramFetchThreadListResult)
  {
    this.a = paramFetchThreadListResult.e();
    this.b = paramFetchThreadListResult.a();
    this.c = paramFetchThreadListResult.b();
    this.d = paramFetchThreadListResult.c();
    this.e = paramFetchThreadListResult.d();
    this.f = paramFetchThreadListResult.g();
    this.g = paramFetchThreadListResult.h();
    this.h = paramFetchThreadListResult.i();
    this.i = paramFetchThreadListResult.j();
    this.j = paramFetchThreadListResult.f();
    this.k = paramFetchThreadListResult.k();
    this.l = paramFetchThreadListResult.l();
    this.m = paramFetchThreadListResult.m();
    this.n = paramFetchThreadListResult.n();
    return this;
  }

  public FetchThreadListResultBuilder a(FolderCounts paramFolderCounts)
  {
    this.g = paramFolderCounts;
    return this;
  }

  public FetchThreadListResultBuilder a(FolderName paramFolderName)
  {
    this.b = paramFolderName;
    return this;
  }

  public FetchThreadListResultBuilder a(ThreadsCollection paramThreadsCollection)
  {
    this.c = paramThreadsCollection;
    return this;
  }

  public FetchThreadListResultBuilder a(ImmutableList<User> paramImmutableList)
  {
    this.d = paramImmutableList;
    return this;
  }

  public FetchThreadListResultBuilder a(List<String> paramList)
  {
    this.e = paramList;
    return this;
  }

  public FetchThreadListResultBuilder a(Map<FolderName, FetchThreadListResult> paramMap)
  {
    this.m = paramMap;
    return this;
  }

  public FetchThreadListResultBuilder a(boolean paramBoolean)
  {
    this.i = paramBoolean;
    return this;
  }

  public FetchThreadListResultBuilder b(long paramLong)
  {
    this.k = paramLong;
    return this;
  }

  public FetchThreadListResultBuilder b(List<String> paramList)
  {
    this.f = paramList;
    return this;
  }

  public FetchThreadListResultBuilder b(boolean paramBoolean)
  {
    this.l = paramBoolean;
    return this;
  }

  public FolderName b()
  {
    return this.b;
  }

  public ThreadsCollection c()
  {
    return this.c;
  }

  public List<User> d()
  {
    return this.d;
  }

  public List<String> e()
  {
    return this.e;
  }

  public List<String> f()
  {
    return this.f;
  }

  public FolderCounts g()
  {
    return this.g;
  }

  public NotificationSetting h()
  {
    return this.h;
  }

  public boolean i()
  {
    return this.i;
  }

  public long j()
  {
    return this.j;
  }

  public long k()
  {
    return this.k;
  }

  public boolean l()
  {
    return this.l;
  }

  public Map<FolderName, FetchThreadListResult> m()
  {
    return this.m;
  }

  public ServiceException n()
  {
    return this.n;
  }

  public FetchThreadListResult o()
  {
    return new FetchThreadListResult(this);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.server.FetchThreadListResultBuilder
 * JD-Core Version:    0.6.0
 */