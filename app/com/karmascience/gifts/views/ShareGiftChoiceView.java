package com.karmascience.gifts.views;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.facebook.widget.UrlImage;
import com.karmascience.gifts.AnalyticsWrapper;
import com.karmascience.gifts.AnalyticsWrapper.MetricsEvent;
import com.karmascience.gifts.content.model.CardFront;
import com.karmascience.gifts.controllers.OrderManager;
import com.karmascience.gifts.controllers.OrderManager.CardInfo;
import com.karmascience.gifts.controllers.OrderManager.UserInfo;
import com.karmascience.gifts.ui.IViewManager;

public class ShareGiftChoiceView extends KSViewController
  implements View.OnClickListener
{
  private CheckBox a;

  public ShareGiftChoiceView(Activity paramActivity, Handler paramHandler, IViewManager paramIViewManager, Bundle paramBundle, String paramString)
  {
    super(paramActivity, paramHandler, paramIViewManager, paramBundle, paramString);
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903549, paramViewGroup, false);
    localView.findViewById(2131297835).setOnClickListener(this);
    localView.findViewById(2131297831).setOnClickListener(this);
    TextView localTextView = (TextView)localView.findViewById(2131297837);
    OrderManager.UserInfo localUserInfo1 = p().e();
    OrderManager.UserInfo localUserInfo2 = p().d();
    Activity localActivity = g();
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = localUserInfo1.b;
    arrayOfObject[1] = localUserInfo2.b;
    localTextView.setText(localActivity.getString(2131362291, arrayOfObject));
    OrderManager.CardInfo localCardInfo = p().f();
    ImageView localImageView = (ImageView)localView.findViewById(2131297838);
    localImageView.setBackgroundDrawable(new ColorDrawable(localCardInfo.a.f()));
    localImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    ((TextView)localView.findViewById(2131297839)).setText(CommonViewUtils.d(localCardInfo.e));
    ((TextView)localView.findViewById(2131297582)).setText(CommonViewUtils.d(localCardInfo.d));
    UrlImage localUrlImage = (UrlImage)localView.findViewById(2131297836);
    localUrlImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localUrlImage.setImageParams(localUserInfo1.c);
    String str = CommonViewUtils.d(localUserInfo2.b);
    ((TextView)localView.findViewById(2131297547)).setText(g().getString(2131362294, new Object[] { str }));
    ((TextView)localView.findViewById(2131297834)).setText(g().getString(2131362295, new Object[] { str }));
    this.a = ((CheckBox)localView.findViewById(2131297832));
    this.a.setChecked(p().c());
    return localView;
  }

  public String d()
  {
    return "Timeline Privacy";
  }

  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131297835)
    {
      n().c("Clicked Review Order").a();
      p().a(this.a.isChecked());
      b(CommonViewUtils.a(9));
    }
    while (true)
    {
      return;
      if (i == 2131297831)
      {
        this.a.toggle();
        n().c("Clicked Timeline Option").a("post_on_timeline", Boolean.toString(this.a.isChecked())).a();
        continue;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.karmascience.gifts.views.ShareGiftChoiceView
 * JD-Core Version:    0.6.0
 */