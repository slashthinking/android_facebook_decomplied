package com.facebook.timeline;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.model.GraphQLAddress;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLLocation;
import com.facebook.graphql.model.GraphQLPhoneNumber;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.TimelineAppSection;
import com.facebook.orca.common.util.Clock;
import com.facebook.orca.inject.FbInjector;
import com.facebook.timeline.page.hours.PageHours;
import com.facebook.timeline.page.hours.PageHours.Status;
import com.facebook.timeline.page.hours.PageHoursRenderer;
import com.facebook.timeline.permissions.ProfilePermissions;
import com.facebook.timeline.permissions.ProfilePermissions.Permission;
import com.facebook.widget.UrlImage;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;

public class PageTimelineHeaderView extends TimelineHeaderView
{
  private final Clock a = (Clock)getInjector().a(Clock.class);
  private final PageHoursRenderer b = new PageHoursRenderer();
  private final Joiner c = Joiner.on(" " + getResources().getString(2131361798) + " ");

  public PageTimelineHeaderView(Context paramContext, SecureContextHelper paramSecureContextHelper, FragmentManager paramFragmentManager)
  {
    super(paramContext, paramSecureContextHelper, paramFragmentManager);
  }

  private void a(ViewGroup paramViewGroup, String paramString, int paramInt)
  {
    View localView = getInflater().inflate(2130903583, null);
    a(localView, 2131297882, paramString);
    ((UrlImage)Preconditions.checkNotNull((UrlImage)localView.findViewById(2131297881))).setPlaceHolderResourceId(paramInt);
    paramViewGroup.addView(localView);
  }

  private String getPrimaryCategoryName()
  {
    List localList = getHeaderData().M();
    if ((localList == null) || (localList.size() == 0));
    for (String str = null; ; str = (String)localList.get(0))
      return str;
  }

  private String getSummaryStatsString()
  {
    TimelineHeaderData localTimelineHeaderData = getHeaderData();
    ArrayList localArrayList = new ArrayList();
    int i = localTimelineHeaderData.D();
    if (i != 0)
    {
      Resources localResources3 = getResources();
      Object[] arrayOfObject3 = new Object[1];
      arrayOfObject3[0] = Integer.valueOf(i);
      localArrayList.add(localResources3.getQuantityString(2131427328, i, arrayOfObject3));
    }
    int j = localTimelineHeaderData.E();
    if (j != 0)
    {
      Resources localResources2 = getResources();
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Integer.valueOf(j);
      localArrayList.add(localResources2.getQuantityString(2131427329, j, arrayOfObject2));
    }
    int k = localTimelineHeaderData.F();
    if (k != 0)
    {
      Resources localResources1 = getResources();
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Integer.valueOf(k);
      localArrayList.add(localResources1.getQuantityString(2131427330, k, arrayOfObject1));
    }
    return this.c.join(localArrayList);
  }

  private void m()
  {
    if ("LOCAL".equalsIgnoreCase(getHeaderData().L()))
      n();
    while (true)
    {
      return;
      o();
    }
  }

  private void n()
  {
    TimelineHeaderData localTimelineHeaderData = getHeaderData();
    ViewGroup localViewGroup = (ViewGroup)findViewById(2131297661);
    localViewGroup.setVisibility(0);
    localViewGroup.removeAllViews();
    localViewGroup.setOnClickListener(new PageTimelineHeaderView.1(this));
    ArrayList localArrayList = new ArrayList();
    String str1 = getPrimaryCategoryName();
    if (str1 != null)
      localArrayList.add(str1);
    String str2 = localTimelineHeaderData.O();
    if (str2 != null)
      localArrayList.add(str2);
    if (localArrayList.size() > 0)
      a(localViewGroup, this.c.join(localArrayList), 2130838813);
    GraphQLAddress localGraphQLAddress = localTimelineHeaderData.Q();
    if ((localGraphQLAddress != null) && (localGraphQLAddress.fullAddress != null))
      a(localViewGroup, this.c.join(localGraphQLAddress.fullAddress.split("\n")), 2130838812);
    GraphQLPhoneNumber localGraphQLPhoneNumber = localTimelineHeaderData.N();
    if ((localGraphQLPhoneNumber != null) && (localGraphQLPhoneNumber.displayNumber != null))
      a(localViewGroup, localGraphQLPhoneNumber.displayNumber, 2130838814);
    List localList = localTimelineHeaderData.R();
    GraphQLLocation localGraphQLLocation = localTimelineHeaderData.P();
    String str3;
    if ((localList != null) && (localList.size() > 0) && (localGraphQLLocation != null) && (localGraphQLLocation.a() != null))
    {
      PageHours localPageHours = new PageHours(localList, localGraphQLLocation.a(), this.a);
      str3 = this.b.a(localPageHours, getResources());
      if (localPageHours.a() != PageHours.Status.OPEN)
        break label283;
    }
    label283: for (int i = 2130838811; ; i = 2130838810)
    {
      a(localViewGroup, str3, i);
      return;
    }
  }

  private void o()
  {
    TimelineHeaderData localTimelineHeaderData = getHeaderData();
    ViewGroup localViewGroup = (ViewGroup)findViewById(2131297661);
    localViewGroup.setVisibility(0);
    localViewGroup.removeAllViews();
    localViewGroup.setOnClickListener(new PageTimelineHeaderView.2(this));
    View localView = getInflater().inflate(2130903471, localViewGroup);
    String str = getPrimaryCategoryName();
    if (str != null)
    {
      a(localView, 2131297655, str);
      GraphQLTextWithEntities localGraphQLTextWithEntities = localTimelineHeaderData.J();
      if (localGraphQLTextWithEntities == null)
        break label111;
      a(localView, 2131297656, localGraphQLTextWithEntities.text);
    }
    while (true)
    {
      return;
      localView.findViewById(2131297655).setVisibility(8);
      break;
      label111: localView.findViewById(2131297656).setVisibility(8);
    }
  }

  private void p()
  {
    a(this, 2131297660, getSummaryStatsString());
  }

  private Bundle q()
  {
    TimelineHeaderData localTimelineHeaderData = getHeaderData();
    boolean bool1 = localTimelineHeaderData.H();
    Bundle localBundle = null;
    if (bool1)
    {
      boolean bool2 = localTimelineHeaderData.I().a(ProfilePermissions.Permission.CREATE_CONTENT);
      localBundle = null;
      if (bool2)
      {
        localBundle = new Bundle();
        localBundle.putBoolean("extra_acts_as_target", true);
        if (localTimelineHeaderData.i() != null)
          localBundle.putString("extra_actor_profile_pic_uri", localTimelineHeaderData.i().uri);
        localBundle.putLong("extra_actor_profile_id", localTimelineHeaderData.d());
        localBundle.putString("extra_actor_profile_name", localTimelineHeaderData.j());
        localBundle.putBoolean("extra_enable_friend_tagging", false);
        localBundle.putBoolean("extra_enable_privacy", false);
        localBundle.putBoolean("extra_enable_attach_album_photos", false);
      }
    }
    return localBundle;
  }

  public int a(int paramInt1, int paramInt2)
  {
    return Math.round(paramInt1 / 2.702F);
  }

  protected View a(TimelineAppSection paramTimelineAppSection)
  {
    return null;
  }

  protected void a()
  {
    if (getHeaderData().s());
    while (true)
    {
      return;
      p();
      m();
    }
  }

  protected boolean b()
  {
    return false;
  }

  protected boolean c()
  {
    if ((super.c()) && (!getHeaderData().H()));
    for (int i = 1; ; i = 0)
      return i;
  }

  protected boolean d()
  {
    return getHeaderData().K();
  }

  protected boolean e()
  {
    boolean bool1 = super.e();
    int i = 0;
    if (!bool1);
    while (true)
    {
      return i;
      TimelineHeaderData localTimelineHeaderData = getHeaderData();
      if (localTimelineHeaderData.H())
      {
        boolean bool2 = localTimelineHeaderData.I().a(ProfilePermissions.Permission.CREATE_CONTENT);
        i = 0;
        if (!bool2)
          continue;
      }
      i = 1;
    }
  }

  protected boolean f()
  {
    return false;
  }

  protected int getHeaderLayoutResource()
  {
    return 2130903472;
  }

  protected Intent getPhotoIntent()
  {
    Intent localIntent = super.getPhotoIntent();
    if (q() != null)
      localIntent.putExtras(q());
    return localIntent;
  }

  protected Intent getStatusIntent()
  {
    Intent localIntent = super.getStatusIntent();
    if (q() != null)
      localIntent.putExtras(q());
    return localIntent;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.PageTimelineHeaderView
 * JD-Core Version:    0.6.0
 */