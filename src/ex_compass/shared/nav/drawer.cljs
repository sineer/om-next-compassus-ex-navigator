(ns ex-compass.shared.nav.drawer
  (:require-macros [natal-shell.components :refer [view text]])
  (:require [om.next :as om :refer-macros [defui]]
;;;            [sw.shared.react.icons :refer [ion-icon]]
            [ex-compass.shared.nav.sight :refer [sight]]
            [ex-compass.shared.react.helpers :refer [drawer-nav drawer-nav-item]]
            [ex-compass.shared.tabs :refer [HomeNav AboutNav]]))


(def styles {:header {:flex 1
                      :height 180
                      :width nil
                      :resizeMode "cover"}
             :buttonTitleText {:color "#222"
                               :fontWeight "bold"
                               :marginLeft 18}
             :buttonTitleTextSelected {:color "#123456"}
             :icon {:color "#999"}
             :selectedText {:color "#FF0000"}
             :selectedItemStyle {:backgroundColor "#D8D8D8"}})


(defn render-header []
  (text {} "HEADER"))

(defn render-title [title isSelected]
  (text {:style [(:buttonTitleText styles) (if isSelected (:buttonTitleTextSelected styles) {})]} title))

(defn render-icon [name isSelected] (text {} name)) ;(ion-icon {:name name :size 30}))


(defui Drawer
  Object
  (render [this]
          (let [config (:config (om/get-state this))]
            (drawer-nav {:navigatorUID "root"
                         :renderHeader (fn [] (render-header))
                         :drawerWidth 300
                         :initialItem "drawer-home"}

                      ;; HomeNav
                      (drawer-nav-item {:id "drawer-home" :key "drawer-home"
                                        :selectedStyle (:selectedItemStyle styles)
                                        :renderTitle (fn [isSelected] (render-title "Apps" isSelected))
                                        :renderIcon (fn [isSelected] (render-icon "md-apps" isSelected))}
                                       (sight {:id "nav/home" :rouetes [:nav/home]}))

                      ;; AboutNav
                      (drawer-nav-item {:id "drawer-about" :key "drawer-about"
                                        :selectedStyle (:selectedItemStyle styles)
                                        :renderTitle (fn [isSelected] (render-title "About" isSelected))
                                        :renderIcon (fn [isSelected] (render-icon "md-jet" isSelected))}
                                       (sight {:id "nav/about" :routes [:nav/about]
                                               :routeConfig {:navigationBar {:backgroundColor "#0084FF" :tintColor "#FFF"}}}))

                      ))))

(def drawer (om/factory Drawer {:keyfn :key}))
