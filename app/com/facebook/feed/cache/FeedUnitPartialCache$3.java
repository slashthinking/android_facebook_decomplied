package com.facebook.feed.cache;

import android.support.v4.util.LruCache;
import com.facebook.feed.db.DbFeedbackHandler;
import com.facebook.graphql.model.Feedback;

class FeedUnitPartialCache$3 extends LruCache<String, Feedback>
{
  protected void a(boolean paramBoolean, String paramString, Feedback paramFeedback1, Feedback paramFeedback2)
  {
    if ((paramFeedback2 == null) || (!paramFeedback2.legacyApiPostId.equals(paramFeedback1.legacyApiPostId)))
      FeedUnitPartialCache.a(this.a).a(paramFeedback1.legacyApiPostId);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.cache.FeedUnitPartialCache.3
 * JD-Core Version:    0.6.0
 */