package com.facebook.katana.activity.nearby;

import com.facebook.katana.activity.places.FriendCheckinsActivity;
import com.facebook.uri.UriIntentBuilder;
import javax.inject.Provider;

public class FallBackToFriendCheckinsUriBuilder extends UriIntentBuilder
{
  private final Provider<Boolean> a;

  public FallBackToFriendCheckinsUriBuilder(Provider<Boolean> paramProvider)
  {
    this.a = paramProvider;
    a("fb://nearby", FriendCheckinsActivity.class);
  }

  public boolean a()
  {
    if (!((Boolean)this.a.b()).booleanValue());
    for (int i = 1; ; i = 0)
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.nearby.FallBackToFriendCheckinsUriBuilder
 * JD-Core Version:    0.6.0
 */