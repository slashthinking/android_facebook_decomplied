package com.facebook.katana.activity.media.vault;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import com.facebook.orca.common.util.StringLocaleUtil;

public class VaultOptInControlFragment extends VaultSimpleOptInFragment
{
  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    String str1 = "<b><u>" + e(2131363601) + "</u></b>";
    String str2 = StringLocaleUtil.b(e(2131363600), new Object[] { str1 });
    ((TextView)A().findViewById(2131297948)).setText(Html.fromHtml(str2));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.media.vault.VaultOptInControlFragment
 * JD-Core Version:    0.6.0
 */