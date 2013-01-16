package com.facebook.timeline.page.hours;

import android.content.res.Resources;
import com.facebook.graphql.model.GraphQLTimeRange;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class PageHoursRenderer
{
  private static final TimeZone a = TimeZone.getTimeZone("GMT-8");
  private final SimpleDateFormat b = new SimpleDateFormat("h:mm a");

  public PageHoursRenderer()
  {
    Calendar localCalendar = Calendar.getInstance(a, Locale.getDefault());
    this.b.setCalendar(localCalendar);
  }

  public String a(long paramLong)
  {
    return this.b.format(new Date(1000L * paramLong)).toLowerCase();
  }

  public String a(PageHours paramPageHours, Resources paramResources)
  {
    GraphQLTimeRange localGraphQLTimeRange = paramPageHours.b();
    PageHours.Status localStatus = paramPageHours.a();
    String str1 = a(localGraphQLTimeRange.start);
    String str2 = a(localGraphQLTimeRange.end);
    String str4;
    if (localStatus == PageHours.Status.OPEN)
      str4 = paramResources.getString(2131361836, new Object[] { str1, str2 });
    while (true)
    {
      return str4;
      Calendar localCalendar = Calendar.getInstance(a, Locale.getDefault());
      localCalendar.setTime(new Date(1000L * paramPageHours.d()));
      int i = localCalendar.get(7);
      localCalendar.setTime(new Date(1000L * localGraphQLTimeRange.start));
      int j = localCalendar.get(7);
      String str3 = localCalendar.getDisplayName(7, 2, Locale.getDefault());
      int k = (7 + (j - i)) % 7;
      if (k == 0)
      {
        str4 = paramResources.getString(2131361837, new Object[] { str1, str2 });
        continue;
      }
      if (k == 1)
      {
        str4 = paramResources.getString(2131361838, new Object[] { str1, str2 });
        continue;
      }
      if (k < 5)
      {
        str4 = paramResources.getString(2131361839, new Object[] { str3, str1, str2 });
        continue;
      }
      str4 = paramResources.getString(2131361840, new Object[] { str3, str1, str2 });
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.timeline.page.hours.PageHoursRenderer
 * JD-Core Version:    0.6.0
 */