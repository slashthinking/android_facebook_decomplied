package com.facebook.orca.cache;

import android.location.Location;
import android.net.Uri;
import com.facebook.location.LocationCache;
import com.facebook.orca.appconfig.AppConfig;
import com.facebook.orca.auth.MeUserAuthDataStore;
import com.facebook.orca.server.DataFreshnessParam;
import com.facebook.orca.server.ThreadCriteria;
import com.facebook.orca.threads.FolderCounts;
import com.facebook.orca.threads.FolderName;
import com.facebook.orca.threads.MessagesCollection;
import com.facebook.orca.threads.ParticipantInfo;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.orca.threads.ThreadsCollection;
import com.facebook.orca.users.User;
import com.facebook.orca.users.UserKey;
import java.util.List;

public class DataCache
{
  private static final Class<?> a = DataCache.class;
  private final MeUserAuthDataStore b;
  private final ThreadsCache c;
  private final LocationCache d;
  private final AppConfigCache e;
  private final ChatVisibilityCache f;
  private final ThreadsCacheUpdateRateLimiter g;

  public DataCache(MeUserAuthDataStore paramMeUserAuthDataStore, ThreadsCache paramThreadsCache, LocationCache paramLocationCache, AppConfigCache paramAppConfigCache, ChatVisibilityCache paramChatVisibilityCache, ThreadsCacheUpdateRateLimiter paramThreadsCacheUpdateRateLimiter)
  {
    this.b = paramMeUserAuthDataStore;
    this.c = paramThreadsCache;
    this.d = paramLocationCache;
    this.e = paramAppConfigCache;
    this.f = paramChatVisibilityCache;
    this.g = paramThreadsCacheUpdateRateLimiter;
  }

  public long a(String paramString)
  {
    return this.c.f(paramString);
  }

  public DataFreshnessParam a(ThreadCriteria paramThreadCriteria, DataFreshnessParam paramDataFreshnessParam)
  {
    return this.g.a(paramThreadCriteria, paramDataFreshnessParam);
  }

  public DataFreshnessParam a(FolderName paramFolderName, DataFreshnessParam paramDataFreshnessParam)
  {
    return this.g.a(paramFolderName, paramDataFreshnessParam);
  }

  public User a()
  {
    return this.b.g();
  }

  public User a(UserKey paramUserKey)
  {
    return this.c.b(paramUserKey);
  }

  public String a(ParticipantInfo paramParticipantInfo)
  {
    return this.c.a(paramParticipantInfo);
  }

  public void a(String paramString, Location paramLocation, long paramLong)
  {
    this.c.a(paramString, paramLocation, paramLong);
  }

  public boolean a(ThreadCriteria paramThreadCriteria)
  {
    return this.g.a(paramThreadCriteria);
  }

  public boolean a(FolderName paramFolderName)
  {
    return this.c.a(paramFolderName);
  }

  public Uri b(UserKey paramUserKey)
  {
    User localUser = this.c.b(paramUserKey);
    if (localUser != null);
    for (Uri localUri = localUser.q(); ; localUri = null)
      return localUri;
  }

  public ThreadSummary b(String paramString)
  {
    return this.c.a(paramString);
  }

  public ThreadsCollection b(FolderName paramFolderName)
  {
    return this.c.c(paramFolderName);
  }

  public UserKey b()
  {
    User localUser = this.b.g();
    if (localUser != null);
    for (UserKey localUserKey = localUser.c(); ; localUserKey = null)
      return localUserKey;
  }

  public String b(ParticipantInfo paramParticipantInfo)
  {
    return this.c.b(paramParticipantInfo);
  }

  public boolean b(ThreadCriteria paramThreadCriteria)
  {
    return this.g.b(paramThreadCriteria);
  }

  public MessagesCollection c(String paramString)
  {
    return this.c.b(paramString);
  }

  public ThreadSummary c(UserKey paramUserKey)
  {
    return this.c.a(paramUserKey);
  }

  public String c()
  {
    User localUser = this.b.g();
    if (localUser != null);
    for (String str = localUser.b(); ; str = null)
      return str;
  }

  public boolean c(FolderName paramFolderName)
  {
    return this.g.a(paramFolderName);
  }

  public List<ThreadSummary> d()
  {
    return this.c.a();
  }

  public boolean d(FolderName paramFolderName)
  {
    return this.g.b(paramFolderName);
  }

  public long e(FolderName paramFolderName)
  {
    return this.c.e(paramFolderName);
  }

  public Location e()
  {
    return this.d.a();
  }

  public AppConfig f()
  {
    return this.e.a();
  }

  public FolderCounts f(FolderName paramFolderName)
  {
    return this.c.d(paramFolderName);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.cache.DataCache
 * JD-Core Version:    0.6.0
 */