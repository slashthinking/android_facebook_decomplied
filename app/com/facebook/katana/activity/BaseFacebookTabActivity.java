package com.facebook.katana.activity;

import android.app.Activity;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.TextView;
import com.facebook.katana.MyTabHost;

@Deprecated
public class BaseFacebookTabActivity extends BaseFacebookActivity
  implements BookmarksMenuHost, FacebookActivity
{
  private MyTabHost n;
  private String o = null;
  private int p = -1;
  private LocalActivityManager q;

  private void l()
  {
    if (this.n == null)
      setContentView(2130903567);
  }

  protected RadioButton a(String paramString, int paramInt)
  {
    RadioButton localRadioButton = (RadioButton)getLayoutInflater().inflate(2130903568, null);
    localRadioButton.setButtonDrawable(2130838155);
    int i = Math.abs(paramString.hashCode());
    if (i <= 0)
      i = 1;
    localRadioButton.setId(i);
    localRadioButton.setText(paramInt);
    return localRadioButton;
  }

  protected void a_(Bundle paramBundle)
  {
    this.q = new LocalActivityManager(this, true);
    if (paramBundle != null);
    for (Bundle localBundle = paramBundle.getBundle("android:states"); ; localBundle = null)
    {
      this.q.dispatchCreate(localBundle);
      return;
    }
  }

  protected void i()
  {
    ((RadioGroup)findViewById(2131297942)).setOnCheckedChangeListener(new BaseFacebookTabActivity.1(this));
  }

  public Activity j()
  {
    return this.q.getCurrentActivity();
  }

  public TabHost k()
  {
    l();
    return this.n;
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    throw new RuntimeException("Unsupported! Don't use onActivityResult in BaseFacebookTabActivity!");
  }

  protected void onChildTitleChanged(Activity paramActivity, CharSequence paramCharSequence)
  {
    if (this.q.getCurrentActivity() == paramActivity)
    {
      View localView = this.n.getCurrentTabView();
      if ((localView != null) && ((localView instanceof TextView)))
        ((TextView)localView).setText(paramCharSequence);
    }
  }

  public void onContentChanged()
  {
    super.onContentChanged();
    this.n = ((MyTabHost)findViewById(16908306));
    if (this.n == null)
      throw new RuntimeException("Your content must have a TabHost whose id attribute is 'android.R.id.tabhost'");
    this.n.setup(this.q);
  }

  protected void onDestroy()
  {
    super.onDestroy();
    this.q.dispatchDestroy(isFinishing());
  }

  protected void onPause()
  {
    super.onPause();
    this.q.dispatchPause(isFinishing());
  }

  protected void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    l();
    if (this.n.getCurrentTab() == -1)
      this.n.setCurrentTab(0);
  }

  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    l();
    String str = paramBundle.getString("currentTab");
    if (str != null)
      this.n.setCurrentTabByTag(str);
    if (this.n.getCurrentTab() < 0)
    {
      if (this.o == null)
        break label57;
      this.n.setCurrentTabByTag(this.o);
    }
    while (true)
    {
      return;
      label57: if (this.p >= 0)
      {
        this.n.setCurrentTab(this.p);
        continue;
      }
    }
  }

  protected void onResume()
  {
    super.onResume();
    this.q.dispatchResume();
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    Bundle localBundle = this.q.saveInstanceState();
    if (localBundle != null)
      paramBundle.putBundle("android:states", localBundle);
    String str = this.n.getCurrentTabTag();
    if (str != null)
      paramBundle.putString("currentTab", str);
  }

  protected void onStop()
  {
    super.onStop();
    this.q.dispatchStop();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.BaseFacebookTabActivity
 * JD-Core Version:    0.6.0
 */