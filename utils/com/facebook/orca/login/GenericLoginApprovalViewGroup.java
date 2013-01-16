package com.facebook.orca.login;

import android.content.Context;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.ops.DialogBasedProgressIndicator;

public class GenericLoginApprovalViewGroup extends AuthFragmentViewGroup<LoginApprovalFragmentControl>
{
  public static final String LAYOUT_RESOURCE = "orca:authparam:login_approval_layout";
  private final InputMethodManager inputMethodManager = (InputMethodManager)getInjector().a(InputMethodManager.class);
  private final Button loginButton;
  private final TextView passwordText;

  public GenericLoginApprovalViewGroup(Context paramContext, LoginApprovalFragmentControl paramLoginApprovalFragmentControl)
  {
    super(paramContext, paramLoginApprovalFragmentControl);
    setContentView(getResource("orca:authparam:login_approval_layout", 2130903360));
    this.passwordText = ((TextView)getView(2131297325));
    this.loginButton = ((Button)getView(2131297326));
    this.loginButton.setOnClickListener(new GenericLoginApprovalViewGroup.1(this));
    this.passwordText.setOnEditorActionListener(new GenericLoginApprovalViewGroup.2(this));
  }

  public static Bundle createParameterBundle(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("orca:authparam:login_approval_layout", paramInt);
    return localBundle;
  }

  private void onLoginClick()
  {
    String str = this.passwordText.getText().toString();
    if (str.length() <= 0);
    while (true)
    {
      return;
      this.inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
      ((LoginApprovalFragmentControl)this.control).a(str, new DialogBasedProgressIndicator(getContext(), 2131362217));
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.login.GenericLoginApprovalViewGroup
 * JD-Core Version:    0.6.2
 */