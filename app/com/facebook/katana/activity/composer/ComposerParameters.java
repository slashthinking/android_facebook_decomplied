package com.facebook.katana.activity.composer;

import android.content.Intent;
import android.location.Location;
import com.facebook.ipc.katana.model.FacebookPlace;
import com.facebook.katana.util.IntentUtils;
import java.util.Set;

public class ComposerParameters
{
  private final String a;
  private final String b;
  private final String c;
  private final Set<Long> d;
  private final Location e;
  private final FacebookPlace f;
  private final boolean g;
  private final boolean h;
  private final boolean i;
  private final boolean j;
  private final String k;
  private long l;
  private long m;

  public ComposerParameters(Intent paramIntent, long paramLong)
  {
    this.c = paramIntent.getStringExtra("extra_status_text");
    this.d = IntentUtils.a(paramIntent.getLongArrayExtra("extra_tagged_ids"));
    String str1 = paramIntent.getStringExtra("extra_tagged_place_id");
    this.g = paramIntent.getBooleanExtra("extra_xed_location", false);
    this.h = paramIntent.getBooleanExtra("extra_is_checkin", false);
    this.e = ((Location)paramIntent.getParcelableExtra("extra_tagged_location"));
    this.m = paramIntent.getLongExtra("extra_target_page", -1L);
    this.b = paramIntent.getStringExtra("extra_status_privacy");
    this.f = ((FacebookPlace)paramIntent.getParcelableExtra("extra_place"));
    if (this.f != null);
    for (String str2 = String.valueOf(this.f.mPageId); ; str2 = str1)
    {
      this.a = str2;
      this.i = paramIntent.getBooleanExtra("is_uploading_media", false);
      this.j = paramIntent.getBooleanExtra("extra_is_share", false);
      this.k = paramIntent.getStringExtra("extra_link_for_share");
      this.l = paramLong;
      long l1 = paramIntent.getLongExtra("extra_fixed_audience_id", -1L);
      if (l1 > 0L)
        this.l = l1;
      return;
    }
  }

  public String a()
  {
    return this.c;
  }

  public Set<Long> b()
  {
    return this.d;
  }

  public String c()
  {
    return this.b;
  }

  public String d()
  {
    return this.a;
  }

  public long e()
  {
    return this.l;
  }

  public Location f()
  {
    return this.e;
  }

  public FacebookPlace g()
  {
    return this.f;
  }

  public boolean h()
  {
    return this.g;
  }

  public boolean i()
  {
    return this.h;
  }

  public long j()
  {
    return this.m;
  }

  public String k()
  {
    return this.k;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.composer.ComposerParameters
 * JD-Core Version:    0.6.0
 */