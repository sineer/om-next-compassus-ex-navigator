(ns ex-compass.shared.nav.compass
  (:require [om.next :as om]
            [compassus.core :as compassus]))

(def set-route! compassus/set-route!)
(def current-route compassus/current-route)

(defn get-reconciler [compass] (compassus/get-reconciler compass))

(defn ^:private new-compass [{:keys [:routes :index-route :mixins :reconciler]}]
  (let [index-route (or index-route (ffirst routes))
        r (compassus/assemble-compassus-reconciler reconciler routes index-route mixins)]
    (compassus/CompassusApplication.
     {:route->component routes
      :mixins           mixins
      :reconciler       r
      :root-class       nil}
     (atom {}))))

(defn create-compass [{:keys [:read :mutate :route-dispatch :reconciler-config] :as compass-config}]
  (println "create-compass called!")
  (assoc reconciler-config :parser (compassus/parser {:read read :mutate mutate :route-dispatch route-dispatch}))
  (let [reconciler (om/reconciler reconciler-config)
        compass (new-compass (assoc compass-config :reconciler reconciler))]
    (println "Compass initialized!")
    compass))
