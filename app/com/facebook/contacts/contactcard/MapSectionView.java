package com.facebook.contacts.contactcard;

import android.content.Context;
import android.content.res.Resources;
import android.location.Location;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.location.Coordinates;
import com.facebook.orca.threads.Message;
import com.facebook.orca.threads.MessagesCollection;
import com.facebook.orca.threads.ParticipantInfo;
import com.facebook.orca.threads.ThreadDateUtil;
import com.facebook.orca.users.UserKey;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.MapImage;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapSectionView extends CustomLinearLayout
{
  private final ThreadDateUtil a = (ThreadDateUtil)getInjector().a(ThreadDateUtil.class);
  private final View b;
  private final View c;
  private final TextView d;
  private final MapImage e;
  private ContactCardFragment.ContactCardListener f;

  public MapSectionView(Context paramContext)
  {
    this(paramContext, null);
  }

  public MapSectionView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOrientation(1);
    setContentView(2130903120);
    this.b = b(2131296604);
    this.c = b(2131296607);
    this.d = ((TextView)b(2131296606));
    this.e = ((MapImage)b(2131296608));
    this.e.setZoom(-1);
    this.e.setOnClickListener(new MapSectionView.1(this));
  }

  private void a(Message paramMessage)
  {
    long l = paramMessage.c();
    String str1 = this.a.a(l);
    String str2 = getResources().getString(2131362444, new Object[] { str1 });
    this.d.setText(str2);
  }

  private void setMapVisibility(boolean paramBoolean)
  {
    View localView1 = this.b;
    int i;
    View localView2;
    int j;
    if (paramBoolean)
    {
      i = 0;
      localView1.setVisibility(i);
      localView2 = this.c;
      j = 0;
      if (!paramBoolean)
        break label43;
    }
    while (true)
    {
      localView2.setVisibility(j);
      return;
      i = 8;
      break;
      label43: j = 8;
    }
  }

  public void a()
  {
    setMapVisibility(false);
  }

  public void setContactCardListener(ContactCardFragment.ContactCardListener paramContactCardListener)
  {
    this.f = paramContactCardListener;
  }

  public void setGroupMessages(MessagesCollection paramMessagesCollection)
  {
    Preconditions.checkNotNull(paramMessagesCollection);
    HashMap localHashMap = Maps.a();
    Iterator localIterator1 = paramMessagesCollection.b().iterator();
    while (localIterator1.hasNext())
    {
      Message localMessage = (Message)localIterator1.next();
      UserKey localUserKey = localMessage.f().e();
      if ((localHashMap.containsKey(localUserKey)) || (localMessage.k() == null))
        continue;
      localHashMap.put(localUserKey, localMessage);
    }
    Object localObject1;
    Object localObject2;
    if (!localHashMap.isEmpty())
    {
      setMapVisibility(true);
      this.e.a();
      this.e.setKeepMarkerAtCenter(false);
      localObject1 = null;
      Iterator localIterator2 = localHashMap.values().iterator();
      if (localIterator2.hasNext())
      {
        localObject2 = (Message)localIterator2.next();
        Coordinates localCoordinates = ((Message)localObject2).k();
        if (localCoordinates != null)
          this.e.a(localCoordinates.a());
        if ((localObject1 != null) && (((Message)localObject2).c() <= localObject1.c()))
          break label215;
      }
    }
    while (true)
    {
      localObject1 = localObject2;
      break;
      a(localObject1);
      while (true)
      {
        return;
        setMapVisibility(false);
      }
      label215: localObject2 = localObject1;
    }
  }

  public void setMessagesAndUserKey(MessagesCollection paramMessagesCollection, UserKey paramUserKey)
  {
    Preconditions.checkNotNull(paramMessagesCollection);
    Iterator localIterator = paramMessagesCollection.b().iterator();
    Message localMessage;
    do
    {
      if (!localIterator.hasNext())
        break;
      localMessage = (Message)localIterator.next();
    }
    while ((!paramUserKey.equals(localMessage.f().e())) || (localMessage.k() == null));
    while (true)
    {
      if (localMessage != null)
      {
        setMapVisibility(true);
        this.e.setKeepMarkerAtCenter(true);
        this.e.a();
        Location localLocation = localMessage.k().a();
        this.e.setCenter(localLocation);
        a(localMessage);
      }
      while (true)
      {
        return;
        setMapVisibility(false);
      }
      localMessage = null;
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.contacts.contactcard.MapSectionView
 * JD-Core Version:    0.6.0
 */