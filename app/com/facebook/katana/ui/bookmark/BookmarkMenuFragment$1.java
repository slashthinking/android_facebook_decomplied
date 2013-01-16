package com.facebook.katana.ui.bookmark;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.content.SecureContextHelper;
import com.facebook.katana.features.uberbar.UberbarActivity;
import com.facebook.orca.inject.FbInjector;

class BookmarkMenuFragment$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.a.p(), UberbarActivity.class);
    BookmarkMenuFragment.a(this.a).a(false);
    ((SecureContextHelper)this.a.R().a(SecureContextHelper.class)).a(localIntent, this.a.p());
    this.a.n().overridePendingTransition(2130968586, 2130968591);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.ui.bookmark.BookmarkMenuFragment.1
 * JD-Core Version:    0.6.0
 */