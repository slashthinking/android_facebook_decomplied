package com.facebook.katana.activity.faceweb;

import android.content.Context;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageButton;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.activity.FacebookActivityDelegate;
import com.facebook.katana.util.StringUtils;
import com.facebook.katana.webview.FacebookWebView;
import com.facebook.katana.webview.FacewebPalCall;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpec;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpecBuilder;

class FacewebFragment$SetBookmarksMenuButton extends FacewebFragment.StatefulNativeUICallHandler
{
  private String b;
  private int c = -1;
  private String d = null;
  private String g = null;

  public FacewebFragment$SetBookmarksMenuButton(FacewebFragment paramFacewebFragment, Handler paramHandler)
  {
    super(paramHandler);
  }

  private int a(String paramString)
  {
    if ((paramString.equals("feed_filter_live")) || (paramString.equals("feed_filter_h_chr")));
    for (int i = 2130838243; ; i = c(paramString))
      return i;
  }

  private String b(String paramString)
  {
    String str;
    if (!paramString.equals("feed_filter_live"))
    {
      boolean bool = paramString.equals("feed_filter_h_chr");
      str = null;
      if (!bool);
    }
    else
    {
      str = this.a.n().getString(2131363451);
    }
    return str;
  }

  private int c(String paramString)
  {
    int i = 2130838375;
    if (paramString.equals("compose"))
      i = 2130838376;
    while (true)
    {
      return i;
      if (paramString.equals("add"))
      {
        i = 2130838373;
        continue;
      }
      if (paramString.equals("action"))
      {
        i = 2130838372;
        continue;
      }
      if (paramString.equals("feed_filter_live"))
      {
        i = 2130838251;
        continue;
      }
      if (paramString.equals("feed_filter_h_chr"))
      {
        i = 2130838247;
        continue;
      }
      if (paramString.equals("feed_filter_status"))
      {
        i = 2130838250;
        continue;
      }
      if (paramString.equals("feed_filter_photos"))
      {
        i = 2130838249;
        continue;
      }
      if (paramString.equals("feed_filter_links"))
      {
        i = 2130838246;
        continue;
      }
      if (paramString.equals("feed_filter_pages"))
      {
        i = 2130838248;
        continue;
      }
      if (paramString.equals("feed_filter_events"))
      {
        i = 2130838244;
        continue;
      }
      if (paramString.equals("feed_filter_videos"))
      {
        i = 2130838252;
        continue;
      }
      if (paramString.equals("feed_filter_lists"))
      {
        i = 2130838245;
        continue;
      }
      if ((paramString.equals("like")) || (paramString.equals("unlike")))
        continue;
      if (paramString.equals("feed_find_friends"))
      {
        i = 2130838253;
        continue;
      }
      i = -1;
    }
  }

  public void a(Context paramContext, FacebookWebView paramFacebookWebView)
  {
    if ("true".equals(this.f.a(paramFacebookWebView.getMobilePage(), "isDisabled")));
    while (true)
    {
      return;
      if ("right".equals(this.f.a(paramFacebookWebView.getMobilePage(), "position")))
      {
        this.b = this.f.a(paramFacebookWebView.getMobilePage(), "script");
        String str1 = this.f.a(paramFacebookWebView.getMobilePage(), "title");
        String str2 = this.f.a(paramFacebookWebView.getMobilePage(), "type");
        int i = c(str2);
        if (i >= 0)
        {
          this.c = i;
          this.d = null;
          this.g = str2;
          continue;
        }
        this.c = -1;
        this.d = str1;
        this.g = null;
        continue;
      }
    }
  }

  public void b(Context paramContext, FacebookWebView paramFacebookWebView)
  {
    BaseFacebookActivity localBaseFacebookActivity = this.a.P();
    if ((!this.a.v()) || (localBaseFacebookActivity == null));
    while (true)
    {
      return;
      if (FacewebFragment.o(this.a) != FacewebFragment.PrimaryActionDisplayType.NONE)
      {
        if (FacewebFragment.o(this.a) == FacewebFragment.PrimaryActionDisplayType.OPTIONS_MENU)
        {
          if (this.g == null)
            continue;
          FacewebFragment.a(this.a, new FacewebFragment.PrimaryActionMenuItem(a(this.g), b(this.g), this.b));
          continue;
        }
        localBaseFacebookActivity.a(TitleBarButtonSpec.newBuilder().b(this.c).b(this.d).i());
        FacewebFragment.SetBookmarksMenuButton.1 local1 = new FacewebFragment.SetBookmarksMenuButton.1(this);
        localBaseFacebookActivity.t().a(local1);
        if (this.c <= 0)
          continue;
        ImageButton localImageButton = (ImageButton)localBaseFacebookActivity.findViewById(2131296342);
        int i = this.c;
        boolean bool1 = false;
        if (i == 2130838375)
        {
          boolean bool2 = StringUtils.a(this.g, "like");
          bool1 = false;
          if (!bool2)
            bool1 = true;
        }
        localImageButton.setSelected(bool1);
        continue;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.faceweb.FacewebFragment.SetBookmarksMenuButton
 * JD-Core Version:    0.6.0
 */