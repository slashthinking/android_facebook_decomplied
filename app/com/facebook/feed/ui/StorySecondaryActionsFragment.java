package com.facebook.feed.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.feed.intent.IFeedIntentBuilder;
import com.facebook.graphql.model.FeedStory;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.flyout.FlyoutFragment;

public class StorySecondaryActionsFragment extends FlyoutFragment
{
  private FeedStory b;
  private RelativeLayout c;
  private View d;
  private Context e;

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.d = paramLayoutInflater.inflate(2130903227, paramViewGroup, false);
    this.d.setOnTouchListener(new StorySecondaryActionsFragment.1(this));
    this.a = ((RelativeLayout)this.d.findViewById(2131296966));
    this.c = ((RelativeLayout)this.a.findViewById(2131296967));
    ((TextView)this.c.findViewById(2131296969)).setOnClickListener(new StorySecondaryActionsFragment.2(this));
    return this.d;
  }

  public void a(Context paramContext, FeedStory paramFeedStory)
  {
    this.e = paramContext;
    this.b = paramFeedStory;
  }

  protected void a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
  }

  public void b()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.b.id;
    String str = StringLocaleUtil.b("fb://report/story/%s", arrayOfObject);
    ((IFeedIntentBuilder)R().a(IFeedIntentBuilder.class)).a(this.e, str);
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.c.getLayoutParams();
    int i = this.e.getResources().getDimensionPixelSize(2131230792);
    localMarginLayoutParams.topMargin -= i;
    this.c.setLayoutParams(localMarginLayoutParams);
    this.c.requestLayout();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.StorySecondaryActionsFragment
 * JD-Core Version:    0.6.0
 */