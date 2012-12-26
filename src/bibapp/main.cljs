(ns bibapp
  (:require [crate.core :as crate] [common.templates :as templates]))

(.appendChild js/document.body (crate/html templates/frontPage))
