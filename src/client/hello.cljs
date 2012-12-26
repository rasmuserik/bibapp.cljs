(ns hello
  (:require [crate.core :as crate]))

(def frontPage [:div 
                [:div.header [:span.leftIcon] [:input.searchField] [:span.searchIcon]]
                [:h1.biblogo "Kardemommeby Bibliotek"]
                [:div
                 [:span.patronStatus "Afl. 21/1-13, 4 lån, 1 hjemkomne"]
                 [:span.openingTimes]]
                [:ul.news
                 [:li.item [:span.date "3/1-13"] [:span.content "blah blah blah"]]
                 [:li.item [:span.date "3/1-13"] [:span.content "blah blah blah"]]
                 [:li.item [:span.date "3/1-13"] [:span.content "blah blah blah"]]]
                [:ul.calendar
                 [:li.item [:span.date "3/1-13"] [:span.content "blah blah blah"]]
                 [:li.item [:span.date "3/1-13"] [:span.content "blah blah blah"]]
                 [:li.item [:span.date "3/1-13"] [:span.content "blah blah blah"]]]])
(.appendChild js/document.body (crate/html frontPage))

'(
(defn hello 
  "print a greeting"
  [name]
  (.write js/document (+ "<p>Hello " name "</p>")))

(hello (map hello [125 322]))
(hello (reduce + ["foo" "bar"]))
(map hello [124 324])
(hello 'atom)
(.appendChild js/document.body (crate/html [:span.test {:style "color: red"} "crate"]))
  )
