package com.facebook.katana;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.katana.activity.BaseFacebookTabActivity;
import com.facebook.katana.activity.FacebookActivityDelegate;
import com.facebook.katana.activity.findfriends.HowFound;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpec;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpecBuilder;
import java.util.Iterator;
import java.util.List;

public class UsersTabHostActivity extends BaseFacebookTabActivity
  implements AnalyticsActivity, MyTabHost.OnTabChangeListener, TabProgressListener
{
  private Activity n;
  private TextView o;
  private Integer p;

  private void b(String paramString)
  {
    if (paramString.equals("friends"))
    {
      this.o.setHint(2131362937);
      findViewById(2131297940).setVisibility(0);
    }
    while (true)
    {
      return;
      if (paramString.equals("page_search"))
      {
        this.o.setHint(2131362943);
        findViewById(2131297940).setVisibility(0);
        continue;
      }
    }
  }

  private void l()
  {
    if ((this.n instanceof UsersTabProgressSource))
      ((UsersTabProgressSource)this.n).a(this);
  }

  public String a()
  {
    return FB4A_AnalyticEntities.y;
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903620);
    a(TitleBarButtonSpec.newBuilder().b(2130838253).i());
    MyTabHost localMyTabHost = (MyTabHost)k();
    localMyTabHost.a(false);
    MyTabHost.TabSpec localTabSpec1 = localMyTabHost.a("friends", a("friends", 2131362938));
    Intent localIntent1 = new Intent(this, FriendsActivity.class);
    localIntent1.putExtra("within_tab", true);
    localIntent1.putExtra("extra_parent_tag", x());
    localTabSpec1.a(localIntent1);
    localMyTabHost.a(localTabSpec1);
    MyTabHost.TabSpec localTabSpec2 = localMyTabHost.a("page_search", a("page_search", 2131363024));
    Intent localIntent2 = new Intent(this, PageSearchResultsActivity.class);
    localIntent2.putExtra("within_tab", true);
    localIntent2.putExtra("extra_parent_tag", x());
    localTabSpec2.a(localIntent2);
    localMyTabHost.a(localTabSpec2);
    this.o = ((TextView)findViewById(2131297941));
    this.o.addTextChangedListener(new UsersTabHostActivity.1(this));
    this.n = j();
    if ((this.n instanceof UsersTabProgressSource))
      ((UsersTabProgressSource)this.n).a(this);
    String str = getIntent().getStringExtra("com.facebook.katana.DefaultTab");
    if (str != null);
    while (true)
    {
      localMyTabHost.setCurrentTabByTag(str);
      this.n = j();
      b(str);
      l();
      localMyTabHost.setOnTabChangedListener(this);
      i();
      return;
      str = "friends";
    }
  }

  public void a(String paramString)
  {
    if ((this.n != null) && ((this.n instanceof UsersTabProgressSource)))
      ((UsersTabProgressSource)this.n).a(null);
    this.n = j();
    if ((this.n instanceof UsersTabProgressSource))
    {
      ((UsersTabProgressSource)this.n).a(this);
      ((UsersTabProgressSource)this.n).a(this.o.getText().toString().trim());
    }
    b(paramString);
  }

  public void a_(boolean paramBoolean)
  {
    t().a(paramBoolean);
  }

  protected void onDestroy()
  {
    super.onDestroy();
    if ((this.n != null) && ((this.n instanceof UsersTabProgressSource)))
      ((UsersTabProgressSource)this.n).a(null);
  }

  public void onResume()
  {
    super.onResume();
    if (this.p != null)
    {
      Iterator localIterator = ((MyTabHost)k()).getTabSpecs().iterator();
      while (localIterator.hasNext())
      {
        RadioButton localRadioButton = (RadioButton)((MyTabHost.TabSpec)localIterator.next()).b;
        if (this.p.intValue() == 0)
        {
          localRadioButton.setText(getString(2131362962));
          continue;
        }
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = this.p;
        localRadioButton.setText(getString(2131363128, arrayOfObject));
      }
    }
  }

  public boolean onSearchRequested()
  {
    return true;
  }

  public void titleBarPrimaryActionClickHandler(View paramView)
  {
    IntentUriHandler.b(this, HowFound.a("friends_view"));
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.UsersTabHostActivity
 * JD-Core Version:    0.6.0
 */