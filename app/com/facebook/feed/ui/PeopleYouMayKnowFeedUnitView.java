package com.facebook.feed.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.feed.renderer.FeedUnitViewStyle;
import com.facebook.feed.ui.footer.PYMKFeedUnitFooterSection;
import com.facebook.feed.ui.pymk.PYMKFeedUnitSuggestionsSection;
import com.facebook.graphql.model.PeopleYouMayKnowFeedUnit;
import com.facebook.widget.CustomLinearLayout;

public class PeopleYouMayKnowFeedUnitView extends CustomLinearLayout
  implements BindableFeedUnitView<PeopleYouMayKnowFeedUnit>
{
  private final PYMKFeedUnitSuggestionsSection a;
  private final PYMKFeedUnitFooterSection b;

  public PeopleYouMayKnowFeedUnitView(Context paramContext)
  {
    this(paramContext, null);
  }

  public PeopleYouMayKnowFeedUnitView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setContentView(2130903529);
    this.a = ((PYMKFeedUnitSuggestionsSection)b(2131297781));
    this.b = ((PYMKFeedUnitFooterSection)b(2131297783));
  }

  public void a(PeopleYouMayKnowFeedUnit paramPeopleYouMayKnowFeedUnit, FeedUnitViewStyle paramFeedUnitViewStyle, boolean paramBoolean)
  {
    setVisibility(8);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.PeopleYouMayKnowFeedUnitView
 * JD-Core Version:    0.6.0
 */