(ns ex-compass.shared.nav
  (:require [ex-compass.shared.tabs :refer [Home Foo About]]))

(def drawers-compass-config {:home {:id home :index-route Home}
                             :about {:id about :index-route About}})
