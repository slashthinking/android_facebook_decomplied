package com.karmascience.gifts.content.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Iterator;
import java.util.List;

public class Skus
{

  @JsonProperty("nodes")
  private final List<Sku> mSkus = null;

  public Sku a(int paramInt)
  {
    if (this.mSkus != null);
    for (Sku localSku = (Sku)this.mSkus.get(paramInt); ; localSku = null)
      return localSku;
  }

  public Sku a(String paramString)
  {
    Sku localSku;
    if ((this.mSkus != null) && (paramString != null))
    {
      Iterator localIterator = this.mSkus.iterator();
      do
      {
        if (!localIterator.hasNext())
          break;
        localSku = (Sku)localIterator.next();
      }
      while (!paramString.equals(localSku.c()));
    }
    while (true)
    {
      return localSku;
      localSku = null;
    }
  }

  public List<Sku> a()
  {
    return this.mSkus;
  }

  public int b()
  {
    if (this.mSkus != null);
    for (int i = this.mSkus.size(); ; i = 0)
      return i;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.content.model.Skus
 * JD-Core Version:    0.6.0
 */