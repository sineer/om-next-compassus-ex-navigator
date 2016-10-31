(ns ex-compass.shared.tabs
  (:require-macros [natal-shell.components :refer [view text]])
  (:require [om.next :as om :refer-macros [defui]]
            [ex-compass.shared.compass :refer [compass]]
            [ex-compass.shared.nav :refer [nav->compass]]
            [ex-compass.shared.react.helpers :refer [tab-nav tab-nav-item]]))

(def tabs {:home-tab {:id "home-tab"
                      :index-route :home
                      :routes {:home Home :foo Foo}}
           :about-tab {:id "about-tab"
                       :index-route :about
                       :routes {:about About :foo Foo}}})

(defui HomeNav
  Object
  (render [this]
          (tab-nav {:tabBarHeight 56 :initialTab "home/home"}
                   (tab-item {:id "home/home"} (sight {:key "home/home" :config (:home-tab tabs)}))
                   (tab-item {:id "home/foo"} (sight {:key "home/foo" :config (nav->compass :foo-tab)})))))

(defui AboutNav
  Object
  (render [this]
          (tab-nav {:tabBarHeight 56 :initialTab "about/about"}
                   (tab-item {:id "about/about"} (sight {:key "about/about" :config (nav->compass :about-tab)}))
                   (tab-item {:id "about/foo"} (sight {:key "about/foo" :config (nav->compass :foo-tab)})))))

(defui Home
  Object
  (render [this]
          ))

(defui Foo
  Object
  (render [this]
          ))

(defui About
  Object
  (render [this]
          ))
