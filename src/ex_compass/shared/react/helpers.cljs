(ns ex-compass.shared.react.helpers
  (:require [ex-compass.shared.react.requires :as rr]))

(def app-registry (.-AppRegistry js/ReactNative))

;; ex-navigation
(defn nav-provider
  "..."
  [opts & children]
  (js/React.createElement rr/NavigationProvider (clj->js opts) (clj->js children)))

(defn stack-nav
  "..."
  [opts & children]
  (js/React.createElement rr/StackNavigation (clj->js opts) (clj->js children)))

(defn drawer-nav
  "..."
  [opts & children]
  (js/React.createElement rr/DrawerNavigation (clj->js opts) (clj->js children)))

(defn drawer-nav-item
  "..."
  [opts & children]
  (js/React.createElement rr/DrawerNavigationItem (clj->js opts) (clj->js children)))

(defn action
  "..."
  [name & opts]
  (name rr/NavigationActions (clj->js opts)))
