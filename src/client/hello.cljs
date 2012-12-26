(ns hello
  (:require [crate.core :as crate]))

(defn hello 
  "print a greeting"
  [name]
  (.write js/document (+ "<p>Hello " name "</p>")))

(hello (map hello [125 322]))
(hello (reduce + ["foo" "bar"]))
(map hello [124 324])
(hello 'atom)
(.appendChild js/document.body (crate/html [:span.test {:style "color: red"} "crate"]))
