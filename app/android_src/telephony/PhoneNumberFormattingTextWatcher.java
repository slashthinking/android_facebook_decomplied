package android_src.telephony;

import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import com.google.i18n.phonenumbers.AsYouTypeFormatter;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import java.util.Locale;

public class PhoneNumberFormattingTextWatcher
  implements TextWatcher
{
  private boolean a = false;
  private boolean b;
  private AsYouTypeFormatter c;

  public PhoneNumberFormattingTextWatcher()
  {
    this(Locale.getDefault().getCountry());
  }

  public PhoneNumberFormattingTextWatcher(String paramString)
  {
    if (paramString == null)
      throw new IllegalArgumentException();
    this.c = PhoneNumberUtil.getInstance().getAsYouTypeFormatter(paramString);
  }

  private String a(char paramChar, boolean paramBoolean)
  {
    if (paramBoolean);
    for (String str = this.c.inputDigitAndRememberPosition(paramChar); ; str = this.c.inputDigit(paramChar))
      return str;
  }

  private String a(CharSequence paramCharSequence, int paramInt)
  {
    int i = paramInt - 1;
    Object localObject1 = null;
    this.c.clear();
    int j = paramCharSequence.length();
    int k = 0;
    boolean bool = false;
    char c1 = '\000';
    if (k < j)
    {
      char c2 = paramCharSequence.charAt(k);
      if (!PhoneNumberUtils.isNonSeparator(c2))
        break label119;
      if (c1 != 0)
      {
        localObject1 = a(c1, bool);
        bool = false;
      }
      c1 = c2;
    }
    label119: for (Object localObject2 = localObject1; ; localObject2 = localObject1)
    {
      if (k == i)
        bool = true;
      k++;
      localObject1 = localObject2;
      break;
      if (c1 != 0)
        localObject1 = a(c1, bool);
      return localObject1;
    }
  }

  private void a()
  {
    this.b = true;
    this.c.clear();
  }

  private boolean a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (i < paramInt1 + paramInt2)
      if (PhoneNumberUtils.isNonSeparator(paramCharSequence.charAt(i)));
    for (int j = 1; ; j = 0)
    {
      return j;
      i++;
      break;
    }
  }

  public void afterTextChanged(Editable paramEditable)
  {
    boolean bool = true;
    monitorenter;
    try
    {
      if (this.b)
        if (paramEditable.length() != 0)
          this.b = bool;
      while (true)
      {
        return;
        bool = false;
        break;
        if (this.a)
          continue;
        String str = a(paramEditable, Selection.getSelectionEnd(paramEditable));
        if (str == null)
          continue;
        int i = this.c.getRememberedPosition();
        this.a = true;
        paramEditable.replace(0, paramEditable.length(), str, 0, str.length());
        if (str.equals(paramEditable.toString()))
          Selection.setSelection(paramEditable, i);
        this.a = false;
      }
    }
    finally
    {
      monitorexit;
    }
    throw localObject;
  }

  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.a) || (this.b));
    while (true)
    {
      return;
      if ((paramInt2 > 0) && (a(paramCharSequence, paramInt1, paramInt2)))
      {
        a();
        continue;
      }
    }
  }

  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.a) || (this.b));
    while (true)
    {
      return;
      if ((paramInt3 > 0) && (a(paramCharSequence, paramInt1, paramInt3)))
      {
        a();
        continue;
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     android_src.telephony.PhoneNumberFormattingTextWatcher
 * JD-Core Version:    0.6.0
 */