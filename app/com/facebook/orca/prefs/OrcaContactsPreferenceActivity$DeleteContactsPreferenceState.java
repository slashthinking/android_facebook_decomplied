package com.facebook.orca.prefs;

 enum OrcaContactsPreferenceActivity$DeleteContactsPreferenceState
{
  static
  {
    IN_PROGRESS = new DeleteContactsPreferenceState("IN_PROGRESS", 1);
    FINISHED_SUCCESS = new DeleteContactsPreferenceState("FINISHED_SUCCESS", 2);
    FINISHED_ERROR = new DeleteContactsPreferenceState("FINISHED_ERROR", 3);
    DeleteContactsPreferenceState[] arrayOfDeleteContactsPreferenceState = new DeleteContactsPreferenceState[4];
    arrayOfDeleteContactsPreferenceState[0] = NOT_STARTED;
    arrayOfDeleteContactsPreferenceState[1] = IN_PROGRESS;
    arrayOfDeleteContactsPreferenceState[2] = FINISHED_SUCCESS;
    arrayOfDeleteContactsPreferenceState[3] = FINISHED_ERROR;
    $VALUES = arrayOfDeleteContactsPreferenceState;
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.OrcaContactsPreferenceActivity.DeleteContactsPreferenceState
 * JD-Core Version:    0.6.0
 */