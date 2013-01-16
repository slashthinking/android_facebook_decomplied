package com.karmascience.gifts.views;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.karmascience.gifts.AnalyticsWrapper;
import com.karmascience.gifts.AnalyticsWrapper.MetricsEvent;
import com.karmascience.gifts.controllers.OrderManager;
import com.karmascience.gifts.controllers.OrderManager.UserInfo;
import com.karmascience.gifts.ui.IViewManager;

public class OrderConfirmationView extends KSViewController
  implements View.OnClickListener
{
  private static final String a = OrderConfirmationView.class.getName();
  private final String b;
  private final String c;

  public OrderConfirmationView(Activity paramActivity, Handler paramHandler, IViewManager paramIViewManager, Bundle paramBundle, String paramString)
  {
    super(paramActivity, paramHandler, paramIViewManager, paramBundle, paramString);
    OrderManager.UserInfo localUserInfo = p().d();
    this.b = CommonViewUtils.d(localUserInfo.b);
    this.c = localUserInfo.a;
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903442, paramViewGroup, false);
    TextView localTextView1 = (TextView)localView.findViewById(2131297547);
    Resources localResources1 = g().getResources();
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = this.b;
    localTextView1.setText(localResources1.getString(2131362277, arrayOfObject1));
    TextView localTextView2 = (TextView)localView.findViewById(2131297548);
    Resources localResources2 = g().getResources();
    Object[] arrayOfObject2 = new Object[1];
    arrayOfObject2[0] = this.b;
    localTextView2.setText(localResources2.getString(2131362278, arrayOfObject2));
    Button localButton = (Button)localView.findViewById(2131297550);
    Resources localResources3 = g().getResources();
    Object[] arrayOfObject3 = new Object[1];
    arrayOfObject3[0] = this.b;
    localButton.setText(localResources3.getString(2131362280, arrayOfObject3));
    localButton.setOnClickListener(this);
    localView.findViewById(2131297549).setOnClickListener(this);
    return localView;
  }

  public String d()
  {
    return "Order Confirmation";
  }

  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131297549)
    {
      b(CommonViewUtils.a(p().g(), false));
      n().c("Goto Pay Now").a("order_id", p().g()).a();
    }
    while (true)
    {
      return;
      if (paramView.getId() == 2131297550)
      {
        n().c("Goto Timeline").a("order_id", p().g()).a();
        b(CommonViewUtils.a(this.c));
        continue;
      }
    }
  }

  public boolean v()
  {
    g().finish();
    return true;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.views.OrderConfirmationView
 * JD-Core Version:    0.6.0
 */