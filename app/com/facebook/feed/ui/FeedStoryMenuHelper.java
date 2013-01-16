package com.facebook.feed.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.intent.IFeedIntentBuilder;
import com.facebook.feed.renderer.IFeedUnitRenderer;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.FeedStory.PageStoryType;
import com.facebook.graphql.model.ReportInfo;
import com.facebook.orca.common.util.StringLocaleUtil;

public class FeedStoryMenuHelper
  implements View.OnClickListener
{
  private final Context a;
  private final IFeedIntentBuilder b;
  private final IFeedUnitRenderer c;
  private final boolean d;

  public FeedStoryMenuHelper(Context paramContext, IFeedIntentBuilder paramIFeedIntentBuilder, IFeedUnitRenderer paramIFeedUnitRenderer, boolean paramBoolean)
  {
    this.a = paramContext;
    this.b = paramIFeedIntentBuilder;
    this.c = paramIFeedUnitRenderer;
    this.d = paramBoolean;
  }

  protected static View a(FeedStoryView paramFeedStoryView, FeedStory paramFeedStory)
  {
    if (FeedStory.PageStoryType.NCPP.equals(paramFeedStory.A()));
    for (View localView = paramFeedStoryView.getExplanationSectionMenuButton(); ; localView = paramFeedStoryView.getDefaultMenuButton())
      return localView;
  }

  protected final Context a()
  {
    return this.a;
  }

  protected void a(View paramView, FeedStory paramFeedStory)
  {
    AlertDialogMenuBuilder localAlertDialogMenuBuilder = new AlertDialogMenuBuilder(this.a);
    localAlertDialogMenuBuilder.a(paramFeedStory.reportInfo.action, new FeedStoryMenuHelper.1(this, paramFeedStory));
    localAlertDialogMenuBuilder.a(this.a.getResources().getString(2131362138), new FeedStoryMenuHelper.2(this));
    localAlertDialogMenuBuilder.show();
  }

  protected boolean a(FeedStory paramFeedStory)
  {
    if ((this.d) && (paramFeedStory.reportInfo != null) && (paramFeedStory.id != null));
    for (int i = 1; ; i = 0)
      return i;
  }

  public boolean a(FeedStory paramFeedStory, FeedStoryView paramFeedStoryView, boolean paramBoolean)
  {
    boolean bool = c(paramFeedStory);
    View localView = a(paramFeedStoryView, paramFeedStory);
    FeedStory localFeedStory;
    if (bool)
    {
      localFeedStory = paramFeedStory;
      localView.setTag(2131296276, localFeedStory);
      if (!bool)
        break label84;
    }
    label84: for (int i = 0; ; i = 8)
    {
      localView.setVisibility(i);
      if (bool)
      {
        if (!paramBoolean)
          break label91;
        this.c.a(localView, paramFeedStory, null);
      }
      localView.setClickable(bool);
      return bool;
      localFeedStory = null;
      break;
    }
    label91: if (bool);
    while (true)
    {
      localView.setOnClickListener(this);
      break;
      this = null;
    }
  }

  protected void b(FeedStory paramFeedStory)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramFeedStory.id;
    String str = StringLocaleUtil.b("fb://report/story/%s", arrayOfObject);
    this.b.a(this.a, str);
  }

  protected boolean c(FeedStory paramFeedStory)
  {
    return a(paramFeedStory);
  }

  public final void onClick(View paramView)
  {
    a(paramView, (FeedStory)paramView.getTag(2131296276));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.FeedStoryMenuHelper
 * JD-Core Version:    0.6.0
 */