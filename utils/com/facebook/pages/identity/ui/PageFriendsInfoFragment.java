package com.facebook.pages.identity.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.model.PageFriendsHereNow;
import com.facebook.graphql.model.PageFriendsWhoLike;
import com.facebook.graphql.model.PageFriendsWhoVisited;
import com.facebook.orca.activity.OrcaFragment;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.inject.FbInjector;
import com.facebook.uri.FbUriIntentHandler;
import com.google.common.base.Preconditions;

public class PageFriendsInfoFragment extends OrcaFragment
{
  private static final Class<?> a = PageFriendsInfoFragment.class;
  private SecureContextHelper Y;
  private PageFriendsInfoFragment.OnFriendRowClickedListener b;
  private ListView c;
  private PageFriendsInfoAdapter d;
  private PageFriendsWhoLike e;
  private PageFriendsWhoVisited f;
  private PageFriendsHereNow g;
  private Context h;
  private FbUriIntentHandler i;

  private void a(String paramString)
  {
    Preconditions.checkNotNull(paramString);
    if ((this.b != null) && (!this.b.a(paramString)))
    {
      BLog.e(a, "Failed handle friend info row click event");
      throw new RuntimeException("Failed rhandle friend info row click event");
    }
  }

  public View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(2130903221, paramViewGroup, false);
    this.c = ((ListView)localView.findViewById(2131296953));
    this.d = new PageFriendsInfoAdapter(p());
    this.c.setAdapter(this.d);
    this.c.setOnItemClickListener(new PageFriendsInfoFragment.1(this));
    return localView;
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    n().getIntent().getParcelableArrayExtra("android.intent.extra.SUBJECT");
    Intent localIntent = n().getIntent();
    if (localIntent.hasExtra("friends_here_now"))
      this.g = ((PageFriendsHereNow)localIntent.getParcelableExtra("friends_here_now"));
    if (localIntent.hasExtra("friends_who_like"))
      this.e = ((PageFriendsWhoLike)localIntent.getParcelableExtra("friends_who_like"));
    if (localIntent.hasExtra("friends_who_visited"))
      this.f = ((PageFriendsWhoVisited)localIntent.getParcelableExtra("friends_who_visited"));
    if ((this.g != null) || (this.e != null) || (this.f != null));
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool, "Missing friends info in intent");
      this.h = p();
      this.i = ((FbUriIntentHandler)FbInjector.a(this.h).a(FbUriIntentHandler.class));
      this.Y = ((SecureContextHelper)FbInjector.a(this.h).a(SecureContextHelper.class));
      return;
    }
  }

  public void a(PageFriendsInfoFragment.OnFriendRowClickedListener paramOnFriendRowClickedListener)
  {
    this.b = paramOnFriendRowClickedListener;
  }

  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    if (this.g != null)
      this.d.a(e(2131361871), this.g.friends);
    if (this.f != null)
      this.d.a(e(2131361869), this.f.friends);
    if (this.e != null)
      this.d.a(e(2131361870), this.e.friends);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.pages.identity.ui.PageFriendsInfoFragment
 * JD-Core Version:    0.6.2
 */