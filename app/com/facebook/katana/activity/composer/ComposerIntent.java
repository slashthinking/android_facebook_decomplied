package com.facebook.katana.activity.composer;

import android.content.Intent;

public class ComposerIntent extends Intent
{
  private ComposerIntent(ComposerIntent.Builder paramBuilder)
  {
    super(ComposerIntent.Builder.a(paramBuilder), ComposerActivity.class);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.composer.ComposerIntent
 * JD-Core Version:    0.6.0
 */