package com.facebook.katana.activity.places;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.katana.activity.BaseFacebookListActivity;
import com.facebook.katana.activity.NotNewNavEnabled;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.PageTopic;
import com.facebook.katana.ui.SectionedListView;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities;
import java.util.List;

public class SelectPageTopicActivity extends BaseFacebookListActivity
  implements AnalyticsActivity, NotNewNavEnabled
{
  private SelectPageTopicAdapter n;
  private int o;
  private long p;
  private AppSession q;
  private final AppSessionListener r = new SelectPageTopicActivity.1(this);

  public String a()
  {
    return FB4A_AnalyticEntities.s;
  }

  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903473);
    this.p = getIntent().getLongExtra("extra_topic_id", 0L);
    this.o = getIntent().getIntExtra("extra_category_level", 0);
    this.n = new SelectPageTopicAdapter(this, this.o, this.p);
    ((SectionedListView)m()).setSectionedListAdapter(this.n);
  }

  public void b(ListView paramListView, View paramView, int paramInt, long paramLong)
  {
    PageTopic localPageTopic = (PageTopic)this.n.e(paramInt);
    List localList = this.n.a(localPageTopic.id);
    if ((localList != null) && (localList.size() > 0) && (localPageTopic.id != this.p))
    {
      Intent localIntent2 = new Intent(this, SelectPageTopicActivity.class);
      localIntent2.putExtra("extra_topic_id", localPageTopic.id);
      localIntent2.putExtra("extra_topic_name", localPageTopic.displayName);
      localIntent2.putExtra("extra_category_level", 1 + this.o);
      startActivityForResult(localIntent2, 1);
    }
    while (true)
    {
      return;
      Intent localIntent1 = new Intent();
      localIntent1.putExtra("object", localPageTopic);
      setResult(-1, localIntent1);
      finish();
    }
  }

  public String i()
  {
    return getString(2131363473);
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == 0);
    while (true)
    {
      return;
      switch (paramInt1)
      {
      default:
        break;
      case 1:
        if ((paramInt2 != -1) || (!paramIntent.hasExtra("object")))
          continue;
        setResult(-1, paramIntent);
        finish();
      }
    }
  }

  protected void onPause()
  {
    super.onPause();
    this.q.b(this.r);
  }

  protected void onResume()
  {
    super.onResume();
    this.q = AppSession.a(this, true);
    this.q.a(this.r);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.places.SelectPageTopicActivity
 * JD-Core Version:    0.6.0
 */