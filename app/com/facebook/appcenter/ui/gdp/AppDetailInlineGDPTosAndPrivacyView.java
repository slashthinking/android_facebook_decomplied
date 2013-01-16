package com.facebook.appcenter.ui.gdp;

import android.content.Context;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import com.facebook.appcenter.graphql.model.AppDetail;
import com.facebook.appcenter.util.AppCenterInlineGDPHelper;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.CustomViewGroup;

public class AppDetailInlineGDPTosAndPrivacyView extends CustomViewGroup
{
  private AppCenterInlineGDPHelper a;
  private TextView b;

  public AppDetailInlineGDPTosAndPrivacyView(Context paramContext)
  {
    this(paramContext, null, 0);
  }

  public AppDetailInlineGDPTosAndPrivacyView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public AppDetailInlineGDPTosAndPrivacyView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2130903051);
    this.a = ((AppCenterInlineGDPHelper)getInjector().a(AppCenterInlineGDPHelper.class));
    this.b = ((TextView)getView(2131296380));
  }

  public void setAppDetailInfo(AppDetail paramAppDetail)
  {
    SpannableString localSpannableString = this.a.a(paramAppDetail.name, paramAppDetail.termsOfServiceUrl, paramAppDetail.privacyUrl);
    this.b.setText(localSpannableString);
    this.b.setMovementMethod(LinkMovementMethod.getInstance());
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.ui.gdp.AppDetailInlineGDPTosAndPrivacyView
 * JD-Core Version:    0.6.0
 */