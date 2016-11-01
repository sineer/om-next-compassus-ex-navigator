(ns ex-compass.shared.nav.sight
  (:require-macros [natal-shell.components :refer [view text]])
  (:require [om.next :as om :refer-macros [defui]]
            [ex-compass.shared.react.helpers :refer [stack-nav]]))


(defui Sight
  Object
  (initLocalState [this]
                  (let [props (om/props this)
                        {:keys [:config]} props
                        routes (:routes config)
                        index-route (:index-route config)]
                    {:id (:id config)
                     :routes (:routes config)
                     :compass (:compass config)
                     :index-route index-route}))

  (render [this]
          (let [state (om/get-state this)
                id (:id state)
                index-route (:index-route state)
                factory (om/factory index-route {:keyfn :key})
                index-thunk ((fn [] (fn [] (factory {:key id}))))]
            (stack-nav {:key (str id "-nav") :navigatorUID id :initialRoute index-thunk}))))

(def sight (om/factory Sight {:keyfn :id}))
