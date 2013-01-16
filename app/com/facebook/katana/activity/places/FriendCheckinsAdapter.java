package com.facebook.katana.activity.places;

import android.content.Context;
import android.graphics.Bitmap;
import android.location.Location;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.common.util.DefaultTimeFormatUtil;
import com.facebook.common.util.TimeFormatUtil.TimeFormatStyle;
import com.facebook.ipc.katana.model.FacebookPlace;
import com.facebook.ipc.katana.model.FacebookUser;
import com.facebook.katana.ViewHolder;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.StreamPhotosCache;
import com.facebook.katana.features.places.PlacesUtils;
import com.facebook.katana.model.FacebookApp;
import com.facebook.katana.model.FacebookCheckin;
import com.facebook.katana.model.FacebookCheckinDetails;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.ui.SectionedListAdapter;
import com.facebook.katana.util.FBLocationManager;
import com.facebook.katana.util.FBLocationManager.FBLocationListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FriendCheckinsAdapter extends SectionedListAdapter
  implements FBLocationManager.FBLocationListener
{
  public AsyncTask<List<FacebookCheckin>, Integer, List<FriendCheckinsAdapter.Group>> a = null;
  protected Location b;
  private final Context c;
  private final LayoutInflater d;
  private final StreamPhotosCache e;
  private final List<ViewHolder<String>> f;
  private List<FacebookCheckin> g;
  private List<FriendCheckinsAdapter.Group> h;
  private final Set<View> i;
  private final Set<View> j;

  public FriendCheckinsAdapter(Context paramContext, StreamPhotosCache paramStreamPhotosCache)
  {
    this.c = paramContext;
    this.e = paramStreamPhotosCache;
    this.f = new ArrayList();
    this.d = LayoutInflater.from(paramContext);
    this.i = new HashSet();
    this.j = new HashSet();
    e();
  }

  private List<FriendCheckinsAdapter.Group> b(List<FacebookCheckin> paramList)
  {
    long l = new GregorianCalendar().getTimeInMillis() / 1000L;
    ArrayList localArrayList1 = new ArrayList(3);
    AppSession localAppSession = AppSession.a(this.c, false);
    ArrayList localArrayList2 = new ArrayList(1);
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      FacebookCheckin localFacebookCheckin = (FacebookCheckin)localIterator.next();
      FacebookCheckinDetails localFacebookCheckinDetails = localFacebookCheckin.a();
      FacebookPlace localFacebookPlace = localFacebookCheckinDetails.a();
      float[] arrayOfFloat = new float[1];
      if ((localAppSession != null) && (localFacebookCheckin.mActorId == localAppSession.b().userId))
      {
        localArrayList2.add(localFacebookCheckin);
        PlacesUtils.a(this.c, localFacebookCheckin, 1000L * localFacebookCheckinDetails.mTimestamp);
        continue;
      }
      if (this.b != null)
      {
        Location.distanceBetween(this.b.getLatitude(), this.b.getLongitude(), localFacebookPlace.mLatitude, localFacebookPlace.mLongitude, arrayOfFloat);
        if ((arrayOfFloat[0] <= 3000.0F) && (l - localFacebookCheckinDetails.mTimestamp <= 10800L))
        {
          localArrayList3.add(localFacebookCheckin);
          continue;
        }
        localArrayList4.add(localFacebookCheckin);
        continue;
      }
      localArrayList4.add(localFacebookCheckin);
    }
    if (localArrayList2.size() > 0)
      localArrayList1.add(new FriendCheckinsAdapter.Group(this.c.getString(2131363050), localArrayList2));
    if (localArrayList3.size() == 0)
      if (localArrayList4.size() > 0)
        localArrayList1.add(new FriendCheckinsAdapter.Group(this.c.getString(2131363048), localArrayList4));
    while (true)
    {
      return localArrayList1;
      localArrayList1.add(new FriendCheckinsAdapter.Group(this.c.getString(2131363049), localArrayList3));
      localArrayList1.add(new FriendCheckinsAdapter.Group(this.c.getString(2131363047), localArrayList4));
    }
  }

  public int a(int paramInt)
  {
    return 0;
  }

  public View a(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
  {
    FacebookCheckin localFacebookCheckin = (FacebookCheckin)a(paramInt1, paramInt2);
    if ((paramView == null) || (!this.i.contains(paramView)))
    {
      paramView = this.d.inflate(2130903094, null);
      ViewHolder localViewHolder1 = new ViewHolder(paramView, 2131296492);
      this.f.add(localViewHolder1);
      paramView.setTag(localViewHolder1);
    }
    FacebookUser localFacebookUser = localFacebookCheckin.b();
    FacebookCheckinDetails localFacebookCheckinDetails = localFacebookCheckin.a();
    ViewHolder localViewHolder2 = (ViewHolder)paramView.getTag();
    String str1 = localFacebookUser.mImageUrl;
    localViewHolder2.a(str1);
    Context localContext2;
    Object[] arrayOfObject2;
    if ((str1 != null) && (str1.length() != 0))
    {
      Bitmap localBitmap = this.e.a(this.c, str1, 1);
      if (localBitmap != null)
      {
        localViewHolder2.a.setImageBitmap(localBitmap);
        ((TextView)paramView.findViewById(2131296493)).setText(localFacebookUser.a());
        ((TextView)paramView.findViewById(2131296494)).setText(localFacebookCheckinDetails.a().mName);
        if (localFacebookCheckinDetails.b() == null)
          break label322;
        localContext2 = this.c;
        arrayOfObject2 = new Object[2];
        arrayOfObject2[0] = DefaultTimeFormatUtil.a(this.c, TimeFormatUtil.TimeFormatStyle.STREAM_RELATIVE_STYLE, 1000L * localFacebookCheckinDetails.mTimestamp);
        arrayOfObject2[1] = localFacebookCheckinDetails.b().mName;
      }
    }
    label322: Context localContext1;
    Object[] arrayOfObject1;
    for (String str2 = localContext2.getString(2131363045, arrayOfObject2); ; str2 = localContext1.getString(2131363046, arrayOfObject1))
    {
      ((TextView)paramView.findViewById(2131296495)).setText(str2);
      this.i.add(paramView);
      return paramView;
      localViewHolder2.a.setImageResource(2130838447);
      break;
      localViewHolder2.a.setImageResource(2130838447);
      break;
      localContext1 = this.c;
      arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = DefaultTimeFormatUtil.a(this.c, TimeFormatUtil.TimeFormatStyle.STREAM_RELATIVE_STYLE, 1000L * localFacebookCheckinDetails.mTimestamp);
    }
  }

  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    FriendCheckinsAdapter.Group localGroup = (FriendCheckinsAdapter.Group)c(paramInt);
    if ((paramView == null) || (!this.j.contains(paramView)));
    for (View localView = this.d.inflate(2130903239, null); ; localView = paramView)
    {
      ((TextView)localView).setText(localGroup.a);
      this.j.add(localView);
      return localView;
    }
  }

  public Object a(int paramInt1, int paramInt2)
  {
    return ((FriendCheckinsAdapter.Group)this.h.get(paramInt1)).b.get(paramInt2);
  }

  void a(Bitmap paramBitmap, String paramString)
  {
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
    {
      ViewHolder localViewHolder = (ViewHolder)localIterator.next();
      String str = (String)localViewHolder.a();
      if ((str == null) || (!str.equals(paramString)))
        continue;
      localViewHolder.a.setImageBitmap(paramBitmap);
    }
  }

  public void a(Location paramLocation)
  {
    this.b = paramLocation;
    a(this.g);
  }

  void a(List<FacebookCheckin> paramList)
  {
    if ((this.a != null) && (this.a.getStatus() == AsyncTask.Status.RUNNING))
    {
      this.a.cancel(true);
      this.a = null;
    }
    this.a = new FriendCheckinsAdapter.BucketizeItemsTask(this, null);
    this.a.execute(new List[] { paramList });
    this.g = paramList;
  }

  public int b(int paramInt)
  {
    List localList = ((FriendCheckinsAdapter.Group)this.h.get(paramInt)).b;
    if (localList == null);
    for (int k = 0; ; k = localList.size())
      return k;
  }

  public int b(int paramInt1, int paramInt2)
  {
    return 1;
  }

  public int c()
  {
    return 2;
  }

  public Object c(int paramInt)
  {
    return this.h.get(paramInt);
  }

  public boolean c(int paramInt1, int paramInt2)
  {
    return true;
  }

  public boolean d()
  {
    int k = 1;
    if (this.h == null);
    while (true)
    {
      return k;
      if (this.h.size() == 0)
        continue;
      k = 0;
    }
  }

  public int d_()
  {
    if (this.h == null);
    for (int k = 0; ; k = this.h.size())
      return k;
  }

  void e()
  {
    FBLocationManager.a(this.c, this);
  }

  void f()
  {
    if (this.a != null)
      this.a.cancel(true);
    FBLocationManager.a(this);
  }

  public void k()
  {
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.places.FriendCheckinsAdapter
 * JD-Core Version:    0.6.0
 */