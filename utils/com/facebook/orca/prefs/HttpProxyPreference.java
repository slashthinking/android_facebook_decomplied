package com.facebook.orca.prefs;

import android.content.Context;
import android.widget.EditText;

public class HttpProxyPreference extends EditTextPreferenceWithSummaryValue
{
  public HttpProxyPreference(Context paramContext)
  {
    super(paramContext);
    setKey(InternalHttpPrefKeys.g.a());
    setTitle(2131362801);
    a(getContext().getString(2131362802));
    setDialogTitle(2131362803);
    getEditText().setHint(2131362804);
    getEditText().setSingleLine(true);
    getEditText().setInputType(1);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.HttpProxyPreference
 * JD-Core Version:    0.6.2
 */