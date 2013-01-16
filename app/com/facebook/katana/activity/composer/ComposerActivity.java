package com.facebook.katana.activity.composer;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.location.Location;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsSubModuleActivity;
import com.facebook.analytics.InteractionLogger;
import com.facebook.camera.utils.Storage;
import com.facebook.common.json.jsonmirror.JMStaticKeysDictDestination.Encoder;
import com.facebook.common.util.ErrorReporting;
import com.facebook.common.util.FbErrorReporter;
import com.facebook.common.util.Log;
import com.facebook.common.util.Toaster;
import com.facebook.composer.model.ImplicitLocation;
import com.facebook.composer.model.SharePreview;
import com.facebook.composer.protocol.LinksPreviewParams;
import com.facebook.composer.protocol.PostRecommendationParams;
import com.facebook.composer.protocol.PublishLocationParams;
import com.facebook.composer.protocol.PublishPostParamsBuilder;
import com.facebook.debug.Assert;
import com.facebook.feed.util.FeedLinkifyUtil;
import com.facebook.feed.util.composer.UniqueRequestIdGenerator;
import com.facebook.graphql.model.FeedStory;
import com.facebook.graphql.model.GraphQLObjectType.ObjectType;
import com.facebook.graphql.model.Shareable;
import com.facebook.ipc.composer.model.ComposerConstants;
import com.facebook.ipc.katana.model.FacebookEvent;
import com.facebook.ipc.katana.model.FacebookPlace;
import com.facebook.ipc.katana.model.FacebookUser;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.ipc.model.PrivacySetting;
import com.facebook.ipc.model.PrivacySetting.Category;
import com.facebook.katana.AlertDialogs;
import com.facebook.katana.LoginActivity;
import com.facebook.katana.activity.BaseFacebookActivity;
import com.facebook.katana.activity.NotNewNavEnabled;
import com.facebook.katana.activity.media.AlbumsAdapter;
import com.facebook.katana.activity.media.AlbumsAdapterFactory;
import com.facebook.katana.activity.media.FacebookPhotoTagSet;
import com.facebook.katana.activity.media.MediaItemFactory;
import com.facebook.katana.activity.media.MediaPickerActivity;
import com.facebook.katana.activity.media.MediaPickerEnvironment;
import com.facebook.katana.activity.media.MediaPickerEnvironment.Builder;
import com.facebook.katana.activity.media.MediaTagController;
import com.facebook.katana.activity.places.SelectAtTagActivity;
import com.facebook.katana.activity.profilelist.FriendMultiSelectorActivity;
import com.facebook.katana.activity.profilelist.GroupMemberMultiSelectorActivity;
import com.facebook.katana.binding.AppSession;
import com.facebook.katana.binding.AppSessionListener;
import com.facebook.katana.binding.NetworkRequestCallback;
import com.facebook.katana.features.Gatekeeper;
import com.facebook.katana.features.UserSeenNux;
import com.facebook.katana.features.UserSeenNux.Project;
import com.facebook.katana.features.composer.AudienceAdapter;
import com.facebook.katana.features.composer.AudienceAdapter.FriendListAudienceOption;
import com.facebook.katana.features.composer.AudienceAdapter.PrivacySettingAudienceOption;
import com.facebook.katana.features.composer.AudienceOption;
import com.facebook.katana.features.composer.AudienceOption.Type;
import com.facebook.katana.features.composer.ComposerUserSettings;
import com.facebook.katana.features.composer.MinorStatus;
import com.facebook.katana.features.composer.TimeAdapter;
import com.facebook.katana.features.composer.TimeAdapter.Period;
import com.facebook.katana.features.events.AggressiveSuggestionPreferences;
import com.facebook.katana.features.places.SelectAtTagFetcher.SearchType;
import com.facebook.katana.model.FacebookAlbum;
import com.facebook.katana.model.FacebookPhotoTag;
import com.facebook.katana.model.FacebookProfileUtil;
import com.facebook.katana.model.FacebookSessionInfo;
import com.facebook.katana.model.FriendList;
import com.facebook.katana.model.GeoRegion.ImplicitLocation;
import com.facebook.katana.model.GeoRegion.Type;
import com.facebook.katana.model.MediaItem;
import com.facebook.katana.model.MediaItem.MediaType;
import com.facebook.katana.model.PhotoItem;
import com.facebook.katana.provider.ConnectionsProviderInjectable;
import com.facebook.katana.provider.PhotosProvider;
import com.facebook.katana.service.MediaUploadService;
import com.facebook.katana.service.method.AudienceSettings;
import com.facebook.katana.service.method.FqlGetAtTags.FqlGetEventsCoveringTimeRange;
import com.facebook.katana.service.method.FqlGetNearbyRegions;
import com.facebook.katana.service.method.FqlGetProfile;
import com.facebook.katana.service.method.GraphSetUserSeenNux;
import com.facebook.katana.service.method.MediaUploaderController.MediaUnpublishedPhoto;
import com.facebook.katana.ui.ComposerEditText;
import com.facebook.katana.ui.OverlaySelectorView;
import com.facebook.katana.ui.mentions.MentionsAutoCompleteTextView;
import com.facebook.katana.ui.mentions.MentionsSpannableStringBuilder;
import com.facebook.katana.ui.mentions.MentionsUtils;
import com.facebook.katana.util.FBLocationManager;
import com.facebook.katana.util.FBLocationManager.FBLocationListener;
import com.facebook.katana.util.IntentUtils;
import com.facebook.katana.util.StringUtils;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities.Modules;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities.UIElements;
import com.facebook.katana.view.composer.ComposerAttachmentsView;
import com.facebook.katana.view.composer.ComposerAttachmentsView.ItemClickedListener;
import com.facebook.katana.view.composer.ComposerAudienceSelectorButton;
import com.facebook.katana.view.composer.ComposerAudienceSelectorButton.AudienceType;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpec;
import com.facebook.orca.common.ui.titlebar.TitleBarButtonSpecBuilder;
import com.facebook.orca.common.util.StringLocaleUtil;
import com.facebook.orca.common.util.StringUtil;
import com.facebook.orca.inject.FbInjector;
import com.facebook.orca.ops.OrcaServiceOperationFactory;
import com.facebook.orca.ops.OrcaServiceOperationFactory.OrcaServiceOperation;
import com.facebook.orca.prefs.UiCounters;
import com.facebook.photos.analytics.PhotoFlowLogger;
import com.facebook.photos.analytics.PhotoFlowLogger.ComposerType;
import com.facebook.photos.analytics.WaterfallIdGenerator;
import com.facebook.widget.UrlImage;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.Futures;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ObjectAnimator;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

public class ComposerActivity extends BaseFacebookActivity
  implements AnalyticsSubModuleActivity, NotNewNavEnabled, ComposerAttachmentsView.ItemClickedListener
{
  private static String aE = "privacy_tooltip_counter";
  private static int aF = 5;
  private static SimpleDateFormat aG = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
  private static SimpleDateFormat aH;
  private Location A;
  private AudienceAdapter B;
  private AlbumsAdapter C;
  private ImageButton D;
  private TimeAdapter E;
  private TargetSelectorActivity.Target F;
  private GeoRegion.ImplicitLocation G;
  private boolean H;
  private boolean I;
  private MediaPickerEnvironment J;
  private Map<String, MediaUploaderController.MediaUnpublishedPhoto> K = Maps.a();
  private long L = 0L;
  private TextView M;
  private CheckBox N;
  private String O;
  private boolean P;
  private ComposerActivity.TipMode Q = ComposerActivity.TipMode.NONE;
  private Uri R;
  private ComposerActivity.OverlayMode S;
  private OverlaySelectorView T;
  private OverlaySelectorView U;
  private ListView V;
  private long W;
  private String X;
  private boolean Y;
  private ComposerAudienceSelectorButton Z;
  private int aA = 3;
  private UiCounters aB;
  private boolean aC = false;
  private boolean aD = false;
  private FacebookAlbum aa;
  private String ab;
  private final LinkedList<String> ac = new LinkedList();
  private Location ad;
  private FBLocationManager.FBLocationListener ae;
  private boolean af;
  private boolean ag;
  private boolean ah;
  private boolean ai;
  private boolean aj = false;
  private long ak;
  private List<File> al;
  private Handler am;
  private InteractionLogger an;
  private PhotoFlowLogger ao;
  private EventTaggingAnalyticsLogger ap;
  private AggressiveSuggestionPreferences aq;
  private String ar;
  private Storage as;
  private OrcaServiceOperationFactory at;
  private FbErrorReporter au;
  private boolean av = true;
  private String aw;
  private ConnectionsProviderInjectable ax;
  private ImageView ay;
  private ComposerAttachmentsView az;
  protected EditText n;
  private AppSession o;
  private FacebookProfile p;
  private List<AppSessionListener> q;
  private List<MediaItem> r;
  private List<FacebookProfile> s = new ArrayList();
  private Set<Long> t = new HashSet();
  private HashMap<Long, ArrayList<MediaItem>> u = Maps.a();
  private long v = -1L;
  private FacebookPlace x;
  private FacebookPlace y;
  private boolean z;

  static
  {
    aG.setTimeZone(TimeZone.getTimeZone("UTC"));
    aH = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
  }

  private void E()
  {
    ImageView localImageView = (ImageView)findViewById(2131296543);
    if (G())
    {
      localImageView.setVisibility(0);
      if (this.aa != null)
        localImageView.setImageResource(2130837705);
    }
    while (true)
    {
      return;
      localImageView.setImageResource(2130837704);
      continue;
      localImageView.setVisibility(8);
    }
  }

  private boolean F()
  {
    if ((this.r != null) && (!this.r.isEmpty()));
    for (int i = 1; ; i = 0)
      return i;
  }

  private boolean G()
  {
    if ((this.W == -1L) && (F()));
    for (int i = 1; ; i = 0)
      return i;
  }

  private boolean H()
  {
    if ((!"event".equals(this.X)) && (Boolean.TRUE.equals(Gatekeeper.a(this, "android_event_tagging_aggressive"))) && (!Boolean.TRUE.equals(MinorStatus.a(this))));
    for (int i = 1; ; i = 0)
      return i;
  }

  private void I()
  {
    if (!this.aD)
    {
      this.aD = true;
      a((TextView)findViewById(2131296532), ComposerActivity.InOutAnimationType.FADE_IN_NO_OUT, null);
    }
  }

  private void J()
  {
    TextView localTextView = (TextView)findViewById(2131296532);
    if (localTextView == null);
    while (true)
    {
      return;
      if (localTextView.getVisibility() == 0)
      {
        localTextView.startAnimation(AnimationUtils.loadAnimation(this, 2130968589));
        localTextView.setVisibility(8);
        continue;
      }
    }
  }

  private PrivacySetting K()
  {
    PrivacySetting localPrivacySetting;
    if (this.B == null)
      localPrivacySetting = null;
    while (true)
    {
      return localPrivacySetting;
      AudienceOption localAudienceOption = this.B.g();
      if ((localAudienceOption != null) && (localAudienceOption.c() == AudienceOption.Type.PRIVACY_SETTING))
      {
        localPrivacySetting = ((AudienceAdapter.PrivacySettingAudienceOption)localAudienceOption).d();
        continue;
      }
      localPrivacySetting = null;
    }
  }

  private boolean L()
  {
    PrivacySetting localPrivacySetting = K();
    if ((localPrivacySetting != null) && ((localPrivacySetting.value.equals("EVERYONE")) || (localPrivacySetting.value.equals("ALL_FRIENDS")) || (localPrivacySetting.value.equals("FRIENDS_OF_FRIENDS"))));
    for (int i = 1; ; i = 0)
      return i;
  }

  private String M()
  {
    Intent localIntent = getIntent();
    String str;
    if (localIntent.hasExtra("extra_composer_title"))
      str = getString(localIntent.getExtras().getInt("extra_composer_title"));
    while (true)
    {
      return str;
      if (localIntent.hasExtra("extra_composer_title_string"))
      {
        str = localIntent.getExtras().getString("extra_composer_title_string");
        continue;
      }
      if (this.af)
      {
        str = getString(2131363287);
        continue;
      }
      if (localIntent.getBooleanExtra("extra_is_share", false))
      {
        if (localIntent.hasExtra("extra_link_for_share"))
        {
          str = getString(2131361969);
          continue;
        }
        Shareable localShareable = (Shareable)localIntent.getParcelableExtra("extra_shareable");
        if (localShareable != null)
          switch (ComposerActivity.35.c[localShareable.b().ordinal()])
          {
          default:
            str = getString(2131361974);
            break;
          case 1:
            str = getString(2131361969);
            break;
          case 2:
            str = getString(2131361970);
            break;
          case 3:
            str = getString(2131361971);
            break;
          case 4:
            str = getString(2131361972);
            break;
          case 5:
            str = getString(2131361973);
            break;
          }
      }
      str = getString(2131362127);
    }
  }

  private void N()
  {
    ((ComposerEditText)findViewById(2131296520)).addTextChangedListener(new ComposerActivity.18(this));
  }

  private FacebookPhotoTag[] O()
  {
    return new FacebookPhotoTag[0];
  }

  private void P()
  {
    Intent localIntent = getIntent();
    if ((this.ag) && (localIntent.hasExtra("extra_composer_hint_target")))
    {
      EditText localEditText = this.n;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = localIntent.getStringExtra("extra_composer_hint_target");
      localEditText.setHint(getString(2131362872, arrayOfObject));
    }
    label149: 
    while (true)
    {
      return;
      int i = 2131363210;
      if ((this.r != null) && (this.r.size() > 0))
        if (this.r.size() > 1)
          i = 2131362870;
      while (true)
      {
        if (i <= 0)
          break label149;
        this.n.setHint(getString(i));
        break;
        if (this.r.size() != 1)
          continue;
        i = 2131362869;
        continue;
        if (this.R == null)
          continue;
        i = 2131362871;
      }
    }
  }

  private void Q()
  {
    if (this.ah)
      a(TitleBarButtonSpec.newBuilder().b(getString(2131362854)).i());
    while (true)
    {
      return;
      a(TitleBarButtonSpec.newBuilder().b(getString(2131362853)).i());
    }
  }

  private void R()
  {
    this.u.clear();
    label26: Iterator localIterator1;
    if ((this.r == null) || (this.r.size() == 0))
      return;
    else
      localIterator1 = this.r.iterator();
    while (true)
    {
      if (!localIterator1.hasNext())
        break label26;
      MediaItem localMediaItem = (MediaItem)localIterator1.next();
      if (localMediaItem.e() != MediaItem.MediaType.PHOTO)
        break;
      PhotoItem localPhotoItem = (PhotoItem)localMediaItem;
      FacebookPhotoTagSet localFacebookPhotoTagSet = localPhotoItem.k();
      if (localFacebookPhotoTagSet == null)
        break;
      Iterator localIterator2 = localFacebookPhotoTagSet.b().iterator();
      while (localIterator2.hasNext())
      {
        FacebookPhotoTag localFacebookPhotoTag = (FacebookPhotoTag)localIterator2.next();
        Long localLong = Long.valueOf(localFacebookPhotoTag.a());
        if (localFacebookPhotoTag.a() <= 0L)
          continue;
        Object localObject = (ArrayList)this.u.get(localLong);
        if (localObject == null)
        {
          ArrayList localArrayList = Lists.a();
          this.u.put(localLong, localArrayList);
          this.s.add(new FacebookProfile(localFacebookPhotoTag.a(), localFacebookPhotoTag.f(), localFacebookPhotoTag.h(), 0));
          localObject = localArrayList;
        }
        ((ArrayList)localObject).add(localPhotoItem);
      }
    }
  }

  private void S()
  {
    Iterator localIterator = this.u.keySet().iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      if (this.ax.a(this, localLong.longValue()) == null)
        continue;
      this.t.add(localLong);
    }
  }

  private void T()
  {
    a(null);
    k();
  }

  private void U()
  {
    this.J = ((MediaPickerEnvironment)getIntent().getParcelableExtra("extra_environment"));
    if (this.J == null)
      if ((this.aj) || (this.W <= 0L))
        break label65;
    label65: for (boolean bool = true; ; bool = false)
    {
      this.J = new MediaPickerEnvironment.Builder(this.W).b(bool).a();
      return;
    }
  }

  private void V()
  {
    Bundle localBundle = getIntent().getExtras();
    if (localBundle == null);
    while (true)
    {
      return;
      SharePreview localSharePreview = (SharePreview)localBundle.getParcelable("extra_share_preview");
      Shareable localShareable = (Shareable)localBundle.getParcelable("extra_shareable");
      if (localSharePreview != null)
      {
        a(localShareable, localSharePreview);
        continue;
      }
      a(localShareable);
    }
  }

  private void W()
  {
    View localView = this.U.findViewById(2131297584);
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = 0.0F;
    arrayOfFloat[1] = localView.getHeight();
    ObjectAnimator localObjectAnimator = ObjectAnimator.a(localView, "translationY", arrayOfFloat).d(400L);
    localObjectAnimator.a(new ComposerActivity.23(this));
    localObjectAnimator.c();
  }

  private void X()
  {
    c(2131296546);
    ((TextView)findViewById(2131296686)).setText(M());
    Q();
  }

  private void Y()
  {
    c(2131296547);
  }

  private void Z()
  {
    long l3;
    long l4;
    long l6;
    if ((this.r != null) && (!this.r.isEmpty()))
    {
      Iterator localIterator = this.r.iterator();
      l3 = -1L;
      l4 = -1L;
      while (localIterator.hasNext())
      {
        long l5 = b((MediaItem)localIterator.next());
        if ((l5 == -1L) || (l5 == 0L))
          continue;
        if ((l3 == -1L) || (l5 < l3))
          l3 = l5;
        if ((l4 != -1L) && (l5 <= l4))
          break label323;
        l6 = l5;
      }
    }
    while (true)
    {
      l4 = l6;
      break;
      long l1 = l4;
      long l2 = l3;
      while (true)
      {
        boolean bool2;
        label156: int i;
        if (l2 == -1L)
          if (l1 == -1L)
          {
            bool2 = true;
            Assert.b(bool2);
            i = 0;
            label164: if (i == 0)
              break label297;
            FqlGetAtTags.FqlGetEventsCoveringTimeRange localFqlGetEventsCoveringTimeRange = new FqlGetAtTags.FqlGetEventsCoveringTimeRange(this, null, this.o.b().sessionKey, null, this.o.b().userId, 2, l2, l1);
            this.O = this.o.a(this, localFqlGetEventsCoveringTimeRange, 1001, 1020, null);
          }
        while (true)
        {
          return;
          if (this.R == null)
            break label312;
          l1 = d(this.R);
          l2 = l1;
          break;
          bool2 = false;
          break label156;
          if (l1 != -1L);
          for (boolean bool1 = true; ; bool1 = false)
          {
            Assert.b(bool1);
            if (l1 - l2 > 604800000L)
              break label291;
            i = 1;
            break;
          }
          label291: i = 0;
          break label164;
          label297: a(null);
          this.Q = ComposerActivity.TipMode.NONE;
        }
        label312: l1 = -1L;
        l2 = -1L;
      }
      label323: l6 = l4;
    }
  }

  public static int a(CharSequence paramCharSequence)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramCharSequence);
    ComposerActivity.MetaText[] arrayOfMetaText = (ComposerActivity.MetaText[])localSpannableStringBuilder.getSpans(0, localSpannableStringBuilder.length(), ComposerActivity.MetaText.class);
    int i = localSpannableStringBuilder.length();
    int j = arrayOfMetaText.length;
    int k = 0;
    int m;
    if (k < j)
    {
      m = localSpannableStringBuilder.getSpanStart(arrayOfMetaText[k]);
      if ((m == -1) || (m >= i))
        break label81;
    }
    while (true)
    {
      k++;
      i = m;
      break;
      return Math.max(0, i);
      label81: m = i;
    }
  }

  private Location a(Uri paramUri)
  {
    float[] arrayOfFloat = new float[2];
    try
    {
      if (new ExifInterface(paramUri.getPath()).getLatLong(arrayOfFloat))
      {
        localLocation = new Location("photo-exif");
        localLocation.setLatitude(arrayOfFloat[0]);
        localLocation.setLongitude(arrayOfFloat[1]);
      }
      while (true)
      {
        return localLocation;
        localLocation = null;
      }
    }
    catch (IOException localIOException)
    {
      while (true)
        Location localLocation = null;
    }
  }

  private String a(PrivacySetting paramPrivacySetting, long paramLong)
  {
    long l = getIntent().getLongExtra("extra_actor_profile_id", -1L);
    FacebookUser localFacebookUser;
    if (l != -1L)
      localFacebookUser = new FacebookUser(l, null, null, getIntent().getStringExtra("extra_actor_profile_name"), getIntent().getStringExtra("extra_actor_profile_pic_uri"));
    while (true)
    {
      FeedStory localFeedStory = FeedStoryPreview.a(getApplicationContext(), new SpannableStringBuilder(am()), localFacebookUser, this.t, this.x, paramPrivacySetting, paramLong, (FeedLinkifyUtil)C().a(FeedLinkifyUtil.class), this.ax, this.au);
      try
      {
        String str2 = ((ObjectMapper)C().a(ObjectMapper.class)).writeValueAsString(localFeedStory);
        str1 = str2;
        return str1;
        localFacebookUser = this.o.b().a();
      }
      catch (IOException localIOException)
      {
        while (true)
          String str1 = null;
      }
    }
  }

  private void a(long paramLong)
  {
    SharedPreferences.Editor localEditor = getSharedPreferences("composer_prefs", 0).edit();
    localEditor.putLong("user_profile_last_update", paramLong);
    localEditor.commit();
  }

  public static void a(Context paramContext)
  {
    new ComposerActivity.34(paramContext).start();
  }

  private void a(Intent paramIntent)
  {
    Iterator localIterator1 = this.u.keySet().iterator();
    while (localIterator1.hasNext())
    {
      Long localLong = (Long)localIterator1.next();
      this.t.remove(localLong);
      Iterator localIterator2 = this.s.iterator();
      while (localIterator2.hasNext())
      {
        if (((FacebookProfile)localIterator2.next()).mId != localLong.longValue())
          continue;
        localIterator2.remove();
      }
    }
    Parcelable[] arrayOfParcelable = paramIntent.getParcelableArrayExtra("result_tags");
    if ((arrayOfParcelable != null) && (arrayOfParcelable.length > 0))
    {
      int i = arrayOfParcelable.length;
      int j = 0;
      if (j < i)
      {
        FacebookPhotoTag localFacebookPhotoTag = (FacebookPhotoTag)arrayOfParcelable[j];
        if ((localFacebookPhotoTag.a() <= 0L) || (this.ax.a(this, localFacebookPhotoTag.a()) == null));
        while (true)
        {
          j++;
          break;
          this.t.add(Long.valueOf(localFacebookPhotoTag.a()));
          this.s.add(new FacebookProfile(localFacebookPhotoTag.a(), localFacebookPhotoTag.f(), localFacebookPhotoTag.h(), 0));
        }
      }
    }
    R();
    S();
    T();
  }

  private void a(Intent paramIntent, String paramString1, long paramLong, String paramString2)
  {
    paramIntent.putExtra("extra_status_text", paramString1);
    paramIntent.putExtra("extra_tagged_ids", IntentUtils.a(this.t));
    if (this.x != null)
    {
      paramIntent.putExtra("extra_place", this.x);
      if (this.A != null)
        paramIntent.putExtra("extra_tagged_location", this.A);
    }
    while (true)
    {
      if (this.H)
        paramIntent.putExtra("extra_xed_location", true);
      if (!this.aj)
        paramIntent.putExtra("extra_fixed_audience_id", paramLong);
      if (!StringUtils.c(paramString2))
        paramIntent.putExtra("extra_status_privacy", paramString2);
      if ((this.af) && (this.x != null))
        paramIntent.putExtra("extra_is_checkin", true);
      if (this.ag)
      {
        paramIntent.putExtra("extra_is_recommendation", true);
        paramIntent.putExtra("extra_target_page", this.ak);
      }
      return;
      if (this.G == null)
        continue;
      paramIntent.putExtra("extra_tagged_place_id", String.valueOf(this.G.b));
    }
  }

  private void a(Bitmap paramBitmap)
  {
    this.ay.setImageBitmap(paramBitmap);
    this.ay.setVisibility(0);
    ar();
  }

  private void a(Location paramLocation)
  {
    if ((this.G != null) && (this.ad != null) && (paramLocation.distanceTo(this.ad) < 20.0F));
    while (true)
    {
      return;
      if ((paramLocation != null) && (!this.ag))
      {
        this.ad = paramLocation;
        Locale localLocale = (Locale)null;
        Object[] arrayOfObject = new Object[4];
        arrayOfObject[0] = Double.valueOf(paramLocation.getLatitude());
        arrayOfObject[1] = Double.valueOf(paramLocation.getLongitude());
        arrayOfObject[2] = GeoRegion.Type.city;
        arrayOfObject[3] = GeoRegion.Type.state;
        String str = FqlGetNearbyRegions.a(this, String.format(localLocale, "latitude='%f' and longitude='%f' and type in ('%s','%s')", arrayOfObject));
        this.ac.add(str);
        continue;
      }
    }
  }

  private void a(View paramView, Animation paramAnimation, Callable<Void> paramCallable)
  {
    paramAnimation.setAnimationListener(new ComposerActivity.3(this, paramView, paramCallable));
  }

  private void a(LinearLayout paramLinearLayout)
  {
    boolean bool = this.P;
    ComposerActivity.19 local19 = null;
    if (!bool)
      local19 = new ComposerActivity.19(this);
    a(paramLinearLayout, ComposerActivity.InOutAnimationType.DIRECT_IN_FADE_OUT, local19);
  }

  private void a(Shareable paramShareable)
  {
    if (paramShareable != null);
    for (LinksPreviewParams localLinksPreviewParams = new LinksPreviewParams(paramShareable.id, null); ; localLinksPreviewParams = new LinksPreviewParams(null, getIntent().getStringExtra("extra_link_for_share")))
    {
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("linksPreviewParams", localLinksPreviewParams);
      Futures.a(this.at.a("links_preview", localBundle).d(), new ComposerActivity.20(this, paramShareable));
      do
        return;
      while (!getIntent().hasExtra("extra_link_for_share"));
    }
  }

  private void a(Shareable paramShareable, SharePreview paramSharePreview)
  {
    View localView1 = f(2131296516);
    UrlImage localUrlImage = (UrlImage)f(2131296536);
    TextView localTextView1 = (TextView)f(2131296538);
    TextView localTextView2 = (TextView)f(2131296539);
    localTextView1.setText(paramSharePreview.a);
    localTextView2.setText(paramSharePreview.b);
    if (!StringUtils.c(paramSharePreview.d))
    {
      localUrlImage.setVisibility(0);
      localUrlImage.setImageParams(Uri.parse(paramSharePreview.d));
      if (b(paramShareable))
      {
        View localView2 = f(2131296537);
        localView2.setVisibility(0);
        localView2.bringToFront();
      }
    }
    Intent localIntent = (Intent)getIntent().getParcelableExtra("extra_share_preview_on_click");
    if (a(paramShareable, paramSharePreview, localIntent))
    {
      localView1.setClickable(true);
      localView1.setOnClickListener(new ComposerActivity.21(this, localIntent, paramSharePreview));
    }
    while (true)
    {
      localView1.setVisibility(0);
      return;
      localView1.setOnClickListener(null);
      localView1.setClickable(false);
    }
  }

  private void a(FacebookEvent paramFacebookEvent)
  {
    if (this.x != null);
    while (true)
    {
      return;
      UserSeenNux.a(this, UserSeenNux.Project.EVENT_TAG_EXPANSION, new ComposerActivity.1(this, paramFacebookEvent));
    }
  }

  private void a(FacebookEvent paramFacebookEvent, boolean paramBoolean)
  {
    int i;
    int j;
    int k;
    Object localObject;
    switch (ComposerActivity.35.a[this.Q.ordinal()])
    {
    default:
      i = 2131362864;
      j = 2131362863;
      k = 2131362865;
      if (paramFacebookEvent != null)
        break;
      localObject = getString(j);
      label58: if (paramFacebookEvent == null)
        this.N.setVisibility(8);
    case 1:
    case 2:
    }
    for (ComposerActivity.InOutAnimationType localInOutAnimationType = ComposerActivity.InOutAnimationType.FADE_IN_FADE_OUT; ; localInOutAnimationType = ComposerActivity.InOutAnimationType.FADE_IN_NO_OUT)
    {
      TextView localTextView = (TextView)findViewById(2131296530);
      LinearLayout localLinearLayout = (LinearLayout)findViewById(2131296528);
      localTextView.setText((CharSequence)localObject);
      a(localLinearLayout, localInOutAnimationType, null);
      A();
      return;
      i = 2131362867;
      j = 2131362866;
      k = 2131362868;
      break;
      i = 2131362861;
      j = 2131362860;
      k = 2131362862;
      break;
      String str1;
      if (paramFacebookEvent == null)
      {
        str1 = null;
        label162: if ((paramFacebookEvent == null) || (paramBoolean) || (!L()))
          break label233;
      }
      label233: for (boolean bool = true; ; bool = false)
      {
        this.P = bool;
        if (!this.P)
          break label239;
        String str2 = getString(k, new Object[] { str1 });
        this.L = System.currentTimeMillis();
        localObject = str2;
        break;
        str1 = paramFacebookEvent.b();
        break label162;
      }
      label239: localObject = getString(i, new Object[] { str1 });
      break label58;
      this.M.setVisibility(8);
      this.N.setVisibility(0);
      this.y = new FacebookPlace(paramFacebookEvent);
      this.x = this.y;
      this.z = false;
      this.N.setChecked(true);
    }
  }

  private void a(String paramString)
  {
    SpannableStringBuilder localSpannableStringBuilder1;
    String str1;
    label25: String str2;
    String str3;
    if (paramString != null)
    {
      localSpannableStringBuilder1 = new SpannableStringBuilder(paramString);
      if (!ak())
        break label368;
      str1 = an();
      str2 = ao();
      if ((str1 == null) || (this.x != null))
        break label373;
      str3 = getString(2131363192, new Object[] { str1 });
    }
    while (true)
    {
      if (str3 != null)
      {
        SpannableStringBuilder localSpannableStringBuilder2 = new SpannableStringBuilder(" — ");
        localSpannableStringBuilder2.append(str3);
        localSpannableStringBuilder2.setSpan(new ComposerActivity.MetaText(this, 2131165255), 0, localSpannableStringBuilder2.length(), 33);
        int i = getResources().getColor(2131165440);
        if (str1 != null)
        {
          int m = localSpannableStringBuilder2.toString().indexOf(str1);
          localSpannableStringBuilder2.setSpan(new ForegroundColorSpan(i), m, m + str1.length(), 33);
          localSpannableStringBuilder2.setSpan(new ComposerActivity.31(this), m, m + str1.length(), 33);
        }
        if (this.x != null)
        {
          int k = localSpannableStringBuilder2.toString().indexOf(this.x.mName);
          localSpannableStringBuilder2.setSpan(new ForegroundColorSpan(i), k, k + this.x.mName.length(), 33);
          localSpannableStringBuilder2.setSpan(new ComposerActivity.32(this), k, k + this.x.mName.length(), 33);
        }
        if (str2 != null)
        {
          int j = localSpannableStringBuilder2.toString().indexOf(str2);
          localSpannableStringBuilder2.setSpan(new ForegroundColorSpan(i), j, j + str2.length(), 33);
          localSpannableStringBuilder2.setSpan(new ComposerActivity.33(this), j, j + str2.length(), 33);
        }
        localSpannableStringBuilder1.append(localSpannableStringBuilder2);
      }
      this.n.setText(localSpannableStringBuilder1);
      return;
      localSpannableStringBuilder1 = new SpannableStringBuilder(am());
      break;
      label368: str1 = null;
      break label25;
      label373: if ((this.x != null) && (str1 == null))
      {
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = this.x.mName;
        str3 = getString(2131363193, arrayOfObject2);
        continue;
      }
      str3 = null;
      if (str1 == null)
        continue;
      FacebookPlace localFacebookPlace = this.x;
      str3 = null;
      if (localFacebookPlace == null)
        continue;
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = str1;
      arrayOfObject1[1] = this.x.mName;
      str3 = getString(2131363194, arrayOfObject1);
    }
  }

  private void a(List<MediaItem> paramList)
  {
    ListIterator localListIterator = paramList.listIterator();
    while (localListIterator.hasNext())
    {
      if (new File(((MediaItem)localListIterator.next()).b()).exists())
        continue;
      localListIterator.remove();
      this.au.a("ComposerActivity", "Tried to share nonexistent photo");
    }
    this.r = paramList;
    this.az.setAttachments(paramList);
    this.az.setItemClickedListener(this);
    aq();
    if (paramList.size() == 1)
      this.Q = ComposerActivity.TipMode.TAG_PHOTO_PLACE_TIP;
    while (true)
    {
      a(getIntent());
      ar();
      E();
      return;
      if (paramList.size() > 1)
      {
        this.Q = ComposerActivity.TipMode.TAG_PHOTOS_PLACE_TIP;
        continue;
      }
      if (paramList.size() != 0)
        continue;
      this.aa = null;
    }
  }

  private boolean a(Shareable paramShareable, SharePreview paramSharePreview, Intent paramIntent)
  {
    int i = 1;
    if (paramIntent != null);
    while (true)
    {
      return i;
      if (paramShareable != null)
      {
        if ((paramShareable.b() == GraphQLObjectType.ObjectType.ExternalUrl) && (!StringUtils.c(paramSharePreview.e)))
          continue;
        i = 0;
        continue;
      }
      if (!StringUtils.c(paramSharePreview.e))
        continue;
      i = 0;
    }
  }

  private boolean aa()
  {
    int i = 1;
    Configuration localConfiguration = getResources().getConfiguration();
    if (localConfiguration.orientation == 2);
    while (true)
    {
      return i;
      if ((0xF & localConfiguration.screenLayout) >= 3)
        continue;
      i = 0;
    }
  }

  private long ab()
  {
    return getSharedPreferences("composer_prefs", 0).getLong("user_profile_last_update", 0L);
  }

  private boolean ac()
  {
    Iterator localIterator = this.r.iterator();
    do
      if (!localIterator.hasNext())
        break;
    while (((MediaItem)localIterator.next()).g());
    for (int i = 0; ; i = 1)
      return i;
  }

  @TargetApi(11)
  private AlertDialog.Builder ad()
  {
    if (Build.VERSION.SDK_INT >= 14);
    for (AlertDialog.Builder localBuilder = new AlertDialog.Builder(this, 4); ; localBuilder = new AlertDialog.Builder(this))
      return localBuilder;
  }

  private void ae()
  {
    AlertDialog.Builder localBuilder = ad();
    localBuilder.setCancelable(false);
    localBuilder.setTitle(getString(2131362848));
    localBuilder.setMessage(getString(2131362857));
    localBuilder.setPositiveButton(getString(2131363280), new ComposerActivity.26(this));
    localBuilder.setNegativeButton(getString(2131363016), new ComposerActivity.27(this));
    localBuilder.create().show();
  }

  private void af()
  {
    boolean bool = "group".equals(this.X);
    Intent localIntent = null;
    long l;
    if (bool)
    {
      localIntent = new Intent(this, GroupMemberMultiSelectorActivity.class);
      l = getIntent().getLongExtra("target_id", -1L);
      if (l == -1L)
        this.au.a("TagPeopleHandler", "Unknown group Id : " + l, true);
    }
    while (true)
    {
      return;
      localIntent.putExtra("group_id", l);
      localIntent.putExtra("full_profiles", IntentUtils.a(this.s));
      if (localIntent == null)
        localIntent = new Intent(this, FriendMultiSelectorActivity.class);
      HashSet localHashSet = new HashSet();
      localHashSet.addAll(this.t);
      localHashSet.remove(Long.valueOf(this.o.b().userId));
      localIntent.putExtra("profiles", IntentUtils.a(localHashSet));
      startActivityForResult(localIntent, 1);
    }
  }

  private void ag()
  {
    this.n = ((EditText)findViewById(2131296520));
    this.n.setMovementMethod(new ComposerActivity.ComposerMovementMethod(this));
    this.n.requestFocus();
    String str = getSharedPreferences("extra_composer_setting", 0).getString("extra_last_status_update", "");
    if (str.length() > 0)
    {
      this.o.i(getApplicationContext());
      this.n.setText(MentionsSpannableStringBuilder.a(str, getResources()));
      this.n.setSelection(str.length());
    }
    while (true)
    {
      ComposerActivity.28 local28 = new ComposerActivity.28(this);
      findViewById(2131296517).setOnClickListener(local28);
      View localView = findViewById(2131296521);
      localView.setOnClickListener(local28);
      localView.setOnTouchListener(new ComposerActivity.29(this, localView));
      localView.setOnLongClickListener(new ComposerActivity.30(this));
      return;
      this.n.setSelection(0, 0);
    }
  }

  private void ah()
  {
    ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(this.n.getWindowToken(), 0);
  }

  private void ai()
  {
    ah();
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    localInputMethodManager.toggleSoftInput(0, 0);
    localInputMethodManager.showSoftInput(this.n, 0);
  }

  private void aj()
  {
    UrlImage localUrlImage = (UrlImage)findViewById(2131296518);
    String str;
    if (getIntent().getBooleanExtra("extra_acts_as_target", false))
      str = getIntent().getStringExtra("extra_actor_profile_pic_uri");
    while (true)
    {
      localUrlImage.setPlaceHolderDrawable(getResources().getDrawable(2130838447));
      if (str != null)
        localUrlImage.setImageParams(Uri.parse(str));
      return;
      FacebookProfile localFacebookProfile = this.p;
      str = null;
      if (localFacebookProfile == null)
        continue;
      str = this.p.mImageUrl;
    }
  }

  private boolean ak()
  {
    if ((this.t != null) && (this.t.size() > 0));
    for (int i = 1; ; i = 0)
      return i;
  }

  private int al()
  {
    if (this.t != null);
    for (int i = this.t.size(); ; i = 0)
      return i;
  }

  private CharSequence am()
  {
    int i = a(this.n.getText());
    return new SpannableString(this.n.getText()).subSequence(0, i);
  }

  private String an()
  {
    HashSet localHashSet = new HashSet(this.t);
    localHashSet.remove(Long.valueOf(this.o.b().userId));
    int i = localHashSet.size();
    Object localObject = null;
    if (i == 0)
      return localObject;
    long l = ((Long)new ArrayList(localHashSet).get(0)).longValue();
    FacebookProfile localFacebookProfile = this.ax.a(this, l);
    String str;
    if (localFacebookProfile != null)
    {
      str = localFacebookProfile.mDisplayName;
      label93: if (localHashSet.size() != 1)
        break label149;
    }
    while (true)
    {
      localObject = str;
      break;
      if (this.s.size() > 0)
      {
        str = ((FacebookProfile)this.s.get(0)).mDisplayName;
        break label93;
      }
      str = null;
      break label93;
      label149: if (localHashSet.size() == 2)
      {
        str = getString(2131363189, new Object[] { str });
        continue;
      }
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = str;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = Integer.valueOf(-1 + localHashSet.size());
      arrayOfObject1[1] = getString(2131363190, arrayOfObject2);
      str = getString(2131363191, arrayOfObject1);
    }
  }

  private String ao()
  {
    TimeAdapter localTimeAdapter = this.E;
    String str = null;
    if (localTimeAdapter == null);
    while (true)
    {
      return str;
      TimeAdapter.Period localPeriod = this.E.f();
      str = null;
      if (localPeriod == null)
        continue;
      str = localPeriod.localizedString(this);
    }
  }

  private void ap()
  {
    aq();
    a(new ArrayList());
  }

  private void aq()
  {
    this.ay.setImageBitmap(null);
    this.ay.setVisibility(8);
    this.R = null;
  }

  private void ar()
  {
    if (m());
    for (int i = 2130838163; ; i = 2130838162)
    {
      this.D.setImageResource(i);
      return;
    }
  }

  private PhotoFlowLogger.ComposerType as()
  {
    PhotoFlowLogger.ComposerType localComposerType = PhotoFlowLogger.ComposerType.STATUS;
    if (this.af)
      localComposerType = PhotoFlowLogger.ComposerType.CHECKIN;
    while (true)
    {
      return localComposerType;
      if (!this.ai)
        continue;
      localComposerType = PhotoFlowLogger.ComposerType.PHOTO;
    }
  }

  private long b(Uri paramUri)
  {
    Date localDate;
    do
      try
      {
        ExifInterface localExifInterface = new ExifInterface(paramUri.getPath());
        String str1 = localExifInterface.getAttribute("GPSDateStamp");
        String str2 = localExifInterface.getAttribute("GPSTimeStamp");
        if ((str1 != null) && (str2 != null))
        {
          localDate = aG.parse(str1 + ' ' + str2);
        }
        else
        {
          String str3 = localExifInterface.getAttribute("DateTime");
          if (str3 == null)
          {
            localDate = null;
          }
          else
          {
            localDate = aH.parse(str3);
            continue;
            long l2 = localDate.getTime();
            l1 = l2;
          }
        }
      }
      catch (IOException localIOException)
      {
        l1 = -1L;
      }
      catch (ParseException localParseException)
      {
        l1 = -1L;
      }
    while (localDate != null);
    long l1 = -1L;
    return l1;
  }

  private long b(MediaItem paramMediaItem)
  {
    Uri localUri = Uri.fromFile(new File(paramMediaItem.b()));
    long l;
    switch (ComposerActivity.35.d[paramMediaItem.e().ordinal()])
    {
    default:
      l = -1L;
    case 1:
    case 2:
    }
    while (true)
    {
      if (l == -1L)
        l = paramMediaItem.d();
      return l;
      l = b(localUri);
      continue;
      l = d(localUri);
    }
  }

  public static void b(Context paramContext)
  {
    File localFile1 = d(paramContext);
    File[] arrayOfFile;
    if (localFile1.exists())
    {
      arrayOfFile = localFile1.listFiles();
      if (arrayOfFile != null)
        break label70;
      ErrorReporting.a("ComposerActivity:clearTempFiles", "dir.listFiles is null but exists. \nisDir: " + localFile1.isDirectory() + "path: " + localFile1.getPath(), true);
    }
    while (true)
    {
      localFile1.delete();
      return;
      label70: int i = arrayOfFile.length;
      for (int j = 0; j < i; j++)
      {
        File localFile2 = arrayOfFile[j];
        if (!localFile2.exists())
          continue;
        localFile2.delete();
      }
    }
  }

  private void b(String paramString)
  {
    this.an.a(paramString, FB4A_AnalyticEntities.Modules.a);
  }

  private void b(List<MediaUploaderController.MediaUnpublishedPhoto> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      MediaUploaderController.MediaUnpublishedPhoto localMediaUnpublishedPhoto = (MediaUploaderController.MediaUnpublishedPhoto)localIterator.next();
      this.K.put(localMediaUnpublishedPhoto.a(), localMediaUnpublishedPhoto);
    }
  }

  private boolean b(Shareable paramShareable)
  {
    if ((paramShareable != null) && (paramShareable.b() == GraphQLObjectType.ObjectType.Video));
    for (int i = 1; ; i = 0)
      return i;
  }

  private Location c(Uri paramUri)
  {
    return null;
  }

  private void c(int paramInt)
  {
    findViewById(paramInt).setVisibility(8);
    ai();
    this.S = null;
  }

  private void c(MediaItem paramMediaItem)
  {
    if (this.r != null);
    for (ArrayList localArrayList = Lists.a(this.r); ; localArrayList = Lists.a())
    {
      this.ao.a(as());
      Intent localIntent = new Intent(this, MediaPickerActivity.class);
      localIntent.putExtra("extra_for_result", true);
      localIntent.putParcelableArrayListExtra("extra_selection", localArrayList);
      if (paramMediaItem != null)
        localIntent.putExtra("extra_focused_item", paramMediaItem);
      if (this.J != null)
        localIntent.putExtra("extra_environment", this.J);
      localIntent.putExtra("camera_session_id", this.aw);
      localIntent.putExtra("extra_source_activity", getClass().getSimpleName());
      startActivityForResult(localIntent, 125);
      return;
    }
  }

  private boolean c(boolean paramBoolean)
  {
    int i;
    if (this.ah)
      i = 0;
    while (true)
    {
      return i;
      PrivacySetting localPrivacySetting = K();
      if ((this.U == null) || (this.Z.getAudienceType() != ComposerAudienceSelectorButton.AudienceType.SELECTABLE) || (localPrivacySetting == null) || (localPrivacySetting.value != "SELF"))
      {
        i = 0;
        continue;
      }
      TextView localTextView = (TextView)findViewById(2131296535);
      if ((paramBoolean) && (!this.aC) && (this.aB.a(aE) < aF))
      {
        if (localTextView.getVisibility() != 0)
          this.aB.c(aE);
        a(localTextView, ComposerActivity.InOutAnimationType.FADE_IN_NO_OUT, null);
        i = 1;
        continue;
      }
      if ((!paramBoolean) && (localTextView.getVisibility() != 8))
      {
        this.aC = true;
        localTextView.setVisibility(8);
      }
      i = 0;
    }
  }

  private long d(Uri paramUri)
  {
    long l = new File(this.as.b(paramUri, getContentResolver())).lastModified();
    if (l == 0L)
      l = -1L;
    return l;
  }

  private static File d(Context paramContext)
  {
    return paramContext.getDir("composer_temp", 0);
  }

  private void d(boolean paramBoolean)
  {
    if ((this.x != null) && (this.x.c() != null))
    {
      PrivacySetting localPrivacySetting = K();
      if ((localPrivacySetting != null) && ((localPrivacySetting.value.equals("EVERYONE")) || (localPrivacySetting.value.equals("ALL_FRIENDS")) || (localPrivacySetting.value.equals("FRIENDS_OF_FRIENDS"))));
    }
    else
    {
      return;
    }
    label98: TextView localTextView;
    if (((LinearLayout)findViewById(2131296528)).getVisibility() == 8)
    {
      if (!paramBoolean)
        break label123;
      this.M.setText(2131362876);
      localTextView = this.M;
      if (!paramBoolean)
        break label143;
    }
    label143: for (ComposerActivity.InOutAnimationType localInOutAnimationType = ComposerActivity.InOutAnimationType.FADE_IN_FADE_OUT; ; localInOutAnimationType = ComposerActivity.InOutAnimationType.FADE_IN_NO_OUT)
    {
      a(localTextView, localInOutAnimationType, null);
      break;
      break;
      label123: this.M.setText(2131362875);
      this.L = System.currentTimeMillis();
      break label98;
    }
  }

  protected void A()
  {
    l();
    a(null);
    j();
  }

  public void B()
  {
    c(null);
  }

  public String a()
  {
    return FB4A_AnalyticEntities.k;
  }

  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    a(this);
    this.o = AppSession.b(this, true);
    if (this.o == null)
    {
      LoginActivity.c(this);
      finish();
      return;
    }
    FbInjector localFbInjector = C();
    this.at = ((OrcaServiceOperationFactory)localFbInjector.a(OrcaServiceOperationFactory.class));
    this.au = ((FbErrorReporter)localFbInjector.a(FbErrorReporter.class));
    this.aB = ((UiCounters)localFbInjector.a(UiCounters.class));
    this.ax = ((ConnectionsProviderInjectable)localFbInjector.a(ConnectionsProviderInjectable.class));
    this.an = ((InteractionLogger)localFbInjector.a(InteractionLogger.class));
    this.ap = ((EventTaggingAnalyticsLogger)localFbInjector.a(EventTaggingAnalyticsLogger.class));
    this.aq = ((AggressiveSuggestionPreferences)localFbInjector.a(AggressiveSuggestionPreferences.class));
    this.as = ((Storage)localFbInjector.a(Storage.class));
    this.ao = ((PhotoFlowLogger)localFbInjector.a(PhotoFlowLogger.class));
    this.aw = getIntent().getStringExtra("camera_session_id");
    this.W = getIntent().getLongExtra("extra_fixed_audience_id", -1L);
    this.X = getIntent().getStringExtra("publisher_type");
    this.ah = getIntent().getBooleanExtra("extra_is_share", false);
    this.ar = getIntent().getStringExtra("nectar_module");
    setContentView(2130903105);
    if (getIntent().hasExtra("extra_composer_initial_text"))
    {
      String str2 = getIntent().getStringExtra("extra_composer_initial_text");
      ((TextView)findViewById(2131296520)).setText(str2);
    }
    if (getIntent().hasExtra("extra_tagged_ids"))
      for (long l : getIntent().getLongArrayExtra("extra_tagged_ids"))
        this.t.add(Long.valueOf(l));
    if (getIntent().hasExtra("extra_media_privacy_override"))
      this.ab = getIntent().getStringExtra("extra_media_privacy_override");
    this.af = getIntent().getBooleanExtra("extra_is_checkin", false);
    this.ag = getIntent().getBooleanExtra("extra_is_recommendation", false);
    this.ak = getIntent().getLongExtra("extra_target_page", -1L);
    this.ay = ((ImageView)findViewById(2131296522));
    this.ay.setOnClickListener(new ComposerActivity.4(this));
    this.q = new ArrayList();
    this.q.add(new ComposerActivity.ComposerAppSessionListener(this, null));
    this.p = FacebookProfileUtil.a(this.o.b().a());
    this.al = new ArrayList();
    this.am = new Handler();
    ((TextView)findViewById(2131296686)).setText(M());
    this.S = null;
    ag();
    N();
    boolean bool1 = getIntent().getBooleanExtra("extra_enable_friend_tagging", true);
    View localView1 = findViewById(2131296527);
    View localView2 = findViewById(2131296526);
    label708: View localView5;
    label897: Intent localIntent;
    label1063: ArrayList localArrayList1;
    String str1;
    if (bool1)
    {
      localView2.setOnClickListener(new ComposerActivity.5(this));
      localView1.setOnClickListener(new ComposerActivity.6(this));
      ((MentionsAutoCompleteTextView)this.n).b(this);
      this.N = ((CheckBox)findViewById(2131296531));
      this.N.setOnCheckedChangeListener(new ComposerActivity.7(this));
      boolean bool2 = getIntent().getBooleanExtra("extra_enable_location", true);
      View localView3 = findViewById(2131296529);
      View localView4 = findViewById(2131296528);
      if (bool2)
        break label1689;
      localView3.setVisibility(8);
      localView4.setVisibility(8);
      this.M = ((TextView)findViewById(2131296534));
      findViewById(2131296544).setOnClickListener(new ComposerActivity.9(this));
      boolean bool3 = getIntent().getBooleanExtra("extra_enable_attach_album_photos", true);
      localView5 = findViewById(2131296543);
      if (!bool3)
        break label1710;
      localView5.setOnClickListener(new ComposerActivity.10(this));
      Uri localUri = ContentUris.withAppendedId(PhotosProvider.g, this.o.b().userId);
      this.C = ((AlbumsAdapterFactory)localFbInjector.a(AlbumsAdapterFactory.class)).a(this, localUri, "type IN (\"normal\", \"mobile\")", "type ASC, modified DESC", this.o);
      if (this.C.getCount() == 0)
        this.o.a(this, this.o.b().userId, null);
      this.V = ((ListView)findViewById(2131296546));
      this.V.setOnItemClickListener(new ComposerActivity.11(this));
      this.V.setAdapter(this.C);
      if (this.af)
        ((MentionsAutoCompleteTextView)this.n).setAdapter((ArrayAdapter)null);
      if (paramBundle != null)
      {
        this.x = ((FacebookPlace)paramBundle.getParcelable(ComposerActivity.StateKeys.a));
        this.A = ((Location)paramBundle.getParcelable(ComposerActivity.StateKeys.b));
        this.H = paramBundle.getBoolean(ComposerActivity.StateKeys.c);
        this.G = ((GeoRegion.ImplicitLocation)paramBundle.getParcelable(ComposerActivity.StateKeys.d));
        this.I = paramBundle.getBoolean(ComposerActivity.StateKeys.e);
        this.av = paramBundle.getBoolean(ComposerActivity.StateKeys.f);
        A();
      }
      localIntent = getIntent();
      if ((!localIntent.hasExtra("tagged_place_profile")) || (!localIntent.hasExtra("tagged_place_location")))
        break label1720;
      this.x = ((FacebookPlace)localIntent.getParcelableExtra("tagged_place_profile"));
      this.A = ((Location)localIntent.getParcelableExtra("tagged_place_location"));
      A();
      localArrayList1 = localIntent.getParcelableArrayListExtra("extra_media_items");
      if (localIntent.hasExtra("extra_media_unpublished_items"))
        b(localIntent.getParcelableArrayListExtra("extra_media_unpublished_items"));
      boolean bool4 = StringUtil.a(this.aw);
      str1 = null;
      if (!bool4)
      {
        str1 = this.aw;
        this.ai = true;
      }
      if (!localIntent.hasExtra("extra_media_retry_waterfall_id"))
        break label2128;
      this.aw = localIntent.getExtras().getString("extra_media_retry_waterfall_id");
    }
    label1689: label1710: label1720: label2122: label2128: for (int i = 1; ; i = 0)
    {
      if (StringUtil.a(this.aw))
        this.aw = ((WaterfallIdGenerator)FbInjector.a(getApplicationContext()).a(WaterfallIdGenerator.class)).a();
      this.ao.a(this.aw);
      if (i != 0)
        this.ao.b(false);
      if (!StringUtil.a(str1))
        this.ao.d(str1);
      int j = localIntent.getIntExtra("extra_video_request_code", -1);
      boolean bool5;
      if (j == 2)
      {
        this.R = localIntent.getData();
        bool5 = false;
      }
      while (true)
      {
        label1257: if (this.R != null)
        {
          this.Q = ComposerActivity.TipMode.TAG_VIDEO_PLACE_TIP;
          new ComposerActivity.VideoThumbnailerTask(this, this, this.R).execute(new Void[0]);
        }
        this.ao.a(this.af, this.ah, bool5, as());
        P();
        aj();
        findViewById(2131296529).setOnClickListener(new ComposerActivity.12(this));
        this.Y = getIntent().getBooleanExtra("extra_enable_privacy", true);
        this.Z = ((ComposerAudienceSelectorButton)findViewById(2131296533));
        this.Z.setOnClickListener(new ComposerActivity.13(this));
        this.B = ((AudienceAdapter)localFbInjector.a(AudienceAdapter.class));
        this.B.a(this, Boolean.TRUE.equals(MinorStatus.a(this)));
        this.U = ((OverlaySelectorView)findViewById(2131296545));
        this.U.setOnItemClickListener(new ComposerActivity.14(this));
        this.U.setSectionedListAdapter(this.B);
        this.U.setOnFillerClickListener(new ComposerActivity.15(this));
        U();
        boolean bool6 = getIntent().getBooleanExtra("extra_enable_photos", true);
        this.D = ((ImageButton)findViewById(2131296542));
        label1522: ArrayList localArrayList2;
        int k;
        if (bool6)
        {
          this.D.setOnClickListener(new ComposerActivity.16(this));
          this.az = ((ComposerAttachmentsView)findViewById(2131296523));
          this.az.setPickerEnvironment(this.J);
          localArrayList2 = Lists.a();
          k = localIntent.getIntExtra("extra_photo_request_code", -1);
          if (k != 1)
            break label1803;
          localArrayList2.add(localIntent.getData());
        }
        ArrayList localArrayList4;
        while (true)
        {
          if (localArrayList2.isEmpty())
            break label2081;
          localArrayList4 = Lists.a();
          MediaItemFactory localMediaItemFactory = (MediaItemFactory)localFbInjector.a(MediaItemFactory.class);
          localMediaItemFactory.a(getContentResolver());
          Iterator localIterator1 = localArrayList2.iterator();
          while (localIterator1.hasNext())
          {
            MediaItem localMediaItem = localMediaItemFactory.a((Uri)localIterator1.next());
            if (localMediaItem == null)
              continue;
            localArrayList4.add(localMediaItem);
          }
          localView2.setVisibility(8);
          localView1.setVisibility(8);
          break;
          findViewById(2131296528).setOnClickListener(new ComposerActivity.8(this));
          break label708;
          localView5.setVisibility(8);
          break label897;
          if ((!this.af) || (!this.av))
            break label1063;
          this.Q = ComposerActivity.TipMode.TAG_WITH_TIP;
          launchPlacesNearby(null);
          break label1063;
          if (j != 2544)
            break label2122;
          this.R = localIntent.getData();
          if (this.R == null)
            break label2122;
          this.ao.a(this.R);
          bool5 = true;
          break label1257;
          this.D.setVisibility(8);
          break label1522;
          if (k == 2542)
          {
            Parcelable localParcelable2 = localIntent.getExtras().getParcelable("android.intent.extra.STREAM");
            if ((localParcelable2 instanceof Uri))
              localArrayList2.add((Uri)localParcelable2);
            if (localArrayList2.size() <= 0)
              continue;
            this.ao.b(localArrayList2.size());
            continue;
          }
          if (k != 2543)
            continue;
          ArrayList localArrayList3 = localIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
          if (localArrayList3 != null)
          {
            Iterator localIterator2 = localArrayList3.iterator();
            while (localIterator2.hasNext())
            {
              Parcelable localParcelable1 = (Parcelable)localIterator2.next();
              if (!(localParcelable1 instanceof Uri))
                continue;
              localArrayList2.add((Uri)localParcelable1);
            }
          }
          if (localArrayList2.size() <= 0)
            continue;
          this.ao.b(localArrayList2.size());
        }
        if (!localArrayList4.isEmpty())
          a(localArrayList4);
        while (true)
        {
          Q();
          if (!this.ah)
            break label2095;
          findViewById(2131296527).setVisibility(8);
          findViewById(2131296529).setVisibility(8);
          findViewById(2131296542).setVisibility(8);
          findViewById(2131296543).setVisibility(8);
          ((ComposerEditText)findViewById(2131296520)).setHint(2131361975);
          V();
          this.F = TargetSelectorActivity.Target.OWN_TIMELINE;
          break;
          if (localArrayList1 == null)
            continue;
          a(localArrayList1);
        }
        this.ae = new ComposerActivity.17(this);
        this.I = ComposerUserSettings.a(this);
        E();
        break;
        bool5 = false;
      }
    }
  }

  protected void a(View paramView, ComposerActivity.InOutAnimationType paramInOutAnimationType, Callable<Void> paramCallable)
  {
    Animation localAnimation;
    switch (ComposerActivity.35.b[paramInOutAnimationType.ordinal()])
    {
    default:
      throw new IllegalArgumentException("Invalid animation type: " + paramInOutAnimationType);
    case 1:
      localAnimation = AnimationUtils.loadAnimation(this, 2130968624);
      a(paramView, localAnimation, paramCallable);
    case 2:
    case 3:
    }
    while (true)
    {
      paramView.setVisibility(0);
      paramView.startAnimation(localAnimation);
      return;
      localAnimation = AnimationUtils.loadAnimation(this, 2130968623);
      a(paramView, localAnimation, paramCallable);
      continue;
      localAnimation = AnimationUtils.loadAnimation(this, 2130968622);
    }
  }

  public void a(MediaItem paramMediaItem)
  {
    c(paramMediaItem);
  }

  protected void a(AudienceSettings paramAudienceSettings)
  {
    if (paramAudienceSettings == null)
      return;
    this.B.a(paramAudienceSettings);
    this.B.a(paramAudienceSettings.i());
    if (this.ag)
    {
      this.B.f();
      I();
    }
    while (true)
    {
      this.B.a = true;
      this.B.j();
      if (this.W != -1L)
        this.aj = this.B.a(this.W);
      r();
      if (c(true))
        break;
      p();
      break;
      this.B.a(paramAudienceSettings.h());
    }
  }

  public void closeTimeSelector(View paramView)
  {
    Y();
  }

  public String i()
  {
    return M();
  }

  public void j()
  {
    TextView localTextView = (TextView)findViewById(2131296525);
    boolean bool = getIntent().getBooleanExtra("extra_enable_location", true);
    if ((this.H) || (this.x != null) || (!bool))
      n();
    while (true)
    {
      return;
      if (this.G != null)
      {
        localTextView.setVisibility(0);
        localTextView.setText(this.G.a);
        continue;
      }
    }
  }

  public void k()
  {
    ImageButton localImageButton = (ImageButton)findViewById(2131296527);
    if ((this.t != null) && (al() > 0))
      localImageButton.setImageResource(2130837707);
    while (true)
    {
      return;
      localImageButton.setImageResource(2130837706);
    }
  }

  public void l()
  {
    ImageButton localImageButton = (ImageButton)findViewById(2131296529);
    if (this.x != null)
      localImageButton.setImageResource(2130837716);
    while (true)
    {
      return;
      localImageButton.setImageResource(2130837715);
    }
  }

  public void launchPlacesNearby(View paramView)
  {
    Intent localIntent = new Intent(this, SelectAtTagActivity.class);
    localIntent.putExtra("launched_for_place", true);
    if (this.x != null)
      localIntent.putExtra("extra_place", this.x);
    if ((this.r != null) && (!this.r.isEmpty()))
    {
      Uri localUri = Uri.fromFile(new File(((MediaItem)this.r.get(0)).b()));
      Location localLocation2 = a(localUri);
      long l2 = b(localUri);
      localIntent.putExtra("preset_search_location", localLocation2);
      localIntent.putExtra("preset_search_time", l2);
      localIntent.putExtra("search_type", SelectAtTagFetcher.SearchType.PHOTO);
    }
    while (true)
    {
      startActivityForResult(localIntent, 2);
      return;
      if (this.R != null)
      {
        Location localLocation1 = c(this.R);
        long l1 = d(this.R);
        localIntent.putExtra("preset_search_location", localLocation1);
        localIntent.putExtra("preset_search_time", l1);
        localIntent.putExtra("search_type", SelectAtTagFetcher.SearchType.VIDEO);
        continue;
      }
      if (this.af)
      {
        localIntent.putExtra("search_type", SelectAtTagFetcher.SearchType.CHECKIN);
        continue;
      }
      localIntent.putExtra("search_type", SelectAtTagFetcher.SearchType.STATUS);
    }
  }

  public boolean m()
  {
    if ((this.R != null) || (F()));
    for (int i = 1; ; i = 0)
      return i;
  }

  public void n()
  {
    findViewById(2131296525).setVisibility(8);
  }

  public void o()
  {
    if ((this.t == null) || (this.t.size() == 0))
      a(findViewById(2131296526), ComposerActivity.InOutAnimationType.FADE_IN_FADE_OUT, null);
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == 0) && (this.av) && (this.af))
      finish();
    Context localContext;
    HashSet localHashSet;
    Object localObject;
    while (true)
    {
      return;
      if (paramIntent == null)
        paramIntent = new Intent();
      Iterator localIterator3;
      switch (paramInt1)
      {
      default:
        break;
      case 1:
        if (paramInt2 != -1)
          continue;
        localContext = getApplicationContext();
        localHashSet = new HashSet();
        if (paramIntent.hasExtra("full_profiles"))
        {
          this.s = IntentUtils.a(paramIntent.getParcelableArrayExtra("full_profiles"));
          localIterator3 = this.s.iterator();
        }
      case 3:
        while (true)
          if (localIterator3.hasNext())
          {
            localHashSet.add(Long.valueOf(((FacebookProfile)localIterator3.next()).mId));
            continue;
            if (paramInt2 != -1)
              break;
            new ComposerActivity.TargetSelectorCallback(this, null).a(paramInt2, paramIntent);
            break;
          }
        localObject = localHashSet;
      case 2:
      case 124:
      case 125:
      }
    }
    while (true)
    {
      Iterator localIterator1 = Sets.a(Sets.a(this.t, (Set)localObject)).iterator();
      while (true)
      {
        if (!localIterator1.hasNext())
          break label386;
        Long localLong = (Long)localIterator1.next();
        if (localLong.longValue() == this.o.b().userId)
          continue;
        if (this.u.containsKey(localLong))
        {
          Iterator localIterator2 = ((ArrayList)this.u.get(localLong)).iterator();
          while (true)
            if (localIterator2.hasNext())
            {
              MediaTagController.a(localContext, (MediaItem)localIterator2.next(), localLong.longValue());
              continue;
              if (!paramIntent.hasExtra("profiles"))
                break label678;
              localObject = IntentUtils.a(paramIntent.getLongArrayExtra("profiles"));
              break;
            }
        }
        this.t.remove(localLong);
        this.u.remove(localLong);
      }
      label386: this.t = ((Set)localObject);
      T();
      break;
      if (paramInt2 != -1)
        break;
      this.H = paramIntent.getBooleanExtra("extra_xed_location", false);
      if (this.H)
      {
        this.x = null;
        this.A = null;
        this.G = null;
        this.I = false;
      }
      while (true)
      {
        A();
        this.av = false;
        break;
        if (paramIntent.hasExtra("extra_place"))
        {
          this.x = ((FacebookPlace)paramIntent.getParcelableExtra("extra_place"));
          if (this.x.c() != null)
            this.Q = ComposerActivity.TipMode.TAG_EVENT_EDUCATION_TIP;
          if (paramIntent.hasExtra("extra_nearby_location"))
            this.A = ((Location)paramIntent.getParcelableExtra("extra_nearby_location"));
        }
        if (paramIntent.hasExtra("extra_implicit_location"))
        {
          this.I = true;
          this.G = ((GeoRegion.ImplicitLocation)paramIntent.getParcelableExtra("extra_implicit_location"));
          continue;
        }
        if (this.x != null)
          continue;
        ai();
      }
      if (paramInt2 == 4)
      {
        ap();
        P();
      }
      a(paramIntent);
      break;
      if (paramInt2 == 2)
        if (paramIntent.getData() != null)
        {
          a(new ArrayList());
          this.R = paramIntent.getData();
          new ComposerActivity.VideoThumbnailerTask(this, this, this.R).execute(new Void[0]);
        }
      while (true)
      {
        ar();
        P();
        break;
        ArrayList localArrayList = paramIntent.getParcelableArrayListExtra("extra_media_items");
        if (localArrayList == null)
          localArrayList = Lists.a();
        a(localArrayList);
      }
      label678: localObject = localHashSet;
    }
  }

  public void onBackPressed()
  {
    if (this.S == ComposerActivity.OverlayMode.AUDIENCE_SELECTOR)
      W();
    while (true)
    {
      return;
      if (this.S == ComposerActivity.OverlayMode.ALBUM_SELECTOR)
      {
        X();
        continue;
      }
      if (this.S == ComposerActivity.OverlayMode.TIME_SELECTOR)
      {
        Y();
        continue;
      }
      if ((am().toString().trim().length() > 0) || (this.x != null) || ((this.t != null) && (al() > 0)))
      {
        ae();
        continue;
      }
      if (this.r != null)
      {
        ArrayList localArrayList = Lists.a(this.r);
        setResult(0, new Intent().putParcelableArrayListExtra("extra_media_items", localArrayList));
      }
      super.onBackPressed();
    }
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (getResources().getConfiguration().orientation == 2)
    {
      ((ComposerEditText)findViewById(2131296520)).setImeOptions(6);
      this.n.setImeOptions(6);
    }
    while (true)
    {
      return;
      if (this.S != null)
      {
        ai();
        continue;
      }
    }
  }

  protected Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default:
    case 100:
    }
    ComposerActivity.25 local25;
    for (Object localObject = super.onCreateDialog(paramInt); ; localObject = AlertDialogs.a(this, getString(2131362877), 0, getString(2131362878), getString(2131362879), local25, null, null, null, false))
    {
      return localObject;
      local25 = new ComposerActivity.25(this);
    }
  }

  protected void onDestroy()
  {
    if (this.al != null)
    {
      Iterator localIterator = this.al.iterator();
      while (localIterator.hasNext())
      {
        File localFile = (File)localIterator.next();
        if (localFile == null)
          continue;
        localFile.delete();
      }
    }
    super.onDestroy();
  }

  protected void onPause()
  {
    if (this.o != null)
    {
      Iterator localIterator = this.q.iterator();
      while (localIterator.hasNext())
      {
        AppSessionListener localAppSessionListener = (AppSessionListener)localIterator.next();
        this.o.b(localAppSessionListener);
      }
    }
    FBLocationManager.a(this.ae);
    new Handler().postDelayed(new ComposerActivity.24(this), 1000L);
    findViewById(2131296526).setVisibility(8);
    findViewById(2131296528).setVisibility(8);
    this.M.setVisibility(8);
    super.onPause();
  }

  protected void onResume()
  {
    super.onResume();
    this.o = AppSession.a(this, true);
    Iterator localIterator = this.q.iterator();
    while (localIterator.hasNext())
    {
      AppSessionListener localAppSessionListener = (AppSessionListener)localIterator.next();
      this.o.a(localAppSessionListener);
    }
    if (System.currentTimeMillis() - ab() > 7200000L)
      AppSession.a(this, this.o);
    AudienceSettings localAudienceSettings;
    if ((this.S == null) && ((!this.af) || (this.x != null)))
    {
      if (!this.ah)
        break label221;
      if (aa())
        ai();
    }
    else
    {
      this.n.setSelection(this.n.getText().length());
      if (!ComposerUserSettings.b(this))
        showDialog(100);
      if ((this.B != null) && (!this.B.a))
      {
        localAudienceSettings = AudienceSettings.a(getApplicationContext(), PrivacySetting.Category.composer_sticky);
        if (localAudienceSettings != null)
          break label228;
        r();
      }
    }
    while (true)
    {
      if ((this.I) && (FBLocationManager.b(this)))
        FBLocationManager.a(this, this.ae);
      s();
      T();
      return;
      ah();
      break;
      label221: ai();
      break;
      label228: if (!StringUtil.a(this.ab))
        localAudienceSettings.a((PrivacySetting)JMStaticKeysDictDestination.Encoder.a(this.ab, PrivacySetting.class));
      a(localAudienceSettings);
    }
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putParcelable(ComposerActivity.StateKeys.a, this.x);
    paramBundle.putParcelable(ComposerActivity.StateKeys.b, this.A);
    paramBundle.putBoolean(ComposerActivity.StateKeys.c, this.H);
    paramBundle.putParcelable(ComposerActivity.StateKeys.d, this.G);
    paramBundle.putBoolean(ComposerActivity.StateKeys.e, this.I);
    paramBundle.putBoolean(ComposerActivity.StateKeys.f, this.av);
  }

  public void onUserInteraction()
  {
    super.onUserInteraction();
    J();
    if (this.L > 0L)
    {
      this.M.setVisibility(8);
      if (1000L < System.currentTimeMillis() - this.L)
        q();
      this.L = 0L;
    }
    if ((!this.af) || (!this.av))
      c(false);
  }

  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if (c(true));
    while (true)
    {
      return;
      switch (ComposerActivity.35.a[this.Q.ordinal()])
      {
      default:
        break;
      case 1:
      case 2:
      case 3:
        if (H())
          Z();
        break;
      case 4:
        o();
        this.Q = ComposerActivity.TipMode.NONE;
        continue;
        a(null);
        this.Q = ComposerActivity.TipMode.NONE;
        break;
      case 5:
        p();
        this.Q = ComposerActivity.TipMode.NONE;
      }
    }
  }

  public void openAlbumSelector(View paramView)
  {
    this.S = ComposerActivity.OverlayMode.ALBUM_SELECTOR;
    ah();
    this.V.setVisibility(0);
    this.V.startAnimation(AnimationUtils.loadAnimation(this, 2130968579));
    a(null);
  }

  public void openAudienceSelector(View paramView)
  {
    this.S = ComposerActivity.OverlayMode.AUDIENCE_SELECTOR;
    ah();
    this.U.setVisibility(0);
    View localView = this.U.findViewById(2131297584);
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = localView.getHeight();
    arrayOfFloat[1] = 0.0F;
    ObjectAnimator.a(localView, "translationY", arrayOfFloat).d(400L).c();
    this.an.b(FB4A_AnalyticEntities.Modules.k, true);
  }

  public void openTagPeople(View paramView)
  {
    af();
  }

  public void openTimeSelector(View paramView)
  {
    this.S = ComposerActivity.OverlayMode.TIME_SELECTOR;
    ah();
    this.T.setVisibility(0);
    this.T.findViewById(2131297584).startAnimation(AnimationUtils.loadAnimation(this, 2130968579));
  }

  public void p()
  {
    if (this.W != -1L);
    while (true)
    {
      return;
      UserSeenNux.a(this, UserSeenNux.Project.EVENT_TAG_EXPANSION, new ComposerActivity.2(this));
    }
  }

  public void q()
  {
    if (this.L > 0L)
    {
      this.L = 0L;
      GraphSetUserSeenNux.a(this, UserSeenNux.Project.EVENT_TAG_EXPANSION);
    }
  }

  protected void r()
  {
    this.Z.setAudienceType(z(), this.B);
    s();
    if (this.aa != null)
      this.Z.setPhotoAlbum(this.aa);
  }

  protected void s()
  {
    if ((z() == ComposerAudienceSelectorButton.AudienceType.GROUP) && (this.Z.getGroup() == null))
      FqlGetProfile.a(this, this.W);
  }

  public void titleBarPrimaryActionClickHandler(View paramView)
  {
    int[] arrayOfInt;
    if (this.B != null)
    {
      arrayOfInt = this.B.i();
      if (arrayOfInt != null)
        break label36;
      AudienceSettings.a(getApplicationContext(), PrivacySetting.Category.composer_sticky);
    }
    label36: String str1;
    do
    {
      return;
      arrayOfInt = null;
      break;
      str1 = MentionsUtils.a(new SpannableStringBuilder(am()));
      b(FB4A_AnalyticEntities.UIElements.e);
    }
    while ((str1.length() <= 0) && (this.t.size() <= 0) && (this.x == null) && (!m()) && (!this.ah));
    Intent localIntent1 = new Intent();
    long l1;
    label120: PrivacySetting localPrivacySetting;
    AudienceOption localAudienceOption;
    label165: Object localObject2;
    if (!this.aj)
    {
      l1 = this.W;
      localPrivacySetting = null;
      if (arrayOfInt == null)
        break label1544;
      localAudienceOption = this.B.d(arrayOfInt[0], arrayOfInt[1]);
      if (localAudienceOption.c() != AudienceOption.Type.PRIVACY_SETTING)
        break label675;
      localPrivacySetting = ((AudienceAdapter.PrivacySettingAudienceOption)localAudienceOption).d();
      if (localPrivacySetting == null)
        break label1544;
      if (!"SELF".equals(localPrivacySetting.value))
        this.aB.a(aE, 0);
      if (!"CUSTOM".equals(localPrivacySetting.value))
        break label715;
      localObject2 = JMStaticKeysDictDestination.Encoder.a(localPrivacySetting);
      label216: localIntent1.putExtra("extra_status_privacy", (String)localObject2);
      if (!this.ag)
      {
        AudienceSettings localAudienceSettings = this.B.e();
        if (localAudienceSettings != null)
        {
          localAudienceSettings.a(localPrivacySetting);
          localAudienceSettings.j().a(this, true, PrivacySetting.Category.composer_sticky, "", localAudienceSettings);
        }
      }
    }
    label1025: label1544: for (Object localObject1 = localObject2; ; localObject1 = null)
    {
      a(localIntent1, str1, l1, (String)localObject1);
      label486: EventTaggingAnalyticsLogger localEventTaggingAnalyticsLogger;
      FacebookPlace localFacebookPlace;
      if ((this.r != null) && (!this.r.isEmpty()))
      {
        Intent localIntent2 = new Intent(getIntent());
        String str12 = getApplicationContext().getPackageName();
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = str12;
        arrayOfObject[1] = StringUtils.a(5);
        localIntent2.setAction(StringLocaleUtil.a("%s.upload.retry.%s", arrayOfObject));
        if ((str1 != null) && (str1.length() > 0))
          localIntent2.putExtra("extra_composer_initial_text", str1);
        localIntent2.putExtra("extra_media_privacy_override", JMStaticKeysDictDestination.Encoder.a(localPrivacySetting));
        localIntent2.putExtra("extra_tagged_ids", IntentUtils.a(this.t));
        localIntent2.putExtra("extra_media_retry_waterfall_id", this.aw);
        a(localIntent2, str1, l1, (String)localObject1);
        new ComposerActivity.ComposerPhotoUploads(this, this.r, localIntent2, str1, localPrivacySetting, l1).start();
        localIntent1.putExtra("is_uploading_media", true);
        if (ac())
        {
          Toaster.a(this, 2131363207);
          localEventTaggingAnalyticsLogger = this.ap;
          localFacebookPlace = this.x;
          if (this.y == null)
            break label977;
        }
      }
      String str5;
      label675: label715: label971: label977: for (boolean bool1 = true; ; bool1 = false)
      {
        while (true)
        {
          localEventTaggingAnalyticsLogger.a(localFacebookPlace, bool1, this.r, this.R);
          str5 = "";
          if (!this.ah)
            break label1537;
          localIntent1.putExtra("extra_is_share", true);
          if (getIntent().hasExtra("extra_link_for_share"))
          {
            str5 = getIntent().getStringExtra("extra_link_for_share");
            localIntent1.putExtra("extra_link_for_share", str5);
          }
          if (getIntent().hasExtra("extra_shareable"))
            localIntent1.putExtra("extra_shareable", getIntent().getParcelableExtra("extra_shareable"));
          switch (ComposerActivity.35.e[this.F.ordinal()])
          {
          default:
            throw new RuntimeException("A target was not selected for sharing");
            l1 = -1L;
            break label120;
            AudienceOption.Type localType1 = localAudienceOption.c();
            AudienceOption.Type localType2 = AudienceOption.Type.FRIEND_LIST;
            localPrivacySetting = null;
            if (localType1 != localType2)
              break label165;
            localPrivacySetting = ((AudienceAdapter.FriendListAudienceOption)localAudienceOption).d().a();
            break label165;
            try
            {
              String str13 = new JSONObject().put("value", localPrivacySetting.value).toString();
              localObject2 = str13;
            }
            catch (JSONException localJSONException2)
            {
              Log.a(x(), "inconceivable JSON exception", localJSONException2);
              this.ao.a(localJSONException2.getClass(), "photo_privacy_json_error");
              localObject2 = null;
            }
          case 1:
          case 2:
          case 3:
          case 4:
          }
        }
        break label216;
        Toaster.a(this, 2131363257);
        break label486;
        if (this.R == null)
          break label486;
        String str2 = am().toString().trim();
        if (TextUtils.isEmpty(str2))
          str2 = DateFormat.getDateTimeInstance(2, 3).format(new Date());
        long l2;
        label851: PhotoFlowLogger localPhotoFlowLogger;
        if (this.x != null)
        {
          l2 = this.x.mPageId;
          String str3 = this.as.b(this.R, getContentResolver());
          Set localSet = this.t;
          String str4 = this.aw;
          MediaUploadService.a(this, str3, str2, null, -1L, l1, localSet, (String)localObject1, l2, str4);
          localPhotoFlowLogger = this.ao;
          if (this.t == null)
            break label971;
        }
        for (int i = this.t.size(); ; i = 0)
        {
          localPhotoFlowLogger.a(true, 1, i, (String)localObject1, Long.toString(l1));
          localIntent1.putExtra("is_uploading_media", true);
          Toaster.a(this, 2131363258);
          break;
          l2 = -1L;
          break label851;
        }
      }
      l1 = -1L;
      for (String str6 = str5; ; str6 = str5)
      {
        label992: String str7;
        label1004: String str8;
        ImplicitLocation localImplicitLocation;
        Context localContext;
        long l3;
        JSONObject localJSONObject;
        if (this.I)
        {
          str7 = "1";
          ComposerUserSettings.a(this, "composer_share_location", str7);
          if (this.x != null)
            break label1375;
          str8 = "";
          if (!this.I)
            break label1390;
          localImplicitLocation = ImplicitLocation.ENABLED;
          localContext = getApplicationContext();
          if (!localIntent1.hasExtra("is_uploading_media"))
          {
            l3 = this.o.b().userId;
            if (l1 <= 0L)
              l1 = l3;
            if (!getIntent().getBooleanExtra(ComposerConstants.c, false))
              break label1442;
            if ((this.A == null) || (l3 != l1))
              break label1406;
            localJSONObject = new JSONObject();
          }
        }
        while (true)
        {
          try
          {
            localJSONObject.put("latitude", this.A.getLatitude());
            localJSONObject.put("longitude", this.A.getLongitude());
            String str11 = localJSONObject.toString();
            str10 = str11;
            str9 = str10;
            Shareable localShareable = (Shareable)getIntent().getParcelableExtra("extra_shareable");
            PublishPostParamsBuilder localPublishPostParamsBuilder = new PublishPostParamsBuilder().a(((UniqueRequestIdGenerator)C().a(UniqueRequestIdGenerator.class)).a()).a(l1).b(str1).c(str8).a(this.af);
            if ((this.x == null) || (this.x.c() == null))
              break label1436;
            bool2 = true;
            localIntent1.putExtra("publishPostParams", localPublishPostParamsBuilder.b(bool2).a(this.t).d((String)localObject1).e(str6).b(l3).f(str9).a(localShareable).g(this.ar).a());
            if (!getIntent().getBooleanExtra(ComposerConstants.b, false))
              continue;
            localIntent1.putExtra(ComposerConstants.a, a(localPrivacySetting, l1));
            setResult(-1, localIntent1);
            finish();
            break;
            localObject1 = "";
            l1 = this.v;
            str6 = str5;
            break label992;
            str7 = "";
            break label1004;
            label1375: str8 = String.valueOf(this.x.mPageId);
            break label1025;
            label1390: localImplicitLocation = ImplicitLocation.DISABLED;
          }
          catch (JSONException localJSONException1)
          {
            String str10 = null;
            continue;
          }
          label1406: localIntent1.putExtra("publishLocationParams", new PublishLocationParams("structured_composer", "composer_share_location", localImplicitLocation));
          String str9 = null;
          continue;
          label1436: boolean bool2 = false;
          continue;
          label1442: if (this.ag)
          {
            ComposerParameters localComposerParameters = new ComposerParameters(localIntent1, l1);
            localIntent1.putExtra("postRecommendationParams", new PostRecommendationParams(localComposerParameters.j(), localComposerParameters.a(), localComposerParameters.c()));
            continue;
          }
          ComposerPublisherResult localComposerPublisherResult = ComposerPublisher.a(localContext, new ComposerParameters(localIntent1, l1), this.o);
          if (localComposerPublisherResult == null)
            break;
          localIntent1.putExtra("extra_composer_publisher_result", localComposerPublisherResult);
        }
      }
    }
  }

  protected ComposerAudienceSelectorButton.AudienceType z()
  {
    return ComposerActivity.AudienceSelectorButtonTypeChooser.a(this.X, this.W, this.Y, this.aj, this.aa);
  }
}

/* Location:           /data1/software/jd-gui/com.facebook.katana_2.0_liqucn.com-dex2jar.jar
 * Qualified Name:     com.facebook.katana.activity.composer.ComposerActivity
 * JD-Core Version:    0.6.0
 */