(ns bibapp
  (:require [crate.core :as crate] 
            [cljs.core :as core]
            ))

(set! core/*print-fn* (fn [x] (.log js/console x)))


(def frontPage [:div.foo.bar
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

(.appendChild js/document.body (crate/html frontPage))
(defn style 
  "create a style object based on the window dimensions"
  [width height]
  (let 
    [w (min height width)
     unit (int (/ w 6))]
     { :header 
         {:position "fixed"
           :top 0
           :left 0
           :width w 
           :height unit
           :background "rgba(0,0,255,0.1)"
           }
        :searchField { :background "rgba(0,0,255,0)" }
        :item {:background "red"}}))

(defn for-each 
  "execute a function on each member of a sequence"
  [f coll]
  (if-let [s (seq coll)]
    (do
      (f (first s))
      (recur f (rest s)))
    coll))

(extend-type js/HTMLCollection
  core/ISeqable
  (-seq [coll] (core/array-seq coll 0)))

(extend-type js/DOMTokenList
  core/ISeqable
  (-seq [coll] (core/array-seq coll 0)))

(defn applyStyle
  "Assign style to elements"
  ([styleObj] (applyStyle styleObj js/document.body))
  ([styleObj elem] 
   (do
     (for-each (fn [elem] (applyStyle styleObj elem))
               (.-children elem))
     (for-each (fn [cls] 
                 (if-let [style (styleObj (keyword cls))]
                   (let [styleTarget (.-style elem)]
                     (for-each (fn [styleItem]
                         (let [k (key styleItem)
                               v (val styleItem)]
                          (aset styleTarget (name (key styleItem)) (print (typeof (val styleItem))))))
                       style)) 
                   nil
                 ))
      (.-classList elem)))))
  
(applyStyle (style (.-innerWidth js/window) (.-innerHeight js/window)))
(println (style (.-innerWidth js/window) (.-innerHeight js/window)))
