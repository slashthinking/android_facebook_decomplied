package com.facebook.orca.threads;

import com.facebook.orca.users.User;
import com.facebook.orca.users.UserKey;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Provider;

public class ThreadSummaryStitching
{
  private final Provider<User> a;
  private final ThreadSnippetUtil b;

  public ThreadSummaryStitching(Provider<User> paramProvider, ThreadSnippetUtil paramThreadSnippetUtil)
  {
    this.a = paramProvider;
    this.b = paramThreadSnippetUtil;
  }

  public ThreadSummary a(ThreadSummary paramThreadSummary, Message paramMessage)
  {
    Preconditions.checkNotNull(paramThreadSummary);
    Preconditions.checkNotNull(paramMessage);
    ArrayList localArrayList = Lists.a();
    ParticipantInfo localParticipantInfo1 = paramMessage.f();
    localArrayList.add(localParticipantInfo1);
    Iterator localIterator = paramThreadSummary.l().iterator();
    while (localIterator.hasNext())
    {
      ParticipantInfo localParticipantInfo2 = (ParticipantInfo)localIterator.next();
      if (Objects.equal(localParticipantInfo2.e(), localParticipantInfo1.e()))
        continue;
      localArrayList.add(localParticipantInfo2);
    }
    String str1 = this.b.a(paramMessage);
    if ((str1 != null) && (str1.length() > 120));
    for (String str2 = str1.substring(0, 120); ; str2 = str1)
    {
      UserKey localUserKey = ((User)this.a.b()).c();
      if (!Objects.equal(paramMessage.f().e(), localUserKey));
      for (boolean bool = true; ; bool = false)
        return new ThreadSummaryBuilder().a(paramThreadSummary).c(paramMessage.p()).b(paramMessage.p()).d(paramMessage.c()).c(str2).a(paramMessage.f()).d(localArrayList).b(bool).y();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threads.ThreadSummaryStitching
 * JD-Core Version:    0.6.0
 */