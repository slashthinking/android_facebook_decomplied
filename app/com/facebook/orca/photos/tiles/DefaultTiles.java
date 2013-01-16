package com.facebook.orca.photos.tiles;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.orca.cache.ThreadDisplayCache;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.debug.BLog;
import com.facebook.orca.photos.sizing.CropRegionConstraintsBuilder;
import com.facebook.orca.photos.sizing.CropRegionGraphicOp.CropType;
import com.facebook.orca.photos.sizing.GraphicOpConstraints;
import com.facebook.orca.photos.sizing.GraphicOpConstraintsBuilder;
import com.facebook.orca.photos.sizing.GraphicSizer;
import com.facebook.orca.threads.ParticipantInfo;
import com.facebook.orca.threads.ThreadParticipant;
import com.facebook.orca.threads.ThreadParticipantUtils;
import com.facebook.orca.threads.ThreadSummary;
import com.facebook.orca.users.User.Type;
import com.facebook.orca.users.UserKey;

public class DefaultTiles
{
  public static int a;
  private static final Class<?> b = DefaultTiles.class;
  private final Resources c;
  private final DefaultTilesCache d;
  private final ThreadParticipantUtils e;
  private final ThreadDisplayCache f;

  static
  {
    a = Color.argb(255, 204, 211, 224);
  }

  public DefaultTiles(Resources paramResources, DefaultTilesCache paramDefaultTilesCache, ThreadParticipantUtils paramThreadParticipantUtils, ThreadDisplayCache paramThreadDisplayCache)
  {
    this.c = paramResources;
    this.d = paramDefaultTilesCache;
    this.e = paramThreadParticipantUtils;
    this.f = paramThreadDisplayCache;
  }

  private Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    BLog.a(b, "Bitmap resize with canvas drawing");
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt1, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawColor(paramInt2);
    localCanvas.drawBitmap(paramBitmap, new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight()), new Rect(0, 0, paramInt1, paramInt1), null);
    return localBitmap;
  }

  private Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 != paramInt2);
    for (Bitmap localBitmap = a(paramBitmap, f(paramInt1, paramInt2), paramInt3); ; localBitmap = a(paramBitmap, paramInt1, paramInt3))
      return localBitmap;
  }

  private Bitmap a(Bitmap paramBitmap, GraphicOpConstraints paramGraphicOpConstraints, int paramInt)
  {
    BLog.a(b, "Bitmap resize with GraphicSizer");
    GraphicSizer localGraphicSizer = new GraphicSizer(paramGraphicOpConstraints, paramBitmap.getWidth(), paramBitmap.getHeight());
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawColor(paramInt);
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, null);
    return localGraphicSizer.a(localBitmap);
  }

  private Drawable a(DefaultTilesCache.Type paramType, int paramInt1, int paramInt2, int paramInt3)
  {
    DefaultTilesCache.Key localKey = new DefaultTilesCache.Key(paramType, a, paramInt2, paramInt3);
    Bitmap localBitmap = this.d.a(localKey);
    if (localBitmap == null)
    {
      localBitmap = a(((BitmapDrawable)this.c.getDrawable(paramInt1)).getBitmap(), paramInt2, paramInt3, a);
      this.d.a(localKey, localBitmap);
    }
    return new BitmapDrawable(this.c, localBitmap);
  }

  private Drawable d(int paramInt1, int paramInt2)
  {
    return a(DefaultTilesCache.Type.EMAIL, 2130838588, paramInt1, paramInt2);
  }

  private Drawable e(int paramInt1, int paramInt2)
  {
    return a(DefaultTilesCache.Type.SMS, 2130838591, paramInt1, paramInt2);
  }

  private GraphicOpConstraints f(int paramInt1, int paramInt2)
  {
    BLog.a(b, "Sizing container for unequal resizing");
    return new GraphicOpConstraintsBuilder().a(new CropRegionConstraintsBuilder().a(paramInt1 / paramInt2).b(1.0F).c(1.0F).a(CropRegionGraphicOp.CropType.CENTER).e()).a(paramInt1 / 2).b(paramInt2 / 2).c(paramInt1).d(paramInt2).i();
  }

  public Drawable a(int paramInt1, int paramInt2)
  {
    return a(DefaultTilesCache.Type.THREAD, 2130838589, paramInt1, paramInt2);
  }

  public Drawable a(ParticipantInfo paramParticipantInfo, int paramInt1, int paramInt2)
  {
    Drawable localDrawable;
    if (paramParticipantInfo != null)
      if (paramParticipantInfo.b())
        localDrawable = c(paramInt1, paramInt2);
    while (true)
    {
      return localDrawable;
      if (paramParticipantInfo.c())
      {
        localDrawable = e(paramInt1, paramInt2);
        continue;
      }
      if (!StringUtil.a(paramParticipantInfo.a()))
      {
        localDrawable = d(paramInt1, paramInt2);
        continue;
      }
      localDrawable = c(paramInt1, paramInt2);
    }
  }

  public Drawable a(ThreadSummary paramThreadSummary, int paramInt1, int paramInt2)
  {
    if ((paramThreadSummary != null) && ((paramThreadSummary.q()) || (paramThreadSummary.s())));
    for (Drawable localDrawable = a(paramInt1, paramInt2); ; localDrawable = c(paramInt1, paramInt2))
      return localDrawable;
  }

  public Drawable a(UserKey paramUserKey, int paramInt1, int paramInt2)
  {
    Drawable localDrawable;
    if (paramUserKey != null)
      if (paramUserKey.a() == User.Type.FACEBOOK)
        localDrawable = c(paramInt1, paramInt2);
    while (true)
    {
      return localDrawable;
      if ((paramUserKey.a() == User.Type.PHONE_NUMBER) || (paramUserKey.a() == User.Type.ADDRESS_BOOK))
      {
        localDrawable = e(paramInt1, paramInt2);
        continue;
      }
      if (paramUserKey.a() == User.Type.EMAIL)
      {
        localDrawable = d(paramInt1, paramInt2);
        continue;
      }
      localDrawable = c(paramInt1, paramInt2);
    }
  }

  public Drawable b(int paramInt1, int paramInt2)
  {
    return a(DefaultTilesCache.Type.THREAD, 2130838590, paramInt1, paramInt2);
  }

  public Drawable b(ThreadSummary paramThreadSummary, int paramInt1, int paramInt2)
  {
    ParticipantInfo localParticipantInfo = this.e.a(paramThreadSummary).a();
    if ((paramThreadSummary.g()) && (this.f.c(paramThreadSummary) == 1));
    for (Drawable localDrawable = c(paramInt1, paramInt2); ; localDrawable = a(localParticipantInfo, paramInt1, paramInt2))
      return localDrawable;
  }

  public Drawable c(int paramInt1, int paramInt2)
  {
    return a(DefaultTilesCache.Type.USER, 2130838592, paramInt1, paramInt2);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.photos.tiles.DefaultTiles
 * JD-Core Version:    0.6.0
 */