package com.karmascience.gifts.views;

import android.app.Activity;
import android.content.res.Resources;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.facebook.widget.UrlImage;
import com.karmascience.gifts.content.model.Image;
import com.karmascience.gifts.content.model.Product;
import com.karmascience.gifts.content.model.Sku;
import com.karmascience.gifts.controllers.OrderManager;
import com.karmascience.gifts.controllers.OrderManager.UserInfo;

class ProductSkuSelectorView$SkuAdapter extends BaseAdapter
{
  private final int b = 0;
  private final int c = 1;
  private final Product d;
  private final boolean e;
  private final int f;
  private final LayoutInflater g;
  private TextView h;
  private TextView i;

  public ProductSkuSelectorView$SkuAdapter(ProductSkuSelectorView paramProductSkuSelectorView, Product paramProduct)
  {
    this.d = paramProduct;
    this.e = this.d.l();
    int j = this.d.b();
    if (j % 2 == 0)
    {
      if (this.e);
      for (int m = j / 2; ; m = 1 + j / 2)
      {
        this.f = m;
        this.g = LayoutInflater.from(paramProductSkuSelectorView.g());
        return;
      }
    }
    if (this.e);
    for (int k = 1 + j / 2; ; k = 1 + (1 + j / 2))
    {
      this.f = k;
      break;
    }
  }

  public int getCount()
  {
    return this.f;
  }

  public Object getItem(int paramInt)
  {
    return null;
  }

  public long getItemId(int paramInt)
  {
    return 0L;
  }

  public int getItemViewType(int paramInt)
  {
    boolean bool = this.e;
    int j = 0;
    if (bool);
    while (true)
    {
      return j;
      j = 0;
      if (paramInt != 0)
        continue;
      j = 1;
    }
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ProductSkuSelectorView.SkuAdapter.SkuViewHolder localSkuViewHolder1;
    int j;
    String str3;
    label325: label347: Uri localUri1;
    if (getItemViewType(paramInt) == 0)
    {
      if (paramView == null)
      {
        paramView = View.inflate(this.a.g(), 2130903508, null);
        ProductSkuSelectorView.SkuAdapter.SkuViewHolder localSkuViewHolder2 = new ProductSkuSelectorView.SkuAdapter.SkuViewHolder(this, null);
        localSkuViewHolder2.a = ((TextView)paramView.findViewById(2131297727));
        localSkuViewHolder2.b = paramView.findViewById(2131297728);
        localSkuViewHolder2.c = ((UrlImage)paramView.findViewById(2131297730));
        localSkuViewHolder2.c.setPlaceHolderDrawable(ProductSkuSelectorView.a(this.a));
        localSkuViewHolder2.d = ((TextView)paramView.findViewById(2131297731));
        localSkuViewHolder2.f = paramView.findViewById(2131297732);
        localSkuViewHolder2.f.setVisibility(0);
        localSkuViewHolder2.e = ((TextView)localSkuViewHolder2.f.findViewById(2131297578));
        localSkuViewHolder2.g = paramView.findViewById(2131297733);
        localSkuViewHolder2.h = ((UrlImage)paramView.findViewById(2131297735));
        localSkuViewHolder2.h.setPlaceHolderDrawable(ProductSkuSelectorView.a(this.a));
        localSkuViewHolder2.i = ((TextView)paramView.findViewById(2131297736));
        localSkuViewHolder2.k = paramView.findViewById(2131297737);
        localSkuViewHolder2.j = ((TextView)localSkuViewHolder2.k.findViewById(2131297578));
        localSkuViewHolder2.c.setScaleType(ImageView.ScaleType.FIT_START);
        localSkuViewHolder2.c.setAdjustViewBounds(true);
        localSkuViewHolder2.h.setScaleType(ImageView.ScaleType.FIT_START);
        localSkuViewHolder2.h.setAdjustViewBounds(true);
        paramView.setTag(localSkuViewHolder2);
      }
      localSkuViewHolder1 = (ProductSkuSelectorView.SkuAdapter.SkuViewHolder)paramView.getTag();
      if (this.e)
      {
        j = paramInt * 2;
        Sku localSku1 = this.d.a(j);
        if (j != 0)
          break label632;
        if (!this.e)
          break label592;
        str3 = this.d.g();
        localSkuViewHolder1.a.setText(str3.toUpperCase());
        localSkuViewHolder1.a.setVisibility(0);
        if (localSku1.f() == null)
          break label645;
        localUri1 = localSku1.f().a();
        label365: localSkuViewHolder1.c.setImageParams(localUri1);
        localSkuViewHolder1.d.setText(localSku1.a());
        localSkuViewHolder1.e.setText(CommonViewUtils.b(localSku1.d()));
        localSkuViewHolder1.b.setOnClickListener(new ProductSkuSelectorView.SkuAdapter.1(this, localSku1, j));
        if (j + 1 >= this.d.b())
          break label651;
        localSkuViewHolder1.g.setVisibility(0);
        Sku localSku2 = this.d.a(j + 1);
        localSkuViewHolder1.g.setOnClickListener(new ProductSkuSelectorView.SkuAdapter.2(this, localSku2, j));
        Image localImage = localSku2.f();
        Uri localUri2 = null;
        if (localImage != null)
          localUri2 = localSku2.f().a();
        localSkuViewHolder1.h.setImageParams(localUri2);
        localSkuViewHolder1.i.setText(localSku2.a());
        localSkuViewHolder1.j.setText(CommonViewUtils.b(localSku2.d()));
        localSkuViewHolder1.h.setVisibility(0);
        localSkuViewHolder1.i.setVisibility(0);
        localSkuViewHolder1.j.setVisibility(0);
        localSkuViewHolder1.k.setVisibility(0);
      }
    }
    while (true)
    {
      return paramView;
      j = 2 * (paramInt - 1);
      break;
      label592: Activity localActivity2 = this.a.g();
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = this.d.g();
      str3 = localActivity2.getString(2131362254, arrayOfObject2);
      break label325;
      label632: localSkuViewHolder1.a.setVisibility(8);
      break label347;
      label645: localUri1 = null;
      break label365;
      label651: localSkuViewHolder1.g.setVisibility(4);
      localSkuViewHolder1.g.setOnClickListener(null);
      localSkuViewHolder1.h.setVisibility(8);
      localSkuViewHolder1.i.setVisibility(8);
      localSkuViewHolder1.j.setVisibility(8);
      localSkuViewHolder1.k.setVisibility(8);
      continue;
      if (paramView != null)
        continue;
      paramView = View.inflate(this.a.g(), 2130903509, null);
      TextView localTextView1 = (TextView)paramView.findViewById(2131297738);
      this.h = localTextView1;
      View localView = paramView.findViewById(2131297742);
      localView.setVisibility(0);
      TextView localTextView2 = (TextView)localView.findViewById(2131297578);
      TextView localTextView3 = (TextView)paramView.findViewById(2131297741);
      this.i = localTextView3;
      UrlImage localUrlImage = (UrlImage)paramView.findViewById(2131297740);
      localUrlImage.setPlaceHolderDrawable(ProductSkuSelectorView.a(this.a));
      localTextView2.setText(CommonViewUtils.a(this.d.h(), this.d.i()));
      String str1 = CommonViewUtils.d(this.a.p().d().b);
      Activity localActivity1 = this.a.g();
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = str1;
      arrayOfObject1[1] = this.d.f();
      String str2 = localActivity1.getString(2131362255, arrayOfObject1);
      localTextView1.setText(this.a.g().getResources().getString(2131362253, new Object[] { str1 }).toUpperCase());
      localTextView3.setText(str2);
      paramView.setOnClickListener(new ProductSkuSelectorView.SkuAdapter.3(this));
      if (this.d.o() != null)
      {
        localUrlImage.setImageParams(this.d.o().a());
        continue;
      }
      localUrlImage.setImageParams((Uri)null);
    }
  }

  public int getViewTypeCount()
  {
    if (this.e);
    for (int j = 1; ; j = 2)
      return j;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.views.ProductSkuSelectorView.SkuAdapter
 * JD-Core Version:    0.6.0
 */