package com.karmascience.gifts.views;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.karmascience.gifts.AnalyticsWrapper;
import com.karmascience.gifts.AnalyticsWrapper.MetricsEvent;
import com.karmascience.gifts.content.model.Product;
import com.karmascience.gifts.content.model.Sku;
import com.karmascience.gifts.widget.QuadOptionSelector;
import java.util.Map;

class iTunesSkuSelectionView$3
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    String str1 = (String)paramView.getTag();
    Bundle localBundle2;
    if ("_SKIP_".equals(str1))
    {
      localBundle2 = CommonViewUtils.a(12);
      this.a.n().c("Skipped iTunes Recommendation").a("page_identifier", this.a.d()).a();
    }
    Bundle localBundle1;
    for (Object localObject = localBundle2; ; localObject = localBundle1)
    {
      String str2 = (String)iTunesSkuSelectionView.a(this.a).getCurrentSelection();
      Sku localSku = iTunesSkuSelectionView.b(this.a).a(str2);
      ((Bundle)localObject).putParcelable("product_parcelable", iTunesSkuSelectionView.b(this.a));
      ((Bundle)localObject).putParcelable("sku_parcelable", localSku);
      this.a.b((Bundle)localObject);
      return;
      localBundle1 = CommonViewUtils.a(17);
      localBundle1.putString("media_type", str1);
      localBundle1.putInt("header_res_id", ((Integer)iTunesSkuSelectionView.C().get(str1)).intValue());
      localBundle1.putInt("search_hint_res_id", ((Integer)iTunesSkuSelectionView.D().get(str1)).intValue());
      this.a.n().c("Clicked iTunes Recommendation Category").a("media_type", str1).a();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.views.iTunesSkuSelectionView.3
 * JD-Core Version:    0.6.0
 */