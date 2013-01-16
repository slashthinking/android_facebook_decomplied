package com.facebook.nearby.places;

import android.content.Context;
import android.content.res.Resources;
import android.location.Location;
import android.net.Uri;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import com.facebook.graphql.model.GraphQLEntityRange;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLLocation;
import com.facebook.graphql.model.GraphQLPlace;
import com.facebook.graphql.model.GraphQLProfileList;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.maps.Locations;
import com.facebook.maps.MapsLocationUtils;
import com.facebook.nearby.model.NearbyPlaceEdge;
import com.facebook.nearby.model.TypeaheadPlace;
import com.facebook.nearby.ui.RenderingUtils;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.UrlImage;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.List;

public class NearbyPlaceDetailsView extends CustomRelativeLayout
{
  private final MapsLocationUtils a;
  private final UrlImage b;
  private final TextView c;
  private final TextView d;
  private final TextView e;
  private final FrameLayout f;
  private final RatingBar g;
  private final RatingBar h;
  private final TextView i;
  private final TextView j;
  private final TextView k;
  private final Resources l;
  private NearbyPlaceEdge m;

  public NearbyPlaceDetailsView(Context paramContext)
  {
    this(paramContext, null);
  }

  public NearbyPlaceDetailsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public NearbyPlaceDetailsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setContentView(2130903284);
    this.a = ((MapsLocationUtils)FbInjector.a(paramContext).a(MapsLocationUtils.class));
    this.c = ((TextView)b(2131297116));
    this.b = ((UrlImage)b(2131297114));
    this.d = ((TextView)b(2131297124));
    this.e = ((TextView)b(2131297123));
    this.k = ((TextView)b(2131297115));
    this.f = ((FrameLayout)b(2131297118));
    this.g = ((RatingBar)b(2131297119));
    this.h = ((RatingBar)b(2131297120));
    this.i = ((TextView)b(2131297121));
    this.j = ((TextView)b(2131297122));
    this.l = paramContext.getResources();
  }

  private CharSequence a(GraphQLTextWithEntities paramGraphQLTextWithEntities)
  {
    Object localObject;
    if (paramGraphQLTextWithEntities == null)
      localObject = "";
    while (true)
    {
      return localObject;
      if (paramGraphQLTextWithEntities.ranges == null)
      {
        localObject = paramGraphQLTextWithEntities.text;
        continue;
      }
      SpannableString localSpannableString = new SpannableString(paramGraphQLTextWithEntities.text);
      Iterator localIterator = paramGraphQLTextWithEntities.ranges.iterator();
      while (localIterator.hasNext())
      {
        GraphQLEntityRange localGraphQLEntityRange = (GraphQLEntityRange)localIterator.next();
        localSpannableString.setSpan(new ForegroundColorSpan(this.l.getColor(2131165227)), localGraphQLEntityRange.offset, localGraphQLEntityRange.offset + localGraphQLEntityRange.length, 33);
      }
      localObject = localSpannableString;
    }
  }

  private String a(int paramInt1, int paramInt2)
  {
    Resources localResources1 = this.l;
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = Integer.valueOf(paramInt1);
    String str1 = localResources1.getQuantityString(2131427337, paramInt1, arrayOfObject1);
    Resources localResources2 = this.l;
    Object[] arrayOfObject2 = new Object[1];
    arrayOfObject2[0] = Integer.valueOf(paramInt2);
    String str2 = localResources2.getQuantityString(2131427338, paramInt2, arrayOfObject2);
    String str3 = this.l.getString(2131361908);
    if ((paramInt1 > 0) && (paramInt2 > 0))
      str2 = Joiner.on(" ").join(str1, str3, new Object[] { str2 }).toString();
    while (true)
    {
      return str2;
      if ((paramInt1 == 0) && (paramInt2 > 0))
        continue;
      if ((paramInt1 > 0) && (paramInt2 == 0))
      {
        str2 = str1;
        continue;
      }
      str2 = "";
    }
  }

  public void a(NearbyPlaceEdge paramNearbyPlaceEdge, Location paramLocation)
  {
    Preconditions.checkNotNull(paramNearbyPlaceEdge);
    this.m = paramNearbyPlaceEdge;
    GraphQLPlace localGraphQLPlace = this.m.place;
    this.c.setText(localGraphQLPlace.name);
    this.b.setImageParams(Uri.parse(localGraphQLPlace.profilePicture.uri));
    this.e.setText(RenderingUtils.a(localGraphQLPlace.categories, localGraphQLPlace.address));
    CharSequence localCharSequence;
    if (localGraphQLPlace.location != null)
    {
      this.k.setText(this.a.a(paramLocation, Locations.a(localGraphQLPlace.location.latitude, localGraphQLPlace.location.longitude)));
      localCharSequence = a(paramNearbyPlaceEdge.socialContext);
      boolean bool = StringUtil.a(localCharSequence);
      if (!bool)
        break label264;
      this.d.setVisibility(8);
      label142: if (localGraphQLPlace.averageRating <= 0.0F)
        break label316;
      this.f.setVisibility(0);
      this.i.setVisibility(0);
      this.j.setVisibility(8);
      if (!bool)
        break label284;
      this.g.setRating(localGraphQLPlace.averageRating);
      this.h.setVisibility(8);
      this.g.setVisibility(0);
      label211: TextView localTextView = this.i;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(localGraphQLPlace.raters.count);
      localTextView.setText(StringUtil.a("(%d)", arrayOfObject));
    }
    while (true)
    {
      return;
      this.k.setText("");
      break;
      label264: this.d.setVisibility(0);
      this.d.setText(localCharSequence);
      break label142;
      label284: this.h.setRating(localGraphQLPlace.averageRating);
      this.h.setVisibility(0);
      this.g.setVisibility(8);
      break label211;
      label316: this.f.setVisibility(8);
      this.i.setVisibility(8);
      int n = paramNearbyPlaceEdge.place.pageLikers.count;
      int i1 = paramNearbyPlaceEdge.place.pageVisits.count;
      if ((n == 0) && (i1 == 0))
      {
        this.j.setVisibility(8);
        continue;
      }
      this.j.setVisibility(0);
      this.j.setText(a(n, i1));
    }
  }

  public void a(TypeaheadPlace paramTypeaheadPlace, Location paramLocation)
  {
    this.c.setText(paramTypeaheadPlace.b);
    this.b.setImageParams(Uri.parse(paramTypeaheadPlace.d));
    this.h.setVisibility(8);
    this.g.setVisibility(8);
    if (paramTypeaheadPlace.c > 0.0F)
    {
      this.g.setVisibility(0);
      this.g.setRating(paramTypeaheadPlace.c);
    }
    this.e.setText(RenderingUtils.a(paramTypeaheadPlace.f, paramTypeaheadPlace.g));
    this.k.setText(this.a.a(paramLocation, Locations.a(paramTypeaheadPlace.e.latitude, paramTypeaheadPlace.e.longitude)));
    this.j.setVisibility(8);
    this.i.setVisibility(8);
    this.d.setVisibility(8);
  }

  public NearbyPlaceEdge getDisplayedPlaceEdge()
  {
    return this.m;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.nearby.places.NearbyPlaceDetailsView
 * JD-Core Version:    0.6.0
 */