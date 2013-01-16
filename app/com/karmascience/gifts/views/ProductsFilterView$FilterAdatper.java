package com.karmascience.gifts.views;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.karmascience.gifts.content.model.ProductCategories;
import com.karmascience.gifts.content.model.ProductCategory;
import com.karmascience.gifts.controllers.OrderManager;
import com.karmascience.gifts.controllers.OrderManager.UserInfo;

class ProductsFilterView$FilterAdatper extends BaseAdapter
  implements AdapterView.OnItemClickListener
{
  private final ProductCategories b;
  private final LayoutInflater c;
  private final String d;
  private String e;

  public ProductsFilterView$FilterAdatper(ProductsFilterView paramProductsFilterView, ProductCategories paramProductCategories, String paramString)
  {
    this.b = paramProductCategories;
    this.c = LayoutInflater.from(paramProductsFilterView.g());
    this.e = paramString;
    String str = CommonViewUtils.d(paramProductsFilterView.p().d().b);
    this.d = paramProductsFilterView.g().getString(2131362245, new Object[] { str });
  }

  public int getCount()
  {
    return 1 + this.b.a();
  }

  public Object getItem(int paramInt)
  {
    return null;
  }

  public long getItemId(int paramInt)
  {
    return 0L;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
      paramView = this.c.inflate(2130903514, paramViewGroup, false);
    TextView localTextView = (TextView)paramView.findViewById(2131297749);
    String str1;
    String str2;
    View localView;
    if (paramInt == 0)
    {
      str1 = this.d;
      str2 = "_RECOMMENDED_";
      localTextView.setText(str1);
      localView = paramView.findViewById(2131296427);
      if (!str2.equals(this.e))
        break label105;
      localView.setVisibility(0);
    }
    while (true)
    {
      return paramView;
      ProductCategory localProductCategory = this.b.a(paramInt - 1);
      str1 = localProductCategory.a();
      str2 = localProductCategory.b();
      break;
      label105: localView.setVisibility(4);
    }
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = paramInt - 1;
    if (i == 0);
    for (String str = "_RECOMMENDED_"; ; str = this.b.a(i - 1).b())
    {
      ProductsFilterView.a(this.a, str);
      return;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.views.ProductsFilterView.FilterAdatper
 * JD-Core Version:    0.6.0
 */