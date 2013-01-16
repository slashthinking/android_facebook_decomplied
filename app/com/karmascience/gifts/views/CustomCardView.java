package com.karmascience.gifts.views;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.facebook.common.util.Toaster;
import com.facebook.orca.common.util.StringUtil;
import com.karmascience.gifts.AnalyticsWrapper;
import com.karmascience.gifts.AnalyticsWrapper.MetricsEvent;
import com.karmascience.gifts.Utils;
import com.karmascience.gifts.content.model.CardFront;
import com.karmascience.gifts.controllers.OrderManager;
import com.karmascience.gifts.controllers.OrderManager.CardInfo;
import com.karmascience.gifts.controllers.OrderManager.UserInfo;
import com.karmascience.gifts.ui.IViewManager;
import java.util.ArrayList;
import java.util.List;

public class CustomCardView extends KSViewController
  implements View.OnClickListener
{
  private final boolean a;
  private final boolean b;
  private final String c;
  private String d;
  private String e;
  private String f;
  private int g;
  private EditText h;
  private TextView i;
  private EditText j;
  private EditText k;
  private View l;
  private View m;
  private CustomCardView.PopupHandler n;
  private boolean o = false;

  public CustomCardView(Activity paramActivity, Handler paramHandler, IViewManager paramIViewManager, Bundle paramBundle, String paramString)
  {
    super(paramActivity, paramHandler, paramIViewManager, paramBundle, paramString);
    OrderManager.CardInfo localCardInfo = p().f();
    this.a = s().getBoolean("read_only");
    this.b = s().getBoolean("from_order_review");
    this.e = localCardInfo.a.d();
    this.f = ((String)localCardInfo.a.e().get(0));
    this.d = localCardInfo.c;
    OrderManager.UserInfo localUserInfo = p().e();
    if (!StringUtil.a(localCardInfo.e));
    for (String str = localCardInfo.e; ; str = localUserInfo.b)
    {
      this.c = str;
      return;
    }
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903128, paramViewGroup, false);
    this.m = localView;
    this.h = ((EditText)localView.findViewById(2131296635));
    this.i = ((TextView)localView.findViewById(2131296636));
    this.j = ((EditText)localView.findViewById(2131296637));
    this.k = ((EditText)localView.findViewById(2131296634));
    label156: OrderManager.UserInfo localUserInfo1;
    label190: OrderManager.UserInfo localUserInfo2;
    String str2;
    label228: OrderManager.CardInfo localCardInfo;
    Object localObject;
    if ((this.f != null) && (!this.f.trim().equals("")))
    {
      this.i.setText(this.f + ",");
      if ((this.d == null) || (this.d.trim().equals("")))
        break label498;
      this.h.setText(this.d);
      localUserInfo1 = p().e();
      if (this.c == null)
        break label512;
      String str5 = CommonViewUtils.d(this.c);
      this.j.setText(str5);
      localUserInfo2 = p().d();
      str2 = s().getString("recipient_name");
      if (!this.a)
        break label551;
      EditText localEditText2 = this.k;
      if (str2 == null)
        break label534;
      localEditText2.setText(str2);
      localCardInfo = p().f();
      if (!this.a)
        break label585;
      localObject = new ArrayList();
      ((List)localObject).add(s().getString("closing"));
    }
    while (true)
    {
      this.n = new CustomCardView.PopupHandler(this, this.i, (List)localObject, "Chose Card Closing", true);
      String str3 = localCardInfo.c;
      if ((str3 != null) && (!str3.trim().equals("")))
        this.h.setText(str3);
      this.h.addTextChangedListener(new CustomCardView.1(this));
      this.h.setOnEditorActionListener(new CustomCardView.2(this));
      this.l = localView.findViewById(2131296633);
      localView.findViewById(2131296638).setOnClickListener(this);
      TextView localTextView = (TextView)localView.findViewById(2131296632);
      String str4 = CommonViewUtils.d(localUserInfo2.b);
      localTextView.setText(g().getString(2131362284, new Object[] { str4 }));
      if (this.a)
      {
        this.i.setClickable(false);
        this.h.setClickable(false);
        this.h.setFocusable(false);
        this.k.setClickable(false);
        this.j.setClickable(false);
        this.j.setFocusable(false);
      }
      return localView;
      this.i.setText(null);
      break;
      label498: this.h.setText(this.e);
      break label156;
      label512: String str1 = CommonViewUtils.d(localUserInfo1.b);
      this.j.setText(str1);
      break label190;
      label534: str2 = CommonViewUtils.d(s().getString("recipient_full_name"));
      break label228;
      label551: EditText localEditText1 = this.k;
      if (str2 != null);
      while (true)
      {
        localEditText1.setText(str2);
        break;
        str2 = CommonViewUtils.d(localUserInfo2.b);
      }
      label585: localObject = localCardInfo.a.e();
    }
  }

  public void a(Bundle paramBundle)
  {
    if (this.a);
    label119: 
    while (true)
    {
      return;
      int i1 = paramBundle.getInt("card_front_id");
      this.f = paramBundle.getString("default_closing");
      if (i1 == this.g)
        continue;
      this.g = i1;
      if ((this.f != null) && (!this.f.trim().equals("")))
        this.i.setText(this.f + ",");
      while (true)
      {
        if (this.d != null)
          break label119;
        this.h.setText(this.e);
        break;
        this.i.setText(null);
      }
    }
  }

  public String d()
  {
    return "Card Inside";
  }

  public void onClick(View paramView)
  {
    String str1;
    String str2;
    String str3;
    String str4;
    if (paramView.getId() == 2131296638)
    {
      n().c("Clicked Save Card").a();
      str1 = this.h.getText().toString();
      str2 = this.k.getText().toString();
      str3 = this.i.getText().toString();
      if (str3.endsWith(","))
        str3 = str3.substring(0, -1 + str3.length());
      str4 = this.j.getText().toString();
      if (!Utils.a(str2))
        break label111;
      Toaster.a(g(), 2131362285);
    }
    while (true)
    {
      return;
      label111: if (Utils.a(str4))
      {
        Toaster.a(g(), 2131362286);
        continue;
      }
      if (Utils.a(str1))
      {
        Toaster.a(g(), 2131362287);
        continue;
      }
      p().a(str2, str1, str4, str3);
      if (this.b)
      {
        b(CommonViewUtils.c(null));
        continue;
      }
      b(CommonViewUtils.a(7));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.views.CustomCardView
 * JD-Core Version:    0.6.0
 */