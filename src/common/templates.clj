(ns common.templates)

(def frontPage [:div 
                [:div.header [:span.leftIcon] [:input.searchField] [:span.searchIcon]]
                [:h1.biblogo "Kardemommeby Bibliotek"]
                [:div
                 [:span.patronStatus "Afl. 21/1-13, 4 lån, 1 hjemkomne"]
                 [:span.openingTimes]]
                [:ul.newsWidget
                 [:li.item [:span.date "3/1-13"] [:span.content "blah blah blah"]]
                 [:li.item [:span.date "3/1-13"] [:span.content "blah blah blah"]]
                 [:li.item [:span.date "3/1-13"] [:span.content "blah blah blah"]]]
                [:ul.calendarWidget
                 [:li.item [:span.date "3/1-13"] [:span.content "blah blah blah"]]
                 [:li.item [:span.date "3/1-13"] [:span.content "blah blah blah"]]
                 [:li.item [:span.date "3/1-13"] [:span.content "blah blah blah"]]]])
