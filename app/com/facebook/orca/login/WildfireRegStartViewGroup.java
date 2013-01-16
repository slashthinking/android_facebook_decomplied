package com.facebook.orca.login;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.orca.common.ui.widgets.text.CustomUrlLikeSpan;
import com.facebook.orca.common.util.StyledStringBuilder;
import com.facebook.orca.ops.DialogBasedProgressIndicator;
import com.facebook.orca.ops.OperationProgressIndicator;

public class WildfireRegStartViewGroup extends AuthFragmentViewGroup<WildfireRegStartFragmentControl>
  implements WildfireRegStartFragment.ViewControl
{
  public static final String LOGO1_RESOURCE = "orca:authparam:logo1";
  public static final String LOGO2_RESOURCE = "orca:authparam:logo2";
  private final Button mLoginButton;
  private final OperationProgressIndicator mProgressIndicator;
  private final Button mStartButton;
  private final TextView mTos;

  public WildfireRegStartViewGroup(Context paramContext, WildfireRegStartFragmentControl paramWildfireRegStartFragmentControl)
  {
    super(paramContext, paramWildfireRegStartFragmentControl);
    setContentView(2130903441);
    this.mStartButton = ((Button)getView(2131297545));
    this.mStartButton.setOnClickListener(new WildfireRegStartViewGroup.1(this));
    this.mTos = ((TextView)getView(2131297546));
    this.mLoginButton = ((Button)getView(2131297326));
    this.mLoginButton.setOnClickListener(new WildfireRegStartViewGroup.2(this));
    this.mProgressIndicator = new DialogBasedProgressIndicator(getContext(), 2131362347);
    ImageView localImageView1 = (ImageView)getView(2131297543);
    ImageView localImageView2 = (ImageView)getView(2131297544);
    int i = getResource("orca:authparam:logo1", 0);
    int j = getResource("orca:authparam:logo2", 0);
    if (i != 0)
      localImageView1.setImageResource(i);
    if (j != 0)
      localImageView2.setImageResource(j);
    Resources localResources = getResources();
    CustomUrlLikeSpan localCustomUrlLikeSpan1 = new CustomUrlLikeSpan();
    localCustomUrlLikeSpan1.a(new WildfireRegStartViewGroup.3(this));
    CustomUrlLikeSpan localCustomUrlLikeSpan2 = new CustomUrlLikeSpan();
    localCustomUrlLikeSpan2.a(new WildfireRegStartViewGroup.4(this));
    CustomUrlLikeSpan localCustomUrlLikeSpan3 = new CustomUrlLikeSpan();
    localCustomUrlLikeSpan3.a(new WildfireRegStartViewGroup.5(this));
    CustomUrlLikeSpan localCustomUrlLikeSpan4 = new CustomUrlLikeSpan();
    localCustomUrlLikeSpan4.a(new WildfireRegStartViewGroup.6(this));
    StyledStringBuilder localStyledStringBuilder = new StyledStringBuilder(localResources);
    localStyledStringBuilder.a(localResources.getString(2131362349));
    localStyledStringBuilder.a("[[start]]", localResources.getString(2131362348), null, 33);
    localStyledStringBuilder.a("[[terms]]", localResources.getString(2131362350), localCustomUrlLikeSpan1, 33);
    localStyledStringBuilder.a("[[data_use_policy]]", localResources.getString(2131362351), localCustomUrlLikeSpan2, 33);
    localStyledStringBuilder.a("[[about_cookie_use]]", localResources.getString(2131362352), localCustomUrlLikeSpan3, 33);
    localStyledStringBuilder.a("[[learn_more]]", localResources.getString(2131362353), localCustomUrlLikeSpan4, 33);
    this.mTos.setText(localStyledStringBuilder.b());
    this.mTos.setMovementMethod(LinkMovementMethod.getInstance());
    this.mTos.setSaveEnabled(false);
  }

  public static Bundle createParameterBundle(int paramInt1, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("orca:authparam:logo1", paramInt1);
    localBundle.putInt("orca:authparam:logo2", paramInt2);
    return localBundle;
  }

  private void onCookiesClicked()
  {
    ((WildfireRegStartFragmentControl)this.control).R();
  }

  private void onDupClicked()
  {
    ((WildfireRegStartFragmentControl)this.control).P();
  }

  private void onLearnMoreClicked()
  {
    ((WildfireRegStartFragmentControl)this.control).S();
  }

  private void onLoginClicked()
  {
    ((WildfireRegStartFragmentControl)this.control).a(true);
  }

  private void onStartClicked()
  {
    ((WildfireRegStartFragmentControl)this.control).N();
  }

  private void onTermsClicked()
  {
    ((WildfireRegStartFragmentControl)this.control).O();
  }

  public void beginShowingProgress()
  {
    setVisibility(4);
    this.mProgressIndicator.a();
  }

  public void stopShowingProgress()
  {
    setVisibility(0);
    this.mProgressIndicator.b();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.login.WildfireRegStartViewGroup
 * JD-Core Version:    0.6.0
 */