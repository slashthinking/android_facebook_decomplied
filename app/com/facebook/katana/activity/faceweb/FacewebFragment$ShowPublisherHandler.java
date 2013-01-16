package com.facebook.katana.activity.faceweb;

import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.common.util.ErrorReporting;
import com.facebook.debug.Assert;
import com.facebook.ipc.katana.model.FacebookUser;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.util.FBLocationManager;
import com.facebook.katana.util.FBLocationManager.FBLocationListener;
import com.facebook.katana.webview.FacebookWebView;
import com.facebook.katana.webview.FacewebPalCall;
import com.facebook.katana.webview.FacewebWebView;

class FacewebFragment$ShowPublisherHandler extends FacewebFragment.StatefulNativeUICallHandler
{
  public FacewebFragment$ShowPublisherHandler(FacewebFragment paramFacewebFragment, Handler paramHandler)
  {
    super(paramHandler);
  }

  private void a()
  {
    this.a.A().findViewById(2131297771).setOnClickListener(new FacewebFragment.ShowPublisherHandler.3(this));
  }

  private void a(int paramInt1, int paramInt2)
  {
    ((TextView)this.a.A().findViewById(paramInt1)).setText(paramInt2);
  }

  private void a(FacewebPalCall paramFacewebPalCall)
  {
    String str1;
    long l;
    String str3;
    boolean bool;
    if (FacewebFragment.b(this.a) != null)
    {
      str1 = FacewebFragment.b(this.a).getMobilePage();
      l = paramFacewebPalCall.a(str1, "target", -1L);
      String str2 = paramFacewebPalCall.a(str1, "type", "feed");
      Assert.a(str2);
      str3 = str2.toLowerCase();
      if ((!str3.equals("event")) && (!str3.equals("page")) && (!str3.equals("group")) && ((!str3.equals("user")) || (l == -1L) || (FacewebFragment.d(this.a).b().a().mUserId == l)))
        break label252;
      if ((str3.equals("group")) || (str3.equals("event")))
        FacewebFragment.c(this.a, paramFacewebPalCall.a(str1, "title", ""));
      this.a.A().findViewById(2131297771).setVisibility(8);
      a(2131297770, 2131362125);
      if ((str3.equals("user")) && (paramFacewebPalCall.b(str1, "target")))
        break label246;
      bool = true;
      label217: a(bool, str3);
      a(2131297767, 2131362127);
      a(str3, l);
    }
    while (true)
    {
      return;
      str1 = null;
      break;
      label246: bool = false;
      break label217;
      label252: if ((str3.equals("feed")) || (str3.equals("user")) || (str3.equals("friendlist")))
      {
        if (str3.equals("friendlist"))
          FacewebFragment.c(this.a, paramFacewebPalCall.a(str1, "title", ""));
        a(2131297770, 2131363043);
        a(true, str3);
        a(2131297767, 2131362126);
        a(str3, l);
        a(2131297773, 2131363288);
        a();
        continue;
      }
      ErrorReporting.a("ShowPublisherHandler", "Unknown publisher type: " + str3, true);
      this.a.a(this.a.P(), this.a.M());
    }
  }

  private void a(String paramString, long paramLong)
  {
    this.a.A().findViewById(2131297765).setOnClickListener(new FacewebFragment.ShowPublisherHandler.1(this, paramString, paramLong));
  }

  private void a(boolean paramBoolean, String paramString)
  {
    this.a.A().findViewById(2131297768).setOnClickListener(new FacewebFragment.ShowPublisherHandler.2(this, paramString));
  }

  public void a(Context paramContext, FacebookWebView paramFacebookWebView)
  {
    FacewebFragment.b(this.a, true);
    FacewebFragment.b(this.a, this.f.a(paramFacebookWebView.getMobilePage(), "callback"));
    FacewebFragment.b(this.a, this.f.a(paramFacebookWebView.getMobilePage(), "target", -1L));
    FacewebFragment.a(this.a, FacewebFragment.i(this.a));
    if (!FacewebFragment.d(this.a).c())
      ErrorReporting.a("ShowPublisherHandler", "invalid session info", true);
    while (true)
    {
      return;
      Location localLocation = FBLocationManager.a(300000);
      FragmentActivity localFragmentActivity = this.a.n();
      if (!(localFragmentActivity instanceof FBLocationManager.FBLocationListener))
        continue;
      ((FBLocationManager.FBLocationListener)localFragmentActivity).a(localLocation);
    }
  }

  public void b(Context paramContext, FacebookWebView paramFacebookWebView)
  {
    View localView = this.a.A();
    if (localView == null);
    while (true)
    {
      return;
      ViewGroup localViewGroup = (ViewGroup)localView.findViewById(2131296896);
      if (FacewebFragment.j(this.a))
      {
        if (localViewGroup.getChildCount() == 0)
        {
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
          localViewGroup.addView(LayoutInflater.from(paramContext).inflate(2130903526, null), localLayoutParams);
        }
        if (this.f == null)
          continue;
        a(this.f);
        continue;
      }
      if (localViewGroup.getChildCount() <= 0)
        continue;
      localViewGroup.removeAllViews();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.faceweb.FacewebFragment.ShowPublisherHandler
 * JD-Core Version:    0.6.0
 */