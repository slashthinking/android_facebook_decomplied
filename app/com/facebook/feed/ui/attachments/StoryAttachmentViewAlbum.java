package com.facebook.feed.ui.attachments;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.feed.photos.AlbumIndexCache;
import com.facebook.feed.photos.NewsFeedPhotoAnimation;
import com.facebook.feed.photos.NewsFeedPhotoGallery;
import com.facebook.feed.prefs.FeedRendererOptions;
import com.facebook.feed.ui.FeedAdapterFactory;
import com.facebook.feed.ui.FeedImageLoader;
import com.facebook.feed.ui.FeedImageLoader.FeedImageType;
import com.facebook.feed.ui.NewsFeedImageAdapter;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.FeedStoryAttachment;
import com.facebook.graphql.model.Feedback;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.orca.inject.FbInjector;
import com.facebook.photos.annotation.IsNewGalleryEnabled;
import com.facebook.photos.photogallery.GalleryLauncher;
import com.facebook.photos.photogallery.GalleryLauncherHost;
import com.facebook.photos.photogallery.photogalleries.consumption.ConsumptionPhoto;
import com.facebook.photos.photogallery.photogalleries.consumption.ConsumptionPhotoDataAdapter;
import com.facebook.photos.photogallery.photogalleries.consumption.ConsumptionPhotoGalleryFragmentFactory;
import com.facebook.photos.photogallery.photosources.ListPhotoSource;
import com.facebook.photos.photogallery.photoviewcontrollers.NestedGalleryPhotoViewController;
import com.facebook.widget.ExpandablePhoto;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StoryAttachmentViewAlbum extends StoryAttachmentView
{
  private final Context e;
  private final NewsFeedPhotoGallery f;
  private final AnalyticsLogger g;
  private final FeedAdapterFactory h;
  private final AlbumIndexCache i;
  private List<FeedStoryAttachment> j;
  private ArrayNode k;
  private int l;
  private ExpandablePhoto m;
  private FeedStoryAttachment n;
  private FeedImageLoader o;
  private final boolean p;
  private List<ConsumptionPhoto> q;
  private NewsFeedPhotoAnimation r;
  private final FeedRendererOptions s;
  private String t;

  public StoryAttachmentViewAlbum(Context paramContext)
  {
    this(paramContext, null);
  }

  public StoryAttachmentViewAlbum(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    FbInjector localFbInjector = getInjector();
    this.e = paramContext;
    this.g = ((AnalyticsLogger)localFbInjector.a(AnalyticsLogger.class));
    this.r = ((NewsFeedPhotoAnimation)localFbInjector.a(NewsFeedPhotoAnimation.class));
    this.i = ((AlbumIndexCache)localFbInjector.a(AlbumIndexCache.class));
    this.m = ((ExpandablePhoto)((Activity)localFbInjector.a(Activity.class)).findViewById(2131296268));
    this.r = ((NewsFeedPhotoAnimation)localFbInjector.a(NewsFeedPhotoAnimation.class));
    setContentView(2130903163);
    this.f = ((NewsFeedPhotoGallery)b(2131296744));
    this.l = 0;
    this.j = null;
    this.k = null;
    this.f.setCallbackDuringFling(false);
    this.f.setOnItemSelectedListener(new StoryAttachmentViewAlbum.1(this));
    this.p = ((Boolean)localFbInjector.a(Boolean.class, IsNewGalleryEnabled.class)).booleanValue();
    if (this.p)
      this.f.setOnItemClickListener(new StoryAttachmentViewAlbum.2(this));
    this.s = ((FeedRendererOptions)localFbInjector.a(FeedRendererOptions.class));
    this.h = ((FeedAdapterFactory)localFbInjector.a(FeedAdapterFactory.class));
    this.o = ((FeedImageLoader)localFbInjector.a(FeedImageLoader.class));
  }

  private List<ConsumptionPhoto> a(List<FeedStoryAttachment> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      FeedStoryAttachment localFeedStoryAttachment = (FeedStoryAttachment)localIterator.next();
      Feedback localFeedback = localFeedStoryAttachment.media.S();
      if (localFeedStoryAttachment.a.message != null);
      for (String str = localFeedStoryAttachment.a.message.text; ; str = "")
      {
        ConsumptionPhoto localConsumptionPhoto = new ConsumptionPhoto(Long.parseLong(localFeedStoryAttachment.media.id), new ArrayList(), localFeedStoryAttachment.media.image.uri, localFeedStoryAttachment.media.image.width, localFeedStoryAttachment.media.image.height, 0, 0, str, localFeedback.a(), localFeedback.b(), localFeedback.canViewerLike, localFeedback.canViewerComment, localFeedback.doesViewerLike);
        localConsumptionPhoto.a(this.o.a(FeedImageLoader.FeedImageType.Album));
        localConsumptionPhoto.b(this.o.b(FeedImageLoader.FeedImageType.Album));
        localArrayList.add(localConsumptionPhoto);
        break;
      }
    }
    return localArrayList;
  }

  private void c(int paramInt)
  {
    NestedGalleryPhotoViewController localNestedGalleryPhotoViewController = new NestedGalleryPhotoViewController(((Activity)getContext()).getWindow(), this.f, new StoryAttachmentViewAlbum.3(this));
    ListPhotoSource localListPhotoSource = new ListPhotoSource(this.q);
    ConsumptionPhotoDataAdapter localConsumptionPhotoDataAdapter = (ConsumptionPhotoDataAdapter)getInjector().a(ConsumptionPhotoDataAdapter.class);
    ConsumptionPhotoGalleryFragmentFactory localConsumptionPhotoGalleryFragmentFactory = new ConsumptionPhotoGalleryFragmentFactory(localListPhotoSource, ((FragmentActivity)getContext()).g(), localConsumptionPhotoDataAdapter);
    GalleryLauncher localGalleryLauncher = ((GalleryLauncherHost)getContext()).n();
    localGalleryLauncher.a(localNestedGalleryPhotoViewController, localListPhotoSource, localConsumptionPhotoGalleryFragmentFactory);
    localGalleryLauncher.a(paramInt);
  }

  private void d()
  {
    NewsFeedImageAdapter localNewsFeedImageAdapter = this.h.a(this.f, this.n.subattachments);
    this.f.setAdapter(localNewsFeedImageAdapter);
    localNewsFeedImageAdapter.a(this.i.a(this.t));
    this.j = this.n.subattachments;
    this.l = 0;
    if ((this.f != null) && (this.n.subattachments != null))
      if (this.p)
        this.q = a(this.j);
    while (true)
    {
      return;
      this.r.a(this.m, this.f, this.n.subattachments, this.e, this.t, this.k);
      continue;
      this.q = null;
    }
  }

  public void a(FeedStoryAttachment paramFeedStoryAttachment, FeedStory paramFeedStory)
  {
    if (!this.s.a);
    while (true)
    {
      return;
      this.n = paramFeedStoryAttachment;
      this.t = paramFeedStory.getCacheId();
      d();
      this.k = paramFeedStory.k();
    }
  }

  public StoryAttachmentView.StoryAttachmentViewType getViewType()
  {
    return StoryAttachmentView.StoryAttachmentViewType.ALBUM;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.attachments.StoryAttachmentViewAlbum
 * JD-Core Version:    0.6.0
 */