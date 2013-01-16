package com.facebook.katana.features.events;

import com.facebook.ipc.katana.model.FacebookEvent;
import com.facebook.katana.orca.FbandroidPrefKeys;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.OrcaSharedPreferences.Editor;
import com.facebook.orca.prefs.PrefKey;

public class AggressiveSuggestionPreferences
{
  private static final PrefKey a = (PrefKey)FbandroidPrefKeys.g.c("aggressive_suggestion/");
  private static final PrefKey b = (PrefKey)a.c("latest_disable_time/");
  private static final PrefKey c = (PrefKey)a.c("disabling_count");
  private final OrcaSharedPreferences d;
  private final long e;
  private final long f;
  private final Clock g;

  public AggressiveSuggestionPreferences(OrcaSharedPreferences paramOrcaSharedPreferences, Clock paramClock, long paramLong1, long paramLong2)
  {
    this.d = paramOrcaSharedPreferences;
    this.e = paramLong2;
    this.f = paramLong1;
    this.g = paramClock;
  }

  public boolean a(FacebookEvent paramFacebookEvent)
  {
    PrefKey localPrefKey = (PrefKey)b.c(Long.toString(paramFacebookEvent.a()));
    long l = this.d.a(localPrefKey, -1L);
    if ((l != -1L) && (this.g.a() - l <= this.f));
    for (int i = 0; ; i = 1)
      return i;
  }

  public void b(FacebookEvent paramFacebookEvent)
  {
    long l1 = 0L;
    PrefKey localPrefKey = (PrefKey)b.c(Long.toString(paramFacebookEvent.a()));
    long l2 = 1L + this.d.a(c, l1);
    OrcaSharedPreferences.Editor localEditor = this.d.b();
    if (l2 >= this.e)
      localEditor.b(b);
    while (true)
    {
      localEditor.a(localPrefKey, this.g.a());
      localEditor.a(c, l1);
      localEditor.a();
      return;
      l1 = l2;
    }
  }

  public void c(FacebookEvent paramFacebookEvent)
  {
    PrefKey localPrefKey = (PrefKey)b.c(Long.toString(paramFacebookEvent.a()));
    OrcaSharedPreferences.Editor localEditor = this.d.b();
    localEditor.a(localPrefKey);
    localEditor.a();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.features.events.AggressiveSuggestionPreferences
 * JD-Core Version:    0.6.0
 */