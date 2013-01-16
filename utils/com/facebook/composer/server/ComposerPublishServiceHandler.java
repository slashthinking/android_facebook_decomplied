package com.facebook.composer.server;

import android.os.Bundle;
import com.facebook.composer.protocol.PublishCheckinMethod;
import com.facebook.composer.protocol.PublishLocationMethod;
import com.facebook.composer.protocol.PublishLocationParams;
import com.facebook.composer.protocol.PublishPostMethod;
import com.facebook.composer.protocol.PublishPostParams;
import com.facebook.composer.protocol.PublishShareMethod;
import com.facebook.composer.protocol.SimplePhotoUploadMethod;
import com.facebook.composer.protocol.SimplePhotoUploadParams;
import com.facebook.orca.protocol.base.BatchOperation;
import com.facebook.orca.protocol.base.BatchOperation.Builder;
import com.facebook.orca.protocol.base.BatchRunner;
import com.facebook.orca.server.OperationParams;
import com.facebook.orca.server.OperationResult;
import javax.inject.Provider;

public class ComposerPublishServiceHandler
{
  private final Provider<BatchRunner> a;
  private final PublishCheckinMethod b;
  private final PublishPostMethod c;
  private final PublishLocationMethod d;
  private final PublishShareMethod e;
  private final SimplePhotoUploadMethod f;

  public ComposerPublishServiceHandler(Provider<BatchRunner> paramProvider, PublishCheckinMethod paramPublishCheckinMethod, PublishPostMethod paramPublishPostMethod, PublishLocationMethod paramPublishLocationMethod, PublishShareMethod paramPublishShareMethod, SimplePhotoUploadMethod paramSimplePhotoUploadMethod)
  {
    this.a = paramProvider;
    this.b = paramPublishCheckinMethod;
    this.c = paramPublishPostMethod;
    this.d = paramPublishLocationMethod;
    this.e = paramPublishShareMethod;
    this.f = paramSimplePhotoUploadMethod;
  }

  public OperationResult a(OperationParams paramOperationParams)
  {
    Bundle localBundle = paramOperationParams.b();
    BatchRunner localBatchRunner = (BatchRunner)this.a.b();
    PublishPostParams localPublishPostParams = (PublishPostParams)localBundle.getParcelable("publishPostParams");
    localBatchRunner.a(BatchOperation.a(this.e, localPublishPostParams).a("graphObjectShares").a());
    localBatchRunner.b("publishShare");
    return OperationResult.a((String)localBatchRunner.a("graphObjectShares"));
  }

  public OperationResult b(OperationParams paramOperationParams)
  {
    Bundle localBundle = paramOperationParams.b();
    BatchRunner localBatchRunner = (BatchRunner)this.a.b();
    PublishPostParams localPublishPostParams = (PublishPostParams)localBundle.getParcelable("publishPostParams");
    localBatchRunner.a(BatchOperation.a(this.c, localPublishPostParams).a("graphObjectPosts").a());
    PublishLocationParams localPublishLocationParams = (PublishLocationParams)localBundle.getParcelable("publishLocationParams");
    if (localPublishLocationParams != null)
      localBatchRunner.a(BatchOperation.a(this.d, localPublishLocationParams).a("graphObjectLocation").a());
    localBatchRunner.b("publishPost");
    return OperationResult.a((String)localBatchRunner.a("graphObjectPosts"));
  }

  public OperationResult c(OperationParams paramOperationParams)
  {
    Bundle localBundle = paramOperationParams.b();
    BatchRunner localBatchRunner = (BatchRunner)this.a.b();
    PublishPostParams localPublishPostParams = (PublishPostParams)localBundle.getParcelable("publishPostParams");
    localBatchRunner.a(BatchOperation.a(this.b, localPublishPostParams).a("graphObjectCheckin").a());
    localBatchRunner.b("publishCheckin");
    return OperationResult.a((String)localBatchRunner.a("graphObjectCheckin"));
  }

  public OperationResult d(OperationParams paramOperationParams)
  {
    Bundle localBundle = paramOperationParams.b();
    BatchRunner localBatchRunner = (BatchRunner)this.a.b();
    SimplePhotoUploadParams localSimplePhotoUploadParams = (SimplePhotoUploadParams)localBundle.getParcelable("simplePhotoUploadParams");
    localBatchRunner.a(BatchOperation.a(this.f, localSimplePhotoUploadParams).a("graphObjectPhoto").a());
    localBatchRunner.b("publishPhoto");
    return OperationResult.b();
  }
}

/* Location:           /data1/software/apk2java/dex2jar-0.0.9.12/secondary-1.dex_dex2jar.jar
 * Qualified Name:     com.facebook.composer.server.ComposerPublishServiceHandler
 * JD-Core Version:    0.6.2
 */