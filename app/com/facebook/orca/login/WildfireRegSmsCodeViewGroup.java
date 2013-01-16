package com.facebook.orca.login;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.orca.common.ui.widgets.text.CustomUrlLikeSpan;
import com.facebook.orca.common.util.StyledStringBuilder;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.ops.DialogBasedProgressIndicator;
import com.facebook.orca.ops.OperationProgressIndicator;

public class WildfireRegSmsCodeViewGroup extends AuthFragmentViewGroup<WildfireRegSmsCodeFragmentControl>
  implements WildfireRegSmsCodeFragment.ViewControl
{
  public static final String LOGO1_RESOURCE = "orca:authparam:logo1";
  public static final String LOGO2_RESOURCE = "orca:authparam:logo2";
  private final InputMethodManager mInputMethodManager = (InputMethodManager)getInjector().a(InputMethodManager.class);
  private final Button mNextButton;
  private final OperationProgressIndicator mProgressIndicator;
  private final Drawable mSmsCodeErrorIcon;
  private final TextView mSmsCodePrompt;
  private final EditText mSmsCodeText;
  private final Button mTryAgainButton;

  public WildfireRegSmsCodeViewGroup(Context paramContext, WildfireRegSmsCodeFragmentControl paramWildfireRegSmsCodeFragmentControl)
  {
    super(paramContext, paramWildfireRegSmsCodeFragmentControl);
    setContentView(2130903440);
    this.mSmsCodePrompt = ((TextView)getView(2131297540));
    this.mSmsCodeText = ((EditText)getView(2131297541));
    this.mSmsCodeErrorIcon = getResources().getDrawable(2130838618);
    this.mTryAgainButton = ((Button)getView(2131297542));
    this.mNextButton = ((Button)getView(2131297536));
    this.mProgressIndicator = new DialogBasedProgressIndicator(getContext(), 2131362361);
    this.mTryAgainButton.setOnClickListener(new WildfireRegSmsCodeViewGroup.1(this));
    this.mNextButton.setOnClickListener(new WildfireRegSmsCodeViewGroup.2(this));
    this.mSmsCodeText.setOnEditorActionListener(new WildfireRegSmsCodeViewGroup.3(this));
    ImageView localImageView1 = (ImageView)getView(2131297531);
    ImageView localImageView2 = (ImageView)getView(2131297532);
    int i = getResource("orca:authparam:logo1", 0);
    int j = getResource("orca:authparam:logo2", 0);
    if (i != 0)
      localImageView1.setImageResource(i);
    if (j != 0)
      localImageView2.setImageResource(j);
  }

  public static Bundle createParameterBundle(int paramInt1, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("orca:authparam:logo1", paramInt1);
    localBundle.putInt("orca:authparam:logo2", paramInt2);
    return localBundle;
  }

  private Rect getDrawableBoundsForEditText(EditText paramEditText, Drawable paramDrawable)
  {
    return new Rect(0, 0, paramEditText.getHeight() - paramEditText.getPaddingTop() - paramEditText.getPaddingBottom(), paramEditText.getHeight() - paramEditText.getPaddingTop() - paramEditText.getPaddingBottom());
  }

  private void onNextClick()
  {
    String str = this.mSmsCodeText.getText().toString();
    if (str.length() <= 0);
    while (true)
    {
      return;
      this.mInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
      ((WildfireRegSmsCodeFragmentControl)this.control).a(str);
    }
  }

  private void onTryAgainClick()
  {
    this.mInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
    ((WildfireRegSmsCodeFragmentControl)this.control).a(new DialogBasedProgressIndicator(getContext(), 2131362368));
  }

  public void beginShowingProgress()
  {
    this.mProgressIndicator.a();
  }

  public void hideSmsCodeError()
  {
    this.mSmsCodeText.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
  }

  public void setSmsCodePrompt(String paramString)
  {
    CustomUrlLikeSpan localCustomUrlLikeSpan = new CustomUrlLikeSpan();
    localCustomUrlLikeSpan.a(new WildfireRegSmsCodeViewGroup.4(this));
    Resources localResources = getResources();
    StyledStringBuilder localStyledStringBuilder = new StyledStringBuilder(localResources);
    localStyledStringBuilder.a(paramString);
    localStyledStringBuilder.a("[[edit_phone_link]]", localResources.getString(2131362375), localCustomUrlLikeSpan, 33);
    this.mSmsCodePrompt.setText(localStyledStringBuilder.b());
    this.mSmsCodePrompt.setMovementMethod(LinkMovementMethod.getInstance());
  }

  public void setSmsCodePromptResource(int paramInt)
  {
    setSmsCodePrompt(getResources().getString(paramInt));
  }

  public void showSmsCodeError()
  {
    this.mSmsCodeErrorIcon.setBounds(getDrawableBoundsForEditText(this.mSmsCodeText, this.mSmsCodeErrorIcon));
    this.mSmsCodeText.setCompoundDrawables(null, null, this.mSmsCodeErrorIcon, null);
  }

  public void stopShowingProgress()
  {
    this.mProgressIndicator.b();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.login.WildfireRegSmsCodeViewGroup
 * JD-Core Version:    0.6.0
 */