package com.facebook.feed.prefs;

import com.facebook.orca.prefs.PrefKey;
import com.facebook.orca.prefs.SharedPrefKeys;

public class FeedPrefKeys
{
  public static final PrefKey A;
  public static final PrefKey B;
  public static final PrefKey C;
  public static final PrefKey D;
  public static final PrefKey E;
  public static final PrefKey F;
  public static final PrefKey G;
  public static final PrefKey H;
  public static final PrefKey a = (PrefKey)SharedPrefKeys.a.c("feed/");
  public static final PrefKey b = (PrefKey)a.c("flyout_pref");
  public static final PrefKey c = (PrefKey)a.c("memcache");
  public static final PrefKey d = (PrefKey)a.c("diskcache");
  public static final PrefKey e = (PrefKey)a.c("prefetch");
  public static final PrefKey f = (PrefKey)a.c("viewcache");
  public static final PrefKey g = (PrefKey)a.c("sec_actions");
  public static final PrefKey h = (PrefKey)a.c("viewcache_scrolling");
  public static final PrefKey i = (PrefKey)a.c("image_in_feed");
  public static final PrefKey j = (PrefKey)a.c("images_warm");
  public static final PrefKey k = (PrefKey)a.c("images_prefetch");
  public static final PrefKey l = (PrefKey)a.c("image_resolution_at_scoll_time");
  public static final PrefKey m = (PrefKey)a.c("clear_stories_cache");
  public static final PrefKey n = (PrefKey)a.c("measurement");
  public static final PrefKey o = (PrefKey)a.c("spam_reporting");
  public static final PrefKey p = (PrefKey)a.c("feed_listview_cumstom_physics_enabled");
  public static final PrefKey q = (PrefKey)a.c("friction");
  public static final PrefKey r = (PrefKey)a.c("velocity_scale");
  public static final PrefKey s = (PrefKey)a.c("renderer/");
  public static final PrefKey t = (PrefKey)s.c("header_title");
  public static final PrefKey u = (PrefKey)s.c("header_info");
  public static final PrefKey v = (PrefKey)s.c("message");
  public static final PrefKey w = (PrefKey)s.c("attachments");
  public static final PrefKey x = (PrefKey)s.c("location_map");
  public static final PrefKey y = (PrefKey)s.c("attach_story");
  public static final PrefKey z = (PrefKey)s.c("substories");

  static
  {
    A = (PrefKey)s.c("footer");
    B = (PrefKey)a.c("render_story_freshness_background");
    C = (PrefKey)a.c("fetch/");
    D = (PrefKey)C.c("active_type");
    E = (PrefKey)C.c("last_response");
    F = (PrefKey)C.c("prefetch_calls");
    G = (PrefKey)C.c("prefetch_window");
    H = (PrefKey)C.c("freeze_next");
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.prefs.FeedPrefKeys
 * JD-Core Version:    0.6.0
 */