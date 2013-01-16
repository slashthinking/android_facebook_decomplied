package com.facebook.pages.identity.ui.about;

import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.intent.IFeedIntentBuilder;
import com.facebook.orca.common.util.StringLocaleUtil;

class PageIdentityLocalCardView$1
  implements View.OnClickListener
{
  PageIdentityLocalCardView$1(PageIdentityLocalCardView paramPageIdentityLocalCardView)
  {
  }

  public void onClick(View paramView)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Long.valueOf(PageIdentityLocalCardView.a(this.a));
    arrayOfObject[1] = Integer.valueOf(3);
    String str = StringLocaleUtil.a("fb://faceweb/f?href=%s", new Object[] { Uri.encode(StringLocaleUtil.a("/profile.php?v=timeline&id=%1$d&filter=%2$d", arrayOfObject)) });
    PageIdentityLocalCardView.b(this.a).a(this.a.getContext(), str);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.pages.identity.ui.about.PageIdentityLocalCardView.1
 * JD-Core Version:    0.6.2
 */