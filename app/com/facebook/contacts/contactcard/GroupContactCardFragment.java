package com.facebook.contacts.contactcard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.orca.activity.OrcaFragment;
import com.facebook.orca.cache.DataCache;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.threads.MessagesCollection;
import com.facebook.orca.threads.MessagingIdUtil;
import com.facebook.orca.threads.ThreadSummary;

public class GroupContactCardFragment extends OrcaFragment
{
  private ThreadSummary Y;
  private MessagesCollection Z;
  private DataCache a;
  private AnalyticsLogger b;
  private String c;
  private NameConversationView d;
  private GroupMembersSectionView e;
  private ConversationSettingsView f;
  private MapSectionView g;
  private Button h;
  private GroupContactCardFragment.GroupContactCardListener i;

  private void a(HoneyClientEvent paramHoneyClientEvent)
  {
    paramHoneyClientEvent.d("GroupContactCardFragment");
    paramHoneyClientEvent.b("thread_id", this.c);
    this.b.a(paramHoneyClientEvent);
  }

  private void b()
  {
    if ((this.a == null) || (this.c == null));
    while (true)
    {
      return;
      ThreadSummary localThreadSummary = this.a.b(this.c);
      if ((localThreadSummary == null) || (localThreadSummary == this.Y))
        continue;
      a(localThreadSummary, this.a.c(localThreadSummary.a()));
    }
  }

  public void B()
  {
    super.B();
    a();
    b();
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130903114, paramViewGroup, false);
  }

  public void a()
  {
    if (this.f != null)
      this.f.a();
  }

  public void a(GroupContactCardFragment.GroupContactCardListener paramGroupContactCardListener)
  {
    this.i = paramGroupContactCardListener;
    if (this.g != null)
    {
      this.g.setContactCardListener(paramGroupContactCardListener);
      this.f.setContactCardListener(paramGroupContactCardListener);
    }
  }

  public void a(ThreadSummary paramThreadSummary, MessagesCollection paramMessagesCollection)
  {
    if ((paramThreadSummary == this.Y) && (paramMessagesCollection == this.Z));
    while (true)
    {
      return;
      this.Y = paramThreadSummary;
      this.Z = paramMessagesCollection;
      this.d.setVisibility(0);
      this.h.setVisibility(0);
      if (MessagingIdUtil.g(this.c))
      {
        this.d.setVisibility(8);
        this.h.setVisibility(8);
      }
      if ((paramThreadSummary == null) || (!paramThreadSummary.v()))
      {
        this.d.setVisibility(8);
        this.h.setVisibility(8);
      }
      if (paramThreadSummary != null)
      {
        this.d.a(paramThreadSummary.f(), paramThreadSummary);
        this.e.setThreadSummary(paramThreadSummary);
        this.f.setThreadId(paramThreadSummary.a());
      }
      if (paramMessagesCollection == null)
        continue;
      this.g.setGroupMessages(paramMessagesCollection);
    }
  }

  public void a(String paramString)
  {
    this.c = paramString;
    b();
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    FbInjector localFbInjector = Q();
    this.a = ((DataCache)localFbInjector.a(DataCache.class));
    this.b = ((AnalyticsLogger)localFbInjector.a(AnalyticsLogger.class));
    this.d = ((NameConversationView)g(2131296590));
    this.e = ((GroupMembersSectionView)g(2131296591));
    this.f = ((ConversationSettingsView)g(2131296570));
    this.g = ((MapSectionView)g(2131296576));
    this.h = ((Button)g(2131296592));
    if (this.i != null)
    {
      this.g.setContactCardListener(this.i);
      this.f.setContactCardListener(this.i);
    }
    this.e.setGroupMembersSectionListener(new GroupContactCardFragment.1(this));
    this.h.setOnClickListener(new GroupContactCardFragment.2(this));
    b();
  }

  public void d(boolean paramBoolean)
  {
    super.d(paramBoolean);
    if (!paramBoolean)
      b();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.contactcard.GroupContactCardFragment
 * JD-Core Version:    0.6.0
 */