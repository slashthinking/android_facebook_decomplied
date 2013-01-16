package com.facebook.katana;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.activity.NotNewNavEnabled;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.ui.mentions.MentionsAutoCompleteTextView;
import com.facebook.katana.ui.mentions.MentionsUtils;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpec;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpecBuilder;

public class FeedComposerActivity extends BaseFacebookActivity
  implements NotNewNavEnabled
{
  private AppSession n;

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903144);
    this.n = AppSession.a(this, false);
    ((TextView)findViewById(2131296686)).setText(getString(2131363201));
    ((MentionsAutoCompleteTextView)(EditText)findViewById(2131296697)).b(this);
    findViewById(2131296696).setOnClickListener(new FeedComposerActivity.1(this));
    a(TitleBarButtonSpec.newBuilder().b(getString(2131362853)).i());
  }

  public String i()
  {
    return getString(2131362127);
  }

  public void titleBarPrimaryActionClickHandler(View paramView)
  {
    String str = MentionsUtils.a(((EditText)findViewById(2131296697)).getText());
    if (str.length() > 0)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("extra_comment_text", str);
      setResult(-1, localIntent);
      finish();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.FeedComposerActivity
 * JD-Core Version:    0.6.0
 */