package com.facebook.orca.emoji;

import com.facebook.orca.annotations.IsEmojiAttachmentPopupEnabled;
import com.facebook.orca.inject.AbstractModule;
import com.facebook.orca.inject.binder.AnnotatedBindingBuilder;
import com.facebook.orca.inject.binder.LinkedBindingBuilder;
import com.facebook.orca.inject.binder.ScopedBindingBuilder;

public class EmojiModule extends AbstractModule
{
  protected void a()
  {
    a(EmojiUtil.class).a(new EmojiModule.EmojiUtilProvider(this, null));
    a(Emojis.class).a(new EmojiModule.EmojisProvider(this, null)).a();
    a(Boolean.class).a(IsEmojiAttachmentPopupEnabled.class).c(IsEmojiAttachmentPopupEnabledProvider.class);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.emoji.EmojiModule
 * JD-Core Version:    0.6.0
 */