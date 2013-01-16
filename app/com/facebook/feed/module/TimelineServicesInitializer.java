package com.facebook.feed.module;

import com.facebook.feed.protocol.TimelineHeaderQueue;
import com.facebook.feed.protocol.TimelineSectionQueue;
import com.facebook.feed.service.TimelineService;
import com.facebook.orca.app.INeedInit;
import com.facebook.orca.server.OrcaServiceRegistry;

public class TimelineServicesInitializer
  implements INeedInit
{
  private final OrcaServiceRegistry a;

  public TimelineServicesInitializer(OrcaServiceRegistry paramOrcaServiceRegistry)
  {
    this.a = paramOrcaServiceRegistry;
  }

  public void i_()
  {
    this.a.a(TimelineHeaderQueue.class, TimelineService.class);
    this.a.a("fetch_timeline_header", TimelineHeaderQueue.class);
    this.a.a("add_friend_list_member", TimelineHeaderQueue.class);
    this.a.a("remove_friend_list_member", TimelineHeaderQueue.class);
    this.a.a("fetch_friendlists", TimelineHeaderQueue.class);
    this.a.a("fetch_friendlists_with_member", TimelineHeaderQueue.class);
    this.a.a("clear_cache", TimelineHeaderQueue.class);
    this.a.a(TimelineSectionQueue.class, TimelineService.class);
    this.a.a("fetch_first_units", TimelineSectionQueue.class);
    this.a.a("fetch_section", TimelineSectionQueue.class);
    this.a.a("fetch_section_list", TimelineSectionQueue.class);
    this.a.a("delete_story", TimelineSectionQueue.class);
    this.a.a("hide_story", TimelineSectionQueue.class);
    this.a.a("timeline_publish_checkin", TimelineSectionQueue.class);
    this.a.a("timeline_publish_post", TimelineSectionQueue.class);
    this.a.a("timeline_publish_photo", TimelineSectionQueue.class);
    this.a.a("timeline_publish_share", TimelineSectionQueue.class);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.feed.module.TimelineServicesInitializer
 * JD-Core Version:    0.6.0
 */