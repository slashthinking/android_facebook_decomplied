package com.facebook.orca.emoji;

import com.facebook.orca.app.OrcaAppType;
import com.facebook.orca.prefs.GkPrefKeys;
import com.facebook.orca.prefs.OrcaSharedPreferences;
import com.facebook.orca.prefs.PrefKey;
import javax.inject.Inject;
import javax.inject.Provider;

public class IsEmojiAttachmentPopupEnabledProvider
  implements Provider<Boolean>
{
  public static final PrefKey a = GkPrefKeys.a("messenger_emoji_composer_android");
  private final OrcaSharedPreferences b;
  private final OrcaAppType c;

  @Inject
  public IsEmojiAttachmentPopupEnabledProvider(OrcaSharedPreferences paramOrcaSharedPreferences, OrcaAppType paramOrcaAppType)
  {
    this.b = paramOrcaSharedPreferences;
    this.c = paramOrcaAppType;
  }

  public Boolean a()
  {
    return Boolean.valueOf(this.b.a(a, true));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.emoji.IsEmojiAttachmentPopupEnabledProvider
 * JD-Core Version:    0.6.0
 */