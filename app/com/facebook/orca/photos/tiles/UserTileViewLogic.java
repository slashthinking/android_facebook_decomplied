package com.facebook.orca.photos.tiles;

import android.content.ContentResolver;
import android.net.Uri;
import android.net.Uri.Builder;
import com.facebook.orca.cache.DataCache;
import com.facebook.orca.config.PlatformAppHttpConfig;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.images.FetchImageParams;
import com.facebook.orca.photos.sizing.CropRegionConstraintsBuilder;
import com.facebook.orca.photos.sizing.CropRegionGraphicOp.CropType;
import com.facebook.orca.photos.sizing.CropRegionRectConstraints;
import com.facebook.orca.photos.sizing.GraphicOpConstraints;
import com.facebook.orca.photos.sizing.GraphicOpConstraintsBuilder;
import com.facebook.orca.photos.sizing.GraphicSizerFactory;
import com.facebook.orca.users.PicCropInfo;
import com.facebook.orca.users.User;
import com.facebook.orca.users.User.Type;
import com.facebook.orca.users.UserKey;
import com.facebook.widget.UrlImage;
import com.google.common.base.Objects;
import javax.inject.Provider;

public class UserTileViewLogic
{
  private static final Class<?> a = UserTileViewLogic.class;
  private final DataCache b;
  private final GraphicSizerFactory c;
  private final Provider<PlatformAppHttpConfig> d;
  private final ContentResolver e;

  public UserTileViewLogic(DataCache paramDataCache, GraphicSizerFactory paramGraphicSizerFactory, Provider<PlatformAppHttpConfig> paramProvider, ContentResolver paramContentResolver)
  {
    this.b = paramDataCache;
    this.c = paramGraphicSizerFactory;
    this.d = paramProvider;
    this.e = paramContentResolver;
  }

  private FetchImageParams a(PicCropInfo paramPicCropInfo, int paramInt1, int paramInt2)
  {
    BLog.b(a, "Fetching tile data from crop info: " + paramPicCropInfo);
    if ((paramPicCropInfo == null) || (paramPicCropInfo.b() == null));
    for (FetchImageParams localFetchImageParams = UrlImage.a; ; localFetchImageParams = new FetchImageParams(paramPicCropInfo.b(), this.c.a(b(paramPicCropInfo, paramInt1, paramInt2))))
      return localFetchImageParams;
  }

  private FetchImageParams a(User paramUser, UserKey paramUserKey, int paramInt1, int paramInt2)
  {
    FetchImageParams localFetchImageParams = null;
    if (paramUser != null)
    {
      if ((paramUser.r() != null) && (paramUser.r().i()))
        localFetchImageParams = a(paramUser.r(), paramInt1, paramInt2);
    }
    else if (localFetchImageParams == null)
      if ((paramUserKey == null) || (paramUserKey.a() != User.Type.FACEBOOK) || (Objects.equal(paramUserKey.b(), "0")))
        break label177;
    label177: for (localFetchImageParams = new FetchImageParams(((PlatformAppHttpConfig)this.d.b()).b().appendEncodedPath(paramUserKey.b()).appendEncodedPath("picture").appendQueryParameter("type", "large").build(), this.c.a(a(paramInt1, paramInt2))); ; localFetchImageParams = UrlImage.a)
    {
      return localFetchImageParams;
      Uri localUri = paramUser.q();
      localFetchImageParams = null;
      if (localUri == null)
        break;
      localFetchImageParams = new FetchImageParams(paramUser.q(), this.c.a(a(paramInt1, paramInt2)));
      break;
    }
  }

  private FetchImageParams a(UserKey paramUserKey, int paramInt1, int paramInt2)
  {
    return a(this.b.a(paramUserKey), paramUserKey, paramInt1, paramInt2);
  }

  private GraphicOpConstraints a(int paramInt1, int paramInt2)
  {
    return new GraphicOpConstraintsBuilder().a(new CropRegionConstraintsBuilder().a(paramInt1 / paramInt2).b(1.0F).c(1.0F).e()).a(paramInt1 / 2).b(paramInt2 / 2).c(paramInt1).d(paramInt2).i();
  }

  private GraphicOpConstraints b(PicCropInfo paramPicCropInfo, int paramInt1, int paramInt2)
  {
    return new GraphicOpConstraintsBuilder().a(new CropRegionRectConstraints(paramPicCropInfo.j(), paramInt1 / paramInt2)).a(new CropRegionConstraintsBuilder().a(paramInt1 / paramInt2).b(1.0F).c(1.0F).a(CropRegionGraphicOp.CropType.CENTER).e()).a(paramInt1 / 2).b(paramInt2 / 2).c(paramInt1).d(paramInt2).i();
  }

  public FetchImageParams a(UserTileViewParams paramUserTileViewParams, int paramInt1, int paramInt2)
  {
    FetchImageParams localFetchImageParams;
    if (paramUserTileViewParams == null)
      localFetchImageParams = null;
    while (true)
    {
      return localFetchImageParams;
      switch (UserTileViewLogic.1.a[paramUserTileViewParams.a().ordinal()])
      {
      default:
        throw new IllegalStateException("not reached");
      case 1:
        localFetchImageParams = a(paramUserTileViewParams.b(), paramInt1, paramInt2);
        break;
      case 2:
        localFetchImageParams = a(paramUserTileViewParams.c(), paramInt1, paramInt2);
      }
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.photos.tiles.UserTileViewLogic
 * JD-Core Version:    0.6.0
 */