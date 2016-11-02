(ns ex-compass.shared.tabs
  (:require-macros [natal-shell.components :refer [view text]])
  (:require [om.next :as om :refer-macros [defui]]
            [ex-compass.shared.nav.sight :refer [sight]]
            [ex-compass.shared.react.helpers :refer [tab-nav tab-nav-item]]))

(defui HomeNav
  Object
  (render [this]
          (tab-nav {:tabBarHeight 56 :initialTab "home/home"}
                   ;; TODO tab-sight macro...
                   (tab-nav-item {:id "home/home-item"}
                             (sight {:id "home/home-tab" :routes [:home/home]}))
                   (tab-nav-item {:id "home/foo-item"}
                             (sight {:id "home/foo-tab" :routes [:home/foo]})))))

(defui AboutNav
  Object
  (render [this]
          (tab-nav {:tabBarHeight 56 :initialTab "about/about"}
                   ;; TODO tab-sight macro...
                   (tab-nav-item {:id "about/about-item"}
                             (sight {:id "about/about-tab" :routes [:about/about]}))
                   (tab-nav-item {:id "about/foo-item"}
                             (sight {:id "about/foo-tab" :routes [:about/foo]})))))

(defui Home
  Object
  (render [this]
          (view {} (text {} "HOME"))
          ))

(defui Foo
  Object
  (render [this]
          (view {} (text {} "FOO"))
          ))

(defui About
  Object
  (render [this]
          (view {} (text {} "ABOUT"))
          ))
