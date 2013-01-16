package com.facebook.orca.users;

import android.content.res.Resources;
import com.facebook.orca.cache.DataCache;
import com.facebook.orca.cache.ThreadDisplayCache;
import com.facebook.orca.presence.Availability;
import com.facebook.orca.presence.PresenceManager;
import com.facebook.orca.presence.PresenceManager.OnContactPresenceStateChangedListener;
import com.facebook.orca.presence.PresenceState;
import com.facebook.orca.threads.ThreadParticipant;
import com.facebook.orca.threads.ThreadParticipantUtils;
import com.facebook.orca.threads.ThreadSummary;
import com.google.common.base.Objects;

public class CanonicalThreadPresenceHelper
{
  private final ThreadParticipantUtils a;
  private final PresenceManager b;
  private final DataCache c;
  private final ThreadDisplayCache d;
  private final LastActiveHelper e;
  private final Resources f;
  private final PresenceManager.OnContactPresenceStateChangedListener g;
  private boolean h;
  private ThreadSummary i;
  private ThreadParticipant j;
  private User k;
  private UserKey l;
  private PresenceState m = PresenceState.a;
  private long n;
  private CanonicalThreadPresenceHelper.Listener o;

  public CanonicalThreadPresenceHelper(ThreadParticipantUtils paramThreadParticipantUtils, PresenceManager paramPresenceManager, DataCache paramDataCache, ThreadDisplayCache paramThreadDisplayCache, LastActiveHelper paramLastActiveHelper, Resources paramResources)
  {
    this.a = paramThreadParticipantUtils;
    this.b = paramPresenceManager;
    this.c = paramDataCache;
    this.d = paramThreadDisplayCache;
    this.e = paramLastActiveHelper;
    this.f = paramResources;
    this.g = new CanonicalThreadPresenceHelper.1(this);
  }

  private void a(UserKey paramUserKey)
  {
    if (Objects.equal(paramUserKey, this.l));
    while (true)
    {
      return;
      this.m = PresenceState.a;
      if (this.l != null)
        this.b.b(this.l, this.g);
      this.l = paramUserKey;
      if (this.l == null)
        continue;
      this.b.a(this.l, this.g);
      this.m = this.b.b(this.l);
    }
  }

  private void a(UserKey paramUserKey, PresenceState paramPresenceState)
  {
    if (this.l == null);
    while (true)
    {
      return;
      if ((Objects.equal(paramUserKey, this.l)) && (this.m != paramPresenceState))
      {
        this.m = paramPresenceState;
        if (this.o == null)
          continue;
        this.o.a(paramPresenceState);
        continue;
      }
    }
  }

  private ThreadParticipant e()
  {
    if (this.i != null);
    for (ThreadParticipant localThreadParticipant = this.a.b(this.i); ; localThreadParticipant = null)
      return localThreadParticipant;
  }

  private void f()
  {
    if (this.h)
    {
      ThreadSummary localThreadSummary = this.i;
      UserKey localUserKey = null;
      if (localThreadSummary != null)
      {
        this.j = this.a.b(this.i);
        ThreadParticipant localThreadParticipant = this.j;
        localUserKey = null;
        if (localThreadParticipant != null)
          localUserKey = this.j.d();
      }
      a(localUserKey);
    }
    while (true)
    {
      return;
      a(null);
    }
  }

  private long g()
  {
    long l1 = 0L;
    if ((this.k == null) || (this.k.B() == null));
    while (true)
    {
      return l1;
      if (this.n != l1)
      {
        l1 = this.n;
        continue;
      }
      this.n = this.k.B().a();
      if (this.j.i() > this.n)
        this.n = this.j.i();
      Long localLong = this.d.a(this.k.c());
      if ((localLong != null) && (localLong.longValue() > this.n))
        this.n = localLong.longValue();
      this.n = this.e.a(this.n, this.k.B().b(), this.m.a());
      l1 = this.n;
    }
  }

  private boolean h()
  {
    if ((this.k != null) && (this.k.B() != null) && (g() != 0L) && (this.k.B().b()));
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  private String i()
  {
    if (this.k == null);
    for (String str = ""; ; str = this.e.a(this.n))
      return str;
  }

  public ThreadParticipant a()
  {
    return this.j;
  }

  public void a(ThreadSummary paramThreadSummary)
  {
    this.i = paramThreadSummary;
    this.j = e();
    if (this.j != null);
    for (this.k = this.c.a(this.j.d()); ; this.k = null)
    {
      f();
      return;
    }
  }

  public void a(CanonicalThreadPresenceHelper.Listener paramListener)
  {
    this.o = paramListener;
  }

  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
    f();
  }

  public boolean b()
  {
    if (this.j != null);
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  public PresenceState c()
  {
    return this.m;
  }

  public String d()
  {
    String str;
    if ((this.m.a() == Availability.AVAILABLE) || (h()))
      str = this.f.getString(2131362692);
    while (true)
    {
      return str;
      if (g() != 0L)
      {
        str = i();
        continue;
      }
      boolean bool = this.m.b();
      str = null;
      if (!bool)
        continue;
      str = this.f.getString(2131362699);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.users.CanonicalThreadPresenceHelper
 * JD-Core Version:    0.6.0
 */