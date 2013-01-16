package com.karmascience.gifts.views;

import android.app.Activity;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.facebook.graphql.model.GraphQLBirthdate;
import com.facebook.widget.UrlImage;
import com.karmascience.gifts.AnalyticsWrapper;
import com.karmascience.gifts.AnalyticsWrapper.MetricsEvent;
import com.karmascience.gifts.controllers.OrderManager;
import com.karmascience.gifts.controllers.OrderManager.UserInfo;
import com.karmascience.gifts.controllers.OrderManager.UserInfoListener;
import com.karmascience.gifts.controllers.ProductsManager;
import com.karmascience.gifts.controllers.ProductsManager.GraphQLProductCategoriesRequestListener;
import java.util.GregorianCalendar;

class ProductsView$2
  implements OrderManager.UserInfoListener
{
  public void a(int paramInt, String paramString)
  {
    if (this.b.l())
    {
      this.b.e().setVisibility(4);
      this.b.a(paramInt, paramString);
      this.b.n().c("Launch Failed").a();
      this.b.a(paramInt, paramString);
      this.b.g().finish();
    }
  }

  public void a(OrderManager.UserInfo paramUserInfo)
  {
    int i = 1;
    OrderManager.UserInfo localUserInfo = this.b.p().d();
    Activity localActivity = this.b.g();
    Object[] arrayOfObject = new Object[i];
    arrayOfObject[0] = localUserInfo.b;
    String str = localActivity.getString(2131362243, arrayOfObject);
    SpannableString localSpannableString = new SpannableString(str);
    StyleSpan localStyleSpan = new StyleSpan(i);
    int j = localUserInfo.b.length();
    int k = str.length();
    localSpannableString.setSpan(localStyleSpan, k - j, k, 17);
    ProductsView.c(this.b).setText(localSpannableString);
    ProductsView.d(this.b).setAdjustViewBounds(i);
    ProductsView.d(this.b).setScaleType(ImageView.ScaleType.CENTER_CROP);
    ProductsView.d(this.b).setImageParams(localUserInfo.c);
    if (localUserInfo.d != null)
    {
      GregorianCalendar localGregorianCalendar1 = new GregorianCalendar();
      localGregorianCalendar1.add(i, -21);
      GregorianCalendar localGregorianCalendar2 = new GregorianCalendar(localUserInfo.d.year, localUserInfo.d.month, localUserInfo.d.day);
      ProductsView localProductsView = this.b;
      if (!localGregorianCalendar2.after(localGregorianCalendar1))
        ProductsView.a(localProductsView, i);
    }
    while (true)
    {
      this.b.r().a(this.a);
      return;
      boolean bool = false;
      break;
      ProductsView.a(this.b, bool);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.views.ProductsView.2
 * JD-Core Version:    0.6.0
 */