package com.facebook.katana.activity.events;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.widget.LinearLayout;
import android.widget.TimePicker;
import java.util.Calendar;

class EventCreationActivity$TimePickerFragment extends DialogFragment
  implements TimePickerDialog.OnTimeSetListener
{
  private EventCreationActivity$TimePickerFragment(EventCreationActivity paramEventCreationActivity)
  {
  }

  public Dialog c(Bundle paramBundle)
  {
    Calendar localCalendar;
    TimePickerDialog localTimePickerDialog;
    if (("timepicker_start".equals(k())) || (("timepicker_end".equals(k())) && (EventCreationActivity.l(this.Y) == null)))
    {
      localCalendar = EventCreationActivity.m(this.Y);
      int i = localCalendar.get(11);
      int j = localCalendar.get(12);
      localTimePickerDialog = new TimePickerDialog(n(), this, i, j, DateFormat.is24HourFormat(n()));
      if (!"timepicker_start".equals(k()))
        break label127;
      localTimePickerDialog.setButton(-2, e(2131362917), EventCreationActivity.p(this.Y));
    }
    while (true)
    {
      return localTimePickerDialog;
      localCalendar = EventCreationActivity.l(this.Y);
      break;
      label127: if (!"timepicker_end".equals(k()))
        continue;
      localTimePickerDialog.setButton(-2, e(2131362917), EventCreationActivity.n(this.Y));
    }
  }

  public void onTimeSet(TimePicker paramTimePicker, int paramInt1, int paramInt2)
  {
    if ("timepicker_start".equals(k()))
    {
      EventCreationActivity.a(this.Y, false);
      EventCreationActivity.a(this.Y, paramInt1, paramInt2);
      EventCreationActivity.g(this.Y).setVisibility(0);
    }
    while (true)
    {
      if ((EventCreationActivity.l(this.Y) != null) && (EventCreationActivity.l(this.Y).getTimeInMillis() < EventCreationActivity.m(this.Y).getTimeInMillis()))
        EventCreationActivity.o(this.Y);
      return;
      EventCreationActivity.b(this.Y, paramInt1, paramInt2);
    }
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.events.EventCreationActivity.TimePickerFragment
 * JD-Core Version:    0.6.0
 */