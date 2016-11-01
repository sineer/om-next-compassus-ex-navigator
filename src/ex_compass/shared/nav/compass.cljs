(ns ex-compass.shared.nav.compass
  (:require [compassus.core :as compassus]))

(def set-route! compassus/set-route!)

(def ^:private new-compass [{:keys [routes index-route mixins reconciler] :as opts}]
  (let [index-route (or index-route (ffirst routes))
        reconciler (compassus/assemble-compassus-reconciler reconciler routes index-route mixins)]
    (compassus/CompassusApplication.
     {:route->component routes
      :mixins           mixins
      :reconciler       reconciler
      :root-class       nil}
     (atom {}))))

(defn create-compass [{:keys [read mutate route-dispatch reconciler-config] :as compass-config}]
  (assoc reconciler-config :parser (compassus/parser {:read read :mutate mutate :route-dispatch route-dispatch}))
  (let [reconciler (om/reconciler reconciler-config)
        compass (new-compass compass-config)]
    {:compass compass
     :reconciler reconciler}))
