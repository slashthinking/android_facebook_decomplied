package com.facebook.timeline;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.intent.IFeedIntentBuilder;
import com.facebook.graphql.model.Feedback;
import com.facebook.graphql.model.GraphQLFocusedPhoto;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLObjectType.ObjectType;
import com.facebook.graphql.model.GraphQLPoint2D;
import com.facebook.graphql.model.TimelineAppSection;
import com.facebook.graphql.model.TimelineAppSection.AppSectionType;
import com.facebook.graphql.model.TimelineAppSectionList;
import com.facebook.ipc.composer.model.ComposerConstants;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.timeline.permissions.ProfilePermissions;
import com.facebook.timeline.permissions.ProfilePermissions.Permission;
import com.facebook.timeline.ui.TimelineSubscriberDialog;
import com.facebook.timeline.util.PhotoUtil;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.UrlImage;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;

public abstract class TimelineHeaderView extends CustomLinearLayout
{
  private static final Class<?> a = TimelineHeaderView.class;
  private final SecureContextHelper b;
  private final FragmentManager c;
  private TimelineHeaderData d;
  private TimelineHeaderData.InitializeState e = TimelineHeaderData.InitializeState.UNINITIALIZED;
  private TimelineDataFetcher f;
  private TimelineFriendingClient g;
  private LayoutInflater h;
  private IFeedIntentBuilder i;
  private int j;
  private String k = null;
  private int l = -1;
  private int m = -1;
  private int n = -1;

  protected TimelineHeaderView(Context paramContext, SecureContextHelper paramSecureContextHelper, FragmentManager paramFragmentManager)
  {
    super(paramContext, null);
    this.b = ((SecureContextHelper)Preconditions.checkNotNull(paramSecureContextHelper));
    this.c = ((FragmentManager)Preconditions.checkNotNull(paramFragmentManager));
    setOrientation(1);
    setContentView(getHeaderLayoutResource());
    this.d = null;
    this.h = null;
    this.i = null;
    this.j = getContext().getResources().getConfiguration().orientation;
  }

  private View a(View paramView, int paramInt1, int paramInt2, int paramInt3, Intent paramIntent)
  {
    View localView = paramView.findViewById(paramInt1);
    ((TextView)localView.findViewById(paramInt3)).setText(paramInt2);
    localView.setContentDescription(getContext().getString(paramInt2));
    localView.setClickable(true);
    localView.setOnClickListener(new TimelineHeaderView.8(this, paramIntent));
    return localView;
  }

  private View a(LinearLayout paramLinearLayout, String paramString1, String paramString2, View paramView)
  {
    View localView1 = getInflater().inflate(2130903588, null);
    View localView2 = a(localView1, 2131297889, paramString1);
    FrameLayout localFrameLayout = (FrameLayout)localView1.findViewById(2131297887);
    if (paramView != null)
      localFrameLayout.addView(paramView, 0);
    View localView3 = localView1.findViewById(2131297888);
    localView3.setContentDescription(paramString1);
    if (paramString2 != null)
    {
      TimelineHeaderView.7 local7 = new TimelineHeaderView.7(this, paramString2);
      localView3.setOnClickListener(local7);
      localView2.setOnClickListener(local7);
    }
    paramLinearLayout.addView(localView1);
    return localView1;
  }

  private View a(GraphQLImage paramGraphQLImage)
  {
    ViewGroup localViewGroup = (ViewGroup)getInflater().inflate(2130903594, null);
    if ((paramGraphQLImage != null) && (paramGraphQLImage.uri != null))
    {
      UrlImage localUrlImage = (UrlImage)localViewGroup.findViewById(2131297898);
      localUrlImage.setImageParams(Uri.parse(paramGraphQLImage.uri));
      localUrlImage.setVisibility(0);
    }
    while (true)
    {
      return localViewGroup;
      ((ImageView)localViewGroup.findViewById(2131297899)).setVisibility(0);
    }
  }

  private View a(String paramString)
  {
    UrlImage localUrlImage = (UrlImage)getInflater().inflate(2130903595, null);
    Uri localUri = null;
    if (paramString != null)
      localUri = Uri.parse(paramString);
    localUrlImage.setImageParams(localUri);
    return localUrlImage;
  }

  public static TimelineHeaderView a(Context paramContext, SecureContextHelper paramSecureContextHelper, FragmentManager paramFragmentManager, GraphQLObjectType.ObjectType paramObjectType)
  {
    if ((paramObjectType == GraphQLObjectType.ObjectType.User) || (paramObjectType == GraphQLObjectType.ObjectType.Invalid));
    for (Object localObject = new UserTimelineHeaderView(paramContext, paramSecureContextHelper, paramFragmentManager); ; localObject = new PageTimelineHeaderView(paramContext, paramSecureContextHelper, paramFragmentManager))
    {
      return localObject;
      if (paramObjectType != GraphQLObjectType.ObjectType.Page)
        break;
    }
    throw new RuntimeException("Unhandled timeline view object type: " + paramObjectType);
  }

  private static String a(float paramFloat)
  {
    Object[] arrayOfObject2;
    if (paramFloat < 10.0F)
    {
      arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Float.valueOf(paramFloat);
    }
    Object[] arrayOfObject1;
    for (String str = StringLocaleUtil.a("%.1f", arrayOfObject2); ; str = StringLocaleUtil.a("%.0f", arrayOfObject1))
    {
      return str;
      arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Float.valueOf(paramFloat);
    }
  }

  protected static String a(Context paramContext, int paramInt)
  {
    String str = "";
    if (paramInt < 0);
    while (true)
    {
      return str;
      if (paramInt < 1000)
      {
        str = "" + paramInt;
        continue;
      }
      if (paramInt < 1000000)
      {
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = a(paramInt / 1000.0F);
        str = paramContext.getString(2131361796, arrayOfObject2);
        continue;
      }
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = a(paramInt / 1000000.0F);
      str = paramContext.getString(2131361797, arrayOfObject1);
    }
  }

  private void a(UrlImage paramUrlImage, GraphQLFocusedPhoto paramGraphQLFocusedPhoto, int paramInt)
  {
    b(paramUrlImage, getScreenWidth(), paramInt, this.l, this.m, paramGraphQLFocusedPhoto.focus.x, paramGraphQLFocusedPhoto.focus.y);
  }

  private View b(TimelineAppSection paramTimelineAppSection)
  {
    View localView = a(paramTimelineAppSection);
    if (localView != null);
    while (true)
    {
      return localView;
      TimelineHeaderData localTimelineHeaderData = getHeaderData();
      if (paramTimelineAppSection.a() == TimelineAppSection.AppSectionType.PHOTOS)
      {
        GraphQLFocusedPhoto localGraphQLFocusedPhoto = localTimelineHeaderData.A();
        if ((localGraphQLFocusedPhoto != null) && (localGraphQLFocusedPhoto.photo != null) && (localGraphQLFocusedPhoto.photo.image != null) && (localGraphQLFocusedPhoto.photo.image.uri != null))
        {
          localView = a(localGraphQLFocusedPhoto.photo.image.uri, localGraphQLFocusedPhoto.focus);
          continue;
        }
      }
      else
      {
        if (paramTimelineAppSection.a() == TimelineAppSection.AppSectionType.MAP)
        {
          localView = a(paramTimelineAppSection.logo);
          continue;
        }
        if ((paramTimelineAppSection.logo != null) && (paramTimelineAppSection.logo.uri != null))
        {
          localView = a(paramTimelineAppSection.logo.uri);
          continue;
        }
      }
      localView = null;
    }
  }

  private UrlImage b(View paramView, int paramInt, String paramString)
  {
    UrlImage localUrlImage = (UrlImage)Preconditions.checkNotNull((UrlImage)paramView.findViewById(paramInt));
    if (paramString != null)
      localUrlImage.setImageParams(Uri.parse(paramString));
    while (true)
    {
      return localUrlImage;
      localUrlImage.setImageParams((Uri)null);
    }
  }

  private static void b(UrlImage paramUrlImage, int paramInt1, int paramInt2, int paramInt3, int paramInt4, double paramDouble1, double paramDouble2)
  {
    Matrix localMatrix = PhotoUtil.a(paramInt1, paramInt2, paramInt3, paramInt4, paramDouble1, paramDouble2);
    paramUrlImage.setScaleType(ImageView.ScaleType.MATRIX);
    paramUrlImage.setImageMatrix(localMatrix);
  }

  private long getAudienceId()
  {
    TimelineHeaderData localTimelineHeaderData = getHeaderData();
    long l1;
    if (localTimelineHeaderData.f())
      l1 = -1L;
    while (true)
    {
      return l1;
      l1 = localTimelineHeaderData.d();
    }
  }

  private Intent getCheckinIntent()
  {
    Intent localIntent = getIntentBuilder().b(null, null, getAudienceId());
    localIntent.putExtra("nectar_module", "timeline_composer");
    return localIntent;
  }

  private int getScreenWidth()
  {
    return ((WindowManager)getInjector().a(WindowManager.class)).getDefaultDisplay().getWidth();
  }

  private String getSubscribeButtonText()
  {
    String str;
    switch (TimelineHeaderView.9.a[this.d.v().ordinal()])
    {
    default:
      str = null;
    case 1:
    case 2:
    }
    while (true)
    {
      return str;
      str = getContext().getString(2131361810);
      continue;
      str = getContext().getString(2131361812);
    }
  }

  private void m()
  {
    TextView localTextView = (TextView)findViewById(2131297659);
    CharSequence localCharSequence = getNameCharSequence();
    if (!StringUtil.a(localCharSequence))
    {
      localTextView.setText(localCharSequence);
      if (localCharSequence.length() > 20)
        localTextView.setTextSize(15.0F);
    }
  }

  private void n()
  {
    GraphQLImage localGraphQLImage = getHeaderData().i();
    String str = null;
    if (localGraphQLImage != null)
      str = localGraphQLImage.uri;
    b(this, 2131297658, str);
    GraphQLMedia localGraphQLMedia = getHeaderData().h();
    if (localGraphQLMedia != null)
    {
      View localView = findViewById(2131297908);
      if ((localView != null) && (f()))
      {
        localView.setVisibility(0);
        localView.setOnClickListener(new TimelineHeaderView.1(this, localGraphQLMedia));
      }
    }
  }

  private void o()
  {
    GraphQLFocusedPhoto localGraphQLFocusedPhoto = getHeaderData().m();
    int i1 = a(getScreenWidth(), this.j);
    UrlImage localUrlImage = (UrlImage)Preconditions.checkNotNull((UrlImage)findViewById(2131297883));
    GraphQLImage localGraphQLImage;
    if ((localGraphQLFocusedPhoto != null) && (localGraphQLFocusedPhoto.photo != null))
      if (this.j == 1)
      {
        localGraphQLImage = localGraphQLFocusedPhoto.photo.imagePortrait;
        if ((localGraphQLImage != null) && (localGraphQLImage.uri != null))
        {
          if ((this.l <= -1) || (this.m <= -1) || (!localGraphQLImage.uri.equals(this.k)))
            break label198;
          a(localUrlImage, localGraphQLFocusedPhoto, i1);
          localUrlImage.setOnImageDownloadListener(null);
          label122: localUrlImage.setImageParams(Uri.parse(localGraphQLImage.uri));
          if (f())
          {
            View localView = findViewById(2131297884);
            localView.setVisibility(0);
            localView.setOnClickListener(new TimelineHeaderView.3(this, localGraphQLFocusedPhoto, localGraphQLImage));
          }
        }
      }
    while (true)
    {
      localUrlImage.setLayoutParams(new FrameLayout.LayoutParams(-1, i1));
      return;
      localGraphQLImage = localGraphQLFocusedPhoto.photo.imageLandscape;
      break;
      label198: localUrlImage.setOnImageDownloadListener(new TimelineHeaderView.2(this, localGraphQLImage, localUrlImage, localGraphQLFocusedPhoto, i1));
      break label122;
      this.l = -1;
      this.m = -1;
      this.k = null;
      localUrlImage.setImageParams((Uri)null);
    }
  }

  private void p()
  {
    TimelineHeaderData localTimelineHeaderData = getHeaderData();
    LinearLayout localLinearLayout = (LinearLayout)b(2131297902);
    localLinearLayout.removeAllViews();
    if (localTimelineHeaderData.s())
      a(localLinearLayout, null, null, null).setVisibility(4);
    while (true)
    {
      return;
      if (this.d.g())
      {
        View localView2 = q();
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = Long.valueOf(this.d.d());
        String str3 = StringLocaleUtil.a("fb://insights/%s", arrayOfObject2);
        a(localLinearLayout, getContext().getString(2131361795), str3, localView2);
      }
      TimelineAppSectionList localTimelineAppSectionList = localTimelineHeaderData.n();
      for (int i1 = 0; (localTimelineAppSectionList != null) && (i1 < localTimelineAppSectionList.sections.size()); i1++)
      {
        TimelineAppSection localTimelineAppSection = (TimelineAppSection)localTimelineAppSectionList.sections.get(i1);
        String str2 = a(localTimelineAppSection.a());
        if (str2 == null)
          str2 = localTimelineAppSection.url;
        if (str2 == null)
          continue;
        View localView1 = b(localTimelineAppSection);
        if (localView1 == null)
          continue;
        a(localLinearLayout, localTimelineAppSection.name, str2, localView1);
      }
      if (localTimelineHeaderData.r())
      {
        ImageView localImageView = (ImageView)getInflater().inflate(2130903592, null);
        localImageView.setImageResource(2130838971);
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = Long.valueOf(localTimelineHeaderData.d());
        String str1 = StringLocaleUtil.a("fb://profile/%s/activitylog", arrayOfObject1);
        a(localLinearLayout, getContext().getString(2131361793), str1, localImageView);
      }
      r();
    }
  }

  private View q()
  {
    String str = a(getContext(), this.d.D());
    ViewGroup localViewGroup = (ViewGroup)getInflater().inflate(2130903593, null);
    ((TextView)localViewGroup.findViewById(2131297897)).setText(str);
    return localViewGroup;
  }

  private void r()
  {
    TimelineHeaderData localTimelineHeaderData = getHeaderData();
    View localView = findViewById(2131296905);
    if (!e())
      localView.setVisibility(8);
    while (true)
    {
      return;
      localView.setVisibility(0);
      ArrayList localArrayList = new ArrayList();
      int i1 = 2131362127;
      label57: int i3;
      if (localTimelineHeaderData.f())
      {
        i1 = 2131362103;
        localArrayList.add(a(localView, 2131297765, i1, 2131297767, getStatusIntent()));
        if (!d())
          break label228;
        if (!localTimelineHeaderData.f())
          break label220;
        i3 = 2131362104;
        label100: localArrayList.add(a(localView, 2131297768, i3, 2131297770, getPhotoIntent()));
        label124: if (!localTimelineHeaderData.f())
          break label243;
        localArrayList.add(a(localView, 2131297771, 2131362105, 2131297773, getCheckinIntent()));
      }
      while (true)
      {
        if (localArrayList.size() != 1)
          break label258;
        ((View)localArrayList.get(0)).setBackgroundResource(2130837721);
        break;
        if ((!localTimelineHeaderData.H()) || (localTimelineHeaderData.I() == null) || (!localTimelineHeaderData.I().a(ProfilePermissions.Permission.CREATE_CONTENT)))
          break label57;
        i1 = 2131361968;
        break label57;
        label220: i3 = 2131362125;
        break label100;
        label228: localView.findViewById(2131297768).setVisibility(8);
        break label124;
        label243: localView.findViewById(2131297771).setVisibility(8);
      }
      label258: if (localArrayList.size() <= 1)
        continue;
      ((View)localArrayList.get(0)).setBackgroundResource(2130837709);
      for (int i2 = 1; i2 < -1 + localArrayList.size(); i2++)
        ((View)localArrayList.get(i2)).setBackgroundResource(2130837712);
      ((View)localArrayList.get(-1 + localArrayList.size())).setBackgroundResource(2130837718);
    }
  }

  private void s()
  {
    if (!TimelineSubscriberDialog.b())
    {
      TimelineSubscriberDialog localTimelineSubscriberDialog = new TimelineSubscriberDialog(getContext());
      localTimelineSubscriberDialog.a(getDataFetcher(), getFriendingClient(), getHeaderData());
      localTimelineSubscriberDialog.a(getFragmentManager());
    }
  }

  protected abstract int a(int paramInt1, int paramInt2);

  protected View a(View paramView, int paramInt, String paramString)
  {
    TextView localTextView = (TextView)Preconditions.checkNotNull((TextView)paramView.findViewById(paramInt));
    if (paramString != null)
      localTextView.setText(StringUtil.b(paramString));
    while (true)
    {
      return localTextView;
      localTextView.setText("");
    }
  }

  protected abstract View a(TimelineAppSection paramTimelineAppSection);

  protected View a(String paramString, GraphQLPoint2D paramGraphQLPoint2D)
  {
    UrlImage localUrlImage = (UrlImage)getInflater().inflate(2130903595, null);
    Resources localResources = getContext().getResources();
    if (paramGraphQLPoint2D != null)
      localUrlImage.setOnImageDownloadListener(new TimelineHeaderView.FocusedImageDownloadListener(localUrlImage, localResources.getDimensionPixelSize(2131230766), localResources.getDimensionPixelSize(2131230767), paramGraphQLPoint2D.x, paramGraphQLPoint2D.y));
    if (paramString != null);
    for (Uri localUri = Uri.parse(paramString); ; localUri = null)
    {
      localUrlImage.setImageParams(localUri);
      return localUrlImage;
    }
  }

  protected String a(TimelineAppSection.AppSectionType paramAppSectionType)
  {
    return null;
  }

  protected abstract void a();

  protected void a(GraphQLMedia paramGraphQLMedia, String paramString)
  {
    if (!f());
    while (true)
    {
      return;
      if ((paramGraphQLMedia != null) && (paramGraphQLMedia.id != null))
      {
        Intent localIntent = this.i.a(Long.parseLong(paramGraphQLMedia.id), paramString, paramGraphQLMedia.S().d(), null, null);
        if (localIntent == null)
          continue;
        this.b.a(localIntent, getContext());
        continue;
      }
    }
  }

  public void a(TimelineHeaderData paramTimelineHeaderData, TimelineDataFetcher paramTimelineDataFetcher, TimelineFriendingClient paramTimelineFriendingClient, LayoutInflater paramLayoutInflater, IFeedIntentBuilder paramIFeedIntentBuilder)
  {
    int i1;
    if ((paramTimelineHeaderData != null) && (this.d != paramTimelineHeaderData))
    {
      i1 = 1;
      this.d = paramTimelineHeaderData;
      this.f = paramTimelineDataFetcher;
      this.g = paramTimelineFriendingClient;
      this.h = paramLayoutInflater;
      this.i = paramIFeedIntentBuilder;
      int i2 = getContext().getResources().getConfiguration().orientation;
      if ((i1 != 0) || (this.j != i2) || (this.n < this.d.b()))
      {
        this.j = i2;
        m();
        n();
        o();
        g();
        p();
        a();
        if (Build.VERSION.SDK_INT >= 11)
        {
          if (!this.d.s())
            break label169;
          if (getLayoutTransition() == null)
            setLayoutTransition(new LayoutTransition());
        }
      }
    }
    while (true)
    {
      this.n = this.d.b();
      return;
      i1 = 0;
      break;
      label169: setLayoutTransition(null);
    }
  }

  protected boolean b()
  {
    TimelineHeaderData localTimelineHeaderData = getHeaderData();
    if ((localTimelineHeaderData.u() != TimelineHeaderData.UserFriendshipStatus.ARE_FRIENDS) && (localTimelineHeaderData.v() != TimelineHeaderData.SubscribeStatus.CANNOT_SUBSCRIBE));
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  protected boolean c()
  {
    if ((!i()) || (!b()));
    for (int i1 = 1; ; i1 = 0)
      return i1;
  }

  protected boolean d()
  {
    return true;
  }

  protected boolean e()
  {
    return getHeaderData().p();
  }

  protected abstract boolean f();

  protected void g()
  {
    int i1 = 1;
    TimelineHeaderData localTimelineHeaderData = getHeaderData();
    View localView1 = b(2131297876);
    if (localTimelineHeaderData.f())
      localView1.setVisibility(8);
    while (true)
    {
      return;
      if (localTimelineHeaderData.s())
      {
        localView1.setVisibility(4);
        continue;
      }
      View localView2 = b(2131297877);
      int i2;
      label69: View localView3;
      int i3;
      label111: TextView localTextView1;
      int i4;
      label169: label198: TextView localTextView2;
      if (i())
      {
        localView2.setVisibility(0);
        i2 = i1;
        localView3 = b(2131297878);
        if (!b())
          break label262;
        localView3.setVisibility(0);
        h();
        localView3.setOnClickListener(new TimelineHeaderView.4(this));
        i3 = i1;
        localTextView1 = (TextView)b(2131297879);
        if (!c())
          break label284;
        localTextView1.setVisibility(0);
        localTextView1.setEnabled(this.d.o());
        Resources localResources = getResources();
        if (!this.d.o())
          break label276;
        i4 = 2131165194;
        localTextView1.setTextColor(localResources.getColor(i4));
        localTextView1.setOnClickListener(new TimelineHeaderView.5(this, localTimelineHeaderData));
        i3 = i1;
        localTextView2 = (TextView)b(2131297880);
        if (!j())
          break label294;
        localTextView2.setVisibility(0);
        localTextView2.setOnClickListener(new TimelineHeaderView.6(this, localTimelineHeaderData));
      }
      while (true)
      {
        if (i1 == 0)
          break label307;
        localView1.setVisibility(0);
        break;
        localView2.setVisibility(8);
        i2 = 0;
        break label69;
        label262: localView3.setVisibility(8);
        i3 = i2;
        break label111;
        label276: i4 = 2131165195;
        break label169;
        label284: localTextView1.setVisibility(8);
        break label198;
        label294: localTextView2.setVisibility(8);
        i1 = i3;
      }
      label307: localView1.setVisibility(8);
    }
  }

  protected TimelineDataFetcher getDataFetcher()
  {
    return this.f;
  }

  protected FragmentManager getFragmentManager()
  {
    return this.c;
  }

  protected TimelineFriendingClient getFriendingClient()
  {
    return this.g;
  }

  protected TimelineHeaderData getHeaderData()
  {
    return this.d;
  }

  protected abstract int getHeaderLayoutResource();

  protected LayoutInflater getInflater()
  {
    return this.h;
  }

  protected IFeedIntentBuilder getIntentBuilder()
  {
    return this.i;
  }

  protected CharSequence getNameCharSequence()
  {
    return getHeaderData().j();
  }

  protected Intent getPhotoIntent()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("nectar_module", "timeline_composer");
    IFeedIntentBuilder localIFeedIntentBuilder = this.i;
    long l1 = getHeaderData().d();
    if (getHeaderData().d() == getHeaderData().c());
    for (boolean bool = true; ; bool = false)
      return localIFeedIntentBuilder.a(l1, bool, a.getSimpleName(), localBundle);
  }

  protected Intent getStatusIntent()
  {
    Intent localIntent = getIntentBuilder().a(null, null, getAudienceId());
    localIntent.putExtra(ComposerConstants.c, true);
    localIntent.putExtra(ComposerConstants.b, true);
    localIntent.putExtra("nectar_module", "timeline_composer");
    return localIntent;
  }

  protected void h()
  {
    ((TextView)findViewById(2131297878)).setText(getSubscribeButtonText());
  }

  protected boolean i()
  {
    return false;
  }

  protected boolean j()
  {
    return false;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.TimelineHeaderView
 * JD-Core Version:    0.6.0
 */