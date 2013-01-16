package com.facebook.orca.login;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android_src.telephony.PhoneNumberFormattingTextWatcher;
import com.facebook.orca.common.ui.widgets.text.CustomUrlLikeSpan;
import com.facebook.orca.common.util.StyledStringBuilder;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.ops.DialogBasedProgressIndicator;
import com.facebook.orca.ops.OperationProgressIndicator;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import java.util.Arrays;
import java.util.Locale;

public class WildfireRegPhoneNumberViewGroup extends AuthFragmentViewGroup<WildfireRegPhoneNumberFragmentControl>
  implements WildfireRegPhoneNumberFragment.ViewControl
{
  public static final String LOGO1_RESOURCE = "orca:authparam:logo1";
  public static final String LOGO2_RESOURCE = "orca:authparam:logo2";
  private final TextView mCountryCode;
  private ArrayAdapter<WildfireRegPhoneNumberViewGroup.CountryCode> mCountryCodeListAdapter;
  private final InputMethodManager mInputMethodManager;
  private final Button mNextButton;
  private PhoneNumberFormattingTextWatcher mPhoneNumberFormattingTextWatcher;
  private final EditText mPhoneNumberText;
  private final PhoneNumberUtil mPhoneNumberUtil;
  private final OperationProgressIndicator mProgressIndicator;
  private WildfireRegPhoneNumberViewGroup.CountryCode mSelectedCountryCode;
  private int mSelectedCountryCodeIndex;
  private int mUnconfirmedSelectedCountryCodeIndex;

  public WildfireRegPhoneNumberViewGroup(Context paramContext, WildfireRegPhoneNumberFragmentControl paramWildfireRegPhoneNumberFragmentControl)
  {
    super(paramContext, paramWildfireRegPhoneNumberFragmentControl);
    FbInjector localFbInjector = getInjector();
    this.mPhoneNumberUtil = ((PhoneNumberUtil)localFbInjector.a(PhoneNumberUtil.class));
    this.mInputMethodManager = ((InputMethodManager)localFbInjector.a(InputMethodManager.class));
    setContentView(2130903439);
    this.mCountryCode = ((TextView)getView(2131297538));
    this.mPhoneNumberText = ((EditText)getView(2131297539));
    this.mNextButton = ((Button)getView(2131297536));
    this.mProgressIndicator = new DialogBasedProgressIndicator(getContext(), 2131362368);
    this.mCountryCode.setMovementMethod(LinkMovementMethod.getInstance());
    this.mCountryCode.setOnClickListener(new WildfireRegPhoneNumberViewGroup.1(this));
    this.mNextButton.setOnClickListener(new WildfireRegPhoneNumberViewGroup.2(this));
    this.mPhoneNumberText.setOnEditorActionListener(new WildfireRegPhoneNumberViewGroup.3(this));
    String str = Locale.getDefault().getLanguage();
    String[] arrayOfString = Locale.getISOCountries();
    WildfireRegPhoneNumberViewGroup.CountryCode[] arrayOfCountryCode = new WildfireRegPhoneNumberViewGroup.CountryCode[arrayOfString.length];
    for (int i = 0; i < arrayOfString.length; i++)
      arrayOfCountryCode[i] = new WildfireRegPhoneNumberViewGroup.CountryCode(this, arrayOfString[i], "+" + this.mPhoneNumberUtil.getCountryCodeForRegion(arrayOfString[i]), new Locale(str, arrayOfString[i]).getDisplayCountry());
    Arrays.sort(arrayOfCountryCode);
    this.mCountryCodeListAdapter = new ArrayAdapter(getContext(), 2130903553, arrayOfCountryCode);
    ImageView localImageView1 = (ImageView)getView(2131297531);
    ImageView localImageView2 = (ImageView)getView(2131297532);
    int j = getResource("orca:authparam:logo1", 0);
    int k = getResource("orca:authparam:logo2", 0);
    if (j != 0)
      localImageView1.setImageResource(j);
    if (k != 0)
      localImageView2.setImageResource(k);
  }

  public static Bundle createParameterBundle(int paramInt1, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("orca:authparam:logo1", paramInt1);
    localBundle.putInt("orca:authparam:logo2", paramInt2);
    return localBundle;
  }

  private void onCountryCodeChangeClick()
  {
    WildfireRegPhoneNumberViewGroup.4 local4 = new WildfireRegPhoneNumberViewGroup.4(this);
    new AlertDialog.Builder(getContext()).setTitle(2131362364).setSingleChoiceItems(this.mCountryCodeListAdapter, this.mSelectedCountryCodeIndex, local4).setPositiveButton(2131362167, local4).setNegativeButton(2131362168, local4).show();
  }

  private void onCountryCodeChanged(WildfireRegPhoneNumberViewGroup.CountryCode paramCountryCode)
  {
    this.mSelectedCountryCode = paramCountryCode;
    ((WildfireRegPhoneNumberFragmentControl)this.control).a(paramCountryCode.a);
    int i;
    if (this.mPhoneNumberFormattingTextWatcher != null)
    {
      i = 1;
      this.mPhoneNumberText.removeTextChangedListener(this.mPhoneNumberFormattingTextWatcher);
    }
    while (true)
    {
      this.mPhoneNumberFormattingTextWatcher = new PhoneNumberFormattingTextWatcher(paramCountryCode.a);
      this.mPhoneNumberText.addTextChangedListener(this.mPhoneNumberFormattingTextWatcher);
      if (i != 0)
        this.mPhoneNumberText.setTextKeepState(this.mPhoneNumberText.getText());
      Resources localResources = getResources();
      StyledStringBuilder localStyledStringBuilder = new StyledStringBuilder(localResources);
      localStyledStringBuilder.a(2131362362);
      localStyledStringBuilder.a("[[code]]", paramCountryCode.b, null, 33);
      localStyledStringBuilder.a("[[name]]", paramCountryCode.c, null, 33);
      CustomUrlLikeSpan localCustomUrlLikeSpan = new CustomUrlLikeSpan();
      localStyledStringBuilder.a("[[change_link]]", localResources.getString(2131362363), localCustomUrlLikeSpan, 33);
      this.mCountryCode.setText(localStyledStringBuilder.b());
      return;
      i = 0;
    }
  }

  private void onNextClick()
  {
    String str = this.mPhoneNumberText.getText().toString();
    if (str.length() <= 0);
    while (true)
    {
      return;
      this.mInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
      ((WildfireRegPhoneNumberFragmentControl)this.control).b(str, this.mSelectedCountryCode.a);
    }
  }

  public void beginShowingProgress()
  {
    this.mProgressIndicator.a();
  }

  public void setCountryCode(String paramString)
  {
    for (int i = 0; i < this.mCountryCodeListAdapter.getCount(); i++)
    {
      WildfireRegPhoneNumberViewGroup.CountryCode localCountryCode = (WildfireRegPhoneNumberViewGroup.CountryCode)this.mCountryCodeListAdapter.getItem(i);
      if (!paramString.equalsIgnoreCase(localCountryCode.a))
        continue;
      this.mSelectedCountryCodeIndex = i;
      onCountryCodeChanged(localCountryCode);
    }
  }

  public void stopShowingProgress()
  {
    this.mProgressIndicator.b();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.login.WildfireRegPhoneNumberViewGroup
 * JD-Core Version:    0.6.0
 */