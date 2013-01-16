package com.karmascience.gifts.views;

import android.app.Activity;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.facebook.widget.UrlImage;
import com.karmascience.gifts.AnalyticsWrapper;
import com.karmascience.gifts.AnalyticsWrapper.MetricsEvent;
import com.karmascience.gifts.content.model.Image;
import com.karmascience.gifts.content.model.Product;
import com.karmascience.gifts.content.model.Products;
import com.karmascience.gifts.controllers.OrderManager;
import com.karmascience.gifts.controllers.OrderManager.UserInfo;
import com.karmascience.gifts.controllers.ProductsManager;
import com.karmascience.gifts.controllers.ProductsManager.GraphQLProductsRequestBuilder;
import com.karmascience.gifts.controllers.ProductsManager.GraphQLProductsRequestListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ProductsView$ProductsAdapter extends BaseAdapter
  implements AdapterView.OnItemClickListener
{
  private final LayoutInflater b;
  private final List<Products> c;
  private final List<ProductsView.CategoryPair> d;
  private final boolean e;
  private ProductsManager.GraphQLProductsRequestListener f;
  private Product g;

  public ProductsView$ProductsAdapter(List<ProductsView.CategoryPair> paramList)
  {
    Object localObject;
    this.d = localObject;
    if (this.d.size() == i);
    while (true)
    {
      this.e = i;
      this.b = ((LayoutInflater)paramList.g().getSystemService("layout_inflater"));
      this.c = new ArrayList();
      a();
      return;
      i = 0;
    }
  }

  private void a()
  {
    ProductsManager.GraphQLProductsRequestBuilder localGraphQLProductsRequestBuilder;
    if ((this.f == null) && (this.c.size() < this.d.size()))
    {
      String str = ((ProductsView.CategoryPair)this.d.get(this.c.size())).a;
      this.f = new ProductsView.ProductsAdapter.1(this);
      localGraphQLProductsRequestBuilder = this.a.r().a(this.f);
      localGraphQLProductsRequestBuilder.b(this.a.p().d().a);
      if (str == null)
        break label113;
      localGraphQLProductsRequestBuilder.a(str);
    }
    while (true)
    {
      localGraphQLProductsRequestBuilder.a();
      return;
      label113: if (this.e)
        continue;
      localGraphQLProductsRequestBuilder.a(9);
    }
  }

  public int getCount()
  {
    Iterator localIterator = this.c.iterator();
    int i = 0;
    while (localIterator.hasNext())
      i += 1 + ((Products)localIterator.next()).a() / 2;
    return i;
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
    Iterator localIterator = this.c.iterator();
    int i = 0;
    Products localProducts;
    int j;
    if (localIterator.hasNext())
    {
      localProducts = (Products)localIterator.next();
      j = 0;
      if (paramInt != i);
    }
    while (true)
    {
      return j;
      int k = i + (1 + localProducts.a() / 2);
      if (paramInt < k)
      {
        j = 1;
        continue;
      }
      i = k;
      break;
      j = 1;
    }
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    int j = 0;
    int k = 0;
    Products localProducts1 = null;
    int n;
    Products localProducts2;
    int m;
    if (j < this.c.size())
    {
      localProducts1 = (Products)this.c.get(j);
      int i2 = 1 + localProducts1.a() / 2;
      k += i2;
      if (paramInt < k)
      {
        int i3 = i2 + (paramInt - k);
        n = j;
        localProducts2 = localProducts1;
        m = i3;
      }
    }
    while (true)
    {
      int i1;
      label104: Product localProduct1;
      ProductsView.ProductsAdapter.ViewHolder localViewHolder1;
      if (m != 0)
      {
        i1 = -1 + m * 2;
        localProduct1 = localProducts2.a(i1);
        if (i != 0)
          break label521;
        if (paramView == null)
        {
          paramView = this.b.inflate(2130903518, paramViewGroup, false);
          ProductsView.ProductsAdapter.ViewHolder localViewHolder2 = new ProductsView.ProductsAdapter.ViewHolder(this, null);
          localViewHolder2.e = paramView.findViewById(2131297739);
          localViewHolder2.a = ((UrlImage)paramView.findViewById(2131297751));
          localViewHolder2.a.setScaleType(ImageView.ScaleType.FIT_CENTER);
          localViewHolder2.a.setAdjustViewBounds(true);
          localViewHolder2.a.setPlaceHolderDrawable(ProductsView.f(this.a));
          localViewHolder2.c = ((TextView)paramView.findViewById(2131297578));
          localViewHolder2.b = ((TextView)paramView.findViewById(2131297576));
          localViewHolder2.d = ((TextView)paramView.findViewById(2131297750));
          paramView.findViewById(2131297713).setVisibility(0);
          paramView.setTag(localViewHolder2);
        }
        localViewHolder1 = (ProductsView.ProductsAdapter.ViewHolder)paramView.getTag();
        Image localImage = localProduct1.n();
        if (localImage == null)
          break label494;
        localViewHolder1.a.setImageParams(localImage.a());
        label297: localViewHolder1.c.setText(CommonViewUtils.a(localProduct1.h(), localProduct1.i()));
        localViewHolder1.b.setText(localProduct1.c());
        localViewHolder1.d.setText(((ProductsView.CategoryPair)this.d.get(n)).b.toUpperCase());
        paramView.setOnTouchListener(new ProductsView.ProductsAdapter.2(this, localProduct1));
        if ((!localProduct1.q()) || (ProductsView.g(this.a)))
          break label509;
        ProductsView.a(localViewHolder1.e, 0.5F);
        label402: this.a.n().c("Viewed Product").a("product_id", localProduct1.e()).a();
        label429: if (paramInt + 10 >= getCount())
        {
          if (((((ProductsView.CategoryPair)this.d.get(n)).a == null) && (!this.e)) || (!localProducts2.b()))
            break label1172;
          localProducts2.c();
        }
      }
      while (true)
      {
        return paramView;
        j++;
        break;
        i1 = 0;
        break label104;
        label494: localViewHolder1.a.setImageParams((Uri)null);
        break label297;
        label509: ProductsView.a(localViewHolder1.e, 1.0F);
        break label402;
        label521: if (paramView == null)
        {
          paramView = this.b.inflate(2130903513, paramViewGroup, false);
          ProductsView.ProductsAdapter.DualViewHolder localDualViewHolder2 = new ProductsView.ProductsAdapter.DualViewHolder(this, null);
          paramView.setTag(localDualViewHolder2);
          localDualViewHolder2.a = paramView.findViewById(2131297728);
          localDualViewHolder2.b = ((UrlImage)paramView.findViewById(2131297730));
          localDualViewHolder2.b.setPlaceHolderDrawable(ProductsView.h(this.a));
          localDualViewHolder2.c = ((TextView)paramView.findViewById(2131297731));
          localDualViewHolder2.e = paramView.findViewById(2131297746);
          localDualViewHolder2.e.setVisibility(0);
          localDualViewHolder2.d = ((TextView)localDualViewHolder2.e.findViewById(2131297578));
          localDualViewHolder2.f = paramView.findViewById(2131297733);
          localDualViewHolder2.g = ((UrlImage)paramView.findViewById(2131297735));
          localDualViewHolder2.g.setPlaceHolderDrawable(ProductsView.h(this.a));
          localDualViewHolder2.h = ((TextView)paramView.findViewById(2131297736));
          localDualViewHolder2.j = paramView.findViewById(2131297748);
          localDualViewHolder2.j.setVisibility(0);
          localDualViewHolder2.i = ((TextView)localDualViewHolder2.j.findViewById(2131297578));
          localDualViewHolder2.b.setScaleType(ImageView.ScaleType.FIT_CENTER);
          localDualViewHolder2.b.setAdjustViewBounds(true);
          localDualViewHolder2.g.setScaleType(ImageView.ScaleType.FIT_CENTER);
          localDualViewHolder2.g.setAdjustViewBounds(true);
        }
        ProductsView.ProductsAdapter.DualViewHolder localDualViewHolder1 = (ProductsView.ProductsAdapter.DualViewHolder)paramView.getTag();
        label820: Product localProduct2;
        if (localProduct1.o() != null)
        {
          localDualViewHolder1.b.setImageParams(localProduct1.o().a());
          localDualViewHolder1.c.setText(localProduct1.c());
          localDualViewHolder1.d.setText(CommonViewUtils.a(localProduct1.h(), localProduct1.i()));
          localDualViewHolder1.a.setOnTouchListener(new ProductsView.ProductsAdapter.3(this, localProduct1));
          this.a.n().c("Viewed Product").a("product_id", localProduct1.e()).a();
          if ((!localProduct1.q()) || (ProductsView.g(this.a)))
            break label1112;
          ProductsView.a(localDualViewHolder1.a, 0.5F);
          label928: localProduct2 = localProducts2.a(i1 + 1);
          if (localProduct2 == null)
            break label1151;
          localDualViewHolder1.f.setVisibility(0);
          localDualViewHolder1.i.setVisibility(0);
          if (localProduct2.o() == null)
            break label1124;
          localDualViewHolder1.g.setImageParams(localProduct2.o().a());
          label986: localDualViewHolder1.h.setText(localProduct2.c());
          localDualViewHolder1.i.setText(CommonViewUtils.a(localProduct2.h(), localProduct2.i()));
          localDualViewHolder1.f.setOnTouchListener(new ProductsView.ProductsAdapter.4(this, localProduct2));
          if ((!localProduct2.q()) || (ProductsView.g(this.a)))
            break label1139;
          ProductsView.a(localDualViewHolder1.f, 0.5F);
        }
        while (true)
        {
          this.a.n().c("Viewed Product").a("product_id", localProduct2.e()).a();
          break;
          localDualViewHolder1.b.setImageParams((Uri)null);
          break label820;
          label1112: ProductsView.a(localDualViewHolder1.a, 1.0F);
          break label928;
          label1124: localDualViewHolder1.g.setImageParams((Uri)null);
          break label986;
          label1139: ProductsView.a(localDualViewHolder1.f, 1.0F);
        }
        label1151: localDualViewHolder1.f.setVisibility(4);
        localDualViewHolder1.i.setVisibility(4);
        break label429;
        label1172: a();
      }
      localProducts2 = localProducts1;
      m = 0;
      n = 0;
    }
  }

  public int getViewTypeCount()
  {
    return 2;
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.g != null)
      this.a.a(this.g, paramInt);
    this.g = null;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.views.ProductsView.ProductsAdapter
 * JD-Core Version:    0.6.0
 */