package com.facebook.contacts.contactcard;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.orca.cache.ThreadDisplayCache;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.images.ThreadIconPickerActivity;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.photos.tiles.DefaultTiles;
import com.facebook.orca.server.ModifyThreadParams;
import com.facebook.orca.server.ModifyThreadParamsBuilder;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.orca.threadview.ThreadNamePicker;
import com.facebook.orca.threadview.ThreadViewFragment;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.UrlImage;
import com.google.common.base.Objects;
import java.util.Locale;

public class NameConversationView extends CustomFrameLayout
{
  private final ThreadDisplayCache a;
  private final RelativeLayout b;
  private final TextView c;
  private final UrlImage d;
  private ThreadSummary e;
  private String f;
  private ThreadViewFragment g;
  private AnalyticsLogger h;

  public NameConversationView(Context paramContext)
  {
    this(paramContext, null);
  }

  public NameConversationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public NameConversationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.g = ((ThreadViewFragment)((FragmentActivity)paramContext).g().a("threadViewFragment"));
    FbInjector localFbInjector = getInjector();
    this.a = ((ThreadDisplayCache)localFbInjector.a(ThreadDisplayCache.class));
    this.h = ((AnalyticsLogger)localFbInjector.a(AnalyticsLogger.class));
    setContentView(2130903121);
    this.b = ((RelativeLayout)b(2131296609));
    this.d = ((UrlImage)b(2131296611));
    this.c = ((TextView)b(2131296613));
    this.b.setClickable(true);
    if (Build.VERSION.SDK_INT >= 14)
      this.b.setBackgroundResource(2130838636);
    while (true)
    {
      if (Objects.equal(Locale.getDefault().getLanguage(), "es"))
        this.c.setTextSize(15.0F);
      this.d.setFocusable(true);
      this.d.setClickable(true);
      this.d.setOnClickListener(new NameConversationView.1(this));
      this.b.setOnClickListener(new NameConversationView.2(this));
      return;
      this.b.setBackgroundResource(17301602);
    }
  }

  private String a(String paramString)
  {
    if (StringUtil.a(paramString))
      paramString = "";
    return paramString;
  }

  private void a()
  {
    if ((this.e == null) || (!this.e.u()));
    while (true)
    {
      return;
      a(new HoneyClientEvent("click").e("button").f("thread_image"));
      Intent localIntent = new Intent(getContext(), ThreadIconPickerActivity.class);
      localIntent.putExtra("threadId", this.e.a());
      localIntent.putExtra("hasPictureHash", this.e.q());
      getContext().startActivity(localIntent);
    }
  }

  private void a(HoneyClientEvent paramHoneyClientEvent)
  {
    paramHoneyClientEvent.d("NameConversationView");
    if (this.e != null)
      paramHoneyClientEvent.b("thread_id", this.e.a());
    this.h.a(paramHoneyClientEvent);
  }

  private void b()
  {
    if (!this.e.u());
    while (true)
    {
      return;
      a(new HoneyClientEvent("click").e("button").f("name_conversation"));
      ThreadNamePicker localThreadNamePicker = new ThreadNamePicker(getContext(), this.f);
      localThreadNamePicker.a(new NameConversationView.3(this));
      localThreadNamePicker.show();
    }
  }

  private void c()
  {
    this.c.setText(this.f);
    if (StringUtil.a(this.f, this.e.f()));
    while (true)
    {
      return;
      ModifyThreadParamsBuilder localModifyThreadParamsBuilder = new ModifyThreadParamsBuilder();
      localModifyThreadParamsBuilder.a(this.e.a());
      localModifyThreadParamsBuilder.a(true);
      localModifyThreadParamsBuilder.b(a(this.f));
      ModifyThreadParams localModifyThreadParams = localModifyThreadParamsBuilder.h();
      this.g.a(localModifyThreadParams);
      a(new HoneyClientEvent("set").e("thread_name"));
    }
  }

  public void a(String paramString, ThreadSummary paramThreadSummary)
  {
    this.e = paramThreadSummary;
    this.f = paramThreadSummary.f();
    this.c.setText(paramString);
    LayerDrawable localLayerDrawable = new LayerDrawable(new Drawable[] { new ColorDrawable(DefaultTiles.a), getResources().getDrawable(2130838587) });
    this.d.setPlaceHolderDrawable(localLayerDrawable);
    if (paramThreadSummary != null)
      this.d.setImageParams(this.a.a(paramThreadSummary, false));
    while (true)
    {
      return;
      this.d.setImageParams(UrlImage.a);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.contactcard.NameConversationView
 * JD-Core Version:    0.6.0
 */