package com.facebook.pages.identity.ui.about;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.graphql.model.PageRecommendation;
import com.facebook.pages.identity.data.PageTopRecommendations;
import com.facebook.pages.identity.ui.PageRecommendationRowView;
import com.facebook.widget.CustomViewGroup;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;

public class PageIdentityTopRecommendationsView extends CustomViewGroup
{
  private final PageRecommendationRowView a;
  private final PageRecommendationRowView b;
  private final PageRecommendationRowView c;

  public PageIdentityTopRecommendationsView(Context paramContext)
  {
    this(paramContext, null);
  }

  public PageIdentityTopRecommendationsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public PageIdentityTopRecommendationsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2130903466);
    this.a = ((PageRecommendationRowView)findViewById(2131297640));
    this.b = ((PageRecommendationRowView)findViewById(2131297641));
    this.c = ((PageRecommendationRowView)findViewById(2131297642));
  }

  private void setRecommendationsData(List<PageRecommendation> paramList)
  {
    this.a.setVisibility(8);
    this.b.setVisibility(8);
    this.c.setVisibility(8);
    if (paramList == null);
    while (true)
    {
      return;
      if (paramList.size() > 0)
      {
        this.a.setVisibility(0);
        this.a.a((PageRecommendation)paramList.get(0));
      }
      if (paramList.size() > 1)
      {
        this.b.setVisibility(0);
        this.b.a((PageRecommendation)paramList.get(1));
      }
      if (paramList.size() > 2)
      {
        this.c.setVisibility(0);
        this.c.a((PageRecommendation)paramList.get(2));
      }
    }
  }

  public void a(PageRecommendation paramPageRecommendation)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramPageRecommendation);
    if (this.a.getVisibility() == 0)
      localArrayList.add(this.a.getRecommendation());
    if (this.b.getVisibility() == 0)
      localArrayList.add(this.b.getRecommendation());
    setRecommendationsData(localArrayList);
  }

  public void setTopRecommendations(PageTopRecommendations paramPageTopRecommendations)
  {
    Preconditions.checkArgument(paramPageTopRecommendations.a());
    setRecommendationsData(paramPageTopRecommendations.a(3));
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.pages.identity.ui.about.PageIdentityTopRecommendationsView
 * JD-Core Version:    0.6.2
 */