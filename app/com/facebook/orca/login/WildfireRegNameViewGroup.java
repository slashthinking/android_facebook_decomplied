package com.facebook.orca.login;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.orca.common.names.LanguageNameFormats;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.ops.DialogBasedProgressIndicator;
import com.facebook.orca.ops.OperationProgressIndicator;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import java.util.Locale;
import javax.inject.Provider;

public class WildfireRegNameViewGroup extends AuthFragmentViewGroup<WildfireRegNameFragmentControl>
  implements WildfireRegNameFragment.ViewControl
{
  public static final String LOGO1_RESOURCE = "orca:authparam:logo1";
  public static final String LOGO2_RESOURCE = "orca:authparam:logo2";
  private static final Class<?> TAG = WildfireRegNameViewGroup.class;
  private final Drawable mFirstNameErrorIcon;
  private final EditText mFirstNameText;
  private final InputMethodManager mInputMethodManager;
  private final Drawable mLastNameErrorIcon;
  private final EditText mLastNameText;
  private final Provider<Locale> mLocaleProvider;
  private final ViewGroup mNameContainer;
  private final TextView mNamePrompt;
  private final Button mNextButton;
  private final OperationProgressIndicator mProgressIndicator;

  public WildfireRegNameViewGroup(Context paramContext, WildfireRegNameFragmentControl paramWildfireRegNameFragmentControl)
  {
    super(paramContext, paramWildfireRegNameFragmentControl);
    FbInjector localFbInjector = getInjector();
    this.mInputMethodManager = ((InputMethodManager)localFbInjector.a(InputMethodManager.class));
    this.mLocaleProvider = localFbInjector.b(Locale.class);
    setContentView(2130903438);
    this.mNameContainer = ((ViewGroup)getView(2131297530));
    this.mNamePrompt = ((TextView)getView(2131297533));
    this.mFirstNameText = ((EditText)getView(2131297534));
    this.mFirstNameErrorIcon = getResources().getDrawable(2130838618);
    this.mLastNameText = ((EditText)getView(2131297535));
    this.mLastNameErrorIcon = getResources().getDrawable(2130838618);
    updateNameViewOrder();
    this.mNextButton = ((Button)getView(2131297536));
    this.mProgressIndicator = new DialogBasedProgressIndicator(getContext(), 2131362361);
    this.mNextButton.setOnClickListener(new WildfireRegNameViewGroup.1(this));
    this.mLastNameText.setOnEditorActionListener(new WildfireRegNameViewGroup.2(this));
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
    String str1 = this.mFirstNameText.getText().toString();
    if (str1.length() <= 0);
    while (true)
    {
      return;
      String str2 = this.mLastNameText.getText().toString();
      if (str2.length() <= 0)
        continue;
      this.mInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
      ((WildfireRegNameFragmentControl)this.control).a(str1, str2);
    }
  }

  private void updateNameViewOrder()
  {
    boolean bool1 = true;
    int i = this.mNameContainer.indexOfChild(this.mFirstNameText);
    int j = this.mNameContainer.indexOfChild(this.mLastNameText);
    boolean bool2;
    boolean bool3;
    label47: label57: Locale localLocale;
    if (i != -1)
    {
      bool2 = bool1;
      Preconditions.checkState(bool2);
      if (j == -1)
        break label104;
      bool3 = bool1;
      Preconditions.checkState(bool3);
      if (i >= j)
        break label110;
      Preconditions.checkState(bool1);
      localLocale = (Locale)this.mLocaleProvider.b();
      if (LanguageNameFormats.a.contains(localLocale.getLanguage()))
        break label115;
      BLog.b(TAG, "Not reordering children, already matches default.");
    }
    while (true)
    {
      return;
      bool2 = false;
      break;
      label104: bool3 = false;
      break label47;
      label110: bool1 = false;
      break label57;
      label115: BLog.b(TAG, "Swapping first and last name to match locale: " + localLocale);
      this.mNameContainer.removeView(this.mFirstNameText);
      this.mNameContainer.removeView(this.mLastNameText);
      this.mNameContainer.addView(this.mLastNameText, i);
      this.mNameContainer.addView(this.mFirstNameText, j);
    }
  }

  public void beginShowingProgress()
  {
    this.mProgressIndicator.a();
  }

  public void hideFirstNameError()
  {
    this.mFirstNameText.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
  }

  public void hideLastNameError()
  {
    this.mLastNameText.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
  }

  public void setNamePrompt(String paramString)
  {
    this.mNamePrompt.setText(paramString);
  }

  public void setNamePromptResource(int paramInt)
  {
    this.mNamePrompt.setText(paramInt);
  }

  public void showFirstNameError()
  {
    this.mFirstNameErrorIcon.setBounds(getDrawableBoundsForEditText(this.mFirstNameText, this.mFirstNameErrorIcon));
    this.mFirstNameText.setCompoundDrawables(null, null, this.mFirstNameErrorIcon, null);
  }

  public void showLastNameError()
  {
    this.mLastNameErrorIcon.setBounds(getDrawableBoundsForEditText(this.mLastNameText, this.mLastNameErrorIcon));
    this.mLastNameText.setCompoundDrawables(null, null, this.mLastNameErrorIcon, null);
  }

  public void stopShowingProgress()
  {
    this.mProgressIndicator.b();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.login.WildfireRegNameViewGroup
 * JD-Core Version:    0.6.0
 */