package com.facebook.pages.identity.data;

import com.facebook.graphql.model.PageRecommendation;
import com.facebook.graphql.model.PageRecommendationList;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;

public class PageTopRecommendations
{
  private final List<PageRecommendation> a;
  private final List<PageRecommendation> b;

  private PageTopRecommendations(PageRecommendationList paramPageRecommendationList1, PageRecommendationList paramPageRecommendationList2)
  {
    if (paramPageRecommendationList1 != null)
    {
      this.a = paramPageRecommendationList1.recommendations;
      if (paramPageRecommendationList2 == null)
        break label37;
    }
    label37: for (this.b = paramPageRecommendationList2.recommendations; ; this.b = null)
    {
      return;
      this.a = null;
      break;
    }
  }

  public static PageTopRecommendations a(PageRecommendationList paramPageRecommendationList1, PageRecommendationList paramPageRecommendationList2)
  {
    return new PageTopRecommendations(paramPageRecommendationList1, paramPageRecommendationList2);
  }

  public List<PageRecommendation> a(int paramInt)
  {
    ArrayList localArrayList = Lists.b(paramInt);
    if (this.a != null)
      for (int j = 0; (j < this.a.size()) && (localArrayList.size() < paramInt); j++)
        localArrayList.add(this.a.get(j));
    List localList = this.b;
    int i = 0;
    if (localList != null)
      while ((i < this.b.size()) && (localArrayList.size() < paramInt))
      {
        localArrayList.add(this.b.get(i));
        i++;
      }
    return localArrayList;
  }

  public boolean a()
  {
    if (((this.a != null) && (this.a.size() > 0)) || ((this.b != null) && (this.b.size() > 0)));
    for (boolean bool = true; ; bool = false)
      return bool;
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.pages.identity.data.PageTopRecommendations
 * JD-Core Version:    0.6.2
 */