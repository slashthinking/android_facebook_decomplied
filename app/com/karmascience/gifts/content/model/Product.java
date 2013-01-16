package com.karmascience.gifts.content.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Iterator;
import java.util.List;

public class Product
  implements Parcelable
{
  private final Bundle a = new Bundle();

  @JsonProperty("must_pick_sku")
  private final boolean hasMandatorySku = false;

  @JsonProperty("brand")
  private final String mBrand = null;

  @JsonProperty("choose_sku_line")
  private final String mChooseSkuLine = null;

  @JsonProperty("choose_sku_sentence")
  private final String mChooseSkuSentence = null;

  @JsonProperty("description")
  private final String mDescription = null;

  @JsonProperty("display_name")
  private final String mDisplayName = null;

  @JsonProperty("full_images")
  private final List<Image> mFullImages = null;

  @JsonProperty("id")
  private final String mId = null;

  @JsonProperty("max_price")
  private final int mMaxPrice = 0;

  @JsonProperty("min_price")
  private final int mMinPrice = 0;

  @JsonProperty("name")
  private final String mName = null;

  @JsonProperty("product_type")
  private final String mProductType = null;

  @JsonProperty("skus")
  private final Skus mSkus = null;

  @JsonProperty("thumb_images")
  private final List<Image> mThumbImages = null;

  @JsonProperty("sender_must_prepay")
  private final boolean senderMustPrepay = false;

  public Sku a(int paramInt)
  {
    if (this.mSkus != null);
    for (Sku localSku = this.mSkus.a(paramInt); ; localSku = null)
      return localSku;
  }

  public Sku a(String paramString)
  {
    if (this.mSkus != null);
    for (Sku localSku = this.mSkus.a(paramString); ; localSku = null)
      return localSku;
  }

  public List<Sku> a()
  {
    if (this.mSkus != null);
    for (List localList = this.mSkus.a(); ; localList = null)
      return localList;
  }

  public void a(String paramString1, String paramString2)
  {
    this.a.putString(paramString1, paramString2);
  }

  public int b()
  {
    if (this.mSkus != null);
    for (int i = this.mSkus.b(); ; i = 0)
      return i;
  }

  public String b(String paramString)
  {
    return this.a.getString(paramString);
  }

  public String c()
  {
    return this.mName;
  }

  public boolean c(String paramString)
  {
    String str = this.a.getString(paramString);
    try
    {
      boolean bool2 = Boolean.parseBoolean(str);
      bool1 = bool2;
      return bool1;
    }
    catch (Exception localException)
    {
      while (true)
        boolean bool1 = false;
    }
  }

  public String d()
  {
    return this.mDisplayName;
  }

  public int describeContents()
  {
    return 0;
  }

  public String e()
  {
    return this.mId;
  }

  public String f()
  {
    return this.mChooseSkuLine;
  }

  public String g()
  {
    return this.mChooseSkuSentence;
  }

  public int h()
  {
    return this.mMinPrice;
  }

  public int i()
  {
    return this.mMaxPrice;
  }

  public String j()
  {
    return this.mDescription;
  }

  public String k()
  {
    return this.mProductType;
  }

  public boolean l()
  {
    return this.hasMandatorySku;
  }

  public boolean m()
  {
    return this.senderMustPrepay;
  }

  public Image n()
  {
    if ((this.mFullImages != null) && (this.mFullImages.size() > 0));
    for (Image localImage = (Image)this.mFullImages.get(0); ; localImage = null)
      return localImage;
  }

  public Image o()
  {
    if ((this.mThumbImages != null) && (this.mThumbImages.size() > 0));
    for (Image localImage = (Image)this.mThumbImages.get(0); ; localImage = null)
      return localImage;
  }

  public boolean p()
  {
    return "itunes_desktop".equals(k());
  }

  public boolean q()
  {
    return "alcohol".equals(k());
  }

  public int r()
  {
    Skus localSkus = this.mSkus;
    int i = 0;
    if (localSkus != null)
    {
      List localList = a();
      i = 0;
      if (localList != null)
      {
        Iterator localIterator = localList.iterator();
        for (int j = 0; localIterator.hasNext(); j = Math.max(j, ((Sku)localIterator.next()).e()));
        i = j;
      }
    }
    return i;
  }

  public List<Image> s()
  {
    return this.mFullImages;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.content.model.Product
 * JD-Core Version:    0.6.0
 */