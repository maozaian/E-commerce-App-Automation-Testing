

  Feature:
   Scenario:     1:  user opens facebook link

      When             user opens facebook link
      And             facebook "https://www.facebook.com/nopCommerce" is opened in new tab

    Scenario:     2:  user opens twitter link

      And             user opens twitter link
      And             twitter "https://twitter.com/nopCommerce" is opened in new tab

    Scenario:     3:  user opens rss link

      And             user opens rss link
      And             rss "https://demo.nopcommerce.com/new-online-store-is-open" is opened in new tab

    Scenario:     4:  user opens youtube link

      And             user opens youtube link
      Then            youtube "https://www.youtube.com/user/nopCommerce" is opened in new tab



