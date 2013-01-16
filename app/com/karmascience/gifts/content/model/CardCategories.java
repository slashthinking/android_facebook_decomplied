package com.karmascience.gifts.content.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Iterator;
import java.util.List;

public class CardCategories
{

  @JsonProperty("nodes")
  private final List<CardCategory> mCategories = null;

  public int a()
  {
    if (this.mCategories != null);
    for (int i = this.mCategories.size(); ; i = 0)
      return i;
  }

  public CardCategory a(int paramInt)
  {
    if (this.mCategories != null);
    for (CardCategory localCardCategory = (CardCategory)this.mCategories.get(paramInt); ; localCardCategory = null)
      return localCardCategory;
  }

  public CardCategory a(String paramString)
  {
    CardCategory localCardCategory;
    if ((this.mCategories != null) && (paramString != null))
    {
      Iterator localIterator = this.mCategories.iterator();
      do
      {
        if (!localIterator.hasNext())
          break;
        localCardCategory = (CardCategory)localIterator.next();
      }
      while ((localCardCategory == null) || (!paramString.equals(localCardCategory.a())));
    }
    while (true)
    {
      return localCardCategory;
      localCardCategory = null;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.content.model.CardCategories
 * JD-Core Version:    0.6.0
 */