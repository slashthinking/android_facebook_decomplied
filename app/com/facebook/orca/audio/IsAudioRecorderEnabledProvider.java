package com.facebook.orca.audio;

import android.content.Context;
import com.facebook.orca.annotations.FromApplication;
import com.facebook.orca.app.IntendedAudience;
import com.facebook.orca.app.OrcaAppType;
import com.facebook.orca.prefs.GkPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.PrefKey;
import javax.inject.Inject;
import javax.inject.Provider;

public class IsAudioRecorderEnabledProvider
  implements Provider<Boolean>
{
  public static final PrefKey a = GkPrefKeys.a("messenger_audio_recorder_android");
  private final OrcaSharedPreferences b;
  private final Context c;
  private final OrcaAppType d;

  @Inject
  public IsAudioRecorderEnabledProvider(OrcaSharedPreferences paramOrcaSharedPreferences, @FromApplication Context paramContext, OrcaAppType paramOrcaAppType)
  {
    this.b = paramOrcaSharedPreferences;
    this.c = paramContext;
    this.d = paramOrcaAppType;
  }

  public Boolean a()
  {
    boolean bool1 = this.b.a(a, false);
    boolean bool2 = false;
    if (bool1)
    {
      IntendedAudience localIntendedAudience1 = this.d.h();
      IntendedAudience localIntendedAudience2 = IntendedAudience.PUBLIC;
      bool2 = false;
      if (localIntendedAudience1 != localIntendedAudience2)
      {
        int i = this.c.checkCallingOrSelfPermission("android.permission.RECORD_AUDIO");
        bool2 = false;
        if (i == 0)
          bool2 = true;
      }
    }
    return Boolean.valueOf(bool2);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.audio.IsAudioRecorderEnabledProvider
 * JD-Core Version:    0.6.0
 */