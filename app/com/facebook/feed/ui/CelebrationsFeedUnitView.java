package com.facebook.feed.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.feed.renderer.FeedUnitViewStyle;
import com.facebook.graphql.model.CelebrationsFeedUnit;
import com.facebook.graphql.model.CelebrationsItem;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.widget.CustomLinearLayout;
import java.util.List;

public class CelebrationsFeedUnitView extends CustomLinearLayout
  implements BindableFeedUnitView<CelebrationsFeedUnit>
{
  private final LinearLayout a;
  private final TextView b;
  private final View c;
  private final Context d;

  public CelebrationsFeedUnitView(Context paramContext)
  {
    this(paramContext, null);
  }

  public CelebrationsFeedUnitView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setContentView(2130903091);
    this.d = paramContext;
    this.a = ((LinearLayout)b(2131296484));
    this.b = ((TextView)b(2131296483));
    this.c = b(2131296486);
    this.c.setOnClickListener(new CelebrationsFeedUnitView.1(this));
  }

  public void a(CelebrationsFeedUnit paramCelebrationsFeedUnit, FeedUnitViewStyle paramFeedUnitViewStyle, boolean paramBoolean)
  {
    if (paramCelebrationsFeedUnit.title != null)
      this.b.setText(paramCelebrationsFeedUnit.title.text);
    int i = Math.min(paramCelebrationsFeedUnit.items.size(), 3);
    int j = getChildCount();
    if (j > i)
      removeViews(i, j - i);
    int k = 0;
    CelebrationsFeedUnitItemView localCelebrationsFeedUnitItemView1;
    CelebrationsFeedUnitItemView localCelebrationsFeedUnitItemView2;
    if (k < i)
    {
      localCelebrationsFeedUnitItemView1 = (CelebrationsFeedUnitItemView)this.a.getChildAt(k);
      if (localCelebrationsFeedUnitItemView1 != null)
        break label159;
      localCelebrationsFeedUnitItemView2 = new CelebrationsFeedUnitItemView(this.d);
      this.a.addView(localCelebrationsFeedUnitItemView2);
    }
    label159: for (CelebrationsFeedUnitItemView localCelebrationsFeedUnitItemView3 = localCelebrationsFeedUnitItemView2; ; localCelebrationsFeedUnitItemView3 = localCelebrationsFeedUnitItemView1)
    {
      localCelebrationsFeedUnitItemView3.a((CelebrationsItem)paramCelebrationsFeedUnit.items.get(k));
      if (k == 0)
        localCelebrationsFeedUnitItemView3.b();
      while (true)
      {
        k++;
        break;
        localCelebrationsFeedUnitItemView3.a();
      }
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.CelebrationsFeedUnitView
 * JD-Core Version:    0.6.0
 */