package com.facebook.katana.friendrequests;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.friends.FriendRequestResponse;
import com.facebook.friends.FriendRequestState;
import com.facebook.friends.model.FriendRequest;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLMutualFriends;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.katana.annotations.IsFullscreenJewelsEnabled;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.UrlImage;
import java.util.List;

public class FriendRequestView extends CustomRelativeLayout
{
  private static final Class<?> a = FriendRequestView.class;
  private final UrlImage b;
  private final TextView c;
  private final TextView d;
  private final Button e;
  private final Button f;
  private final View g;
  private final View h;
  private final View i;
  private final View j;
  private final View k;
  private FriendRequestView.OnResponseListener l;
  private FriendRequestView.OnRequestListener m;
  private FriendRequestView.OnIgnoreListener n;
  private FriendRequest o;
  private final boolean p;
  private boolean q = false;
  private boolean r = false;

  public FriendRequestView(Context paramContext)
  {
    this(paramContext, null);
  }

  public FriendRequestView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public FriendRequestView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, 0);
    this.p = ((Boolean)FbInjector.a(paramContext).a(Boolean.class, IsFullscreenJewelsEnabled.class)).booleanValue();
    int i1;
    if (this.p)
    {
      i1 = 2130903232;
      setContentView(i1);
      this.c = ((TextView)b(2131296978));
      this.b = ((UrlImage)b(2131296977));
      this.e = ((Button)b(2131296980));
      this.f = ((Button)b(2131296981));
      this.g = b(2131296979);
      this.h = b(2131296982);
      this.i = b(2131296984);
      if (!this.p)
        break label213;
      this.d = ((TextView)b(2131296987));
      this.j = b(2131296988);
    }
    for (this.k = b(2131296986); ; this.k = null)
    {
      this.e.setOnClickListener(a(FriendRequestResponse.CONFIRM));
      this.f.setOnClickListener(a(FriendRequestResponse.IGNORE));
      return;
      i1 = 2130903231;
      break;
      label213: this.d = null;
      this.j = null;
    }
  }

  private View.OnClickListener a()
  {
    return new FriendRequestView.2(this);
  }

  private View.OnClickListener a(FriendRequestResponse paramFriendRequestResponse)
  {
    return new FriendRequestView.1(this, paramFriendRequestResponse);
  }

  private static void a(View paramView, FriendRequestState paramFriendRequestState1, FriendRequestState paramFriendRequestState2)
  {
    if (paramFriendRequestState1 == paramFriendRequestState2);
    for (int i1 = 0; ; i1 = 8)
    {
      paramView.setVisibility(i1);
      return;
    }
  }

  private void a(FriendRequestState paramFriendRequestState)
  {
    a(this.h, paramFriendRequestState, FriendRequestState.ACCEPTED);
    a(this.i, paramFriendRequestState, FriendRequestState.IGNORED);
    a(this.g, paramFriendRequestState, FriendRequestState.NEEDS_RESPONSE);
    switch (FriendRequestView.4.a[paramFriendRequestState.ordinal()])
    {
    default:
      if (!this.o.a)
        break;
    case 1:
    case 2:
    }
    for (int i1 = 2130838270; ; i1 = 0)
    {
      this.c.setTextColor(getResources().getColor(2131165511));
      while (true)
      {
        setBackgroundResource(i1);
        if ((this.p) && (paramFriendRequestState != FriendRequestState.NEEDS_RESPONSE))
          this.d.setVisibility(8);
        if ((this.p) && (this.r))
          this.k.setBackgroundResource(i1);
        return;
        i1 = 2131165429;
        continue;
        i1 = 2131165430;
        this.c.setTextColor(getResources().getColor(2131165427));
      }
    }
  }

  private View.OnClickListener b()
  {
    return new FriendRequestView.3(this);
  }

  private void b(FriendRequest paramFriendRequest)
  {
    int i3;
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramFriendRequest.a())
      if ((paramFriendRequest.suggesters != null) && (!paramFriendRequest.suggesters.isEmpty()))
      {
        Resources localResources2 = getResources();
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = ((GraphQLProfile)paramFriendRequest.suggesters.get(0)).name;
        String str2 = localResources2.getString(2131363145, arrayOfObject2);
        this.d.setText(str2);
        this.d.setVisibility(0);
        i3 = getResources().getDimensionPixelSize(2131230966);
        localLayoutParams = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
        if (this.d.getVisibility() != 8)
          break label272;
        localLayoutParams.bottomMargin = (i3 * 2);
        localLayoutParams.topMargin = (i3 * 3);
        label139: this.c.setLayoutParams(localLayoutParams);
        if (!this.q)
          break label288;
        this.j.setVisibility(0);
        label163: if (!this.r)
          break label307;
        this.k.setVisibility(0);
      }
    while (true)
    {
      return;
      this.d.setVisibility(8);
      break;
      int i1 = paramFriendRequest.profile.mutualFriends.count;
      Resources localResources1 = getResources();
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = Integer.valueOf(i1);
      String str1 = localResources1.getQuantityString(2131427359, i1, arrayOfObject1);
      this.d.setText(str1);
      TextView localTextView = this.d;
      if (i1 > 0);
      for (int i2 = 0; ; i2 = 8)
      {
        localTextView.setVisibility(i2);
        break;
      }
      label272: localLayoutParams.bottomMargin = 0;
      localLayoutParams.topMargin = i3;
      break label139;
      label288: if (this.j == null)
        break label163;
      this.j.setVisibility(8);
      break label163;
      label307: if (this.j == null)
        continue;
      this.k.setVisibility(8);
    }
  }

  public void a(FriendRequest paramFriendRequest)
  {
    this.o = paramFriendRequest;
    this.c.setText(paramFriendRequest.profile.name);
    this.b.setImageParams(Uri.parse(paramFriendRequest.profile.profilePicture.uri));
    TextView localTextView1 = (TextView)this.i.findViewById(2131296985);
    TextView localTextView2 = (TextView)this.h.findViewById(2131296983);
    if (paramFriendRequest.a())
    {
      localTextView2.setText(getContext().getResources().getString(2131363133));
      this.e.setText(getContext().getResources().getString(2131363129));
      this.e.setOnClickListener(a());
      localTextView1.setText(getContext().getResources().getString(2131363140));
      this.f.setText(getContext().getResources().getString(2131363136));
      this.f.setOnClickListener(b());
    }
    while (true)
    {
      if (this.p)
        b(paramFriendRequest);
      a(paramFriendRequest.b);
      return;
      localTextView2.setText(getContext().getResources().getString(2131363132));
      this.e.setText(getContext().getResources().getString(2131363130));
      this.e.setOnClickListener(a(FriendRequestResponse.CONFIRM));
      localTextView1.setText(getContext().getResources().getString(2131363138));
      this.f.setText(getContext().getResources().getString(2131363137));
      this.f.setOnClickListener(a(FriendRequestResponse.IGNORE));
    }
  }

  public void setFirst(boolean paramBoolean)
  {
    this.r = paramBoolean;
  }

  public void setOnIgnoreListener(FriendRequestView.OnIgnoreListener paramOnIgnoreListener)
  {
    this.n = paramOnIgnoreListener;
  }

  public void setOnRequestListener(FriendRequestView.OnRequestListener paramOnRequestListener)
  {
    this.m = paramOnRequestListener;
  }

  public void setOnResponseListener(FriendRequestView.OnResponseListener paramOnResponseListener)
  {
    this.l = paramOnResponseListener;
  }

  public void setPressed(boolean paramBoolean)
  {
  }

  public void setShowDivider(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.friendrequests.FriendRequestView
 * JD-Core Version:    0.6.0
 */