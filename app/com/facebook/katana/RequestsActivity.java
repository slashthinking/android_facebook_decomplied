package com.facebook.katana;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.ipc.katana.model.FacebookUser;
import com.facebook.katana.activity.BaseFacebookListActivity;
import com.facebook.katana.activity.NotNewNavEnabled;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.model.FacebookSessionInfo;
import java.util.LinkedHashMap;
import java.util.Map;

public class RequestsActivity extends BaseFacebookListActivity
  implements NotNewNavEnabled
{
  private AppSession n;
  private boolean o = false;
  private RequestsAdapter p;
  private AppSessionListener q = new RequestsActivity.1(this);

  private void a(Map<Long, FacebookUser> paramMap)
  {
    if (this.p == null)
    {
      this.p = new RequestsAdapter(this, this.n, paramMap);
      a(this.p);
    }
    while (true)
    {
      return;
      this.p.a(paramMap);
      this.p.notifyDataSetChanged();
    }
  }

  private void j()
  {
    View localView = (View)m().getParent();
    TextView localTextView = (TextView)localView.findViewById(2131296644);
    localTextView.setVisibility(0);
    localTextView.setText(2131363141);
    localView.findViewById(2131296645).setVisibility(4);
  }

  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903537);
    this.n = AppSession.a(this, true);
    Intent localIntent = getIntent();
    if ((localIntent != null) && (localIntent.hasExtra("extra_frend_requests")))
    {
      Parcelable[] arrayOfParcelable = localIntent.getExtras().getParcelableArray("extra_frend_requests");
      LinkedHashMap localLinkedHashMap = new LinkedHashMap();
      int i = arrayOfParcelable.length;
      for (int j = 0; j < i; j++)
      {
        FacebookUser localFacebookUser = (FacebookUser)arrayOfParcelable[j];
        localLinkedHashMap.put(Long.valueOf(localFacebookUser.mUserId), localFacebookUser);
      }
      a(localLinkedHashMap);
      if (localLinkedHashMap.size() == 0)
        j();
      this.o = true;
    }
    if ((localIntent != null) && (!localIntent.getBooleanExtra("within_tab", false)))
      findViewById(2131297804).setVisibility(0);
  }

  public String i()
  {
    return null;
  }

  protected void onDestroy()
  {
    super.onDestroy();
    if (this.p != null)
      this.p.a();
  }

  protected void onPause()
  {
    super.onPause();
    this.o = false;
    if ((this.p != null) && (this.p.a))
    {
      this.n.e(this);
      this.p.a = false;
    }
    this.n.b(this.q);
  }

  protected void onResume()
  {
    super.onResume();
    if (!this.o)
    {
      this.n.a(this.q);
      long l = this.n.b().userId;
      this.n.a(this, l);
      v();
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.RequestsActivity
 * JD-Core Version:    0.6.0
 */