(ns ex-compass.shared.nav.core
  (:require [om.next :as om :refer-macros [defui]]
            [re-natal.support :as sup]
            [ex-compass.shared.state :as s]
            [ex-compass.shared.nav.compass :as compass]))

(def compass (atom nil))

(def roots (atom {}))
(def sights (atom {}))

(defn set-route!
  ([next-route]
   (set-route! next-route nil))
  ([next-route {:keys [queue? params tx] :or {queue? true} :as opts}]
   (compass/set-route! @compass next-route opts)))

(defn get-reconciler [] (compass/get-reconciler @compass))

(defn current-route [] (compass/current-route @compass))

(defn app-root [id] (let [RootNode (sup/root-node! id)] (om/factory RootNode)))

(defn nav-root [id] (id @roots))

(defn add-root! [root id]
  ;; TODO check for duplicate, throw on error!
;;  (swap! roots assoc id root)
;;  (println "add-root! Calling om/add-root! RECONCILER: " (get-reconciler))
  (om/add-root! (get-reconciler) root id))

(defn remove-root! [id]
  ;; ...
  )


(defn sight [id] (id @sights))

(defn add-sight! [id sight]
  (swap! sights assoc id sight))

(defn remove-sight! [id]
  ;; ...
  )
