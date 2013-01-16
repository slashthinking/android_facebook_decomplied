package com.facebook.orca.cache;

import android.net.Uri;
import com.facebook.orca.attachments.AttachmentDataFactory;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.debug.WtfToken;
import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.MessagingIdUtil;
import com.facebook.orca.threads.ParticipantInfo;
import com.facebook.orca.threads.ThreadParticipant;
import com.facebook.orca.threads.ThreadParticipantUtils;
import com.facebook.orca.threads.ThreadSnippetUtil;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.orca.users.UserKey;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

public class ThreadDisplayCache
{
  private static final WtfToken a = new WtfToken();
  private static final Class<?> b = ThreadDisplayCache.class;
  private final DataCache c;
  private final AttachmentDataFactory d;
  private final ThreadParticipantUtils e;
  private final ThreadSnippetUtil f;
  private final ConcurrentMap<String, ThreadDisplayCache.ParticipantListResult> g;
  private final Map<String, ThreadDisplayCache.ThreadSnippet> h;
  private final Map<String, Long> i;

  public ThreadDisplayCache(DataCache paramDataCache, AttachmentDataFactory paramAttachmentDataFactory, ThreadParticipantUtils paramThreadParticipantUtils, ThreadSnippetUtil paramThreadSnippetUtil)
  {
    this.c = paramDataCache;
    this.d = paramAttachmentDataFactory;
    this.e = paramThreadParticipantUtils;
    this.f = paramThreadSnippetUtil;
    this.g = new MapMaker().a(128).c(2).i().n();
    this.h = Maps.c();
    this.i = Maps.c();
  }

  private ThreadDisplayCache.ParticipantListResult d(ThreadSummary paramThreadSummary)
  {
    ImmutableList localImmutableList1 = paramThreadSummary.l();
    ImmutableList localImmutableList2 = paramThreadSummary.i();
    UserKey localUserKey = this.c.b();
    LinkedHashMap localLinkedHashMap = Maps.b();
    Iterator localIterator1 = localImmutableList1.iterator();
    while (localIterator1.hasNext())
    {
      ParticipantInfo localParticipantInfo3 = (ParticipantInfo)localIterator1.next();
      if (Objects.equal(localParticipantInfo3.e(), this.c.b()))
        continue;
      localLinkedHashMap.put(localParticipantInfo3.e(), localParticipantInfo3);
    }
    Iterator localIterator2 = localImmutableList2.iterator();
    while (localIterator2.hasNext())
    {
      ThreadParticipant localThreadParticipant = (ThreadParticipant)localIterator2.next();
      if ((Objects.equal(localThreadParticipant.d(), localUserKey)) || (localLinkedHashMap.containsKey(localThreadParticipant.d())))
        continue;
      localLinkedHashMap.put(localThreadParticipant.d(), localThreadParticipant.a());
    }
    ImmutableList.Builder localBuilder1 = ImmutableList.e();
    ImmutableList.Builder localBuilder2 = ImmutableList.e();
    ParticipantInfo localParticipantInfo2;
    if (localLinkedHashMap.size() == 1)
    {
      localParticipantInfo2 = (ParticipantInfo)localLinkedHashMap.values().iterator().next();
      String str2 = this.c.a(localParticipantInfo2);
      if (str2 != null)
      {
        localBuilder2.b(localParticipantInfo2);
        localBuilder1.b(str2);
      }
    }
    while (true)
    {
      return new ThreadDisplayCache.ParticipantListResult(paramThreadSummary.b(), localBuilder2.b(), localBuilder1.b());
      BLog.a(a, b, "ParticipantInfo [%s]", new Object[] { localParticipantInfo2 });
      continue;
      Iterator localIterator3 = localLinkedHashMap.values().iterator();
      while (localIterator3.hasNext())
      {
        ParticipantInfo localParticipantInfo1 = (ParticipantInfo)localIterator3.next();
        String str1 = this.c.b(localParticipantInfo1);
        if (str1 == null)
          continue;
        localBuilder2.b(localParticipantInfo1);
        localBuilder1.b(str1);
      }
    }
  }

  public Uri a(ThreadSummary paramThreadSummary, boolean paramBoolean)
  {
    Uri localUri;
    if (paramThreadSummary.q())
      localUri = this.d.a(paramThreadSummary);
    while (true)
    {
      return localUri;
      if (paramBoolean)
      {
        int j = c(paramThreadSummary);
        if (j == 1)
        {
          ThreadParticipant localThreadParticipant2 = (ThreadParticipant)paramThreadSummary.i().get(0);
          localUri = this.c.b(localThreadParticipant2.d());
          continue;
        }
        if (j == 2)
        {
          ThreadParticipant localThreadParticipant1 = this.e.a(paramThreadSummary);
          localUri = this.c.b(localThreadParticipant1.d());
          continue;
        }
      }
      localUri = null;
    }
  }

  public UserKey a(String paramString)
  {
    UserKey localUserKey = null;
    if (paramString == null);
    while (true)
    {
      return localUserKey;
      ThreadSummary localThreadSummary = this.c.b(paramString);
      localUserKey = null;
      if (localThreadSummary == null)
        continue;
      ThreadParticipant localThreadParticipant = this.e.b(localThreadSummary);
      localUserKey = null;
      if (localThreadParticipant == null)
        continue;
      localUserKey = localThreadParticipant.d();
    }
  }

  public Long a(UserKey paramUserKey)
  {
    if (paramUserKey == null);
    for (Long localLong = null; ; localLong = (Long)this.i.get(paramUserKey.c()))
      return localLong;
  }

  public List<String> a(ThreadSummary paramThreadSummary)
  {
    ThreadDisplayCache.ParticipantListResult localParticipantListResult = (ThreadDisplayCache.ParticipantListResult)this.g.get(paramThreadSummary.a());
    if ((localParticipantListResult == null) || (ThreadDisplayCache.ParticipantListResult.a(localParticipantListResult) != paramThreadSummary.b()))
    {
      localParticipantListResult = d(paramThreadSummary);
      this.g.put(paramThreadSummary.a(), localParticipantListResult);
    }
    return ThreadDisplayCache.ParticipantListResult.b(localParticipantListResult);
  }

  public void a()
  {
    this.g.clear();
  }

  public void a(Message paramMessage)
  {
    ThreadDisplayCache.ThreadSnippet localThreadSnippet = b(paramMessage.b());
    long l1 = paramMessage.c();
    if (paramMessage.e() != 0L)
      l1 = Math.min(l1, paramMessage.e());
    long l2 = Math.max(paramMessage.c(), paramMessage.e());
    int j;
    int k;
    if ((StringUtil.a(paramMessage.t())) || (paramMessage.e() == 0L))
    {
      j = 1;
      if ((j == 0) || (localThreadSnippet == null) || (localThreadSnippet.c() >= l1))
        break label129;
      k = 1;
      label88: if (k == 0)
        break label135;
      a(paramMessage.b(), new ThreadDisplayCache.ThreadSnippet(this.f.a(paramMessage), paramMessage.f(), l2));
    }
    while (true)
    {
      return;
      j = 0;
      break;
      label129: k = 0;
      break label88;
      label135: if (localThreadSnippet == null)
        continue;
      a(paramMessage.b(), new ThreadDisplayCache.ThreadSnippet(localThreadSnippet.a(), localThreadSnippet.b(), l2));
    }
  }

  public void a(UserKey paramUserKey, long paramLong)
  {
    if (paramUserKey == null);
    while (true)
    {
      return;
      Long localLong = (Long)this.i.get(paramUserKey.c());
      if ((localLong != null) && (localLong.longValue() >= paramLong))
        continue;
      this.i.put(paramUserKey.c(), Long.valueOf(paramLong));
    }
  }

  public void a(String paramString, ThreadDisplayCache.ThreadSnippet paramThreadSnippet)
  {
    this.h.put(paramString, paramThreadSnippet);
  }

  public ThreadDisplayCache.ThreadSnippet b(String paramString)
  {
    return (ThreadDisplayCache.ThreadSnippet)this.h.get(paramString);
  }

  public List<ParticipantInfo> b(ThreadSummary paramThreadSummary)
  {
    ThreadDisplayCache.ParticipantListResult localParticipantListResult = (ThreadDisplayCache.ParticipantListResult)this.g.get(paramThreadSummary.a());
    if ((localParticipantListResult == null) || (ThreadDisplayCache.ParticipantListResult.a(localParticipantListResult) != paramThreadSummary.b()))
    {
      localParticipantListResult = d(paramThreadSummary);
      this.g.put(paramThreadSummary.a(), localParticipantListResult);
    }
    return ThreadDisplayCache.ParticipantListResult.c(localParticipantListResult);
  }

  public void b()
  {
    Iterator localIterator = this.g.keySet().iterator();
    while (localIterator.hasNext())
    {
      if (!MessagingIdUtil.g((String)localIterator.next()))
        continue;
      localIterator.remove();
    }
  }

  public int c(ThreadSummary paramThreadSummary)
  {
    return paramThreadSummary.i().size();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.cache.ThreadDisplayCache
 * JD-Core Version:    0.6.0
 */