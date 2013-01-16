package com.facebook.katana.diagnostics;

import com.facebook.annotations.IsMeUserAnEmployee;
import com.facebook.annotations.IsMeUserFb4aDeveloper;
import com.facebook.annotations.IsMeUserTrustedTester;
import com.facebook.base.BuildConstants;
import com.facebook.common.util.TriState;
import com.facebook.diagnostics.FpsEnableFlag;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.SharedPrefKeys;
import com.google.common.collect.Sets;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;

public class FpsEnableFlagsProvider
  implements Provider<Set<FpsEnableFlag>>
{
  private final Provider<TriState> a;
  private final Provider<TriState> b;
  private final Provider<TriState> c;
  private final OrcaSharedPreferences d;

  @Inject
  public FpsEnableFlagsProvider(@IsMeUserAnEmployee Provider<TriState> paramProvider1, @IsMeUserFb4aDeveloper Provider<TriState> paramProvider2, @IsMeUserTrustedTester Provider<TriState> paramProvider3, OrcaSharedPreferences paramOrcaSharedPreferences)
  {
    this.a = paramProvider1;
    this.b = paramProvider2;
    this.c = paramProvider3;
    this.d = paramOrcaSharedPreferences;
  }

  public Set<FpsEnableFlag> a()
  {
    int i;
    int j;
    label34: int k;
    label44: int m;
    if (this.a.b() == TriState.YES)
    {
      i = 1;
      if (this.b.b() != TriState.YES)
        break label86;
      j = 1;
      if ((i == 0) || (j == 0))
        break label91;
      k = 1;
      if (this.c.b() != TriState.YES)
        break label96;
      m = 1;
      label62: if ((k != 0) || (m != 0))
        break label102;
    }
    label86: label91: label96: label102: HashSet localHashSet;
    for (Object localObject = EnumSet.noneOf(FpsEnableFlag.class); ; localObject = localHashSet)
    {
      return localObject;
      i = 0;
      break;
      j = 0;
      break label34;
      k = 0;
      break label44;
      m = 0;
      break label62;
      localHashSet = Sets.a();
      if (!this.d.a(SharedPrefKeys.o, BuildConstants.a()))
        continue;
      localHashSet.add(FpsEnableFlag.ENABLE);
      localHashSet.add(FpsEnableFlag.ENABLE_FLUSH_DATA_ON_PAUSE);
      if (k != 0)
        localHashSet.add(FpsEnableFlag.ENABLE_RECORD_DATA);
      if (this.d.a(SharedPrefKeys.p, false))
        localHashSet.add(FpsEnableFlag.ENABLE_OUTPUT_TO_LOGCAT);
      if ((j == 0) && (m == 0))
        continue;
      localHashSet.add(FpsEnableFlag.ENABLE_FRAME_COUNTER);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.diagnostics.FpsEnableFlagsProvider
 * JD-Core Version:    0.6.0
 */