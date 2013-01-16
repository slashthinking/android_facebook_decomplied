package com.facebook.katana.activity.findfriends;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.util.GrowthUtils;
import com.facebook.orca.common.util.StringLocaleUtil;

public class StepHowItWorksActivity extends BaseFacebookActivity
{
  private Spanned a(Spanned paramSpanned)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramSpanned);
    localSpannableStringBuilder.append(' ');
    int i = localSpannableStringBuilder.length();
    localSpannableStringBuilder.append(getString(2131363434));
    int j = localSpannableStringBuilder.length();
    localSpannableStringBuilder.setSpan(new StepHowItWorksActivity.1(this), i, j, 33);
    return localSpannableStringBuilder;
  }

  private String i()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = "fb://settings";
    arrayOfObject[1] = getString(2131363435);
    return StringLocaleUtil.a("<a href=\"%s\">%s</a>", arrayOfObject);
  }

  private void j()
  {
    findViewById(2131296862).setOnClickListener(new StepHowItWorksActivity.2(this));
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903199);
    TextView localTextView = (TextView)findViewById(2131296861);
    localTextView.setMovementMethod(LinkMovementMethod.getInstance());
    if (GrowthUtils.a().h(this))
    {
      Resources localResources2 = getResources();
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = i();
      localTextView.setText(a(Html.fromHtml(localResources2.getString(2131363437, arrayOfObject2))));
    }
    while (true)
    {
      j();
      return;
      Resources localResources1 = getResources();
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = i();
      localTextView.setText(a(Html.fromHtml(localResources1.getString(2131363436, arrayOfObject1))));
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.findfriends.StepHowItWorksActivity
 * JD-Core Version:    0.6.0
 */