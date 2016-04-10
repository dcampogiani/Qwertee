package com.danielecampogiani.qwertee.data.network.rawresponses;

import com.danielecampogiani.qwertee.presentation.data.TShirt;

import org.junit.Before;
import org.junit.Test;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class MapperImplTest {

    private MapperImpl subjectUnderTest;

    @Before
    public void setUp() throws Exception {
        subjectUnderTest = new MapperImpl();
    }

    @Test
    public void testMapFromRss() throws Exception {
        Rss rss = getFakeRss();
        final TShirt[] tShirts = subjectUnderTest.map(rss);
        assertThat(tShirts).hasSize(6);

        assertThat(tShirts[0].getTitle()).isEqualTo("Don't Dream It, Be It");
        assertThat(tShirts[0].getDescription()).isEqualTo("By EmilieBoisvert :)");
        assertThat(tShirts[0].getId()).isEqualTo(97400);
        assertThat(tShirts[0].getPrice()).isEqualTo(10);

        assertThat(tShirts[1].getTitle()).isEqualTo("Seymour's Organic Plant Food");
        assertThat(tShirts[1].getDescription()).isEqualTo("By Nemons Feed Me Seymour! A Little Shop of Horrors inspired shop logo");
        assertThat(tShirts[1].getId()).isEqualTo(89263);
        assertThat(tShirts[1].getPrice()).isEqualTo(10);

        assertThat(tShirts[2].getTitle()).isEqualTo("I put a spell on you");
        assertThat(tShirts[2].getDescription()).isEqualTo("By ursulalopez now you are mine!!");
        assertThat(tShirts[2].getId()).isEqualTo(90241);
        assertThat(tShirts[2].getPrice()).isEqualTo(10);

        assertThat(tShirts[3].getTitle()).isEqualTo("Throne Wars");
        assertThat(tShirts[3].getDescription()).isEqualTo("By CoDdesigns Winter is coming...");
        assertThat(tShirts[3].getId()).isEqualTo(96767);
        assertThat(tShirts[3].getPrice()).isEqualTo(12);

        assertThat(tShirts[4].getTitle()).isEqualTo("Imperial Ruler");
        assertThat(tShirts[4].getDescription()).isEqualTo("By JAZZCOLA BOW DOWN");
        assertThat(tShirts[4].getId()).isEqualTo(95529);
        assertThat(tShirts[4].getPrice()).isEqualTo(12);

        assertThat(tShirts[5].getTitle()).isEqualTo("Schrödinger night");
        assertThat(tShirts[5].getDescription()).isEqualTo("By BlancaVidal Our favourite boxed cat!");
        assertThat(tShirts[5].getId()).isEqualTo(95938);
        assertThat(tShirts[5].getPrice()).isEqualTo(12);
    }

    @Test
    public void testMapFromHtml() throws Exception {
        String html = getFakeHTML();
        Page page = subjectUnderTest.map(html);
        TShirt[] tShirts = page.gettShirts();
        int length = tShirts.length;
        assertThat(length).isEqualTo(119);
        for (int i = 0; i < length; i++) {
            assertThat(tShirts[i].getTitle()).isNotEmpty();
            assertThat(tShirts[i].getDescription()).isNotEmpty();
            assertThat(tShirts[i].getId()).isNotZero();
        }

    }

    private Rss getFakeRss() {
        String rssString = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<rss xmlns:atom=\"http://www.w3.org/2005/Atom\" version=\"2.0\">\n" +
                "    <channel>\n" +
                "        <title>Qwertee.com Latest Shirts</title>\n" +
                "        <link>https://www.qwertee.com/</link>\n" +
                "        <description>New Daily Tees from Qwertee.com</description>\n" +
                "        <atom:link href=\"https://www.qwertee.com/rss\" rel=\"self\"></atom:link>\n" +
                "        <language>en-gb</language>\n" +
                "        <item>\n" +
                "            <title>Don&#39;t Dream It, Be It</title>\n" +
                "            <link>https://www.qwertee.com/</link>\n" +
                "            <description>\n" +
                "                <![CDATA[\n" +
                "                By EmilieBoisvert<br>\n" +
                "                :)<br>\n" +
                "                <img src=\"https://cdn.qwertee.com/images/designs/zoom/97400.jpg\" alt=\"\"><br>\n" +
                "                <img src=\"https://cdn.qwertee.com/images/designs/mens/97400.jpg\" alt=\"\"><br>\n" +
                "                ]]>\n" +
                "                </description>\n" +
                "            <pubDate>Sat, 09 Apr 2016 23:00:00 +0100</pubDate>\n" +
                "            <guid>https://www.qwertee.com/product/don-t-dream-it-be-it</guid>\n" +
                "        </item>\n" +
                "        <item>\n" +
                "            <title>Seymour&#39;s Organic Plant Food</title>\n" +
                "            <link>https://www.qwertee.com/</link>\n" +
                "            <description>\n" +
                "                <![CDATA[\n" +
                "                By Nemons<br>\n" +
                "                Feed Me Seymour! A Little Shop of Horrors inspired shop logo<br>\n" +
                "                <img src=\"https://cdn.qwertee.com/images/designs/zoom/89263.jpg\" alt=\"\"><br>\n" +
                "                <img src=\"https://cdn.qwertee.com/images/designs/mens/89263.jpg\" alt=\"\"><br>\n" +
                "                ]]>\n" +
                "                </description>\n" +
                "            <pubDate>Sat, 09 Apr 2016 23:00:00 +0100</pubDate>\n" +
                "            <guid>https://www.qwertee.com/product/seymour-s-organic-plant-food</guid>\n" +
                "        </item>\n" +
                "        <item>\n" +
                "            <title>I put a spell on you</title>\n" +
                "            <link>https://www.qwertee.com/</link>\n" +
                "            <description>\n" +
                "                <![CDATA[\n" +
                "                By ursulalopez<br>\n" +
                "                now you are mine!!<br>\n" +
                "                <img src=\"https://cdn.qwertee.com/images/designs/zoom/90241.jpg\" alt=\"\"><br>\n" +
                "                <img src=\"https://cdn.qwertee.com/images/designs/mens/90241.jpg\" alt=\"\"><br>\n" +
                "                ]]>\n" +
                "                </description>\n" +
                "            <pubDate>Sat, 09 Apr 2016 23:00:00 +0100</pubDate>\n" +
                "            <guid>https://www.qwertee.com/product/i-put-a-spell-on-you</guid>\n" +
                "        </item>\n" +
                "        <item>\n" +
                "            <title>Throne Wars</title>\n" +
                "            <link>https://www.qwertee.com/</link>\n" +
                "            <description>\n" +
                "                <![CDATA[\n" +
                "                By CoDdesigns<br>\n" +
                "                Winter is coming...<br>\n" +
                "                <img src=\"https://cdn.qwertee.com/images/designs/zoom/96767.jpg\" alt=\"\"><br>\n" +
                "                <img src=\"https://cdn.qwertee.com/images/designs/mens/96767.jpg\" alt=\"\"><br>\n" +
                "                ]]>\n" +
                "                </description>\n" +
                "            <pubDate>Fri, 08 Apr 2016 23:00:00 +0100</pubDate>\n" +
                "            <guid>https://www.qwertee.com/product/throne-wars-814</guid>\n" +
                "        </item>\n" +
                "        <item>\n" +
                "            <title>Imperial Ruler</title>\n" +
                "            <link>https://www.qwertee.com/</link>\n" +
                "            <description>\n" +
                "                <![CDATA[\n" +
                "                By JAZZCOLA<br>\n" +
                "                BOW DOWN<br>\n" +
                "                <img src=\"https://cdn.qwertee.com/images/designs/zoom/95529.jpg\" alt=\"\"><br>\n" +
                "                <img src=\"https://cdn.qwertee.com/images/designs/mens/95529.jpg\" alt=\"\"><br>\n" +
                "                ]]>\n" +
                "                </description>\n" +
                "            <pubDate>Fri, 08 Apr 2016 23:00:00 +0100</pubDate>\n" +
                "            <guid>https://www.qwertee.com/product/imperial-ruler</guid>\n" +
                "        </item>\n" +
                "        <item>\n" +
                "            <title>Schrödinger night</title>\n" +
                "            <link>https://www.qwertee.com/</link>\n" +
                "            <description>\n" +
                "                <![CDATA[\n" +
                "                By BlancaVidal<br>\n" +
                "                Our favourite boxed cat!<br>\n" +
                "                <img src=\"https://cdn.qwertee.com/images/designs/zoom/95938.jpg\" alt=\"\"><br>\n" +
                "                <img src=\"https://cdn.qwertee.com/images/designs/mens/95938.jpg\" alt=\"\"><br>\n" +
                "                ]]>\n" +
                "                </description>\n" +
                "            <pubDate>Fri, 08 Apr 2016 23:00:00 +0100</pubDate>\n" +
                "            <guid>https://www.qwertee.com/product/schrodinger-night</guid>\n" +
                "        </item>\n" +
                "    </channel>\n" +
                "</rss>\n";

        Serializer serializer = new Persister();
        try {
            return serializer.read(Rss.class, rssString);
        } catch (Exception e) {
            e.printStackTrace();
            return new Rss();
        }
    }

    private String getFakeHTML() {
        String first = "\n" +
                "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<title>Shop Qwertees | Qwertee : Limited Edition Cheap Daily T Shirts | Gone in 24 Hours | T-shirt Only £8/€10/$12 | Cool Graphic Funny Tee Shirts</title>\n" +
                "<meta name=\"Description\" content=\"Qwertee.com sells a new cool, funny, graphic t shirt every 24 hours for only &pound;8/&euro;10/$12! Get your limited edition tee now before its too late!\"/>\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\">\n" +
                "<meta property=\"fb:admins\" content=\"1050828616\" />\n" +
                "<meta name=\"keywords\" content=\"Qwerty T Shirts, Qwerty, Qwertee, Graphic Tees, cool shirts, awesome t shirts, cheap graphic tees, tee shirts, limited edition tshirts, limited edition tee shirts, cool graphic tees, cool graphic t-shirts, mens, boys girls Tshirts kids Tees, womens, ladies, funny, cool, music, printed, graphic, designer, humor, unique, t-shirts, tee shirts, tshirts, clothing, design, art, Irish T-Shirts, Irish T-Shirt, retro, band, art, cotton t shirt, Irish Shirts, tshirts ireland, Limited Edition, Ireland, online t shirts, tees, funny shirts, funny slogans, t-shirts UK, daily t shirt, 24 hours only, UK, Europe, Worldwide, Free Delivery, Free Returns\" />\n" +
                "<link rel=\"icon\" href=\"//cdn.qwertee.com/favicon.ico\" />\n" +
                "<link href=\"//fonts.googleapis.com/css?family=Open+Sans:300,400,600,800\" rel=\"stylesheet\" type=\"text/css\">\n" +
                "<link href=\"//cdn.qwertee.com/css/main.css\" rel=\"stylesheet\" type=\"text/css\">\n" +
                "<meta name=\"blitz\" content=\"mu-b206d666-41efa54e-0c0a7432-b3a88a29\">\n" +
                "\n" +
                "</head>\n" +
                "<body class=\"body-designs white-footer shop-tees  responsive\">\n" +
                "<noscript>Javascript is required to use this site</noscript>\n" +
                "<div id=\"fb-root\"></div>\n" +
                "<div id=\"top-banner\" data-count=\"33\" style=\"color:#ffffff;background-color:#000000\"><div></div></div>\n" +
                "<div id=\"header-wrap\">\n" +
                "    <div id=\"top-nav\">\n" +
                "\t    <div id=\"delivery-from\">\n" +
                "\t       <span class=\"flag\"></span> <span class=\"price\"></span>\n" +
                "        </div>\n" +
                "      <ol>\n" +
                "    \t<li><a href=\"#currency\">Change Currency\n" +
                "        <span class=\"flag eur\" title=\"eur\" style=\"display: none\"></span>\n" +
                "        <span class=\"flag usd\" title=\"usd\" style=\"display: none\"></span>\n" +
                "        <span class=\"flag gbp\" title=\"gbp\" style=\"display: none\"></span>\n" +
                "        </a> | </li>\n" +
                "        <li><a class=\"cart\" href=\"/checkout\" data-json=\"[]\"></a> |</li>\n" +
                "    \t<li class=\"header-login-link\"><a class=\"login\" href=\"/login\">Log in |</a></li>\n" +
                "    \t<li class=\"header-login-link\"><a class=\"register\" href=\"/register\">Join Us</a></li>\n" +
                "      </ol>\n" +
                "    </div>\n" +
                "    <div id=\"header\">\n" +
                "        <div id=\"logo\">\n" +
                "          <h1><a href=\"/\">Qwertee</a></h1>\n" +
                "        </div>\n" +
                "        <div id=\"main-nav\">\n" +
                "          <a href=\"/\" data-submenu=\"todays-tees\">Today's Tees</a>\n" +
                "          <a href=\"/shop\" data-submenu=\"shop\">Tee Shop</a>\n" +
                "          <a href=\"/prints\">Print Shop</a>\n" +
                "          <a href=\"/tees/vote/selected\" data-submenu=\"vote\">Vote</a>\n" +
                "          <a href=\"/forum\" data-submenu=\"talk\">Talk</a>\n" +
                "          <a href=\"/tees/free-tees\">Win</a>\n" +
                "          <a href=\"/help\" data-submenu=\"help\">Help</a>\n" +
                "        </div>\n" +
                "        <a class=\"nav-button\" href=\"#\">\n" +
                "            <span class=\"bar\"></span>\n" +
                "            <span class=\"bar\"></span>\n" +
                "            <span class=\"bar\"></span>\n" +
                "        </a>\n" +
                "        <div class=\"clear\"></div>\n" +
                "    </div>\n" +
                "    <div class=\"submenus\">\n" +
                "        <div class=\"submenu-wrap\" data-submenu=\"todays-tees\">\n" +
                "            <div class=\"submenu-inner\">\n" +
                "                <ul class=\"submenu\">\n" +
                "                    <li><a href=\"/\">Today's tees</a></li>\n" +
                "                    <li><a href=\"/last-chance\">Last chance</a></li>\n" +
                "                    <li><a href=\"/gift-cards\" data-submenu=\"tees\">Gift Cards</a></li>\n" +
                "                    <li><a href=\"/tees/free-tees\">Win FREE TEES!</a></li>\n" +
                "                </ul>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "        <div class=\"submenu-wrap\" data-submenu=\"shop\">\n" +
                "            <div class=\"submenu-inner\">\n" +
                "                <ul class=\"submenu\">\n" +
                "                    <li><a href=\"/shop\">Shop Tees</a></li>\n" +
                "                    <li><a href=\"/prints\">Shop Prints</a></li>\n" +
                "                    <li><a href=\"/gift-cards\" data-submenu=\"tees\">Gift Cards</a></li>\n" +
                "                </ul>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "        <div class=\"submenu-wrap\" data-submenu=\"vote\">\n" +
                "            <div class=\"submenu-inner\">\n" +
                "                <ul class=\"submenu\">\n" +
                "                    <li><a href=\"/tees/vote/selected\">Vote for Tees</a></li>\n" +
                "                    <li><a href=\"/tees/previous/all\">Previous tees</a></li>\n" +
                "                    <li><a href=\"/submit-design\">Submit Design</a></li>\n" +
                "                    <li><a href=\"/quick-submit\">Quick Submit</a></li>\n" +
                "                    <li><a href=\"/resources\">Artist resources</a></li>\n" +
                "                    <li><a href=\"#what-is-qwertee-popup\">What is Qwertee?</a></li>\n" +
                "                </ul>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "        <div class=\"submenu-wrap\" data-submenu=\"talk\">\n" +
                "            <div class=\"submenu-inner\">\n" +
                "                <ul class=\"submenu\">\n" +
                "                    <li><a href=\"/forum\">Forum</a></li>\n" +
                "                    <li><a href=\"/blog\">Blog / News</a></li>\n" +
                "                    <li><a href=\"/resources\">Artist resources</a></li>\n" +
                "                    <li><a href=\"#what-is-qwertee-popup\">What is Qwertee?</a></li>\n" +
                "                </ul>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "        <div class=\"submenu-wrap\" data-submenu=\"help\">\n" +
                "            <div class=\"submenu-inner\">\n" +
                "                <ul class=\"submenu\">\n" +
                "                    <li><a href=\"#what-is-qwertee-popup\">What is Qwertee?</a></li>\n" +
                "                    <li><a href=\"/help\">Help &amp; FAQ</a></li>\n" +
                "                    <li><a href=\"/help\">Contact Us</a></li>\n" +
                "                </ul>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</div>\n" +
                "<div id=\"content-wrap\">\n" +
                "  <div id=\"page-header-wrap\">\n" +
                "\t<div id=\"page-header\">\n" +
                "\t  <h1>TEE SHOP</h1>\n" +
                "<span>If a daily tee is really popular it may make it into the tee shop. Get them now while they are still available, as once they are gone they are gone forever!</span>\n" +
                "\n" +
                "\n" +
                "\t</div>\n" +
                "\t<div class=\"clear\"></div>\n" +
                "  </div>\n" +
                "<div id=\"content\">\n" +
                "<div id=\"login-popup\" class=\"popup\">\n" +
                "    <h2 class=\"raleway\">WOOPS!</h2>\n" +
                "    <p class=\"content\">\n" +
                "        Sorry! You Need to be logged in to vote on designs.\n" +
                "        Click below to login now or register with the greatest\n" +
                "        daily tee site in the world! (takes only a few seconds)\n" +
                "    </p>\n" +
                "    <p class=\"actions centered\">\n" +
                "        <a href=\"/register\" class=\"submit raleway\">CREATE NEW ACCOUNT NOW</a>\n" +
                "        <a href=\"/login\" class=\"submit raleway\">LOGIN TO MY ACCOUNT</a>\n" +
                "    </p>\n" +
                "</div><div id=\"forum-categories\">\n" +
                "</div>\n" +
                "\n" +
                "<ul class=\"filtersMenu\">\n" +
                "</ul>\n" +
                "\n" +
                "<div class=\"tee-list-wrap\">\n" +
                "    <style>\n" +
                "        #sort-tees-list{\n" +
                "            padding: 0 0 25px 0;\n" +
                "            font-weight: 800;\n" +
                "            font-family: 'Open Sans', sans-serif;\n" +
                "            color:#808080;\n" +
                "            font-style: normal;\n" +
                "            font-size: 1.5em;\n" +
                "            text-transform: uppercase;\n" +
                "        }\n" +
                "        #sort-tees-list ul li{\n" +
                "            display: inline;\n" +
                "        }\n" +
                "        #sort-tees-list ul li a{\n" +
                "            color:#808080;\n" +
                "            text-decoration: none;\n" +
                "        }\n" +
                "        #sort-tees-list ul li a.active, #sort-tees-list ul li a:hover{\n" +
                "            color:#000;\n" +
                "            text-decoration: none;\n" +
                "        }\n" +
                "    </style>\n" +
                "    <div id =\"sort-tees-list\">\n" +
                "        <ul>\n" +
                "            <li>\n" +
                "                <ul id=\"tee-sorter\">\n" +
                "                    <li><span>Pick your size:</span></li>\n" +
                "                        <li><span>Mens:</span></li>\n" +
                "\n" +
                "\n" +
                "                        <li><a id=\"size-s\" class=\"\" href = \"/shop/all/s?sort=popular\">s</a></li>\n" +
                "\n" +
                "                        <li><a id=\"size-m\" class=\"\" href = \"/shop/all/m?sort=popular\">m</a></li>\n" +
                "\n" +
                "                        <li><a id=\"size-l\" class=\"\" href = \"/shop/all/l?sort=popular\">l</a></li>\n" +
                "\n" +
                "                        <li><a id=\"size-xl\" class=\"\" href = \"/shop/all/xl?sort=popular\">xl</a></li>\n" +
                "\n" +
                "                        <li><a id=\"size-xxl\" class=\"\" href = \"/shop/all/xxl?sort=popular\">xxl</a></li>\n" +
                "\n" +
                "                        <li><a id=\"size-3xl\" class=\"\" href = \"/shop/all/3xl?sort=popular\">3xl</a></li>\n" +
                "                        <li><span>Womens:</span></li>\n" +
                "\n" +
                "\n" +
                "                        <li><a id=\"size-ws\" class=\"\" href = \"/shop/all/ws?sort=popular\">ws</a></li>\n" +
                "\n" +
                "                        <li><a id=\"size-wm\" class=\"\" href = \"/shop/all/wm?sort=popular\">wm</a></li>\n" +
                "\n" +
                "                        <li><a id=\"size-wl\" class=\"\" href = \"/shop/all/wl?sort=popular\">wl</a></li>\n" +
                "\n" +
                "                        <li><a id=\"size-wxl\" class=\"\" href = \"/shop/all/wxl?sort=popular\">wxl</a></li>\n" +
                "\n" +
                "                        <li><a id=\"size-wxxl\" class=\"\" href = \"/shop/all/wxxl?sort=popular\">wxxl</a></li>\n" +
                "\n" +
                "                        <li><a id=\"size-\" class=\"active\" href = \"/shop/all/?sort=popular\">Show All</a></li>\n" +
                "                        <li><span>Then sort by: </span></li>\n" +
                "\n" +
                "\n" +
                "                        <li><a id=\"sort-price\" class=\"\" href = \"?sort=price\">Price</a></li>\n" +
                "                        <li><span> | </span></li>\n" +
                "\n" +
                "\n" +
                "                        <li><a id=\"sort-popular\" class=\"active\" href = \"?sort=popular\">Most popular</a></li>\n" +
                "                </ul>\n" +
                "            </li>\n" +
                "        </ul>\n" +
                "    </div>\n" +
                "<ul class=\"tee-list \">\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/schrodinger-night\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/95938-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"12\"\n" +
                "data-tee-price-gbp=\"10\" data-tee-price-usd=\"14\" data-hoodie-price-eur=\"32\"\n" +
                "data-hoodie-price-gbp=\"28\" data-hoodie-price-usd=\"32\" data-sweater-price-eur=\"22\"\n" +
                "data-sweater-price-gbp=\"18\" data-sweater-price-usd=\"24\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/schrodinger-night\" class=\"name\">Schrödinger night</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/525958\">BlancaVidal</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/imperial-ruler\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/95529-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"12\"\n" +
                "data-tee-price-gbp=\"10\" data-tee-price-usd=\"14\" data-hoodie-price-eur=\"32\"\n" +
                "data-hoodie-price-gbp=\"28\" data-hoodie-price-usd=\"32\" data-sweater-price-eur=\"22\"\n" +
                "data-sweater-price-gbp=\"18\" data-sweater-price-usd=\"24\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/imperial-ruler\" class=\"name\">Imperial Ruler</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/429193\">JAZZCOLA</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/throne-wars-814\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/96767-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"12\"\n" +
                "data-tee-price-gbp=\"10\" data-tee-price-usd=\"14\" data-hoodie-price-eur=\"32\"\n" +
                "data-hoodie-price-gbp=\"28\" data-hoodie-price-usd=\"32\" data-sweater-price-eur=\"22\"\n" +
                "data-sweater-price-gbp=\"18\" data-sweater-price-usd=\"24\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/throne-wars-814\" class=\"name\">Throne Wars</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/28681\">CoDdesigns</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/i-put-a-spell-on-you\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/90241-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"10\"\n" +
                "data-tee-price-gbp=\"8\" data-tee-price-usd=\"12\" data-hoodie-price-eur=\"29\"\n" +
                "data-hoodie-price-gbp=\"24\" data-hoodie-price-usd=\"29\" data-sweater-price-eur=\"19\"\n" +
                "data-sweater-price-gbp=\"15\" data-sweater-price-usd=\"21\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/i-put-a-spell-on-you\" class=\"name\">I put a spell on you</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/421583\">ursulalopez</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/seymour-s-organic-plant-food\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/89263-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"10\"\n" +
                "data-tee-price-gbp=\"8\" data-tee-price-usd=\"12\" data-hoodie-price-eur=\"29\"\n" +
                "data-hoodie-price-gbp=\"24\" data-hoodie-price-usd=\"29\" data-sweater-price-eur=\"19\"\n" +
                "data-sweater-price-gbp=\"15\" data-sweater-price-usd=\"21\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/seymour-s-organic-plant-food\" class=\"name\">Seymour&#39;s Organic Plant Food</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/281470\">Nemons</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/don-t-dream-it-be-it\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/97400-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"10\"\n" +
                "data-tee-price-gbp=\"8\" data-tee-price-usd=\"12\" data-hoodie-price-eur=\"29\"\n" +
                "data-hoodie-price-gbp=\"24\" data-hoodie-price-usd=\"29\" data-sweater-price-eur=\"19\"\n" +
                "data-sweater-price-gbp=\"15\" data-sweater-price-usd=\"21\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/don-t-dream-it-be-it\" class=\"name\">Don&#39;t Dream It, Be It</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/252609\">EmilieBoisvert</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/praise-the-sun-reprint\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/74029-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/praise-the-sun-reprint\" class=\"name\">Praise the Sun (Reprint)</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/138898\">AutoSave</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/always-watching-759\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/76059-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/always-watching-759\" class=\"name\">Always watching</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/422897\">Melkron</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/see-you-space-cowboy-461\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/85847-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/see-you-space-cowboy-461\" class=\"name\">See You Space Cowboy...</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/402649\">hyperstaticas</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/over-the-hill\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/86466-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/over-the-hill\" class=\"name\">Over The Hill</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/425209\">AlynSpiller</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/skellington\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/87959-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/skellington\" class=\"name\">Skellington</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/501536\">KoLabs</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/tokyo-ink\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/88017-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/tokyo-ink\" class=\"name\">Tokyo Ink</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/376850\">Dracortis</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/artorias-sif-art-186\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/89277-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/artorias-sif-art-186\" class=\"name\">Artorias &amp; Sif</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/507424\">Taki93</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/red-shadow-white-version\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/86871-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/red-shadow-white-version\" class=\"name\">Red Shadow</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/413324\">Kryokyma</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/ninja-cat\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/90593-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/ninja-cat\" class=\"name\">Ninja Cat</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/503179\">Totem60</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/zoro-art\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/88727-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/zoro-art\" class=\"name\">Zoro </a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/502839\">BeachBoy993</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/disobey-616\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/91969-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"24\"\n" +
                "data-sweater-price-gbp=\"21\" data-sweater-price-usd=\"26\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/disobey-616\" class=\"name\">Disobey</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/122755\">ddjvigo</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/pocket-pandas\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/83170-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"24\"\n" +
                "data-sweater-price-gbp=\"21\" data-sweater-price-usd=\"26\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/pocket-pandas\" class=\"name\">Pocket Pandas</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/361052\">BekaDesigns</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/slow-sloth\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/93488-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"24\"\n" +
                "data-sweater-price-gbp=\"21\" data-sweater-price-usd=\"26\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/slow-sloth\" class=\"name\">Slow sloth</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/463132\">NemiMakeit</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/nice-shirt-820\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/94075-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"24\"\n" +
                "data-sweater-price-gbp=\"21\" data-sweater-price-usd=\"26\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/nice-shirt-820\" class=\"name\">Nice Shirt</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/400299\">KindaCreative</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/without-the-other\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/93385-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"24\"\n" +
                "data-sweater-price-gbp=\"21\" data-sweater-price-usd=\"26\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/without-the-other\" class=\"name\">Without the other</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/493632\">EWN</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/never-one\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/93384-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"24\"\n" +
                "data-sweater-price-gbp=\"21\" data-sweater-price-usd=\"26\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/never-one\" class=\"name\">Never one</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/493632\">EWN</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/le-dragon-noir-147\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/96653-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"24\"\n" +
                "data-sweater-price-gbp=\"21\" data-sweater-price-usd=\"26\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/le-dragon-noir-147\" class=\"name\">Le Dragon Noir</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/189241\">Qwerteebot</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/meowntain-680\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/84735-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/meowntain-680\" class=\"name\">Meowntain</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/8\">Qwertee</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/sharkasm-778\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/85665-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/sharkasm-778\" class=\"name\">Sharkasm</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/135\">TeoZ</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/banksy-flower-368\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/84081-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/banksy-flower-368\" class=\"name\">Banksy Flower</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/100199\">Naolito</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/blood-and-ice-cream-1\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/84894-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/blood-and-ice-cream-1\" class=\"name\">Blood and Ice Cream</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/17541\">TomTrager</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>";

        String second = "\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/super-exclusive-club-125\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/85357-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/super-exclusive-club-125\" class=\"name\">Super Exclusive Club</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/44263\">Dooomcat</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/phanton-boss\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/86594-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/phanton-boss\" class=\"name\">Phanton BOSS</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/422897\">Melkron</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/erebor-stout\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/60492-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/erebor-stout\" class=\"name\">Erebor Stout</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/269204\">CoryFreemanDesign</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/aaaaa\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/73197-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/aaaaa\" class=\"name\">Ghost Pirate Grog</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/281470\">Nemons</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/tboi\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/90405-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/tboi\" class=\"name\">Isaac</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/285490\">Uyuni</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/a-cute-way-to-sleep-270\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/92161-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"24\"\n" +
                "data-sweater-price-gbp=\"21\" data-sweater-price-usd=\"26\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/a-cute-way-to-sleep-270\" class=\"name\">A Cute Way to Sleep</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/429193\">JAZZCOLA</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/wonderland-moon\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/91536-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"24\"\n" +
                "data-sweater-price-gbp=\"21\" data-sweater-price-usd=\"26\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/wonderland-moon\" class=\"name\">Wonderland Moon</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/405100\">ManuelDA</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/fire-and-blood-180\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/64938-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"24\"\n" +
                "data-sweater-price-gbp=\"21\" data-sweater-price-usd=\"26\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/fire-and-blood-180\" class=\"name\">SHADOW OF THE DALEK</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/78202\">Fuacka</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/shadows-of-suspense\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/92486-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"24\"\n" +
                "data-sweater-price-gbp=\"21\" data-sweater-price-usd=\"26\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/shadows-of-suspense\" class=\"name\">Shadows of Suspense</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/242041\">mmarcin</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/skills\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/94073-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"24\"\n" +
                "data-sweater-price-gbp=\"21\" data-sweater-price-usd=\"26\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/skills\" class=\"name\">Skills</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/284236\">FatLizardStudio</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/outatime\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/36153-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/outatime\" class=\"name\">OutaTime</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/28681\">CoDdesigns</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/knowledge-rules\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/52940-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/knowledge-rules\" class=\"name\">Knowledge Rules</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/161749\">RicoMambo</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/mononoke-him\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/74383-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/mononoke-him\" class=\"name\">Hime.</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/277426\">SergioMancinelli</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/x-enomorph-ray-87\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/84848-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/x-enomorph-ray-87\" class=\"name\">X(enomorph)-Ray</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/91827\">harantuladesign</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/gamer-s-crest\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/84736-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/gamer-s-crest\" class=\"name\">Gamer&#39;s Crest</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/8\">Qwertee</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/freddie-mercury\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/84738-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/freddie-mercury\" class=\"name\">Freddie Mercury</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/33508\">wirdou</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/indiana-mouse-219\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/85667-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/indiana-mouse-219\" class=\"name\">Indiana Mouse</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/100199\">Naolito</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/seal-of-approval-248\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/82701-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/seal-of-approval-248\" class=\"name\">Seal of Approval</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/467442\">laurarghh</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/death-moon\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/63956-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/death-moon\" class=\"name\">Death Moon</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/375420\">BlackTaz</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/take-over-the-world-229\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/84080-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/take-over-the-world-229\" class=\"name\">Take Over the World</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/33038\">thehookshot</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/standard-nerds-368\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/84559-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/standard-nerds-368\" class=\"name\">Standard Nerds</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/17541\">TomTrager</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/splat-69\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/84558-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/splat-69\" class=\"name\">Splat!</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/213070\">maped</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/catvengers-the-age-of-meowtron\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/77676-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/catvengers-the-age-of-meowtron\" class=\"name\">CATVENGERS-The Age of Meowtron</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/86014\">danielcm</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/fellowship-of-the-fantasy-183\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/86262-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/fellowship-of-the-fantasy-183\" class=\"name\">Fellowship of the Fantasy</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/100835\">AdamsPinto</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/i-hate-humans\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/81270-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/i-hate-humans\" class=\"name\">I Hate Humans</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/405100\">ManuelDA</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/i-walk-with-wasd\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/88944-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/i-walk-with-wasd\" class=\"name\">I Walk with WASD</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/8\">Qwertee</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/i-choose-fire\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/88163-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/i-choose-fire\" class=\"name\">I Choose Fire</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/281746\">jml2art</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/i-choose-water\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/88164-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>";
        String third = "\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/i-choose-water\" class=\"name\">I Choose Water</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/281746\">jml2art</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/world-domination-137\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/88589-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/world-domination-137\" class=\"name\">World Domination</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/115811\">PolySciGuy</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/minas-tirith-ale\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/88631-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/minas-tirith-ale\" class=\"name\">Minas Tirith Ale</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/269204\">CoryFreemanDesign</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/mordor-dark-ale-976\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/88632-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/mordor-dark-ale-976\" class=\"name\">Mordor Dark Ale</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/269204\">CoryFreemanDesign</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/the-legend-of-crash-akus-mask\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/70304-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/the-legend-of-crash-akus-mask\" class=\"name\">The Legend of Crash: Aku&#39;s Mask</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/366542\">Natarya</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/little-saiyan\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/91312-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/little-saiyan\" class=\"name\">Little Saiyan</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/273568\">StudioM6</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/it-s-bigger-on-the-inside-glow\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/93025-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"24\"\n" +
                "data-sweater-price-gbp=\"21\" data-sweater-price-usd=\"26\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/it-s-bigger-on-the-inside-glow\" class=\"name\">It&#39;s bigger on the inside. Glow!</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/493597\">LestatPrincess</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/rawr\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/52736-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/rawr\" class=\"name\">Rawr!</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/96346\">CrumblinCookie</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/lazy-cat\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/84729-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/lazy-cat\" class=\"name\">Lazy Cat!</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/8\">Qwertee</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/not-a-morning-person-571\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/85093-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/not-a-morning-person-571\" class=\"name\">Not a Morning Person</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/115811\">PolySciGuy</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/under-the-stars-63\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/84826-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/under-the-stars-63\" class=\"name\">Under the Stars</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/76768\">filiskun</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/infant-mutant-ninja-turtles-2\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/86630-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/infant-mutant-ninja-turtles-2\" class=\"name\">Infant Mutant Ninja Turtles</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/26451\">AaronThadathil</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/fighters-against-angels\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/87149-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/fighters-against-angels\" class=\"name\">Fighters Against Angels</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/281746\">jml2art</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/save-the-unicorns-396\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/87910-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/save-the-unicorns-396\" class=\"name\">Save the Unicorns</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/86274\">Gallifreya</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/galactic-rhapsody\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/87106-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/galactic-rhapsody\" class=\"name\">Galactic Rhapsody</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/318487\">DarkInvaderDickwraith</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/future-wars\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/87960-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/future-wars\" class=\"name\">Future wars</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/494912\">DCVisualArts</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/la-petite-rey-389\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/91633-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"24\"\n" +
                "data-sweater-price-gbp=\"21\" data-sweater-price-usd=\"26\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/la-petite-rey-389\" class=\"name\">La Petite Rey</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/299974\">saqman</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/fire-skeleton\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/94648-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"24\"\n" +
                "data-sweater-price-gbp=\"21\" data-sweater-price-usd=\"26\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/fire-skeleton\" class=\"name\">Fire Skeleton</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/264015\">Vallina84</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/deadly-sketch\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/93843-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"24\"\n" +
                "data-sweater-price-gbp=\"21\" data-sweater-price-usd=\"26\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/deadly-sketch\" class=\"name\">Deadly Sketch</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/13822\">YiannisTees</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/boo-moon\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/95334-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"24\"\n" +
                "data-sweater-price-gbp=\"21\" data-sweater-price-usd=\"26\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/boo-moon\" class=\"name\">Boo Moon</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/405100\">ManuelDA</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/it-s-so-fluffy\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/95091-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"24\"\n" +
                "data-sweater-price-gbp=\"21\" data-sweater-price-usd=\"26\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/it-s-so-fluffy\" class=\"name\">It&#39;s so fluffy!!</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/241737\">ItokoDesign</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/home-for-imaginary-friends\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/84743-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"10\"\n" +
                "data-tee-price-gbp=\"8\" data-tee-price-usd=\"12\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/home-for-imaginary-friends\" class=\"name\">Home for Imaginary Friends</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/8\">Qwertee</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/an-adventurer-like-you-217\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/84828-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/an-adventurer-like-you-217\" class=\"name\">An Adventurer Like You</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/367571\">hyperlixir</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/become-a-scientist\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/86261-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/become-a-scientist\" class=\"name\">Become a Scientist</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/33508\">wirdou</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/zombies-549\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/81355-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/zombies-549\" class=\"name\">Zombies</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/460200\">atteoM</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/flash-back\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/86289-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/flash-back\" class=\"name\">FLASH BACK</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/124243\">CappO</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/order-in-the-galaxy\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/87913-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/order-in-the-galaxy\" class=\"name\">Order In The Galaxy</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/494912\">DCVisualArts</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/remember-696\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/89063-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/remember-696\" class=\"name\">Remember</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/233333\">TheSuperSheep</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/how-to-fist-bump-347\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/90494-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/how-to-fist-bump-347\" class=\"name\">How to Fist Bump</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/189241\">Qwerteebot</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/a-smile-from-the-shadows\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/91358-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/a-smile-from-the-shadows\" class=\"name\">A Smile From The Shadows</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/88244\">drsimonbutler</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/team-rogers-904\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/92962-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"24\"\n" +
                "data-sweater-price-gbp=\"21\" data-sweater-price-usd=\"26\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/team-rogers-904\" class=\"name\">Team Rogers</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/51202\">BrandonWilhelmART</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/team-stark-460\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/92963-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"24\"\n" +
                "data-sweater-price-gbp=\"21\" data-sweater-price-usd=\"26\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/team-stark-460\" class=\"name\">Team Stark</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/51202\">BrandonWilhelmART</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/caffeine-powers-activate-597\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/84740-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/caffeine-powers-activate-597\" class=\"name\">Caffeine Powers Activate</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/3550\">Obvian</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/the-trooper-325\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/84707-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/the-trooper-325\" class=\"name\">The Trooper</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/24241\">MarkWelser</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/quinn-of-diamonds-803\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/91752-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"24\"\n" +
                "data-sweater-price-gbp=\"21\" data-sweater-price-usd=\"26\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>";
        String fourth = "\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/quinn-of-diamonds-803\" class=\"name\">Quinn of Diamonds</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/70456\">XmashedGear</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/freaks-vol-2\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/79975-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"24\"\n" +
                "data-sweater-price-gbp=\"21\" data-sweater-price-usd=\"26\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/freaks-vol-2\" class=\"name\">Nightmare Moon (Glows)</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/405100\">ManuelDA</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/be-positive\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/65599-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/be-positive\" class=\"name\">Be Positive!</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/405100\">ManuelDA</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/critical-failure-152\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/89540-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/critical-failure-152\" class=\"name\">CRITICAL FAILURE</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/100835\">AdamsPinto</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/the-neighbors\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/94030-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"24\"\n" +
                "data-sweater-price-gbp=\"21\" data-sweater-price-usd=\"26\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/the-neighbors\" class=\"name\">The Neighbors</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/543344\">vptrinidad</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/dragon-moon-677\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/95335-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"24\"\n" +
                "data-sweater-price-gbp=\"21\" data-sweater-price-usd=\"26\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/dragon-moon-677\" class=\"name\">Dragon Moon</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/405100\">ManuelDA</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/not-the-droids-we-are-looking-for-912\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/84851-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/not-the-droids-we-are-looking-for-912\" class=\"name\">Not The Droids We Are Looking For</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/33508\">wirdou</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/10th\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/89028-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"10\"\n" +
                "data-tee-price-gbp=\"8\" data-tee-price-usd=\"12\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/10th\" class=\"name\">10th</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/17541\">TomTrager</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/dancing-dragons\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/88797-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/dancing-dragons\" class=\"name\">Dancing Dragons</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/91827\">harantuladesign</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/link-s-memories\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/82661-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/link-s-memories\" class=\"name\">Link&#39;s memories</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/298592\">SrPompas</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/silly-road-769\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/89538-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/silly-road-769\" class=\"name\">Silly Road</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/69924\">JBaz</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/three-brothers-tale-253\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/85096-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/three-brothers-tale-253\" class=\"name\">Three Brothers Tale</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/405100\">ManuelDA</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/not-a-people-person-97\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/88656-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/not-a-people-person-97\" class=\"name\">Not A People Person</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/115811\">PolySciGuy</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/trust-me-678\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/91268-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/trust-me-678\" class=\"name\">TRUST ME!</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/325074\">Manu96</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/we-don-t-need-roads-237\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/91974-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"7\"\n" +
                "data-tee-price-gbp=\"6\" data-tee-price-usd=\"8\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"24\"\n" +
                "data-sweater-price-gbp=\"21\" data-sweater-price-usd=\"26\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/we-don-t-need-roads-237\" class=\"name\">We Don&#39;t Need Roads</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/182873\">olly</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/rpg-united\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/93458-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"24\"\n" +
                "data-sweater-price-gbp=\"21\" data-sweater-price-usd=\"26\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/rpg-united\" class=\"name\">RPG United</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/106051\">Letter-Q</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/schrodinger-s-cat-6\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/84734-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/schrodinger-s-cat-6\" class=\"name\">Schrodinger&#39;s Cat</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/8\">Qwertee</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/the-botfather-128\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/82666-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/the-botfather-128\" class=\"name\">The Botfather</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/265146\">Melonseta</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/brace-yourself\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/88545-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/brace-yourself\" class=\"name\">Brace yourself!</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/457322\">Queenlear</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/meaning-of-life-184\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/85664-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/meaning-of-life-184\" class=\"name\">Meaning of Life</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/8\">Qwertee</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/schrodingers-dropbox-506\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/85092-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/schrodingers-dropbox-506\" class=\"name\">Schrodingers Dropbox</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/40827\">Phillymar</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/sushi-fusion-354\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/84737-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/sushi-fusion-354\" class=\"name\">Sushi Fusion</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/8\">Qwertee</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/ghost-trap\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/61366-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"24\"\n" +
                "data-sweater-price-gbp=\"21\" data-sweater-price-usd=\"26\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/ghost-trap\" class=\"name\">Cartridge of Time</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/100199\">Naolito</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/the-hero-650\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/90891-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"24\"\n" +
                "data-sweater-price-gbp=\"21\" data-sweater-price-usd=\"26\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/the-hero-650\" class=\"name\">The Hero!</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/245250\">Sampool</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/you-shall-not-pass-864\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/84731-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/you-shall-not-pass-864\" class=\"name\">You Shall Not Pass!</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/8\">Qwertee</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/just-fluffy\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/92881-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"24\"\n" +
                "data-sweater-price-gbp=\"21\" data-sweater-price-usd=\"26\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/just-fluffy\" class=\"name\">Just fluffy</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/463132\">NemiMakeit</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/i-believe-905\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/93314-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"24\"\n" +
                "data-sweater-price-gbp=\"21\" data-sweater-price-usd=\"26\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/i-believe-905\" class=\"name\">I Believe</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/241860\">djkopet</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/communist-party\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/87151-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/communist-party\" class=\"name\">Communist Party</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/494973\">tomburns</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/classic-915\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/91044-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"10\"\n" +
                "data-tee-price-gbp=\"8\" data-tee-price-usd=\"12\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/classic-915\" class=\"name\">Classic</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/17541\">TomTrager</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/playing-with-power-481\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/87644-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/playing-with-power-481\" class=\"name\">Playing With Power</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/33038\">thehookshot</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "        <li class=\"tee-list-item \">\n" +
                "            <a href=\"/product/fullmetal-graffiti\">\n" +
                "                <img src=\"//cdn.qwertee.com/images/designs/product-thumbs/90311-zoom-255x306.jpg\" alt=\"\">\n" +
                "            </a>\n" +
                "                <div class=\"price\"><span class=\"product-price\" data-type=\"tee\" data-cursym-eur=\"€\" data-cursym-gbp=\"£\" data-cursym-usd=\"$\" data-tee-price-eur=\"15\"\n" +
                "data-tee-price-gbp=\"12\" data-tee-price-usd=\"15\" data-hoodie-price-eur=\"35\"\n" +
                "data-hoodie-price-gbp=\"35\" data-hoodie-price-usd=\"35\" data-sweater-price-eur=\"25\"\n" +
                "data-sweater-price-gbp=\"25\" data-sweater-price-usd=\"25\" data-print-price-eur=\"10\"\n" +
                "data-print-price-gbp=\"8\" data-print-price-usd=\"12\" ></span></div>\n" +
                "            <div class=\"info\">\n" +
                "                <div class=\"inner\">\n" +
                "                    <a href=\"/product/fullmetal-graffiti\" class=\"name\">FullMetal Graffiti</a><br>\n" +
                "                    <span class=\"author\">by <a href=\"/profile/211565\">Fearcheck</a></span>\n" +
                "                    </div>\n" +
                "            </div>\n" +
                "        </li>\n" +
                "</ul>\n" +
                "    <div class=\"clear\"></div>\n" +
                "</div>\n" +
                "\n" +
                "<input type=\"hidden\" name=\"_csrf\" value=\"K2Qicytz--uOQjF7SCOX_0UWjn_Nun8U1HlI\">\n" +
                "        <div class=\"clear\"></div>\n" +
                "    </div>\n" +
                "\n" +
                "\n" +
                "    <div class=\"popup\" id=\"newsletter-popup\">\n" +
                "        <h2 class=\"raleway\">NEARLY THERE</h2>\n" +
                "        <div class=\"content\">\n" +
                "            <p class=\"communicate\"></p>\n" +
                "            <p class=\"actions centered\"><a href=\"#\" class=\"submit close\">CLOSE</a></p>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "\n" +
                "    <p class=\"show-full-version\">\n" +
                "        <a href=\"?force-desktop=1\">Show full version</a>\n" +
                "    </p>\n" +
                "\n" +
                "    <div id=\"footer\">\n" +
                "        <div class=\"footer-inner\">\n" +
                "            <hr>\n" +
                "            <div class=\"footer-three\">\n" +
                "                <h4>Newsletter:</h4>\n" +
                "                <p>Get a €1/£1/$1 discount code, sneak peeks of upcoming tees/sales, a chance at a free tee every week and more!</p>\n" +
                "                <form class=\"manage-subscriptions\" action=\"/newsletter\" method=\"post\">\n" +
                "                    <input type=\"hidden\" value=\"1\" name=\"newsletter\">\n" +
                "                    <input type=\"hidden\" name=\"_csrf\" value=\"K2Qicytz--uOQjF7SCOX_0UWjn_Nun8U1HlI\">\n" +
                "                    <input type=\"email\" name=\"email\" placeholder=\"Enter your email\">\n" +
                "                    <input type=\"submit\" value=\"JOIN!\" class=\"submit raleway\"><br>\n" +
                "                    <input type=\"checkbox\" value=\"1\" checked=\"checked\" name=\"daily\" id=\"footer-daily\">\n" +
                "                    <label for=\"footer-daily\">Also sign up for Daily Update Mail, Get €1/£1/$1 discount code and never miss a tee!</label>\n" +
                "                </form>\n" +
                "            </div>\n" +
                "            <div class=\"footer-three free-tees\">\n" +
                "                <h4>WANT TO WIN FREE TEES?</h4>\n" +
                "                We give away over 30 FREE TEES every single week.<br>\n" +
                "                Just <a href=\"/tees/free-tees\">click here</a> to win some now!!!\n" +
                "            </div>\n" +
                "            <div class=\"footer-three\" id=\"footer-icons\">\n" +
                "                <h4>Connect with Qwertee (to win!):</h4>\n" +
                "                <a class=\"facebook\" href=\"https://www.facebook.com/Qwertee\" target=\"_blank\"></a>\n" +
                "                <a class=\"twitter\" href=\"https://twitter.com/qwertee\" target=\"_blank\"></a>\n" +
                "                <a class=\"google\" href=\"https://plus.google.com/109683997264820223800\" target=\"_blank\"></a>\n" +
                "                <a class=\"pinterest\" href=\"https://www.pinterest.com/qwertee/\" target=\"_blank\"></a>\n" +
                "                <a class=\"tumblr\" href=\"http://qwertee.tumblr.com/\" target=\"_blank\"></a>\n" +
                "            </div>\n" +
                "            <div class=\"clear\"></div>\n" +
                "            <hr><br>\n" +
                "            <div class=\"footer-six\">\n" +
                "                <h4>Tees:</h4>\n" +
                "                <ol>\n" +
                "                    <li><a href=\"/\">Today's Tee</a></li>\n" +
                "                    <li><a href=\"/\">Last Chance Tee</a></li>\n" +
                "                    <li><a href=\"/shop\">Shop Tees</a></li>\n" +
                "                    <li><a href=\"/tees/previous/all\">Previous Tees</a></li>\n" +
                "                    <li><a href=\"/tees/free-tees\">Win FREE TEES!</a></li>\n" +
                "                </ol>\n" +
                "            </div>\n" +
                "            <div class=\"footer-six\">\n" +
                "                <h4>Vote:</h4>\n" +
                "                <ol>\n" +
                "                    <li><a href=\"/tees/vote/selected\">Vote For Tees</a></li>\n" +
                "                    <li><a href=\"/tees/vote/newest\">Newest Tees</a></li>\n" +
                "                    <li><a href=\"/tees/vote/popular\">Most Voted For Tees</a></li>\n" +
                "                    <li><a href=\"/submit-design\">Submit Your Design</a></li>\n" +
                "                    <li><a href=\"/resources\">Info For Artists</a></li>\n" +
                "                </ol>\n" +
                "            </div>\n" +
                "            <div class=\"footer-six\">\n" +
                "                <h4>Talk:</h4>\n" +
                "                <ol>\n" +
                "                    <li><a href=\"/forum\">Forums</a></li>\n" +
                "                    <li><a href=\"/blog\">Blog/News</a></li>\n" +
                "                    <li><a href=\"/rss\">RSS Feed</a></li>\n" +
                "                </ol>\n" +
                "            </div>\n" +
                "            <div class=\"footer-six\">\n" +
                "                <h4>Help:</h4>\n" +
                "                <ol>\n" +
                "                    <li><a href=\"#what-is-qwertee-popup\">How Does Qwertee Work?</a></li>\n" +
                "                    <li><a href=\"/help\">Help &amp; FAQ</a></li>\n" +
                "                    <li><a href=\"/user/orders\">Order Tracking</a></li>\n" +
                "                    <li><a href=\"/help\">Contact Us</a></li>\n" +
                "                    <li><a href=\"/jobs\">Jobs</a></li>\n" +
                "                </ol>\n" +
                "            </div>\n" +
                "            <div class=\"footer-six footer-address\">\n" +
                "                <h4>Company Info:</h4>\n" +
                "                <p><strong>US & Canada Mail Distributed Via</strong><br>\n" +
                "                International Sorting Centre<br>\n" +
                "                USPS | JFK International Airport<br>\n" +
                "                Building 250 | Jamaica NY 11430<br>\n" +
                "                United States of America</p>\n" +
                "\n" +
                "                <p>\n" +
                "                    <strong>Qwertee Registered Address:</strong><br>\n" +
                "                    Qwertee.com / Qwertee Ltd<br>\n" +
                "                    13 Upper Baggot St | 2nd Floor<br>\n" +
                "                    Dublin 4 | Ireland<br>\n" +
                "                    Company Number: 476522<br>\n" +
                "                </p>\n" +
                "            </div>\n" +
                "            <div class=\"footer-six footer-address\">\n" +
                "                <h4>&nbsp;</h4>\n" +
                "                <p><strong>UK Mail Distributed Via</strong><br>\n" +
                "                Royal Mail Birmingham Mail Centre<br>\n" +
                "                St. Stephens Street | Aston<br>\n" +
                "                Birmingham | B6 4AA<br>\n" +
                "                United Kingdom\n" +
                "                </p>\n" +
                "            </div>\n" +
                "            <div class=\"clear\"></div>\n" +
                "            <hr>\n" +
                "            <div id=\"footer-copyright\">\n" +
                "                &copy; Qwertee 2016. All designs copyright by owner. <a href=\"/privacy\">Privacy Policy</a>. <a href=\"/terms\">Terms of Use</a>. <a href=\"/cookies\">Cookies Policy</a>. <a href=\"/comments\">Comments Policy</a>. <a href=\"/help/contact\">Copyright Complaint</a>.\n" +
                "            </div>\n" +
                "        </div>\n" +
                "\n" +
                "        <div class=\"clear\"></div>\n" +
                "        <div id=\"loading-status\">Talking to server <span></span></div>\n" +
                "    </div>\n" +
                "</div>\n" +
                "\n" +
                "<div id=\"what-is-qwertee-popup\" class=\"popup\">\n" +
                "    <div class=\"content\">\n" +
                "        <h2>What is Qwertee?</h2>\n" +
                "        <p class=\"video-placeholder\"></p>\n" +
                "        <p class=\"actions centered\"><a href=\"#\" class=\"close submit\">Close</a></p>\n" +
                "    </div>\n" +
                "</div>\n" +
                "\n" +
                "<div id=\"cart-contents-error\" class=\"popup\">\n" +
                "    <h2 class=\"raleway\">WHOOPS!</h2>\n" +
                "    <div class=\"content\">\n" +
                "        <p class=\"text\"></p>\n" +
                "        <p class=\"actions centered\">\n" +
                "            <input type=\"submit\" class=\"submit close raleway\" value=\"CLOSE\">\n" +
                "        </p>\n" +
                "    </div>\n" +
                "</div>\n" +
                "<input name=\"_csrf\" value=\"K2Qicytz--uOQjF7SCOX_0UWjn_Nun8U1HlI\" type=\"hidden\">\n" +
                "\n" +
                "<script async=\"async\" src=\"//cdn.qwertee.com/js/main.js\"></script>\n" +
                "<script>\n" +
                "  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){\n" +
                "  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),\n" +
                "  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)\n" +
                "  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');\n" +
                "\n" +
                "  ga('create', 'UA-25877856-1', 'auto');\n" +
                "  ga('send', 'pageview');\n" +
                "\n" +
                "</script>\n" +
                "</body>\n" +
                "</html>\n";
        return first + second + third + fourth;
    }
}