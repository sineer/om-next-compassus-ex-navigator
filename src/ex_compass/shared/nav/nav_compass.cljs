(ns ex-compass.shared.nav.nav-compass
  (:require [re-natal.support :as sup]
            [ex-compass.shared.state :as s]
            [ex-compass.shared.nav.core :as nav]
            [ex-compass.shared.nav.routes :as routes]))

(def set-route! nav/set-route!)

(defonce nav-compass
  (let [config {:read s/read
                :mutate nil
                :routes routes
                :index-route :nav/root
                :route-dispatch true
                :reconciler-config {:state s/app-state
                                    :root-render  sup/root-render
                                    :root-unmount sup/root-unmount}}]
    (reset! nav/compass (nav/create-compass config))
    (println " * nav/compass initialized!")))
