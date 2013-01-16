package com.facebook.feed.ui.footer;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.GraphQLStoryInsights;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.CustomRelativeLayout;

public class StoryInsightsFooterView extends CustomRelativeLayout
{
  private final TextView a;
  private final TextView b;
  private boolean c = ((Boolean)getInjector().a(Boolean.class, ShouldDisplayInsightsFooter.class)).booleanValue();
  private StoryInsightsFooterView.OnViewInsightsListener d;
  private FeedStory e;

  public StoryInsightsFooterView(Context paramContext)
  {
    this(paramContext, null);
  }

  public StoryInsightsFooterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (this.c)
    {
      setContentView(2130903176);
      this.a = ((TextView)b(2131296806));
      this.b = ((TextView)b(2131296807));
      this.b.setOnClickListener(new StoryInsightsFooterView.1(this));
    }
    while (true)
    {
      return;
      this.a = null;
      this.b = null;
    }
  }

  public void a(FeedStory paramFeedStory)
  {
    this.e = paramFeedStory;
    if ((this.c) && (paramFeedStory.o()))
    {
      setVisibility(0);
      TextView localTextView = this.a;
      Context localContext = getContext();
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Long.valueOf(paramFeedStory.insights.totalReach);
      localTextView.setText(localContext.getString(2131362136, arrayOfObject));
    }
    while (true)
    {
      return;
      setVisibility(8);
    }
  }

  public void setViewInsightsListener(StoryInsightsFooterView.OnViewInsightsListener paramOnViewInsightsListener)
  {
    this.d = paramOnViewInsightsListener;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.footer.StoryInsightsFooterView
 * JD-Core Version:    0.6.0
 */