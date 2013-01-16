package com.facebook.megaphone.data;

import android.os.Handler;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.graphql.model.MegaphoneStory;
import com.facebook.megaphone.fetcher.MegaphoneFetcher;
import com.facebook.orca.common.util.Clock;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MegaphoneStore
{
  private static final String a = MegaphoneFetcher.class.getSimpleName();
  private static final MegaphoneStore.MegaphoneEntry b = new MegaphoneStore.MegaphoneEntry(null, 0L);
  private final Handler c = new Handler();
  private final Clock d;
  private final MegaphoneFetcher e;
  private final FbErrorReporter f;
  private Map<String, MegaphoneStore.MegaphoneEntry> g;
  private Multimap<String, MegaphoneStore.MegaphoneUpdateListener> h;
  private Set<String> i;

  public MegaphoneStore(Clock paramClock, MegaphoneFetcher paramMegaphoneFetcher, FbErrorReporter paramFbErrorReporter)
  {
    this.d = paramClock;
    this.e = paramMegaphoneFetcher;
    this.f = paramFbErrorReporter;
    this.g = Maps.c();
    this.h = Multimaps.a(HashMultimap.m());
    this.i = Sets.a(Maps.c());
  }

  public MegaphoneStory a(String paramString)
  {
    MegaphoneStore.MegaphoneEntry localMegaphoneEntry = (MegaphoneStore.MegaphoneEntry)this.g.get(paramString);
    if (localMegaphoneEntry != null);
    for (MegaphoneStory localMegaphoneStory = localMegaphoneEntry.a; ; localMegaphoneStory = null)
      return localMegaphoneStory;
  }

  public void a(int paramInt)
  {
    this.e.a(paramInt);
  }

  public void a(String paramString, MegaphoneStore.MegaphoneUpdateListener paramMegaphoneUpdateListener)
  {
    this.h.a(paramString, paramMegaphoneUpdateListener);
  }

  public void b(String paramString)
  {
    if (this.g.remove(paramString) != null)
    {
      this.g.put(paramString, b);
      Iterator localIterator = this.h.b(paramString).iterator();
      while (localIterator.hasNext())
      {
        MegaphoneStore.MegaphoneUpdateListener localMegaphoneUpdateListener = (MegaphoneStore.MegaphoneUpdateListener)localIterator.next();
        this.c.post(new MegaphoneStore.3(this, localMegaphoneUpdateListener));
      }
    }
  }

  public void b(String paramString, MegaphoneStore.MegaphoneUpdateListener paramMegaphoneUpdateListener)
  {
    this.h.c(paramString, paramMegaphoneUpdateListener);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.megaphone.data.MegaphoneStore
 * JD-Core Version:    0.6.2
 */