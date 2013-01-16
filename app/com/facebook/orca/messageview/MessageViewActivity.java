package com.facebook.orca.messageview;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsActivity;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.orca.activity.ExportMenuToFbHostActivity;
import com.facebook.orca.activity.ExportMenuToFbHostActivity.CustomFbHostMenuItem;
import com.facebook.orca.activity.FbFragmentActivity;
import com.facebook.orca.activity.SafeLocalBroadcastReceiver;
import com.facebook.orca.attachments.AttachmentDataFactory;
import com.facebook.orca.cache.DataCache;
import com.facebook.orca.common.ui.titlebar.FbTitleBar;
import com.facebook.orca.common.ui.titlebar.FbTitleBarUtil;
import com.facebook.orca.common.ui.util.MessageRenderingUtil;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.common.util.IntentUtil;
import com.facebook.orca.common.util.SizeUtil;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.location.Coordinates;
import com.facebook.orca.location.GeocodingForMessageLocationExecutor;
import com.facebook.orca.location.GeocodingForMessageLocationResult;
import com.facebook.orca.mutators.DeleteMessagesActivity;
import com.facebook.orca.photos.tiles.UserTileView;
import com.facebook.orca.photos.tiles.UserTileViewParams;
import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.MessagingIdUtil;
import com.facebook.orca.threads.ParticipantInfo;
import com.facebook.orca.threads.ThreadDateUtil;
import com.facebook.orca.threads.ThreadParticipant;
import com.facebook.orca.threads.ThreadSourceUtil;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.orca.threadview.ThreadViewTitleHelper;
import com.facebook.orca.users.UserKey;
import com.facebook.widget.MapImage;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;

public class MessageViewActivity extends FbFragmentActivity
  implements AnalyticsActivity, ExportMenuToFbHostActivity
{
  private static final Class<?> n = MessageViewActivity.class;
  private TextView A;
  private UserTileView B;
  private MapImage C;
  private TextView D;
  private MessageViewOtherAttachmentsView E;
  private MessageReaderListView F;
  private String G;
  private Message H;
  private SafeLocalBroadcastReceiver I;
  private ListenableFuture<GeocodingForMessageLocationResult> J;
  private AndroidThreadUtil o;
  private DataCache p;
  private MessageRenderingUtil q;
  private AttachmentDataFactory r;
  private ThreadDateUtil s;
  private ThreadSourceUtil t;
  private GeocodingForMessageLocationExecutor u;
  private AnalyticsLogger v;
  private ThreadSummary w;
  private FbTitleBar x;
  private TextView y;
  private TextView z;

  private void a(RelativeLayout.LayoutParams paramLayoutParams1, RelativeLayout.LayoutParams paramLayoutParams2, LinearLayout.LayoutParams paramLayoutParams)
  {
    paramLayoutParams1.addRule(9, -1);
    paramLayoutParams2.addRule(1, 2131297361);
    paramLayoutParams2.leftMargin = SizeUtil.a(getResources(), 5.0F);
    paramLayoutParams.leftMargin = SizeUtil.a(getResources(), 46.0F);
  }

  private void a(RelativeLayout.LayoutParams paramLayoutParams1, RelativeLayout.LayoutParams paramLayoutParams2, LinearLayout.LayoutParams paramLayoutParams3, LinearLayout.LayoutParams paramLayoutParams4, LinearLayout.LayoutParams paramLayoutParams5)
  {
    paramLayoutParams1.addRule(11, -1);
    paramLayoutParams2.addRule(0, 2131297361);
    paramLayoutParams2.rightMargin = SizeUtil.a(getResources(), 5.0F);
    if (MessagingIdUtil.g(this.H.b()))
      this.D.setBackgroundDrawable(getResources().getDrawable(2130838581));
    while (true)
    {
      paramLayoutParams3.rightMargin = SizeUtil.a(getResources(), 46.0F);
      paramLayoutParams3.gravity = 5;
      paramLayoutParams4.gravity = 5;
      paramLayoutParams5.gravity = 5;
      return;
      this.D.setBackgroundDrawable(getResources().getDrawable(2130838578));
    }
  }

  private void a(Coordinates paramCoordinates)
  {
    if (paramCoordinates == null);
    while (true)
    {
      return;
      this.J = this.u.a(this.H.k());
      this.o.a(this.J, new MessageViewActivity.4(this));
    }
  }

  private void i()
  {
    RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)this.B.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.D.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams3 = (LinearLayout.LayoutParams)this.A.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams4 = (LinearLayout.LayoutParams)this.y.getLayoutParams();
    LinearLayout.LayoutParams localLayoutParams5 = (LinearLayout.LayoutParams)this.z.getLayoutParams();
    if (this.H.f().e().equals(this.p.b()))
      a(localLayoutParams1, localLayoutParams2, localLayoutParams3, localLayoutParams4, localLayoutParams5);
    while (true)
    {
      return;
      a(localLayoutParams1, localLayoutParams2, localLayoutParams3);
    }
  }

  private void j()
  {
    this.I.a();
  }

  private void k()
  {
    if (this.I != null)
      this.I.b();
  }

  private void l()
  {
    if (this.J != null)
    {
      this.J.cancel(false);
      this.J = null;
    }
  }

  private void m()
  {
    String str = this.H.f().e().b();
    Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("fb://profile/" + Uri.encode(str)));
    if (IntentUtil.a(this, localIntent))
      startActivity(localIntent);
    while (true)
    {
      return;
      startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://m.facebook.com/profile.php?id=" + Uri.encode(str))));
    }
  }

  public String a()
  {
    return "message";
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2130903377);
    FbInjector localFbInjector = C();
    this.o = ((AndroidThreadUtil)localFbInjector.a(AndroidThreadUtil.class));
    this.p = ((DataCache)localFbInjector.a(DataCache.class));
    this.q = ((MessageRenderingUtil)localFbInjector.a(MessageRenderingUtil.class));
    this.r = ((AttachmentDataFactory)localFbInjector.a(AttachmentDataFactory.class));
    this.s = ((ThreadDateUtil)localFbInjector.a(ThreadDateUtil.class));
    this.t = ((ThreadSourceUtil)localFbInjector.a(ThreadSourceUtil.class));
    this.v = ((AnalyticsLogger)localFbInjector.a(AnalyticsLogger.class));
    this.u = ((GeocodingForMessageLocationExecutor)localFbInjector.a(GeocodingForMessageLocationExecutor.class));
    FbTitleBarUtil.a(this);
    this.x = ((FbTitleBar)f(2131296299));
    this.y = ((TextView)f(2131297359));
    this.z = ((TextView)f(2131297360));
    this.A = ((TextView)f(2131297362));
    this.B = ((UserTileView)f(2131297361));
    this.C = ((MapImage)f(2131297358));
    this.D = ((TextView)f(2131297345));
    this.E = ((MessageViewOtherAttachmentsView)f(2131297363));
    this.F = ((MessageReaderListView)f(2131297364));
    Intent localIntent = getIntent();
    this.G = localIntent.getStringExtra("thread_id");
    this.w = this.p.b(this.G);
    this.H = ((Message)localIntent.getParcelableExtra("message"));
    if ((this.w == null) || (this.H == null))
    {
      finish();
      return;
    }
    MessageReaderListView.Parameters localParameters = new MessageReaderListView.Parameters();
    if (localIntent.hasExtra("readers"))
      localParameters.a(localIntent.getParcelableArrayListExtra("readers"));
    if (localIntent.hasExtra("other_readers"))
      localParameters.b(localIntent.getParcelableArrayListExtra("other_readers"));
    localParameters.a(this.H);
    localParameters.a(this.w);
    this.F.setParameters(localParameters);
    ThreadViewTitleHelper localThreadViewTitleHelper = (ThreadViewTitleHelper)localFbInjector.a(ThreadViewTitleHelper.class);
    localThreadViewTitleHelper.a(this.x);
    localThreadViewTitleHelper.a(this.w);
    ParticipantInfo localParticipantInfo = this.H.f();
    ThreadParticipant localThreadParticipant = this.w.a(localParticipantInfo);
    if (localThreadParticipant != null)
    {
      this.B.setParams(UserTileViewParams.a(localThreadParticipant));
      label474: this.y.setText(localParticipantInfo.d());
      if (localParticipantInfo.b())
      {
        this.y.setClickable(true);
        this.y.setOnClickListener(new MessageViewActivity.1(this));
      }
      this.z.setText(this.s.d(this.H.c()));
      this.A.setText(this.t.a(this.H));
      a(this.H.k());
      if (this.H.o())
      {
        this.C.setVisibility(0);
        this.C.setCenter(this.H.k().a());
        this.C.setOnClickListener(new MessageViewActivity.2(this));
      }
      if (!StringUtil.f(this.H.h()))
        break label727;
      this.D.setVisibility(8);
      this.A.setVisibility(8);
      label648: if (!this.r.f(this.H))
        break label783;
      this.E.setMessage(this.H);
      this.E.setVisibility(0);
    }
    while (true)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.facebook.orca.ACTION_DELETED_MESSAGES_FOR_UI");
      this.I = new MessageViewActivity.3(this, this, localIntentFilter);
      break;
      this.B.setParams(null);
      break label474;
      label727: Spanned localSpanned = this.q.a(this.H);
      this.D.setLinksClickable(true);
      this.D.setAutoLinkMask(15);
      this.D.setMovementMethod(LinkMovementMethod.getInstance());
      this.D.setText(localSpanned);
      i();
      break label648;
      label783: this.E.setVisibility(8);
    }
  }

  public void a_(int paramInt)
  {
    if (paramInt == 2131298007)
    {
      Intent localIntent = new Intent(this, DeleteMessagesActivity.class);
      localIntent.putExtra("thread_id", this.H.b());
      localIntent.putExtra("message_ids", ImmutableList.a(this.H.a()));
      startActivity(localIntent);
    }
  }

  public List<ExportMenuToFbHostActivity.CustomFbHostMenuItem> b()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new ExportMenuToFbHostActivity.CustomFbHostMenuItem(2131298007, 2131362580, 2130838621, true, null));
    return localArrayList;
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    super.onCreateOptionsMenu(paramMenu);
    getMenuInflater().inflate(2131755008, paramMenu);
    return true;
  }

  protected void onDestroy()
  {
    super.onDestroy();
    k();
    l();
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131298007)
    {
      this.v.a(new HoneyClientEvent("click").e("opt_menu_item").f("delete"));
      Intent localIntent = new Intent(this, DeleteMessagesActivity.class);
      localIntent.putExtra("thread_id", this.H.b());
      localIntent.putExtra("message_ids", ImmutableList.a(this.H.a()));
      startActivity(localIntent);
    }
    for (boolean bool = true; ; bool = super.onOptionsItemSelected(paramMenuItem))
      return bool;
  }

  protected void onStart()
  {
    super.onStart();
    j();
  }

  protected void onStop()
  {
    super.onStop();
    k();
    l();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.messageview.MessageViewActivity
 * JD-Core Version:    0.6.0
 */