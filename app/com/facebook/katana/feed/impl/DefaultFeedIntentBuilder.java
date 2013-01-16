package com.facebook.katana.feed.impl;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.composer.model.SharePreview;
import com.facebook.feed.intent.IFeedIntentBuilder;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.FeedStoryAttachment;
import com.facebook.graphql.model.Feedback;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLObjectType.ObjectType;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.Shareable;
import com.facebook.ipc.composer.model.ComposerConstants;
import com.facebook.ipc.feed.ViewPermalinkIntentFactory;
import com.facebook.ipc.feed.ViewPermalinkParams;
import com.facebook.katana.IntentUriHandler;
import com.facebook.katana.activity.FbFragmentChromeActivity;
import com.facebook.katana.activity.composer.ComposerActivity;
import com.facebook.katana.activity.findfriends.FriendFinderActivity;
import com.facebook.katana.activity.media.MediaPickerActivity;
import com.facebook.katana.activity.media.MediaPickerEnvironment;
import com.facebook.katana.activity.media.MediaPickerEnvironment.Builder;
import com.facebook.katana.activity.media.PhotoGalleryActivity;
import com.facebook.katana.util.StringUtils;
import com.facebook.megaphone.intent.IMegaphoneIntentBuilder;
import com.google.common.collect.Lists;
import java.util.List;

public class DefaultFeedIntentBuilder
  implements IFeedIntentBuilder, IMegaphoneIntentBuilder
{
  private final Context a;
  private final ViewPermalinkIntentFactory b;
  private final FbErrorReporter c;

  public DefaultFeedIntentBuilder(Context paramContext, ViewPermalinkIntentFactory paramViewPermalinkIntentFactory, FbErrorReporter paramFbErrorReporter)
  {
    this.a = paramContext;
    this.c = paramFbErrorReporter;
    this.b = paramViewPermalinkIntentFactory;
  }

  private String a(FeedStory paramFeedStory, Shareable paramShareable)
  {
    StringBuilder localStringBuilder1 = new StringBuilder().append("Story id: ");
    String str1;
    StringBuilder localStringBuilder2;
    if (paramFeedStory != null)
    {
      str1 = paramFeedStory.id;
      localStringBuilder2 = localStringBuilder1.append(str1).append(", shareable id ");
      if (paramShareable == null)
        break label64;
    }
    label64: for (String str2 = paramShareable.id; ; str2 = "")
    {
      return str2;
      str1 = "";
      break;
    }
  }

  private Intent c(FeedStory paramFeedStory)
  {
    FeedStoryAttachment localFeedStoryAttachment1 = paramFeedStory.N();
    GraphQLObjectType.ObjectType localObjectType = paramFeedStory.shareable.b();
    Intent localIntent;
    if (localFeedStoryAttachment1 == null)
      localIntent = a(paramFeedStory);
    while (true)
    {
      return localIntent;
      GraphQLMedia localGraphQLMedia = localFeedStoryAttachment1.media;
      switch (DefaultFeedIntentBuilder.1.a[localObjectType.ordinal()])
      {
      default:
      case 1:
      case 2:
      case 3:
      case 4:
      }
      do
      {
        List localList;
        do
        {
          do
          {
            do
            {
              localIntent = a(paramFeedStory);
              break;
            }
            while ((localGraphQLMedia == null) || (localGraphQLMedia.id == null) || (localGraphQLMedia.image.uri == null) || (localFeedStoryAttachment1.mediaReferenceToken == null));
            localIntent = a(Long.parseLong(localGraphQLMedia.id), localGraphQLMedia.image.uri, localGraphQLMedia.S().d(), localFeedStoryAttachment1.mediaReferenceToken, null);
            break;
          }
          while (StringUtils.c(localFeedStoryAttachment1.url));
          localIntent = new Intent("android.intent.action.VIEW");
          localIntent.setData(Uri.parse(localFeedStoryAttachment1.url));
          break;
          localList = localFeedStoryAttachment1.subattachments;
        }
        while ((localList == null) || (localGraphQLMedia == null) || (localGraphQLMedia.image == null) || (localGraphQLMedia.image.uri == null));
        String[] arrayOfString1 = new String[localList.size()];
        long[] arrayOfLong = new long[localList.size()];
        String[] arrayOfString2 = new String[localList.size()];
        for (int i = 0; i < arrayOfLong.length; i++)
        {
          FeedStoryAttachment localFeedStoryAttachment2 = (FeedStoryAttachment)localList.get(i);
          arrayOfString1[i] = localFeedStoryAttachment2.media.image.uri;
          arrayOfLong[i] = Long.parseLong(localFeedStoryAttachment2.media.id);
          arrayOfString2[i] = localFeedStoryAttachment2.media.S().d();
        }
        localIntent = a(Long.parseLong(localGraphQLMedia.id), arrayOfString1, arrayOfLong, arrayOfString2, null, null);
        break;
      }
      while ((localGraphQLMedia == null) || (!localGraphQLMedia.isPlayable) || (StringUtils.c(localGraphQLMedia.playableUrl)));
      localIntent = a(localGraphQLMedia.playableUrl);
    }
  }

  public Intent a()
  {
    return new Intent(this.a, FriendFinderActivity.class);
  }

  public Intent a(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Intent localIntent = new Intent(this.a, PhotoGalleryActivity.class);
    localIntent.putExtra("photo_fbid", paramLong);
    localIntent.putExtra("photo_uri", paramString1);
    localIntent.putExtra("feedback_id", paramString2);
    localIntent.putExtra("photoset_token", paramString3);
    localIntent.putExtra("fragment_id", paramString4);
    return localIntent;
  }

  public Intent a(long paramLong, boolean paramBoolean, String paramString, Bundle paramBundle)
  {
    MediaPickerEnvironment.Builder localBuilder = new MediaPickerEnvironment.Builder(paramLong);
    if (!paramBoolean);
    for (boolean bool = true; ; bool = false)
    {
      MediaPickerEnvironment localMediaPickerEnvironment = localBuilder.b(bool).a(true).a();
      Intent localIntent = new Intent(this.a, MediaPickerActivity.class);
      localIntent.putExtra("extra_environment", localMediaPickerEnvironment);
      localIntent.putExtra("extra_source_activity", paramString);
      localIntent.putExtra("composer_extras", paramBundle);
      return localIntent;
    }
  }

  public Intent a(long paramLong, String[] paramArrayOfString1, long[] paramArrayOfLong, String[] paramArrayOfString2, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(this.a, PhotoGalleryActivity.class);
    localIntent.putExtra("photo_fbid", paramLong);
    localIntent.putExtra("photoset_uris", paramArrayOfString1);
    localIntent.putExtra("photoset_ids", paramArrayOfLong);
    localIntent.putExtra("feedback_ids", paramArrayOfString2);
    localIntent.putExtra("story_cache_id", paramString1);
    localIntent.putExtra("fragment_id", paramString2);
    return localIntent;
  }

  public Intent a(Uri paramUri, Bundle paramBundle, long paramLong)
  {
    Intent localIntent = new Intent(this.a, ComposerActivity.class);
    if (paramUri != null)
      localIntent.setData(paramUri);
    if (paramBundle != null)
      localIntent.putExtras(paramBundle);
    if (paramLong != -1L)
      localIntent.putExtra("extra_fixed_audience_id", paramLong);
    return localIntent;
  }

  public Intent a(FeedStory paramFeedStory)
  {
    ViewPermalinkParams localViewPermalinkParams = new ViewPermalinkParams(paramFeedStory);
    return this.b.a(localViewPermalinkParams);
  }

  public Intent a(String paramString)
  {
    Intent localIntent1 = new Intent("android.intent.action.VIEW");
    Uri localUri = Uri.parse(paramString);
    if (StringUtils.a(localUri.getScheme(), "https"))
      localUri = localUri.buildUpon().scheme("http").build();
    localIntent1.setDataAndType(localUri, "video/*");
    if (this.a.getPackageManager().queryIntentActivities(localIntent1, 0).size() > 0);
    for (Intent localIntent2 = localIntent1; ; localIntent2 = null)
      return localIntent2;
  }

  public Intent a(List<GraphQLProfile> paramList)
  {
    Intent localIntent = new Intent(this.a, FbFragmentChromeActivity.class);
    localIntent.putExtra("target_fragment", 6);
    localIntent.putParcelableArrayListExtra("gql_profile_list", Lists.a(paramList));
    localIntent.putExtra("profile_list_is_feedback", false);
    return localIntent;
  }

  public boolean a(Context paramContext, String paramString)
  {
    return IntentUriHandler.b(paramContext, paramString);
  }

  public boolean a(Context paramContext, String paramString, Bundle paramBundle)
  {
    return IntentUriHandler.a(paramContext, paramString, paramBundle);
  }

  public Intent b(Context paramContext, String paramString)
  {
    return IntentUriHandler.a(paramContext, paramString);
  }

  public Intent b(Uri paramUri, Bundle paramBundle, long paramLong)
  {
    Intent localIntent = a(paramUri, paramBundle, paramLong);
    localIntent.putExtra("extra_is_checkin", true);
    localIntent.putExtra(ComposerConstants.c, true);
    localIntent.putExtra(ComposerConstants.b, true);
    return localIntent;
  }

  public Intent b(FeedStory paramFeedStory)
  {
    Shareable localShareable = paramFeedStory.shareable;
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("extra_is_share", true);
    localBundle.putBoolean(ComposerConstants.c, true);
    localBundle.putParcelable("extra_shareable", localShareable);
    try
    {
      localBundle.putParcelable("extra_share_preview", SharePreview.a(paramFeedStory));
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        while (true)
        {
          localBundle.putParcelable("extra_share_preview_on_click", c(paramFeedStory));
          Intent localIntent = new Intent(this.a, ComposerActivity.class);
          localIntent.putExtras(localBundle);
          return localIntent;
          localThrowable1 = localThrowable1;
          this.c.a("Share", "Share Preview error " + a(paramFeedStory, localShareable), localThrowable1, false);
        }
      }
      catch (Throwable localThrowable2)
      {
        while (true)
          this.c.a("Share", "Share Preview on click intent error " + a(paramFeedStory, localShareable), localThrowable2, false);
      }
    }
  }

  public Intent b(String paramString)
  {
    Intent localIntent = new Intent(this.a, FbFragmentChromeActivity.class);
    localIntent.putExtra("target_fragment", 6);
    localIntent.putExtra("gql_feedback_id", paramString);
    localIntent.putExtra("profile_list_is_feedback", true);
    return localIntent;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.feed.impl.DefaultFeedIntentBuilder
 * JD-Core Version:    0.6.0
 */