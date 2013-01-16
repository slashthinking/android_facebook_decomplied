package com.facebook.timeline;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.StyleSpan;
import android.text.style.TextAppearanceSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.util.FeedLinkifyUtil;
import com.facebook.friends.FriendingClient;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLProfileList;
import com.facebook.graphql.model.TimelineAppSection;
import com.facebook.graphql.model.TimelineAppSection.AppSectionType;
import com.facebook.graphql.model.TimelineBylineFragment;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.inject.FbInjector;
import com.facebook.timeline.ui.TimelineFriendDialog;
import com.facebook.widget.UrlImage;
import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.List;

public class UserTimelineHeaderView extends TimelineHeaderView
{
  private final FeedLinkifyUtil a = (FeedLinkifyUtil)FbInjector.a(getContext()).a(FeedLinkifyUtil.class);
  private TimelineFriendDialog b = null;

  public UserTimelineHeaderView(Context paramContext, SecureContextHelper paramSecureContextHelper, FragmentManager paramFragmentManager)
  {
    super(paramContext, paramSecureContextHelper, paramFragmentManager);
  }

  private View a(int paramInt)
  {
    ViewGroup localViewGroup = (ViewGroup)getInflater().inflate(2130903596, null);
    ((TextView)localViewGroup.findViewById(2131297901)).setText(a(getContext(), paramInt));
    return localViewGroup;
  }

  private View a(List<GraphQLProfile> paramList, TimelineAppSection.AppSectionType paramAppSectionType)
  {
    int i = 0;
    Object localObject;
    int j;
    switch (paramList.size())
    {
    default:
      localObject = (ViewGroup)getInflater().inflate(2130903591, null);
      j = 0;
    case 0:
      while (j < 6)
      {
        a((ViewGroup)localObject, j, (GraphQLProfile)paramList.get(j), false);
        j++;
        continue;
        localObject = null;
      }
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    }
    while (true)
    {
      return localObject;
      localObject = a(((GraphQLProfile)paramList.get(0)).facepileSingle.uri, null);
      continue;
      localObject = (ViewGroup)getInflater().inflate(2130903589, null);
      while (i < 2)
      {
        a((ViewGroup)localObject, i, (GraphQLProfile)paramList.get(i), true);
        i++;
      }
      localObject = (ViewGroup)getInflater().inflate(2130903590, null);
      a((ViewGroup)localObject, 0, (GraphQLProfile)paramList.get(0), true);
      a((ViewGroup)localObject, 1, (GraphQLProfile)paramList.get(1), false);
      a((ViewGroup)localObject, 2, (GraphQLProfile)paramList.get(2), false);
    }
  }

  private GraphQLProfileList a(TimelineAppSection.AppSectionType paramAppSectionType, TimelineHeaderData paramTimelineHeaderData)
  {
    GraphQLProfileList localGraphQLProfileList;
    switch (UserTimelineHeaderView.5.b[paramAppSectionType.ordinal()])
    {
    default:
      localGraphQLProfileList = null;
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      return localGraphQLProfileList;
      localGraphQLProfileList = paramTimelineHeaderData.w();
      continue;
      localGraphQLProfileList = paramTimelineHeaderData.x();
      continue;
      localGraphQLProfileList = paramTimelineHeaderData.y();
    }
  }

  private void a(ViewGroup paramViewGroup)
  {
    View localView = getInflater().inflate(2130903583, null);
    localView.setVisibility(4);
    paramViewGroup.addView(localView);
  }

  private void a(ViewGroup paramViewGroup, int paramInt, GraphQLProfile paramGraphQLProfile, boolean paramBoolean)
  {
    if (paramGraphQLProfile == null)
      return;
    Object localObject;
    if (paramBoolean)
    {
      if (paramGraphQLProfile.facepileLarge != null);
      for (String str2 = paramGraphQLProfile.facepileLarge.uri; ; str2 = null)
      {
        localObject = str2;
        label30: if (localObject == null)
          break label103;
        UrlImage localUrlImage = (UrlImage)Preconditions.checkNotNull((UrlImage)paramViewGroup.getChildAt(paramInt));
        Uri localUri = null;
        if (localObject != null)
          localUri = Uri.parse((String)localObject);
        localUrlImage.setImageParams(localUri);
        break;
      }
    }
    if (paramGraphQLProfile.facepileSmall != null);
    for (String str1 = paramGraphQLProfile.facepileSmall.uri; ; str1 = null)
    {
      localObject = str1;
      break label30;
      label103: break;
    }
  }

  private void a(ViewGroup paramViewGroup, TimelineBylineFragment paramTimelineBylineFragment)
  {
    View localView = getInflater().inflate(2130903583, null);
    if ((paramTimelineBylineFragment.icon == null) || (paramTimelineBylineFragment.text == null));
    while (true)
    {
      return;
      ((UrlImage)localView.findViewById(2131297881)).setImageParams(Uri.parse(paramTimelineBylineFragment.icon.uri));
      TextView localTextView = (TextView)localView.findViewById(2131297882);
      localTextView.setMovementMethod(LinkMovementMethod.getInstance());
      localTextView.setText(this.a.a(paramTimelineBylineFragment.text));
      paramViewGroup.addView(localView);
    }
  }

  public static boolean a(TimelineHeaderData.UserFriendshipStatus paramUserFriendshipStatus)
  {
    if (paramUserFriendshipStatus != TimelineHeaderData.UserFriendshipStatus.CANNOT_REQUEST);
    for (int i = 1; ; i = 0)
      return i;
  }

  private String getFriendButtonText()
  {
    String str;
    switch (UserTimelineHeaderView.5.a[getHeaderData().u().ordinal()])
    {
    default:
      str = null;
    case 1:
    case 2:
    case 3:
    case 4:
    }
    while (true)
    {
      return str;
      str = getContext().getString(2131361805);
      continue;
      str = getContext().getString(2131361806);
      continue;
      str = getContext().getString(2131361808);
      continue;
      str = getContext().getString(2131361807);
    }
  }

  private void m()
  {
    ViewGroup localViewGroup = (ViewGroup)Preconditions.checkNotNull(findViewById(2131297661));
    localViewGroup.removeAllViews();
    TimelineHeaderData localTimelineHeaderData = getHeaderData();
    if (localTimelineHeaderData.s())
      for (int i = 0; i < 3; i++)
        a(localViewGroup);
    List localList = localTimelineHeaderData.t();
    if (localList == null)
      BLog.d(getClass(), "Missing timeline byline fragments");
    while (true)
    {
      return;
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
        a(localViewGroup, (TimelineBylineFragment)localIterator.next());
    }
  }

  private void n()
  {
    TimelineHeaderData localTimelineHeaderData = getHeaderData();
    ViewGroup localViewGroup1 = (ViewGroup)findViewById(2131297939);
    if ((localTimelineHeaderData.f()) && (localTimelineHeaderData.C() > 0))
    {
      localViewGroup1.setVisibility(0);
      ((TextView)localViewGroup1.findViewById(2131297906)).setText(Integer.toString(localTimelineHeaderData.C()));
      ViewGroup localViewGroup2 = (ViewGroup)localViewGroup1.findViewById(2131297903);
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Long.valueOf(getHeaderData().d());
      localViewGroup2.setOnClickListener(new UserTimelineHeaderView.1(this, StringLocaleUtil.a("fb://profile/%s/approvalqueue", arrayOfObject)));
    }
    while (true)
    {
      return;
      localViewGroup1.setVisibility(8);
    }
  }

  private void o()
  {
    if ((this.b == null) && (!TimelineFriendDialog.b()))
    {
      this.b = new TimelineFriendDialog(getContext());
      TimelineHeaderFriendListData localTimelineHeaderFriendListData = getHeaderData().B();
      localTimelineHeaderFriendListData.a(new UserTimelineHeaderView.2(this));
      if (localTimelineHeaderFriendListData.a())
        p();
    }
  }

  private void p()
  {
    if (this.b != null)
    {
      this.b.a(getDataFetcher(), getFriendingClient(), getHeaderData());
      this.b.a(getFragmentManager());
    }
    this.b = null;
  }

  private void q()
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = getResources().getString(2131361819);
    arrayOfString[1] = getResources().getString(2131361820);
    new AlertDialog.Builder(getContext()).setItems(arrayOfString, new UserTimelineHeaderView.3(this)).show();
  }

  private void r()
  {
    ((TextView)b(2131297877)).setText(getFriendButtonText());
  }

  public int a(int paramInt1, int paramInt2)
  {
    float f;
    if (paramInt2 == 1)
      f = 1.221F;
    while (true)
    {
      return Math.round(paramInt1 / f);
      f = 2.702F;
    }
  }

  protected View a(TimelineAppSection paramTimelineAppSection)
  {
    TimelineHeaderData localTimelineHeaderData = getHeaderData();
    GraphQLProfileList localGraphQLProfileList = a(paramTimelineAppSection.a(), localTimelineHeaderData);
    Object localObject;
    if (localGraphQLProfileList != null)
      localObject = a(localGraphQLProfileList.profiles, paramTimelineAppSection.a());
    while (true)
    {
      return localObject;
      if (paramTimelineAppSection.a() == TimelineAppSection.AppSectionType.ABOUT)
      {
        localObject = (ImageView)getInflater().inflate(2130903592, null);
        if (localTimelineHeaderData.l() == TimelineHeaderData.Gender.FEMALE)
        {
          ((ImageView)localObject).setImageResource(2130838988);
          continue;
        }
        ((ImageView)localObject).setImageResource(2130838989);
        continue;
      }
      TimelineAppSection.AppSectionType localAppSectionType1 = paramTimelineAppSection.a();
      TimelineAppSection.AppSectionType localAppSectionType2 = TimelineAppSection.AppSectionType.SUBSCRIBERS;
      localObject = null;
      if (localAppSectionType1 != localAppSectionType2)
        continue;
      localObject = a(localTimelineHeaderData.z());
    }
  }

  protected String a(TimelineAppSection.AppSectionType paramAppSectionType)
  {
    if ((paramAppSectionType == TimelineAppSection.AppSectionType.PHOTOS) && (getHeaderData().f()));
    for (String str = "fb://albums"; ; str = super.a(paramAppSectionType))
      return str;
  }

  protected void a()
  {
    m();
    n();
  }

  protected boolean f()
  {
    return true;
  }

  protected void g()
  {
    super.g();
    if (getHeaderData().s());
    while (true)
    {
      return;
      TextView localTextView = (TextView)b(2131297877);
      if (localTextView == null)
        continue;
      TimelineHeaderData localTimelineHeaderData = getHeaderData();
      FriendingClient localFriendingClient = getFriendingClient().a();
      r();
      localTextView.setOnClickListener(new UserTimelineHeaderView.4(this, localTimelineHeaderData, localFriendingClient));
    }
  }

  protected int getHeaderLayoutResource()
  {
    return 2130903619;
  }

  protected CharSequence getNameCharSequence()
  {
    String str1 = getHeaderData().j();
    if (StringUtil.a(str1));
    SpannableStringBuilder localSpannableStringBuilder;
    for (Object localObject = null; ; localObject = localSpannableStringBuilder)
    {
      return localObject;
      localSpannableStringBuilder = new SpannableStringBuilder(str1);
      String str2 = getHeaderData().k();
      if ((StringUtil.a(str2)) || (str2.equals(str1)))
        continue;
      ((TextView)findViewById(2131297659)).setTypeface(null, 0);
      localSpannableStringBuilder.setSpan(new StyleSpan(1), 0, str1.length(), 33);
      localSpannableStringBuilder.append(" (" + str2 + ")");
      localSpannableStringBuilder.setSpan(new TextAppearanceSpan(getContext(), 2131492871), 1 + str1.length(), localSpannableStringBuilder.length(), 33);
    }
  }

  public boolean i()
  {
    return a(getHeaderData().u());
  }

  protected boolean j()
  {
    return getHeaderData().q();
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.UserTimelineHeaderView
 * JD-Core Version:    0.6.0
 */