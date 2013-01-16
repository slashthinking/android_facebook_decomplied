package com.facebook.orca.prefs;

public class InternalPrefKeys
{
  public static final PrefKey a = (PrefKey)SharedPrefKeys.b.c("picker/");
  public static final PrefKey b = (PrefKey)a.c("force_rolodex");
  public static final PrefKey c = (PrefKey)SharedPrefKeys.b.c("contacts/");
  public static final PrefKey d = (PrefKey)c.c("upload_contacts_batch_size");
  public static final PrefKey e = (PrefKey)SharedPrefKeys.b.c("incall/");
  public static final PrefKey f = (PrefKey)e.c("use_incall");
  public static final PrefKey g = (PrefKey)e.c("use_incall_outgoing");
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.orca.prefs.InternalPrefKeys
 * JD-Core Version:    0.6.0
 */