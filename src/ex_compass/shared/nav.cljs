(ns ex-compass.shared.nav
  (:require [ex-compass.shared.state :as state]
            [ex-compass.shared.tabs :refer [Home Foo About]]))

(def compasses {:home {:id "home"
                       :index-route :home
                       :routes {:home Home :foo Foo}
                       :app-state state/app-state
                       :read state/read
                       :mutate nil
                       :route-dispatch true}
                :about {:id "about"
                        :index-route :about
                        :routes {:about About :foo Foo}
                        :app-state state/app-state
                        :read state/read
                        :mutate nil
                        :route-dispatch false}})

(defn drawer->compass [id]
  (get compasses id))

;;;(def drawers [:home :about])
