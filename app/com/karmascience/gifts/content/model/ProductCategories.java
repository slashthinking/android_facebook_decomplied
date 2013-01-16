package com.karmascience.gifts.content.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.karmascience.gifts.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductCategories
{

  @JsonProperty("nodes")
  private final List<ProductCategory> mCategories;

  protected ProductCategories()
  {
    this.mCategories = null;
  }

  private ProductCategories(List<ProductCategory> paramList)
  {
    this.mCategories = paramList;
  }

  public int a()
  {
    if (this.mCategories != null);
    for (int i = this.mCategories.size(); ; i = 0)
      return i;
  }

  public ProductCategories a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.mCategories != null)
    {
      Iterator localIterator = this.mCategories.iterator();
      while (localIterator.hasNext())
      {
        ProductCategory localProductCategory = (ProductCategory)localIterator.next();
        if (!Utils.a(localProductCategory.c(), paramString))
          continue;
        localArrayList.add(localProductCategory);
      }
    }
    return new ProductCategories(localArrayList);
  }

  public ProductCategory a(int paramInt)
  {
    if (this.mCategories != null);
    for (ProductCategory localProductCategory = (ProductCategory)this.mCategories.get(paramInt); ; localProductCategory = null)
      return localProductCategory;
  }

  public String b(String paramString)
  {
    ProductCategory localProductCategory;
    if (paramString != null)
    {
      Iterator localIterator = this.mCategories.iterator();
      do
      {
        if (!localIterator.hasNext())
          break;
        localProductCategory = (ProductCategory)localIterator.next();
      }
      while (!paramString.equals(localProductCategory.b()));
    }
    for (String str = localProductCategory.a(); ; str = null)
      return str;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.content.model.ProductCategories
 * JD-Core Version:    0.6.0
 */