package com.facebook.feed.ui.attachments;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.intent.IFeedIntentBuilder;
import com.facebook.feed.photos.NewsFeedPhotoAnimation;
import com.facebook.feed.prefs.FeedRendererOptions;
import com.facebook.feed.ui.FeedImageLoader;
import com.facebook.feed.ui.FeedImageLoader.FeedImageType;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.FeedStoryAttachment;
import com.facebook.graphql.model.FeedStoryAttachmentTarget;
import com.facebook.graphql.model.Feedback;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.orca.images.FetchImageParams;
import com.facebook.orca.images.ImageCacheKey.Options;
import com.facebook.orca.inject.FbInjector;
import com.facebook.photos.annotation.IsNewGalleryEnabled;
import com.facebook.photos.photogallery.GalleryLauncher;
import com.facebook.photos.photogallery.GalleryLauncherHost;
import com.facebook.photos.photogallery.photogalleries.consumption.ConsumptionPhoto;
import com.facebook.photos.photogallery.photogalleries.consumption.ConsumptionPhotoDataAdapter;
import com.facebook.photos.photogallery.photogalleries.consumption.ConsumptionPhotoGalleryFragmentFactory;
import com.facebook.photos.photogallery.photosources.SinglePhotoSource;
import com.facebook.photos.photogallery.photoviewcontrollers.NestedViewPhotoViewController;
import com.facebook.widget.ExpandablePhoto;
import com.facebook.widget.UrlImage;
import java.util.ArrayList;

public class StoryAttachmentViewPhoto extends StoryAttachmentView
{
  private final Context e;
  private final UrlImage f;
  private final IFeedIntentBuilder g;
  private final AnalyticsLogger h;
  private final FeedImageLoader i;
  private FeedStoryAttachment j;
  private ExpandablePhoto k;
  private HoneyClientEvent l;
  private final boolean m;
  private ConsumptionPhoto n;
  private NewsFeedPhotoAnimation o;
  private final FeedRendererOptions p;

  public StoryAttachmentViewPhoto(Context paramContext)
  {
    this(paramContext, null);
  }

  public StoryAttachmentViewPhoto(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.e = paramContext;
    setContentView(2130903167);
    this.f = ((UrlImage)b(2131296761));
    this.f.setPlaceHolderDrawable(null);
    this.f.setPlaceholderBackgroundResourceId(2131165264);
    FbInjector localFbInjector = getInjector();
    this.g = ((IFeedIntentBuilder)localFbInjector.a(IFeedIntentBuilder.class));
    this.h = ((AnalyticsLogger)localFbInjector.a(AnalyticsLogger.class));
    this.k = ((ExpandablePhoto)((Activity)localFbInjector.a(Activity.class)).findViewById(2131296268));
    this.i = ((FeedImageLoader)localFbInjector.a(FeedImageLoader.class));
    this.o = ((NewsFeedPhotoAnimation)localFbInjector.a(NewsFeedPhotoAnimation.class));
    this.p = ((FeedRendererOptions)localFbInjector.a(FeedRendererOptions.class));
    this.f.setLoadResolutionDuringScroll(this.p.d);
    this.m = ((Boolean)localFbInjector.a(Boolean.class, IsNewGalleryEnabled.class)).booleanValue();
    if (this.m)
      this.f.setOnClickListener(new StoryAttachmentViewPhoto.1(this));
  }

  private ConsumptionPhoto a(FeedStoryAttachment paramFeedStoryAttachment)
  {
    Feedback localFeedback = paramFeedStoryAttachment.media.S();
    if (paramFeedStoryAttachment.a.message != null);
    for (String str = paramFeedStoryAttachment.a.message.text; ; str = "")
      return new ConsumptionPhoto(Long.parseLong(paramFeedStoryAttachment.media.id), new ArrayList(), paramFeedStoryAttachment.media.image.uri, paramFeedStoryAttachment.media.image.width, paramFeedStoryAttachment.media.image.height, 0, 0, str, localFeedback.a(), localFeedback.b(), localFeedback.canViewerLike, localFeedback.canViewerComment, localFeedback.doesViewerLike);
  }

  private void d()
  {
    if ((this.j.target != null) && (this.j.a != null))
      this.l = this.d.b(this.j.target.id, this.j.a.k());
    FetchImageParams localFetchImageParams2;
    int i4;
    int i3;
    if ((this.j != null) && (this.j.media != null) && (this.j.media.image != null))
      if (this.m)
      {
        this.n = a(this.j);
        localFetchImageParams2 = this.i.a(this.j.media.image, FeedImageLoader.FeedImageType.Photo);
        if (localFetchImageParams2 == null)
          break label276;
        i4 = localFetchImageParams2.c().b;
        i3 = localFetchImageParams2.c().c;
      }
    while (true)
    {
      int i1;
      int i2;
      FetchImageParams localFetchImageParams1;
      if (this.m)
      {
        this.n.a(i4);
        this.n.b(i3);
        i1 = i4;
        i2 = i3;
        localFetchImageParams1 = localFetchImageParams2;
      }
      while (true)
      {
        this.f.setImageParams(localFetchImageParams1);
        ViewGroup.LayoutParams localLayoutParams = this.f.getLayoutParams();
        localLayoutParams.width = i1;
        localLayoutParams.height = i2;
        this.f.setLayoutParams(localLayoutParams);
        return;
        this.o.a(this.k, this.f, this.j, this.l, this.e);
        break;
        this.n = null;
        localFetchImageParams1 = null;
        i1 = 0;
        i2 = 0;
        continue;
        i1 = i4;
        i2 = i3;
        localFetchImageParams1 = localFetchImageParams2;
      }
      label276: i3 = 0;
      i4 = 0;
    }
  }

  private void e()
  {
    NestedViewPhotoViewController localNestedViewPhotoViewController = new NestedViewPhotoViewController(((Activity)getContext()).getWindow(), this.f, this.f.getImageView());
    SinglePhotoSource localSinglePhotoSource = new SinglePhotoSource(this.n);
    ConsumptionPhotoDataAdapter localConsumptionPhotoDataAdapter = (ConsumptionPhotoDataAdapter)getInjector().a(ConsumptionPhotoDataAdapter.class);
    ConsumptionPhotoGalleryFragmentFactory localConsumptionPhotoGalleryFragmentFactory = new ConsumptionPhotoGalleryFragmentFactory(localSinglePhotoSource, ((FragmentActivity)getContext()).g(), localConsumptionPhotoDataAdapter);
    GalleryLauncher localGalleryLauncher = ((GalleryLauncherHost)getContext()).n();
    localGalleryLauncher.a(localNestedViewPhotoViewController, localSinglePhotoSource, localConsumptionPhotoGalleryFragmentFactory);
    localGalleryLauncher.a(0);
  }

  public void a(FeedStoryAttachment paramFeedStoryAttachment, FeedStory paramFeedStory)
  {
    this.j = paramFeedStoryAttachment;
    d();
  }

  public StoryAttachmentView.StoryAttachmentViewType getViewType()
  {
    return StoryAttachmentView.StoryAttachmentViewType.PHOTO;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.ui.attachments.StoryAttachmentViewPhoto
 * JD-Core Version:    0.6.0
 */