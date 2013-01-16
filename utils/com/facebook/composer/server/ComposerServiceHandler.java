package com.facebook.composer.server;

import android.os.Bundle;
import com.facebook.composer.model.LinksPreview;
import com.facebook.composer.protocol.LinksPreviewMethod;
import com.facebook.composer.protocol.LinksPreviewParams;
import com.facebook.composer.protocol.PostRecommendationMethod;
import com.facebook.composer.protocol.PostRecommendationParams;
import com.facebook.orca.protocol.base.SingleMethodRunner;
import com.facebook.orca.server.OperationParams;
import com.facebook.orca.server.OperationResult;
import com.facebook.orca.server.OrcaServiceHandler;
import javax.inject.Provider;

public class ComposerServiceHandler
  implements OrcaServiceHandler
{
  private final Provider<SingleMethodRunner> a;
  private final LinksPreviewMethod b;
  private final PostRecommendationMethod c;

  public ComposerServiceHandler(Provider<SingleMethodRunner> paramProvider, LinksPreviewMethod paramLinksPreviewMethod, PostRecommendationMethod paramPostRecommendationMethod)
  {
    this.a = paramProvider;
    this.b = paramLinksPreviewMethod;
    this.c = paramPostRecommendationMethod;
  }

  private OperationResult b(OperationParams paramOperationParams)
  {
    LinksPreviewParams localLinksPreviewParams = (LinksPreviewParams)paramOperationParams.b().getParcelable("linksPreviewParams");
    return OperationResult.a((LinksPreview)((SingleMethodRunner)this.a.b()).a(this.b, localLinksPreviewParams));
  }

  private OperationResult c(OperationParams paramOperationParams)
  {
    PostRecommendationParams localPostRecommendationParams = (PostRecommendationParams)paramOperationParams.b().getParcelable("postRecommendationParams");
    return OperationResult.a((String)((SingleMethodRunner)this.a.b()).a(this.c, localPostRecommendationParams));
  }

  public OperationResult a(OperationParams paramOperationParams)
  {
    String str = paramOperationParams.a();
    if ("links_preview".equals(str));
    for (OperationResult localOperationResult = b(paramOperationParams); ; localOperationResult = c(paramOperationParams))
    {
      return localOperationResult;
      if (!"post_recommendation".equals(str))
        break;
    }
    throw new IllegalArgumentException("unknown operation type: " + str);
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.composer.server.ComposerServiceHandler
 * JD-Core Version:    0.6.2
 */