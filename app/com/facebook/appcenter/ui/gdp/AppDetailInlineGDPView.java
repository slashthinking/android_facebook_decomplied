package com.facebook.appcenter.ui.gdp;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.appcenter.graphql.model.AppCenterPermissionSummary;
import com.facebook.appcenter.graphql.model.AppDetail;
import com.facebook.appcenter.util.AppCenterInlineGDPHelper;
import com.facebook.appcenter.util.SocialTextStringGenerator;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.CustomViewGroup;

public class AppDetailInlineGDPView extends CustomViewGroup
  implements AppDetailPrivacyPickerView.PrivacyPickerListener
{
  private TextView a;
  private TextView b;
  private TextView c;
  private AppDetailInlineGDPTosAndPrivacyView d;
  private AppDetailPrivacyPickerView e;
  private AppCenterInlineGDPHelper f;
  private SocialTextStringGenerator g;
  private LinearLayout h;
  private LinearLayout i;
  private int j;
  private AppCenterPermissionSummary k;

  public AppDetailInlineGDPView(Context paramContext)
  {
    this(paramContext, null, 0);
  }

  public AppDetailInlineGDPView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public AppDetailInlineGDPView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2130903050);
    this.a = ((TextView)getView(2131296374));
    this.b = ((TextView)getView(2131296376));
    this.c = ((TextView)getView(2131296377));
    this.e = ((AppDetailPrivacyPickerView)getView(2131296378));
    this.e.setListener(this);
    this.d = ((AppDetailInlineGDPTosAndPrivacyView)getView(2131296379));
    this.f = ((AppCenterInlineGDPHelper)getInjector().a(AppCenterInlineGDPHelper.class));
    this.g = ((SocialTextStringGenerator)getInjector().a(SocialTextStringGenerator.class));
    this.h = ((LinearLayout)getView(2131296373));
    this.i = ((LinearLayout)getView(2131296375));
    this.i.setVisibility(8);
    this.h.setOnClickListener(new AppDetailInlineGDPView.1(this));
  }

  private void a()
  {
    this.a.setText(b());
    this.b.setText(this.f.b(this.k, this.j));
    this.c.setText(this.f.a(this.k));
    this.e.setSelectedIndex(this.j);
  }

  private SpannableStringBuilder b()
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append(this.f.c(this.k, this.j));
    localSpannableStringBuilder.append(' ');
    localSpannableStringBuilder.append(this.g.a());
    return localSpannableStringBuilder;
  }

  public void a(int paramInt)
  {
    this.j = paramInt;
    a();
  }

  public int getSelectedPrivacyOptionIndex()
  {
    return this.j;
  }

  public void setAppDetailInfo(AppDetail paramAppDetail)
  {
    if (this.f.a(paramAppDetail.isFacebookApp, paramAppDetail.viewerHasAuthorized, paramAppDetail.appCenterPermissionSummary))
      setVisibility(0);
    while (true)
    {
      this.j = this.f.a(paramAppDetail.activitySuggestedPrivacy);
      this.k = paramAppDetail.appCenterPermissionSummary;
      this.d.setAppDetailInfo(paramAppDetail);
      a();
      return;
      setVisibility(8);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.appcenter.ui.gdp.AppDetailInlineGDPView
 * JD-Core Version:    0.6.0
 */