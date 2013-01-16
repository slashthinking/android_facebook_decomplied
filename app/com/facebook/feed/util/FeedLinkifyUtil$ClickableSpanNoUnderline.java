package com.facebook.feed.util;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.facebook.feed.intent.IFeedIntentBuilder;
import com.facebook.orca.inject.FbInjector;

public class FeedLinkifyUtil$ClickableSpanNoUnderline extends ClickableSpan
{
  private final String a;
  private final Bundle b;
  private final Context c;
  private final IFeedIntentBuilder d;
  private int e;

  public FeedLinkifyUtil$ClickableSpanNoUnderline(String paramString, Context paramContext)
  {
    this(paramString, paramContext, null);
  }

  public FeedLinkifyUtil$ClickableSpanNoUnderline(String paramString, Context paramContext, Bundle paramBundle)
  {
    this.a = paramString;
    this.b = paramBundle;
    this.c = paramContext;
    this.d = ((IFeedIntentBuilder)FbInjector.a(this.c).a(IFeedIntentBuilder.class));
    this.e = 2131165265;
  }

  public ClickableSpanNoUnderline a(int paramInt)
  {
    this.e = paramInt;
    return this;
  }

  public void onClick(View paramView)
  {
    Context localContext = paramView.getContext();
    if (!this.d.a(localContext, this.a, this.b))
    {
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setData(Uri.parse(this.a));
      localContext.startActivity(localIntent);
    }
  }

  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.setColor(this.c.getResources().getColor(this.e));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.util.FeedLinkifyUtil.ClickableSpanNoUnderline
 * JD-Core Version:    0.6.0
 */