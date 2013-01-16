package com.facebook.orca.login;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.orca.auth.PasswordCredentials;
import com.facebook.orca.common.ui.widgets.text.CustomUrlLikeSpan;
import com.facebook.orca.common.util.StyledStringBuilder;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.locale.FBLocaleMapper;
import com.facebook.orca.ops.DialogBasedProgressIndicator;
import com.facebook.widget.UrlImage;
import java.util.Locale;

public class GenericPasswordCredentialsViewGroup extends AuthFragmentViewGroup<PasswordCredentialsFragmentControl>
  implements PasswordCredentialsFragment.ViewControl
{
  public static final String LAYOUT_RESOURCE = "orca:authparam:login_screen_layout";
  public static final String LOGO1_RESOURCE = "orca:authparam:logo1";
  public static final String LOGO2_RESOURCE = "orca:authparam:logo2";
  private final TextView emailText;
  private final InputMethodManager inputMethodManager = (InputMethodManager)getInjector().a(InputMethodManager.class);
  private final Button loginButton;
  private final ImageView logo1;
  private final ImageView logo2;
  private final TextView notYouLink;
  private final TextView passwordText;
  private final Button signupButton;
  private final View userDisplay;
  private final TextView userName;
  private final UrlImage userPhoto;

  public GenericPasswordCredentialsViewGroup(Context paramContext, PasswordCredentialsFragmentControl paramPasswordCredentialsFragmentControl)
  {
    super(paramContext, paramPasswordCredentialsFragmentControl);
    setContentView(getResource("orca:authparam:login_screen_layout", 2130903359));
    this.userDisplay = getView(2131297320);
    this.userPhoto = ((UrlImage)getView(2131297321));
    this.userName = ((TextView)getView(2131297322));
    this.notYouLink = ((TextView)getView(2131297323));
    this.emailText = ((TextView)getView(2131297324));
    this.passwordText = ((TextView)getView(2131297325));
    this.loginButton = ((Button)getView(2131297326));
    this.signupButton = ((Button)getView(2131297327));
    this.logo1 = ((ImageView)getView(2131297318));
    this.logo2 = ((ImageView)getView(2131297319));
    CustomUrlLikeSpan localCustomUrlLikeSpan = new CustomUrlLikeSpan();
    Resources localResources = getResources();
    StyledStringBuilder localStyledStringBuilder = new StyledStringBuilder(localResources);
    localStyledStringBuilder.a(localCustomUrlLikeSpan, 33);
    localStyledStringBuilder.a(localResources.getString(2131362219));
    localStyledStringBuilder.a();
    this.notYouLink.setText(localStyledStringBuilder.b());
    this.notYouLink.setSaveEnabled(false);
    this.notYouLink.setOnClickListener(new GenericPasswordCredentialsViewGroup.1(this));
    this.loginButton.setOnClickListener(new GenericPasswordCredentialsViewGroup.2(this));
    this.signupButton.setOnClickListener(new GenericPasswordCredentialsViewGroup.3(this));
    this.passwordText.setOnEditorActionListener(new GenericPasswordCredentialsViewGroup.4(this));
    this.passwordText.setTypeface(Typeface.DEFAULT);
    int i = getResource("orca:authparam:logo1", 0);
    int j = getResource("orca:authparam:logo2", 0);
    if (i != 0)
      this.logo1.setImageResource(i);
    if (j != 0)
      this.logo2.setImageResource(j);
  }

  private void clearUser()
  {
    ((PasswordCredentialsFragmentControl)this.control).N();
    this.emailText.setText("");
    this.userDisplay.setVisibility(8);
    this.emailText.setVisibility(0);
  }

  public static Bundle createParameterBundle(int paramInt1, int paramInt2, int paramInt3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("orca:authparam:login_screen_layout", paramInt1);
    localBundle.putInt("orca:authparam:logo1", paramInt2);
    localBundle.putInt("orca:authparam:logo2", paramInt3);
    return localBundle;
  }

  private void onLoginClick()
  {
    String str1 = this.emailText.getText().toString();
    if (str1.length() <= 0);
    while (true)
    {
      return;
      String str2 = this.passwordText.getText().toString();
      if (str2.length() > 0)
      {
        this.inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        ((PasswordCredentialsFragmentControl)this.control).a(new PasswordCredentials(str1, str2), new DialogBasedProgressIndicator(getContext(), 2131362217));
      }
    }
  }

  protected void onSignupClick()
  {
    Uri.Builder localBuilder = Uri.parse("https://m.facebook.com/r.php").buildUpon();
    localBuilder.appendQueryParameter("locale", FBLocaleMapper.a(Locale.getDefault()));
    ((PasswordCredentialsFragmentControl)this.control).c(new Intent("android.intent.action.VIEW", localBuilder.build()));
  }

  protected void setSignupButtonText(int paramInt)
  {
    this.signupButton.setText(paramInt);
  }

  public void setUser(String paramString1, String paramString2, String paramString3)
  {
    this.emailText.setText(paramString1);
    this.userName.setText(paramString2);
    this.userPhoto.setImageParams(Uri.parse(paramString3));
    this.emailText.setVisibility(8);
    this.userDisplay.setVisibility(0);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.login.GenericPasswordCredentialsViewGroup
 * JD-Core Version:    0.6.2
 */