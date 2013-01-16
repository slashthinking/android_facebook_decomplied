package com.facebook.composer.service;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.analytics.AnalyticsLogger;
import com.facebook.analytics.HoneyClientEvent;
import com.facebook.common.json.FBJsonFactory;
import com.facebook.composer.analytics.ComposerAnalyticsEventBuilder;
import com.facebook.composer.optimistic.ComposerActivityBroadcaster;
import com.facebook.composer.protocol.PublishLocationParams;
import com.facebook.composer.protocol.PublishPostParams;
import com.facebook.composer.protocol.PublishPostParams.PublishType;
import com.facebook.composer.protocol.SimplePhotoUploadParams;
import com.facebook.graphql.model.FeedStory;
import com.facebook.ipc.composer.model.ComposerConstants;
import com.facebook.orca.common.dialogs.ErrorMessageGenerator;
import com.facebook.orca.common.util.AndroidThreadUtil;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.facebook.orca.server.OperationResult;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;

public class ComposerPublishService
{
  private final AndroidThreadUtil a;
  private final ComposerActivityBroadcaster b;
  private final Context c;
  private final ObjectMapper d;
  private final OrcaServiceOperationFactory e;
  private final ErrorMessageGenerator f;
  private final AnalyticsLogger g;

  public ComposerPublishService(Context paramContext, ComposerActivityBroadcaster paramComposerActivityBroadcaster, OrcaServiceOperationFactory paramOrcaServiceOperationFactory, AndroidThreadUtil paramAndroidThreadUtil, ErrorMessageGenerator paramErrorMessageGenerator, AnalyticsLogger paramAnalyticsLogger, ObjectMapper paramObjectMapper)
  {
    this.c = paramContext;
    this.b = paramComposerActivityBroadcaster;
    this.e = paramOrcaServiceOperationFactory;
    this.a = paramAndroidThreadUtil;
    this.f = paramErrorMessageGenerator;
    this.g = paramAnalyticsLogger;
    this.d = paramObjectMapper;
  }

  private ListenableFuture<OperationResult> a(Intent paramIntent, PublishPostParams paramPublishPostParams, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("publishPostParams", paramPublishPostParams);
    ListenableFuture localListenableFuture = a(localBundle, paramString);
    return a(paramIntent.getStringExtra(ComposerConstants.a), paramPublishPostParams, localListenableFuture);
  }

  private ListenableFuture<OperationResult> a(Bundle paramBundle, String paramString)
  {
    ListenableFuture localListenableFuture = this.e.a(paramString, paramBundle).d();
    PublishPostParams localPublishPostParams = (PublishPostParams)paramBundle.getParcelable("publishPostParams");
    HoneyClientEvent localHoneyClientEvent = ComposerAnalyticsEventBuilder.a().a(paramString).a(localPublishPostParams.a()).b(localPublishPostParams.b()).c();
    this.g.a(localHoneyClientEvent);
    this.a.a(localListenableFuture, new ComposerPublishService.2(this, paramString, localPublishPostParams));
    return localListenableFuture;
  }

  private ListenableFuture<OperationResult> a(String paramString, PublishPostParams paramPublishPostParams, ListenableFuture<OperationResult> paramListenableFuture)
  {
    if (paramString == null);
    while (true)
    {
      return paramListenableFuture;
      try
      {
        JsonParser localJsonParser = FBJsonFactory.a.createJsonParser(paramString);
        localFeedStory = (FeedStory)this.d.readValue(localJsonParser, FeedStory.class);
        if (localFeedStory == null)
          continue;
        this.b.a(paramPublishPostParams.a, localFeedStory, paramPublishPostParams.b);
        this.a.a(paramListenableFuture, new ComposerPublishService.1(this, paramPublishPostParams));
      }
      catch (JsonParseException localJsonParseException)
      {
        while (true)
          localFeedStory = null;
      }
      catch (IOException localIOException)
      {
        while (true)
          FeedStory localFeedStory = null;
      }
    }
  }

  private ListenableFuture<OperationResult> b(Intent paramIntent, PublishPostParams paramPublishPostParams, String paramString)
  {
    if ((paramString.equals("publish_checkin")) || (paramString.equals("timeline_publish_checkin")));
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("publishPostParams", paramPublishPostParams);
      ListenableFuture localListenableFuture = a(localBundle, paramString);
      return a(paramIntent.getStringExtra(ComposerConstants.a), paramPublishPostParams, localListenableFuture);
    }
  }

  private ListenableFuture<OperationResult> c(Intent paramIntent, PublishPostParams paramPublishPostParams, String paramString)
  {
    if ((paramString.equals("publish_post")) || (paramString.equals("timeline_publish_post")));
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      PublishLocationParams localPublishLocationParams = (PublishLocationParams)paramIntent.getParcelableExtra("publishLocationParams");
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("publishPostParams", paramPublishPostParams);
      localBundle.putParcelable("publishLocationParams", localPublishLocationParams);
      ListenableFuture localListenableFuture = a(localBundle, paramString);
      return a(paramIntent.getStringExtra(ComposerConstants.a), paramPublishPostParams, localListenableFuture);
    }
  }

  private ListenableFuture<OperationResult> d(Intent paramIntent, PublishPostParams paramPublishPostParams, String paramString)
  {
    Preconditions.checkArgument(paramString.equals("timeline_publish_photo"));
    SimplePhotoUploadParams localSimplePhotoUploadParams = (SimplePhotoUploadParams)paramIntent.getParcelableExtra("simplePhotoUploadParams");
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("publishPostParams", paramPublishPostParams);
    localBundle.putParcelable("simplePhotoUploadParams", localSimplePhotoUploadParams);
    return a(localBundle, paramString);
  }

  public ListenableFuture<OperationResult> a(Intent paramIntent, ComposerPublishService.Publisher paramPublisher)
  {
    PublishPostParams localPublishPostParams = (PublishPostParams)paramIntent.getParcelableExtra("publishPostParams");
    Preconditions.checkNotNull(localPublishPostParams);
    PublishPostParams.PublishType localPublishType = localPublishPostParams.a();
    ListenableFuture localListenableFuture;
    switch (ComposerPublishService.3.b[paramPublisher.ordinal()])
    {
    default:
      switch (ComposerPublishService.3.a[localPublishType.ordinal()])
      {
      case 2:
      default:
        localListenableFuture = c(paramIntent, localPublishPostParams, "publish_post");
      case 3:
      case 1:
      }
      break;
    case 1:
    }
    while (true)
    {
      return localListenableFuture;
      switch (ComposerPublishService.3.a[localPublishType.ordinal()])
      {
      default:
        localListenableFuture = c(paramIntent, localPublishPostParams, "timeline_publish_post");
        break;
      case 1:
        localListenableFuture = b(paramIntent, localPublishPostParams, "timeline_publish_checkin");
        break;
      case 2:
        localListenableFuture = d(paramIntent, localPublishPostParams, "timeline_publish_photo");
        break;
      case 3:
        localListenableFuture = a(paramIntent, localPublishPostParams, "timeline_publish_share");
        continue;
        localListenableFuture = a(paramIntent, localPublishPostParams, "publish_share");
        continue;
        localListenableFuture = b(paramIntent, localPublishPostParams, "publish_checkin");
      }
    }
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.composer.service.ComposerPublishService
 * JD-Core Version:    0.6.2
 */