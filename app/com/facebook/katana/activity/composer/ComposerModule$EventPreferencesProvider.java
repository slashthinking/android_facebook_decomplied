package com.facebook.katana.activity.composer;

import com.facebook.katana.features.events.AggressiveSuggestionPreferences;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.inject.AbstractProvider;
import com.facebook.orca.prefs.OrcaSharedPreferences;

class ComposerModule$EventPreferencesProvider extends AbstractProvider<AggressiveSuggestionPreferences>
{
  private ComposerModule$EventPreferencesProvider(ComposerModule paramComposerModule)
  {
  }

  public AggressiveSuggestionPreferences a()
  {
    return new AggressiveSuggestionPreferences((OrcaSharedPreferences)b(OrcaSharedPreferences.class), (Clock)b(Clock.class), 86400000L, 50L);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.composer.ComposerModule.EventPreferencesProvider
 * JD-Core Version:    0.6.0
 */