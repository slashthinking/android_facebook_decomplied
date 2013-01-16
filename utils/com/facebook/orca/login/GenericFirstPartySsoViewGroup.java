package com.facebook.orca.login;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.orca.auth.FirstPartySsoSessionInfo;
import com.facebook.orca.common.ui.widgets.text.CustomUrlLikeSpan;
import com.facebook.orca.common.util.StyledStringBuilder;
import com.facebook.orca.ops.DialogBasedProgressIndicator;

public class GenericFirstPartySsoViewGroup extends AuthFragmentViewGroup<FirstPartySsoFragmentControl>
  implements FirstPartySsoFragment.ViewControl
{
  public static final String LAYOUT_RESOURCE = "orca:authparam:sso_layout";
  public static final String LOGO1_RESOURCE = "orca:authparam:logo1";
  public static final String LOGO2_RESOURCE = "orca:authparam:logo2";
  private final Button loginButton;
  private final TextView loginText;
  private final ImageView logo1;
  private final ImageView logo2;

  public GenericFirstPartySsoViewGroup(Context paramContext, FirstPartySsoFragmentControl paramFirstPartySsoFragmentControl)
  {
    super(paramContext, paramFirstPartySsoFragmentControl);
    setContentView(getResource("orca:authparam:sso_layout", 2130903362));
    this.loginButton = ((Button)getView(2131297326));
    this.loginText = ((TextView)getView(2131297329));
    this.logo1 = ((ImageView)getView(2131297318));
    this.logo2 = ((ImageView)getView(2131297319));
    this.loginText.setMovementMethod(LinkMovementMethod.getInstance());
    this.loginButton.setOnClickListener(new GenericFirstPartySsoViewGroup.1(this));
    int i = getResource("orca:authparam:logo1", 0);
    int j = getResource("orca:authparam:logo2", 0);
    if (i != 0)
      this.logo1.setImageResource(i);
    if (j != 0)
      this.logo2.setImageResource(j);
  }

  public static Bundle createParameterBundle(int paramInt1, int paramInt2, int paramInt3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("orca:authparam:sso_layout", paramInt1);
    localBundle.putInt("orca:authparam:logo1", paramInt2);
    localBundle.putInt("orca:authparam:logo2", paramInt3);
    return localBundle;
  }

  private void onLoginClicked()
  {
    ((FirstPartySsoFragmentControl)this.control).a(new DialogBasedProgressIndicator(getContext(), 2131362217));
  }

  private void onNotYouClicked()
  {
    ((FirstPartySsoFragmentControl)this.control).N();
  }

  public void setSsoSessionInfo(FirstPartySsoSessionInfo paramFirstPartySsoSessionInfo)
  {
    String str = paramFirstPartySsoSessionInfo.a().replace(' ', ' ');
    Resources localResources = getResources();
    StyledStringBuilder localStyledStringBuilder1 = new StyledStringBuilder(localResources);
    localStyledStringBuilder1.a(localResources.getString(2131362218));
    localStyledStringBuilder1.a("[[name]]", str, null, 33);
    this.loginButton.setText(localStyledStringBuilder1.b());
    CustomUrlLikeSpan localCustomUrlLikeSpan = new CustomUrlLikeSpan();
    localCustomUrlLikeSpan.a(new GenericFirstPartySsoViewGroup.2(this));
    StyledStringBuilder localStyledStringBuilder2 = new StyledStringBuilder(localResources);
    localStyledStringBuilder2.a(localCustomUrlLikeSpan, 33);
    localStyledStringBuilder2.a(localResources.getString(2131362219));
    localStyledStringBuilder2.a();
    this.loginText.setText(localStyledStringBuilder2.b());
    this.loginText.setSaveEnabled(false);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.login.GenericFirstPartySsoViewGroup
 * JD-Core Version:    0.6.2
 */