package com.facebook.orca.emoji;

import android.content.res.Resources;
import com.facebook.orca.inject.AbstractProvider;

class EmojiModule$EmojiUtilProvider extends AbstractProvider<EmojiUtil>
{
  private EmojiModule$EmojiUtilProvider(EmojiModule paramEmojiModule)
  {
  }

  public EmojiUtil a()
  {
    return new EmojiUtil((Emojis)b(Emojis.class), (Resources)b(Resources.class));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.emoji.EmojiModule.EmojiUtilProvider
 * JD-Core Version:    0.6.0
 */