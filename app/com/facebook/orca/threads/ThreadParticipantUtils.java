package com.facebook.orca.threads;

import com.facebook.orca.users.User;
import com.facebook.orca.users.User.Type;
import com.facebook.orca.users.UserKey;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Provider;

public class ThreadParticipantUtils
{
  private static Class<?> a = ThreadParticipantUtils.class;
  private final Provider<User> b;

  public ThreadParticipantUtils(Provider<User> paramProvider)
  {
    this.b = paramProvider;
  }

  public ThreadParticipant a(ThreadSummary paramThreadSummary)
  {
    User localUser = (User)this.b.b();
    ThreadParticipant localThreadParticipant;
    if (localUser != null)
    {
      Iterator localIterator = paramThreadSummary.i().iterator();
      do
      {
        if (!localIterator.hasNext())
          break;
        localThreadParticipant = (ThreadParticipant)localIterator.next();
      }
      while (Objects.equal(localThreadParticipant.d(), localUser.c()));
    }
    while (true)
    {
      return localThreadParticipant;
      localThreadParticipant = (ThreadParticipant)paramThreadSummary.i().get(0);
    }
  }

  public ThreadParticipant b(ThreadSummary paramThreadSummary)
  {
    if ((paramThreadSummary != null) && (paramThreadSummary.g()));
    for (ThreadParticipant localThreadParticipant = a(paramThreadSummary); ; localThreadParticipant = null)
      return localThreadParticipant;
  }

  public List<ThreadParticipant> c(ThreadSummary paramThreadSummary)
  {
    User localUser = (User)this.b.b();
    ArrayList localArrayList = Lists.a();
    Iterator localIterator = paramThreadSummary.i().iterator();
    while (localIterator.hasNext())
    {
      ThreadParticipant localThreadParticipant = (ThreadParticipant)localIterator.next();
      if ((Objects.equal(localThreadParticipant.d(), localUser.c())) || (!Objects.equal(localThreadParticipant.d().a(), User.Type.PHONE_NUMBER)))
        continue;
      localArrayList.add(localThreadParticipant);
    }
    return localArrayList;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.threads.ThreadParticipantUtils
 * JD-Core Version:    0.6.0
 */