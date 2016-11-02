(ns ex-compass.android.core
  (:require [om.next :as om :refer-macros [defui]]
            [ex-compass.shared.react.helpers :refer [app-registry]]
            [ex-compass.shared.nav.core :as nav]
            [ex-compass.shared.nav.root :as root]
            [ex-compass.shared.nav.nav-compass :refer [set-route!]]))

(defui AppRoot
  static om/IQuery
  (query [_] `[:app/ios {:nav/root ~(om/query root/NavRoot)}])

  Object
  (render [this] (root/nav-root {:key "nav/root"})))

(defn init []
  (nav/add-root! AppRoot 1)
  (let [app-root (nav/app-root 1)]
    (.registerComponent app-registry "Ex-Compass" (fn [] app-root))
    (set-route! :app/ios)))
