(ns ex-compass.shared.nav.nav-compass
  (:require [re-natal.support :as sup]
            [ex-compass.shared.state :as s]
            [ex-compass.shared.nav.core :as nav]
            [ex-compass.shared.nav.compass :as c]
            [ex-compass.shared.routes :as routes]))

(def set-route! nav/set-route!)

(def nav-config {:read s/read
                 :mutate nil
                 :routes routes/compass
                 :index-route :nav/root
                 :route-dispatch true
                 :reconciler-config {:state s/app-state
                                     :root-render  sup/root-render
                                     :root-unmount sup/root-unmount}})

(defn nav-reset! []
  (reset! nav/compass (c/create-compass nav-config)))
