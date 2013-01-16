package com.facebook.katana.activity.composer;

import com.facebook.uri.UriIntentBuilder;

public class ComposerUriIntentBuilder extends UriIntentBuilder
{
  public ComposerUriIntentBuilder()
  {
    a("fb://composer", ComposerActivity.class);
  }

  public boolean a()
  {
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.composer.ComposerUriIntentBuilder
 * JD-Core Version:    0.6.0
 */