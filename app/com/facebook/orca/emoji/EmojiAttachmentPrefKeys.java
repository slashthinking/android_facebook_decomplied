package com.facebook.orca.emoji;

import com.facebook.orca.prefs.PrefKey;
import com.facebook.orca.prefs.SharedPrefKeys;

public class EmojiAttachmentPrefKeys
{
  public static final PrefKey a = (PrefKey)SharedPrefKeys.a.c("emoji_attachment/");
  public static final PrefKey b = (PrefKey)a.c("front_state/");

  public static PrefKey a(String paramString)
  {
    return (PrefKey)b.c(paramString);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.emoji.EmojiAttachmentPrefKeys
 * JD-Core Version:    0.6.0
 */