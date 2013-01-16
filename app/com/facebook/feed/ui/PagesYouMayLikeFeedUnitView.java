package com.facebook.feed.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.feed.renderer.FeedUnitViewStyle;
import com.facebook.feed.ui.ego.PagesYouMayLikeFeedUnitItemView;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.PagesYouMayLikeFeedUnit;
import com.facebook.graphql.model.PagesYouMayLikeFeedUnitItem;
import com.facebook.widget.CustomLinearLayout;
import java.util.List;

public class PagesYouMayLikeFeedUnitView extends CustomLinearLayout
  implements BindableFeedUnitView<PagesYouMayLikeFeedUnit>
{
  private final Context a;
  private final LinearLayout b;
  private final TextView c;

  public PagesYouMayLikeFeedUnitView(Context paramContext)
  {
    this(paramContext, null);
  }

  public PagesYouMayLikeFeedUnitView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    setContentView(2130903530);
    this.b = ((LinearLayout)b(2131297786));
    this.c = ((TextView)b(2131297785));
  }

  public void a(PagesYouMayLikeFeedUnit paramPagesYouMayLikeFeedUnit, FeedUnitViewStyle paramFeedUnitViewStyle, boolean paramBoolean)
  {
    this.c.setText(paramPagesYouMayLikeFeedUnit.title.text);
    int i = paramPagesYouMayLikeFeedUnit.items.size();
    int j = getChildCount();
    if (j > i)
      removeViews(i, j - i);
    int k = 0;
    PagesYouMayLikeFeedUnitItemView localPagesYouMayLikeFeedUnitItemView1;
    PagesYouMayLikeFeedUnitItemView localPagesYouMayLikeFeedUnitItemView2;
    if (k < i)
    {
      localPagesYouMayLikeFeedUnitItemView1 = (PagesYouMayLikeFeedUnitItemView)this.b.getChildAt(k);
      if (localPagesYouMayLikeFeedUnitItemView1 != null)
        break label148;
      localPagesYouMayLikeFeedUnitItemView2 = new PagesYouMayLikeFeedUnitItemView(this.a);
      this.b.addView(localPagesYouMayLikeFeedUnitItemView2);
    }
    label148: for (PagesYouMayLikeFeedUnitItemView localPagesYouMayLikeFeedUnitItemView3 = localPagesYouMayLikeFeedUnitItemView2; ; localPagesYouMayLikeFeedUnitItemView3 = localPagesYouMayLikeFeedUnitItemView1)
    {
      localPagesYouMayLikeFeedUnitItemView3.a((PagesYouMayLikeFeedUnitItem)paramPagesYouMayLikeFeedUnit.items.get(k));
      if (k == 0)
        localPagesYouMayLikeFeedUnitItemView3.b();
      while (true)
      {
        k++;
        break;
        localPagesYouMayLikeFeedUnitItemView3.a();
      }
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.PagesYouMayLikeFeedUnitView
 * JD-Core Version:    0.6.0
 */