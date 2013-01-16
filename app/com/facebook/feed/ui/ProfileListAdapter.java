package com.facebook.feed.ui;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.facebook.feed.data.AppendOnlyGraphQLObjectCollection;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.UrlImage;

public class ProfileListAdapter extends BaseAdapter
{
  private Context a;
  private AppendOnlyGraphQLObjectCollection<GraphQLProfile> b;
  private final LayoutInflater c;

  public ProfileListAdapter(Context paramContext, AppendOnlyGraphQLObjectCollection<GraphQLProfile> paramAppendOnlyGraphQLObjectCollection)
  {
    this.a = paramContext;
    this.b = paramAppendOnlyGraphQLObjectCollection;
    this.c = ((LayoutInflater)FbInjector.a(this.a).a(LayoutInflater.class));
  }

  public int getCount()
  {
    return this.b.c();
  }

  public Object getItem(int paramInt)
  {
    return this.b.a(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView != null)
    {
      localObject = (ProfileListAdapter.ProfileViewHolder)paramView.getTag();
      GraphQLProfile localGraphQLProfile = (GraphQLProfile)this.b.a(paramInt);
      if (!localGraphQLProfile.c())
        break label119;
      ((ProfileListAdapter.ProfileViewHolder)localObject).a.setImageParams(Uri.parse(localGraphQLProfile.profilePicture.uri));
      label53: if (localGraphQLProfile.name == null)
        break label134;
      ((ProfileListAdapter.ProfileViewHolder)localObject).b.setText(localGraphQLProfile.name);
      ((ProfileListAdapter.ProfileViewHolder)localObject).b.setVisibility(0);
    }
    while (true)
    {
      return paramView;
      paramView = this.c.inflate(2130903521, null);
      ProfileListAdapter.ProfileViewHolder localProfileViewHolder = new ProfileListAdapter.ProfileViewHolder(paramView);
      paramView.setTag(localProfileViewHolder);
      localObject = localProfileViewHolder;
      break;
      label119: ((ProfileListAdapter.ProfileViewHolder)localObject).a.setImageParams((Uri)null);
      break label53;
      label134: ((ProfileListAdapter.ProfileViewHolder)localObject).b.setVisibility(8);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.ProfileListAdapter
 * JD-Core Version:    0.6.0
 */