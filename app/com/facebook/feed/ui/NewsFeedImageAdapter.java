package com.facebook.feed.ui;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import com.facebook.feed.photos.NewsFeedPhotoGallery;
import com.facebook.feed.prefs.FeedRendererOptions;
import com.facebook.graphql.model.FeedStoryAttachment;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.orca.images.FetchImageParams;
import com.facebook.orca.images.ImageCacheKey;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.UrlImage;
import java.util.List;

public class NewsFeedImageAdapter extends BaseAdapter
{
  private final List<FeedStoryAttachment> a;
  private final LayoutInflater b;
  private final FeedRendererOptions c;
  private final FeedImageLoader d;
  private final NewsFeedPhotoGallery e;

  public NewsFeedImageAdapter(Context paramContext, NewsFeedPhotoGallery paramNewsFeedPhotoGallery, FeedImageLoader paramFeedImageLoader, List<FeedStoryAttachment> paramList)
  {
    FbInjector localFbInjector = FbInjector.a(paramContext);
    this.b = LayoutInflater.from(paramContext);
    this.e = paramNewsFeedPhotoGallery;
    this.a = paramList;
    this.d = paramFeedImageLoader;
    this.c = ((FeedRendererOptions)localFbInjector.a(FeedRendererOptions.class));
  }

  private GraphQLImage a(int paramInt)
  {
    return ((FeedStoryAttachment)this.a.get(paramInt)).media.image;
  }

  private Uri b(int paramInt)
  {
    FeedStoryAttachment localFeedStoryAttachment;
    if ((this.a != null) && (paramInt >= 0) && (paramInt < this.a.size()))
    {
      localFeedStoryAttachment = (FeedStoryAttachment)this.a.get(paramInt);
      if ((localFeedStoryAttachment.media == null) || (localFeedStoryAttachment.media.image == null) || (localFeedStoryAttachment.media.image.uri == null));
    }
    for (Uri localUri = Uri.parse(localFeedStoryAttachment.media.image.uri); ; localUri = null)
      return localUri;
  }

  public UrlImage a(View paramView)
  {
    return ((NewsFeedImageAdapter.ViewHolder)paramView.getTag()).a;
  }

  public boolean a(Uri paramUri)
  {
    int i = 0;
    if (i < getCount())
      if ((b(i) == null) || (paramUri == null) || (!b(i).equals(paramUri)));
    while (true)
    {
      int j = 0;
      if (i > -1)
      {
        this.e.setSelection(i);
        j = 1;
      }
      return j;
      i++;
      break;
      i = -1;
    }
  }

  public boolean a(ImageCacheKey paramImageCacheKey)
  {
    return a(paramImageCacheKey.a());
  }

  public int getCount()
  {
    if (this.a == null);
    for (int i = 0; ; i = this.a.size())
      return i;
  }

  public Object getItem(int paramInt)
  {
    if ((this.a != null) && (paramInt >= 0) && (paramInt < this.a.size()));
    for (Object localObject = this.a.get(paramInt); ; localObject = null)
      return localObject;
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null);
    NewsFeedImageAdapter.ViewHolder localViewHolder;
    for (Object localObject = (NewsFeedImageAdapter.ViewHolder)paramView.getTag(); ; localObject = localViewHolder)
    {
      FetchImageParams localFetchImageParams = this.d.a(a(paramInt), FeedImageLoader.FeedImageType.Album);
      ((NewsFeedImageAdapter.ViewHolder)localObject).a.setImageParams(localFetchImageParams);
      Gallery.LayoutParams localLayoutParams = new Gallery.LayoutParams(this.d.a(FeedImageLoader.FeedImageType.Album), this.d.b(FeedImageLoader.FeedImageType.Album));
      ((NewsFeedImageAdapter.ViewHolder)localObject).a.setLayoutParams(localLayoutParams);
      return paramView;
      paramView = this.b.inflate(2130903161, null);
      localViewHolder = new NewsFeedImageAdapter.ViewHolder(null);
      localViewHolder.a = ((UrlImage)paramView.findViewById(2131296737));
      localViewHolder.a.setLoadResolutionDuringScroll(this.c.d);
      localViewHolder.a.setPlaceHolderDrawable(null);
      localViewHolder.a.setPlaceholderBackgroundResourceId(2131165264);
      paramView.setTag(localViewHolder);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.NewsFeedImageAdapter
 * JD-Core Version:    0.6.0
 */