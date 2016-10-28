(ns ex-compass.shared.compass
  (:require-macros [natal-shell.components :refer [view text]])
  (:require [om.next :as om :refer-macros [defui]]
            [compassus.core :as compassus]
            [ex-compass.shared.react.helpers :refer [stack-nav]]))


(defui Compass
  Object
  (initLocalState [this]
                  (let [props (om/props this)
                        {:keys [:config]} props]
                    {:id (:id config)
                     :index-route (:index-route config)}))

  (render [this]
          (let [state (om/get-state this)
                id (:id state)
                index-route (:index-route state)
                factory (om/factory index-route {:keyfn :key})
                index-thunk ((fn [] (fn [] (factory {:key id}))))]
            (stack-nav {:key (str key "-nav") :navigatorUID key :initialRoute index-thunk}))))

(def compass (om/factory Compass {:keyfn :key}))
