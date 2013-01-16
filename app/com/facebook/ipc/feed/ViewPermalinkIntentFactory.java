package com.facebook.ipc.feed;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.Feedback;
import com.facebook.ipc.intent.FacebookOnlyIntentActionFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import java.io.IOException;

public class ViewPermalinkIntentFactory
{
  private final String a;
  private final ObjectMapper b;

  public ViewPermalinkIntentFactory(FacebookOnlyIntentActionFactory paramFacebookOnlyIntentActionFactory, ObjectMapper paramObjectMapper)
  {
    this.a = paramFacebookOnlyIntentActionFactory.a("VIEW_PERMALINK");
    this.b = ((ObjectMapper)Preconditions.checkNotNull(paramObjectMapper));
  }

  public Intent a(ViewPermalinkParams paramViewPermalinkParams)
  {
    Bundle localBundle = new Bundle();
    FeedStory localFeedStory = paramViewPermalinkParams.a;
    if ((localFeedStory.cacheId == null) && (localFeedStory.S() != null) && (localFeedStory.S().legacyApiPostId != null))
    {
      localBundle.putString("extra_fallback_url", "");
      localBundle.putBoolean("extra_is_platform_id", true);
      localBundle.putString("extra_platform_id", localFeedStory.S().legacyApiPostId);
    }
    while (true)
    {
      Intent localIntent = new Intent(this.a);
      localBundle.putInt("target_fragment", 2);
      localIntent.putExtras(localBundle);
      return localIntent;
      try
      {
        localBundle.putString("permalink_story", this.b.writeValueAsString(localFeedStory));
      }
      catch (IOException localIOException)
      {
      }
    }
    throw Throwables.propagate(localIOException);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.ipc.feed.ViewPermalinkIntentFactory
 * JD-Core Version:    0.6.0
 */