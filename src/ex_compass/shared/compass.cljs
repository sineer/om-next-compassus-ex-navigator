(ns ex-compass.shared.compass
  (:require-macros [natal-shell.components :refer [view text]])
  (:require [om.next :as om :refer-macros [defui]]
            [compassus.core :as compassus]
            [ex-compass.shared.react.helpers :refer [stack-nav]]))


(defui Compass
  Object
  (initLocalState [this]
                  (let [props (om/props this)
                        {:keys [:routes]} props]
                    {:routes routes}))

  (render [this]
          (let [routes (:routes (om/get-state this))]
            (stack-nav {:key (str key "-nav") :navigatorUID key :initialRoute (:initialRoute routes)}))))

(def compass (om/factory Compass {:keyfn :key}))
