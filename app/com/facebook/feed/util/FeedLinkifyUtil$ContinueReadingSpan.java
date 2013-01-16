package com.facebook.feed.util;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.intent.IFeedIntentBuilder;
import com.facebook.graphql.model.FeedStory;
import com.facebook.orca.inject.FbInjector;

class FeedLinkifyUtil$ContinueReadingSpan extends ClickableSpan
{
  private final FeedStory a;
  private final Context b;
  private final IFeedIntentBuilder c;
  private final SecureContextHelper d;

  public FeedLinkifyUtil$ContinueReadingSpan(FeedStory paramFeedStory, Context paramContext, SecureContextHelper paramSecureContextHelper)
  {
    this.a = paramFeedStory;
    this.b = paramContext;
    this.c = ((IFeedIntentBuilder)FbInjector.a(this.b).a(IFeedIntentBuilder.class));
    this.d = paramSecureContextHelper;
  }

  public void onClick(View paramView)
  {
    if (this.a != null)
    {
      Intent localIntent = this.c.a(this.a);
      this.d.a(localIntent, paramView.getContext());
    }
  }

  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.setColor(this.b.getResources().getColor(2131165265));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.util.FeedLinkifyUtil.ContinueReadingSpan
 * JD-Core Version:    0.6.0
 */